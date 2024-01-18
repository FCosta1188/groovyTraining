def c = { } // by default def considers a declaration with { } as a Closure object
println c.class.name // 02Creating_Closures$_run_closure1, not a specific class name because it is anonymous
println c instanceof Closure // true

def sayHello = { name ->
    println "Hello, $name"
}
sayHello('Dan')

List nums = [1,4,7,4,30,2]
nums.each {
    println it // it (keyword): default for closures, points to current item.
}
nums.each { num -> // custom name for current item.
    println num
}
println "---------------------------"


// Closures are objects therefore, unlike methods, can be passed around in the code (blocks of code acting like anonymous functions).
def timesTen(num, closure) { // or static def timesTen(num, closure). A method which accepts a variable and a closure as arguments.
    closure(num * 10)
}
timesTen(10, { println it }) // 100

// if a closure is the last parameter of a method, the code can be also written as following:
timesTen(2) {
    println it // 20
}

//times is a static method of the class DefaultGroovyMethods, which accepts a number and a closure as arguments.
//times iterates X times based on the number parameters.
// Printing "it" results in the indexes sequence (eg: 10.times: 0-9), but in general the code within the closure is executed X times.

10.times {
    println it
}

Random rnd = new Random()
3.times {
    println rnd.nextInt()
}
println "---------------------------"
