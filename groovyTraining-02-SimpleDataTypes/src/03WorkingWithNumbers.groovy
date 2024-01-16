// Groovy Number Defaults
def number = 10
println number.class //java.lang.Integer
def decimal = 5.50
println decimal.class //java.math.BigDecimal
println "-----------------------------------"


// Converting Data Types
// Explicit: casting
def myFloat = (float) 1.0 //the default of this def would be BigDecimal
println myFloat.class
// Implicit: coercion, performed automatically when declaring a def
println "-----------------------------------"


// Rules for types when using operands (+,-,*,/)

// If either operand is a float or a double the result is a double,
// whereas in Java if only floats are involved the result is a float
Float f = 5.25
Double d = 10.50
def result = d / f
println result
println result.class
Float a = 10.75
Float b = 53.75
def result2 = b / a
println result2
println result2.class

// If either operand is a big decimal the result is a big decimal
def x = 34.5 // BigDecimal
def y = 15
def bigResult = x / y
println bigResult
println bigResult.class
// If either operand is a BigInteger the result is a BigInteger
// If either operand is a Long the result is a Long
// If either operand is a Integer the result is an Integer

// Double Subtraction (Division?)
println 5.0d - 4.1d //Double, incorrect result (0.9000000000000004)
println 5-4.1 //BigDecimal, correct result (0.9)

// Integer Division
def intDiv = 1 / 2
println intDiv // 0.5
println intDiv.getClass().getName() //BigDecimal
println 1.intdiv(2) // 0, like it would be in Java
println "-----------------------------------"


// GDK (Groovy Development Kit) Methods
// Converting and Assessing Data Types
assert 2 == 2.5.toInteger() // conversion
assert 2 == 2.5 as Integer  // enforced coercion
assert 2 == (int) 2.5 // cast
assert '5.50'.isNumber() // does this String represent a number?
assert 5 == '5'.toInteger()

// times: loop over an operation for X times
20.times {
    print '*'
}
println()

// upto: iterates numbers from X to Y (ascending) and the related operations inside the block
1.upto(10) { num ->
    println num
}

// downto: iterates numbers from Y to X (descending)
10.downto(1) { num ->
    println num
}

// step: iterates numbers from X to Y (ascending) and the related operations inside the block,
// by increasing steps defined by the user
0.step(1,0.1) { num ->
    println num
}
println "-----------------------------------"