/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import java.util.*;
import java.util.logging.*;
import javamessaging.contract.IMemberDepartmentMessage;
import javamessaging.stubs.*;
import javamessagingclient.controller.AddPlayerToClubTeamController;
import javax.jms.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.table.*;

/**

 @author Thomas
 */
public class MemberSubscriberForm
        extends javax.swing.JFrame
        implements MessageListener, ExceptionListener
{
    private List<IMemberDepartmentMessage> messages = new LinkedList<IMemberDepartmentMessage>();
    private List<IClubTeamDto> clubTeams = new LinkedList<IClubTeamDto>();
    private AddPlayerToClubTeamController controller = new AddPlayerToClubTeamController();
    private IDepartmentHeadDto departmentHeadDto;
    private MemberSubscriberJms subscriberJms;

    public MemberSubscriberForm(IDepartmentHeadDto departmentHead)
    {
        initComponents();

        this.departmentHeadDto = departmentHead;

        TableModel tableModel = clubTeamTable.getModel();

        for (IDepartmentDto d : this.departmentHeadDto.getDepartmentList())
        {
            for (IClubTeamDto c : d.getClubTeamList())
            {
                clubTeams.add(c);
                clubTeamTable.setValueAt(c, tableModel.getRowCount() + 1, 0);
            }
        }
        clubTeamTable.setModel(tableModel);

        playerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int selectedMessageId = playerTable.getSelectedRow();

                jButton1.setEnabled(selectedMessageId != -1);
            }
        });

        subscriberJms = new MemberSubscriberJms(departmentHead);
        subscriberJms.read(this, this);
    }

    /**
     This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        clubTeamTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        playerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Vorname", "Nachname"
            }
        ));
        jScrollPane1.setViewportView(playerTable);
        playerTable.getColumnModel().getColumn(1).setHeaderValue("Nachname");

        clubTeamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Team"
            }
        ));
        jScrollPane2.setViewportView(clubTeamTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jButton1)
                        .addGap(0, 409, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        writeToDatabase(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clubTeamTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable playerTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(Message message)
    {
        try
        {
            ObjectMessage om = (ObjectMessage) message;
            Object o = om.getObject();

            IMemberDepartmentMessage msg = (IMemberDepartmentMessage) o;

            System.out.println("received: " + msg);

            if (!departmentHeadDto.getDepartmentList().contains(msg.getDepartment()))
            {
                return;
            }

            messages.add(msg);

            updatePlayers();
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MemberSubscriberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onException(JMSException exception)
    {
        System.err.println("something bad happended: " + exception);
    }

    private void writeToDatabase(boolean shouldWrite)
    {
        int selectedMessageId = playerTable.getSelectedRow();

        if (selectedMessageId == -1)
        {
            JOptionPane.showMessageDialog(this, "No message selected");
            return;
        }

        if (shouldWrite)
        {
            return;
        }

        int[] clubTeamIds = clubTeamTable.getSelectedRows();

        if (clubTeamIds.length == 0)
        {
            JOptionPane.showMessageDialog(this, "No clubTeam selected");
            return;
        }

        IMemberDepartmentMessage selectedMessage = messages.remove(selectedMessageId);
        updatePlayers();

        for (int clubTeamId : clubTeamIds)
        {
            IClubTeamDto clubTeam = clubTeams.get(clubTeamId);

            controller.addPlayerToClubTeam(clubTeam, selectedMessage.getMember());
        }
    }

    private void updatePlayers()
    {
        TableModel tm = playerTable.getModel();

        DefaultTableModel dm = (DefaultTableModel) playerTable.getModel();
        dm.setRowCount(0);
        dm.setRowCount(messages.size());

        playerTable.setModel(tm);

        TableModel tableModel = playerTable.getModel();

        for (int i = 0; i < messages.size(); i++)
        {
            IMemberDto member = messages.get(i).getMember().getMember();

            tableModel.setValueAt(member.getPrename(), i, 0);
            tableModel.setValueAt(member.getLastname(), i, 1);
        }

        playerTable.setModel(tableModel);
    }
}