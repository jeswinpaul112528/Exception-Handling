/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmproject;
import java.util.*;

/**
 *
 * @author jeswinnnn
 */
public class ATMProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        ATMSystem atm = new ATMSystem();

        try {

            System.out.println("================================");
            System.out.println("        ATM SYSTEM ");
            System.out.println("================================");

            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            atm.verifyPIN(pin);

            System.out.println("PIN verified successfully!");

            int choice;

            do {

                System.out.println("\n----------- ATM MENU -----------");
                System.out.println("1.Balance Enquiry");
                System.out.println("2.Deposit");
                System.out.println("3.Withdraw");
                System.out.println("4.Exit");
                System.out.println("--------------------------------");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                try {

                    switch (choice) {

                        case 1:
                            System.out.println(
                                    "Current Balance: Rs."
                                    + atm.getBalance());
                            break;

                        case 2:

                            System.out.print(
                                    "Enter deposit amount: Rs.");

                            double deposit =
                                    sc.nextDouble();

                            atm.deposit(deposit);

                            System.out.println(
                                    "Deposit successful!");

                            System.out.println(
                                    "Current Balance: Rs."
                                    + atm.getBalance());

                            break;

                        case 3:

                            System.out.print(
                                    "Enter withdrawal amount: Rs.");

                            double withdraw =
                                    sc.nextDouble();

                            atm.withdraw(withdraw);

                            System.out.println(
                                    "Withdrawal successful!");

                            System.out.println(
                                    "Please collect your cash.");

                            System.out.println(
                                    "Remaining Balance: Rs."
                                    + atm.getBalance());

                            break;

                        case 4:

                            System.out.println(
                                    "Thank you for using the ATM!");

                            break;

                        default:

                            System.out.println(
                                    "Invalid menu choice.");
                    }

                } catch (InvalidAmountException |
                         InsufficientBalanceException |
                         WithdrawalLimitException e) {

                    System.out.println(
                            "Transaction Failed!");

                    System.out.println(
                            "Reason: " + e.getMessage());
                }

            } while (choice != 4);

        } catch (InvalidPINException e) {

            System.out.println(
                    "Error: " + e.getMessage());

        } finally {

            System.out.println(
                    "\n================================");

            System.out.println(
                    "     ATM SESSION ENDED");

            System.out.println(
                    "================================");

            sc.close();
        }
    }

    
}
