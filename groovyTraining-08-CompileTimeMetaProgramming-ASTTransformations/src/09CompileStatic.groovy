//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/CompileStatic.html
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
class SomeClass {

    String foo(){
        "foo"
    }

    String bar(){
        "bar"
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    void noReturn(){

    }

}