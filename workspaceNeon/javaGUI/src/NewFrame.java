
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewFrame extends JFrame implements ActionListener
{

	public NewFrame()
	{
		JButton open = new JButton("New Window");
		open.addActionListener(this);
		add(open);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
		new NewFrame();
	}
}
