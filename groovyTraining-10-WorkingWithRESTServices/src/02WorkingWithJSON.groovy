//https://docs.groovy-lang.org/next/html/gapi/groovy/json/JsonSlurper.html
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

JsonBuilder builder = new JsonBuilder()

builder.books {
    currentBook {
        title 'The 4 Hour Work Week'
        isbn '978-0-307-46535-1'
        author( first:'Timothy', last:'Ferriss', twitter:'@tferriss')
        related 'The 4 Hour Body', 'The 4 hour chef'
    }
    nextBook {
        title '#AskGaryVee'
        isbn '978-0-06-227312-3'
        author(first: 'Gary', last: 'Vaynerchuck', twitter: '@garyvee')
        related 'Jab, Jab, Jab, Right Hook', 'Crush It!'
    }
}

new File('data/books.json').write(builder.toPrettyString())

JsonSlurper slurper = new JsonSlurper()
def json = slurper.parse(new File('data/02WorkingWithJSON.json'))

println json.books.currentBook
println json.books.currentBook.title
println json.books.currentBook.author.twitter
println json.books.currentBook.related
println '----------------------------'

/*
def books = '''
{
    "books": {
        "currentBook": {
            "title": "The 4 Hour Work Week",
            "isbn": "978-0-307-46535-1",
            "author": {
                "first": "Timothy",
                "last": "Ferriss",
                "twitter": "@tferriss"
            },
            "related": [
                "The 4 Hour Body",
                "The 4 hour chef"
            ]
        },
        "nextBook": {
            "title": "#AskGaryVee",
            "isbn": "978-0-06-227312-3",
            "author": {
                "first": "Gary",
                "last": "Vaynerchuck",
                "twitter": "@garyvee"
            },
            "related": [
                "Jab, Jab, Jab, Right Hook",
                "Crush It!"
            ]
        }
    }
}
'''

JsonSlurper slurper = new JsonSlurper()
def json = slurper.parseText(books)

println json.books.nextBook.title
*/

