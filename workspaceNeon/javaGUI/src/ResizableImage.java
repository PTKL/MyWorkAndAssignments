import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class  ResizableImage extends JFrame
{
    public ImageIcon imageIcon;
    MyJLabel jLabel;
    public ResizableImage (){
        super("JLabel Demo");
    }
    public void createAndShowGUI()
    {
        imageIcon = new ImageIcon("china_countries_ofdi.png");
        jLabel = new MyJLabel(imageIcon);
        getContentPane().add(jLabel);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                jLabel.repaint();
            }
        });
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jLabel.repaint();
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                ResizableImage demo = new ResizableImage();
                demo.createAndShowGUI();
            }
        });
    }
}
class MyJLabel extends JLabel
{
    ImageIcon imageIcon;
    public MyJLabel(ImageIcon icon)
    {
        super();
        this.imageIcon = icon;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
    }
}
