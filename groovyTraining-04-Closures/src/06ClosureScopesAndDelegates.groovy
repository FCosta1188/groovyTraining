/*
Scopes of a closure:
- owner: enclosing object where the closure is defined, which can be either a class or a Closure object (nested closures)
- delegate: third party object where methods call or where properties are resolved whenever the receiver of the message is not defined.
- this: enclosing class where the closure is defined
*/

class ScopeDemo {

    def outerClosure = {
        println this.class.name
        println owner.class.name
        println delegate.class.name

        def nestedClosure = {
            println this.class.name
            println owner.class.name
            println delegate.class.name
        }

        nestedClosure()
    }

}

def scopeDemo = new ScopeDemo()
scopeDemo.outerClosure()
println "---------------------------"


// Delegates
def writer = { //closure
    append 'Dan'
    append ' lives in Cleveland'
}

def append(String s) { //custom append()
    println "append() called with argument of $s"
}

// Delegating the responsibilities of the writer closure to the StringBuffer class:
// this allows writer to refer to the append() included in StringBuffer, without the need of creating a custom append().
// If both a custom and a delegate method exist, the priority is given to the custom one, unless specified otherwise
// via the resolveStrategy property.
StringBuffer sb = new StringBuffer()
writer.resolveStrategy = Closure.DELEGATE_FIRST
writer.delegate = sb
writer()
println "---------------------------"