/* http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html
An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
The Map interface provides three collection views, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings.
The order of a map is defined as the order in which the iterators on the map's collection views return their elements.
Some map implementations, like the TreeMap class, make specific guarantees as to their order; others, like the HashMap class, do not.
*/

def map = [:] // def uses LinkedHashMap by default
println map
println map.getClass().getName()

def person = [first:"Dan",last:"Vega",email:"danvega@gmail.com"]
println person
println person.first

person.twitter = "@therealdanvega"
println person

def emailKey = "EmailAddress"
def twitter = [username:"@therealdanvega",(emailKey):"danvega@gmail.com"]

println person.size()
println person.sort()

// looping through person
for( entry in person ) {
    println entry
}

for( key in person.keySet() ) {
    println "$key:${person[key]}"
}

// each | eachWithIndex