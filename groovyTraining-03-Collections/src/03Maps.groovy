/* http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html
An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
The Map interface provides three collection views, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings.
The order of a map is defined as the order in which the iterators on the map's collection views return their elements.
Some map implementations, like the TreeMap class, make specific guarantees as to their order; others, like the HashMap class, do not.
*/

def map = [:] // def uses LinkedHashMap by default when declaring with [:]
println map
println map.getClass().getName() // map.class.name won't work here, because maps don't have a class property

def person = [first:"Dan",last:"Vega",email:"danvega@gmail.com"]
println person
println person.first
person.twitter = "@therealdanvega" // adds a key and the related value
println person
println person.size()
println person.sort() // sorts by ascending key name

// Key without (): literal (username). Key within (): variable value (Email Address).
def emailKey = "Email Address" // this does not work as literal key name but it works with a variable (see line below)
def twitterMap = [username:"@therealdanvega",(emailKey):"danvega@gmail.com"]
println twitterMap
println twitterMap.size()
println twitterMap.sort()
println "---------------------"


// Looping maps
for(entry in person) {
    println entry // print key-value pair with default format
}

for(key in person.keySet()) {
    println "$key:${person[key]}" // print key-value pair with custom format (GString)
}

// Looping with closures
person.each {entry -> println "$entry.key | $entry.value"}
person.each {key, value -> println "$key | $value"}
person.eachWithIndex {entry, index -> println "$index | $entry.key | $entry.value"} // provides the index of each entry
println "---------------------"


// Exercise
def days = [1:"Mon",2:"Tue",3:"Wed",4:"Thu",5:"Fri",6:"Sat",7:"Sun"]
println days
println days.getClass().getName()
println days.size()

// print the entire maps without using closure (needed in each and eachWithIndex, see above)
println days.entrySet() // returns a Set containing the key-values pairs (entries)
println days.values() // returns a Collection containing the values only
println "---------------------"