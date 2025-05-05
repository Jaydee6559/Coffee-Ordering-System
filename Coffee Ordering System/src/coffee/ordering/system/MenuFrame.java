
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



public class MenuFrame extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    
    private String[] imageNames = {"diwata.png", "hiwaga.png", "romnick.png"}; 
    private String[] productNames = {"<html>Spanish Latte</html>", "<html>Hot Coffee</html>", "<html>Croissant</html>"};
    private String[] productDescriptions = {"<html>The perfect blend of bold and breezy.</html>", "<html>The only thing warmer than your smile? This perfectly brewed cup.</html>", "<html>Treat yourself to a little piece of Paris.</html>"};
    private int currentIndex = 0;
    
    String[] categories = {"Choose", "Main Courses", "Desserts"};
   
    public MenuFrame() {
        initComponents();
        cardLayout = (CardLayout)(getContentPane().getLayout());
        cartPanel.setVisible(false);
        cartPanel1.setVisible(false);
        int logoSize = 110;
        logo.setIcon(getScaledIcon("/images/logo.png", logoSize, logoSize));
        int iconSize = 15; // You can use 48 or 64 depending on desired size
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        aboutBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        HotCoffee1 = new javax.swing.JButton();
        IcedCoffee1 = new javax.swing.JButton();
        Pastries1 = new javax.swing.JButton();
        categoriesBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        cartBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        roundedPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pastries = new javax.swing.JButton();
        IcedCoffee = new javax.swing.JButton();
        HotCoffee = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Pastries2 = new javax.swing.JButton();
        IcedCoffee2 = new javax.swing.JButton();
        IcedCoffee3 = new javax.swing.JButton();
        IcedCoffee4 = new javax.swing.JButton();
        IcedCoffee5 = new javax.swing.JButton();
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
        setTitle("MENU");
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(813, 606));
        setResizable(false);
        getContentPane().setLayout(null);

        panelHome.setBackground(new java.awt.Color(239, 233, 233));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelHome.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 7, 160, 90));

        cartPanel.setLayout(new javax.swing.OverlayLayout(cartPanel));
        panelHome.add(cartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, -50, 160, 320));

        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jButton1.setText("Order Now");
        jButton1.setPreferredSize(new java.awt.Dimension(77, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHome.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 120, -1));

        LogoutBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });
        panelHome.add(LogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 120, -1));

        jLabel2.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Best Products");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 810, -1));

        aboutBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        aboutBtn.setText("About Us");
        aboutBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });
        panelHome.add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 385, 120, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Name");
        panelHome.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 70, 40));

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Name");
        panelHome.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 70, 40));

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Name");
        panelHome.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 70, 40));

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Name");
        panelHome.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 70, 40));

        HotCoffee1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        HotCoffee1.setToolTipText("");
        HotCoffee1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HotCoffee1.setPreferredSize(new java.awt.Dimension(85, 23));
        HotCoffee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCoffee1ActionPerformed(evt);
            }
        });
        panelHome.add(HotCoffee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 140, 160));

        IcedCoffee1.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee1.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee1.setText("Add to Cart");
        IcedCoffee1.setToolTipText("");
        IcedCoffee1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee1.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee1ActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 130, 30));

        Pastries1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Pastries1.setToolTipText("");
        Pastries1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pastries1.setPreferredSize(new java.awt.Dimension(85, 23));
        Pastries1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pastries1ActionPerformed(evt);
            }
        });
        panelHome.add(Pastries1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 130, 160));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHome.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, 860, 1));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHome.add(roundedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 567));

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pastries");
        panelHome.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 70, 40));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hot Coffee");
        panelHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 70, 40));

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iced Coffee");
        panelHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 70, 40));

        Pastries.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Pastries.setToolTipText("");
        Pastries.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pastries.setPreferredSize(new java.awt.Dimension(85, 23));
        Pastries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastriesActionPerformed(evt);
            }
        });
        panelHome.add(Pastries, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 90, 90));

        IcedCoffee.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee.setToolTipText("");
        IcedCoffee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffeeActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 90, 90));

        HotCoffee.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        HotCoffee.setToolTipText("");
        HotCoffee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HotCoffee.setPreferredSize(new java.awt.Dimension(85, 23));
        HotCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCoffeeActionPerformed(evt);
            }
        });
        panelHome.add(HotCoffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 90, 90));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel4.setText("Popular Picks");
        panelHome.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 170, 60));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel7.setText("Categories");
        panelHome.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 170, 60));

        Pastries2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        Pastries2.setToolTipText("");
        Pastries2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pastries2.setPreferredSize(new java.awt.Dimension(85, 23));
        Pastries2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pastries2ActionPerformed(evt);
            }
        });
        panelHome.add(Pastries2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 130, 160));

        IcedCoffee2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee2.setToolTipText("");
        IcedCoffee2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee2.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee2ActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 140, 160));

        IcedCoffee3.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee3.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee3.setText("Add to Cart");
        IcedCoffee3.setToolTipText("");
        IcedCoffee3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee3.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee3ActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 140, 30));

        IcedCoffee4.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee4.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee4.setText("Add to Cart");
        IcedCoffee4.setToolTipText("");
        IcedCoffee4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee4.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee4ActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 140, 30));

        IcedCoffee5.setBackground(new java.awt.Color(138, 80, 43));
        IcedCoffee5.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        IcedCoffee5.setForeground(new java.awt.Color(255, 255, 255));
        IcedCoffee5.setText("Add to Cart");
        IcedCoffee5.setToolTipText("");
        IcedCoffee5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IcedCoffee5.setPreferredSize(new java.awt.Dimension(85, 23));
        IcedCoffee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedCoffee5ActionPerformed(evt);
            }
        });
        panelHome.add(IcedCoffee5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 130, 30));

        getContentPane().add(panelHome);
        panelHome.setBounds(0, 0, 890, 600);

        panelCategory.setMaximumSize(null);
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

        getContentPane().add(panelCategory);
        panelCategory.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private ImageIcon getScaledIcon(String path, int size) {
    ImageIcon icon = new ImageIcon(getClass().getResource(path));
    Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
    return new ImageIcon(img);
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout.show(getContentPane(), "card3");
    }//GEN-LAST:event_jButton1ActionPerformed

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
        cartPanel1.setVisible(!cartPanel1.isVisible());
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

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
    UserFrame UserFrame = new UserFrame(); // Instantiate your target JFrame
    UserFrame.setVisible(true);
    UserFrame.pack();    
    UserFrame.setLocationRelativeTo(null); // Center the window
    this.dispose(); 
    }//GEN-LAST:event_homeBtnActionPerformed

    private void categoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesBtnActionPerformed
    MenuFrame MenuFrame = new MenuFrame(); // Instantiate your target JFrame
    MenuFrame.setVisible(true);
    MenuFrame.pack();    
    MenuFrame.setLocationRelativeTo(null); // Center the window
    this.dispose();               // Optional: close the current window
    }//GEN-LAST:event_categoriesBtnActionPerformed

    private void PastriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PastriesActionPerformed

    private void IcedCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffeeActionPerformed

    private void HotCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCoffeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HotCoffeeActionPerformed

    private void HotCoffee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCoffee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HotCoffee1ActionPerformed

    private void IcedCoffee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedCoffee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IcedCoffee1ActionPerformed

    private void Pastries1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pastries1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pastries1ActionPerformed

    private void Pastries2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pastries2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pastries2ActionPerformed

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
                new MenuFrame().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HotCoffee;
    private javax.swing.JButton HotCoffee1;
    private javax.swing.JButton IcedCoffee;
    private javax.swing.JButton IcedCoffee1;
    private javax.swing.JButton IcedCoffee2;
    private javax.swing.JButton IcedCoffee3;
    private javax.swing.JButton IcedCoffee4;
    private javax.swing.JButton IcedCoffee5;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton LogoutBtn1;
    private javax.swing.JButton Pastries;
    private javax.swing.JButton Pastries1;
    private javax.swing.JButton Pastries2;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelCategory;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel product1;
    private javax.swing.JPanel product2;
    private javax.swing.JPanel product3;
    private javax.swing.JPanel product4;
    private javax.swing.JPanel roundedPanel;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
