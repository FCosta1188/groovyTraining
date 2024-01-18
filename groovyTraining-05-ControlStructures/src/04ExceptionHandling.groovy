// In Groovy every exception is optional, meaning that unlike in Java, the Exception class does not have to be
// part of the method signature ("throw Exception" statement) if the method can throw exceptions.

/* Java method declaration
public void foo() throws Exception {
    throw new Exception()
}
*/

// Groovy method declaration
def foo() {
    // do stuff
    throw new Exception("Foo Exception")
}
List log = []

try {
    foo()
} catch(Exception e) {
    log << e.message
} finally {
    log << 'finally'
}
println log
println "---------------------------"


// Multi-catch syntax introduced by Java 7
try {
    // do stuff
    throw new FileNotFoundException("my FileNotFound Exception")
} catch(FileNotFoundException | NullPointerException e) {
    println e.class.name
    println e.message
}
println "---------------------------"
