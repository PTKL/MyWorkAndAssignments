import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ReportGUI  extends JFrame implements ActionListener {
    private static final long serialVersionUID = 8679886300517958494L;

    private JButton button;
    private ViewCourseGUI frame2 = null;

    public ReportGUI() {

        //frame1 stuff
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setLayout(new FlowLayout());

        //create button
        button = new JButton("Open other frame");
        button.addActionListener(this);
        add(button);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReportGUI  frame = new ReportGUI();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (frame2 == null)
                frame2 = new ViewCourseGUI();
            if (!frame2.isVisible())
                frame2.setVisible(true);
        }

    }

}
