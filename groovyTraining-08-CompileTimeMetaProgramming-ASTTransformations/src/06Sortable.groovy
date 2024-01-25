//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/Sortable.html
import groovy.transform.Canonical
import groovy.transform.Sortable

@Canonical
@Sortable(includes = ['last', 'first']) // properties used for sorting (priority order)
class Person {
    String first
    String last
}

Person p1 = new Person("Katie","Vega")
Person p2 = new Person("Dan","Vega")
Person p3 = new Person("Andy","Vega")
Person p4 = new Person("Joe","Vega")
Person p5 = new Person("Jason","NotaVega")

def vegas = [p1,p2,p3,p4,p5]

println vegas.toSorted()
println"--------------------------"