import java.util.regex.*
// Java Sample Pattern
Pattern javaPattern = Pattern.compile("a\\\\b") // a + \ to escape \ + \ to escape \b (literal backspace)
println javaPattern // a\\b (a-backslash-backspace)
println javaPattern.class
println "---------------------------"

// Groovy Patterns
// operators: =~ (find), ==~ (match), ~ (pattern)
String slashy = /a\b/ // /slashy string/, used to escape the backslash
String url = $/http://threaldanvega.com/blog/$ // $/dollar slashy string/$, used to escape the forward slashes
println slashy.class
println url.class
def pattern = ~/a\b/ // ~ operator defines the following string as a RegEx Pattern
println pattern.class

// Find | Match
def text = "Being a Cleveland Sports Fan is no way to go through life"
pattern = ~/Cleveland Sports Fan/
def finder = text =~ pattern // find: java.util.regex.Matcher[pattern=Cleveland Sports Fan region=0,57 lastmatch=]
println finder
println finder.size() // occurrences (number of matches)

def matcher = text ==~ pattern
println matcher // exact match - boolean: false
text = "Cleveland Sports Fan"
pattern = ~/Cleveland Sports Fan/
matcher = text ==~ pattern // exact match - boolean: true
println matcher

//Regular expressions (patterns) as method arguments
text = "Being a Cleveland Sports Fan is no way to go through life" // true
pattern = ~/Cleveland/
text = text.replaceFirst(pattern,"Buffalo")
println text