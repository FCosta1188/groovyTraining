import groovy.transform.Sortable
import groovy.transform.ToString

// http://groovy-lang.org/operators.html

// Arithmetic operators and their assignment forms (+= -= *= /= %= **=)
assert 10 + 1 == 11
assert 10 - 1 == 9
assert 10 * 2 == 20
assert 10 / 5 == 2
assert 10 % 3 == 1 // modulo/reminder: the resto/remainder of the division.
assert 10 ** 2 == 100 // power, like Math.pow() in Java.

def a = 10
a += 5 // a = a + 5
assert a == 15
println "---------------------"


// Relational operators
assert 1 + 2 == 3
assert 3 != 4
assert 3 < 4
assert 2 <= 2
assert 5 > 1
assert 5 >= -2
println "---------------------"


// Logical operators
assert !false // NOT
assert true && true // AND
assert true || false // OR
println "---------------------"


// Conditional operators

class User {
    String name
    String password

    User(String name) {
        this.name = name
    }
}

// Ternary Operator
String s = ""
if(s != null && s.length() > 0) {
    result = 'Found'
} else {
    result = 'Not found'
}
s = ""
result = (s != null && s.length() > 0) ? 'Found' : 'Not Found'
println result
println "---------------------"

// Elvis operator (shorthand of ternary operator)
User user = new User('Fra')
displayName = user.name ? user.name : 'Anonymous' // ternary
println displayName // user.name (Fra), because user.name is not empty and the ternary evaluates to true
user.name = ''
displayName = user.name ?: 'Anonymous' // Elvis
println displayName // Anonymous
println "---------------------"


// Object operators

class Address {
    String first
    String second
}

class Person {
    String first
    String last
    Address address
}

// Safe Navigation operator
    // Java
    Person p = new Person()
    if(p.address != null) {
        Address address = p.address
        address.first = "1234 Main"
    }
    // Groovy
    def address = p?.address //checks if the property is null to avoid throwing a null pointer exception. If null, assigns null to address.
    assert address == null
println "---------------------"
