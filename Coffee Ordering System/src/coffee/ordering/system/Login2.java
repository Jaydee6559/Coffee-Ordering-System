
package coffee.ordering.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class Login2 extends javax.swing.JFrame {


    public Login2() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jTextPane6 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGNUP");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setMaximizedBounds(new java.awt.Rectangle(800, 568, 568, 568));
        setMinimumSize(new java.awt.Dimension(800, 568));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 568));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 568));

        Right.setBackground(new java.awt.Color(89, 51, 20));
        Right.setPreferredSize(new java.awt.Dimension(400, 568));
        Right.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Front.JPG"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        Right.add(jLabel6);
        jLabel6.setBounds(0, -1, 400, 570);

        Left.setAlignmentX(0.0F);
        Left.setAlignmentY(0.0F);
        Left.setMinimumSize(new java.awt.Dimension(400, 568));
        Left.setPreferredSize(new java.awt.Dimension(400, 568));
        Left.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel1);
        jLabel1.setBounds(160, 30, 93, 55);
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setFont(new java.awt.Font("Poppins Light", 0, 18)); // NOI18N
        jLabel5.setText("Hello! let’s get started");
        jLabel5.setAlignmentY(0.0F);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel5);
        jLabel5.setBounds(105, 80, 189, 28);

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel8.setText("Username");
        Left.add(jLabel8);
        jLabel8.setBounds(35, 150, 74, 22);

        jTextPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane2.setAlignmentX(0.0F);
        jTextPane2.setAlignmentY(0.0F);
        Left.add(jTextPane2);
        jTextPane2.setBounds(35, 175, 330, 22);

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel11.setText("Login As");
        Left.add(jLabel11);
        jLabel11.setBounds(60, 320, 74, 22);

        jTextPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane6.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane6.setAlignmentX(0.0F);
        jTextPane6.setAlignmentY(0.0F);
        Left.add(jTextPane6);
        jTextPane6.setBounds(35, 260, 330, 22);

        jComboBox1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Left.add(jComboBox1);
        jComboBox1.setBounds(125, 320, 80, 22);

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel13.setText("Password");
        Left.add(jLabel13);
        jLabel13.setBounds(35, 235, 74, 22);

        LoginBtn.setBackground(new java.awt.Color(89, 51, 20));
        LoginBtn.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        Left.add(LoginBtn);
        LoginBtn.setBounds(265, 320, 72, 27);

        jLabel4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel4.setText("Don't have an account?");
        Left.add(jLabel4);
        jLabel4.setBounds(65, 510, 166, 22);

        jButton2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setText("Login");
        jButton2.setAlignmentY(0.0F);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Left.add(jButton2);
        jButton2.setBounds(265, 506, 72, 29);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        String Email, Password, query, fname = null, passDb = null, userTypeDb = null;
        String SUrl, SUser, SPass;
        SUrl = "jdbc:MySQL://localhost:3306/java_user_database";
        SUser = "root";
        SPass = "";
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            if ("".equals(email.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Email Address is required", "Error",
                    JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(password.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error",
                    JOptionPane.ERROR_MESSAGE);
            } else if (user_type.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Please select a User Type", "Error",
                    JOptionPane.ERROR_MESSAGE);
            } else {
                Email = email.getText();
                Password = password.getText();
                String selectedType = user_type.getSelectedItem().toString();

                query = "SELECT * FROM user WHERE email= '" + Email + "'";

                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    passDb = rs.getString("password");
                    fname = rs.getString("full_name");
                    userTypeDb = rs.getString("user_type");
                    notFound = 1;
                }

                if (notFound == 1 && Password.equals(passDb)) {
                    if (userTypeDb != null && userTypeDb.equals(selectedType)) {
                        if (userTypeDb.equals("USER")) {
                            UserFrame userFrame = new UserFrame();
                            userFrame.setUser(fname);
                            userFrame.setVisible(true);
                            userFrame.pack();
                            userFrame.setLocationRelativeTo(null);
                            this.dispose();
                        } else if (userTypeDb.equals("ADMIN")) {
                            AdminFrame adminFrame = new AdminFrame();
                            adminFrame.setUser(fname);
                            adminFrame.setVisible(true);
                            adminFrame.pack();
                            adminFrame.setLocationRelativeTo(null);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid user type.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "User type mismatch!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password", "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

                password.setText("");
            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }

    }//GEN-LAST:event_LoginBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane6;
    // End of variables declaration//GEN-END:variables
}
