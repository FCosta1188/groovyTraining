byte b //java.lang.Byte
println "Groovy-wrapped byte class: " + b.getClass().getName()
println "hard-coded 3 class: " + 3.getClass()

// Optional Typing (def)
// def allows assignments of different types of values and the related wrapping class changes accordingly (dynamically)
def x = 10
println x.getClass().getName()
x = "Fra"
println x.getClass().getName()
