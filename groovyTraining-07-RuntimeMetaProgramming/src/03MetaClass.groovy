/* https://docs.groovy-lang.org/latest/html/api/groovy/lang/MetaClass.html
A MetaClass (interface) within Groovy defines the behaviour of any given Groovy or Java class.
Each object has a property metaClass of type MetaClass, which is dynamically expandable.
In this way, even custom regular classes can be expanded by using the features of their metaClass property.
*/

//Expando (groovy.util): represents a dynamically expandable bean, like MetaClass.
Expando e1 = new Expando()
e1.name = 'Dan' // new property, not defined withing the class definition, but defined dynamically at runtime
e1.expandCode = { -> println "$name loves to expand code..."} // new method (defined through a closure), not defined withing the class definition, but defined dynamically at runtime
e1.expandCode()

Expando e2 = new Expando()
// e2.expandCode() // does not work, because dynamic properties and methods are instance-based
println "-----------------------------------"


// To expand custom classes like seen in Expando, we can use their metaClass property.
class Developer {
    String name

    Developer(String name) {
        this.name = name
    }
}

// per instance: when the new property/method is defined on an object
Developer dan = new Developer()
dan.metaClass.name = 'Dan'
dan.metaClass.writeCode = { -> println "$name loves to write code..."}
dan.writeCode()

// every instance: when the new property/method is defined on a class (both custom and built-in Groovy and Java classes)
Developer.metaClass.writeDocs = { -> println "$name loves to write documentation..." }
Developer d1 = new Developer("Pinco")
Developer d2 = new Developer("Tizio")
d1.writeDocs()
d2.writeDocs()

String.metaClass.shout = { -> toUpperCase() }
println "hello dan".shout()
String str = "my string"
println str.shout()
println "-----------------------------------"
