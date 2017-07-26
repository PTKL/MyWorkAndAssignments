import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class WaiterLoginView {

    private JFrame frame;
    private JPasswordField passwordField;
    private JTextField usernameField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WaiterLoginView window = new WaiterLoginView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public WaiterLoginView() {
        initialize();
    }
    
    /**
     * put image on jframe
     */
    public class imageicon extends JPanel{
        public imageicon(){
            setOpaque(false);
            setLayout(new GroupLayout(frame));
            
        }
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setForeground(Color.WHITE);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 800, 600);
        
        //Login Button
        JButton login = new JButton("Login");
        login.setFont(new Font("Tahoma", Font.PLAIN, 14));
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });     
        //Reset Button
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                usernameField.setText(null);
                passwordField.setText(null);
            }
        });
        
        //Trying to add background image or a brand logo in JLabel... Not working
        imageicon img = new imageicon();//this.getclass().getResource("/brand-logo.jpg")).getImage();
        img.add(login);
        img.add(reset);
        //frame.add(img);
                        
        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        passwordField = new JPasswordField();
        
        JLabel lblUserAuthentication = new JLabel("User Authentication");
        lblUserAuthentication.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        usernameField = new JTextField();
        usernameField.setColumns(1);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        usernameField.setBorder(border);
        
        JButton btnRegisterNow = new JButton("Register Now");
        btnRegisterNow.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(WaiterLoginView.class.getResource("/cafeautomation/brand-logo.jpg")));
        lblNewLabel.setBackground(Color.BLACK);
        
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(290, Short.MAX_VALUE)
                    .addComponent(btnRegisterNow, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                    .addGap(286))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(129)
                    .addComponent(login, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                    .addGap(55)
                    .addComponent(reset, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(60)
                    .addComponent(lblNewLabel)
                    .addContainerGap(64, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(166, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPassword))
                    .addGap(41)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblUserAuthentication)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                            .addComponent(usernameField)
                            .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                    .addContainerGap(199, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblUserAuthentication, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(26)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(41)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(reset, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(login, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(40)
                    .addComponent(btnRegisterNow, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(37))
        );
        frame.getContentPane().setLayout(groupLayout);
    }
}
