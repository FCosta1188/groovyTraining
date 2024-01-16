String name = null
//String name = ""
//String name = "myName"

if(name) //null and empty strings ("") evaluate to false, so in those cases the if block won't be executed
    println "name has a value: $name"
println "---------------------"

def i = 1
while (i <= 3) {
    println i++
}
println "---------------------"

def numbers = [2,4,6]
for (n in numbers) {
    println n
}
numbers.each {println it} //closure (replaces the for-each loop, in this case)
println "---------------------"

def num = 10
switch(num) { //unlike Java, Groovy switch allows to evaluate expressions in the cases, not only "equals"
    case (num <= 10):
        println "success"
        break
    default:
        println "failure"
        break
}
println "---------------------"