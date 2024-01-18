// Closure Basics
def mymethod(Closure c) {
    c()
}
def foo = {
    println "foo..."
}
mymethod(foo)

List names = ["Dan Vega","Joe Vega","Andy Vega","Katie Vega"]
names.each { name ->
    println name
}

Map teams = [baseball:"Cleveland Indians",basketball:"Cleveland Cavs",football:"Cleveland Browns"]
teams.each { k,v ->
    println "$k = $v"
}

def greet = { String greeting, String name ->
    println "$greeting, $name"
}
greet("Hello","Dan")
def sayHello = greet.curry("Hello")
sayHello("Joe")
println "---------------------------"


// Explore the GDK
List people = [
        [name:'Jane',city:"New York City"],
        [name:'John',city:"Cleveland"],
        [name:'Mary',city:"New York City"],
        [name:'Dan',city:"Cleveland"],
        [name:'Tom',city:"New York City"],
        [name:'Frank',city:"New York City"],
        [name:'Jason',city:"Cleveland"]
]

println people.find { person -> person.city == "Cleveland" }
println people.findAll { person -> person.city == "Cleveland" }
println people.any { person -> person.city == "Cleveland" }
println people.every { person -> person.city == "Cleveland" }
println people.every { person -> person.name.size() >= 3 }

def peopleByCity = people.groupBy { person -> person.city }
println peopleByCity

def newyorkers = peopleByCity["New York City"]
newyorkers.each {
    println it.name
}

def clevelanders = peopleByCity.Cleveland
clevelanders.each {
    println it.name
}
println "---------------------------"