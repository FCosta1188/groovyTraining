import groovy.transform.ToString

@ToString
class Person {

    String first,last

    // constructor (it's a special method)
    Person(String fullName) {
        List nameParts = fullName.split(' ')
        first = nameParts[0]
        last = nameParts[1]
    }

    // methods
    public void foo(String a, String b) {
        // do stuff
    }

    String getFullName(){
        "$first $last" // return is implicit
    }

    def bar(){

    }

    static String doGoodWork(){
        println "doing good work..."
    }

    List someMethod(List numbers = [1,2,3], Boolean canAccessAll = false){

    }

    def concat(String... args) {
        println args.length
    }

}

Person p = new Person("Dan Vega")
println p.getFullName()

p.concat('a','b','c','d')
