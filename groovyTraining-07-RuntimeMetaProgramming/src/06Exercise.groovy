import groovy.transform.ToString

// Groovy Object
class MOPDemo  {
    String myProp

    def invokeMethod(String name,Object args){
        return "invokeMethod: $name $args"
    }

    def getProperty(String name){
        if(metaClass.hasProperty(this, name)) { // property exists
            return metaClass.getProperty(this, name)
        } else { // property does not exists
            return "getProperty: $name"
        }
    }

    void setProperty(String name, Object value) {
        metaClass.setProperty(this,name,value)
    }
}
MOPDemo mop = new MOPDemo()
println mop.newMethod("test new method")
println mop.myProp
println mop.myProp2
mop.myProp = 'test'
println mop.myProp
println "------------------------"


// Expando
Expando e = new Expando()

e.first = "Dan"
e.last  = "Vega"
e.email = "danvega@gmail.com"

e.getFullName = {
    "$first $last"
}

println e.toString()
println e.getFullName()

@ToString(includeNames = true)
class Person {
    String first, last
}

Person p = new Person(first: "Dan", last: "Vega")
println p
p.metaClass.email = "danvega@gmail.com"
println p // email not printed, as this prop is generated on runtime and space was not allocated for it in the class definition.
println p.email
println "------------------------"


// Times Two
class IntegerCategory {
    static Integer timesTwoCat(Integer i) {
        i * 2
    }
}

Integer.metaClass.timesTwoMeta = { delegate * 2 }
println 22.timesTwoMeta()

use(IntegerCategory) {
    println 2.timesTwoCat()
}
println "------------------------"
