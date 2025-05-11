
package coffee.ordering.system;


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
import javax.swing.SwingConstants;
import java.sql.ResultSet;




public class UserFrame extends javax.swing.JFrame {
    
    

    private String[] imageNames = {"SpanishLatte.JPG", "BrewedCoffee.JPG", "Croissant.JPG"}; 
    private String[] productNames = {"<html>Spanish Latte</html>", "<html>Brewed Coffee</html>", "<html>Croissant</html>"};
    private String[] productDescriptions = {"<html>The perfect blend of bold and breezy.</html>", "<html>The only thing warmer than your smile? This perfectly brewed cup.</html>", "<html>Treat yourself to a little piece of Paris.</html>"};
    private int currentIndex = 0;
    
    String[] categories = {"Choose", "Main Courses", "Desserts"};
    private java.util.List<OrderItem> cart = new java.util.ArrayList<>();
    private javax.swing.table.DefaultTableModel cartModel;
    private int currentUserId;
    private List<OrderItem> currentOrderList = new ArrayList<>();
    private String selectedPaymentType = "";        // "Delivery" or "Pickup"
    private String selectedPaymentMethod = "Cash";  // default to Cash
   
    
    public UserFrame() {
        initComponents();
        updateDisplay();
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
        categoryBack.setVisible(false);//back button
        americanoPanel.setVisible(false);
        HCMacchiatoPanel.setVisible(false);
        LattePanel.setVisible(false);
        CappuccinoPanel.setVisible(false);
        BrewedCoffeePanel.setVisible(false);
        IWMochaPanel.setVisible(false);
        IcedHazelnutPanel.setVisible(false);
        SpanishLattePanel.setVisible(false);
        MatchaPanel.setVisible(false);
        CoffeeJellyPanel.setVisible(false);
        CroissantPanel.setVisible(false);
        CheeseRollPanel.setVisible(false);
        CookiePanel.setVisible(false);
        CinnamonPanel.setVisible(false);
        BMuffinPanel.setVisible(false);
        jLayeredPane1.setVisible(false);
        cartLayeredPanel.setLayer(billingPickUpPanel, 100);
        cartLayeredPanel.setLayer(billingDeliveryPanel, 100);
        cartLayeredPanel.setLayer(pickupCheckoutPanel, 200);
        cartLayeredPanel.setLayer(deliveryCheckoutPanel, 200);
        
        billingPickUpPanel.setBounds(0, 0, cartLayeredPanel.getWidth(), cartLayeredPanel.getHeight());
        billingDeliveryPanel.setBounds(0, 0, cartLayeredPanel.getWidth(), cartLayeredPanel.getHeight());
        
        pickupCheckoutPanel.setBounds(0, 0, cartLayeredPanel.getWidth(), cartLayeredPanel.getHeight());
        deliveryCheckoutPanel.setBounds(0, 0, cartLayeredPanel.getWidth(), cartLayeredPanel.getHeight());
        
        billingPickUpPanel.setVisible(false);
        billingDeliveryPanel.setVisible(false);
        pickupCheckoutPanel.setVisible(false);
        deliveryCheckoutPanel.setVisible(false);
        
        cartPanell.setVisible(true);
        
        longLine.setVisible(true);
        shortLine.setVisible(true);
        
        //hot coffee
        americanoDesc.setText("<html><div style='text-align: center;'>A simple yet bold coffee drink made by diluting a shot of espresso with hot water.</div></html>");
        americanoIng.setText("<html>" + "<li>Espresso</li>" + "<li>Hot Water</li>" + "</div></html>");
        americanoDesc.setVerticalAlignment(SwingConstants.TOP);
        americanoDesc.setHorizontalAlignment(SwingConstants.CENTER);
        americanoPic.setIcon(getScaledIcon("/images/americano.JPG", 275, 275));
        americanoPic.setHorizontalAlignment(SwingConstants.CENTER);   
        americanoButton.setIcon(getScaledIcon("/images/americano.JPG", 130, 130));
        
        HCMacchiatoDesc.setText("<html><div style='text-align: center;'>Rich espresso layered with velvety steamed milk and sweet caramel drizzle—smooth, sweet, and indulgently bold.</div></html>");
        HCMacchiatoIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        HCMacchiatoDesc.setVerticalAlignment(SwingConstants.TOP);
        HCMacchiatoDesc.setHorizontalAlignment(SwingConstants.CENTER);
        HCMacchiatoPic.setIcon(getScaledIcon("/images/HCMacchiato.JPG", 275, 275));
        HCMacchiatoPic.setHorizontalAlignment(SwingConstants.CENTER); 
        hotCaramelMacchiatoButton.setIcon(getScaledIcon("/images/HCMacchiato.JPG", 130, 130));
        
        LatteDesc.setText("<html><div style='text-align: center;'>Silky steamed milk blended with a smooth shot of espresso, creating a mellow, creamy cup that's perfectly balanced.</div></html>");
        LatteIng.setText("<html>" + "<li>Espresso</li>" + "<li>Steamed Milk</li>" + "<li>Milk Foam</li>" + "</div></html>");
        LatteDesc.setVerticalAlignment(SwingConstants.TOP);
        LatteDesc.setHorizontalAlignment(SwingConstants.CENTER);
        LattePic.setIcon(getScaledIcon("/images/Latte.JPG", 275, 275));
        LattePic.setHorizontalAlignment(SwingConstants.CENTER);     
        latteButton.setIcon(getScaledIcon("/images/Latte.JPG", 130, 130));
        
        CappuccinoDesc.setText("<html><div style='text-align: center;'>A bold espresso base topped with a thick layer of frothy milk foam—light, airy, and full of flavor in every sip.</div></html>");
        CappuccinoIng.setText("<html>" + "<li>Espresso</li>" + "<li>Steamed Milk</li>" + "<li>Milk Foam</li>" + "</div></html>");
        CappuccinoDesc.setVerticalAlignment(SwingConstants.TOP);
        CappuccinoDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CappuccinoPic.setIcon(getScaledIcon("/images/Cappuccino.JPG", 275, 275));
        CappuccinoPic.setHorizontalAlignment(SwingConstants.CENTER); 
        cappuccinoButton.setIcon(getScaledIcon("/images/Cappuccino.JPG", 130, 130));
        
        BrewedCoffeeDesc.setText("<html><div style='text-align: center;'>Freshly brewed and full-bodied, this classic cup delivers a bold, aromatic experience to kickstart your day.</div></html>");
        BrewedCoffeeIng.setText("<html>" + "<li>Ground Coffee</li>" + "<li>Hot Water</li>" + "</div></html>");
        BrewedCoffeeDesc.setVerticalAlignment(SwingConstants.TOP);
        BrewedCoffeeDesc.setHorizontalAlignment(SwingConstants.CENTER);
        BrewedCoffeePic.setIcon(getScaledIcon("/images/Cappuccino.JPG", 275, 275));
        BrewedCoffeePic.setHorizontalAlignment(SwingConstants.CENTER);  
        brewedCoffeeButton.setIcon(getScaledIcon("/images/BrewedCoffee.JPG", 130, 130));
        
        //iced coffee
        IWMochaDesc.setText("<html><div style='text-align: center;'>A creamy, chilled blend of espresso and white chocolate syrup, topped with milk and ice for a smooth, sweet treat.</div></html>");
        IWMochaIng.setText("<html>" + "<li>Espresso</li>" + "<li>White Chocolate Syrup</li>" + "<li>Milk</li>" + "</div></html>");
        IWMochaDesc.setVerticalAlignment(SwingConstants.TOP);
        IWMochaDesc.setHorizontalAlignment(SwingConstants.CENTER);
        IWMochaPic.setIcon(getScaledIcon("/images/IWMocha.JPG", 275, 275));
        IWMochaPic.setHorizontalAlignment(SwingConstants.CENTER);
        icedWhiteMochaButton.setIcon(getScaledIcon("/images/IWMocha.JPG", 130, 130));
        
        IcedHazelnutDesc.setText("<html><div style='text-align: center;'>Classic iced coffee infused with rich hazelnut flavor, delivering a nutty twist on a refreshing favorite.</div></html>");
        IcedHazelnutIng.setText("<html>" + "<li>Brewed Coffe</li>" + "<li>Hazelnut Syrup</li>" + "<li>Milk</li>" + "</div></html>");
        IcedHazelnutDesc.setVerticalAlignment(SwingConstants.TOP);
        IcedHazelnutDesc.setHorizontalAlignment(SwingConstants.CENTER);
        IcedHazelnutPic.setIcon(getScaledIcon("/images/IcedHazelnut.JPG", 275, 275));
        IcedHazelnutPic.setHorizontalAlignment(SwingConstants.CENTER);
        icedHazelnutCoffee.setIcon(getScaledIcon("/images/IcedHazelnut.JPG", 130, 130));
        
        SpanishLatteDesc.setText("<html><div style='text-align: center;'>A balanced mix of bold espresso and sweetened milk served over ice, offering a smooth, indulgent flavor.</div></html>");
        SpanishLatteIng.setText("<html>" + "<li>Espresso</li>" + "<li>Steamed Milk</li>" + "<li>Condensed Milk</li>" + "</div></html>");
        SpanishLatteDesc.setVerticalAlignment(SwingConstants.TOP);
        SpanishLatteDesc.setHorizontalAlignment(SwingConstants.CENTER);
        SpanishLattePic.setIcon(getScaledIcon("/images/SpanishLatte.JPG", 275, 275));
        SpanishLattePic.setHorizontalAlignment(SwingConstants.CENTER);
        spanishLatteButton.setIcon(getScaledIcon("/images/SpanishLatte.JPG", 130, 130));
        
        MatchaDesc.setText("<html><div style='text-align: center;'>A vibrant fusion of earthy matcha and bold espresso layered over ice for a unique, energizing sip.</div></html>");
        MatchaIng.setText("<html>" + "<li>Matcha</li>" + "<li>Milk</li>" + "<li>Espresso</li>" + "</div></html>");
        MatchaDesc.setVerticalAlignment(SwingConstants.TOP);
        MatchaDesc.setHorizontalAlignment(SwingConstants.CENTER);
        MatchaPic.setIcon(getScaledIcon("/images/Matcha.JPG", 275, 275));
        MatchaPic.setHorizontalAlignment(SwingConstants.CENTER); 
        icedMatchaEspressoButton.setIcon(getScaledIcon("/images/Matcha.JPG", 130, 130));
        
        CoffeeJellyDesc.setText("<html><div style='text-align: center;'>Bold iced coffee paired with soft coffee jelly cubes, adding a fun, chewy texture to every refreshing sip.</div></html>");
        CoffeeJellyIng.setText("<html>" + "<li>Brewed Coffee</li>" + "<li>Coffee Jelly</li>" + "<li>Sweetener</li>" + "<li>Cream</li>" + "</div></html>");
        CoffeeJellyDesc.setVerticalAlignment(SwingConstants.TOP);
        CoffeeJellyDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CoffeeJellyPic.setIcon(getScaledIcon("/images/CoffeeJelly.JPG", 275, 275));
        CoffeeJellyPic.setHorizontalAlignment(SwingConstants.CENTER); 
        icedCoffeeJellyButton.setIcon(getScaledIcon("/images/CoffeeJelly.JPG", 130, 130));
     
        //pastries
        CroissantDesc.setText("<html><div style='text-align: center;'>Flaky, buttery, and golden—our classic croissant is a light and airy delight.</div></html>");
        CroissantIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        CroissantDesc.setVerticalAlignment(SwingConstants.TOP);
        CroissantDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CroissantPic.setIcon(getScaledIcon("/images/Croissant.JPG", 275, 275));
        CroissantPic.setHorizontalAlignment(SwingConstants.CENTER);  
        croissantButton.setIcon(getScaledIcon("/images/Croissant.JPG", 130, 130));
        
        CheeseRollDesc.setText("<html><div style='text-align: center;'>Soft and savory, this roll is filled with creamy cheese for a rich, satisfying bite.</div></html>");
        CheeseRollIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        CheeseRollDesc.setVerticalAlignment(SwingConstants.TOP);
        CheeseRollDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CheeseRollPic.setIcon(getScaledIcon("/images/Cheeseroll.JPG", 275, 275));
        CheeseRollPic.setHorizontalAlignment(SwingConstants.CENTER); 
        cheeseRollButton.setIcon(getScaledIcon("/images/Cheeseroll.JPG", 130, 130));
        
        CookieDesc.setText("<html><div style='text-align: center;'>Crispy on the edges, chewy in the center, and packed with melty chocolate chips.</div></html>");
        CookieIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        CookieDesc.setVerticalAlignment(SwingConstants.TOP);
        CookieDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CookiePic.setIcon(getScaledIcon("/images/Cookie.JPG", 275, 275));
        CookiePic.setHorizontalAlignment(SwingConstants.CENTER);   
        chocolateChipCookieButton.setIcon(getScaledIcon("/images/Cookie.JPG", 130, 130));
        
        CinnamonDesc.setText("<html><div style='text-align: center;'>Swirled with cinnamon sugar and topped with sweet glaze, it’s a warm, comforting classic.</div></html>");
        CinnamonIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        CinnamonDesc.setVerticalAlignment(SwingConstants.TOP);
        CinnamonDesc.setHorizontalAlignment(SwingConstants.CENTER);
        CinnamonPic.setIcon(getScaledIcon("/images/Cinnamon.JPG", 275, 275));
        CinnamonPic.setHorizontalAlignment(SwingConstants.CENTER); 
        cinnamonRollButton.setIcon(getScaledIcon("/images/Cinnamon.JPG", 130, 130));
        
        BMuffinDesc.setText("<html><div style='text-align: center;'>Moist and fluffy, bursting with juicy blueberries in every bite.</div></html>");
        BMuffinIng.setText("<html>" + "<li>1–2 shots espresso</li>" + "<li>6–8 oz hot water</li>" + "<li>Sugar or sweetener</li>" + "<li>Milk or cream</li>" + "<li>Cinnamon or cocoa</li>" + "</div></html>");
        BMuffinDesc.setVerticalAlignment(SwingConstants.TOP);
        BMuffinDesc.setHorizontalAlignment(SwingConstants.CENTER);
        BMuffinPic.setIcon(getScaledIcon("/images/BMuffin.JPG", 275, 275));
        BMuffinPic.setHorizontalAlignment(SwingConstants.CENTER);  
        blueberryMuffinButton.setIcon(getScaledIcon("/images/BMuffin.JPG", 130, 130));
        
        //misc
        int IcedCoffeeIconSize = 70;
        IcedCoffee.setIcon(getScaledIcon("/images/iced-coffee.png", IcedCoffeeIconSize));
        IcedCoffee.setHorizontalAlignment(SwingConstants.CENTER);     
        HotCoffee.setIcon(getScaledIcon("/images/coffee-cup.png", IcedCoffeeIconSize));
        HotCoffee.setHorizontalAlignment(SwingConstants.CENTER);
        Pastries.setIcon(getScaledIcon("/images/croissant.png", IcedCoffeeIconSize));
        Pastries.setHorizontalAlignment(SwingConstants.CENTER);
        popular3.setIcon(getScaledIcon("/images/Latte.JPG", 130, 130));
        popular2.setIcon(getScaledIcon("/images/IWMocha.JPG", 130, 130));
        popular1.setIcon(getScaledIcon("/images/SpanishLatte.JPG", 130, 130));
        popular4.setIcon(getScaledIcon("/images/BMuffin.JPG", 130, 130));
        
        cartModel = new DefaultTableModel(new String[]{"Order", "Quantity", "Size", "Price"}, 0);
        cartTable.setModel(cartModel);
        
        int barsitaBotSize = 110;
        barsitaBot.setIcon(getScaledIcon("/images/logo.png", barsitaBotSize, barsitaBotSize));
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
        panelHome = new javax.swing.JPanel();
        shortLine = new javax.swing.JPanel();
        longLine = new javax.swing.JPanel();
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
        categoryBack2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        categoryBack = new javax.swing.JButton();
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
        categoryBack1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Pastries = new javax.swing.JButton();
        IcedCoffee = new javax.swing.JButton();
        HotCoffee = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        popular1 = new javax.swing.JButton();
        popular2 = new javax.swing.JButton();
        popular3 = new javax.swing.JButton();
        popular4 = new javax.swing.JButton();
        jLabel125 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        cartLayeredPanel = new javax.swing.JLayeredPane();
        yourOrderLabel = new javax.swing.JLabel();
        billingDeliveryPanel = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        deliveryAddress = new javax.swing.JTextArea();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        deliveryNumber = new javax.swing.JTextField();
        deliveryCity = new javax.swing.JTextField();
        adw1 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel161 = new javax.swing.JLabel();
        showDeliveryTotal = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        currentOrderTable1 = new javax.swing.JTable();
        deliveryFullName = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        showDeliveryPaymentMethod = new javax.swing.JLabel();
        showDeliveryPaymentType = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        deliveryName = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        showDeliveryCity = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        showDeliveryAddress = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        showDeliveryNumber = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        pickupCheckoutPanel = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        deliveryCheckoutPanel = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        billingPickUpPanel = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        pickupNumber = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        showPickupTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        currentOrderTable = new javax.swing.JTable();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        pickupName = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        showPickupPaymentMethod = new javax.swing.JLabel();
        showPickupPaymentType = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        showPickupFullName = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        showPickupNumber = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        cartPanell = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        clearAll = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        tab5 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        americanoPanel = new javax.swing.JPanel();
        americanoPic = new javax.swing.JLabel();
        sizeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        americanoDesc = new javax.swing.JLabel();
        americanoIng = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        categoryBack3 = new javax.swing.JButton();
        HCMacchiatoPanel = new javax.swing.JPanel();
        HCMacchiatoPic = new javax.swing.JLabel();
        sizeComboBox1 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        quantitySpinner1 = new javax.swing.JSpinner();
        jLabel69 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        HCMacchiatoDesc = new javax.swing.JLabel();
        HCMacchiatoIng = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        categoryBack4 = new javax.swing.JButton();
        LattePanel = new javax.swing.JPanel();
        LattePic = new javax.swing.JLabel();
        sizeComboBox2 = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        quantitySpinner2 = new javax.swing.JSpinner();
        jLabel75 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        LatteDesc = new javax.swing.JLabel();
        LatteIng = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        categoryBack5 = new javax.swing.JButton();
        CappuccinoPanel = new javax.swing.JPanel();
        CappuccinoPic = new javax.swing.JLabel();
        sizeComboBox3 = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        quantitySpinner3 = new javax.swing.JSpinner();
        jLabel81 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        CappuccinoDesc = new javax.swing.JLabel();
        CappuccinoIng = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        categoryBack6 = new javax.swing.JButton();
        BrewedCoffeePanel = new javax.swing.JPanel();
        BrewedCoffeePic = new javax.swing.JLabel();
        sizeComboBox4 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        quantitySpinner4 = new javax.swing.JSpinner();
        jLabel87 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        BrewedCoffeeDesc = new javax.swing.JLabel();
        BrewedCoffeeIng = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        categoryBack7 = new javax.swing.JButton();
        IWMochaPanel = new javax.swing.JPanel();
        IWMochaPic = new javax.swing.JLabel();
        sizeComboBox5 = new javax.swing.JComboBox<>();
        jLabel92 = new javax.swing.JLabel();
        quantitySpinner5 = new javax.swing.JSpinner();
        jLabel93 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        IWMochaDesc = new javax.swing.JLabel();
        IWMochaIng = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        categoryBack8 = new javax.swing.JButton();
        IcedHazelnutPanel = new javax.swing.JPanel();
        IcedHazelnutPic = new javax.swing.JLabel();
        sizeComboBox6 = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        quantitySpinner6 = new javax.swing.JSpinner();
        jLabel99 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel100 = new javax.swing.JLabel();
        IcedHazelnutDesc = new javax.swing.JLabel();
        IcedHazelnutIng = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        categoryBack9 = new javax.swing.JButton();
        SpanishLattePanel = new javax.swing.JPanel();
        SpanishLattePic = new javax.swing.JLabel();
        sizeComboBox7 = new javax.swing.JComboBox<>();
        jLabel104 = new javax.swing.JLabel();
        quantitySpinner7 = new javax.swing.JSpinner();
        jLabel105 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        SpanishLatteDesc = new javax.swing.JLabel();
        SpanishLatteIng = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        categoryBack10 = new javax.swing.JButton();
        MatchaPanel = new javax.swing.JPanel();
        MatchaPic = new javax.swing.JLabel();
        sizeComboBox8 = new javax.swing.JComboBox<>();
        jLabel110 = new javax.swing.JLabel();
        quantitySpinner8 = new javax.swing.JSpinner();
        jLabel111 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        MatchaDesc = new javax.swing.JLabel();
        MatchaIng = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        categoryBack11 = new javax.swing.JButton();
        CoffeeJellyPanel = new javax.swing.JPanel();
        CoffeeJellyPic = new javax.swing.JLabel();
        sizeComboBox9 = new javax.swing.JComboBox<>();
        jLabel116 = new javax.swing.JLabel();
        quantitySpinner9 = new javax.swing.JSpinner();
        jLabel117 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        CoffeeJellyDesc = new javax.swing.JLabel();
        CoffeeJellyIng = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        categoryBack12 = new javax.swing.JButton();
        CroissantPanel = new javax.swing.JPanel();
        CroissantPic = new javax.swing.JLabel();
        quantitySpinner10 = new javax.swing.JSpinner();
        jLabel123 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        CroissantDesc = new javax.swing.JLabel();
        CroissantIng = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        categoryBack13 = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        CheeseRollPanel = new javax.swing.JPanel();
        CheeseRollPic = new javax.swing.JLabel();
        quantitySpinner11 = new javax.swing.JSpinner();
        jLabel129 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        CheeseRollDesc = new javax.swing.JLabel();
        CheeseRollIng = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        categoryBack14 = new javax.swing.JButton();
        jLabel135 = new javax.swing.JLabel();
        CookiePanel = new javax.swing.JPanel();
        CookiePic = new javax.swing.JLabel();
        quantitySpinner12 = new javax.swing.JSpinner();
        jLabel136 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jLabel137 = new javax.swing.JLabel();
        CookieDesc = new javax.swing.JLabel();
        CookieIng = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        categoryBack15 = new javax.swing.JButton();
        jLabel140 = new javax.swing.JLabel();
        CinnamonPanel = new javax.swing.JPanel();
        CinnamonPic = new javax.swing.JLabel();
        quantitySpinner13 = new javax.swing.JSpinner();
        jLabel142 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel143 = new javax.swing.JLabel();
        CinnamonDesc = new javax.swing.JLabel();
        CinnamonIng = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        categoryBack16 = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        BMuffinPanel = new javax.swing.JPanel();
        BMuffinPic = new javax.swing.JLabel();
        quantitySpinner14 = new javax.swing.JSpinner();
        jLabel148 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel149 = new javax.swing.JLabel();
        BMuffinDesc = new javax.swing.JLabel();
        BMuffinIng = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        categoryBack17 = new javax.swing.JButton();
        jLabel152 = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();
        categoriesBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        cartBtn = new javax.swing.JButton();
        barsitaBot = new javax.swing.JLabel();
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

        shortLine.setBackground(new java.awt.Color(255, 255, 255));
        shortLine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout shortLineLayout = new javax.swing.GroupLayout(shortLine);
        shortLine.setLayout(shortLineLayout);
        shortLineLayout.setHorizontalGroup(
            shortLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        shortLineLayout.setVerticalGroup(
            shortLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHome.add(shortLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, 200, 0));

        longLine.setBackground(new java.awt.Color(255, 255, 255));
        longLine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout longLineLayout = new javax.swing.GroupLayout(longLine);
        longLine.setLayout(longLineLayout);
        longLineLayout.setHorizontalGroup(
            longLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        longLineLayout.setVerticalGroup(
            longLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHome.add(longLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, 860, 1));

        jTabbedPanel.setBackground(new java.awt.Color(239, 233, 233));

        tab1.setBackground(new java.awt.Color(239, 233, 233));
        tab1.setMaximumSize(null);

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
                .addContainerGap(269, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(461, 461, 461))))
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 317, Short.MAX_VALUE))
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTabbedPanel.addTab("tab5", tab1);

        tab2.setBackground(new java.awt.Color(239, 233, 233));
        tab2.setLayout(null);

        pastriesPanel.setBackground(new java.awt.Color(239, 233, 233));
        pastriesPanel.setMaximumSize(null);
        pastriesPanel.setRequestFocusEnabled(false);

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

        blueberryMuffinButton.setMargin(null);
        blueberryMuffinButton.setMaximumSize(null);
        blueberryMuffinButton.setMinimumSize(null);
        blueberryMuffinButton.setPreferredSize(null);
        blueberryMuffinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueberryMuffinButtonActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Blueberry Muffin");

        jLabel29.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Croissant");

        jLabel30.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Cheese Roll");

        jLabel31.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Chocolate Chip Cookie ");

        jLabel32.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Cinnamon Roll");

        categoryBack2.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        categoryBack2.setText("Back");
        categoryBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack2ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jButton2.setText("Order Now");
        jButton2.setPreferredSize(new java.awt.Dimension(77, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pastriesPanelLayout = new javax.swing.GroupLayout(pastriesPanel);
        pastriesPanel.setLayout(pastriesPanelLayout);
        pastriesPanelLayout.setHorizontalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pastriesPanelLayout.createSequentialGroup()
                .addComponent(blueberryMuffinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(croissantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cinnamonRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cheeseRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanelLayout.createSequentialGroup()
                .addComponent(categoryBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel13)
            .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chocolateChipCookieButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pastriesPanelLayout.setVerticalGroup(
            pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pastriesPanelLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(10, 10, 10)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cheeseRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(croissantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueberryMuffinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cinnamonRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addGap(38, 38, 38)
                .addComponent(chocolateChipCookieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addGap(33, 33, 33)
                .addGroup(pastriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryBack2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        tab2.add(pastriesPanel);
        pastriesPanel.setBounds(8, 110, 600, 490);

        hotCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));
        hotCoffeePanel.setMaximumSize(null);

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel11.setText("Hot Coffees");

        americanoButton.setMargin(null);
        americanoButton.setMaximumSize(null);
        americanoButton.setMinimumSize(null);
        americanoButton.setPreferredSize(new java.awt.Dimension(72, 72));
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

        hotCaramelMacchiatoButton.setMargin(null);
        hotCaramelMacchiatoButton.setMaximumSize(null);
        hotCaramelMacchiatoButton.setMinimumSize(null);
        hotCaramelMacchiatoButton.setPreferredSize(null);
        hotCaramelMacchiatoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotCaramelMacchiatoButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Americano");

        jLabel19.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Hot Caramel Macchiato");

        jLabel20.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Latte");

        jLabel21.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cappuccino");

        jLabel22.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Brewed Coffee");

        categoryBack.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        categoryBack.setText("Back");
        categoryBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hotCoffeePanelLayout = new javax.swing.GroupLayout(hotCoffeePanel);
        hotCoffeePanel.setLayout(hotCoffeePanelLayout);
        hotCoffeePanelLayout.setHorizontalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                    .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hotCaramelMacchiatoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(26, 26, 26)
                    .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(brewedCoffeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(latteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                    .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryBack, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cappuccinoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        hotCoffeePanelLayout.setVerticalGroup(
            hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(latteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brewedCoffeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hotCoffeePanelLayout.createSequentialGroup()
                        .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hotCaramelMacchiatoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(americanoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(hotCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel22)
                                .addComponent(jLabel20)))
                        .addGap(38, 38, 38)
                        .addComponent(cappuccinoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(33, 33, 33)
                        .addComponent(categoryBack)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        tab2.add(hotCoffeePanel);
        hotCoffeePanel.setBounds(8, 110, 600, 490);

        coldCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));
        coldCoffeePanel.setMaximumSize(null);

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

        jLabel23.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Iced Coffee Jelly");

        jLabel24.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Iced White Mocha");

        jLabel25.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Iced Hazelnut Coffee");

        jLabel26.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Spanish Latte");

        jLabel27.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Iced Matcha Espresso");

        categoryBack1.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        categoryBack1.setText("Back");
        categoryBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coldCoffeePanelLayout = new javax.swing.GroupLayout(coldCoffeePanel);
        coldCoffeePanel.setLayout(coldCoffeePanelLayout);
        coldCoffeePanelLayout.setHorizontalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spanishLatteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(categoryBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                        .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icedCoffeeJellyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icedWhiteMochaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icedMatchaEspressoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icedHazelnutCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel12))
                .addGap(0, 0, 0))
        );
        coldCoffeePanelLayout.setVerticalGroup(
            coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldCoffeePanelLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icedCoffeeJellyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icedWhiteMochaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icedHazelnutCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icedMatchaEspressoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coldCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24)
                        .addComponent(jLabel27))
                    .addComponent(jLabel25))
                .addGap(38, 38, 38)
                .addComponent(spanishLatteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(categoryBack1)
                .addGap(50, 50, 50))
        );

        tab2.add(coldCoffeePanel);
        coldCoffeePanel.setBounds(8, 110, 620, 490);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel7.setText("Categories");
        tab2.add(jLabel7);
        jLabel7.setBounds(8, 110, 250, 30);

        jLabel3.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Best Products");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab2.add(jLabel3);
        jLabel3.setBounds(160, 20, 261, 47);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pastries");
        tab2.add(jLabel6);
        jLabel6.setBounds(228, 240, 90, 16);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hot Coffee");
        tab2.add(jLabel5);
        jLabel5.setBounds(119, 240, 90, 16);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Blueberry Muffin");
        tab2.add(jLabel4);
        jLabel4.setBounds(478, 470, 130, 18);

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
        Pastries.setBounds(228, 150, 90, 90);

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
        IcedCoffee.setBounds(8, 150, 90, 90);

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
        HotCoffee.setBounds(118, 150, 90, 90);

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel8.setText("Popular Picks");
        tab2.add(jLabel8);
        jLabel8.setBounds(10, 300, 120, 26);

        popular1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        popular1.setToolTipText("");
        popular1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        popular1.setPreferredSize(new java.awt.Dimension(85, 23));
        popular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popular1ActionPerformed(evt);
            }
        });
        tab2.add(popular1);
        popular1.setBounds(478, 340, 130, 130);

        popular2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        popular2.setToolTipText("");
        popular2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        popular2.setPreferredSize(new java.awt.Dimension(85, 23));
        popular2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popular2ActionPerformed(evt);
            }
        });
        tab2.add(popular2);
        popular2.setBounds(8, 340, 130, 130);

        popular3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        popular3.setToolTipText("");
        popular3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        popular3.setPreferredSize(new java.awt.Dimension(85, 23));
        popular3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popular3ActionPerformed(evt);
            }
        });
        tab2.add(popular3);
        popular3.setBounds(163, 340, 130, 130);

        popular4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        popular4.setToolTipText("");
        popular4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        popular4.setPreferredSize(new java.awt.Dimension(85, 23));
        popular4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popular4ActionPerformed(evt);
            }
        });
        tab2.add(popular4);
        popular4.setBounds(320, 340, 130, 130);

        jLabel125.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Iced Coffee");
        tab2.add(jLabel125);
        jLabel125.setBounds(8, 240, 90, 16);

        jLabel153.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel153.setText("Spanish Latte");
        tab2.add(jLabel153);
        jLabel153.setBounds(8, 470, 130, 18);

        jLabel154.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel154.setText("Iced White Mocha");
        tab2.add(jLabel154);
        jLabel154.setBounds(163, 470, 130, 18);

        jLabel155.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel155.setText("Latte");
        tab2.add(jLabel155);
        jLabel155.setBounds(320, 470, 130, 18);

        jTabbedPanel.addTab("tab1", tab2);

        tab3.setBackground(new java.awt.Color(239, 233, 233));
        tab3.setLayout(null);

        yourOrderLabel.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        yourOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourOrderLabel.setText("Your Orders");
        yourOrderLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        billingDeliveryPanel.setPreferredSize(new java.awt.Dimension(600, 550));
        billingDeliveryPanel.setLayout(null);

        jLabel156.setText("Full Name");
        billingDeliveryPanel.add(jLabel156);
        jLabel156.setBounds(330, 100, 54, 16);

        deliveryAddress.setColumns(20);
        deliveryAddress.setRows(5);
        deliveryAddress.setText("text area\n");
        jScrollPane4.setViewportView(deliveryAddress);

        billingDeliveryPanel.add(jScrollPane4);
        jScrollPane4.setBounds(30, 170, 230, 30);

        jLabel157.setText("Address");
        billingDeliveryPanel.add(jLabel157);
        jLabel157.setBounds(340, 130, 42, 16);

        jLabel158.setText("City");
        billingDeliveryPanel.add(jLabel158);
        jLabel158.setBounds(350, 160, 21, 16);

        jLabel159.setText("Phone Number");
        billingDeliveryPanel.add(jLabel159);
        jLabel159.setBounds(320, 190, 90, 16);

        deliveryNumber.setText(".");
        deliveryNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryNumberActionPerformed(evt);
            }
        });
        billingDeliveryPanel.add(deliveryNumber);
        deliveryNumber.setBounds(30, 290, 234, 22);

        deliveryCity.setText(".");
        billingDeliveryPanel.add(deliveryCity);
        deliveryCity.setBounds(30, 230, 234, 22);

        adw1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        adw1.setText("Order Summary");
        billingDeliveryPanel.add(adw1);
        adw1.setBounds(310, 30, 260, 48);

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel160.setText("Billing");
        billingDeliveryPanel.add(jLabel160);
        jLabel160.setBounds(100, 40, 129, 48);

        jButton25.setText("Gcash");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        billingDeliveryPanel.add(jButton25);
        jButton25.setBounds(60, 370, 72, 23);

        jButton26.setText("Cash");
        billingDeliveryPanel.add(jButton26);
        jButton26.setBounds(150, 370, 72, 23);

        jButton27.setText("Proceed to Checkout");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        billingDeliveryPanel.add(jButton27);
        jButton27.setBounds(340, 510, 243, 23);

        jButton28.setText("close");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        billingDeliveryPanel.add(jButton28);
        jButton28.setBounds(10, 20, 72, 23);

        jLabel161.setText("Amount to Pay");
        billingDeliveryPanel.add(jLabel161);
        jLabel161.setBounds(380, 400, 80, 16);

        showDeliveryTotal.setText(".");
        billingDeliveryPanel.add(showDeliveryTotal);
        showDeliveryTotal.setBounds(490, 400, 80, 16);

        currentOrderTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(currentOrderTable1);

        billingDeliveryPanel.add(jScrollPane5);
        jScrollPane5.setBounds(340, 220, 230, 170);

        deliveryFullName.setText(".");
        billingDeliveryPanel.add(deliveryFullName);
        deliveryFullName.setBounds(440, 100, 150, 16);

        jLabel168.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel168.setText("Payment Method");
        billingDeliveryPanel.add(jLabel168);
        jLabel168.setBounds(70, 330, 140, 25);

        jLabel169.setBackground(new java.awt.Color(0, 0, 0));
        jLabel169.setText("Line");
        billingDeliveryPanel.add(jLabel169);
        jLabel169.setBounds(280, 10, 30, 380);

        jLabel170.setText("Payment Method");
        billingDeliveryPanel.add(jLabel170);
        jLabel170.setBounds(360, 430, 100, 16);

        showDeliveryPaymentMethod.setText(".");
        billingDeliveryPanel.add(showDeliveryPaymentMethod);
        showDeliveryPaymentMethod.setBounds(480, 430, 90, 16);

        showDeliveryPaymentType.setText(".");
        billingDeliveryPanel.add(showDeliveryPaymentType);
        showDeliveryPaymentType.setBounds(470, 470, 100, 16);

        jLabel173.setText("Payment Type");
        billingDeliveryPanel.add(jLabel173);
        jLabel173.setBounds(370, 470, 80, 16);

        jLabel180.setText("Full Name");
        billingDeliveryPanel.add(jLabel180);
        jLabel180.setBounds(32, 89, 54, 16);

        deliveryName.setText("jLabel167");
        billingDeliveryPanel.add(deliveryName);
        deliveryName.setBounds(30, 110, 210, 16);

        jLabel182.setText("Address");
        billingDeliveryPanel.add(jLabel182);
        jLabel182.setBounds(30, 150, 42, 16);

        showDeliveryCity.setText(".");
        billingDeliveryPanel.add(showDeliveryCity);
        showDeliveryCity.setBounds(440, 160, 140, 16);

        jLabel184.setText("City");
        billingDeliveryPanel.add(jLabel184);
        jLabel184.setBounds(30, 210, 21, 16);

        showDeliveryAddress.setText(".");
        billingDeliveryPanel.add(showDeliveryAddress);
        showDeliveryAddress.setBounds(440, 130, 140, 16);

        jLabel186.setText("Phone Number");
        billingDeliveryPanel.add(jLabel186);
        jLabel186.setBounds(30, 270, 234, 16);

        jLabel187.setText("Phone Number");
        billingDeliveryPanel.add(jLabel187);
        jLabel187.setBounds(30, 270, 234, 16);

        showDeliveryNumber.setText(".");
        billingDeliveryPanel.add(showDeliveryNumber);
        showDeliveryNumber.setBounds(440, 190, 130, 16);

        jButton30.setText("Submit");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        billingDeliveryPanel.add(jButton30);
        jButton30.setBounds(90, 430, 72, 23);

        pickupCheckoutPanel.setPreferredSize(new java.awt.Dimension(500, 350));
        pickupCheckoutPanel.setLayout(null);

        jButton33.setText("close");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        pickupCheckoutPanel.add(jButton33);
        jButton33.setBounds(200, 290, 72, 23);

        jLabel208.setText("Your Order is ready for pickup in 5-10 minutes");
        pickupCheckoutPanel.add(jLabel208);
        jLabel208.setBounds(120, 190, 260, 16);

        jLabel209.setText("Thank you for Ordering!");
        pickupCheckoutPanel.add(jLabel209);
        jLabel209.setBounds(180, 230, 190, 16);

        deliveryCheckoutPanel.setPreferredSize(new java.awt.Dimension(500, 350));
        deliveryCheckoutPanel.setLayout(null);

        jButton32.setText("close");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        deliveryCheckoutPanel.add(jButton32);
        jButton32.setBounds(210, 290, 72, 23);

        jLabel206.setText("Your Order willl arrive in 5-10 minutes");
        deliveryCheckoutPanel.add(jLabel206);
        jLabel206.setBounds(150, 190, 200, 16);

        jLabel207.setText("Thank you for Ordering!");
        deliveryCheckoutPanel.add(jLabel207);
        jLabel207.setBounds(180, 230, 190, 16);

        billingPickUpPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        billingPickUpPanel.setLayout(null);

        jLabel56.setText("Full Name");
        billingPickUpPanel.add(jLabel56);
        jLabel56.setBounds(32, 89, 54, 16);

        jLabel59.setText("Phone Number");
        billingPickUpPanel.add(jLabel59);
        jLabel59.setBounds(330, 90, 90, 16);

        pickupNumber.setText(".");
        billingPickUpPanel.add(pickupNumber);
        pickupNumber.setBounds(30, 190, 234, 22);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel61.setText("Order Summary");
        billingPickUpPanel.add(jLabel61);
        jLabel61.setBounds(320, 10, 270, 48);

        jButton7.setText("Gcash");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        billingPickUpPanel.add(jButton7);
        jButton7.setBounds(60, 280, 72, 23);

        jButton8.setText("Cash");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        billingPickUpPanel.add(jButton8);
        jButton8.setBounds(150, 280, 72, 23);

        jButton9.setText("Proceed to Checkout");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        billingPickUpPanel.add(jButton9);
        jButton9.setBounds(340, 400, 243, 23);

        jButton10.setText("close");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        billingPickUpPanel.add(jButton10);
        jButton10.setBounds(10, 10, 72, 23);

        jLabel62.setText("Payment Type");
        billingPickUpPanel.add(jLabel62);
        jLabel62.setBounds(370, 360, 80, 20);

        showPickupTotal.setText(".");
        billingPickUpPanel.add(showPickupTotal);
        showPickupTotal.setBounds(480, 290, 100, 16);

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

        billingPickUpPanel.add(jScrollPane2);
        jScrollPane2.setBounds(350, 110, 230, 170);

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel163.setText("Payment Method");
        billingPickUpPanel.add(jLabel163);
        jLabel163.setBounds(70, 240, 140, 25);

        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel164.setText("Billing");
        billingPickUpPanel.add(jLabel164);
        jLabel164.setBounds(90, 20, 129, 48);

        jLabel57.setBackground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Line");
        billingPickUpPanel.add(jLabel57);
        jLabel57.setBounds(280, 10, 30, 350);

        pickupName.setText(".");
        billingPickUpPanel.add(pickupName);
        pickupName.setBounds(30, 120, 60, 16);

        jLabel165.setText("Amount to Pay");
        billingPickUpPanel.add(jLabel165);
        jLabel165.setBounds(380, 290, 80, 16);

        jLabel174.setText("Payment Method");
        billingPickUpPanel.add(jLabel174);
        jLabel174.setBounds(370, 330, 100, 16);

        showPickupPaymentMethod.setText(".");
        billingPickUpPanel.add(showPickupPaymentMethod);
        showPickupPaymentMethod.setBounds(480, 330, 80, 16);

        showPickupPaymentType.setText(".");
        billingPickUpPanel.add(showPickupPaymentType);
        showPickupPaymentType.setBounds(480, 360, 90, 16);

        jLabel166.setText("Full Name");
        billingPickUpPanel.add(jLabel166);
        jLabel166.setBounds(350, 70, 60, 16);

        showPickupFullName.setText(".");
        billingPickUpPanel.add(showPickupFullName);
        showPickupFullName.setBounds(450, 70, 100, 16);

        jLabel178.setText("Phone Number");
        billingPickUpPanel.add(jLabel178);
        jLabel178.setBounds(30, 160, 234, 16);

        showPickupNumber.setText(".");
        billingPickUpPanel.add(showPickupNumber);
        showPickupNumber.setBounds(450, 90, 110, 16);

        jButton29.setText("Submit");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        billingPickUpPanel.add(jButton29);
        jButton29.setBounds(100, 340, 72, 23);

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

        jButton3.setText("Proceed to Billing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setText("Total");

        clearAll.setText("Clear All");
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });

        lblTotal.setText("jLabel19");

        javax.swing.GroupLayout cartPanellLayout = new javax.swing.GroupLayout(cartPanell);
        cartPanell.setLayout(cartPanellLayout);
        cartPanellLayout.setHorizontalGroup(
            cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartPanellLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addGroup(cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cartPanellLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(clearAll))
                        .addGroup(cartPanellLayout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(lblTotal))
                        .addGroup(cartPanellLayout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addComponent(jButton3)))
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        cartPanellLayout.setVerticalGroup(
            cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
            .addGroup(cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartPanellLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addGroup(cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cartPanellLayout.createSequentialGroup()
                            .addGap(289, 289, 289)
                            .addComponent(clearAll)))
                    .addGap(18, 18, 18)
                    .addGroup(cartPanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(lblTotal))
                    .addGap(20, 20, 20)
                    .addComponent(jButton3)
                    .addContainerGap()))
        );

        cartLayeredPanel.setLayer(yourOrderLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cartLayeredPanel.setLayer(billingDeliveryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cartLayeredPanel.setLayer(pickupCheckoutPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cartLayeredPanel.setLayer(deliveryCheckoutPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cartLayeredPanel.setLayer(billingPickUpPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cartLayeredPanel.setLayer(cartPanell, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout cartLayeredPanelLayout = new javax.swing.GroupLayout(cartLayeredPanel);
        cartLayeredPanel.setLayout(cartLayeredPanelLayout);
        cartLayeredPanelLayout.setHorizontalGroup(
            cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cartPanell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(billingDeliveryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pickupCheckoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(deliveryCheckoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(billingPickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayeredPanelLayout.createSequentialGroup()
                    .addContainerGap(189, Short.MAX_VALUE)
                    .addComponent(yourOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(170, Short.MAX_VALUE)))
        );
        cartLayeredPanelLayout.setVerticalGroup(
            cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayeredPanelLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(cartPanell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(billingDeliveryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pickupCheckoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(deliveryCheckoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(billingPickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(cartLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayeredPanelLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(yourOrderLabel)
                    .addContainerGap(499, Short.MAX_VALUE)))
        );

        tab3.add(cartLayeredPanel);
        cartLayeredPanel.setBounds(-10, 0, 640, 570);

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

        jLabel60.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Menu");
        jLabel60.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        americanoPanel.setBackground(new java.awt.Color(239, 233, 233));
        americanoPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel10.setText("Size");

        jLabel15.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel15.setText("Quantity");

        jButton4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton4.setText("Add to Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel17.setText("Americano");

        americanoDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        americanoIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        americanoIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        americanoIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        americanoIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        americanoIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setText("Price: ");

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel14.setText("Ingredients");

        jLabel67.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel67.setText("Php 135 (12oz), Php 160 (16oz)");

        categoryBack3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack3.setText("Back");
        categoryBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout americanoPanelLayout = new javax.swing.GroupLayout(americanoPanel);
        americanoPanel.setLayout(americanoPanelLayout);
        americanoPanelLayout.setHorizontalGroup(
            americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(americanoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(americanoPanelLayout.createSequentialGroup()
                                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(americanoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(americanoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel67)))
                                .addGap(33, 33, 33))
                            .addGroup(americanoPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(americanoPanelLayout.createSequentialGroup()
                                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(americanoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(americanoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(americanoPanelLayout.createSequentialGroup()
                                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(americanoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(americanoPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        americanoPanelLayout.setVerticalGroup(
            americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(americanoPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(americanoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(americanoPanelLayout.createSequentialGroup()
                        .addComponent(americanoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(americanoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(categoryBack3))
                .addGap(18, 18, 18))
            .addGroup(americanoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(americanoPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        HCMacchiatoPanel.setBackground(new java.awt.Color(239, 233, 233));
        HCMacchiatoPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox1ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel68.setText("Size");

        jLabel69.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel69.setText("Quantity");

        jButton11.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton11.setText("Add to Cart");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel70.setText("Hot Caramel Macchiato");

        HCMacchiatoDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        HCMacchiatoIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        HCMacchiatoIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HCMacchiatoIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        HCMacchiatoIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        HCMacchiatoIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel71.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel71.setText("Price: ");

        jLabel72.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel72.setText("Ingredients");

        jLabel73.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel73.setText("Php 160 (12oz), Php 185 (16oz)");

        categoryBack4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack4.setText("Back");
        categoryBack4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HCMacchiatoPanelLayout = new javax.swing.GroupLayout(HCMacchiatoPanel);
        HCMacchiatoPanel.setLayout(HCMacchiatoPanelLayout);
        HCMacchiatoPanelLayout.setHorizontalGroup(
            HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                        .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HCMacchiatoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel73)))
                                .addGap(33, 33, 33))
                            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HCMacchiatoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HCMacchiatoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        HCMacchiatoPanelLayout.setVerticalGroup(
            HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel70)
                .addGap(18, 18, 18)
                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HCMacchiatoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                        .addComponent(HCMacchiatoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(HCMacchiatoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(sizeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(quantitySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(categoryBack4))
                .addGap(18, 18, 18))
            .addGroup(HCMacchiatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HCMacchiatoPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        LattePanel.setBackground(new java.awt.Color(239, 233, 233));
        LattePanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox2ActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel74.setText("Size");

        jLabel75.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel75.setText("Quantity");

        jButton12.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton12.setText("Add to Cart");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel76.setText("Latte");

        LatteDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        LatteIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        LatteIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LatteIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LatteIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        LatteIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel77.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel77.setText("Price: ");

        jLabel78.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel78.setText("Ingredients");

        jLabel79.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel79.setText("Php 145 (12oz), Php 170 (16oz)");

        categoryBack5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack5.setText("Back");
        categoryBack5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LattePanelLayout = new javax.swing.GroupLayout(LattePanel);
        LattePanel.setLayout(LattePanelLayout);
        LattePanelLayout.setHorizontalGroup(
            LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LattePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LattePanelLayout.createSequentialGroup()
                        .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LattePanelLayout.createSequentialGroup()
                                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LattePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(LattePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel79)))
                                .addGap(33, 33, 33))
                            .addGroup(LattePanelLayout.createSequentialGroup()
                                .addComponent(categoryBack5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LattePanelLayout.createSequentialGroup()
                                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LatteIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LatteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(LattePanelLayout.createSequentialGroup()
                                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(LattePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(LattePanelLayout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LattePanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        LattePanelLayout.setVerticalGroup(
            LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LattePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel76)
                .addGap(18, 18, 18)
                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LattePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LattePanelLayout.createSequentialGroup()
                        .addComponent(LatteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(LatteIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(sizeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(quantitySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(categoryBack5))
                .addGap(18, 18, 18))
            .addGroup(LattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LattePanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CappuccinoPanel.setBackground(new java.awt.Color(239, 233, 233));
        CappuccinoPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox3ActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel80.setText("Size");

        jLabel81.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel81.setText("Quantity");

        jButton13.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton13.setText("Add to Cart");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel82.setText("Cappuccino");

        CappuccinoDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CappuccinoIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CappuccinoIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CappuccinoIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CappuccinoIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CappuccinoIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel83.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel83.setText("Price: ");

        jLabel84.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel84.setText("Ingredients");

        jLabel85.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel85.setText("Php 145 (12oz), Php 170 (16oz)");

        categoryBack6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack6.setText("Back");
        categoryBack6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CappuccinoPanelLayout = new javax.swing.GroupLayout(CappuccinoPanel);
        CappuccinoPanel.setLayout(CappuccinoPanelLayout);
        CappuccinoPanelLayout.setHorizontalGroup(
            CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                        .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CappuccinoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel85)))
                                .addGap(33, 33, 33))
                            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CappuccinoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CappuccinoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel80)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(326, Short.MAX_VALUE)))
        );
        CappuccinoPanelLayout.setVerticalGroup(
            CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel82)
                .addGap(18, 18, 18)
                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CappuccinoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                        .addComponent(CappuccinoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CappuccinoIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(sizeComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(quantitySpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(categoryBack6))
                .addGap(18, 18, 18))
            .addGroup(CappuccinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CappuccinoPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        BrewedCoffeePanel.setBackground(new java.awt.Color(239, 233, 233));
        BrewedCoffeePanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox4ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel86.setText("Size");

        jLabel87.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel87.setText("Quantity");

        jButton14.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton14.setText("Add to Cart");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel88.setText("Brewed Coffee");

        BrewedCoffeeDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        BrewedCoffeeIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        BrewedCoffeeIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BrewedCoffeeIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BrewedCoffeeIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BrewedCoffeeIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel89.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel89.setText("Price: ");

        jLabel90.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel90.setText("Ingredients");

        jLabel91.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel91.setText("Php 125 (12oz), Php 150 (16oz)");

        categoryBack7.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack7.setText("Back");
        categoryBack7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BrewedCoffeePanelLayout = new javax.swing.GroupLayout(BrewedCoffeePanel);
        BrewedCoffeePanel.setLayout(BrewedCoffeePanelLayout);
        BrewedCoffeePanelLayout.setHorizontalGroup(
            BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                        .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BrewedCoffeePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel91)))
                                .addGap(33, 33, 33))
                            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                .addComponent(categoryBack7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BrewedCoffeeIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BrewedCoffeeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel86)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );
        BrewedCoffeePanelLayout.setVerticalGroup(
            BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel88)
                .addGap(18, 18, 18)
                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BrewedCoffeePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                        .addComponent(BrewedCoffeeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(BrewedCoffeeIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(sizeComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87)
                    .addComponent(quantitySpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(categoryBack7))
                .addGap(18, 18, 18))
            .addGroup(BrewedCoffeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BrewedCoffeePanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        IWMochaPanel.setBackground(new java.awt.Color(239, 233, 233));
        IWMochaPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox5ActionPerformed(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel92.setText("Size");

        jLabel93.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel93.setText("Quantity");

        jButton15.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton15.setText("Add to Cart");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel94.setText("Iced White Mocha");

        IWMochaDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        IWMochaIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        IWMochaIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IWMochaIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        IWMochaIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        IWMochaIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel95.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel95.setText("Price: ");

        jLabel96.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel96.setText("Ingredients");

        jLabel97.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel97.setText("Php 160 (12oz), Php 185 (16oz)");

        categoryBack8.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack8.setText("Back");
        categoryBack8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IWMochaPanelLayout = new javax.swing.GroupLayout(IWMochaPanel);
        IWMochaPanel.setLayout(IWMochaPanelLayout);
        IWMochaPanelLayout.setHorizontalGroup(
            IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IWMochaPanelLayout.createSequentialGroup()
                        .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IWMochaPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel97)))
                                .addGap(33, 33, 33))
                            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IWMochaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IWMochaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(IWMochaPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel92)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(IWMochaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IWMochaPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        IWMochaPanelLayout.setVerticalGroup(
            IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IWMochaPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel94)
                .addGap(18, 18, 18)
                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IWMochaPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IWMochaPanelLayout.createSequentialGroup()
                        .addComponent(IWMochaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(IWMochaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(sizeComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93)
                    .addComponent(quantitySpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(categoryBack8))
                .addGap(18, 18, 18))
            .addGroup(IWMochaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IWMochaPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        IcedHazelnutPanel.setBackground(new java.awt.Color(239, 233, 233));
        IcedHazelnutPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox6ActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel98.setText("Size");

        jLabel99.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel99.setText("Quantity");

        jButton16.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton16.setText("Add to Cart");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel100.setText("Iced Hazelnut");

        IcedHazelnutDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        IcedHazelnutIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        IcedHazelnutIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IcedHazelnutIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        IcedHazelnutIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        IcedHazelnutIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel101.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel101.setText("Price: ");

        jLabel102.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel102.setText("Ingredients");

        jLabel103.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel103.setText("Php 125 (12oz), Php 150 (16oz)");

        categoryBack9.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack9.setText("Back");
        categoryBack9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IcedHazelnutPanelLayout = new javax.swing.GroupLayout(IcedHazelnutPanel);
        IcedHazelnutPanel.setLayout(IcedHazelnutPanelLayout);
        IcedHazelnutPanelLayout.setHorizontalGroup(
            IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                        .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IcedHazelnutPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel103)))
                                .addGap(33, 33, 33))
                            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IcedHazelnutIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IcedHazelnutDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel98)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        IcedHazelnutPanelLayout.setVerticalGroup(
            IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel100)
                .addGap(18, 18, 18)
                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IcedHazelnutPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                        .addComponent(IcedHazelnutDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(IcedHazelnutIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(sizeComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addComponent(quantitySpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(categoryBack9))
                .addGap(18, 18, 18))
            .addGroup(IcedHazelnutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IcedHazelnutPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        SpanishLattePanel.setBackground(new java.awt.Color(239, 233, 233));
        SpanishLattePanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox7.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox7ActionPerformed(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel104.setText("Size");

        jLabel105.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel105.setText("Quantity");

        jButton17.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton17.setText("Add to Cart");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel106.setText("Iced Spanish Latte");

        SpanishLatteDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        SpanishLatteIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        SpanishLatteIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SpanishLatteIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        SpanishLatteIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SpanishLatteIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel107.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel107.setText("Price: ");

        jLabel108.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel108.setText("Ingredients");

        jLabel109.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel109.setText("Php 135 (12oz), Php 160 (16oz)");

        categoryBack10.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack10.setText("Back");
        categoryBack10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SpanishLattePanelLayout = new javax.swing.GroupLayout(SpanishLattePanel);
        SpanishLattePanel.setLayout(SpanishLattePanelLayout);
        SpanishLattePanelLayout.setHorizontalGroup(
            SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                        .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpanishLattePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel109)))
                                .addGap(33, 33, 33))
                            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                .addComponent(categoryBack10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpanishLatteIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpanishLatteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel104)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        SpanishLattePanelLayout.setVerticalGroup(
            SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel106)
                .addGap(18, 18, 18)
                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpanishLattePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                        .addComponent(SpanishLatteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(SpanishLatteIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(sizeComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105)
                    .addComponent(quantitySpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(categoryBack10))
                .addGap(18, 18, 18))
            .addGroup(SpanishLattePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SpanishLattePanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        MatchaPanel.setBackground(new java.awt.Color(239, 233, 233));
        MatchaPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox8.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox8ActionPerformed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel110.setText("Size");

        jLabel111.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel111.setText("Quantity");

        jButton18.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton18.setText("Add to Cart");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel112.setText("Iced Matcha Espresso");

        MatchaDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        MatchaIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        MatchaIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MatchaIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MatchaIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        MatchaIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel113.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel113.setText("Price: ");

        jLabel114.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel114.setText("Ingredients");

        jLabel115.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel115.setText("Php 160 (12oz), Php 185 (16oz)");

        categoryBack11.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack11.setText("Back");
        categoryBack11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MatchaPanelLayout = new javax.swing.GroupLayout(MatchaPanel);
        MatchaPanel.setLayout(MatchaPanelLayout);
        MatchaPanelLayout.setHorizontalGroup(
            MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MatchaPanelLayout.createSequentialGroup()
                        .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MatchaPanelLayout.createSequentialGroup()
                                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MatchaPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(MatchaPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel115)))
                                .addGap(33, 33, 33))
                            .addGroup(MatchaPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MatchaPanelLayout.createSequentialGroup()
                                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MatchaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MatchaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(MatchaPanelLayout.createSequentialGroup()
                                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(MatchaPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel110)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(MatchaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MatchaPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        MatchaPanelLayout.setVerticalGroup(
            MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchaPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel112)
                .addGap(18, 18, 18)
                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MatchaPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MatchaPanelLayout.createSequentialGroup()
                        .addComponent(MatchaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(MatchaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(sizeComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(quantitySpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(categoryBack11))
                .addGap(18, 18, 18))
            .addGroup(MatchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MatchaPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CoffeeJellyPanel.setBackground(new java.awt.Color(239, 233, 233));
        CoffeeJellyPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        sizeComboBox9.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sizeComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal 12 oz", "Large 16 oz" }));
        sizeComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboBox9ActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel116.setText("Size");

        jLabel117.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel117.setText("Quantity");

        jButton19.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton19.setText("Add to Cart");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel118.setText("Iced Coffee Jelly");

        CoffeeJellyDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CoffeeJellyIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CoffeeJellyIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CoffeeJellyIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CoffeeJellyIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CoffeeJellyIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel119.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel119.setText("Price: ");

        jLabel120.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel120.setText("Ingredients");

        jLabel121.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel121.setText("Php 165 (12oz), Php 190 (16oz)");

        categoryBack12.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack12.setText("Back");
        categoryBack12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CoffeeJellyPanelLayout = new javax.swing.GroupLayout(CoffeeJellyPanel);
        CoffeeJellyPanel.setLayout(CoffeeJellyPanelLayout);
        CoffeeJellyPanelLayout.setHorizontalGroup(
            CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                        .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CoffeeJellyPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel121)))
                                .addGap(33, 33, 33))
                            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CoffeeJellyIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CoffeeJellyDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel116)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sizeComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        CoffeeJellyPanelLayout.setVerticalGroup(
            CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CoffeeJellyPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                        .addComponent(CoffeeJellyDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CoffeeJellyIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(sizeComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(quantitySpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(categoryBack12))
                .addGap(18, 18, 18))
            .addGroup(CoffeeJellyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CoffeeJellyPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CroissantPanel.setBackground(new java.awt.Color(239, 233, 233));
        CroissantPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel123.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel123.setText("Quantity");

        jButton20.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton20.setText("Add to Cart");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel124.setText("Croissant");

        CroissantDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CroissantIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CroissantIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CroissantIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CroissantIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CroissantIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel126.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel126.setText("Ingredients");

        jLabel127.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel127.setText("Php 105 ");

        categoryBack13.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack13.setText("Back");
        categoryBack13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack13ActionPerformed(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel134.setText("Price: ");

        javax.swing.GroupLayout CroissantPanelLayout = new javax.swing.GroupLayout(CroissantPanel);
        CroissantPanel.setLayout(CroissantPanelLayout);
        CroissantPanelLayout.setHorizontalGroup(
            CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CroissantPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CroissantPanelLayout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CroissantPanelLayout.createSequentialGroup()
                        .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CroissantPanelLayout.createSequentialGroup()
                                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CroissantPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CroissantPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(CroissantPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CroissantPanelLayout.createSequentialGroup()
                                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CroissantIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CroissantDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CroissantPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CroissantPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CroissantPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        CroissantPanelLayout.setVerticalGroup(
            CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CroissantPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel124)
                .addGap(18, 18, 18)
                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CroissantPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CroissantPanelLayout.createSequentialGroup()
                        .addComponent(CroissantDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CroissantIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(quantitySpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(categoryBack13))
                .addGap(18, 18, 18))
            .addGroup(CroissantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CroissantPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CheeseRollPanel.setBackground(new java.awt.Color(239, 233, 233));
        CheeseRollPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel129.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel129.setText("Quantity");

        jButton21.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton21.setText("Add to Cart");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel130.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel130.setText("Cheese Roll");

        CheeseRollDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CheeseRollIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CheeseRollIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheeseRollIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CheeseRollIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CheeseRollIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel131.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel131.setText("Ingredients");

        jLabel132.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel132.setText("Php 95");

        categoryBack14.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack14.setText("Back");
        categoryBack14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack14ActionPerformed(evt);
            }
        });

        jLabel135.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel135.setText("Price: ");

        javax.swing.GroupLayout CheeseRollPanelLayout = new javax.swing.GroupLayout(CheeseRollPanel);
        CheeseRollPanel.setLayout(CheeseRollPanelLayout);
        CheeseRollPanelLayout.setHorizontalGroup(
            CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                        .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheeseRollPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheeseRollIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheeseRollDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        CheeseRollPanelLayout.setVerticalGroup(
            CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel130)
                .addGap(18, 18, 18)
                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheeseRollPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                        .addComponent(CheeseRollDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CheeseRollIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(quantitySpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(categoryBack14))
                .addGap(18, 18, 18))
            .addGroup(CheeseRollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CheeseRollPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CookiePanel.setBackground(new java.awt.Color(239, 233, 233));
        CookiePanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel136.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel136.setText("Quantity");

        jButton22.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton22.setText("Add to Cart");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel137.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel137.setText("Chocolate Chip Cookie");

        CookieDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CookieIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CookieIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CookieIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CookieIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CookieIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel138.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel138.setText("Ingredients");

        jLabel139.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel139.setText("Php 85");

        categoryBack15.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack15.setText("Back");
        categoryBack15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack15ActionPerformed(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel140.setText("Price: ");

        javax.swing.GroupLayout CookiePanelLayout = new javax.swing.GroupLayout(CookiePanel);
        CookiePanel.setLayout(CookiePanelLayout);
        CookiePanelLayout.setHorizontalGroup(
            CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CookiePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CookiePanelLayout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CookiePanelLayout.createSequentialGroup()
                        .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CookiePanelLayout.createSequentialGroup()
                                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CookiePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CookiePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(CookiePanelLayout.createSequentialGroup()
                                .addComponent(categoryBack15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CookiePanelLayout.createSequentialGroup()
                                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CookieIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CookieDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CookiePanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CookiePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CookiePanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        CookiePanelLayout.setVerticalGroup(
            CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CookiePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel137)
                .addGap(18, 18, 18)
                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CookiePic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CookiePanelLayout.createSequentialGroup()
                        .addComponent(CookieDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CookieIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(quantitySpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(categoryBack15))
                .addGap(18, 18, 18))
            .addGroup(CookiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CookiePanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        CinnamonPanel.setBackground(new java.awt.Color(239, 233, 233));
        CinnamonPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel142.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel142.setText("Quantity");

        jButton23.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton23.setText("Add to Cart");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel143.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel143.setText("Cinnamon Roll");

        CinnamonDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        CinnamonIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CinnamonIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CinnamonIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CinnamonIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CinnamonIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel144.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel144.setText("Ingredients");

        jLabel145.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel145.setText("Php 120");

        categoryBack16.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack16.setText("Back");
        categoryBack16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack16ActionPerformed(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel146.setText("Price: ");

        javax.swing.GroupLayout CinnamonPanelLayout = new javax.swing.GroupLayout(CinnamonPanel);
        CinnamonPanel.setLayout(CinnamonPanelLayout);
        CinnamonPanelLayout.setHorizontalGroup(
            CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CinnamonPanelLayout.createSequentialGroup()
                        .addComponent(jLabel143)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CinnamonPanelLayout.createSequentialGroup()
                        .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CinnamonPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CinnamonIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CinnamonDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CinnamonPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CinnamonPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        CinnamonPanelLayout.setVerticalGroup(
            CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CinnamonPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel143)
                .addGap(18, 18, 18)
                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CinnamonPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CinnamonPanelLayout.createSequentialGroup()
                        .addComponent(CinnamonDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(CinnamonIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(quantitySpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(categoryBack16))
                .addGap(18, 18, 18))
            .addGroup(CinnamonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CinnamonPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        BMuffinPanel.setBackground(new java.awt.Color(239, 233, 233));
        BMuffinPanel.setPreferredSize(new java.awt.Dimension(670, 480));

        jLabel148.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel148.setText("Quantity");

        jButton24.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jButton24.setText("Add to Cart");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        jLabel149.setText("Cinnamon Roll");

        BMuffinDesc.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        BMuffinIng.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        BMuffinIng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BMuffinIng.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BMuffinIng.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BMuffinIng.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel150.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel150.setText("Ingredients");

        jLabel151.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel151.setText("Php 120");

        categoryBack17.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        categoryBack17.setText("Back");
        categoryBack17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBack17ActionPerformed(evt);
            }
        });

        jLabel152.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel152.setText("Price: ");

        javax.swing.GroupLayout BMuffinPanelLayout = new javax.swing.GroupLayout(BMuffinPanel);
        BMuffinPanel.setLayout(BMuffinPanelLayout);
        BMuffinPanelLayout.setHorizontalGroup(
            BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BMuffinPanelLayout.createSequentialGroup()
                        .addComponent(jLabel149)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BMuffinPanelLayout.createSequentialGroup()
                        .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BMuffinPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                .addComponent(categoryBack17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BMuffinIng, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BMuffinDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BMuffinPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantitySpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BMuffinPanelLayout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        BMuffinPanelLayout.setVerticalGroup(
            BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BMuffinPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel149)
                .addGap(18, 18, 18)
                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BMuffinPic, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BMuffinPanelLayout.createSequentialGroup()
                        .addComponent(BMuffinDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(BMuffinIng, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(quantitySpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(categoryBack17))
                .addGap(18, 18, 18))
            .addGroup(BMuffinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BMuffinPanelLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tab5Layout.createSequentialGroup()
                .addGroup(tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(americanoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HCMacchiatoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LattePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CappuccinoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrewedCoffeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IWMochaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IcedHazelnutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpanishLattePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MatchaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CoffeeJellyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CroissantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheeseRollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CookiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CinnamonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BMuffinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 137, Short.MAX_VALUE))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel60)
                .addGap(21, 21, 21)
                .addComponent(americanoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(HCMacchiatoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(LattePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CappuccinoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(BrewedCoffeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(IWMochaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(IcedHazelnutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(SpanishLattePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(MatchaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CoffeeJellyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CroissantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CheeseRollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CookiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CinnamonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(BMuffinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        panelHome.add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 120, -1));

        categoriesBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        categoriesBtn.setText("Menu");
        categoriesBtn.setAlignmentY(0.0F);
        categoriesBtn.setPreferredSize(new java.awt.Dimension(85, 23));
        categoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesBtnActionPerformed(evt);
            }
        });
        panelHome.add(categoriesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 203, 120, -1));

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
        panelHome.add(cartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, -1));

        barsitaBot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barsitaBot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelHome.add(barsitaBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 90));

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

    private void popular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popular1ActionPerformed

    private void popular2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popular2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popular2ActionPerformed

    private void popular3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popular3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popular3ActionPerformed

    private void popular4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popular4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popular4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPanel.setSelectedIndex(3);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void hideAllProductPanels() {
    americanoPanel.setVisible(false);
    HCMacchiatoPanel.setVisible(false);
    LattePanel.setVisible(false);
    CappuccinoPanel.setVisible(false);
    BrewedCoffeePanel.setVisible(false);
    IWMochaPanel.setVisible(false);
    IcedHazelnutPanel.setVisible(false);
    SpanishLattePanel.setVisible(false);
    MatchaPanel.setVisible(false);
    CoffeeJellyPanel.setVisible(false);
    CroissantPanel.setVisible(false);
    CheeseRollPanel.setVisible(false);
    CookiePanel.setVisible(false);
    CinnamonPanel.setVisible(false);
    BMuffinPanel.setVisible(false);
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String fullName = getFullNameFromUserId(currentUserId);
        longLine.setVisible(false);
        cartPanell.setVisible(false);
        Object[] options = {"Delivery", "Pick-up"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Select a receiving method:",
            "Choose Fulfillment Option",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) { // Delivery
            selectedPaymentType = "Delivery";
            billingDeliveryPanel.setVisible(true);
            deliveryName.setText(fullName);
        } else if (choice == 1) { // Pickup
            selectedPaymentType = "Pickup";
            billingPickUpPanel.setVisible(true);
            pickupName.setText(fullName);
        } else {
            return; // User canceled
        }

        // Save order and load the current order table
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
            DefaultTableModel model1 = (DefaultTableModel) currentOrderTable1.getModel();
            model.setRowCount(0); // Clear both tables
            model1.setRowCount(0);

            // Store all rows in a List first
            List<Object[]> orders = new ArrayList<>();
            boolean hasOrders = false;

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("item_name"),
                    rs.getString("size"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                };
                orders.add(row);
                hasOrders = true;
            }

            // Add the same data to both tables
            for (Object[] row : orders) {
                model.addRow(row);   // Add to first table (Pickup)
                model1.addRow(row);  // Add to second table (Delivery)
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
        hideAllProductPanels();
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
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        LattePanel.setVisible(true);
    }//GEN-LAST:event_latteButtonActionPerformed

    private void cappuccinoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cappuccinoButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        CappuccinoPanel.setVisible(true);
    }//GEN-LAST:event_cappuccinoButtonActionPerformed

    private void brewedCoffeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brewedCoffeeButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        BrewedCoffeePanel.setVisible(true);
    }//GEN-LAST:event_brewedCoffeeButtonActionPerformed

    private void hotCaramelMacchiatoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotCaramelMacchiatoButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        HCMacchiatoPanel.setVisible(true);
    }//GEN-LAST:event_hotCaramelMacchiatoButtonActionPerformed

    private void icedWhiteMochaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedWhiteMochaButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        IWMochaPanel.setVisible(true);
    }//GEN-LAST:event_icedWhiteMochaButtonActionPerformed

    private void icedHazelnutCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedHazelnutCoffeeActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        IcedHazelnutPanel.setVisible(true);
    }//GEN-LAST:event_icedHazelnutCoffeeActionPerformed

    private void spanishLatteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishLatteButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        SpanishLattePanel.setVisible(true);
    }//GEN-LAST:event_spanishLatteButtonActionPerformed

    private void icedMatchaEspressoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedMatchaEspressoButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        MatchaPanel.setVisible(true);
    }//GEN-LAST:event_icedMatchaEspressoButtonActionPerformed

    private void icedCoffeeJellyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icedCoffeeJellyButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        CoffeeJellyPanel.setVisible(true);
    }//GEN-LAST:event_icedCoffeeJellyButtonActionPerformed

    private void croissantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_croissantButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        CroissantPanel.setVisible(true);
    }//GEN-LAST:event_croissantButtonActionPerformed

    private void cheeseRollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheeseRollButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        CheeseRollPanel.setVisible(true);
    }//GEN-LAST:event_cheeseRollButtonActionPerformed

    private void chocolateChipCookieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocolateChipCookieButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        CookiePanel.setVisible(true);
    }//GEN-LAST:event_chocolateChipCookieButtonActionPerformed

    private void cinnamonRollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinnamonRollButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        CinnamonPanel.setVisible(true);
    }//GEN-LAST:event_cinnamonRollButtonActionPerformed

    private void blueberryMuffinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueberryMuffinButtonActionPerformed
        jTabbedPanel.setSelectedIndex(4);
        hideAllProductPanels();
        BMuffinPanel.setVisible(true);
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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        billingPickUpPanel.setVisible(false);
        cartPanell.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pickupCheckoutPanel.setVisible(true);
        billingPickUpPanel.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void categoryBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack1ActionPerformed
        jTabbedPanel.setSelectedIndex(1);
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack1ActionPerformed

    private void categoryBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack2ActionPerformed
        jTabbedPanel.setSelectedIndex(1);
        hotCoffeePanel.setVisible(false);
        coldCoffeePanel.setVisible(false);
        pastriesPanel.setVisible(false);
        categoryBack.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack2ActionPerformed

    private void categoryBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack3ActionPerformed

    private void sizeComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String size = sizeComboBox1.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner1.getValue();
        double basePrice = 160; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Hot Caramel Macchiato", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Hot Caramel Macchiato (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void categoryBack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack4ActionPerformed

    private void sizeComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String size = sizeComboBox2.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner2.getValue();
        double basePrice = 145; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Latte", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Latte (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void categoryBack5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack5ActionPerformed

    private void sizeComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String size = sizeComboBox3.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner3.getValue();
        double basePrice = 145; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Cappuccino", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Cappuccino (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void categoryBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack6ActionPerformed

    private void sizeComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String size = sizeComboBox4.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner4.getValue();
        double basePrice = 125; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Brewed Coffee", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Brewed Coffee (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void categoryBack7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack7ActionPerformed

    private void sizeComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String size = sizeComboBox5.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner5.getValue();
        double basePrice = 160; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Iced White Mocha", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Iced White Mocha (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void categoryBack8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack8ActionPerformed

    private void sizeComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox6ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String size = sizeComboBox6.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner6.getValue();
        double basePrice = 125; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Iced Hazelnut Coffee", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Iced Hazelnut Coffee (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void categoryBack9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack9ActionPerformed

    private void sizeComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox7ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String size = sizeComboBox7.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner7.getValue();
        double basePrice = 135; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Iced Spanish Latte", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Iced Spanish Latte (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void categoryBack10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack10ActionPerformed

    private void sizeComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox8ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String size = sizeComboBox8.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner8.getValue();
        double basePrice = 160; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Iced Matcha Expresso", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Iced Matcha Expresso (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void categoryBack11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack11ActionPerformed

    private void sizeComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeComboBox9ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        String size = sizeComboBox9.getSelectedItem().toString();
        int quantity = (Integer) quantitySpinner9.getValue();
        double basePrice = 165; 
        double extra = size.equals("Large 16 oz") ? 25 : 0;
        double finalPrice = (basePrice + extra) * quantity;

        OrderItem item = new OrderItem("Iced Coffee Jelly", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Iced Coffee Jelly (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void categoryBack12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack12ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String size = "N/A";
        int quantity = (Integer) quantitySpinner10.getValue();
        double basePrice = 105; 
        double finalPrice = basePrice * quantity;

        OrderItem item = new OrderItem("Croissant", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Croissant (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void categoryBack13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack13ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        String size = "N/A";
        int quantity = (Integer) quantitySpinner11.getValue();
        double basePrice = 95; 
        double finalPrice = basePrice * quantity;

        OrderItem item = new OrderItem("Cheese Roll", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Cheese Roll (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void categoryBack14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack14ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String size = "N/A";
        int quantity = (Integer) quantitySpinner12.getValue();
        double basePrice = 85; 
        double finalPrice = basePrice * quantity;

        OrderItem item = new OrderItem("Chocolate Chip Cookie", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Chocolate Chip Cookie (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void categoryBack15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack15ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String size = "N/A";
        int quantity = (Integer) quantitySpinner13.getValue();
        double basePrice = 120; 
        double finalPrice = basePrice * quantity;

        OrderItem item = new OrderItem("Cinnamon Roll", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Cinnamon Roll (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void categoryBack16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack16ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String size = "N/A";
        int quantity = (Integer) quantitySpinner14.getValue();
        double basePrice = 105; 
        double finalPrice = basePrice * quantity;

        OrderItem item = new OrderItem("Blue Muffin", size, quantity, finalPrice);
        cart.add(item);
        cartModel.addRow(item.toTableRow());
        updateTotal();
        
        String addedMessage = String.format("Blue Muffin (%s, x%d) - ₱%.2f added successfully!", size, quantity, finalPrice);
        javax.swing.JOptionPane.showMessageDialog(this, addedMessage, "Item Added", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void categoryBack17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBack17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBack17ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        deliveryCheckoutPanel.setVisible(true);
        billingDeliveryPanel.setVisible(false);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        billingDeliveryPanel.setVisible(false);
        cartPanell.setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        selectedPaymentMethod = "Gcash";
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        deliveryCheckoutPanel.setVisible(false);
        billingDeliveryPanel.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        pickupCheckoutPanel.setVisible(false);
        billingPickUpPanel.setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        selectedPaymentMethod = "Cash";
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        selectedPaymentMethod = "Gcash";
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        processPickupCheckout();
        updateOrderSummaryLabels();
        
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        processDeliveryCheckout();
        updateOrderSummaryLabels();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void deliveryNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryNumberActionPerformed
    
    private String getFullNameFromUserId(int userId) {
        String fullName = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user_database", "root", "");
            String sql = "SELECT firstName, lastName FROM user WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fullName = rs.getString("firstName") + " " + rs.getString("lastName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullName;
    }
    
    public double calculatePickupTotal() {
    double total = 0.0;
    DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());
            double price = Double.parseDouble(model.getValueAt(i, 3).toString());
            total += quantity * price;
        } catch (Exception e) {
            System.out.println("Pickup row " + i + " error: " + e.getMessage());
        }
    }
    return total;
}
    
    public double calculateDeliveryTotal() {
    double total = 0.0;
    DefaultTableModel model = (DefaultTableModel) currentOrderTable1.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());
            double price = Double.parseDouble(model.getValueAt(i, 3).toString());
            total += quantity * price;
        } catch (Exception e) {
            System.out.println("Delivery row " + i + " error: " + e.getMessage());
        }
    }
    return total;
}
    
    private void processDeliveryCheckout() {
        String fullName = getFullNameFromUserId(currentUserId);
        String phone = deliveryNumber.getText().trim();     // from delivery panel
        String address = deliveryAddress.getText().trim();    // delivery-only
        String city = deliveryCity.getText().trim();      // delivery-only
        double totalAmount = calculatePickupTotal() + calculateDeliveryTotal();
        totalAmount = totalAmount / 2;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user_database", "root", "");
            String sql = "INSERT INTO order_summary (user_id, full_name, address, city, phone_number, payment_method, payment_type, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentUserId);
            ps.setString(2, fullName);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, phone);
            ps.setString(6, selectedPaymentMethod);   // Gcash/Cash
            ps.setString(7, "Delivery");
            ps.setDouble(8, totalAmount);
            ps.setString(9, "Pending");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delivery order placed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to place delivery order.");
        }
    }
    
    private void processPickupCheckout() {
        String fullName = getFullNameFromUserId(currentUserId);
        String phone = pickupNumber.getText().trim();     // from pickup panel
        double totalAmount = calculatePickupTotal() + calculateDeliveryTotal();
        totalAmount = totalAmount / 2;
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user_database", "root", "");
            String sql = "INSERT INTO order_summary (user_id, full_name, address, city, phone_number, payment_method, payment_type, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentUserId);
            ps.setString(2, fullName);
            ps.setString(3, "N/A"); // address
            ps.setString(4, "N/A"); // city
            ps.setString(5, phone);
            ps.setString(6, selectedPaymentMethod);   // Gcash/Cash
            ps.setString(7, "Pickup");
            ps.setDouble(8, totalAmount);
            ps.setString(9, "Pending");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pickup order placed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to place pickup order.");
        }
    }
    
    private void updateOrderSummaryLabels() {
        String fullName = getFullNameFromUserId(currentUserId);
        deliveryFullName.setText(fullName);  // Full name
        showPickupFullName.setText(fullName);
        double totalAmount = calculatePickupTotal() + calculateDeliveryTotal();
        totalAmount = totalAmount / 2;
 
                
        if (selectedPaymentType.equals("Delivery")) {
            String address = deliveryAddress.getText().trim();
            String city = deliveryCity.getText().trim();
            String phone = deliveryNumber.getText().trim();

            showDeliveryAddress.setText(address);  // Address
            // NOTE: You have 2 `jLabel183`s — give one a better name like jLabelCity if needed
            showDeliveryCity.setText(city);     // City (conflicts if same label!)
            showDeliveryNumber.setText(phone);    // Phone
            showDeliveryPaymentMethod.setText(selectedPaymentMethod);
            showDeliveryPaymentType.setText(selectedPaymentType);
            showDeliveryTotal.setText("₱" + String.format("%.2f", totalAmount));
            System.out.println("DEBUG: totalAmount = " + totalAmount);
            
        } else {
            String phone = pickupNumber.getText().trim();  // Pickup phone field
            
            showPickupNumber.setText(phone);
            showPickupTotal.setText("₱" + String.format("%.2f", totalAmount));
            showPickupPaymentMethod.setText(selectedPaymentMethod);
            showPickupPaymentType.setText(selectedPaymentType);
            System.out.println("DEBUG: totalAmount = " + totalAmount);
        }
    }
    
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
    private javax.swing.JLabel BMuffinDesc;
    private javax.swing.JLabel BMuffinIng;
    private javax.swing.JPanel BMuffinPanel;
    private javax.swing.JLabel BMuffinPic;
    private javax.swing.JLabel BrewedCoffeeDesc;
    private javax.swing.JLabel BrewedCoffeeIng;
    private javax.swing.JPanel BrewedCoffeePanel;
    private javax.swing.JLabel BrewedCoffeePic;
    private javax.swing.JLabel CappuccinoDesc;
    private javax.swing.JLabel CappuccinoIng;
    private javax.swing.JPanel CappuccinoPanel;
    private javax.swing.JLabel CappuccinoPic;
    private javax.swing.JLabel CheeseRollDesc;
    private javax.swing.JLabel CheeseRollIng;
    private javax.swing.JPanel CheeseRollPanel;
    private javax.swing.JLabel CheeseRollPic;
    private javax.swing.JLabel CinnamonDesc;
    private javax.swing.JLabel CinnamonIng;
    private javax.swing.JPanel CinnamonPanel;
    private javax.swing.JLabel CinnamonPic;
    private javax.swing.JLabel CoffeeJellyDesc;
    private javax.swing.JLabel CoffeeJellyIng;
    private javax.swing.JPanel CoffeeJellyPanel;
    private javax.swing.JLabel CoffeeJellyPic;
    private javax.swing.JLabel CookieDesc;
    private javax.swing.JLabel CookieIng;
    private javax.swing.JPanel CookiePanel;
    private javax.swing.JLabel CookiePic;
    private javax.swing.JLabel CroissantDesc;
    private javax.swing.JLabel CroissantIng;
    private javax.swing.JPanel CroissantPanel;
    private javax.swing.JLabel CroissantPic;
    private javax.swing.JLabel HCMacchiatoDesc;
    private javax.swing.JLabel HCMacchiatoIng;
    private javax.swing.JPanel HCMacchiatoPanel;
    private javax.swing.JLabel HCMacchiatoPic;
    private javax.swing.JButton HotCoffee;
    private javax.swing.JLabel IWMochaDesc;
    private javax.swing.JLabel IWMochaIng;
    private javax.swing.JPanel IWMochaPanel;
    private javax.swing.JLabel IWMochaPic;
    private javax.swing.JButton IcedCoffee;
    private javax.swing.JLabel IcedHazelnutDesc;
    private javax.swing.JLabel IcedHazelnutIng;
    private javax.swing.JPanel IcedHazelnutPanel;
    private javax.swing.JLabel IcedHazelnutPic;
    private javax.swing.JLabel LatteDesc;
    private javax.swing.JLabel LatteIng;
    private javax.swing.JPanel LattePanel;
    private javax.swing.JLabel LattePic;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel MatchaDesc;
    private javax.swing.JLabel MatchaIng;
    private javax.swing.JPanel MatchaPanel;
    private javax.swing.JLabel MatchaPic;
    private javax.swing.JButton Pastries;
    private javax.swing.JLabel SpanishLatteDesc;
    private javax.swing.JLabel SpanishLatteIng;
    private javax.swing.JPanel SpanishLattePanel;
    private javax.swing.JLabel SpanishLattePic;
    private javax.swing.JButton aboutBtn;
    private javax.swing.JLabel adw1;
    private javax.swing.JButton americanoButton;
    private javax.swing.JButton americanoButton1;
    private javax.swing.JLabel americanoDesc;
    private javax.swing.JLabel americanoIng;
    private javax.swing.JPanel americanoPanel;
    private javax.swing.JLabel americanoPic;
    private javax.swing.JLabel barsitaBot;
    private javax.swing.JPanel billingDeliveryPanel;
    private javax.swing.JPanel billingPickUpPanel;
    private javax.swing.JButton blueberryMuffinButton;
    private javax.swing.JButton blueberryMuffinButton1;
    private javax.swing.JButton brewedCoffeeButton;
    private javax.swing.JButton brewedCoffeeButton1;
    private javax.swing.JButton cappuccinoButton;
    private javax.swing.JButton cappuccinoButton1;
    private javax.swing.JButton cartBtn;
    private javax.swing.JLayeredPane cartLayeredPanel;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel cartPanell;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JButton categoryBack;
    private javax.swing.JButton categoryBack1;
    private javax.swing.JButton categoryBack10;
    private javax.swing.JButton categoryBack11;
    private javax.swing.JButton categoryBack12;
    private javax.swing.JButton categoryBack13;
    private javax.swing.JButton categoryBack14;
    private javax.swing.JButton categoryBack15;
    private javax.swing.JButton categoryBack16;
    private javax.swing.JButton categoryBack17;
    private javax.swing.JButton categoryBack2;
    private javax.swing.JButton categoryBack3;
    private javax.swing.JButton categoryBack4;
    private javax.swing.JButton categoryBack5;
    private javax.swing.JButton categoryBack6;
    private javax.swing.JButton categoryBack7;
    private javax.swing.JButton categoryBack8;
    private javax.swing.JButton categoryBack9;
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
    private javax.swing.JTable currentOrderTable1;
    private javax.swing.JTextArea deliveryAddress;
    private javax.swing.JPanel deliveryCheckoutPanel;
    private javax.swing.JTextField deliveryCity;
    private javax.swing.JLabel deliveryFullName;
    private javax.swing.JLabel deliveryName;
    private javax.swing.JTextField deliveryNumber;
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
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
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
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPanel;
    private javax.swing.JButton latteButton;
    private javax.swing.JButton latteButton1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton leftButton;
    private javax.swing.JPanel longLine;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel pastriesPanel;
    private javax.swing.JPanel pastriesPanel1;
    private javax.swing.JPanel pickupCheckoutPanel;
    private javax.swing.JLabel pickupName;
    private javax.swing.JTextField pickupNumber;
    private javax.swing.JButton popular1;
    private javax.swing.JButton popular2;
    private javax.swing.JButton popular3;
    private javax.swing.JButton popular4;
    private javax.swing.JLabel productDescription;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productName;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JSpinner quantitySpinner1;
    private javax.swing.JSpinner quantitySpinner10;
    private javax.swing.JSpinner quantitySpinner11;
    private javax.swing.JSpinner quantitySpinner12;
    private javax.swing.JSpinner quantitySpinner13;
    private javax.swing.JSpinner quantitySpinner14;
    private javax.swing.JSpinner quantitySpinner2;
    private javax.swing.JSpinner quantitySpinner3;
    private javax.swing.JSpinner quantitySpinner4;
    private javax.swing.JSpinner quantitySpinner5;
    private javax.swing.JSpinner quantitySpinner6;
    private javax.swing.JSpinner quantitySpinner7;
    private javax.swing.JSpinner quantitySpinner8;
    private javax.swing.JSpinner quantitySpinner9;
    private javax.swing.JInternalFrame receiptInternalFrame;
    private javax.swing.JButton rightButton;
    private javax.swing.JPanel roundedPanel;
    private javax.swing.JPanel shortLine;
    private javax.swing.JLabel showDeliveryAddress;
    private javax.swing.JLabel showDeliveryCity;
    private javax.swing.JLabel showDeliveryNumber;
    private javax.swing.JLabel showDeliveryPaymentMethod;
    private javax.swing.JLabel showDeliveryPaymentType;
    private javax.swing.JLabel showDeliveryTotal;
    private javax.swing.JLabel showPickupFullName;
    private javax.swing.JLabel showPickupNumber;
    private javax.swing.JLabel showPickupPaymentMethod;
    private javax.swing.JLabel showPickupPaymentType;
    private javax.swing.JLabel showPickupTotal;
    private javax.swing.JComboBox<String> sizeComboBox;
    private javax.swing.JComboBox<String> sizeComboBox1;
    private javax.swing.JComboBox<String> sizeComboBox2;
    private javax.swing.JComboBox<String> sizeComboBox3;
    private javax.swing.JComboBox<String> sizeComboBox4;
    private javax.swing.JComboBox<String> sizeComboBox5;
    private javax.swing.JComboBox<String> sizeComboBox6;
    private javax.swing.JComboBox<String> sizeComboBox7;
    private javax.swing.JComboBox<String> sizeComboBox8;
    private javax.swing.JComboBox<String> sizeComboBox9;
    private javax.swing.JButton spanishLatteButton;
    private javax.swing.JButton spanishLatteButton1;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private javax.swing.JLabel user;
    private javax.swing.JLabel yourOrderLabel;
    // End of variables declaration//GEN-END:variables
}
