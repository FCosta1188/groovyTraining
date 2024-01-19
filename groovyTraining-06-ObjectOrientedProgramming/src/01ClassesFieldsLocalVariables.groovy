// class an methods are public by default
// fields (attributes) are private by default

class Person {

    String firstName, lastName
    def dob
    protected String f1,f2,f3
    private Date createdOn = new Date()

    static welcomeMsg = 'HELLO'
    public static final String WELCOME_MSG = 'HELLO'

    def foo() { //method
        // local variables: only visible within the method they are declared in
        String msg = "Hello"
        String firstName = "Dan"
        println "$msg, $firstName"
    }
}

def person = new Person()
println person.foo()