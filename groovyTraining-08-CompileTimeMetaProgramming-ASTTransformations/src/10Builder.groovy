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
    List langugages

}

Developer dan = Developer
        .builder()
        .firstName("Dan")
        .lastName("Vega")
        .middleInitial("A")
        .email("danvega@gmail.com")
        .hireDate(new Date())
        .langugages(["Java","Groovy"])
        .build()

println dan
assert dan.firstName == "Dan"
assert dan.lastName == "Vega"
assert dan.langugages.size() == 2
