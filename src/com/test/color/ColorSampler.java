package com.test.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 
 * Name: <br>
 * Project number: <br>
 * Due date: <br>
 * Current date: <br>
 * Description:
 * 
 */
public class ColorSampler extends JFrame implements ActionListener {
	JFrame frameMain;
	JButton buttonShowColor;
	JLabel labelColorName;
	JTextField textFieldColorName;

	ColorSampler() {
		// Initial main frame
		frameMain = new JFrame("Color Chooser Example.");
		frameMain.setSize(1200, 800);
		frameMain.setLocationRelativeTo(null);
		frameMain.getContentPane().setBackground(Color.WHITE);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add label for name of color
		labelColorName = new JLabel("Color name:");
		labelColorName.setBounds(5, 100, 110, 30);
		// Add text field to enter name of color
		textFieldColorName = new JTextField();
		textFieldColorName.setBounds(80, 100, 200, 30);
		// Add button to show the color
		buttonShowColor = new JButton("Show me the color");
		buttonShowColor.setBounds(50, 250, 300, 30);
		// Set button event
		buttonShowColor.addActionListener(this);
		// Add related items to main frame
		frameMain.add(buttonShowColor);
		frameMain.add(labelColorName);
		frameMain.add(textFieldColorName);
		frameMain.setLayout(null);
		frameMain.setSize(400, 400);
		// Display frame
		frameMain.setVisible(true);
	}

	/**
	 * Perform action when click button: Show me the color
	 */
	public void actionPerformed(ActionEvent e) {
		String inputColorName = textFieldColorName.getText();
		Color choseColor = null;
		try {
			choseColor = getColor(inputColorName);
			frameMain.getContentPane().setBackground(choseColor);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(frameMain, "Unknown Color!", "Error happend", JOptionPane.ERROR_MESSAGE);
			frameMain.getContentPane().setBackground(Color.WHITE);
		}
	}

	/**
	 * Get color based on name
	 * 
	 * @param colorName
	 * @return
	 * @throws UnKnownColorException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	private Color getColor(String colorName) throws UnKnownColorException, IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
		Color returnColor = null;
		Field field = Class.forName("java.awt.Color").getField(colorName);
		returnColor = (Color) field.get(null);
		return returnColor;
	}
}