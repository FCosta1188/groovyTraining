//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/builder/Builder.html
import groovy.transform.ToString
import groovy.transform.builder.Builder

@Builder
@ToString(includeNames = true)
class Developer {
    String firstName
    String lastName
    String middleInitial
    String email
    Date hireDate
    List languages
}

Developer dan = Developer
        .builder() // builder() calls setters to build the object, replacing the usage of a constructor, which can make the code less readable in some cases.
        .firstName("Dan")
        .lastName("Vega")
        .middleInitial("A")
        .email("danvega@gmail.com")
        .hireDate(new Date())
        .languages(["Java","Groovy"])
        .build()

println dan
assert dan.firstName == "Dan"
assert dan.lastName == "Vega"
assert dan.languages.size() == 2
println"--------------------------"
