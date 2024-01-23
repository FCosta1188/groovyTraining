/*
A JavaBean is just a standard for classes:
- All properties private (use encapsulation: getters/setters).
- A public no-argument constructor.
- Implements Serializable.
- (optional) An overridden toString() method.

Java provides a mechanism, called object serialization where an object can be represented as a
sequence of bytes that includes the object's data as well as information about the object's
type and the types of data stored in the object.
*/

import groovy.transform.ToString


public class EmployeeJavaBean implements Serializable { // regular Java bean

    // private properties
    private String first;
    private String last;
    private String email;

    // public no-arg constructor
    public EmployeeBean(){

    }

    // getters & setters
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "last='" + last + '\'' +
                ", first='" + first + '\'' +
                '}';
    }

}

@ToString
class EmployeeGroovyBean implements Serializable { // Equivalent Groovy bean of above Java bean

    // properties private by default
    String first,last,email
    String fullName

    // public no-arg constructor created automatically (hidden)

    // getters and setters created automatically for each property (hidden)

    // if the default getters and setters created by Groovy are not suitable, they can be replaced by custom ones
    void setFullName(String name){
        fullName = name
    }

    String getFullName(){
        "Full Name: ${fullName}"
    }

    // @Override public String toString(){} replaced by @groovy.transform.ToString

}

EmployeeGroovyBean emp1 = new EmployeeGroovyBean(first:"Dan",last: "Vega",email: "danvega@gmail.com")
println emp1
emp1.fullName = "$emp1.first $emp1.last"
println emp1.fullName

EmployeeGroovyBean emp2 = new EmployeeGroovyBean()
emp2.first = "Dan"
println emp2.first
println "-----------------------------------------"

// direct field access: useful when a custom getters has to return a value which is different from the original value of the property.
//                      @ can be used to access the value directly, when calling the getter (see below).
class DoubleBean {

    public Integer value

    void setValue(value){
        this.value = value
    }

    Integer getValue(){
        value * 2
    }

}

DoubleBean db = new DoubleBean()
db.value = 100
println db.value // gets the value of the property through the getter
println db.@value // direct access to the value of the property
println "-----------------------------------------"