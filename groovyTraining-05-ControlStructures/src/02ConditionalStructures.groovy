// if-else-else if statements

if( true ) {
    println "true"
}

if( true )
    println true

def age = 35
if( age >= 35 ){
    println "can run for president"
}

if(false) {
    println "true"
} else {
    println "false"
}

def yourAge = 18
if( yourAge >= 21 ) {
    println "buy beer"
} else {
    println "no beer for you"
}

def someAge = 37

if( someAge >= 21 && someAge < 35 ) {
    println "buy some beer"
} else if( someAge >= 35 ) {
    println "run for president"
} else {
    println "under 21..."
}
println "---------------------------"


// Ternary operator -> (expression) ? true : false
// Elvis operator -> true ?: false
def name = 'Dan'
def isItDan = (name.toLowerCase() == 'DAN') ? 'YES' : 'NO'
println isItDan

def msg
def output = (msg != null) ? msg : 'default message...'
def elvisOutput = msg ?: 'default message...'
println msg
println output
println elvisOutput
println "---------------------------"


// switch
def num = 12

switch(num) { // cases are evaluated from top to bottom, so if more than one condition is true, only the first one will be considered (if the breaks are placed correctly)
    case 1:
        println "1"
        break
    case 2:
        println "2"
        break
    case 1..3:
        println "in range 1..3"
        break
    case [1,2,12]:
        println "num is in list [1,2,12]"
        break
    case Integer:
        println "num is an Integer"
        break
    case Float:
        println "num is a float"
        break
    default:
        println "default..."
}
println "---------------------------"


// in
def validAges = 18..35
def myAge = 19
println myAge in validAges
println "---------------------------"
