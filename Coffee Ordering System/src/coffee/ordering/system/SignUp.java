
package coffee.ordering.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class SignUp extends javax.swing.JFrame {


    public SignUp() {
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
        jLabel2 = new javax.swing.JLabel();
        SignUpBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jTextPane4 = new javax.swing.JTextPane();
        jTextPane5 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jTextPane6 = new javax.swing.JTextPane();
        jTextPane7 = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGNUP");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setMaximizedBounds(new java.awt.Rectangle(800, 568, 568, 568));
        setMaximumSize(new java.awt.Dimension(800, 568));
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
        jLabel1.setText("Sign Up");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Left.add(jLabel1);
        jLabel1.setBounds(135, 30, 134, 55);
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
        SignUpBtn.setBounds(35, 450, 330, 31);

        jLabel4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel4.setText("I already have an account?");
        Left.add(jLabel4);
        jLabel4.setBounds(65, 510, 190, 22);

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
        jLabel8.setBounds(35, 190, 74, 22);

        jTextPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane2.setAlignmentX(0.0F);
        jTextPane2.setAlignmentY(0.0F);
        Left.add(jTextPane2);
        jTextPane2.setBounds(35, 215, 330, 22);

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel9.setText("Last Name");
        Left.add(jLabel9);
        jLabel9.setBounds(35, 125, 73, 22);

        jTextPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane4.setAlignmentX(0.0F);
        jTextPane4.setAlignmentY(0.0F);
        Left.add(jTextPane4);
        jTextPane4.setBounds(35, 150, 130, 22);

        jTextPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane5.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane5.setAlignmentX(0.0F);
        jTextPane5.setAlignmentY(0.0F);
        Left.add(jTextPane5);
        jTextPane5.setBounds(235, 150, 130, 22);

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel10.setText("Email");
        Left.add(jLabel10);
        jLabel10.setBounds(35, 255, 74, 22);

        jTextPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane3.setAlignmentX(0.0F);
        jTextPane3.setAlignmentY(0.0F);
        Left.add(jTextPane3);
        jTextPane3.setBounds(35, 280, 330, 22);

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel11.setText("Password");
        Left.add(jLabel11);
        jLabel11.setBounds(35, 320, 74, 22);

        jTextPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane6.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane6.setAlignmentX(0.0F);
        jTextPane6.setAlignmentY(0.0F);
        Left.add(jTextPane6);
        jTextPane6.setBounds(35, 345, 330, 22);

        jTextPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Light", 0, 14))); // NOI18N
        jTextPane7.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextPane7.setAlignmentX(0.0F);
        jTextPane7.setAlignmentY(0.0F);
        Left.add(jTextPane7);
        jTextPane7.setBounds(35, 410, 330, 22);

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel12.setText("Confirm Password");
        Left.add(jLabel12);
        jLabel12.setBounds(35, 385, 150, 22);

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
        String fullName, email, Password, userType, query;
        String SUrl, SUser, SPass;
        SUrl = "jdbc:MySQL://localhost:3306/java_user_database";
        SUser = "root";
        SPass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            if("".equals(fname.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Full Name is require", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }else if("".equals(emailAddress.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Email Address is require", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }else if("".equals(pass.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Password is require", "Error",
                    JOptionPane.ERROR_MESSAGE);
            } else if (user_type.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Please select a User Type", "Error",
                    JOptionPane.ERROR_MESSAGE);
            } else {
                fullName = fname.getText();
                email    = emailAddress.getText();
                Password = pass.getText();
                userType = user_type.getSelectedItem().toString();
                System.out.println(Password);

                query = "INSERT INTO user(full_name, email, password, user_type) " +
                "VALUES('" + fullName + "', '" + email + "', '" + Password + "', '" + userType + "')";

                st.execute(query);
                fname.setText("");
                emailAddress.setText("");
                pass.setText("");
                user_type.setSelectedIndex(0);
                showMessageDialog(null, "New account has been created successfully!");
            }
        }catch(Exception e){
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_SignUpBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    // End of variables declaration//GEN-END:variables
}
