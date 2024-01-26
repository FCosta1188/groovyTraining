//https://docs.groovy-lang.org/next/html/gapi/groovy/xml/XmlSlurper.html
import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper

FileWriter writer = new FileWriter('data/01WorkingWithXML.xml')
MarkupBuilder builder = new MarkupBuilder(writer)
builder.doubleQuotes = true

builder.sports {
    sport(id:1) {
        name 'Baseball'
    }
    sport(id:2) {
        name 'Basketball'
    }
    sport(id:3) {
        name 'Football'
    }
    sport(id:4) {
        name 'Hockey'
    }

}

def sports = new XmlSlurper().parse('data/sports.xml')
println sports
println sports.sport[2].name
println '----------------------------'

/*
def xml = '''
    <sports>
        <sport>
            <name>Football</name>
        </sport>
    </sports>
'''

def sports = new XmlSlurper().parseText(xml)

println sports.getClass().getName()
println sports.sport.name
*/
