
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Controller class is part of MVC pattern it controls the system through Model and View. It
 * Observes and updates the View. Interactions with View invokes the Controller which in return uses
 * the Model to apply business logic. Model and View refer not to the other classes only, but to a
 * whole assembly.
 *
 * @see Model
 * @see View
 * @author Nikoloz
 */

public class Controller {

  /** Singleton of Controller class. */
  private static Controller instance = new Controller();
  /** Singleton of Model class. */
  private static Model model;

  /** Singleton of CustomerView class. */
  private CustomerView customerView;

  /** Singleton of LoginView class */
  private LoginView loginView;

  /** Listener for authorisation (login) button on loginView */
  AuthoriseListener authoriseListener = new AuthoriseListener();

  /** Listener for the menu selection */
  private MenuItemSelectionListener menuItemListener = new MenuItemSelectionListener();

  /** Listener for the Login button on the CustomerView. */
  private LoginListener loginListener = new LoginListener();

  /** Listener for the Login button on the CustomerView. */
  private HomeListener homeListener = new HomeListener();

  /** Listener for the 3 JComboBox that filter the menu in CustomerView */
  //private ItemChangeListener itemChangeListener = new ItemChangeListener();

  /**
   * Database instance, it is public in case you prefer to use your server instead of team one
   */

  private Controller() {
    this.model = Model.getModel();
    this.customerView = CustomerView.getCustomerView();
    /**
     * pack and setLocationRelativeTo(null) are used to make the screen appear in centre.
     */
    this.customerView.pack();
    this.customerView.setLocationRelativeTo(null);
    // above 2 lines make the view appear in the centre of the screen.
    this.customerView.setVisible(true);
    this.loginView = LoginView.getLoginView();
    // this.loginView.setVisible(true);

    customerView.setLoginListener(loginListener);
    customerView.registerMenuItemModel(model.getList(), menuItemListener);
    //customerView.registerJcomboBox(itemChangeListener);
    loginView.setHomeListener(homeListener);
    /*
     * when the list is changed according to preferences.
     */
    loginView.setAuthoriseListener(authoriseListener);
    // this.changeList();
  }

  private void changeList() {

  }



    /**
     * Class for creating a listener to Listen to JComboBox. It is not fully or correctly
     * implemented. It will need some modification to display
     */
//    private class ItemChangeListener implements ItemListener {
//      /*
//       * I declared Strings here because they should be initialised somewhere. And after each action
//       * (selecting from the JComboBox) only one of them should change not each one.
//       */
//      private String dealType = "REGULAR_MENU";
//      private String menuType = "MAIN";
//      private String foodType = "NON_VEGETARIAN";
//
//      private ItemChangeListener() {
//
//      }
//
//      @Override
//      public void itemStateChanged(ItemEvent event) {
//        if (event.getStateChange() == ItemEvent.SELECTED) {
//
//          // Item in JComboBox on Which event occurred.
//          Object item = event.getItem();
//          System.out.println();
//          // String representation of the named item.
//          String typeVar = item.toString();
//          System.out.println();
//          // Checking what was selected by printing it.
//          System.out.println(typeVar);
//          System.out.println();
//          /*
//           * getting the JComboBox its client property will be used to identify where the change
//           * occurred
//           */
//          JComboBox jBox = (JComboBox) event.getSource();
//          String selectedType = (String) jBox.getClientProperty("type");
//          // checking which type (JComboBox) out of 3 was selected.
//          System.out.println(selectedType);
//          // types of JComboBox
//
//          if (selectedType.equals("deal_type")) {
//            dealType = typeVar;
//          } else if (selectedType.equals("menu_type")) {
//            menuType = typeVar;
//          } else if (selectedType.equals("food_type")) {
//            foodType = typeVar;
//          }
//
//
//          /**
//           * Getting the new list according to the changes to JComboBox
//           */
//          MenuItemList tempList = null;
//          try {
//            tempList = sqlDB.getMenuItemList(Controller.instance.sqlDB.getConnection(), dealType,
//                menuType, foodType);
//            if (tempList.getSize() == 0) {
//              System.out.println("Nothing has returned");
//            } else {
//              for (int i = 0; i < tempList.getSize(); i++) {
//                System.out.println(tempList.getElementAt(i));
//                // SELECT * FROM menuitems WHERE menuitems.menu_type = 'DESSERT' and
//                // menuitems.deal_type= 'REGULAR_MENU' and menuitems.food_type= 'NON_VEGETARIAN '
//              }
//            }
//          } catch (SQLException e) {
//            e.printStackTrace();
//          }
//
//          Controller.model.setList(tempList);
//          // updates the list that is displayed
//          customerView.registerMenuItemModel(model.getList(), menuItemListener);
//        }
//      }
//    }

    /**
     * Class for creating a listener to Listen to login button on CustomerView screen
     */
    private class LoginListener implements ActionListener {
      private LoginListener() {

      }

      @Override
      public void actionPerformed(ActionEvent event) {
        /** Unnecessary for the time being */
        // gets the button that was pressed
        // JButton btn = (JButton) event.getSource();
        instance.loginView.setVisible(true);
        instance.customerView.setVisible(false);
      }

    }

    /**
     * Class for creating a listener to Listen to Log in button LoginView screen
     */
    private class AuthoriseListener implements ActionListener {
      private AuthoriseListener() {

      }

      @Override
      public void actionPerformed(ActionEvent event) {
        /** Unnecessary for the time being */
        // gets the button that was pressed
        // JButton btn = (JButton) event.getSource();
        /**
         * Login parameters
         */
        String user = instance.loginView.getUserName();
        String password = instance.loginView.getPassword();
        if (user.length() > 15 || user.length() < 5) {
          loginView.showErrorDialog("Username should be between 8 and 15 characters",
              "wrong Username");
        }
        if (user.contains("@") && password.equals("homehome")) {
          instance.loginView.setVisible(false);
          instance.customerView.setVisible(true);
        } else if (user.contains("1")) {
          WaiterViewStub waiter = new WaiterViewStub();
          waiter.main(null);
          /*
           * JOptionPane.showMessageDialog(null, "Wrong Password / Username"); txuser.setText("");
           * pass.setText(""); txuser.requestFocus();
           */
        }
      }

    }

    /**
     * Class for creating a listener to Listen to Home button on any screen and return back to
     * homescreen which is CustomerView (customerscreen)
     */
    private class HomeListener implements ActionListener {
      private HomeListener() {

      }

      @Override
      public void actionPerformed(ActionEvent event) {
        /** Unnecessary for the time being */
        // gets the button that was pressed
        // JButton btn = (JButton) event.getSource();
        /**
         * This method needs changes so that it can be used whenever home buttonis pressed
         */
        goHome(instance.loginView);
      }

    }

    // getter for Controller instance
    public static Controller getController() {
      return instance;
    }

    public void goHome(JFrame jframe) {
      jframe.setVisible(false);
      this.instance.customerView.setVisible(true);
    }

    private class MenuItemSelectionListener implements ListSelectionListener {

      @Override
      public void valueChanged(ListSelectionEvent listEvent) {
        if (listEvent.getValueIsAdjusting()) {
          return;
        }

      }

    }

  }

