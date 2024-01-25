//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/AutoClone.html
/*
Class annotation used to assist in the creation of Cloneable classes.
The @AutoClone annotation instructs the compiler to execute an AST transformation which adds a public clone() method and
adds Cloneable to the list of interfaces which the class implements.
Because the JVM doesn't have a one-size fits all cloning strategy, several customizations exist for the cloning implementation.
*/
import groovy.transform.AutoClone
import groovy.transform.Canonical


@Canonical
@AutoClone
class Sheep { // equivalent to "class Person implements Cloneable {}"
    String name
}

def dolly = new Sheep("Dolly")
println dolly
def dollyClone = dolly.clone()
println dollyClone

assert dolly instanceof Cloneable
assert dollyClone instanceof Cloneable
assert !(dolly.name instanceof Cloneable)
assert !(dolly.is(dollyClone))
assert dolly.name.is(dollyClone.name)
println"--------------------------"