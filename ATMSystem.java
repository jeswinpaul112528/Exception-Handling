/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject;

/**
 *
 * @author jeswinnnn
 */
public class ATMSystem {

    private double balance;
    private final int correctPIN;
    private final double dailyLimit;
    private double withdrawnToday;

    public ATMSystem() {
        balance = 10000;
        correctPIN = 1234;
        dailyLimit = 5000;
        withdrawnToday = 0;
    }

    public void verifyPIN(int pin)
            throws InvalidPINException {

        if (pin != correctPIN) {
            throw new InvalidPINException(
                    "Invalid PIN! Access denied.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientBalanceException,
            WithdrawalLimitException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (withdrawnToday + amount > dailyLimit) {
            throw new WithdrawalLimitException(
                    "Daily withdrawal limit of Rs.5000 exceeded.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance.");
        }

        balance -= amount;
        withdrawnToday += amount;
    }
}