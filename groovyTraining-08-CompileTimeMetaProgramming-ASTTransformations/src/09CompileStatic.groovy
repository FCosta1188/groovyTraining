//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/CompileStatic.html
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

// @CompileStatic can be applied at class level (all methods) or to individual methods.
@CompileStatic // bypasses Groovy's MOP: does not allow dynamic programming, making Groovy more similar to Java.
               // In comparison, @TypeChecked applies static checks but allows dynamic programming (MOP)
class SomeClass {

    String foo() {
        "foo"
    }

    String bar() {
        "bar"
    }

    @CompileStatic(TypeCheckingMode.SKIP) // turns off @CompileStatic for this method
    void noReturn() {

    }
}

println"--------------------------"