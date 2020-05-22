public class BankBST
{
    // Todo: Set to private
    public Account root;
    private BankBST left;
    private BankBST right;

    public void Insert(Account account)
    {

        if(root == null)
        {
            root = account;
            left = new BankBST();
            right = new BankBST();
            return;
        }
        else

            if (account.getKey() < root.getKey())
            {

                left.Insert(account);
            }
            else right.Insert(account);

    }
    public Account Find(int account)
    {
        try
        {
            if (root == null) return null;
            if (account == root.getKey())
            {
                System.out.print(root.getKey() + " ");
                return root;
            }
            if (account < root.getKey())
            {
                System.out.print(root.getKey() + " ");
                return left.Find(account);
            }
            else
            {
                System.out.print(root.getKey() + " ");
                return right.Find(account);
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("A problem has occured");
        return null;
    }
    public void InOrderTrav()
    {
        if(root == null) return;
        System.out.println(root.getKey() + " " + "$" + root.getBalance());
        left.InOrderTrav();
        right.InOrderTrav();
    }
    public void Remove(int account)
    {
        if(root == null) return;
        if(account == root.getKey())
        {
            if(left.root != null && right.root != null)
            {
                BankBST tmp = right.FindMin();
                root = tmp.root;
                right.Remove(tmp.root.getKey());
            }
            else if(right.root != null)
            {
                BankBST tmp = right.FindMin();
                root = tmp.root;
                right.Remove(tmp.root.getKey());
            }
            else if(left.root != null)
            {
                BankBST tmp = left.FindMax();
                root = tmp.root;
                left.Remove(tmp.root.getKey());
            }
            else root = null;
        }
        else if(account < root.getKey())
        {
            left.Remove(account);
        }
        else right.Remove(account);

    }
    public BankBST FindMin()
    {
        if(left.root == null) return this;
        else return left.FindMin();

    }
    public BankBST FindMax()
    {
        if(right.root == null) return this;
        else return right.FindMax();
    }


}



