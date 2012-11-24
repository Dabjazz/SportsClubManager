package presentation.forms.member;

import com.ServiceClient;
import contract.dto.IMemberDto;
import javax.swing.JPanel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class AddToATeamForm extends AbstractMainForm {
    
    ServiceClient client;
    IMemberDto user;
//    IAddToTeam controller;

    /**
     * Creates new form AddMemberToTeam
     */
    public AddToATeamForm(AbstractForm form, ServiceClient client, IMemberDto user) {
        super(form);
        this.client = client;
        this.user = user;
        //controller = client.getAddToTeamService();
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        thePanel = new javax.swing.JPanel();
        comboTeam = new javax.swing.JComboBox();
        checkBoxPlayer = new javax.swing.JCheckBox();
        checkBoxTrainer = new javax.swing.JCheckBox();
        lblAvailable = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblTrainer = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailable = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPlayer = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listTrainer = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(848, 546));

        comboTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team 1", "Team 2", "Team 3", "Team 4" }));
        comboTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeamActionPerformed(evt);
            }
        });

        checkBoxPlayer.setText("Show Players");
        checkBoxPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPlayerActionPerformed(evt);
            }
        });

        checkBoxTrainer.setText("Show Trainers");
        checkBoxTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxTrainerActionPerformed(evt);
            }
        });

        lblAvailable.setText("Available Members");

        lblPlayer.setText("Team Player(s)");

        lblTrainer.setText("Team Trainer(s)");

        btnAdd.setText("Add >");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("< Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        listAvailable.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listAvailable.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAvailableValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listAvailable);

        listPlayer.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listPlayer.setEnabled(false);
        listPlayer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPlayerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listPlayer);

        listTrainer.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listTrainer.setEnabled(false);
        listTrainer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTrainerValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listTrainer);

        javax.swing.GroupLayout thePanelLayout = new javax.swing.GroupLayout(thePanel);
        thePanel.setLayout(thePanelLayout);
        thePanelLayout.setHorizontalGroup(
            thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(thePanelLayout.createSequentialGroup()
                                .addComponent(checkBoxTrainer)
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxPlayer))
                            .addComponent(lblAvailable)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayer))
                        .addGap(42, 42, 42)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrainer))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        thePanelLayout.setVerticalGroup(
            thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxTrainer)
                    .addComponent(checkBoxPlayer))
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblTrainer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAvailable)
                            .addComponent(lblPlayer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTeamActionPerformed

    private void checkBoxTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxTrainerActionPerformed

    private void checkBoxPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxPlayerActionPerformed

    private void listAvailableValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAvailableValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listAvailableValueChanged

    private void listPlayerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPlayerValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listPlayerValueChanged

    private void listTrainerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTrainerValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listTrainerValueChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAddActionPerformed

    public JPanel getPanel(){
        return thePanel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JCheckBox checkBoxPlayer;
    private javax.swing.JCheckBox checkBoxTrainer;
    private javax.swing.JComboBox comboTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAvailable;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblTrainer;
    private javax.swing.JList listAvailable;
    private javax.swing.JList listPlayer;
    private javax.swing.JList listTrainer;
    private javax.swing.JPanel thePanel;
    // End of variables declaration//GEN-END:variables
}