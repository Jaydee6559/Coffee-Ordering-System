
package coffee.ordering.system;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class SignUp extends javax.swing.JFrame {


    public SignUp() {
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
        jLabel2 = new javax.swing.JLabel();
        SignUpBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Username = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextPane();
        FirstName = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        Email = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        user_type = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        ConfirmPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGNUP");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(800, 568));
        setMinimumSize(new java.awt.Dimension(800, 568));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 568));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(239, 233, 233));
        jPanel1.setToolTipText("");
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 568));

        Right.setBackground(new java.awt.Color(239, 233, 233));
        Right.setPreferredSize(new java.awt.Dimension(400, 568));
        Right.setLayout(null);

        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Right.add(logo);
        logo.setBounds(90, 0, 250, 160);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Front.JPG"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        Right.add(jLabel6);
        jLabel6.setBounds(0, -1, 400, 570);

        Left.setBackground(new java.awt.Color(239, 233, 233));
        Left.setAlignmentX(0.0F);
        Left.setAlignmentY(0.0F);
        Left.setMinimumSize(new java.awt.Dimension(400, 568));
        Left.setPreferredSize(new java.awt.Dimension(400, 568));
        Left.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jLabel1.setText("Sign Up");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel1);
        jLabel1.setBounds(135, 30, 126, 47);
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel2.setText("First Name");
        Left.add(jLabel2);
        jLabel2.setBounds(235, 125, 84, 25);

        SignUpBtn.setBackground(new java.awt.Color(89, 51, 20));
        SignUpBtn.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        SignUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        SignUpBtn.setText("SIGNUP");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });
        Left.add(SignUpBtn);
        SignUpBtn.setBounds(245, 450, 120, 31);

        jLabel4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel4.setText("I already have an account?");
        Left.add(jLabel4);
        jLabel4.setBounds(65, 510, 171, 19);

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
        jButton2.setBounds(265, 506, 72, 26);

        jLabel5.setFont(new java.awt.Font("Poppins Light", 0, 18)); // NOI18N
        jLabel5.setText("Hello! let’s get started");
        jLabel5.setAlignmentY(0.0F);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel5);
        jLabel5.setBounds(105, 80, 174, 24);

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel8.setText("Username");
        Left.add(jLabel8);
        jLabel8.setBounds(35, 190, 74, 19);

        Username.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        Username.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Username.setAlignmentX(0.0F);
        Username.setAlignmentY(0.0F);
        Left.add(Username);
        Username.setBounds(35, 215, 330, 22);

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel9.setText("Last Name");
        Left.add(jLabel9);
        jLabel9.setBounds(35, 125, 67, 19);

        LastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        LastName.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        LastName.setAlignmentX(0.0F);
        LastName.setAlignmentY(0.0F);
        Left.add(LastName);
        LastName.setBounds(35, 150, 130, 22);

        FirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        FirstName.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        FirstName.setAlignmentX(0.0F);
        FirstName.setAlignmentY(0.0F);
        Left.add(FirstName);
        FirstName.setBounds(235, 150, 130, 22);

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel10.setText("Email");
        Left.add(jLabel10);
        jLabel10.setBounds(35, 255, 74, 19);

        Email.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        Email.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Email.setAlignmentX(0.0F);
        Email.setAlignmentY(0.0F);
        Left.add(Email);
        Email.setBounds(35, 280, 330, 22);

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel11.setText("Password");
        Left.add(jLabel11);
        jLabel11.setBounds(35, 320, 74, 19);

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel12.setText("Confirm Password");
        Left.add(jLabel12);
        jLabel12.setBounds(35, 385, 150, 19);

        user_type.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        user_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        user_type.setName(""); // NOI18N
        user_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_typeActionPerformed(evt);
            }
        });
        Left.add(user_type);
        user_type.setBounds(115, 455, 80, 20);

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel13.setText("Sign Up as");
        Left.add(jLabel13);
        jLabel13.setBounds(35, 455, 74, 19);
        Left.add(Password);
        Password.setBounds(40, 350, 320, 22);
        Left.add(ConfirmPassword);
        ConfirmPassword.setBounds(40, 410, 320, 22);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        String fullName, email, password, confirmPassword, username, userType, id; // default or static type
        String SUrl = "jdbc:mysql://localhost:3306/java_user_database"; // Note: lowercase 'mysql'
        String SUser = "root";
        String SPass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            String firstName = FirstName.getText();
            String lastName = LastName.getText();
            username = Username.getText();
            email = Email.getText();
            password = new String(Password.getPassword());
            confirmPassword = new String(ConfirmPassword.getPassword());
            userType = user_type.getSelectedItem().toString();


            if (firstName.isEmpty() || lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "First and Last Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                fullName = firstName + " " + lastName;

                String query = "INSERT INTO user(lastName, firstName, username, email, password, confirmPassword, user_type)" + 
                    "VALUES('" + lastName + "', '" + firstName + "', '" + username + "', '" + email + "', '" + password + "', '" + confirmPassword + "', '" + userType + "')";

                try (java.sql.PreparedStatement pst = con.prepareStatement(query)) {

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "New account has been created successfully!");

                    // Clear fields
                    Username.setText("");
                    Email.setText("");
                    LastName.setText("");
                    FirstName.setText("");
                    Password.setText("");
                    ConfirmPassword.setText("");
                    user_type.setSelectedIndex(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SignUpBtnActionPerformed

    private void user_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_typeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JTextPane Email;
    private javax.swing.JTextPane FirstName;
    private javax.swing.JTextPane LastName;
    private javax.swing.JPanel Left;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPanel Right;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JTextPane Username;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> user_type;
    // End of variables declaration//GEN-END:variables
}
