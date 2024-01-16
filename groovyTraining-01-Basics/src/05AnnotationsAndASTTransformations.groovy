//AST = Abstract Syntax Tree
//toString() is an AST transformation.

import groovy.transform.Immutable
/*
https://docs.groovy-lang.org/2.4.7/html/gapi/groovy/transform/Immutable.html
The @Immutable annotation instructs the compiler to execute an AST transformation which adds the necessary getters,
constructors, equals(), hashCode(), toString() and other helper methods that are typically written when creating immutable classes
with the defined properties.
*/
import groovy.transform.Canonical
/*
http://docs.groovy-lang.org/next/html/gapi/groovy/transform/Canonical.html
The @Canonical meta-annotation combines the @EqualsAndHashCode, @ToString and @TupleConstructor annotations.
It is used to assist in the creation of mutable classes. It instructs the compiler to execute AST transformations
which add positional constructors, equals, hashCode and a pretty print toString to your class.
*/
import groovy.transform.Sortable
/*http://docs.groovy-lang.org/next/html/gapi/groovy/transform/Sortable.html
A class annotation used to make a class Comparable by (potentially) multiple Comparators.
The generated Groovy class will:
    - implement the Comparable interface
    - have a compareTo method based on the first, last and age properties (priority ordering will be according to the ordering of property definition, highest first, unless 'includes' is used; in which case, priority will be according to the order given in the includes list)
    - have three Comparator methods named comparatorByFirst, comparatorByLast and comparatorByAge
    - sort by natural order by default, reversed natural order can be specified
The properties within the class must themselves be Comparable or @Sortable.
*/
import groovy.transform.ToString

@Immutable class Customer { //An immutable (final) POJO/POGO (eg: no setters)
    String first, last
    int age
    Date since
    Collection favItems
}

def d = new Date()
//in Groovy constructor it is possible to set properties in any order, by using the property names (myProperty: ...)
def c1 = new Customer(first:'Tom', last:'Jones', age:21, since:d, favItems:['Books', 'Games'])
def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])
def c3 = new Customer('Tommy', 'Jones', 21, d, ['Books', 'Games'])
assert c1 == c2
//assert c1 == c3
println "---------------------"

@Canonical class Client { //A mutable POJO/POGO (eg: setters created)
    String first, last
    int age
    Date since
    Collection favItems = ['Food']
    def object
}

def date = new Date()
def anyObject = new Object()
def cl1 = new Client(first:'Tom', last:'Jones', age:21, since:date, favItems:['Books', 'Games'], object: anyObject)
def cl2 = new Client('Tom', 'Jones', 21, date, ['Books', 'Games'], anyObject)
assert cl1 == cl2
cl2.first = "Tommy"
//assert cl1 == cl2
println "---------------------"

@ToString
@Sortable class Person {
    String first
    String last
    Integer age

    Person(String first, String last, Integer age) {
        this.first = first
        this.last = last
        this.age = age
    }
}

def p1 = new Person("John", "Smith", 50)
def p2 = new Person("Chad", "Lovable", 25)
def people = [p1, p2]
def sortedPeople = people.sort(false /*don't change original collection*/)
println sortedPeople
println "---------------------"
