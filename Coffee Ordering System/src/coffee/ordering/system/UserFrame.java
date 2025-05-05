
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



public class UserFrame extends javax.swing.JFrame {
    
    
    
    private String[] imageNames = {"diwata.png", "hiwaga.png", "romnick.png"}; 
    private String[] productNames = {"<html>Spanish Latte</html>", "<html>Hot Coffee</html>", "<html>Croissant</html>"};
    private String[] productDescriptions = {"<html>The perfect blend of bold and breezy.</html>", "<html>The only thing warmer than your smile? This perfectly brewed cup.</html>", "<html>Treat yourself to a little piece of Paris.</html>"};
    private int currentIndex = 0;
    
    String[] categories = {"Choose", "Main Courses", "Desserts"};
   
    public UserFrame() {
        initComponents();
        updateDisplay();
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
        categoryBack.setVisible(false);//back button
        americanoPanel.setVisible(false);
        
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
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
        coldCoffeePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pastriesPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        tab5 = new javax.swing.JPanel();
        americanoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sizeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
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

        javax.swing.GroupLayout hotCoffeePanelLayout = new javax.swing.GroupLayout(hotCoffeePanel);
        hotCoffeePanel.setLayout(hotCoffeePanelLayout);
        hotCoffeePanelLayout.setHorizontalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        hotCoffeePanelLayout.setVerticalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        tab2.add(hotCoffeePanel);
        hotCoffeePanel.setBounds(10, 110, 760, 490);

        coldCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel12.setText("Cold Coffees");

        javax.swing.GroupLayout coldCoffeePanelLayout = new javax.swing.GroupLayout(coldCoffeePanel);
        coldCoffeePanel.setLayout(coldCoffeePanelLayout);
        coldCoffeePanelLayout.setHorizontalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(639, Short.MAX_VALUE))
        );
        coldCoffeePanelLayout.setVerticalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(458, Short.MAX_VALUE))
        );

        tab2.add(coldCoffeePanel);
        coldCoffeePanel.setBounds(10, 110, 760, 490);

        pastriesPanel.setBackground(new java.awt.Color(239, 233, 233));

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel13.setText("Pastries");

        javax.swing.GroupLayout pastriesPanelLayout = new javax.swing.GroupLayout(pastriesPanel);
        pastriesPanel.setLayout(pastriesPanelLayout);
        pastriesPanelLayout.setHorizontalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(682, Short.MAX_VALUE))
        );
        pastriesPanelLayout.setVerticalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(458, Short.MAX_VALUE))
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
        jLabel5.setBounds(20, 200, 70, 40);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Iced Coffee");
        tab2.add(jLabel4);
        jLabel4.setBounds(130, 200, 70, 40);

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order", "Quantity", "Size", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Proceed to Billing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Your Orders");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jButton3))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton3)
                .addContainerGap(89, Short.MAX_VALUE))
        );

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

        jLabel16.setText("135");

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
                                .addComponent(jLabel16)
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
                        .addComponent(jLabel16)
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
        panelHome.setBounds(0, 0, 970, 600);

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
        BillingFrame billingFrame = new BillingFrame();
        billingFrame.setVisible(true);
        billingFrame.pack();
        billingFrame.setLocationRelativeTo(null); 
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
    private javax.swing.JButton americanoButton;
    private javax.swing.JPanel americanoPanel;
    private javax.swing.JButton cartBtn;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JButton categoryBack;
    private javax.swing.JPanel coldCoffeePanel;
    private javax.swing.JButton homeBtn;
    private javax.swing.JPanel hotCoffeePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPanel;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton leftButton;
    private javax.swing.JPanel line;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel pastriesPanel;
    private javax.swing.JLabel productDescription;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productName;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton rightButton;
    private javax.swing.JPanel roundedPanel;
    private javax.swing.JComboBox<String> sizeComboBox;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
