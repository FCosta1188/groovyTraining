//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/Immutable.html
import groovy.transform.Immutable
import groovy.transform.ToString

@ToString
@Immutable // the state of an instance of an immutable (final) class cannot be changed
class Person {
    String first
    String last
}

Person p1 = new Person(first: "Dan",last: "Vega")
println p1.toString()
Person p2 = new Person(first: "Fran",last: "Costa")
println p2.toString()

p.first = "Andy" //groovy.lang.ReadOnlyPropertyException: Cannot set readonly property: first for class: Person
println"--------------------------"