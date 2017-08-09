// Account.java

import java.text.NumberFormat;		// for toString() method

public class Account
{
        /*  Instance fields
        */
    private String m_sFirstName;
    private String m_sLastName;
    private double m_fBalance;
    private int m_nAcctNumber;

        /*  Class field for generating new account numbers.
        */
    private static int nextAcctNumber = 1000;

        /** Constructor requiring that all new accounts must
         *  have initial field values.
        */
    public Account( String first, String last, double amount )
    {
        m_sFirstName = first;
        m_sLastName = last;
        m_fBalance = (amount >= 0.0) ? amount : 0.0;

        m_nAcctNumber = nextAcctNumber++;
    }

        /** Copy Constructor, for making a copy w/same acct#.
        */
    public Account(Account acct)
    {
        m_sFirstName = acct.m_sFirstName;
        m_sLastName = acct.m_sLastName;
        m_fBalance = acct.m_fBalance;
        m_nAcctNumber = acct.m_nAcctNumber;
    }


        /** Method to get this account number.
        */
    public int getAccountNumber()
    {
        return m_nAcctNumber;
    }

        /** Method to get this account balance.
        */
    public double getBalance()
    {
        return m_fBalance;
    }

        /** Method to add an amount to this account balance.

         *  Returns true if the amount is positive, otherwise
         *  it returns false without making a deposit.
        */
    public boolean deposit( double amount )
    {
        boolean result = false;

        // Accept only positive amounts.

        if( amount >= 0.0 )
        {
            m_fBalance += amount;
            result = true;
        }

        return result;
    }

        /** Method to subtract an amount from this account balance.

         *  Returns true if the amount is positive AND <= this
         *  account balance, otherwise it returns false without
         *  making a withdrawal.
        */
    public boolean withdraw( double amount )
    {
        boolean result = false;

        // Accept only positive amounts and,
        // do not allow negative balance.

        if( 0.0 <= amount && amount <= m_fBalance )
        {
            m_fBalance -= amount;
            result = true;
        }

        return result;
    }

        /** Method to return the String representation of this account.
        */
    public String toString()
    {
        NumberFormat dollar = NumberFormat.getCurrencyInstance();

        StringBuilder sb = new StringBuilder(
										String.format("%15s", m_sLastName) );

        sb.append( ", " );
        sb.append( String.format("%-15s", m_sFirstName) );
        sb.append( String.format("%5d", m_nAcctNumber) );
        sb.append( String.format("%15s", dollar.format(m_fBalance)) );

        return sb.toString();
    }
}
