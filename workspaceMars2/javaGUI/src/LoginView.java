
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
//import net.miginfocom.swing.MigLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

/**
* LoginView is part of the view assembly it represents view that the user gets for authorization.
* It is the screen that should open, once authorization button is pressed in CustomerView.
* Vamsi used JFrames instead I extended the class to JFrame to get rid of unnecessary initializations.
* 
* @author Vamsi, Nikoloz
*
*/

public class LoginView extends JFrame{
	
	/**	The Constant serialVersionUID needed for any Serializable class. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. This object is used instead of calling method getContentPane() */
	  private JPanel loginContentPane = new JPanel();
	
	/**singleton of the LoginView class*/
	private static LoginView loginView=new LoginView();
	/** Button to go back to Home, which is CustomerView*/
	JButton homeButtonFromLogin = new JButton("Home");
	
	/** Button for authorisation */
	JButton authoriseButton = new JButton("Login");
			
	//Here is the obsolete JFrame
	//private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;

	/**
	 * Launch the application. Main was commented out. Should check use of runnable.
	 * Just like in CustomerView.
	 * 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	private LoginView() {
		//initialize();
		
		super("Login View");
		setContentPane(loginContentPane);
		loginContentPane.setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		loginContentPane.setForeground(Color.WHITE);
		setBounds(100, 100, 800, 600);
		
		//Login Button
		authoriseButton.setFont(new Font("Tahoma", Font.PLAIN, 14));		
		//Reset Button
		JButton reset = new JButton("Reset");
		reset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameField.setText(null);
				passwordField.setText(null);
			}
		});
		
		/**
		 * These things are unnecessary, since class now extends JFrame and
		 *  contentPane is set to loginContentPane 
		 */
		//Trying to add background image or a brand logo in JLabel... Not working
		/*imageicon img = new imageicon();//this.getclass().getResource("/brand-logo.jpg")).getImage();
		img.add(login);
		img.add(reset);*/
		//frame.add(img);
		
		//loginContentPane.add(login);
		//loginContentPane.add(reset);
		
						
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
		lblNewLabel.setIcon(new ImageIcon("miscFiles/brand-logo.jpg"));
		lblNewLabel.setBackground(Color.BLACK);
		
		
		
		GroupLayout groupLayout = new GroupLayout(loginContentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(302, Short.MAX_VALUE)
					.addComponent(btnRegisterNow, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(286))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(authoriseButton, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(reset, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(142, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel)
					.addContainerGap(736, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserAuthentication)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(usernameField)
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
					.addContainerGap(205, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(homeButtonFromLogin)
					.addContainerGap(702, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(homeButtonFromLogin, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(reset, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(authoriseButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(btnRegisterNow, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		loginContentPane.setLayout(groupLayout);
		
	}
	
	/**
	 * put image on jframe
	 */
	/*public class imageicon extends JPanel{
		public imageicon(){
			setOpaque(false);
			setLayout(new GroupLayout(frame));
			
		}
	}*/
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}

	public static LoginView getLoginView() {
		return loginView;
	}

	/** Sets a listener for home button which returns to CustomerView*/
	public void setHomeListener(ActionListener homeListener) {
		//Listener for home button
		homeButtonFromLogin.addActionListener(homeListener);
		
	}
	
	public String getUserName(){
		
		return usernameField.getText();
	}
	public String getPassword(){
		return passwordField.getText();
	}

	public void setAuthoriseListener(ActionListener authoriseListener) {
		authoriseButton.addActionListener(authoriseListener);
		
	}
	public void showErrorDialog(String text, String title){
		JOptionPane.showMessageDialog(this, text, title, JOptionPane.ERROR_MESSAGE);
	}
}
