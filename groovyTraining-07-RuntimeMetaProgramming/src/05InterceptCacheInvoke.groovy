// Intercept-Cache-Invoke pattern
/* https://arturoherrero.com/intercept-cache-invoke-pattern/
Used for performance improvement when using dynamically created methods (i.e., created at runtime).
It allows to dynamically figure out the behaviour for methods upon invocation, so that we can create new methods with flexible and
dynamic names on-the-fly.
A synthesized method may not exist as a separate method until we call it.
When we call a nonexistent method, we can intercept the call, allow our application to implement it on the fly,
let us cache that implementation for future invocation, and then invoke it.
The first call takes performance hit but next calls are faster.
*/


class Developer {

    List languages = []

    def methodMissing(String name, args){
        println "${name}($args) method was called..."

        if(name.startsWith('write')) {
            String language = name.split("write")[1]

            // this block defines a new method during runtime, the first time that an unknown method is called (if it satisfies the required conditions)
            // after the method creation, it will exist during all the runtime, therefore methodMissing() won't be called on the subsequent calls of the new method
            if(languages.contains(language)) {
                def impl = { Object[] myArgs ->
                    println "I like to write code in $language"
                }
                getMetaClass()."$name" = impl
                return impl(args)
            }
        }
    }

}

Developer dan = new Developer()
dan.languages << "Groovy"
dan.languages << "Java"
println dan.metaClass.methods.size() // methods included in the class/object (also the inherited ones)
dan.writeGroovy()
dan.writeGroovy()
dan.writeGroovy()
println dan.metaClass.methods.size()
dan.writeJava()
dan.writeJava()
println dan.metaClass.methods.size()
println "---------------------------"