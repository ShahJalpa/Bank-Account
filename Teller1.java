
/**
 * Assignment 7
 * Teller1 class.
 *
 * @author (your name)
 */


import java.util.Scanner;

public class Teller1
{
    private static final Scanner keyboard = new Scanner(System.in);
    
    private static final char CREATE_NEWACCOUNT = 'C';
    private static final char DEPOSIT = 'D';
    private static final char WITHDRAWAL = 'W';
    private static final char PRINT_ACCOUNTLIST = 'P';
    private static final char QUIT = 'Q';

    public static void main(String[] args)
    {
        Account obj [] = new Account [5];
       // double amount [] = new double [obj.length];
        int counter = 0;
        char tellerMenu = '\u0000';
        do
        {
            tellerMenu = Character.toUpperCase(getTellerMenu());
            

            switch(tellerMenu)
            {
                case CREATE_NEWACCOUNT:     if (counter < 5)
                                            {
                                                obj[counter] = createNewAccount();
                                                System.out.println(" ");
                                                counter++;
                                            }
                                            else
                                            {
                                                System.out.println ("Sorry, no new accounts will be accepted. ");
                                            }
                                            break;
                                            
                case DEPOSIT:               boolean deposit = makeDeposit(obj, counter);
                                            System.out.println(" ");
                                            break;
                                            
                case WITHDRAWAL:            boolean withdraw = makeWithdrawal(obj, counter);
                                            System.out.println(" ");
                                            break;
                                            
                case PRINT_ACCOUNTLIST:     printAllAccounts(obj, counter);
                                            double totalAmtOfAssets = getTotalAmtOfAssets(obj, counter);
                                            System.out.println("Total amount of all assets: " + totalAmtOfAssets);
                                            break;
                                            
                case QUIT:                  System.out.println("Thank you for your transaction.");
                                            break;

                default:                
                                            System.out.println("\n\t\tInvalid choice, \nplease try again.");
            }

        } while(tellerMenu != QUIT);
        
        
    }
    
    public static char getTellerMenu()
    {
        System.out.println();
        System.out.println("    Teller Menu");
        System.out.println("-------------------------------------");
        
        System.out.println(CREATE_NEWACCOUNT + " ......(C)reate New Account ");
        System.out.println(DEPOSIT + " ...... Make a (D)eposit");
        System.out.println(WITHDRAWAL + " ...... Make a (W)ithdrawal");
        System.out.println(PRINT_ACCOUNTLIST +" ......(P)rint Account List");
        System.out.println(QUIT + " ...... (Q)uit Program");
        System.out.println("-------------------------------------");

        System.out.print(            "Enter option: " );

        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        char option = inputLine.charAt(0);

        return option;
    }
    
    public static double getTotalAmtOfAssets(Account [] acct, int count)
    {
        //double balance;
        double totalAmtOfAssets = 0.00;
        for (int i = 0; i < count; i++)
        {
             
                 totalAmtOfAssets += acct[i].getBalance();
             
        }
        return totalAmtOfAssets;
    }
    
    public static Account createNewAccount()
    {
        String firstName;
        String lastName;
        String newAccount; 
        double openingBalanceAmt;
        
        System.out.print("Enter first name: ");
        firstName = keyboard.next();
                                                
        System.out.print("Enter last name: ");
        lastName = keyboard.next();
                                            
        System.out.print("Enter opening balance amount: ");
        openingBalanceAmt = keyboard.nextDouble ();
        
        return new Account (firstName,lastName,openingBalanceAmt);
    }
    
    public static boolean makeDeposit(Account [] acct, int count)
    {
        boolean result = false;
        int temp = 0;
        int accountNumber;
        double deposit;
        while (temp == 0)
        {
            System.out.print("Enter the account number: ");
            accountNumber = keyboard.nextInt();
                                                
            for (int i = 0; i < count; i++)
            {
                if (accountNumber == acct[i].getAccountNumber())                
                {
                     System.out.print("Enter amount to deposit: ");
                     deposit = keyboard.nextDouble();
                     acct[i].deposit(deposit);
                     temp++;
                     result = true;
                }
            }
        }
        return result;
    }
    
    public static boolean makeWithdrawal(Account [] acct, int count)
    {
        boolean result = false;
        int temp = 0;
        //count = 0;
        int accountNumber;
        double withdraw;
        while (temp == 0)
        {
            System.out.print("Enter the account number: ");
            accountNumber = keyboard.nextInt();
            
            for (int i = 0; i < count; i++)
            {
                if (accountNumber == acct[i].getAccountNumber())
                {
                    System.out.print("Enter amount to withdraw: ");
                    withdraw = keyboard.nextDouble ();
                                                         
                    if (withdraw > acct[i].getBalance() || withdraw < 0)
                    {
                        System.out.println("withdraw failed."); 
                        temp++;
                        result = false;
                    }
                    else
                    {
                        acct[i].withdraw(withdraw);
                        temp++;
                        result = true;
                    }
                }
            }
        }
        return result;
    }
    
    public static void printAllAccounts(Account [] acct, int count)
    {
        if (count <= 0)
        {
            System.out.println ("You must first create 1 or more new accounts.");
        }
        else
        {
            System.out.println(" ");
            System.out.println("Account Information");
            System.out.println (" ");
            System.out.printf("%24s %15s %11s" , "Customer name", "Account#", "Account Balance" );
            System.out.println(" ");
            for (int i = 0; i < count; i++)
            {
                 System.out.println(acct[i]);
            }
        }
    }
}

