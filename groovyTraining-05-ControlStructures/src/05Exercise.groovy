class Account {
    BigDecimal balance = 0.0

    void deposit(def amount) {
        if (amount >= 0) {
            balance += amount
            println "$amount EUR added to account"
        } else
            throw new Exception("Deposit amount cannot be lower than 0 EUR")
    }

    void deposit(List amounts) {
        for (amount in amounts) {
            deposit(amount)
        }
    }
}

Account account = new Account()
try {
    account.deposit(100)
    account.deposit(-50)
} catch (Exception e) {
    println e.message
}
println account.balance

try {
    account.deposit([199, -50, 500, -20, 200])
} catch (Exception e) {
    println e.message
}
println account.balance
println "---------------------------"
