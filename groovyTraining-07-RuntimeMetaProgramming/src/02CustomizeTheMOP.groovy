// Every Groovy class implements the groovy.lang.GroovyObject interface by default.

// invokeMethod():
// Method provided by groovy.lang.GroovyObject, which can be called on any method, whether it exists or not.
// If a method exists, the invokeMethod has to be called on it explicitly, in order to use it.
// If a method does not exist, the invokeMethod of the class (default or overridden) is called automatically.
class InvokeDemo {

    //default invokeMethod contained in groovy.lang.GroovyObject
    /*
    default Object invokeMethod(String name, Object args) {
        return this.getMetaClass().invokeMethod(this, name, args);
    }
    */

    //custom overridden invokeMethod
    def invokeMethod(String name,Object args){
        return "called invokeMethod $name $args"
    }

    def test() {
        return "test() method"
    }

}

def invokeDemo = new InvokeDemo()

assert invokeDemo.test() == 'test() method'
assert invokeDemo.invokeMethod("test", "myArgs") == 'called invokeMethod test myArgs'
assert invokeDemo.nonExistingMethod(52) == 'called invokeMethod nonExistingMethod [52]'
println "-----------------------------------------------------------"


// getProperty():
// method provided by groovy.lang.GroovyObject, which is used to intercept read accesses to a property,
// allowing to handle calls to non-existing properties.
class GetPropertyDemo {

    def prop1 = "prop1"
    def prop2 = "prop2"
    def prop3 = "prop3"

    //default getProperty contained in groovy.lang.GroovyObject
    /*
    default Object getProperty(String propertyName) {
        return this.getMetaClass().getProperty(this, propertyName);
    }
    */

    //custom overridden getProperty (overrides default getters)
    def getProperty(String name){
        println "getProperty() called with argument $name"

        if(metaClass.hasProperty(this,name)) { // property exists
            return metaClass.getProperty(this,name)
        } else { // property does not exists
            println "lets do something fun with this property"
            return "party time..."
        }

    }

}

def pd = new GetPropertyDemo()
println pd.prop1 //getProperty("prop1")
println pd.prop2
println pd.prop3
println pd.prop4
println "-----------------------------------------------------------"


// setProperty():
// method provided by groovy.lang.GroovyObject, which is used to intercept write accesses to a property,
// allowing to handle calls to non-existing properties.
class SetPropertyDemo {

    String property

    //default setProperty contained in groovy.lang.GroovyObject
    /*
    default void setProperty(String propertyName, Object newValue) {
        this.getMetaClass().setProperty(this, propertyName, newValue);
    }
    */

    //custom overridden setProperty (overrides default setters)
    void setProperty(String name, Object value) {
        this.@"$name" = 'overridden'
    }

}

def pogo = new SetPropertyDemo()
pogo.property = 'a' // the setter has been overridden by setProperty, which sets the property to a hardcoded values (see above).
assert pogo.property == 'overridden'
println "-----------------------------------------------------------"


// propertyMissing():
// method which is called in case of failing property resolution attempts (if it has been defined in the class, as it's not inherited).
class PropertyMissingDemo {

    def propertyMissing(String name) {
        "caught missing property: $name"
    }

}

println new PropertyMissingDemo().bar
println "-----------------------------------------------------------"


// methodMissing():
// method which is called in case of a failed method dispatch (if it has been defined in the class, as it's not inherited),
// when no method can be found for the given name and/or the given arguments.
// The recognition is based on the method signature (arguments pattern), therefore the method is considered non-existing even when the name is correct
// but the signature is not.
class MethodMissingDemo {

    def methodMissing(String name, def args){

        if( name != 'missingMethodNoEx' ) {
            throw new MissingMethodException(name, MethodMissingDemo.class, args)
        }

        println "Method Missing called on: $name"
        println "with arguments $args"
    }

    def signatureMissing() {
        println "called signatureMissing()"
    }

}

MethodMissingDemo mm = new MethodMissingDemo()
mm.missingMethodNoEx(1,2,3)
mm.missingMethodWithEx(4,5,6)
mm.signatureMissing(7,8,9)
println "-----------------------------------------------------------"




