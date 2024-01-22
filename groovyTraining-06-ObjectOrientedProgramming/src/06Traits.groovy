/* https://docs.groovy-lang.org/docs/groovy-2.3.0/html/documentation/core-traits.html

Traits are a structural construct of Groovy which allow:
- composition of behaviors
- runtime implementation of interfaces
- behavior overriding
- compatibility with static type checking/compilation

They can be seen as interfaces carrying both default implementations and state.
*/

class Bird implements FlyingAbility, SpeakingAbility {

    @Override
    String foo() {
        return null
    }

}

trait SpeakingAbility {

    public String a
    private String b

    String speak() {
        "I'm Speaking!"
    }

}

trait FlyingAbility {

    String fly() {
        "I'm Flying!"
    }

    abstract String foo()

    private String bar() {
        "bar"
    }

}


Bird b = new Bird()
assert b.fly() == "I'm Flying!"
assert b.speak() == "I'm Speaking!"
println "-------------------------"