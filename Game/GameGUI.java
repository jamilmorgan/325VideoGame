
public class GameGUI extends javax.swing.JFrame {

    Game game;
    String command;
    

    public GameGUI() {
        
        //Instantiate a game and pass in the gui
        game = new Game(this);
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

        txtPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        commandTxt = new javax.swing.JTextField();
        goBtn = new javax.swing.JButton();
        moveLbl = new javax.swing.JLabel();
        infoPnl = new javax.swing.JPanel();
        healthLbl = new javax.swing.JLabel();
        weaponLbl = new javax.swing.JLabel();
        heartLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        nameLbl = new javax.swing.JLabel();
        dmgTxt = new javax.swing.JTextField();
        dmgLbl = new javax.swing.JLabel();
        healthTxt = new javax.swing.JTextField();
        pHealthLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        quitItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        controlsItem = new javax.swing.JMenuItem();
        instructionsItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        creatorsItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(740, 550));

        txtPnl.setBackground(new java.awt.Color(116, 135, 109));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        goBtn.setText("Go");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        moveLbl.setText("Your move:");

        infoPnl.setBackground(new java.awt.Color(116, 135, 109));

        healthLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        healthLbl.setText("Your health:");

        weaponLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        weaponLbl.setText("Your weapon:");

        heartLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled.png"))); // NOI18N
        heartLbl.setText("heart img");

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setText("Hands");

        nameLbl.setText("Name:");

        dmgTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dmgTxt.setText("1");

        dmgLbl.setText("Damage:");

        healthTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        healthTxt.setText("5");

        javax.swing.GroupLayout infoPnlLayout = new javax.swing.GroupLayout(infoPnl);
        infoPnl.setLayout(infoPnlLayout);
        infoPnlLayout.setHorizontalGroup(
            infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPnlLayout.createSequentialGroup()
                        .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(infoPnlLayout.createSequentialGroup()
                                .addComponent(dmgLbl)
                                .addGap(0, 23, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dmgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoPnlLayout.createSequentialGroup()
                        .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(healthLbl)
                            .addComponent(weaponLbl))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPnlLayout.createSequentialGroup()
                        .addComponent(heartLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(healthTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(pHealthLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        infoPnlLayout.setVerticalGroup(
            infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(healthLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heartLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pHealthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(weaponLbl)
                .addGap(18, 18, 18)
                .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt))
                .addGap(18, 18, 18)
                .addGroup(infoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dmgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dmgLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout txtPnlLayout = new javax.swing.GroupLayout(txtPnl);
        txtPnl.setLayout(txtPnlLayout);
        txtPnlLayout.setHorizontalGroup(
            txtPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPnlLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(txtPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveLbl)
                    .addGroup(txtPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtPnlLayout.createSequentialGroup()
                            .addComponent(commandTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(infoPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtPnlLayout.setVerticalGroup(
            txtPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(moveLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(commandTxt)
                    .addComponent(goBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(infoPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        quitItem.setText("Quit");
        fileMenu.add(quitItem);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");

        controlsItem.setText("Controls");
        controlsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlsItemActionPerformed(evt);
            }
        });
        helpMenu.add(controlsItem);

        instructionsItem.setText("Instructions");
        helpMenu.add(instructionsItem);

        jMenuBar1.add(helpMenu);

        aboutMenu.setText("About");

        creatorsItem.setText("Creators");
        aboutMenu.add(creatorsItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void controlsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlsItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controlsItemActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        // TODO add your handling code here:
        String s = commandTxt.getText();
        
        if(s.equals(""))
        {
            txtArea.append("\nYou need to enter a command.");
        }
        else
        {
            setCommand(s);
            String output = game.runCommand(s);
            printOutput(output);
        }
        
        commandTxt.setText("");
    }//GEN-LAST:event_goBtnActionPerformed

    public void setPHealth(int h)
    {
        String hString = Integer.toString(h);
        healthTxt.setText(hString);
    }
    
    public void setPWeapon(Weapon w)
    {
        String n = w.getName();
        int d = w.getDamage();
        
        String dString = Integer.toString(d);
        
        nameTxt.setText(n);
        dmgTxt.setText(dString);
    }
    
    public String getCommand()
    {
        return command;
    }
    
    public void setCommand(String s)
    {
        this.command = s;
    }
    
    public void printOutput(String s)
    {
        txtArea.append(s);
    }
    
    public void showIntro(){
        
        String INTRO = "  You awake in a crossroad. "
                + "Beside you is a note.\n  The note reads...\n\n"
                + "            ...You have one task. Find the treasure...\n\n"
                + "  There is a weapon lying next to you.\n"
                + "  What is your next move?\n";
        
        String WD_OPTION = "\n  1. take weapon\n  2. n / s / e / w \n  3. quit\n";
       
        
        printOutput(INTRO + WD_OPTION);
        
        System.out.println(INTRO + WD_OPTION);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JTextField commandTxt;
    private javax.swing.JMenuItem controlsItem;
    private javax.swing.JMenuItem creatorsItem;
    private javax.swing.JLabel dmgLbl;
    private javax.swing.JTextField dmgTxt;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton goBtn;
    private javax.swing.JLabel healthLbl;
    private javax.swing.JTextField healthTxt;
    private javax.swing.JLabel heartLbl;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel infoPnl;
    private javax.swing.JMenuItem instructionsItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moveLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel pHealthLbl;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JPanel txtPnl;
    private javax.swing.JLabel weaponLbl;
    // End of variables declaration//GEN-END:variables
}
