import groovy.transform.ToString

@ToString
class Phone {

    String name
    String os
    String appStore

    def powerOn(){

    }

    def powerOff(){

    }

    def ring(){

    }

}


class IPhone extends Phone {

    String iosVersion

    def homeButtonPressed() {

    }

    def airPlay() {

    }

    // @Override: not needed in Groovy, it is done automatically
    def powerOn() { // implicit override of the inherited method

    }

    @Override
    String toString() {
        "I" + super.toString() + "\b, $this.iosVersion)"
    }
}


Phone myPhone = new Phone(name:"pocof3",appStore:"Google Play",os:"android")
println myPhone
IPhone myIPhone = new IPhone(name:"iPhone",appStore:"Apple Store",os:"ios",iosVersion:"1.0")
println myIPhone
println "------------------------------------------------------------------"