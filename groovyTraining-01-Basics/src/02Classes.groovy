import groovy.transform.ToString

/*
Unlike Java, Groovy does not force files and classes to have the same name. Therefore, a
.groovy file can contain multiple classes, but if it contains none, it is considered a script.
The compiler takes care of creating distinct .class files based on the classes defined in the .groovy file.

Classes and scripts can be mixed in the same file and a psvm method is not needed to run the script (see below).
*/

// Classes and methods are PUBLIC by default
// Properties are PRIVATE by default and their getters and setters are created automatically by Groovy

@ToString //short for @groovy.transform.ToString; creates the typical overridden toString() of a POJO (o Java Bean)
class Developer {

    String first = "Dev"
    String last = "Eloper"
    def languages = []

    void work() {
        println "$first $last is now working"
    }
}

Developer dev = new Developer()
dev.work()
println "---------------------"

dev.first = "First" //the property is private, so this is not a direct access, but it's a call to the hidden setter setFirst()
dev.work()
dev.setFirst("NewFirst")
dev.setLast("Last")
dev.work()
println "---------------------"

println dev.languages.getClass() //since this property has been created via def, the type has been assigned automatically (ArrayList)
dev.languages << "Java"
dev.languages << "Groovy"
println dev.languages //same as dev.getLanguages()
println dev.getLanguages()
println "---------------------"

println dev.toString()
println "---------------------"