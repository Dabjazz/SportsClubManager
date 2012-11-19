package presentation.forms.member;

import contract.INewMember;
import dto.classes.Admin;
import dto.classes.Caretaker;
import dto.classes.DepartmentHead;
import dto.classes.Player;
import dto.classes.Trainer;
import dto.contract.IAddress;
import dto.contract.IClubTeam;
import dto.contract.ICountry;
import dto.contract.IDepartment;
import dto.contract.IMember;
import dto.contract.IPlayer;
import dto.contract.IRole;
import dto.contract.ITrainer;
import dto.contract.ITypeOfSport;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;
import presentation.forms.helper.SelectSportsHelper;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**

 @author Lucia
 */
public class NewMemberForm
        extends AbstractMainForm
{
    //Controler and contract
    ServiceClient client;
    INewMember controller;
    IMember member;
    IMember user;
    IRole role;
    IDepartment department;
    IAddress address;
    ICountry country;
    IClubTeam clubTeam;
    private List<ITypeOfSport> typeOfSports;
    private List<ITypeOfSport> availableSports;
    private List<ITypeOfSport> selectedSports;
    private boolean adminPermission = false;

    /**
     Creates new form NewMemb
     */
    public NewMemberForm(AbstractForm form, ServiceClient client, IMember user)
            throws ServiceNotAvailableException
    {
        super(form);
        this.client = client;
        this.user = user;
        //adminPermission = user.hasPermission();
        if(!adminPermission){
            disableExtendedRadioSelection();
        }
        this.selectedSports = new LinkedList<>();
        controller = this.client.getNewMemberService();
        initComponents();
    }

    /**
     This method is called from within the constructor to initialize the form.
     WARNING: Do NOT modify this code. The content of this method is always
     regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneNewMember = new javax.swing.JPanel();
        panePersonData = new javax.swing.JPanel();
        lblFName = new javax.swing.JLabel();
        txtfieldFName = new javax.swing.JTextField();
        lblLName = new javax.swing.JLabel();
        txtfieldLName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtfieldAddress = new javax.swing.JTextField();
        txtfieldPostCode = new javax.swing.JTextField();
        lblPostCode = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        txtfieldCity = new javax.swing.JTextField();
        txtfieldCountry = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        dateChooserBirth = new com.toedter.calendar.JDateChooser();
        lblGender = new javax.swing.JLabel();
        txtfieldPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        radioFemale = new javax.swing.JRadioButton();
        radioMale = new javax.swing.JRadioButton();
        txtfieldMail = new javax.swing.JTextField();
        paneMembershipData = new javax.swing.JPanel();
        lblEntryDate = new javax.swing.JLabel();
        dateChooserEntry = new com.toedter.calendar.JDateChooser();
        lblDepartment = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox();
        lblRole = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioTrainer = new javax.swing.JRadioButton();
        radioPlayer = new javax.swing.JRadioButton();
        lblTeam = new javax.swing.JLabel();
        comboTeam = new javax.swing.JComboBox();
        radioDeptHead = new javax.swing.JRadioButton();
        radioCaretaker = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtFieldSport = new javax.swing.JTextField();
        btnAddSports = new javax.swing.JButton();
        btnSaveMember = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Member");
        setMinimumSize(new java.awt.Dimension(848, 549));

        paneNewMember.setName(""); // NOI18N

        panePersonData.setBorder(javax.swing.BorderFactory.createTitledBorder("Person Data"));

        lblFName.setText("First Name");

        txtfieldFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldFNameActionPerformed(evt);
            }
        });

        lblLName.setText("Last Name");

        lblAddress.setText("Address");

        txtfieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldAddressActionPerformed(evt);
            }
        });

        lblPostCode.setText("Post Code");

        lblCity.setText("City");

        txtfieldCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldCityActionPerformed(evt);
            }
        });

        lblCountry.setText("Country");

        lblMail.setText("Mail");

        lblBirthDate.setText("Birth Date");

        lblGender.setText("Gender");

        lblPhone.setText("Phone");

        radioFemale.setText("female");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        radioMale.setText("male");

        javax.swing.GroupLayout panePersonDataLayout = new javax.swing.GroupLayout(panePersonData);
        panePersonData.setLayout(panePersonDataLayout);
        panePersonDataLayout.setHorizontalGroup(
            panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFName)
                    .addComponent(lblAddress)
                    .addComponent(lblCity)
                    .addComponent(lblBirthDate)
                    .addComponent(lblPhone))
                .addGap(26, 26, 26)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtfieldCity)
                        .addComponent(txtfieldFName)
                        .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtfieldPhone)
                        .addGroup(panePersonDataLayout.createSequentialGroup()
                            .addComponent(dateChooserBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panePersonDataLayout.createSequentialGroup()
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMail)
                            .addComponent(lblCountry)
                            .addComponent(lblGender))
                        .addGap(10, 10, 10))
                    .addComponent(lblLName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPostCode, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addComponent(radioFemale)
                        .addGap(18, 18, 18)
                        .addComponent(radioMale)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldCountry)
                            .addComponent(txtfieldPostCode)
                            .addComponent(txtfieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(191, 191, 191))
        );
        panePersonDataLayout.setVerticalGroup(
            panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addComponent(txtfieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtfieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLName)
                            .addComponent(txtfieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPostCode)
                            .addComponent(txtfieldPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountry)
                            .addComponent(lblCity))
                        .addGap(30, 30, 30)
                        .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panePersonDataLayout.createSequentialGroup()
                                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMail)
                                    .addComponent(txtfieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioFemale)
                                    .addComponent(radioMale)
                                    .addComponent(lblGender)))
                            .addGroup(panePersonDataLayout.createSequentialGroup()
                                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBirthDate)
                                    .addGroup(panePersonDataLayout.createSequentialGroup()
                                        .addComponent(lblPhone)
                                        .addGap(29, 29, 29))
                                    .addComponent(dateChooserBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        paneMembershipData.setBorder(javax.swing.BorderFactory.createTitledBorder("Membership Data"));

        lblEntryDate.setText("Entry Date");

        lblDepartment.setText("Department");

        comboDepartment.setModel(new javax.swing.DefaultComboBoxModel(getComboDepartment()));
        comboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepartmentActionPerformed(evt);
            }
        });

        lblRole.setText("Role");

        radioAdmin.setText("Admin");
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdminActionPerformed(evt);
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

        lblTeam.setText("Team");

        comboTeam.setModel(new javax.swing.DefaultComboBoxModel(getComboTeam()));
        comboTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeamActionPerformed(evt);
            }
        });

        radioDeptHead.setText("Department Head");
        radioDeptHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDeptHeadActionPerformed(evt);
            }
        });

        radioCaretaker.setText("Caretaker");
        radioCaretaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCaretakerActionPerformed(evt);
            }
        });

        jLabel1.setText("Sport(s)");

        txtFieldSport.setEnabled(false);

        btnAddSports.setText("Add Sport(s)");
        btnAddSports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneMembershipDataLayout = new javax.swing.GroupLayout(paneMembershipData);
        paneMembershipData.setLayout(paneMembershipDataLayout);
        paneMembershipDataLayout.setHorizontalGroup(
            paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepartment)
                    .addComponent(lblEntryDate)
                    .addComponent(lblTeam)
                    .addComponent(lblRole)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMembershipDataLayout.createSequentialGroup()
                        .addComponent(radioAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioCaretaker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioDeptHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTrainer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioPlayer))
                    .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateChooserEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboDepartment, 0, 200, Short.MAX_VALUE))
                    .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneMembershipDataLayout.createSequentialGroup()
                        .addComponent(txtFieldSport, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddSports)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneMembershipDataLayout.setVerticalGroup(
            paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEntryDate)
                    .addComponent(dateChooserEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartment)
                    .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(radioAdmin)
                    .addComponent(radioTrainer)
                    .addComponent(radioPlayer)
                    .addComponent(radioDeptHead)
                    .addComponent(radioCaretaker))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSports))
                .addGap(7, 7, 7)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeam))
                .addGap(71, 71, 71))
        );

        btnSaveMember.setText("Save Member");
        btnSaveMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneNewMemberLayout = new javax.swing.GroupLayout(paneNewMember);
        paneNewMember.setLayout(paneNewMemberLayout);
        paneNewMemberLayout.setHorizontalGroup(
            paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panePersonData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneMembershipData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneNewMemberLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveMember)))
                .addContainerGap())
        );
        paneNewMemberLayout.setVerticalGroup(
            paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panePersonData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMembershipData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveMember)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneNewMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneNewMember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldFNameActionPerformed

    private void txtfieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldAddressActionPerformed

    private void txtfieldCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldCityActionPerformed

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFemaleActionPerformed

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAdminActionPerformed

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTeamActionPerformed
        setSelectedTeam();
    }//GEN-LAST:event_comboTeamActionPerformed

    private void radioDeptHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDeptHeadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDeptHeadActionPerformed

    private void comboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepartmentActionPerformed
        //get teams from department and set selectable teams for combobox
        setSelectedDepartment();
        setAvailableSports(department.getTypeOfSportList());
        comboTeam.setModel(new DefaultComboBoxModel(getComboTeam()));
    }//GEN-LAST:event_comboDepartmentActionPerformed

    private void btnSaveMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMemberActionPerformed
        if (validInput())
        {
            setMemberData();
            //TODO add some success message                    
        }
        else
        {
            JOptionPane.showMessageDialog(parent, "Please fill in all text fields!");
        }
    }//GEN-LAST:event_btnSaveMemberActionPerformed

    private void radioCaretakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCaretakerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCaretakerActionPerformed

    private void radioTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioTrainerActionPerformed

    private void radioPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPlayerActionPerformed

    private void btnAddSportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSportsActionPerformed
        SelectSportsHelper selectSportsHelper = new SelectSportsHelper(availableSports, new LinkedList<ITypeOfSport>(), this);
    }//GEN-LAST:event_btnAddSportsActionPerformed

    private String[] getComboDepartment()
    {
        List<IDepartment> depList = controller.getDepartments();
        String[] depArray = new String[depList.size()];

        for (int i = 0; i < depList.size(); i++)
        {
            depArray[i] = depList.get(i).getName();
        }

        return depArray;
    }

    private void setSelectedDepartment()
    {
        String selName = comboDepartment.getSelectedItem().toString();
        List<IDepartment> depList = controller.getDepartments();

        for (IDepartment d : depList)
        {
            if (d.getName().equals(selName))
            {
                department = d;
            }
        }
    }

    private List<Integer> getSelectedSports()
    {
        List<Integer> tosIDs = new LinkedList<>();

        for (ITypeOfSport tos : typeOfSports)
        {
            for (ITypeOfSport s : selectedSports)
            {
                if (s.equals(tos))
                {
                    tosIDs.add(tos.getId());
                }
            }
        }
        return tosIDs;
    }
    
    private String[] getComboTeam()
    {
        if (department != null)
        {
            List<Integer> cTeamInt = department.getClubTeamList();
            List<IClubTeam> cTeamList = controller.getClubTeams(cTeamInt);
            Iterator<IClubTeam> cTeamIterator = cTeamList.iterator();
            String[] cTeamArray = new String[cTeamList.size()];

            for (int i = 0; cTeamIterator.hasNext(); i++)
            {
                cTeamArray[i] = cTeamIterator.next().getName();
            }
            return cTeamArray;
        }
        else
        {
            return new String[]
                    {
                        "Team"
                    };
        }
    }

    private void setSelectedTeam()
    {
        String selName = comboTeam.getSelectedItem().toString();
        List<Integer> cTeamInt = department.getClubTeamList();
        List<IClubTeam> cTeamList = controller.getClubTeams(cTeamInt);

        for (IClubTeam t : cTeamList)
        {
            if (t.getName().equals(selName))
            {
                clubTeam = t;
            }
        }
    }

    private void setAvailableSports(List<Integer> typeOfSportList)
    {
        typeOfSports = controller.getTypeOfSports(typeOfSportList);
        availableSports = new LinkedList<>();

        for (ITypeOfSport s : typeOfSports)
        {
            availableSports.add(s);
        }
    }

    @Override
    public void setTxtFieldSports(List<ITypeOfSport> selection)
    {
        this.selectedSports = selection;

        StringBuilder sb = new StringBuilder(selectedSports.size());
        for (ITypeOfSport s : selectedSports)
        {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());    //TODO check if this works 

        txtFieldSport.setText(sb.toString());
    }

    private void setMemberData()
    {
        member.setPrename(txtfieldFName.getText());
        member.setLastname(txtfieldLName.getText());
        member.setDateOfBirth(dateChooserBirth.getDate());
        member.setMemberFrom(dateChooserEntry.getDate());
        member.setTelephonenumber(txtfieldPhone.getText());
        member.setEmailAddress(txtfieldMail.getText());

        address.setStreet(txtfieldAddress.getText());
        address.setPostalCode(Integer.parseInt(txtfieldPostCode.getText()));
        address.setVillage(txtfieldCity.getText());
        // member.setAddress(address.getId());


        country.setName(txtfieldCountry.getText());
        member.setNationality(country.getId());

        if (radioFemale.isSelected())
        {
            member.setGender(true);
        }
        else
        {
            member.setGender(false);
        }


        //TODO: which case only member and address necessary?!
        //role list necessary?
        List<IRole> membersRoles = new LinkedList<>();
        
        if (adminPermission)
        {
            if (radioAdmin.isSelected())
            {
                membersRoles.add(new Admin());
            }
            if (radioCaretaker.isSelected())
            {
                membersRoles.add(new Caretaker());
            }
            if (radioDeptHead.isSelected())
            {
                membersRoles.add(new DepartmentHead());
            }
            if (radioTrainer.isSelected())
            {
                ITrainer trainer = new Trainer();
                membersRoles.add(trainer);
                trainer.setTypeOfSportList(getSelectedSports());
            }
        }

        if (radioPlayer.isSelected())
        {
            IPlayer player = new Player();
            membersRoles.add(player);
            player.setTypeOfSportList(getSelectedSports());
        }

        List<Integer> roleInt = new LinkedList<>();
        for (IRole role : membersRoles)
        {
            roleInt.add(role.getId());
        }
        
        member.setRoleList(roleInt);
        

        if (radioTrainer.isSelected() || radioPlayer.isSelected())
        {
            member.setRoleList(roleInt);            
            setSelectedDepartment();
            setSelectedTeam();

            controller.setNewMember(member, address, department, clubTeam, role);
        }
        else
        {            
            controller.setNewMember(member, address);
        }
    }

    private boolean validInput()
    {
        boolean success = true;

        if (txtfieldFName.getText().isEmpty())
        {
            success = false;
        }
        else if (txtfieldLName.getText().isEmpty())
        {
            success = false;
        }
        else if (txtfieldCity.getText().isEmpty())
        {
            success = false;
        }
        else if (dateChooserBirth.getDate() == null)
        {
            success = false;
        }

        return success;
    }

    private void disableExtendedRadioSelection()
    {
        radioAdmin.setEnabled(false);
        radioCaretaker.setEnabled(false);
        radioDeptHead.setEnabled(false);
        radioTrainer.setEnabled(false);
    }    
    

    public JPanel getPanel()
    {
        return paneNewMember;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSports;
    private javax.swing.JButton btnSaveMember;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JComboBox comboTeam;
    private com.toedter.calendar.JDateChooser dateChooserBirth;
    private com.toedter.calendar.JDateChooser dateChooserEntry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblEntryDate;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JPanel paneMembershipData;
    private javax.swing.JPanel paneNewMember;
    private javax.swing.JPanel panePersonData;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioCaretaker;
    private javax.swing.JRadioButton radioDeptHead;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JRadioButton radioPlayer;
    private javax.swing.JRadioButton radioTrainer;
    private javax.swing.JTextField txtFieldSport;
    private javax.swing.JTextField txtfieldAddress;
    private javax.swing.JTextField txtfieldCity;
    private javax.swing.JTextField txtfieldCountry;
    private javax.swing.JTextField txtfieldFName;
    private javax.swing.JTextField txtfieldLName;
    private javax.swing.JTextField txtfieldMail;
    private javax.swing.JTextField txtfieldPhone;
    private javax.swing.JTextField txtfieldPostCode;
    // End of variables declaration//GEN-END:variables

}
