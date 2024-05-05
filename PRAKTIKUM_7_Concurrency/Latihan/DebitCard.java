package PRAKTIKUM_7_Concurrency.Latihan;

public class DebitCard {
    private int balance;
    private TransactionVerificator verificator;
    private TransactionHistory history;

    public DebitCard(int balance) {
        this.balance = balance;
        verificator = new TransactionVerificator();
        history = new TransactionHistory();
    }

    public void printTransactionsHistory() {
        history.printTransactionsHistory();
        System.out.println("\nCurrent balance: " + balance);
    }

    public void withdraw(int amount){
        if(verificator.isFraud(amount)){
            if (verificator.verifyWithdraw(balance, amount)) {
                synchronized (this) {
                balance -= amount;
                history.addWithdraw(amount, true);
                }
            } else {
                history.addWithdraw(amount, false);
            }
        }
    }

    public void deposit(int amount){
        if(verificator.isFraud(amount)){
            if (verificator.verifyDeposit(balance, amount)) {
                synchronized (this) {
                balance += amount;
                history.addDeposit(amount, true);
                }
            } else {
                history.addDeposit(amount, false);
            }
        }
    }



}
