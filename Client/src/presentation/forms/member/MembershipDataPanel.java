/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.member;

import contract.dto.*;
import contract.dto.classes.*;
import contract.useCaseController.IMembershipController;
import contract.useCaseController.NetworkFailureException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.forms.helper.SelectTeamsHelper;

/**
 *
 * @author Thomas
 */
public class MembershipDataPanel
        extends javax.swing.JPanel {

    private IMemberDto member;
    private List<ITypeOfSportDto> selectedSports = new LinkedList<>();
    private List<IClubTeamDto> selectedTrainerTeams;
    private List<IClubTeamDto> selectedPlayerTeams;
    private IMembershipController controller;

    public IMembershipController getController() {
        return controller;
    }

    public void setController(IMembershipController controller) {
        this.controller = controller;
    }

    public IMemberDto getMember() {
        try {
            List<IRoleDto> roles = new LinkedList<>();

            controller.setRole(member, "Admin", radioAdmin.isSelected());
            controller.setRole(member, "Caretaker", radioCaretaker.isSelected());
            controller.setRole(member, "DepartmentHead", radioDepHead.isSelected());
            ITrainerDto trainer = (ITrainerDto) controller.setRole(member, "Trainer", radioTrainer.isSelected());
            IPlayerDto player = (IPlayerDto) controller.setRole(member, "Player", radioPlayer.isSelected());

            trainer.setTypeOfSportList(getSelectedSports());
            trainer.setClubTeamList(getSelectedTeamIds(selectedTrainerTeams));

            player.setTypeOfSportList(getSelectedSports());
            player.setClubTeamList(getSelectedTeamIds(selectedPlayerTeams));

            member.setMemberFrom(dateEntry.getDate());

        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return member;
    }

    public void setMember(IMemberDto member) {
        try {
            for (IRoleDto role : controller.getRoles(member.getId())) {
                if (role instanceof IAdminDto) {
                    radioAdmin.setSelected(true);
                    disableExtendedRadioSelection();
                } else if (role instanceof ICaretakerDto) {
                    radioCaretaker.setSelected(true);
                } else if (role instanceof IDepartmentHeadDto) {
                    radioDepHead.setSelected(true);
                } else if (role instanceof ITrainerDto) {
                    radioTrainer.setSelected(true);
                    setSelectedSports(role);
                } else if (role instanceof IPlayerDto) {
                    radioPlayer.setSelected(true);
                    setSelectedSports(role);
                }
            }
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtfieldMemberNr.setText(member.getId() + "");
        dateEntry.setDate(member.getMemberFrom());

        updateSelectedClubTeamList(member);
        updateSelectedTypeOfSportList(member);

        setTrainerClubTeams(selectedTrainerTeams);
        setPlayerClubTeams(selectedPlayerTeams);
        this.member = member;
    }

    private void updateSelectedClubTeamList(IMemberDto selectedMember) {
        try {
            List<Integer> trainerList = new LinkedList<>();
            List<Integer> playerList = new LinkedList<>();

            for (IRoleDto role : controller.getRoles(selectedMember.getId())) {
                if (role instanceof ITrainerDto) {
                    for (Integer t : ((ITrainerDto) role).getClubTeamList()) {
                        trainerList.add(t);
                    }
                } else if (role instanceof IPlayerDto) {
                    for (Integer t : ((IPlayerDto) role).getClubTeamList()) {
                        playerList.add(t);
                    }
                }
            }

            selectedTrainerTeams = controller.getClubTeams(trainerList);
            selectedPlayerTeams = controller.getClubTeams(playerList);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateSelectedTypeOfSportList(IMemberDto selectedMember) {
        try {
            List<Integer> sports = new LinkedList<>();

            for (IRoleDto role : controller.getRoles(selectedMember.getId())) {
                if (role instanceof ITrainerDto) {
                    for (Integer t : ((ITrainerDto) role).getTypeOfSportList()) {
                        if (sports.contains(t)) {
                            continue;
                        }
                        sports.add(t);
                    }
                } else if (role instanceof IPlayerDto) {
                    for (Integer t : ((IPlayerDto) role).getTypeOfSportList()) {
                        if (!sports.contains(t)) {
                            sports.add(t);
                        }
                    }
                }
            }

            StringBuilder builder = new StringBuilder();

            for (ITypeOfSportDto t : controller.getTypeOfSports(sports)) {
                builder.append(t);
                builder.append(", ");
            }

            txtFieldSports.setText(builder.toString().substring(0, builder.length() - 2));
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setSelectedSports(IRoleDto role) {
        try {
            List<Integer> typeOfSportsID = null;

            if (role instanceof ITrainerDto) {
                ITrainerDto tmp = (ITrainerDto) role;
                typeOfSportsID = tmp.getTypeOfSportList();
            } else {
                IPlayerDto tmp = (IPlayerDto) role;
                typeOfSportsID = tmp.getTypeOfSportList();
            }

            //add members sports to his/her selectedSportsList
            for (ITypeOfSportDto tos : controller.getAllSports()) {
                for (Integer i : typeOfSportsID) {
                    if ((tos.getId()).equals(i)) {
                        selectedSports.add(tos);
                    }
                }
            }
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Integer> getSelectedSports() {
        List<Integer> tosIDs = new LinkedList<>();
        try {
            for (ITypeOfSportDto tos : controller.getAllSports()) {
                for (ITypeOfSportDto s : selectedSports) {
                    if (s.equals(tos)) {
                        tosIDs.add(tos.getId());
                    }
                }
            }
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipDataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tosIDs;
    }

    private List<Integer> getSelectedTeamIds(List<IClubTeamDto> teams) {
        List<Integer> result = new LinkedList<>();

        for (IClubTeamDto team : teams) {
            result.add(team.getId());
        }

        return result;
    }

    private void disableExtendedRadioSelection() {
        radioAdmin.setEnabled(false);
        radioCaretaker.setEnabled(false);
        radioDepHead.setEnabled(false);
        radioTrainer.setEnabled(false);
    }

    public void setPlayerClubTeams(List<IClubTeamDto> selected) {
        if (selected.isEmpty()) {
            txtFieldPlayerClubTeam.setText("");
            return;
        }

        this.selectedPlayerTeams = selected;

        StringBuilder sb = new StringBuilder(selectedPlayerTeams.size());

        for (IClubTeamDto ct : selectedPlayerTeams) {
            sb.append(ct);
            sb.append(", ");
        }

        txtFieldPlayerClubTeam.setText(sb.toString().substring(0, sb.length() - 2));
    }

    public void setTrainerClubTeams(List<IClubTeamDto> selected) {
        if (selected.isEmpty()) {
            txtFieldTrainerClubTeam.setText("");
            return;
        }

        this.selectedTrainerTeams = selected;

        StringBuilder sb = new StringBuilder(selectedTrainerTeams.size());

        for (IClubTeamDto ct : selectedTrainerTeams) {
            sb.append(ct);
            sb.append(", ");
        }

        txtFieldTrainerClubTeam.setText(sb.toString().substring(0, sb.length() - 2));
    }

    /**
     * Creates new form MembershipDataPanel
     */
    public MembershipDataPanel() {
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

        txtfieldMemberNr = new javax.swing.JTextField();
        btnAddSport = new javax.swing.JButton();
        btnTeams = new javax.swing.JButton();
        btnTeams1 = new javax.swing.JButton();
        txtFieldPlayerClubTeam = new javax.swing.JTextField();
        txtFieldTrainerClubTeam = new javax.swing.JTextField();
        txtFieldSports = new javax.swing.JTextField();
        lblSport = new javax.swing.JLabel();
        lblTeam = new javax.swing.JLabel();
        lblTeam1 = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioCaretaker = new javax.swing.JRadioButton();
        radioDepHead = new javax.swing.JRadioButton();
        radioTrainer = new javax.swing.JRadioButton();
        radioPlayer = new javax.swing.JRadioButton();
        lblMemberNr = new javax.swing.JLabel();
        dateEntry = new com.toedter.calendar.JDateChooser();
        lblEntryDate = new javax.swing.JLabel();

        txtfieldMemberNr.setEnabled(false);

        btnAddSport.setText("Select Sport(s)");
        btnAddSport.setInheritsPopupMenu(true);
        btnAddSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSportActionPerformed(evt);
            }
        });

        btnTeams.setText("Select Team(s)");
        btnTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeamsActionPerformed(evt);
            }
        });

        btnTeams1.setText("Select Team(s)");
        btnTeams1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeams1ActionPerformed(evt);
            }
        });

        txtFieldPlayerClubTeam.setEnabled(false);

        txtFieldTrainerClubTeam.setEnabled(false);

        txtFieldSports.setEnabled(false);

        lblSport.setText("Sport");

        lblTeam.setText("Team als Trainer");

        lblTeam1.setText("Team als Spieler");

        lblRole.setText("Role");

        radioAdmin.setText("Admin");
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdminActionPerformed(evt);
            }
        });

        radioCaretaker.setText("Caretaker");
        radioCaretaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCaretakerActionPerformed(evt);
            }
        });

        radioDepHead.setText("Department Head");
        radioDepHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDepHeadActionPerformed(evt);
            }
        });

        radioTrainer.setText("Trainer");
        radioTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTrainerActionPerformed(evt);
            }
        });

        radioPlayer.setText("Player");
        radioPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPlayerActionPerformed(evt);
            }
        });

        lblMemberNr.setText("Membership Nr.");

        dateEntry.setEnabled(false);

        lblEntryDate.setText("Entry Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(lblEntryDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213)
                .addComponent(lblMemberNr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfieldMemberNr, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTeam)
                .addComponent(lblSport))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtFieldTrainerClubTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addComponent(txtFieldSports))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnTeams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddSport)))
                .addGroup(layout.createSequentialGroup()
                .addComponent(lblRole)
                .addGap(58, 58, 58)
                .addComponent(radioAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioCaretaker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioDepHead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioTrainer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioPlayer))))
                .addGroup(layout.createSequentialGroup()
                .addComponent(lblTeam1)
                .addGap(30, 30, 30)
                .addComponent(txtFieldPlayerClubTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTeams1)))
                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblEntryDate)
                .addComponent(dateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMemberNr)
                .addComponent(txtfieldMemberNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioTrainer)
                .addComponent(radioPlayer)
                .addComponent(radioCaretaker)
                .addComponent(radioDepHead))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblRole)
                .addComponent(radioAdmin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSport)
                .addComponent(txtFieldSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddSport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTeam)
                .addComponent(txtFieldTrainerClubTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnTeams))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTeam1)
                .addComponent(txtFieldPlayerClubTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnTeams1))
                .addGap(31, 31, 31)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddSportActionPerformed
    {//GEN-HEADEREND:event_btnAddSportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddSportActionPerformed

    private void btnTeamsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTeamsActionPerformed
    {//GEN-HEADEREND:event_btnTeamsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTeamsActionPerformed

    private void btnTeams1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTeams1ActionPerformed
    {//GEN-HEADEREND:event_btnTeams1ActionPerformed
        try {
            new SelectTeamsHelper(selectedSports, true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Service currently not available. Sorry!");
        }
    }//GEN-LAST:event_btnTeams1ActionPerformed

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioAdminActionPerformed
    {//GEN-HEADEREND:event_radioAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAdminActionPerformed

    private void radioCaretakerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioCaretakerActionPerformed
    {//GEN-HEADEREND:event_radioCaretakerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCaretakerActionPerformed

    private void radioDepHeadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioDepHeadActionPerformed
    {//GEN-HEADEREND:event_radioDepHeadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDepHeadActionPerformed

    private void radioTrainerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioTrainerActionPerformed
    {//GEN-HEADEREND:event_radioTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioTrainerActionPerformed

    private void radioPlayerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioPlayerActionPerformed
    {//GEN-HEADEREND:event_radioPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPlayerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSport;
    private javax.swing.JButton btnTeams;
    private javax.swing.JButton btnTeams1;
    private com.toedter.calendar.JDateChooser dateEntry;
    private javax.swing.JLabel lblEntryDate;
    private javax.swing.JLabel lblMemberNr;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSport;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JLabel lblTeam1;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioCaretaker;
    private javax.swing.JRadioButton radioDepHead;
    private javax.swing.JRadioButton radioPlayer;
    private javax.swing.JRadioButton radioTrainer;
    private javax.swing.JTextField txtFieldPlayerClubTeam;
    private javax.swing.JTextField txtFieldSports;
    private javax.swing.JTextField txtFieldTrainerClubTeam;
    private javax.swing.JTextField txtfieldMemberNr;
    // End of variables declaration//GEN-END:variables

    List<IClubTeamDto> getPlayerTeams() {
        return selectedPlayerTeams;
    }

    List<IClubTeamDto> getTrainerTeams() {
        return selectedTrainerTeams;
    }
}
