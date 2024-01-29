import groovy.transform.ToString

@ToString
class Person {
    String first
    String last
    String email
    Date dob
}

Person p = new Person(first: "Dan", last: "Vega", email: "danvega@gmail.com", dob: new Date())
println p
println "-----------------------"