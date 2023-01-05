import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiRunner implements ActionListener{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First GUI");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);

		JPanel buttonPanel = new JPanel(true);
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setSize(500, 40);
		buttonPanel.setLocation(0, 0);
		JButton saveButton = new JButton("SavePath");
		saveButton.setName("SavePath");
		buttonPanel.add(saveButton);
		saveButton.addActionListener(null);
		
		frame.getContentPane().add(button); // Adds Button to content pane of frame

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		if (c.getName().equals("Quit")) {
			System.exit(0);
		}

	}

}
