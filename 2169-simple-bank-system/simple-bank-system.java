class Bank {

    private long[] balanceAccounts;
    private int numAccounts;
    public Bank(long[] balance) {
        this.balanceAccounts = balance;
        this.numAccounts = balance.length;
        // how to initialise here. 
    }
    private boolean accountExists(int account){
        if(account < 1 || account > numAccounts) return false;
        return true;
    }
    public boolean transfer(int account1, int account2, long money) {
        if(!accountExists(account1) || !accountExists(account2) || balanceAccounts[account1 - 1] < money) return false;
        balanceAccounts[account1 - 1] -= money;
        balanceAccounts[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!accountExists(account)) return false;
        balanceAccounts[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!accountExists(account) || balanceAccounts[account - 1] < money) return false;
        balanceAccounts[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */