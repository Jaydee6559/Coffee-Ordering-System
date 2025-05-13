/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coffee.ordering.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Login extends javax.swing.JFrame {

    static {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
    }
    
    public Login() {
        initComponents();
        int logoSize = 225;
        logo.setIcon(getScaledIcon("/images/logo-white.png", logoSize, logoSize));
    }

    private ImageIcon getScaledIcon(String path, int width, int height) {
        java.net.URL imageUrl = getClass().getResource(path);
        if (imageUrl == null) {
            System.out.println("Image not found at: " + path);
            return null;
        }
        ImageIcon icon = new ImageIcon(imageUrl);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        username = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jTextPane6 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SignUpBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(239, 233, 233));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
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

        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Right.add(logo);
        logo.setBounds(90, 0, 250, 160);

        jLabel6.setBackground(new java.awt.Color(239, 233, 233));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Front.JPG"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setMinimumSize(null);
        jLabel6.setName(""); // NOI18N
        Right.add(jLabel6);
        jLabel6.setBounds(0, -1, 400, 570);

        Left.setBackground(new java.awt.Color(239, 233, 233));
        Left.setForeground(new java.awt.Color(239, 233, 233));
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
        jLabel1.setBounds(160, 30, 86, 47);
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setFont(new java.awt.Font("Poppins Light", 0, 18)); // NOI18N
        jLabel5.setText("Hello! let’s get started");
        jLabel5.setAlignmentY(0.0F);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel5);
        jLabel5.setBounds(105, 80, 174, 24);

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel8.setText("Email");
        Left.add(jLabel8);
        jLabel8.setBounds(35, 150, 74, 19);

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        username.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        username.setAlignmentX(0.0F);
        username.setAlignmentY(0.0F);
        Left.add(username);
        username.setBounds(35, 175, 330, 22);

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel11.setText("Login As");
        Left.add(jLabel11);
        jLabel11.setBounds(60, 320, 74, 19);

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
        jComboBox1.setBounds(120, 320, 80, 22);

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel13.setText("Password");
        Left.add(jLabel13);
        jLabel13.setBounds(35, 235, 74, 19);

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
        LoginBtn.setBounds(265, 318, 72, 27);

        jLabel4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel4.setText("Don't have an account?");
        Left.add(jLabel4);
        jLabel4.setBounds(65, 510, 150, 19);

        SignUpBtn.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        SignUpBtn.setForeground(new java.awt.Color(102, 0, 0));
        SignUpBtn.setText("Sign Up");
        SignUpBtn.setAlignmentY(0.0F);
        SignUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });
        Left.add(SignUpBtn);
        SignUpBtn.setBounds(247, 506, 90, 26);

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
        int userId = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

        if ("".equals(username.getText())) {
             JOptionPane.showMessageDialog(new JFrame(), "Email Address is required", "Error",
                     JOptionPane.ERROR_MESSAGE);
         } else if ("".equals(jTextPane6.getText())) {
             JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error",
                     JOptionPane.ERROR_MESSAGE);
         } else if (jComboBox1.getSelectedItem() == null) {
             JOptionPane.showMessageDialog(new JFrame(), "Please select a User Type", "Error",
                     JOptionPane.ERROR_MESSAGE);
         } else {
             Email = username.getText();
             Password = jTextPane6.getText();
             String selectedType = jComboBox1.getSelectedItem().toString();


                query = "SELECT * FROM user WHERE email= '" + Email + "'";

                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    passDb = rs.getString("password");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    fname = firstName + " " + lastName;
                    userTypeDb = rs.getString("user_type");
                    userId = rs.getInt("id");
                    notFound = 1;
                    userId = rs.getInt("id");
                }

                if (notFound == 1 && Password.equals(passDb)) {
                    if (userTypeDb != null && userTypeDb.equals(selectedType)) {
                        if (userTypeDb.equals("User")) {
                            UserFrame userFrame = new UserFrame();
                            userFrame.setUser(fname);   
                            userFrame.setCurrentUserId(userId);
                            userFrame.setVisible(true);
                            userFrame.pack();
                            userFrame.setLocationRelativeTo(null);
                            this.dispose();
                        } else if (userTypeDb.equals("Admin")) {
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

        jTextPane6.setText("");

            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }

    }//GEN-LAST:event_LoginBtnActionPerformed

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_SignUpBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JLabel logo;
    private javax.swing.JTextPane username;
    // End of variables declaration//GEN-END:variables
}
