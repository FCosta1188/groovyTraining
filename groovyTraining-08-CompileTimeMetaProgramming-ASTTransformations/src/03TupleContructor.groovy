//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/TupleConstructor.html
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Person {
    String first
    String last
    String email
}

Person p = new Person("Dan","Vega","danvega@gmail.com")
println p.toString()
println"--------------------------"