
package coffee.ordering.system;


public class LoginAndSignUp {

  
    public static void main(String[] args) {
        Splashscreen splash = new Splashscreen(); // Show splash first
        splash.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40); // Speed of progress bar
                splash.getBar().setValue(i);
                splash.getProgress().setText(i + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        splash.dispose(); // Close splash

        // Now open login
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
    
}
