//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/Canonical.html
import groovy.transform.Canonical

@Canonical // combines @ToString, @EqualsAndHashCode and @TupleConstructor (which represent a canonical java class/bean/POJO)
class Person {
    String first
    String last
    String email
}

// @TupleConstructor
Person p1 = new Person("Dan","Vega","danvega@gmail.com")
Person p2 = new Person("Dan","Vega","danvega@gmail.com")

// @EqualsAndHashCode
assert p1 == p2

// @ToString
println p1.toString()
println"--------------------------"