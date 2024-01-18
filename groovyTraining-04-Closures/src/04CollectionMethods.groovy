// each & eachWithIndex
List favNums = [2,21,44,35,8,4]

for(num in favNums) { // regular for-each
    println num
}
favNums.each { println it } // .each with closure

for( int i=0; i<favNums.size(); i++){ // regular for-each with indexes
    println "$i:${favNums[i]}"
}
favNums.eachWithIndex { num, idx -> // .eachWithIndex with closure
    println "$idx:$num"
}
println "---------------------------"


// findAll
List days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
List weekend = days.findAll { it.startsWith("S") }

println days
println weekend
println "---------------------------"


// collect
List nums = [1,2,2,7,2,8,2,4,6]
List numsTimesTen = nums.collect { num -> num * 10 }
println nums
println numsTimesTen

// Alternative version with .each, less efficient and more verbose.
/*nums.each { num ->
    numsTimesTen << num * 10
}*/
println "---------------------------"


// map methods
def person = [first:"Dan",last:"Vega",email:"danvega@gmail.com"]

person.each { entry ->
    println entry
}
person.each { k, v ->
    println "$k:$v"
}

class Person {
    String name
    int age
}

def people = [
        new Person(name:"Joe", age:45),
        new Person(name:"Mary", age:35),
        new Person(name:"Andrew", age:25)
]

assert people
        .findAll { it.age < 40 }
        .collect {it.name.toUpperCase() }
        .sort()
        .join(', ') == "ANDREW, MARY"
println "---------------------------"