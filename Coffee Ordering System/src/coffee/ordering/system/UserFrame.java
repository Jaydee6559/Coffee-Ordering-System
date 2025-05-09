
package coffee.ordering.system;


import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;




public class UserFrame extends javax.swing.JFrame {
    
    

    private String[] imageNames = {"diwata.png", "hiwaga.png", "romnick.png"}; 
    private String[] productNames = {"<html>Spanish Latte</html>", "<html>Hot Coffee</html>", "<html>Croissant</html>"};
    private String[] productDescriptions = {"<html>The perfect blend of bold and breezy.</html>", "<html>The only thing warmer than your smile? This perfectly brewed cup.</html>", "<html>Treat yourself to a little piece of Paris.</html>"};
    private int currentIndex = 0;
    
    String[] categories = {"Choose", "Main Courses", "Desserts"};
    private java.util.List<OrderItem> cart = new java.util.ArrayList<>();
    private javax.swing.table.DefaultTableModel cartModel;
    private int currentUserId;
    private List<OrderItem> currentOrderList = new ArrayList<>();
   
   
    
    public UserFrame() {
        initComponents();
        updateDisplay();
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
        categoryBack.setVisible(false);//back button
        americanoPanel.setVisible(false);
        jLayeredPane1.setVisible(false);
        billingPanel.setVisible(false);
        
        cartModel = new DefaultTableModel(new String[]{"Order", "Quantity", "Size", "Price"}, 0);
        cartTable.setModel(cartModel);
        
        int logoSize = 110;
        logo.setIcon(getScaledIcon("/images/logo.png", logoSize, logoSize));
        int iconSize = 15; // You can use 48 or 64 depending on desired size
        leftButton.setIcon(getScaledIcon("/images/left-arrow.png", iconSize));
        rightButton.setIcon(getScaledIcon("/images/right-arrow.png", iconSize));
        int homeIconSize = 16; // Or any size that fits well
        homeBtn.setIcon(getScaledIcon("/images/home.png", homeIconSize));
        homeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Optional: text to the right of icon
        homeBtn.setIconTextGap(10); // Optional: spacing between icon and text
        int menuIconSize = 16; // Or any size that fits well
        categoriesBtn.setIcon(getScaledIcon("/images/menu.png", menuIconSize));
        categoriesBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Optional: text to the right of icon
        categoriesBtn.setIconTextGap(10); // Optional: spacing between icon and text
        int cartIconSize = 16; // Or any size that fits well
        cartBtn.setIcon(getScaledIcon("/images/cart.png", cartIconSize));
        cartBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Optional: text to the right of icon
        cartBtn.setIconTextGap(10); // Optional: spacing between icon and text
        int abtIconSize = 16; // Or any size that fits well
        aboutBtn.setIcon(getScaledIcon("/images/people.png", abtIconSize));
        aboutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Optional: text to the right of icon
        aboutBtn.setIconTextGap(10); // Optional: spacing between icon and text
        roundedPanel.setOpaque(false); // Important for clean edges
        roundedPanel.setBorder(new javax.swing.border.Border() {
            private final int radius = 8; // Adjust corner radius here

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the rounded area with white
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(x, y, width-1, height-1, radius*2, radius*2);

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(x, y, width-1, height-1, radius*2, radius*2);

                g2d.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius, radius, radius, radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }
        });

    // Make sure the parent container doesn't show through
    roundedPanel.setBackground(Color.WHITE);
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
    
    public void setCurrentUserId(int userId) {
        this.currentUserId = userId;
        // Optional: Update UI to show logged in user
        user.setText("User ID: " + userId); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
        pastriesPanel1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        croissantButton1 = new javax.swing.JButton();
        cheeseRollButton1 = new javax.swing.JButton();
        chocolateChipCookieButton1 = new javax.swing.JButton();
        cinnamonRollButton1 = new javax.swing.JButton();
        blueberryMuffinButton1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        coldCoffeePanel1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        icedWhiteMochaButton1 = new javax.swing.JButton();
        icedHazelnutCoffee1 = new javax.swing.JButton();
        spanishLatteButton1 = new javax.swing.JButton();
        icedMatchaEspressoButton1 = new javax.swing.JButton();
        icedCoffeeJellyButton1 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        hotCoffeePanel1 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        americanoButton1 = new javax.swing.JButton();
        latteButton1 = new javax.swing.JButton();
        cappuccinoButton1 = new javax.swing.JButton();
        brewedCoffeeButton1 = new javax.swing.JButton();
        hotCaramelMacchiatoButton1 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        receiptInternalFrame = new javax.swing.JInternalFrame();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelHome = new javax.swing.JPanel();
        line = new javax.swing.JPanel();
        jTabbedPanel = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        productDescription = new javax.swing.JLabel();
        productImage = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        tab2 = new javax.swing.JPanel();
        categoryBack = new javax.swing.JButton();
        hotCoffeePanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        americanoButton = new javax.swing.JButton();
        latteButton = new javax.swing.JButton();
        cappuccinoButton = new javax.swing.JButton();
        brewedCoffeeButton = new javax.swing.JButton();
        hotCaramelMacchiatoButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        coldCoffeePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        icedWhiteMochaButton = new javax.swing.JButton();
        icedHazelnutCoffee = new javax.swing.JButton();
        spanishLatteButton = new javax.swing.JButton();
        icedMatchaEspressoButton = new javax.swing.JButton();
        icedCoffeeJellyButton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pastriesPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        croissantButton = new javax.swing.JButton();
        cheeseRollButton = new javax.swing.JButton();
        chocolateChipCookieButton = new javax.swing.JButton();
        cinnamonRollButton = new javax.swing.JButton();
        blueberryMuffinButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Pastries = new javax.swing.JButton();
        IcedCoffee = new javax.swing.JButton();
        HotCoffee = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        IcedCoffee2 = new javax.swing.JButton();
        IcedCoffee3 = new javax.swing.JButton();
        IcedCoffee4 = new javax.swing.JButton();
        IcedCoffee5 = new javax.swing.JButton();
        IcedCoffee7 = new javax.swing.JButton();
        IcedCoffee8 = new javax.swing.JButton();
        IcedCoffee9 = new javax.swing.JButton();
        IcedCoffee10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        billingPanel = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        adw = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        currentOrderTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        clearAll = new javax.swing.JButton();
        tab4 = new javax.swing.JPanel();
        tab5 = new javax.swing.JPanel();
        americanoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sizeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        americanoPrice = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();
        categoriesBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        cartBtn = new javax.swing.JButton();
        roundedPanel = new javax.swing.JPanel();

        user.setText("jLabel1");

        cartPanel.setLayout(new javax.swing.OverlayLayout(cartPanel));

        pastriesPanel1.setBackground(new java.awt.Color(239, 233, 233));

        jLabel33.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel33.setText("Pastries");

        croissantButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                croissantButton1ActionPerformed(evt);
            }
        });

        cheeseRollButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheeseRollButton1ActionPerformed(evt);
            }
        });

        chocolateChipCookieButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chocolateChipCookieButton1ActionPerformed(evt);
            }
        });

        cinnamonRollButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinnamonRollButton1ActionPerformed(evt);
            }
        });

        blueberryMuffinButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueberryMuffinButton1ActionPerformed(evt);
            }
        });

        jLabel34.setText("Blueberry Muffin");

        jLabel35.setText("Croissant");

        jLabel36.setText("Cheese Roll");

        jLabel37.setText("Chocolate Chip Cookie ");

        jLabel38.setText("Cinnamon Roll");

        javax.swing.GroupLayout pastriesPanel1Layout = new javax.swing.GroupLayout(pastriesPanel1);
        pastriesPanel1.setLayout(pastriesPanel1Layout);
        pastriesPanel1Layout.setHorizontalGroup(
            pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(blueberryMuffinButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(croissantButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(cheeseRollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(pastriesPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel34)
                .addGap(159, 159, 159)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(154, 154, 154))
            .addGroup(pastriesPanel1Layout.createSequentialGroup()
                .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pastriesPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(pastriesPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pastriesPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel37)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel38))
                            .addGroup(pastriesPanel1Layout.createSequentialGroup()
                                .addComponent(chocolateChipCookieButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(cinnamonRollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pastriesPanel1Layout.setVerticalGroup(
            pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cheeseRollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pastriesPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(70, 70, 70)
                        .addComponent(croissantButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(blueberryMuffinButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(43, 43, 43)
                .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chocolateChipCookieButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cinnamonRollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pastriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addGap(37, 37, 37))
        );

        coldCoffeePanel1.setBackground(new java.awt.Color(239, 233, 233));

        jLabel39.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel39.setText("Cold Coffees");

        icedWhiteMochaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedWhiteMochaButton1ActionPerformed(evt);
            }
        });

        icedHazelnutCoffee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedHazelnutCoffee1ActionPerformed(evt);
            }
        });

        spanishLatteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishLatteButton1ActionPerformed(evt);
            }
        });

        icedMatchaEspressoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedMatchaEspressoButton1ActionPerformed(evt);
            }
        });

        icedCoffeeJellyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedCoffeeJellyButton1ActionPerformed(evt);
            }
        });

        jLabel40.setText("Iced Coffee Jelly");

        jLabel41.setText("Iced White Mocha");

        jLabel42.setText("Iced Hazelnut Coffee");

        jLabel43.setText("Spanish Latte");

        jLabel44.setText("Iced Matcha Espresso");

        javax.swing.GroupLayout coldCoffeePanel1Layout = new javax.swing.GroupLayout(coldCoffeePanel1);
        coldCoffeePanel1.setLayout(coldCoffeePanel1Layout);
        coldCoffeePanel1Layout.setHorizontalGroup(
            coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel39))
                    .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coldCoffeePanel1Layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel44))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coldCoffeePanel1Layout.createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(spanishLatteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(113, 113, 113)
                            .addComponent(icedMatchaEspressoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coldCoffeePanel1Layout.createSequentialGroup()
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(icedCoffeeJellyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(icedWhiteMochaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel40)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icedHazelnutCoffee1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(101, 101, 101))
        );
        coldCoffeePanel1Layout.setVerticalGroup(
            coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icedHazelnutCoffee1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(coldCoffeePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(48, 48, 48)
                        .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(icedWhiteMochaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icedCoffeeJellyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(50, 50, 50)
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spanishLatteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icedMatchaEspressoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coldCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        hotCoffeePanel1.setBackground(new java.awt.Color(239, 233, 233));

        jLabel45.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel45.setText("Hot Coffees");

        americanoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                americanoButton1ActionPerformed(evt);
            }
        });

        latteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latteButton1ActionPerformed(evt);
            }
        });

        cappuccinoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cappuccinoButton1ActionPerformed(evt);
            }
        });

        brewedCoffeeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brewedCoffeeButton1ActionPerformed(evt);
            }
        });

        hotCaramelMacchiatoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotCaramelMacchiatoButton1ActionPerformed(evt);
            }
        });

        jLabel46.setText("Americano");

        jLabel47.setText("Hot Caramel Macchiato");

        jLabel48.setText("Latte");

        jLabel49.setText("Cappuccino");

        jLabel50.setText("Brewed Coffee");

        javax.swing.GroupLayout hotCoffeePanel1Layout = new javax.swing.GroupLayout(hotCoffeePanel1);
        hotCoffeePanel1.setLayout(hotCoffeePanel1Layout);
        hotCoffeePanel1Layout.setHorizontalGroup(
            hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(americanoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(hotCaramelMacchiatoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(latteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel46)
                .addGap(142, 142, 142)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addGap(143, 143, 143))
            .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                .addGroup(hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(cappuccinoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(brewedCoffeeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel49)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel50)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hotCoffeePanel1Layout.setVerticalGroup(
            hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hotCoffeePanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(americanoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(latteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hotCaramelMacchiatoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hotCoffeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(55, 55, 55)
                        .addComponent(cappuccinoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel49)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hotCoffeePanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brewedCoffeeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addGap(58, 58, 58))))
        );

        jLabel51.setText("Full Name");

        jLabel52.setText("City");

        jLabel53.setText("Address");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel54.setText("Billing Address");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel55.setText("Payment");

        jButton5.setText("gcash");

        jButton6.setText("paypall");

        jRadioButton1.setText("jRadioButton1");

        jLayeredPane1.setLayer(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel53, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel54, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel55, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jRadioButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jLabel55)
                        .addGap(92, 92, 92))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(53, 53, 53)
                        .addComponent(jButton6)
                        .addGap(42, 42, 42))))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jRadioButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel51))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addGap(51, 51, 51)
                .addComponent(jLabel53)
                .addGap(69, 69, 69)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(83, 83, 83))
        );

        receiptInternalFrame.setTitle("Receipt");
        receiptInternalFrame.setVisible(true);

        jLabel64.setText("Full Name");

        jLabel65.setText("Address");

        jLabel66.setText("City");

        javax.swing.GroupLayout receiptInternalFrameLayout = new javax.swing.GroupLayout(receiptInternalFrame.getContentPane());
        receiptInternalFrame.getContentPane().setLayout(receiptInternalFrameLayout);
        receiptInternalFrameLayout.setHorizontalGroup(
            receiptInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptInternalFrameLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(receiptInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel65)
                    .addComponent(jLabel64))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        receiptInternalFrameLayout.setVerticalGroup(
            receiptInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptInternalFrameLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addGap(18, 18, 18)
                .addComponent(jLabel66)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(813, 606));
        setResizable(false);
        getContentPane().setLayout(null);

        panelHome.setBackground(new java.awt.Color(239, 233, 233));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHome.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, 860, 1));

        jTabbedPanel.setBackground(new java.awt.Color(239, 233, 233));

        tab1.setBackground(new java.awt.Color(239, 233, 233));

        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jButton1.setText("Order Now");
        jButton1.setPreferredSize(new java.awt.Dimension(77, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Best Products");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        productName.setFont(new java.awt.Font("Poppins Light", 3, 30)); // NOI18N
        productName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productName.setText("Product name ");
        productName.setToolTipText("");
        productName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        productDescription.setFont(new java.awt.Font("Poppins Light", 0, 20)); // NOI18N
        productDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productDescription.setText("Product Description");

        productImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        rightButton.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        rightButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rightButton.setPreferredSize(new java.awt.Dimension(85, 23));
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        leftButton.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        leftButton.setToolTipText("");
        leftButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButton.setPreferredSize(new java.awt.Dimension(85, 23));
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(393, 393, 393))))
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 140, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTabbedPanel.addTab("tab5", tab1);

        tab2.setBackground(new java.awt.Color(239, 233, 233));
        tab2.setLayout(null);

        categoryBack.setText("Back");
        categoryBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBackActionPerformed(evt);
            }
        });
        tab2.add(categoryBack);
        categoryBack.setBounds(80, 30, 75, 23);

        hotCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel11.setText("Hot Coffees");

        americanoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                americanoButtonActionPerformed(evt);
            }
        });

        latteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latteButtonActionPerformed(evt);
            }
        });

        cappuccinoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cappuccinoButtonActionPerformed(evt);
            }
        });

        brewedCoffeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brewedCoffeeButtonActionPerformed(evt);
            }
        });

        hotCaramelMacchiatoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotCaramelMacchiatoButtonActionPerformed(evt);
            }
        });

        jLabel16.setText("Americano");

        jLabel19.setText("Hot Caramel Macchiato");

        jLabel20.setText("Latte");

        jLabel21.setText("Cappuccino");

        jLabel22.setText("Brewed Coffee");

        javax.swing.GroupLayout hotCoffeePanelLayout = new javax.swing.GroupLayout(hotCoffeePanel);
        hotCoffeePanel.setLayout(hotCoffeePanelLayout);
        hotCoffeePanelLayout.setHorizontalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(hotCaramelMacchiatoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(latteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel16)
                .addGap(142, 142, 142)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(143, 143, 143))
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(cappuccinoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(brewedCoffeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel21)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hotCoffeePanelLayout.setVerticalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(latteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hotCaramelMacchiatoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(55, 55, 55)
                        .addComponent(cappuccinoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hotCoffeePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brewedCoffeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(58, 58, 58))))
        );

        tab2.add(hotCoffeePanel);
        hotCoffeePanel.setBounds(10, 110, 760, 490);

        coldCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel12.setText("Cold Coffees");

        icedWhiteMochaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedWhiteMochaButtonActionPerformed(evt);
            }
        });

        icedHazelnutCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedHazelnutCoffeeActionPerformed(evt);
            }
        });

        spanishLatteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishLatteButtonActionPerformed(evt);
            }
        });

        icedMatchaEspressoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedMatchaEspressoButtonActionPerformed(evt);
            }
        });

        icedCoffeeJellyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icedCoffeeJellyButtonActionPerformed(evt);
            }
        });

        jLabel23.setText("Iced Coffee Jelly");

        jLabel24.setText("Iced White Mocha");

        jLabel25.setText("Iced Hazelnut Coffee");

        jLabel26.setText("Spanish Latte");

        jLabel27.setText("Iced Matcha Espresso");

        javax.swing.GroupLayout coldCoffeePanelLayout = new javax.swing.GroupLayout(coldCoffeePanel);
        coldCoffeePanel.setLayout(coldCoffeePanelLayout);
        coldCoffeePanelLayout.setHorizontalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coldCoffeePanelLayout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coldCoffeePanelLayout.createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(spanishLatteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(113, 113, 113)
                            .addComponent(icedMatchaEspressoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coldCoffeePanelLayout.createSequentialGroup()
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(icedCoffeeJellyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(icedWhiteMochaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel23)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icedHazelnutCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(101, 101, 101))
        );
        coldCoffeePanelLayout.setVerticalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icedHazelnutCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(48, 48, 48)
                        .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(icedWhiteMochaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icedCoffeeJellyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(50, 50, 50)
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spanishLatteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icedMatchaEspressoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        tab2.add(coldCoffeePanel);
        coldCoffeePanel.setBounds(10, 110, 760, 490);

        pastriesPanel.setBackground(new java.awt.Color(239, 233, 233));

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel13.setText("Pastries");

        croissantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                croissantButtonActionPerformed(evt);
            }
        });

        cheeseRollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheeseRollButtonActionPerformed(evt);
            }
        });

        chocolateChipCookieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chocolateChipCookieButtonActionPerformed(evt);
            }
        });

        cinnamonRollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinnamonRollButtonActionPerformed(evt);
            }
        });

        blueberryMuffinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueberryMuffinButtonActionPerformed(evt);
            }
        });

        jLabel28.setText("Blueberry Muffin");

        jLabel29.setText("Croissant");

        jLabel30.setText("Cheese Roll");

        jLabel31.setText("Chocolate Chip Cookie ");

        jLabel32.setText("Cinnamon Roll");

        javax.swing.GroupLayout pastriesPanelLayout = new javax.swing.GroupLayout(pastriesPanel);
        pastriesPanel.setLayout(pastriesPanelLayout);
        pastriesPanelLayout.setHorizontalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(blueberryMuffinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(croissantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(cheeseRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel28)
                .addGap(159, 159, 159)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(154, 154, 154))
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pastriesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(pastriesPanelLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pastriesPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel31)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel32))
                            .addGroup(pastriesPanelLayout.createSequentialGroup()
                                .addComponent(chocolateChipCookieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(cinnamonRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pastriesPanelLayout.setVerticalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cheeseRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pastriesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(70, 70, 70)
                        .addComponent(croissantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(blueberryMuffinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(43, 43, 43)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chocolateChipCookieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cinnamonRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(37, 37, 37))
        );

        tab2.add(pastriesPanel);
        pastriesPanel.setBounds(10, 110, 760, 490);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel7.setText("Categories");
        tab2.add(jLabel7);
        jLabel7.setBounds(10, 110, 110, 30);

        jLabel3.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Best Products");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab2.add(jLabel3);
        jLabel3.setBounds(238, 27, 261, 47);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pastries");
        tab2.add(jLabel6);
        jLabel6.setBounds(240, 200, 70, 40);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hot Coffee");
        tab2.add(jLabel5);
        jLabel5.setBounds(130, 200, 70, 40);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Iced Coffee");
        tab2.add(jLabel4);
        jLabel4.setBounds(20, 200, 70, 40);

        Pastries.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Pastries.setToolTipText("");
        Pastries.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pastries.setPreferredSize(new java.awt.Dimension(85, 23));
        Pastries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastriesActionPerformed(evt);
            }
        });
        tab2.add(Pastries);
        Pastries.setBounds(230, 150, 90, 90);

        IcedCoffee.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee.setToolTipText("");
        IcedCoffee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffeeActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee);
        IcedCoffee.setBounds(10, 150, 90, 90);

        HotCoffee.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        HotCoffee.setToolTipText("");
        HotCoffee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HotCoffee.setPreferredSize(new java.awt.Dimension(85, 23));
        HotCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCoffeeActionPerformed(evt);
            }
        });
        tab2.add(HotCoffee);
        HotCoffee.setBounds(120, 150, 90, 90);

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel8.setText("Popular Picks");
        tab2.add(jLabel8);
        jLabel8.setBounds(10, 260, 120, 26);

        IcedCoffee2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee2.setToolTipText("");
        IcedCoffee2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee2.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee2ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee2);
        IcedCoffee2.setBounds(490, 300, 140, 160);

        IcedCoffee3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee3.setToolTipText("");
        IcedCoffee3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee3.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee3ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee3);
        IcedCoffee3.setBounds(10, 300, 140, 160);

        IcedCoffee4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee4.setToolTipText("");
        IcedCoffee4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee4.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee4ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee4);
        IcedCoffee4.setBounds(170, 300, 140, 160);

        IcedCoffee5.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee5.setToolTipText("");
        IcedCoffee5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee5.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee5ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee5);
        IcedCoffee5.setBounds(330, 300, 140, 160);

        IcedCoffee7.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee7.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee7.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee7.setText("Add to Cart");
        IcedCoffee7.setToolTipText("");
        IcedCoffee7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee7.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee7ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee7);
        IcedCoffee7.setBounds(490, 470, 140, 30);

        IcedCoffee8.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee8.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee8.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee8.setText("Add to Cart");
        IcedCoffee8.setToolTipText("");
        IcedCoffee8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee8.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee8ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee8);
        IcedCoffee8.setBounds(10, 470, 140, 30);

        IcedCoffee9.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee9.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee9.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee9.setText("Add to Cart");
        IcedCoffee9.setToolTipText("");
        IcedCoffee9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee9.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee9ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee9);
        IcedCoffee9.setBounds(170, 470, 140, 30);

        IcedCoffee10.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee10.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee10.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee10.setText("Add to Cart");
        IcedCoffee10.setToolTipText("");
        IcedCoffee10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee10.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee10ActionPerformed(evt);
            }
        });
        tab2.add(IcedCoffee10);
        IcedCoffee10.setBounds(330, 470, 140, 30);

        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jButton2.setText("Order Now");
        jButton2.setPreferredSize(new java.awt.Dimension(77, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        tab2.add(jButton2);
        jButton2.setBounds(510, 540, 110, 29);

        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab2.add(logo);
        logo.setBounds(0, 0, 0, 0);

        jTabbedPanel.addTab("tab1", tab2);

        tab3.setBackground(new java.awt.Color(239, 233, 233));
        tab3.setLayout(null);

        billingPanel.setLayout(null);

        jLabel56.setText("Full Name");
        billingPanel.add(jLabel56);
        jLabel56.setBounds(32, 89, 54, 16);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("text area\n");
        jScrollPane3.setViewportView(jTextArea2);

        billingPanel.add(jScrollPane3);
        jScrollPane3.setBounds(32, 203, 137, 28);

        jLabel57.setText("Address");
        billingPanel.add(jLabel57);
        jLabel57.setBounds(32, 175, 42, 16);

        jLabel58.setText("City");
        billingPanel.add(jLabel58);
        jLabel58.setBounds(32, 261, 21, 16);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Pickup");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        billingPanel.add(jRadioButton2);
        jRadioButton2.setBounds(67, 406, 59, 21);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Delivery");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        billingPanel.add(jRadioButton3);
        jRadioButton3.setBounds(144, 406, 65, 21);

        jLabel59.setText("Phone Number");
        billingPanel.add(jLabel59);
        jLabel59.setBounds(32, 337, 234, 16);

        jTextField1.setText("jTextField1");
        billingPanel.add(jTextField1);
        jTextField1.setBounds(32, 363, 234, 22);

        jTextField2.setText("jTextField1");
        billingPanel.add(jTextField2);
        jTextField2.setBounds(32, 283, 234, 22);

        jTextField3.setText("jTextField1");
        billingPanel.add(jTextField3);
        jTextField3.setBounds(32, 117, 234, 22);

        adw.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        adw.setText("Payment");
        billingPanel.add(adw);
        adw.setBounds(380, 30, 137, 48);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel61.setText("Billing");
        billingPanel.add(jLabel61);
        jLabel61.setBounds(92, 35, 129, 48);

        jButton7.setText("Gcash");
        billingPanel.add(jButton7);
        jButton7.setBounds(359, 89, 72, 23);

        jButton8.setText("Cash");
        billingPanel.add(jButton8);
        jButton8.setBounds(500, 90, 72, 23);

        jButton9.setText("Proceed to Checkout");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        billingPanel.add(jButton9);
        jButton9.setBounds(360, 400, 243, 23);

        jButton10.setText("close");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        billingPanel.add(jButton10);
        jButton10.setBounds(543, 6, 72, 23);

        jLabel62.setText("Amount to Pay");
        billingPanel.add(jLabel62);
        jLabel62.setBounds(400, 350, 80, 16);

        jLabel63.setText("Total");
        billingPanel.add(jLabel63);
        jLabel63.setBounds(520, 350, 27, 16);

        currentOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order", "Size", "Quantity", "Price"
            }
        ));
        jScrollPane2.setViewportView(currentOrderTable);

        billingPanel.add(jScrollPane2);
        jScrollPane2.setBounds(360, 130, 230, 210);

        tab3.add(billingPanel);
        billingPanel.setBounds(0, 0, 0, 0);

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order", "Size", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(cartTable);

        tab3.add(jScrollPane1);
        jScrollPane1.setBounds(148, 148, 340, 321);

        jButton3.setText("Proceed to Billing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        tab3.add(jButton3);
        jButton3.setBounds(257, 523, 123, 23);

        jLabel9.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Your Orders");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab3.add(jLabel9);
        jLabel9.setBounds(204, 24, 261, 47);

        jLabel18.setText("Total");
        tab3.add(jLabel18);
        jLabel18.setBounds(306, 487, 39, 16);

        lblTotal.setText("jLabel19");
        tab3.add(lblTotal);
        lblTotal.setBounds(389, 487, 43, 16);

        clearAll.setText("Clear All");
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });
        tab3.add(clearAll);
        clearAll.setBounds(526, 437, 74, 23);

        jTabbedPanel.addTab("tab3", tab3);

        tab4.setBackground(new java.awt.Color(239, 233, 233));

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jTabbedPanel.addTab("tab4", tab4);

        tab5.setBackground(new java.awt.Color(239, 233, 233));

        americanoPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/americano.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("Size");

        jLabel15.setText("Quantity");

        jButton4.setText("Add to Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        americanoPrice.setText("135");

        jLabel17.setText("Americano");

        javax.swing.GroupLayout americanoPanelLayout = new javax.swing.GroupLayout(americanoPanel);
        americanoPanel.setLayout(americanoPanelLayout);
        americanoPanelLayout.setHorizontalGroup(
            americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(americanoPanelLayout.createSequentialGroup()
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(americanoPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, americanoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(americanoPrice)
                                .addGap(179, 179, 179)))
                        .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        americanoPanelLayout.setVerticalGroup(
            americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(americanoPanelLayout.createSequentialGroup()
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(45, 45, 45))
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(americanoPrice)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel14.setText("Your Order");

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(americanoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(americanoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPanel.addTab("tab5", tab5);

        panelHome.add(jTabbedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -40, 760, 650));

        LogoutBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });
        panelHome.add(LogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 120, -1));

        aboutBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        aboutBtn.setText("About Us");
        aboutBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });
        panelHome.add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 385, 120, -1));

        categoriesBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        categoriesBtn.setText("Menu");
        categoriesBtn.setAlignmentY(0.0F);
        categoriesBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        categoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesBtnActionPerformed(evt);
            }
        });
        panelHome.add(categoriesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 205, 120, -1));

        homeBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        homeBtn.setText("Home");
        homeBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        panelHome.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 120, -1));

        cartBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        cartBtn.setText("Cart");
        cartBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });
        panelHome.add(cartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 295, 120, -1));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

        panelHome.add(roundedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 567));

        getContentPane().add(panelHome);
        panelHome.setBounds(0, 0, 930, 600);

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


        // Get original image
        Image originalImage = icon.getImage();

        // Calculate scaled dimensions while preserving aspect ratio
        int labelWidth = productImage.getWidth();
        int labelHeight = productImage.getHeight();

        int imgWidth = icon.getIconWidth();
        int imgHeight = icon.getIconHeight();

        float widthRatio = (float) labelWidth / imgWidth;
        float heightRatio = (float) labelHeight / imgHeight;
        float scaleFactor = Math.min(widthRatio, heightRatio);

        int newWidth = Math.round(imgWidth * scaleFactor);
        int newHeight = Math.round(imgHeight * scaleFactor);

        // Scale image smoothly and maintain aspect ratio
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Set scaled image to label
        productImage.setIcon(new ImageIcon(scaledImage));
        productName.setText(productNames[currentIndex]);
        productDescription.setText(productDescriptions[currentIndex]);
}
    
    
    private ImageIcon getScaledIcon(String path, int size) {
    ImageIcon icon = new ImageIcon(getClass().getResource(path));
    Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
    return new ImageIcon(img);
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void saveOrderToDatabase(int userId, List<OrderItem> orderItems) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_user_database", "root", "");

            String sql = "INSERT INTO orders (user_id, item_name, size, quantity, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            for (OrderItem item : orderItems) {
                stmt.setInt(1, userId);
                stmt.setString(2, item.name);
                stmt.setString(3, item.size);
                stmt.setInt(4, item.quantity);
                stmt.setDouble(5, item.price);
                stmt.executeUpdate();
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving order: " + e.getMessage());
        }
    }
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        currentIndex++;
        if (currentIndex >= imageNames.length) currentIndex = 0;
        updateDisplay();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtnActionPerformed
        jTabbedPanel.setSelectedIndex(3);
    }//GEN-LAST:event_aboutBtnActionPerformed

    private void cartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtnActionPerformed
        jTabbedPanel.setSelectedIndex(2);
    }//GEN-LAST:event_cartBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        jTabbedPanel.setSelectedIndex(0);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        currentIndex--;
        if (currentIndex < 0) currentIndex = imageNames.length - 1;
        updateDisplay();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void categoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesBtnActionPerformed
        jTabbedPanel.setSelectedIndex(1);
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
        categoryBack.setVisible(false);
    }//GEN-LAST:event_categoriesBtnActionPerformed

    private void PastriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastriesActionPerformed
        pastriesPanel.setVisible(true);
        categoryBack.setVisible(true);
    }//GEN-LAST:event_PastriesActionPerformed

    private void IcedCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffeeActionPerformed
        coldCoffeePanel.setVisible(true);
        categoryBack.setVisible(true);
    }//GEN-LAST:event_IcedCoffeeActionPerformed

    private void HotCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCoffeeActionPerformed
        hotCoffeePanel.setVisible(true);
        categoryBack.setVisible(true);
    }//GEN-LAST:event_HotCoffeeActionPerformed

    private void IcedCoffee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee2ActionPerformed

    private void IcedCoffee3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee3ActionPerformed

    private void IcedCoffee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee4ActionPerformed

    private void IcedCoffee5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee5ActionPerformed

    private void IcedCoffee7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee7ActionPerformed

    private void IcedCoffee8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee8ActionPerformed

    private void IcedCoffee9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee9ActionPerformed

    private void IcedCoffee10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPanel.setSelectedIndex(3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        billingPanel.setVisible(true);
        saveOrderToDatabase(currentUserId, cart);
        try {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_user_database", "root", ""
        );

        String sql = "SELECT item_name, size, quantity, price FROM orders WHERE user_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, currentUserId); // Uses stored user ID
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();
        model.setRowCount(0); // Clear table

        boolean hasOrders = false;
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("item_name"),
                rs.getString("size"),
                rs.getInt("quantity"),
                rs.getDouble("price")
            });
            hasOrders = true;
        }

        if (!hasOrders) {
            JOptionPane.showMessageDialog(this, "No orders found for your account.");
        }

        rs.close();
        pst.close();
        con.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading orders: " + ex.getMessage());
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void categoryBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBackActionPerformed
        jTabbedPanel.setSelectedIndex(1);
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
    }//GEN-LAST:event_categoryBackActionPerformed

    private void sizeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBoxActionPerformed

    private void americanoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_americanoButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        americanoPanel.setVisible(true);
    }//GEN-LAST:event_americanoButtonActionPerformed
    

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String size = sizeComboBox.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner.getValue();
        double basePrice = 135; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Americano", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Americano (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllActionPerformed
        cartModel.setRowCount(0); 
        cart.clear();             
        updateTotal();
    }//GEN-LAST:event_clearAllActionPerformed

    private void latteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latteButtonActionPerformed

    private void cappuccinoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cappuccinoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cappuccinoButtonActionPerformed

    private void brewedCoffeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brewedCoffeeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brewedCoffeeButtonActionPerformed

    private void hotCaramelMacchiatoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotCaramelMacchiatoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotCaramelMacchiatoButtonActionPerformed

    private void icedWhiteMochaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedWhiteMochaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedWhiteMochaButtonActionPerformed

    private void icedHazelnutCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedHazelnutCoffeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedHazelnutCoffeeActionPerformed

    private void spanishLatteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishLatteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spanishLatteButtonActionPerformed

    private void icedMatchaEspressoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedMatchaEspressoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedMatchaEspressoButtonActionPerformed

    private void icedCoffeeJellyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedCoffeeJellyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedCoffeeJellyButtonActionPerformed

    private void croissantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_croissantButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_croissantButtonActionPerformed

    private void cheeseRollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheeseRollButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cheeseRollButtonActionPerformed

    private void chocolateChipCookieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocolateChipCookieButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chocolateChipCookieButtonActionPerformed

    private void cinnamonRollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinnamonRollButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cinnamonRollButtonActionPerformed

    private void blueberryMuffinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueberryMuffinButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueberryMuffinButtonActionPerformed

    private void croissantButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_croissantButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_croissantButton1ActionPerformed

    private void cheeseRollButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheeseRollButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cheeseRollButton1ActionPerformed

    private void chocolateChipCookieButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocolateChipCookieButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chocolateChipCookieButton1ActionPerformed

    private void cinnamonRollButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinnamonRollButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cinnamonRollButton1ActionPerformed

    private void blueberryMuffinButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueberryMuffinButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueberryMuffinButton1ActionPerformed

    private void icedWhiteMochaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedWhiteMochaButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedWhiteMochaButton1ActionPerformed

    private void icedHazelnutCoffee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedHazelnutCoffee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedHazelnutCoffee1ActionPerformed

    private void spanishLatteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishLatteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spanishLatteButton1ActionPerformed

    private void icedMatchaEspressoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedMatchaEspressoButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedMatchaEspressoButton1ActionPerformed

    private void icedCoffeeJellyButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedCoffeeJellyButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icedCoffeeJellyButton1ActionPerformed

    private void americanoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_americanoButton1ActionPerformed
  
    }//GEN-LAST:event_americanoButton1ActionPerformed

    private void latteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latteButton1ActionPerformed

    private void cappuccinoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cappuccinoButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cappuccinoButton1ActionPerformed

    private void brewedCoffeeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brewedCoffeeButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brewedCoffeeButton1ActionPerformed

    private void hotCaramelMacchiatoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotCaramelMacchiatoButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotCaramelMacchiatoButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        billingPanel.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed
    
    private void updateTotal() {
        double total = 0;
        for (OrderItem item : cart) {
            total += item.getPrice();
        }
        lblTotal.setText("₱" + String.format("%.2f", total));
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
    private javax.swing.JButton HotCoffee;
    private javax.swing.JButton IcedCoffee;
    private javax.swing.JButton IcedCoffee10;
    private javax.swing.JButton IcedCoffee2;
    private javax.swing.JButton IcedCoffee3;
    private javax.swing.JButton IcedCoffee4;
    private javax.swing.JButton IcedCoffee5;
    private javax.swing.JButton IcedCoffee7;
    private javax.swing.JButton IcedCoffee8;
    private javax.swing.JButton IcedCoffee9;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton Pastries;
    private javax.swing.JButton aboutBtn;
    private javax.swing.JLabel adw;
    private javax.swing.JButton americanoButton;
    private javax.swing.JButton americanoButton1;
    private javax.swing.JPanel americanoPanel;
    private javax.swing.JLabel americanoPrice;
    private javax.swing.JPanel billingPanel;
    private javax.swing.JButton blueberryMuffinButton;
    private javax.swing.JButton blueberryMuffinButton1;
    private javax.swing.JButton brewedCoffeeButton;
    private javax.swing.JButton brewedCoffeeButton1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cappuccinoButton;
    private javax.swing.JButton cappuccinoButton1;
    private javax.swing.JButton cartBtn;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JButton categoryBack;
    private javax.swing.JButton cheeseRollButton;
    private javax.swing.JButton cheeseRollButton1;
    private javax.swing.JButton chocolateChipCookieButton;
    private javax.swing.JButton chocolateChipCookieButton1;
    private javax.swing.JButton cinnamonRollButton;
    private javax.swing.JButton cinnamonRollButton1;
    private javax.swing.JButton clearAll;
    private javax.swing.JPanel coldCoffeePanel;
    private javax.swing.JPanel coldCoffeePanel1;
    private javax.swing.JButton croissantButton;
    private javax.swing.JButton croissantButton1;
    private javax.swing.JTable currentOrderTable;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton hotCaramelMacchiatoButton;
    private javax.swing.JButton hotCaramelMacchiatoButton1;
    private javax.swing.JPanel hotCoffeePanel;
    private javax.swing.JPanel hotCoffeePanel1;
    private javax.swing.JButton icedCoffeeJellyButton;
    private javax.swing.JButton icedCoffeeJellyButton1;
    private javax.swing.JButton icedHazelnutCoffee;
    private javax.swing.JButton icedHazelnutCoffee1;
    private javax.swing.JButton icedMatchaEspressoButton;
    private javax.swing.JButton icedMatchaEspressoButton1;
    private javax.swing.JButton icedWhiteMochaButton;
    private javax.swing.JButton icedWhiteMochaButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPanel;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton latteButton;
    private javax.swing.JButton latteButton1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton leftButton;
    private javax.swing.JPanel line;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel pastriesPanel;
    private javax.swing.JPanel pastriesPanel1;
    private javax.swing.JLabel productDescription;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productName;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JInternalFrame receiptInternalFrame;
    private javax.swing.JButton rightButton;
    private javax.swing.JPanel roundedPanel;
    private javax.swing.JComboBox<String> sizeComboBox;
    private javax.swing.JButton spanishLatteButton;
    private javax.swing.JButton spanishLatteButton1;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
