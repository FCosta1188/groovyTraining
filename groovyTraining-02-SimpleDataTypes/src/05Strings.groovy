// Java:
char c = 'c'
println c.class

String str = "this is a string"
println str.class
println "---------------------------"

// Groovy: def considers both characters and strings as String
def c2 = 'c'
println c2.class
def str2 = 'this is a string'
println str2.class

// string concatenation and interpolation
String name = "Dan"
String msg = "Hello " + name + "..." // Java-like string concatenation (java.lang.String)
println msg
String msg2 = "Hello ${name}" // G-String (groovy.lang.String) evaluation ($): only works with double quotes
println msg2
String msg3 = 'Hello ${name}' // G-String literal: single quotes
println msg3
String msg4 = "We can evaulate expressions here: ${1 + 1}"
println msg4

// multiline strings
def aLargeMsg = """
A 
Msg
goes 
here and 
keeps going ${1+1}
"""
println aLargeMsg

// dollar slashy ($/.../$)
// escapes the entire string, without having to escape single characters
def folder = $/C:\groovy\dan\foo\bar/$ // escapes all "\" in the string
println folder
println "---------------------------"
