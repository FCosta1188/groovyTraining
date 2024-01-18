/* https://groovy-lang.org/semantics.html#the-groovy-truth
Set of rules applied by Groovy to decide whether an expression is true or false.
*/

// Boolean: value is true
assert true
assert !false

// Matcher: has match
assert ('a' =~ /a/)
assert !('a' =~ /b/)

// Collection: is not empty
assert [1]
assert ![]

// Map: is not empty
assert [1:'one']
assert ![:]

// String: is not empty
assert 'a'
assert !''

// Number: is not 0
assert 1
assert 3.5
assert !0

// None of the above: object reference is not null
assert new Object()
assert !null