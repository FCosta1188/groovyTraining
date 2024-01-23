//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/ToString.html
import groovy.transform.ToString

@ToString(includeNames = true, excludes = ["email"]) // see docs for other options
class Person {
    String first
    String last
    String email
}

Person p = new Person(first:"Dan",last: "Vega", email: "danvega@gmail.com")
println p.toString()
println"--------------------------"