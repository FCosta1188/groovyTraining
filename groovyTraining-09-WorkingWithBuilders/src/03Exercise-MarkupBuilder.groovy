import groovy.transform.Canonical
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.xml.MarkupBuilder
import groovy.xml.XmlParser
import groovy.xml.XmlSlurper

@ToString
@Canonical
@TupleConstructor
class Book {
    String title
    String author
    Double price
}

FileWriter xmlWriter = new FileWriter('xml/03Exercise-MarkupBuilder.xml')
MarkupBuilder xmlBuilder = new MarkupBuilder(xmlWriter)

FileWriter htmlWriter = new FileWriter('html/03Exercise-MarkupBuilder.html')
MarkupBuilder htmlBuilder = new MarkupBuilder(htmlWriter)

xmlBuilder.books {
    book(isbn:'978-1935182443') {
        title('Groovy in Action 2nd Edition')
        author('Dierk Koenig')
        price(50.58)
    }
    book(isbn:'978-1935182948') {
        title('Making Java Groovy')
        author('Ken Kousen')
        price(33.96)
    }
    book(isbn:'978-1937785307') {
        title('Programming Groovy 2: Dynamic Productivity for the Java Developer')
        author('Venkat Subramaniam')
        price(28.92)
    }
}

FileReader xmlReader = new FileReader('xml/03Exercise-MarkupBuilder.xml')
def xmlBooksGPathResult = new XmlSlurper().parse(xmlReader)

// Groovy approach
def books = xmlBooksGPathResult.book.each {
    new Book(it.title.text(), it.author.text(), Double.parseDouble(it.price.text()))
}

// Java approach
/*
List<Book> books = new ArrayList<Book>()
for (int i = 0; i < xmlBooksGPathResult.book.size(); i++) {
    books[i] = new Book(xmlBooksGPathResult.book[i].title.text(),
                        xmlBooksGPathResult.book[i].author.text(),
                        Double.parseDouble(xmlBooksGPathResult.book[i].price.text()))
}
*/

htmlBuilder.html {
    head {
        title 'Groovy Books'
        description 'List of books for learning Groovy'
        keywords 'Dan Vega, Fran Costa, Groovy, Java, MarkupBuilder'
    }
    body {
        section {
            h2 'Books'
            table {
                tr {
                    th 'title'
                    th 'author'
                    th 'price'
                }
                books.each { book ->
                    tr {
                        td book.title
                        td book.author
                        td book.price
                    }
                }
            }
        }
    }
}
