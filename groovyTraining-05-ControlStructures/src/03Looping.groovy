// while
List numbers = [1,2,3]
while(numbers) { // evaluates to true as long as the list is not empty (3 iterations)
    print(numbers.size())
    numbers.remove(0)
    print " -> $numbers.size"
    println()
}

assert numbers == []
println "---------------------------"


// for
// for(variable in iterable) { //some logic }
List nums = [1,2,3]
for(Integer i in nums) {
    println i
}

for(Integer i in 1..10) {
    println i
}

for(i in 1..5) {
    println i
}
println "---------------------------"


// return/break/continue
String getFoo() {
    "foo" // return is implicit
}
println getFoo()

Integer a = 1
while(true) { // infinite loop if no break
    a++
    break
}
assert a == 2

for(String s in 'a'..'z'){
    if(s == 'a') continue
    println s
    if(s > 'b') break
}
println "---------------------------"