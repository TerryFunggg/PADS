package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import linkedList.EmptyListException;
import calculator.CalculatorCore;

public class CalculatorUI  implements ActionListener{
	private final int HEIGHT = 450;
	private final int WIDTH = 400;
	private final int NUMOFNUMPAD = 17;
	private CalculatorCore core;
	private JFrame jFrame;
	private JTextField resultTextField;
	private String[] numPad;
	private String result;
	
	public CalculatorUI() {
		core = new CalculatorCore();
		jFrame = new JFrame("Calculator");
		result = "0";
		resultTextField = new JTextField(result,8);
		numPad = initNumPad();
		
	}
	
	public void init() throws EmptyListException {
		
		// Window setting
		jFrame.setResizable(true);
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setLocation(10, 10);
        jFrame.setVisible(true);
        
        // Panel
        Container container = jFrame.getContentPane();
        JPanel numPadPanel = new JPanel();
        	JPanel displayPanel = new JPanel();
        	numPadPanel.setLayout(new GridLayout(4, 4, 5, 5));
        	resultTextField.setEditable(false);
        	resultTextField.setFont(new Font("Aria",Font.PLAIN,50));
        	resultTextField.setAlignmentX((TextField.RIGHT_ALIGNMENT));
        	displayPanel.add(resultTextField);
        	displayPanel.setLayout(new FlowLayout(3));
        	container.add(numPadPanel , BorderLayout.CENTER);
        	container.add(displayPanel , BorderLayout.NORTH);
        	
        	// Button
        	JButton[] buttons = new JButton[NUMOFNUMPAD];
        	for (int i = 0; i < NUMOFNUMPAD; i++) {
				buttons[i] = new JButton(numPad[i]);
				numPadPanel.add(buttons[i]);
				buttons[i].addActionListener(this);
			
		}
        	buttons[16].setPreferredSize(new Dimension(55,55));
        	displayPanel.add(buttons[16]);
        
        	
        
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		switch (button) {
		
		case "C":
			result = "0";
			resultTextField.setFont(new Font("Aria",Font.PLAIN,50));
			resultTextField.setText(result);
			break;
		case "=":
				try {
					core.setEquation(result);
					result = core.process()+ "";
					if(result.length() > 11) {
						resultTextField.setFont(new Font("Aria",Font.PLAIN,30));
					}
					resultTextField.setText(result);
				} catch (EmptyListException | EmptyEquationException | NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
				}
			break;
		default:
			if(result == "0") {
				result = "";
			}else if(result == "0" && button != "0") {
				result = "0";
			}
			result += button;
			resultTextField.setText(result);
			break;
		}
		
	}
	
	private String[] initNumPad() {
		return new String[]{
				"7","8","9","/",
				"4","5","6","*",
				"1","2","3","-",
				"0",".","=","+","C"
		};
	}
}
