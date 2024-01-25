//https://docs.groovy-lang.org/latest/html/api/groovy/xml/MarkupBuilder.html
import groovy.xml.MarkupBuilder

MarkupBuilder builder = new MarkupBuilder()
builder.omitEmptyAttributes = true
builder.omitNullAttributes = true

// by default, it will be printed on the console when running the script (no need for println). Other options available (file, stream, etc.): see 02MarkupBuilder-HTML.groovy
builder.sports { // sport and name are tags (outer and inner), id and foo are attributes
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
    sport(id:null, foo:'') { // omitted as per options above
        name '' // not omitted
    }
}