
package coffee.ordering.system;

import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class UserFrame extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    
    private String[] imageNames = {"diwata.png", "hiwaga.png", "romnick.png"}; 
    private String[] productNames = {"Diwata Coffee", "Hiwaga Coffee", "Romnick Coffee"};
    private String[] productDescriptions = {"Laos na", "Madumi", "May Daga"};
    private int currentIndex = 0;
    
    String[] categories = {"Choose", "Main Courses", "Desserts"};
   
    public UserFrame() {
        initComponents();
        cardLayout = (CardLayout)(getContentPane().getLayout());
        updateDisplay();
        cartPanel.setVisible(false);
        cartPanel1.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        cartPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        productImage = new javax.swing.JLabel();
        productDescription = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        aboutBtn = new javax.swing.JButton();
        categoriesBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        cartBtn = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        panelCategory = new javax.swing.JPanel();
        cartPanel1 = new javax.swing.JPanel();
        product1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        product2 = new javax.swing.JPanel();
        product3 = new javax.swing.JPanel();
        product4 = new javax.swing.JPanel();
        categoryComboBox = new javax.swing.JComboBox<>();
        homeBtn1 = new javax.swing.JButton();
        cartBtn1 = new javax.swing.JButton();
        aboutBtn1 = new javax.swing.JButton();
        categoriesBtn1 = new javax.swing.JButton();
        LogoutBtn1 = new javax.swing.JButton();

        user.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER");
        setMinimumSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(new java.awt.CardLayout());

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.setMinimumSize(new java.awt.Dimension(1100, 700));
        panelHome.setLayout(null);

        cartPanel.setLayout(new javax.swing.OverlayLayout(cartPanel));
        panelHome.add(cartPanel);
        cartPanel.setBounds(800, 50, 290, 420);

        jButton1.setText("Order Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHome.add(jButton1);
        jButton1.setBounds(210, 320, 100, 23);

        leftButton.setText("Left Button");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        panelHome.add(leftButton);
        leftButton.setBounds(30, 330, 110, 23);

        LogoutBtn.setText("LOGOUT");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });
        panelHome.add(LogoutBtn);
        LogoutBtn.setBounds(20, 630, 140, 40);

        productImage.setText("product image");
        panelHome.add(productImage);
        productImage.setBounds(417, 180, 350, 262);

        productDescription.setText("product Descrip");
        panelHome.add(productDescription);
        productDescription.setBounds(210, 250, 84, 16);

        jLabel2.setText("Best Products");
        panelHome.add(jLabel2);
        jLabel2.setBounds(220, 150, 90, 16);

        productName.setText("product name ");
        panelHome.add(productName);
        productName.setBounds(220, 200, 90, 16);

        aboutBtn.setText("About us");
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });
        panelHome.add(aboutBtn);
        aboutBtn.setBounds(548, 20, 100, 23);

        categoriesBtn.setText("Categories");
        panelHome.add(categoriesBtn);
        categoriesBtn.setBounds(416, 20, 100, 23);

        homeBtn.setText("Home");
        panelHome.add(homeBtn);
        homeBtn.setBounds(290, 20, 90, 23);

        cartBtn.setText("Cart");
        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });
        panelHome.add(cartBtn);
        cartBtn.setBounds(910, 20, 72, 23);

        rightButton.setText("Right Button");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        panelHome.add(rightButton);
        rightButton.setBounds(927, 340, 120, 23);

        getContentPane().add(panelHome, "card2");

        panelCategory.setLayout(null);

        cartPanel1.setLayout(new javax.swing.OverlayLayout(cartPanel1));
        panelCategory.add(cartPanel1);
        cartPanel1.setBounds(800, 50, 290, 420);

        product1.setBackground(new java.awt.Color(204, 255, 204));
        product1.setLayout(null);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        product1.add(jPanel1);
        jPanel1.setBounds(70, 40, 160, 160);

        panelCategory.add(product1);
        product1.setBounds(130, 80, 840, 510);

        product2.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout product2Layout = new javax.swing.GroupLayout(product2);
        product2.setLayout(product2Layout);
        product2Layout.setHorizontalGroup(
            product2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        product2Layout.setVerticalGroup(
            product2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        panelCategory.add(product2);
        product2.setBounds(130, 80, 840, 510);

        product3.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout product3Layout = new javax.swing.GroupLayout(product3);
        product3.setLayout(product3Layout);
        product3Layout.setHorizontalGroup(
            product3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        product3Layout.setVerticalGroup(
            product3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        panelCategory.add(product3);
        product3.setBounds(130, 80, 840, 510);

        product4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout product4Layout = new javax.swing.GroupLayout(product4);
        product4.setLayout(product4Layout);
        product4Layout.setHorizontalGroup(
            product4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        product4Layout.setVerticalGroup(
            product4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        panelCategory.add(product4);
        product4.setBounds(130, 80, 840, 510);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Product1", "Product2", "Product3", "Product4" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });
        panelCategory.add(categoryComboBox);
        categoryComboBox.setBounds(70, 40, 82, 22);

        homeBtn1.setText("Home");
        panelCategory.add(homeBtn1);
        homeBtn1.setBounds(290, 20, 90, 23);

        cartBtn1.setText("Cart");
        cartBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtn1ActionPerformed(evt);
            }
        });
        panelCategory.add(cartBtn1);
        cartBtn1.setBounds(910, 20, 72, 23);

        aboutBtn1.setText("About us");
        aboutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtn1ActionPerformed(evt);
            }
        });
        panelCategory.add(aboutBtn1);
        aboutBtn1.setBounds(548, 20, 100, 23);

        categoriesBtn1.setText("Categories");
        panelCategory.add(categoriesBtn1);
        categoriesBtn1.setBounds(416, 20, 100, 23);

        LogoutBtn1.setText("LOGOUT");
        LogoutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn1ActionPerformed(evt);
            }
        });
        panelCategory.add(LogoutBtn1);
        LogoutBtn1.setBounds(20, 630, 140, 40);

        getContentPane().add(panelCategory, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_LogoutBtnActionPerformed
    private void updateDisplay() {
        // Load image from the "images" folder
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imageNames[currentIndex]));

        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        productImage.setIcon(new ImageIcon(img));
        productName.setText(productNames[currentIndex]);
        productDescription.setText(productDescriptions[currentIndex]);
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout.show(getContentPane(), "card3");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        currentIndex--;
        if (currentIndex < 0) currentIndex = imageNames.length - 1;
        updateDisplay();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        currentIndex++;
        if (currentIndex >= imageNames.length) currentIndex = 0;
        updateDisplay();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutBtnActionPerformed

    private void cartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtnActionPerformed
        cartPanel.setVisible(!cartPanel.isVisible());
    }//GEN-LAST:event_cartBtnActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        updateFoodsDisplay(selectedCategory);
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void cartBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtn1ActionPerformed
        cartPanel1.setVisible(!cartPanel.isVisible());
    }//GEN-LAST:event_cartBtn1ActionPerformed

    private void aboutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutBtn1ActionPerformed

    private void LogoutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtn1ActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_LogoutBtn1ActionPerformed
    
    void updateFoodsDisplay(String category) {
    if (category.equals("Product1")) {
        product1.setVisible(true);
        product2.setVisible(false);
        product3.setVisible(false);
        product4.setVisible(false);
    } else if (category.equals("Product2")) {
        product1.setVisible(false);
        product2.setVisible(true);
        product3.setVisible(false);
        product4.setVisible(false);
    } else if (category.equals("Product3")) {
        product1.setVisible(false);
        product2.setVisible(false);
        product3.setVisible(true);
        product4.setVisible(false);
    } else if (category.equals("Product4")) {
        product1.setVisible(false);
        product2.setVisible(false);
        product3.setVisible(false);
        product4.setVisible(true);
    } else {
        product1.setVisible(false);
        product2.setVisible(false);
        product3.setVisible(false);
        product4.setVisible(true);
    }
}
    public void setUser(String name){
        user.setText(name);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton LogoutBtn1;
    private javax.swing.JButton aboutBtn;
    private javax.swing.JButton aboutBtn1;
    private javax.swing.JButton cartBtn;
    private javax.swing.JButton cartBtn1;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel cartPanel1;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JButton categoriesBtn1;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton homeBtn1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leftButton;
    private javax.swing.JPanel panelCategory;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel product1;
    private javax.swing.JPanel product2;
    private javax.swing.JPanel product3;
    private javax.swing.JPanel product4;
    private javax.swing.JLabel productDescription;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productName;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
