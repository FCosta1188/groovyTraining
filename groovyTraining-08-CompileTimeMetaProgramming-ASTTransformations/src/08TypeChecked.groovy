//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/TypeChecked.html
import groovy.transform.TypeChecked

@TypeChecked
class Person {

    String firstName
    String lastName

    String getFullName(){
        "$firstName $lastName"
    }
}
Person p = new Person("Dan","Vega")
println p.toString()