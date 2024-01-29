//Java: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
//Groovy: https://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Date.html


//create and format a new date
Date today = new Date()
println today

Date bday = new Date("08/21/1978")
println bday
println bday.format('M-d-Y')

Date rightnow = new Date()
println rightnow.toTimestamp()
println "-------------"

// add & subtract
Date oneWeekFromToday = today + 7 // overloaded plus operator: today.plus(7)
Date oneWeekAgo = today - 7 // overloaded minus operator: today.minus(7)
println oneWeekFromToday
println oneWeekAgo
println "-------------"

// downto & upto
oneWeekFromToday.downto(today){
    println it
}

oneWeekAgo.upto(today){
    println it
}
println "-------------"

// range
Range twoWeeks = oneWeekAgo..oneWeekFromToday
twoWeeks.each {
    println it
}
println "-------------"

// next & previous
Date newyear = new Date('01/01/2017')
println newyear.next() // next day
println newyear.previous() // previous day
println "-------------"
