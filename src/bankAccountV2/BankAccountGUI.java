package bankAccountV2;

import java.awt.Font;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Dimension;


public class BankAccountGUI {
	
	// Set it as a class-level variable to allow it to update
	private static JLabel balanceLabel;
	
	public static void main(String[] args) {
		
		//Set up Main GUI
		JFrame mainGUI = new JFrame();
		mainGUI.setSize(600, 600);
		mainGUI.setTitle("Online Banking System");
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setLayout(new BorderLayout()); 
		
		// Create Panels
		JPanel welcomePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		
		//Set Welcome Panel Layout
		welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
		
		//Create And Adjust Account Info Label
		Font accntInfoFont = new Font("Arial", Font.BOLD, 10);
		JLabel accountInfoLabel = new JLabel(BankAccount.accountSummary());
		accountInfoLabel.setFont(accntInfoFont);
		accountInfoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		//Create Some Welcome Text
		JLabel welcomeLabel = new JLabel("Welcome To The Online Banking System.");
		welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		//Create and Adjust Current Balance Label
		String balanceFormat = String.format(BankAccount.getFormattedBalance());
		Font balanceFont = new Font("Arial", Font.BOLD, 16);
		balanceLabel = new JLabel(balanceFormat);
		balanceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		balanceLabel.setFont(balanceFont);
		
		//Add All Elements To The Welcome Panel
		welcomePanel.add(accountInfoLabel);
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(Box.createVerticalStrut(20)); //Adds Blank Space Between welcomeLable and balanceLabel
		welcomePanel.add(balanceLabel);
		welcomePanel.add(Box.createVerticalStrut(50));
		
		//Set Main Panel Layout
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		//Create And Adjust User Input Text Field
		JTextField userInputField = new JTextField();
		userInputField.setMaximumSize(new Dimension(200, 30));
		userInputField.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		userInputField.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		
		//Create Withdraw Button w/ Event Listener
		JButton withdrawButton = new JButton();
		withdrawButton.setText("Withdraw");
		withdrawButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		withdrawButton.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		//Action Listener For Withdraw Button
		withdrawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				//Gets User Input From Text Box
				String textInput = userInputField.getText();
				
				BankAccount.withdraw(textInput);
				updateBalanceLabel();
				
			}
		
		});
		
		//Create Deposit Button w/ Event Listener
		JButton depositButton = new JButton();
		depositButton.setText("Deposit");
		depositButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		depositButton.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		//Action Listener For Deposit Button
		depositButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Gets User Input From Text Box
				String textInput = userInputField.getText();
				
				BankAccount.deposit(textInput);
				updateBalanceLabel();
				
			}
		});
		
		
		//Add All Elements To Main Panel
		mainPanel.add(userInputField);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(withdrawButton);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(depositButton);
		
		//Add And Place Panels Into Main Frame
		mainGUI.add(welcomePanel, BorderLayout.NORTH);
		mainGUI.add(mainPanel, BorderLayout.CENTER);
		
		// Make Frame Visible
		mainGUI.setVisible(true);
		
	}
	
	// Method To Update Balance Label
    private static void updateBalanceLabel() {
        BankAccountGUI.balanceLabel.setText(BankAccount.getFormattedBalance());
    }
}
