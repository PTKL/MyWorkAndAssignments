import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author
 *
 */
public class MyFrame extends JFrame implements ActionListener {

    private static String SHOW_ACTION = "show";
    private static String HIDE_ACTION = "hide";

    private Image image = null;
    private boolean showImage = false;

    public MyFrame(String filename) {
        setTitle("MyWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);

        this.image = new ImageIcon(filename).getImage();

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createControls(), BorderLayout.SOUTH);
    }

    private JPanel createControls() {
        JButton showButton = new JButton("Show");
        showButton.addActionListener(this);
        showButton.setActionCommand(SHOW_ACTION);

        JButton hideButton = new JButton("Hide");
        hideButton.addActionListener(this);
        hideButton.setActionCommand(HIDE_ACTION);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(showButton);
        panel.add(hideButton);

        return panel;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (showImage) {
            g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();

        if (SHOW_ACTION.equals(actionCommand)) {
            showImage = true;
        } else if (HIDE_ACTION.equals(actionCommand)) {
            showImage = false;
        }

        repaint();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyFrame frame = new MyFrame("cross.gif");
                frame.setVisible(true);
            }
        });
    }
}
