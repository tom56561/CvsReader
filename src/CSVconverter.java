import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVconverter implements ActionListener {
	private JTextField txtInput;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String savePath = JOptionPane.showInputDialog("Enter the path where you want to save");
		JOptionPane.showMessageDialog(null, "Already save in " + savePath);

		CSVconverter.convert(savePath);
//		CSVconverter runner = new CSVconverter();
//		runner.gui();
	}

	public static void convert(String savaPath) throws FileNotFoundException, IOException {
		// Read
		Reader in = new FileReader("sample_items2.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

		// Write
		FileWriter out = new FileWriter(savaPath);
		CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL);

		for (CSVRecord record : records) {

			for (int i = 0; i < 35; i++) {
				if (i == 4) {
					printer.print(record.get(5));
				} else if (i == 5) {
					printer.print(record.get(4));
				} else {
					printer.print(record.get(i));
				}
			}
			// 換行
			printer.println();
		}
		printer.flush();
		printer.close();
	}

	public void gui() {
		JFrame frame = new JFrame("My First GUI");
		CSVconverter runner = new CSVconverter();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);

		JPanel buttonPanel = new JPanel(true);
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setSize(200, 40);
		buttonPanel.setLocation(0, 0);
		buttonPanel.setLayout(new FlowLayout());
		JButton saveButton = new JButton("SavePath");
		saveButton.setName("SavePath");
		buttonPanel.add(saveButton);
		saveButton.addActionListener(this);
		txtInput = new JTextField(10);
		buttonPanel.add(txtInput);
		txtInput.addActionListener(this);
		frame.add(buttonPanel);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		if (c.getName().equals("SavePath")) {
			String savePath = this.txtInput.getText();
			System.out.print(savePath);
			try {
				this.convert(savePath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
