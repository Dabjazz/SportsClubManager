package presentation.forms.helper;

import contract.dto.ITypeOfSportDto;
import java.util.*;
import javax.swing.JPanel;
import presentation.basics.AbstractMainForm;
import presentation.forms.helper.observer.SelectedSportsValue;

/**
 * @author Lucia
 */
public class SelectSportsHelper
        extends AbstractMainForm {

    private List<ITypeOfSportDto> allSports;
    private SelectedSportsValue parent;

    /**
     * Creates new form SelectSports
     */
    public SelectSportsHelper(List<ITypeOfSportDto> allSports, List<ITypeOfSportDto> selSports, SelectedSportsValue parent) {
        this.allSports = allSports;

        this.parent = parent;
        initComponents();

        for (ITypeOfSportDto sport : selSports) {
            listSports.setSelectedValue(sport, rootPaneCheckingEnabled);
        }

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAddSports = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSports = new javax.swing.JList();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Sport(s)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelAddSports.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add more sport(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        listSports.setModel(new javax.swing.AbstractListModel()
            {
                Object[] strings = allSports.toArray();
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
            listSports.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    listSportsValueChanged(evt);
                }
            });
            jScrollPane1.setViewportView(listSports);

            btnAdd.setText("Add Sport(s)");
            btnAdd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAddActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout panelAddSportsLayout = new javax.swing.GroupLayout(panelAddSports);
            panelAddSports.setLayout(panelAddSportsLayout);
            panelAddSportsLayout.setHorizontalGroup(
                panelAddSportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAddSportsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd)
                    .addContainerGap())
            );
            panelAddSportsLayout.setVerticalGroup(
                panelAddSportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddSportsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelAddSportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelAddSportsLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnAdd))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAddSports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAddSports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        List<ITypeOfSportDto> selSports = new LinkedList<>();
        for (Object o : listSports.getSelectedValues()) {
            selSports.add((ITypeOfSportDto) o);
        }

        parent.sportSelected(selSports);

        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void listSportsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSportsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listSportsValueChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listSports;
    private javax.swing.JPanel panelAddSports;
    // End of variables declaration//GEN-END:variables
}
