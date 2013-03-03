import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class UserInterface extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2832522444027044012L;
	JPanel panel;
	JPanel southPanel;
	JPanel centerPanel;
	JLabel label;
	JButton classify;
	JButton train;
	JTextField myClass;
	STDrawPanel drawpanel;

	public UserInterface() {
		super("THE WORK WINDOW");

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		// panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.NORTH);
		// panel.add(null,BorderLayout.CENTER);

		classify = new JButton("Classify");
		classify.setBackground(Color.GRAY);
		classify.isVisible();
		classify.setSize(80, 200);
		classify.addActionListener(this);

		train = new JButton("Train");
		train.setBackground(Color.GRAY);
		train.isVisible();
		train.setSize(80, 200);
		train.addActionListener(this);

		centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		label = new JLabel("Class: ");
		myClass = new JTextField(2);
		centerPanel.add(label);
		centerPanel.add(myClass);
		add(centerPanel, BorderLayout.CENTER);

		southPanel = new JPanel();
		southPanel.setOpaque(false);
		southPanel.add(classify);
		southPanel.add(train);
		add(southPanel, BorderLayout.SOUTH);

		// label= new JLabel();
		// label.setSize(400,400);
		// label.setBackground(Color.black);
		// label.setBounds(40, 40,100,100);
		// panel.add(label, BorderLayout.CENTER);

		drawpanel = new STDrawPanel();
		panel.add(drawpanel, BorderLayout.NORTH);
		STMouseAdapter mAdapter = new STMouseAdapter(drawpanel);
		drawpanel.addMouseListener(mAdapter);
		drawpanel.addMouseMotionListener(mAdapter);

	}

	public static void main(String[] args) {
		UserInterface object = new UserInterface();
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.setSize(425, 600);
		object.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == train) {
			
			int classNumber = Integer.parseInt(myClass.getText());
			
			String path = "class " + classNumber;
			File dir = new File(path);
			
			if (!dir.exists()) {
				dir.mkdir();
			}

			File[] listOfFiles = dir.listFiles();
			int minClass = 0;
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].getName().length() == 7 && Character.digit(listOfFiles[i].getName().charAt(2), 10) >= minClass)
				{
					minClass = Character.digit(listOfFiles[i].getName().charAt(2), 10) + 1;
				}
			}
			File text = new File("Test_Data/Text.txt");
			boolean success = text.renameTo(new File(dir, "f" + classNumber + minClass + ".txt"));
			drawpanel.clear(); 
			panel.updateUI();
			
		} else if (source == classify) {
			finalrun.recognize();
			myClass.setText(Integer.toString(finalrun.max_index));
			File text = new File("Test_Data\\Text.txt");
			boolean success = text.delete();
			if (!success) {
				System.out.println("delete not successful.");
			}
			drawpanel.clear();
			panel.updateUI();
		}
	}
}
