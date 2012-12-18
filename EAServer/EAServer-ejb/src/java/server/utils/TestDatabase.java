/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.utils;

import server.domain.DomainFacade;

/**
 *
 * @author mohi
 */
public class TestDatabase extends javax.swing.JFrame
{
    
    public boolean objects = true;
    public boolean queries = true;
    /**
     * Creates new form TestDatabase
     */
    public TestDatabase()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        checkBoxObjects = new javax.swing.JCheckBox();
        checkBoxQueries = new javax.swing.JCheckBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        message = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errormessage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(140, 131));
        setResizable(false);

        jLabel1.setText("Test the Database");

        checkBoxObjects.setSelected(objects);
        checkBoxObjects.setText("Test Objects");
        checkBoxObjects.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkBoxObjectsActionPerformed(evt);
            }
        });

        checkBoxQueries.setSelected(queries);
        checkBoxQueries.setText("Test Queries");
        checkBoxQueries.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkBoxQueriesActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Run");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton1ActionPerformed(evt);
            }
        });

        errormessage.setColumns(20);
        errormessage.setRows(5);
        jScrollPane1.setViewportView(errormessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(checkBoxQueries)
                            .addComponent(jLabel1)
                            .addComponent(checkBoxObjects)
                            .addComponent(jToggleButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxObjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxQueries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxObjectsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkBoxObjectsActionPerformed
    {//GEN-HEADEREND:event_checkBoxObjectsActionPerformed
        objects = checkBoxObjects.isSelected();
    }//GEN-LAST:event_checkBoxObjectsActionPerformed

    private void checkBoxQueriesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkBoxQueriesActionPerformed
    {//GEN-HEADEREND:event_checkBoxQueriesActionPerformed
        queries = checkBoxQueries.isSelected();
    }//GEN-LAST:event_checkBoxQueriesActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton1ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton1ActionPerformed
        message.setText("");
        try{
        HibernateTestDatabase test = new HibernateTestDatabase();
        if(objects)
        {
            test.runGetterTest();
        }
        if(queries)
        {
            test.runQueryTests();
        }
        }catch(Exception ex)
        {
            errormessage.setText(ex.getMessage());
        }
        finally
        {
            message.setText("Done");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                TestDatabase t = new TestDatabase();
                t.setLocationRelativeTo(null);
                t.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxObjects;
    private javax.swing.JCheckBox checkBoxQueries;
    private javax.swing.JTextArea errormessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
