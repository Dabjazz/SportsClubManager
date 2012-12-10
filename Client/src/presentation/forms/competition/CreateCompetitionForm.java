/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.competition;

import com.ServiceNotAvailableException;
import com.contract.IUseCaseControllerFactory;
import contract.dto.*;
import contract.dto.classes.AddressDto;
import contract.dto.classes.CompetitionDto;
import contract.dto.classes.CountryDto;
import contract.dto.classes.MatchDto;
import contract.useCaseController.INewCompetitionController;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;

/**
 * @author Lucia
 */
public class CreateCompetitionForm
        extends AbstractMainForm {

    IUseCaseControllerFactory client;
    INewCompetitionController controller;
    ICompetitionDto competition;
    List<IMatchDto> matches;
    IMemberDto user;
    List<ITeamDto> selectedTeams;
    List<ITeamDto> aTeam;
    List<ITeamDto> bTeam;
    boolean confirmed = false;
    boolean lastWasA = false;
    Object tmpTeam = null;

    /**
     * Creates new form NewMatch
     */
    public CreateCompetitionForm(AbstractForm parent, IUseCaseControllerFactory client, IMemberDto user)
            throws ServiceNotAvailableException {
        super(parent);
        this.client = client;
        this.user = user;
        controller = this.client.getNewCompetitionController();
        initComponents();

        String[] neededRoles = {"DepartmentHeadDto", "Admin"};
        if (!hasRole(neededRoles)) {
            this.getPanel().removeAll();
            JOptionPane.showMessageDialog(null, "Sorry, you do not have the permission to enter this area!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        paneData = new javax.swing.JPanel();
        lblTeams = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSelectTeams = new javax.swing.JList();
        lblSport = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        txtfieldLocation = new javax.swing.JTextField();
        txtfieldName = new javax.swing.JTextField();
        dateDateFrom = new com.toedter.calendar.JDateChooser();
        txtfieldplz = new javax.swing.JTextField();
        txtfieldcity = new javax.swing.JTextField();
        txtfieldCountry = new javax.swing.JTextField();
        lblFee = new javax.swing.JLabel();
        txtfieldFee = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        dateDateTo = new com.toedter.calendar.JDateChooser();
        comboSport = new javax.swing.JComboBox();
        paneSetMatches = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSelectMatch = new javax.swing.JList();
        txtfieldTeamA = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        txtfieldTeamB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTeamA = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        listTeamB = new javax.swing.JList();
        lbl2 = new javax.swing.JLabel();
        btnAddMatch = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(845, 549));

        paneData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Competition Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        paneData.setMaximumSize(new java.awt.Dimension(794, 279));
        paneData.setMinimumSize(new java.awt.Dimension(794, 279));
        paneData.setPreferredSize(new java.awt.Dimension(794, 279));

        lblTeams.setText("Select Teams");

        listSelectTeams.setModel(new javax.swing.AbstractListModel() {
            Object[] teams = new Object[]{};
            public int getSize() { return teams.length; }
            public Object getElementAt(int i) { return teams[i]; }
        });
        listSelectTeams.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setPreferredSize(new java.awt.Dimension(40, 80));
        listSelectTeams.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSelectTeamsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSelectTeams);

        lblSport.setText("Sport");

        lblName.setText("Title");

        lblDate.setText("From");

        lblTime.setText("To");

        lblLocation.setText("Location");

        lblCity.setText("City");

        lblCountry.setText("Country");

        lblPostCode.setText("Post Code");

        lblFee.setText("Fee");

        btnConfirm.setText("Confirm Data");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        comboSport.setModel(new javax.swing.DefaultComboBoxModel(getSportsList()));
        comboSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneDataLayout = new javax.swing.GroupLayout(paneData);
        paneData.setLayout(paneDataLayout);
        paneDataLayout.setHorizontalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTeams)
                    .addComponent(lblSport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(comboSport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(47, 47, 47)
                        .addComponent(txtfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLocation)
                            .addComponent(lblDate)
                            .addComponent(lblPostCode)
                            .addComponent(lblCountry)
                            .addComponent(lblFee))
                        .addGap(18, 18, 18)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfieldcity))
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addComponent(dateDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lblTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldLocation)
                            .addComponent(txtfieldCountry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm)
                        .addContainerGap())))
        );
        paneDataLayout.setVerticalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSport)
                            .addComponent(comboSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(lblTeams))
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfieldName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDate)
                                    .addComponent(lblTime)
                                    .addComponent(dateDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLocation)
                                    .addComponent(txtfieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCity)
                                    .addComponent(txtfieldcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPostCode)
                                    .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCountry)
                                    .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConfirm))
                                .addGap(1, 1, 1))
                            .addComponent(lblFee))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneSetMatches.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Matches", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        paneSetMatches.setMaximumSize(new java.awt.Dimension(712, 214));
        paneSetMatches.setMinimumSize(new java.awt.Dimension(712, 214));
        paneSetMatches.setPreferredSize(new java.awt.Dimension(712, 214));

        listSelectMatch.setModel(new javax.swing.AbstractListModel() {
            Object[] objects = { "" };
            public int getSize() { return objects.length; }
            public Object getElementAt(int i) { return objects[i]; }
        });
        listSelectMatch.setEnabled(false);
        listSelectMatch.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setPreferredSize(new java.awt.Dimension(40, 80));
        listSelectMatch.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSelectMatchValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listSelectMatch);

        txtfieldTeamA.setEnabled(false);

        lbl1.setText("vs.");

        txtfieldTeamB.setEnabled(false);

        setListTeamAModel();
        listTeamA.setEnabled(false);
        listTeamA.setMaximumSize(new java.awt.Dimension(40, 80));
        listTeamA.setMinimumSize(new java.awt.Dimension(40, 80));
        listTeamA.setPreferredSize(new java.awt.Dimension(40, 80));
        jScrollPane2.setViewportView(listTeamA);

        setListTeamBModel();
        listTeamB.setEnabled(false);
        listTeamB.setMaximumSize(new java.awt.Dimension(40, 80));
        listTeamB.setMinimumSize(new java.awt.Dimension(40, 80));
        listTeamB.setPreferredSize(new java.awt.Dimension(40, 80));
        jScrollPane4.setViewportView(listTeamB);

        lbl2.setText("vs.");

        btnAddMatch.setText("Add Match");
        btnAddMatch.setEnabled(false);
        btnAddMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneSetMatchesLayout = new javax.swing.GroupLayout(paneSetMatches);
        paneSetMatches.setLayout(paneSetMatchesLayout);
        paneSetMatchesLayout.setHorizontalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lbl1))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddMatch)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        paneSetMatchesLayout.setVerticalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(paneSetMatchesLayout.createSequentialGroup()
                            .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAddMatch))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane2))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbl2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnCreate.setText("Create Competition");
        btnCreate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreate)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneSetMatches, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paneData, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(paneData, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneSetMatches, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPanel() {
        return panel;
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        if (confirmed) {
            List<Integer> matchesInt = new LinkedList<>();
            for (IMatchDto m : matches) {
                matchesInt.add(m.getId());
            }
            competition.setMatchList(matchesInt);
            controller.setCompetition(competition, user);
        } else {
            JOptionPane.showMessageDialog(null, "Please confirm the competition details first!");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void listSelectTeamsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSelectTeamsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listSelectTeamsValueChanged

    private void listSelectMatchValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSelectMatchValueChanged
        tmpTeam = listSelectMatch.getSelectedValue();

        if (lastWasA == false && txtfieldTeamA.getText().isEmpty()) {
            txtfieldTeamA.setText(listSelectMatch.getSelectedValue().toString());
            lastWasA = true;
        } else if (!tmpTeam.equals(txtfieldTeamA.getText()) || !txtfieldTeamB.getText().isEmpty()) {
            txtfieldTeamB.setText(listSelectMatch.getSelectedValue().toString());
            lastWasA = false;
        }
    }//GEN-LAST:event_listSelectMatchValueChanged

    private void btnAddMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMatchActionPerformed
        addToATeams(txtfieldTeamA.getText());
        addToBTeams(txtfieldTeamB.getText());
        updateMatchTables();
        txtfieldTeamA.setText("");
        txtfieldTeamB.setText("");
    }//GEN-LAST:event_btnAddMatchActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        competition = new CompetitionDto();
        competition.setName(txtfieldName.getText());
        competition.setDescription(txtfieldLocation.getText());
        competition.setDateFrom(dateDateFrom.getDate());
        competition.setDateTo(dateDateTo.getDate());
        competition.setPayment(Double.parseDouble(txtfieldFee.getText()));
        competition.setTeamList(getSelectedTeamsID());
        ITypeOfSportDto sport = (ITypeOfSportDto)comboSport.getSelectedItem();
        competition.setSport(sport.getId());

        //Set Competitions address
        IAddressDto address = new AddressDto();
        address.setVillage(txtfieldcity.getText());
        address.setPostalCode(Integer.parseInt(txtfieldplz.getText()));
        ICountryDto country = new CountryDto();
        country.setName(txtfieldCountry.getText());
        address.setCountry(country.getId());
        competition.setAddress(address.getId());

        setMatchTeamList();
        confirmed = true;
        btnAddMatch.setEnabled(true);
        listSelectMatch.setEnabled(true);
        matches = new LinkedList<>();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void comboSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSportActionPerformed
        setListSelectTeams((ITypeOfSportDto)comboSport.getSelectedItem());
    }//GEN-LAST:event_comboSportActionPerformed

    //TODO add controller method
    private Object[] getSportsList() {
        List<ITypeOfSportDto> sportList = controller.getTypeOfSports(user.getId());
       
        Object[] array = sportList.toArray();
        setListSelectTeams((ITypeOfSportDto)array[0]);
        
        return array;
    }

    private void setListSelectTeams(final ITypeOfSportDto sport) {
        listSelectTeams.setModel(new javax.swing.AbstractListModel() {
            Object[] teams = getTeamsList(sport);

            public int getSize() {
                return teams.length;
            }

            public Object getElementAt(int i) {
                return teams[i];
            }
        });
                
    }

    private Object[] getTeamsList(ITypeOfSportDto sport) {
        List<ITeamDto> teamList = controller.getTeams(sport);
        return teamList.toArray();
    }

    private void setMatchTeamList() {
        if (selectedTeams.isEmpty()) {
            selectedTeams = getSelectedTeams();
        }

        listSelectMatch.setModel(new AbstractListModel() {
            Object[] objects = selectedTeams.toArray();

            @Override
            public int getSize() {
                return objects.length;
            }

            @Override
            public Object getElementAt(int i) {
                return objects[i];
            }
        });
    }

    public List<ITeamDto> getSelectedTeams() {
        Object[] selection = listSelectTeams.getSelectedValues();       //array with selected values
        selectedTeams = new LinkedList<>();                             //selected teams

        //add selected values to the selection teamlist
        for (int i = 0; i < selection.length; i++) {
            selectedTeams.add((ITeamDto) selection[i]);
        }
        return selectedTeams;
    }

    private List<Integer> getSelectedTeamsID() {
        selectedTeams = getSelectedTeams();

        List<Integer> selectedTeamsID = new LinkedList<>();
        for (ITeamDto t : selectedTeams) {
            selectedTeamsID.add(t.getId());
        }

        return selectedTeamsID;
    }

    private void updateMatchTables() {
        IMatchDto newMatch = new MatchDto();
        newMatch.setCompetition(competition.getId());
        newMatch.setHometeam(getTeamID(txtfieldTeamA.getText()));
        newMatch.setForeignteam(getTeamID(txtfieldTeamB.getText()));
        matches.add(newMatch);

        setListTeamAModel();
        setListTeamBModel();
    }

    private Integer getTeamID(String teamName) {
        Integer teamID = null;

        for (ITeamDto t : selectedTeams) {
            if (t.getName().equals(teamName)) {
                teamID = t.getId();
            }
        }
        return teamID;
    }

    private void addToATeams(String teamName) {
        if (aTeam == null) {
            aTeam = new LinkedList<>();
        }

        for (ITeamDto t : selectedTeams) {
            if (t.getName().equals(teamName)) {
                aTeam.add(t);
                return;
            }
        }
    }

    private void addToBTeams(String teamName) {
        if (bTeam == null) {
            bTeam = new LinkedList<>();
        }

        for (ITeamDto t : selectedTeams) {
            if (t.getName().equals(teamName)) {
                bTeam.add(t);
                return;
            }
        }
    }

    private Object[] getATeams() {
        if (aTeam == null) {
            aTeam = new LinkedList<>();
        }
        return aTeam.toArray();
    }

    private Object[] getBTeams() {
        if (bTeam == null) {
            bTeam = new LinkedList<>();
        }
        return bTeam.toArray();
    }

    private void setListTeamAModel() {
        listTeamA.setModel(new AbstractListModel() {
            Object[] objects = getATeams();

            @Override
            public int getSize() {
                return objects.length;
            }

            @Override
            public Object getElementAt(int i) {
                return objects[i];
            }
        });

    }

    private void setListTeamBModel() {
        listTeamB.setModel(new AbstractListModel() {
            Object[] objects = getBTeams();

            @Override
            public int getSize() {
                return objects.length;
            }

            @Override
            public Object getElementAt(int i) {
                return objects[i];
            }
        });
    }

    private boolean hasRole(String[] roleNames) {
        List<IRoleDto> roleList = controller.getRoles(user.getId());

        for (IRoleDto r : roleList) {
            for (int i = 0; i < roleNames.length; i++) {
                if (r.getName().equals(roleNames[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMatch;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox comboSport;
    private com.toedter.calendar.JDateChooser dateDateFrom;
    private com.toedter.calendar.JDateChooser dateDateTo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFee;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblSport;
    private javax.swing.JLabel lblTeams;
    private javax.swing.JLabel lblTime;
    private javax.swing.JList listSelectMatch;
    private javax.swing.JList listSelectTeams;
    private javax.swing.JList listTeamA;
    private javax.swing.JList listTeamB;
    private javax.swing.JPanel paneData;
    private javax.swing.JPanel paneSetMatches;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtfieldCountry;
    private javax.swing.JTextField txtfieldFee;
    private javax.swing.JTextField txtfieldLocation;
    private javax.swing.JTextField txtfieldName;
    private javax.swing.JTextField txtfieldTeamA;
    private javax.swing.JTextField txtfieldTeamB;
    private javax.swing.JTextField txtfieldcity;
    private javax.swing.JTextField txtfieldplz;
    // End of variables declaration//GEN-END:variables
}