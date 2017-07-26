import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * CustomerView is part of the view assembly it represents view that the customer gets.
 * It is the first screen that should open. Vamsi used JFrames instead I extended the class
 * to JFrame to get rid of unnecessary initializations.
 * 
 * @author Vamsi, Nikoloz
 *
 */

public class CustomerView extends JFrame{
	
	/**	The Constant serialVersionUID needed for any Serializable class. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant LIST_LENGTH is the default height on screen of a list. */
	  private static final int LIST_LENGTH = 100;
	
	//Here is the Jframe that is obsolete for now
	//private JFrame frame;
	private JTextField textField;
	
	/**singleton of the CustomerView class*/
	private static CustomerView customerView=new CustomerView();
	
	/** The content pane. This object is used instead of calling method getContentPane() */
	  private JPanel customerContentPane = new JPanel();
	  
	  /** JList for menu*/
	 private JList menuList;
	 
	 /** Renders items in menu using a JLabel to allow pictures */
	  private MenuItemRenderer menuItemRenderer = new MenuItemRenderer();
	  
	  /** JComboBox for filtering menu that is displayed according to meal type deal type
	   * and food type(preferences). 
	   */
	  private JComboBox  dealselection;
	  private JComboBox  menuselection;
	  private JComboBox  foodselection;
	  
	/** Login button for authorization*/
	  private JButton loginButton = new JButton("Login");
	/** Button for adding MenuItem to Order */
	  //private JButton addToOrder=new JButton("Add to Order");

	/**
	 * Part of the View assembly. Main was commented out, Should check use of runnable
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView window = new CustomerView();
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
	private CustomerView() {
		//initialize();
		
		super("Customer View");
		setContentPane(customerContentPane);
		customerContentPane.setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(200, 500, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * 
		 * Sent the action listener to Controller
		 * 
		 * 
		 */
		/** Button for calling the waiter with its listener*/
		JButton btnNewButton = new JButton("Call Waiter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "connect this to waiter");
			}
		});
		/**
		 * 
		 * Sent the action listener to Controller
		 * 
		 * 
		 */
		/** Button used to open authorization screen it is already declared as a field here just a font is set*/
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField = new JTextField();
		textField.setColumns(10);
		
		/**
		 * Button that adds MenuItems to order. Setting font
		 */
		//addToOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 
		dealselection.putClientProperty("type", "deal_type");
		menuselection.putClientProperty("type", "menu_type");
		foodselection.putClientProperty("type", "food_type");
		JLabel dealtypelabel = new JLabel("Deal Type");
		
		JLabel menutypelabel = new JLabel("Menu Type");
		
		JLabel preferenceslabel = new JLabel("Preferences");
		
		JLabel lblYourOrder = new JLabel("Your Order");
		lblYourOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton confirmOrderButton = new JButton("Confirm Order");
		confirmOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel brandimageLabel = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("miscFiles/brand-logo.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		brandimageLabel.setIcon(new ImageIcon(newimg));
		
		/**
		 * Have hand coded some parts windowBuilder may not be able to parse them.
		 */
		menuList = new JList();
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.setVisibleRowCount(5);
		menuList.setBackground(Color.GREEN);
		menuList.setCellRenderer(menuItemRenderer);
		
		
		GroupLayout groupLayout = new GroupLayout(customerContentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(39)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(dealselection, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
											.addComponent(dealtypelabel))
										.addGap(29)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(menuselection, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
												.addComponent(foodselection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(menutypelabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
										.addGap(109))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(menuList, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
										.addGap(145))))
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(preferenceslabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addGap(137)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(brandimageLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(confirmOrderButton, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblYourOrder, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(94))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(brandimageLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(preferenceslabel)
								.addComponent(menutypelabel)
								.addComponent(dealtypelabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(dealselection, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(foodselection, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(menuselection, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(confirmOrderButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(menuList, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(lblYourOrder, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		customerContentPane.setLayout(groupLayout);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}

	//getter for CustomerView instance
	public static CustomerView getCustomerView() {
		return customerView;
	}
	
	/** Sets a listener for Login button which takes user to the LoginView*/
	public void setLoginListener(ActionListener loginListener) {
	    // Listener for login button
	    loginButton.addActionListener(loginListener);
	    
	  }
	
	/** Sets a listener for the 3 JComboBox, which filter the list that is displayed in JList menu on CustomerView*/
	public void registerJcomboBox(ItemListener itemChangeListener){
		dealselection.addItemListener(itemChangeListener);
		menuselection.addItemListener(itemChangeListener);
		foodselection.addItemListener(itemChangeListener);
	}
	
	/** Sets a listener for the MenuItemList that is set as a model for the JList menu on CustomerView */
	public void registerMenuItemModel(MenuItemList menu,
		      ListSelectionListener itemListener) {
		    // Listeners and Models for the JLists
		    
		    menuList.setModel(menu);
		   
		    menuList.addListSelectionListener(itemListener);
	
	}
}
