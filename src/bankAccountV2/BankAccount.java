package bankAccountV2;

public class BankAccount {

	//Set Variables For User Info and Balance Info
	static String firstName = "Gryphon";
	static String lastInitial = "M";
	static int accountID = 00001;
	static double balance = 0.0;
	
	//Summarizes Account Info For Label
	public static String accountSummary() {
		return "User: " + firstName + ". " + lastInitial + " | Account ID#: " + accountID;
	}
	
	//Method To Withdraw Money
	public static void withdraw(String textInput) {
		try {
			double withdrawAmount = Double.parseDouble(textInput);
			balance -= withdrawAmount;
		} catch (NumberFormatException e) { //Ensures That Program Doesn't Crash If Non-Number characters are inputed into text field
			System.out.println("Invalid String Format." + e);
		}
	}
	
	//Method To Deposit Money
	public static void deposit(String textInput) {
		try {
			double depositAmount = Double.parseDouble(textInput);
			balance = depositAmount + balance;
		} catch (NumberFormatException e) { //Ensures That Program Doesn't Crash If Non-Number characters are inputed into text field
			System.out.println("Invalid String Format." + e);
		}
	}
	
	//Method Returns Balance Formatted To Two Decimal Places
    public static String getFormattedBalance() {
        return "Current Balance: $" + String.format("%.2f", balance);
    }

	
}
