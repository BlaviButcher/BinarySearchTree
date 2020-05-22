import java.io.FileReader;
import java.io.BufferedReader;
public class XProcess
{
    public static BankBST bst = new BankBST();

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.println("Usage: Xprocess \"input_file\"");
            return;
        }
        try
        {
            FileReader fr = new FileReader(args[0]);


            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            String[] tokens;

            // While end of file isn't reached
            while (s != null)
            {
                tokens = s.split(" ");
                // Check if account, transaction type, and amount are present
                if (tokens.length == 3)
                {
                    // Check for syntax of account number and amount
                    if (IsInt(tokens[0]) && IsDouble(tokens[2]))
                    {
                        String transactionType = TransactionType(tokens);
                        if (tokens != null)
                        {
                            // Find account number
                            Account temp = bst.Find((Integer.parseInt(tokens[0])));

                            // if the account was found
                            if (temp != null)
                            {
                                if(transactionType == "c")
                                {
                                    bst.Remove(Integer.parseInt(tokens[0]));
                                    System.out.print("CLOSE" + "\n");
                                }
                                else
                                {
                                    // manipulate balance
                                    temp.setBalance(Double.parseDouble(tokens[2]));
                                    // Print new line, so output is clean
                                    System.out.print(TransactionType(tokens[1]) + "\n");
                                }

                            }
                            // if account was not found, make new account
                            else
                            {
                                temp = new Account(Integer.parseInt(tokens[0]), 0);
                                temp.setBalance(Double.parseDouble(tokens[2]));
                                bst.Insert(temp);
                                // account number was not previously there, therefore print + \n for clean
                                System.out.print(tokens[0] + " " + TransactionType(tokens[1]) + "\n");

                            }
                        }
                    }
                }
                s = br.readLine();
            }
            System.out.println("RESULTS:");
            bst.InOrderTrav();
        }
        catch(Exception e)
        {
            System.out.println("File may not exist : "+ e);
        }

    }

    public static String TransactionType(String type)
    {
        char c = type.charAt(0);
        if(c == 'd') return "DEPOSIT";
        if(c == 'w') return "WITHDRAW";
        else return "CLOSE";
    }
    //Finds the intent of the input (c, d, w)
    public static String TransactionType(String[] tokens)
    {
        String type = null;
        // Try catch : if there is a syntax problem with the intent character then return tokens = null and allow program to continue
        try
        {

            char c = tokens[1].charAt(0);
            if (c == 'd')
            {
            }
            else if (c == 'w')
            {
                double temp = (Double.parseDouble(tokens[2])) * -1;
                tokens[2] = Double.toString(temp);
            }
            else if (c == 'c')
            {
                //Todo: Remove method here
                //so when returned the loop will continue and ignore
                type = "c";
            }
        }
        catch(Exception e)
        {
            tokens = null;
        }
        return type;

    }
    public static boolean IsDouble(String x)
    {
        try
        {
            Double.parseDouble(x);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public static boolean IsInt(String x)
    {
        try
        {
            Integer.parseInt(x);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}