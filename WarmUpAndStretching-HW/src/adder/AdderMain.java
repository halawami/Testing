﻿package adder;


// Import classes needed for appearance
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
// TODO: Import additional classes needed for event handling
// import container for all of the buttons.


/**
 * A simple calculator that only does addition of non-negative numbers.
 * 
 *  TODO
 * @author Claude Anderson and Hussein Alawami. Created Oct 12, 2011.
 */
public class AdderMain {


	@SuppressWarnings("unused")  // You will write code to use it, then this suppression will be unnecessary.
	private static long sum=0;
	
	
	/**
	 * Set up the AdderGUI to respond to button clicks.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final int WIDTH = 300, HEIGHT = 450;
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Adder");

		// Create the text field that displays numbers.
		final JTextField display = new JTextField("0", 20);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Helvetica", Font.BOLD, 24));

		// Make a panel to hold the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
		
		Font f = new Font("Helvetica", Font.BOLD, 48);

		// Create the top nine buttons (1-9) and add them to the panel.
		// label each button with a string representing the button's value.
		ArrayList<JButton> buttonList = new ArrayList<JButton>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				JButton b = new JButton(7 - 3*row + col + "");
				b.setFont(f);
				buttonList.add(b);
				buttonPanel.add(b);
			}
		}
		// Create and add the bottom three buttons.
		String[] remainingButtonLabels = {"C", "0", "+"};
		for (String s : remainingButtonLabels) {
			JButton b = new JButton(s);
			b.setFont(f);
			buttonList.add(b);
			buttonPanel.add(b);
		}
	
		// Add both components to the frame.
		frame.add(buttonPanel);
		frame.add(display, BorderLayout.NORTH);
		frame.add(buttonPanel);
		final int[] sum = {0};
		final String[] oldString = {""};
		for(JButton b:buttonList){
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub.
					switch(e.getActionCommand()){
					case "C":
						sum[0]=0;
						oldString[0] = "";
						display.setText(new String("0"));
						break;
					case "1":
						if(oldString[0].equals("0")){
							oldString[0] = "1";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "1";
						display.setText(oldString[0]);
						break;
					case "2":
						if(oldString[0].equals("0")){
							oldString[0] = "2";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "2";
						display.setText(oldString[0]);
						break;
					case "3":
						if(oldString[0].equals("0")){
							oldString[0] = "3";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "3";
						display.setText(oldString[0]);
						break;
					case "4":
						if(oldString[0].equals("0")){
							oldString[0] = "4";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "4";
						display.setText(oldString[0]);
						break;
					case "5":
						if(oldString[0].equals("0")){
							oldString[0] = "5";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "5";
						display.setText(oldString[0]);
						break;
					case "6":
						if(oldString[0].equals("0")){
							oldString[0] = "6";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "6";
						display.setText(oldString[0]);
						break;
					case "7":
						if(oldString[0].equals("0")){
							oldString[0] = "7";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "7";
						display.setText(oldString[0]);
						break;
					case "8":
						if(oldString[0].equals("0")){
							oldString[0] = "8";
							display.setText(oldString[0]);
							break;
						}
						oldString[0] += "8";
						display.setText(oldString[0]);
						break;
					case "9":
						if(oldString[0].equals("0")){
							oldString[0] = "9";
							display.setText(oldString[0]);
							break;
						}oldString[0] += "9";
						display.setText(oldString[0]);
						break;
					case "0":
						if(oldString[0].equals("0")){
							break;
						}
						oldString[0] += "0";
						display.setText(oldString[0]);
						break;
					case "+":
//						if(Integer.parseInt(display.getText())==sum[0] && !oldString.equals(display.getText())){
//							break;
//						}
						sum[0] += Integer.parseInt(oldString[0]);
						display.setText(new String(Integer.toString(sum[0])));
						oldString[0] = "";
						break;
						
					}
				}
			});
		}
		// TODO:  Add the rest of the code needed to get a working "Adding calculator":
		// Most of the additional code (but not all) can be written below this point)
			// 1.  Pressing C should set both the displayed value and the sum to 0.
		    // 2.  Pressing + adds the current displayed value to the sum and displays the new sum.
			// 3. Pressing a number key works like on a real calculator. 
		    //    The value of the number represented by the sequence of key presses is displayed on the screen. 
		
		/* Example of a sequence of button presses and what should be displayed after each:
		 * 
		 *       0  (initial display before any buttons are pressed)
		 *  2    2
		 *  3    23
		 *  +    23
		 *  5    5
		 *  6    56
		 *  +    79
		 *  0    0
		 *  0    0
		 *  1    1
		 *  8    18
		 *  C    0
		 *  3    3
		 *  +    3
		 *  2    2
		 *  +    5
		 *  
		 */
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}


