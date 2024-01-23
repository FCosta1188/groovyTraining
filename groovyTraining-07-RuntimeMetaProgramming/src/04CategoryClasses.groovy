import groovy.time.TimeCategory


// custom category class: it contains static methods which expand the original String class
class StringCategory {
    static String shout(String str){
        str.toUpperCase()
    }
}

use(StringCategory) { // the use keyword is needed to define the code block where the category class will be available
    println "hello".shout()
}
println"------------------------------"

// built-in Groovy class
use(TimeCategory) {

    println 1.minute.from.now
    println 10.hours.ago

    def someDate = new Date()
    println someDate - 3.months

}
println"------------------------------"