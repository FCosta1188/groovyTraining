/* http://docs.groovy-lang.org/latest/html/gapi/groovy/lang/Range.html
A Range represents the list of discrete items (eg: integer numbers) between some starting (or from) value and working up towards some ending (or to) value (eg: A-Z, 1-10).
For a reverse range, the list is obtained by starting at the to value and working down towards the from value.
The concept of working up and working down is dependent on the range implementation.
*/

Range r = 1..10
println r // range definition (1..0)
println r.toList() // entire range
println r.toArray() // entire range
println r.class.name
println r.from // starting value
println r.to // ending value

assert (0..10).contains(0) // comparison with true by default
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

assert (0..<10).contains(0)
assert (0..<10).contains(9)
assert (0..<10).contains(10) == false

Range letters = 'a'..'z'
println letters.toList()
println "----------------------------"


Date today = new Date()
Date oneWeekAway = today + 7 // thank the GDK for this simple statement
Range days = today..oneWeekAway

println today
println oneWeekAway
println days.toList()
println "----------------------------"


enum Days {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY, SUNDAY
}

def dayRange = Days.MONDAY..Days.SUNDAY

dayRange.each { day ->
    println day
}

println dayRange.size()
println dayRange.contains(Days.WEDNESDAY)

// next() and previous() are equivalent to ++ and -- operators.
// /!\ REMEMBER that ++ and -- change the value of variables whereas next() and previous() don't (see example below).
def myDay = Days.WEDNESDAY
assert Days.THURSDAY == ++myDay
assert Days.WEDNESDAY == --myDay
assert Days.THURSDAY == myDay.next()
assert Days.TUESDAY == myDay.previous()
println "----------------------------"


