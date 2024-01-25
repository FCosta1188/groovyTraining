//https://docs.groovy-lang.org/next/html/gapi/groovy/transform/TypeChecked.html

import groovy.transform.Canonical
import groovy.transform.TypeChecked

@Canonical
@TypeChecked // introduces the compilation checks found in static languages (Groovy is dynamic)
class Person {
    String firstName
    String lastName

    String getFullName(){
        "$firstName $lastName"
        // "$firstName $last" // without @TypeChecked, last is not flagged as an error in the IDE (no compile checks: dynamic)
                              // with @TypeChecked, last is flagged as an error in the IDE (compile checks: static)
    }
}

Person p = new Person("Dan", "Vega")
println p.toString()
println"--------------------------"