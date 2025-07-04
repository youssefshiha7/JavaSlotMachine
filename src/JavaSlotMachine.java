import java.util.Random;
import java.util.Scanner;

public class JavaSlotMachine {
    public static void main(String[] args) {
        //Java Slot Machine

        // Declare Variables
        Scanner scanner = new Scanner(System.in);
        int balance=10000;
        int bet;
        int payout = 0;
        int options;
        System.out.println("****************************");
        System.out.println("Welcome to Java Slot Machine");
        System.out.println("Symbols : 😂 ✔ 🎉 🍉 🍒");
        System.out.println("****************************");

        while(balance > 0){
            System.out.printf("Current Balance: $%s%n",balance);
            System.out.print("Enter your bet amount: ");
            bet=scanner.nextInt();
            if(bet < 0){
                System.out.println("Bet Can't be less than 0");
                continue;
            } else if (bet > balance) {
                System.out.println("INSUFFICIENT FUNDS");
                continue;
            }else{
                balance-=bet;
            }
            balance=RunSpin(balance,payout,bet);
            System.out.printf("1-Again %n2-Ext %n");
            options=scanner.nextInt();

            if(options==2){
                System.out.println("See you soon");
                break;
            } else {
                if (options != 1) {
                    System.out.println("Wrong option");
                }
            }

        }
        if(balance<0){
            System.out.print("You don't have enough balance: "+balance);
        }
    }

    private static int RunSpin(int balance ,int payout , int bet) {

        String[] symbols={"😂","✔","🎉","🍉","🍒"};
        String[] row= new String[3];
        Random random= new Random();
        boolean isWin=false;

        for (int itr=0;itr<3;itr++)
        {
            row[itr]=symbols[random.nextInt(symbols.length)];
            if(itr==2){
                if(row[0].equals(row[1]) && row[1].equals(row[2])){
                    isWin=true;
                    switch (row[0]) {
                        case "🍒" -> {
                            payout += bet * 5;
                            balance += payout;
                            return balance;
                        }
                        case "😂" -> {
                            payout += bet;
                            balance += payout;
                            return balance;
                        }
                        case "🍉" -> {
                            payout += bet * 3;
                            balance += payout;
                            return balance;
                        }
                        case "✔" -> {
                            payout += bet * 2;
                            balance += payout;
                            return balance;
                        }
                        case "🎉" -> {
                            payout += bet * 4;
                            balance += payout;
                            return balance;
                        }
                    }
                }
            }
        }
        showResult(row);
        if(isWin){
            System.out.println("You have WON");
        }else {
            System.out.println("Try Again you lost");
        }
        return balance;
    }

    private static void showResult(String[] row) {
        for(String column: row){
            System.out.print(column+" ");
        }
        System.out.println();
    }
}
