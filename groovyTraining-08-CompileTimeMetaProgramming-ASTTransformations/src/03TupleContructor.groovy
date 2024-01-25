//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/TupleConstructor.html
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Person {
    String first
    String last
    String email

    // TupleConstructor creates a constructor based in the class properties, following the order in which they are declared
}

Person p = new Person("Dan","Vega","danvega@gmail.com")
println p.toString()
println"--------------------------"