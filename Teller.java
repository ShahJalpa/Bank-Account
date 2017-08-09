
/**
 * Write a description of class Teller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Teller
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
        int counter = 0;
        String firstName;
        String lastName;
        String newAccount;
        double openingBalanceAmt;
        int accountNumber;
        double deposit;
        double withdraw;
               
        char tellerMenu = '\u0000';
        do
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

            System.out.print("Enter option: " );
            
            char option = keyboard.next().charAt(0);
            tellerMenu = Character.toUpperCase(option);
            
            int temp = 0;
            switch(tellerMenu)
            {
                case CREATE_NEWACCOUNT:     
                                            if (counter < 5)
                                            {
                                                System.out.print("Enter first name: ");
                                                firstName = keyboard.next();
                                                
                                                System.out.print("Enter last name: ");
                                                lastName = keyboard.next();
                                            
                                                System.out.print("Enter opening balance amount: ");
                                                openingBalanceAmt = keyboard.nextDouble ();
                                                
                                                obj[counter]=new Account(firstName,lastName,openingBalanceAmt);
                                                System.out.println(" ");
                                                
                                                counter ++;
                                                                                                                                           }
                                            else
                                            {
                                                System.out.println ("Sorry, no new accounts will be accepted. ");
                                            }
                                            break;
                                            
                case DEPOSIT:               while (temp == 0)
                                            {
                                                System.out.print("Enter the account number: ");
                                                accountNumber = keyboard.nextInt();
                                                
                                                for (int i = 0; i < counter; i++)
                                                {
                                                    if (accountNumber == obj[i].getAccountNumber())
                                                    {
                                                        System.out.print("Enter amount to deposit: ");
                                                        deposit = keyboard.nextDouble();
                                                        obj[i].deposit(deposit);
                                                        temp++;
                                                    }
                                                }
                                            }
                                            System.out.println(" ");
                                            break;
                                            
                case WITHDRAWAL:            while(temp == 0)
                                            {
                                                System.out.print("Enter the account number: ");
                                                accountNumber = keyboard.nextInt();
                                                for (int i = 0; i < counter; i++)
                                                {
                                                    if (accountNumber == obj[i].getAccountNumber())
                                                    {
                                                         System.out.print("Enter amount to withdraw: ");
                                                         withdraw = keyboard.nextDouble ();
                                                         
                                                         if (withdraw > obj[i].getBalance() || withdraw < 0)
                                                         {
                                                              System.out.println("withdraw failed."); 
                                                              temp++;
                                                         }
                                                         else
                                                         {
                                                              obj[i].withdraw(withdraw);
                                                              temp = 1;
                                                         }
                                                    }
                                                }
                                            }
                                            System.out.println(" ");
                                            break;
                                            
                case PRINT_ACCOUNTLIST:     if (counter <= 0)
                                            {
                                              System.out.println ("You must first create 1 or more new accounts.");
                                            }
                                            else
                                            {
                                                System.out.println(" ");
                                                System.out.println("Account Information");
                                                System.out.println (" ");
                                                System.out.printf("%24s %15s %11s" , "Customer name", "Account#", "Balance" );
                                                System.out.println(" ");
                                                for (int i = 0; i < counter; i++)
                                                {
                                                    System.out.println(obj[i]);
                                                }
                                            }
                                            break;
                                            
                case QUIT:                  System.out.println("Thank you for your transaction.");
                                            break;

                default:                
                                            System.out.println("\n\t\tInvalid choice, please try again.");
            }

        } while(tellerMenu != QUIT);
    }
}


