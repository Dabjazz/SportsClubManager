package sportsclubmanager.presentation.forms.competition;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import sportsclubmanager.presentation.basics.AbstractForm;
import sportsclubmanager.presentation.basics.AbstractMainForm;


/**
 *
 * @author Lucia
 */
public class CreateCompetitionForm extends AbstractMainForm{

    // Variables declaration - do not modify
    private JButton btnAddMatch;
    private JButton btnConfirm;
    private JButton btnCreate;
    private com.toedter.calendar.JDateChooser dateDate;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JSpinner jSpinner1;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lblCity;
    private JLabel lblCountry;
    private JLabel lblDate;
    private JLabel lblFee;
    private JLabel lblLocation;
    private JLabel lblMatchNr;
    private JLabel lblName;
    private JLabel lblPostCode;
    private JLabel lblTeams;
    private JLabel lblTime;
    private JList listSelectMatch;
    private JList listSelectTeams;
    private JList listTeamA;
    private JList listTeamB;
    private JPanel paneData;
    private JPanel paneSetMatches;
    public JPanel panel;
    private JTextField textfieldName;
    private JTextField txtfieldCountry;
    private JTextField txtfieldFee;
    private JTextField txtfieldLocation;
    private JTextField txtfieldTeamA;
    private JTextField txtfieldTeamB;
    private JTextField txtfieldTime;
    private JTextField txtfieldcity;
    private JTextField txtfieldplz;
    // End of variables declaration
    
    public CreateCompetitionForm(AbstractForm parent) {
        super(parent);
        initComponents();    
    }
    
    private void initComponents() {

        panel = new JPanel();
        paneData = new JPanel();
        lblTeams = new JLabel();
        jScrollPane1 = new JScrollPane();
        listSelectTeams = new JList();
        lblMatchNr = new JLabel();
        jSpinner1 = new JSpinner();
        lblName = new JLabel();
        lblDate = new JLabel();
        lblTime = new JLabel();
        lblLocation = new JLabel();
        lblCity = new JLabel();
        lblCountry = new JLabel();
        lblPostCode = new JLabel();
        txtfieldLocation = new JTextField();
        textfieldName = new JTextField();
        dateDate = new com.toedter.calendar.JDateChooser();
        txtfieldTime = new JTextField();
        txtfieldplz = new JTextField();
        txtfieldcity = new JTextField();
        txtfieldCountry = new JTextField();
        lblFee = new JLabel();
        txtfieldFee = new JTextField();
        btnConfirm = new JButton();
        paneSetMatches = new JPanel();
        jScrollPane3 = new JScrollPane();
        listSelectMatch = new JList();
        txtfieldTeamA = new JTextField();
        lbl1 = new JLabel();
        txtfieldTeamB = new JTextField();
        jScrollPane2 = new JScrollPane();
        listTeamA = new JList();
        jScrollPane4 = new JScrollPane();
        listTeamB = new JList();
        lbl2 = new JLabel();
        btnAddMatch = new JButton();
        btnCreate = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(845, 549));

        paneData.setBorder(javax.swing.BorderFactory.createTitledBorder("Set Teams, Location & Date"));
        paneData.setMinimumSize(new java.awt.Dimension(794, 279));

        lblTeams.setText("Select Teams");

        listSelectTeams.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSelectTeams.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setPreferredSize(new java.awt.Dimension(40, 80));
        jScrollPane1.setViewportView(listSelectTeams);

        lblMatchNr.setText("Number of Matches");

        lblName.setText("Name");

        lblDate.setText("Date");

        lblTime.setText("Time");

        lblLocation.setText("Location");

        lblCity.setText("City");

        lblCountry.setText("Country");

        lblPostCode.setText("Post Code");

        txtfieldLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldLocationActionPerformed(evt);
            }
        });

        textfieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldNameActionPerformed(evt);
            }
        });

        lblFee.setText("Fee");

        txtfieldFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldFeeActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm Data");

        javax.swing.GroupLayout paneDataLayout = new javax.swing.GroupLayout(paneData);
        paneData.setLayout(paneDataLayout);
        paneDataLayout.setHorizontalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTeams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addComponent(lblMatchNr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLocation)
                                    .addComponent(lblName)
                                    .addComponent(lblDate))
                                .addGap(18, 18, 18)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneDataLayout.createSequentialGroup()
                                        .addComponent(dateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(lblTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtfieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPostCode)
                                    .addComponent(lblCountry)
                                    .addComponent(lblFee))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneDataLayout.createSequentialGroup()
                                        .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfieldcity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDataLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm)))
                .addContainerGap())
        );
        paneDataLayout.setVerticalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTeams)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMatchNr)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(paneDataLayout.createSequentialGroup()
                                        .addComponent(lblName)
                                        .addGap(12, 12, 12)
                                        .addComponent(lblDate))
                                    .addGroup(paneDataLayout.createSequentialGroup()
                                        .addComponent(textfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblTime)
                                                .addComponent(txtfieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(dateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLocation)
                                    .addComponent(txtfieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPostCode)
                                    .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCity)
                                    .addComponent(txtfieldcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCountry)
                                    .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFee))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDataLayout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addContainerGap())))
        );

        paneSetMatches.setBorder(javax.swing.BorderFactory.createTitledBorder("Set Matches"));

        listSelectMatch.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSelectMatch.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setPreferredSize(new java.awt.Dimension(40, 80));
        jScrollPane3.setViewportView(listSelectMatch);

        txtfieldTeamA.setEnabled(false);
        txtfieldTeamA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldTeamAActionPerformed(evt);
            }
        });

        lbl1.setText("vs.");

        txtfieldTeamB.setEnabled(false);
        txtfieldTeamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldTeamBActionPerformed(evt);
            }
        });

        listTeamA.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listTeamA.setEnabled(false);
        jScrollPane2.setViewportView(listTeamA);

        listTeamB.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listTeamB.setEnabled(false);
        jScrollPane4.setViewportView(listTeamB);

        lbl2.setText("vs.");

        btnAddMatch.setText("Add Match");

        javax.swing.GroupLayout paneSetMatchesLayout = new javax.swing.GroupLayout(paneSetMatches);
        paneSetMatches.setLayout(paneSetMatchesLayout);
        paneSetMatchesLayout.setHorizontalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lbl1))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddMatch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl2)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneSetMatchesLayout.setVerticalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMatch)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lbl2)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );

        btnCreate.setText("Create Competition");
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
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneSetMatches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreate)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneSetMatches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void txtfieldLocationActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void textfieldNameActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void txtfieldFeeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtfieldTeamAActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void txtfieldTeamBActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    } 

     
    
}
