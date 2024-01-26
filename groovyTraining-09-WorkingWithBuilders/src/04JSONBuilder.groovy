//https://docs.groovy-lang.org/next/html/gapi/groovy/json/JsonBuilder.html
import groovy.json.JsonBuilder

JsonBuilder builder = new JsonBuilder()

builder.books {
    currentBook {
        title 'The 4 Hour Work Week'
        isbn '978-0-307-46535-1'
        authors([first:'Timothy', last:'Ferriss', twitter:'@tferriss'])
        related 'The 4 Hour Body', 'The 4 hour chef'
    }

    nextBook {
        title '#AskGaryVee'
        isbn '978-0-06-227312-3'
        authors([first: 'Gary', last: 'Vaynerchuck', twitter: '@garyvee'],[first: 'Yrag', last: 'Chuckvayner', twitter: '@YragChu'])
        related 'Jab, Jab, Jab, Right Hook', 'Crush It!'
    }
}

println builder.toString()
println builder.toPrettyString()

new File('json/04JSONBuilder.json').write(builder.toPrettyString())
println '----------------------------'