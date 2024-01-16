import groovy.transform.ToString

class Account {

    BigDecimal balance = 0.0

    Account plus(Account other) {
        new Account(balance: this.balance + other.balance) // implicit return
    }

    String toString() { // Override implicit in Groovy, no need for @Override annotation
        "Account Balance: $balance"
    }
}

@ToString
class AccountDemo {

    BigDecimal balance = 0.0
    String type

    void deposit(BigDecimal amount) {
        balance += amount
    }

    void withdraw(BigDecimal amount) {
        balance -= amount
    }

    BigDecimal plus(AccountDemo otherAccountDemo) {
        this.balance + otherAccountDemo.balance // implicit return
    }
}

// Different reference types include the method plus, which can be overridden based on the user needs
def a = 1
def b = 2
println a + b // implicit call to the plus() method included in the Integer class
println a.plus(b)
def s1 = "Hello"
def s2 = ", World!"
println s1 + s2 // implicit call to the plus() method included in the String class
println s1.plus(s2)
println "-----------------------------------"

Account savings = new Account(balance:100.00)
Account checking = new Account(balance:500.00)
println savings
println checking
println savings + checking // using + is an implicit call to the plus() method, if it as been defined. If not, an exception is thrown.
println "-----------------------------------"

// Exercise
AccountDemo checkingDemo = new AccountDemo(type:"Checking")
checkingDemo.deposit(100.00)
println checkingDemo

AccountDemo savingsDemo = new AccountDemo(type:"Savings")
savingsDemo.deposit(50.00)
println savingsDemo

BigDecimal totalDemo = checkingDemo + savingsDemo
println totalDemo
println "-----------------------------------"