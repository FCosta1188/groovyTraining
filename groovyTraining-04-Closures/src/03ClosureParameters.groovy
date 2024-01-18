// implicit parameter (it)
def itParam = {
    println it
}
itParam('dan')

// no parameters
def noParams = { ->
    println "no params..."
}
noParams()

// explicit params (1+)
def params = { String first, String last ->
    println "Hello, $first $last"
}
params("Dan", "Vega")
println "---------------------------"


// default values
def defaultValues = { String name, String greeting = "Howdy" ->
    println "$greeting, $name"
}
defaultValues("Dan","Hello")
defaultValues("Joe")
println "---------------------------"


// var-arg (...): used for accepting an undefined number of arguments (1+). Valid for regular methods too.
def concat = { String... args ->
    args.join('.') // the argument of join() is the separator
}
println concat('abc','def')
println concat('abc','def','123','456')
println "---------------------------"


// A Closure object has properties which describe the closure itself (number of params, types, etc.).
// For example, this can be used to inspect the arguments/parameters.
def someMethod(Closure c) {
    println "$c.class: max params $c.maximumNumberOfParameters, param types $c.parameterTypes"
}
def someClosure = { int x, int y -> x + y }

someMethod(someClosure)
println "---------------------------"
