/* https://docs.groovy-lang.org/docs/next/html/documentation/template-engines.html

Groovy supports multiple ways to generate text dynamically including GStrings, printf and MarkupBuilder just to name a few.
In addition to these, there is a dedicated template framework which is well-suited to applications where the text to be generated
follows the form of a static template.

Template Placeholders
    $variable         Inserts the value of the variable into the text
    ${groovycode}     Evaluates single line groovy code and inserts the result into the text
    <%=groovycode%>   Evaluate the groovy code and insert the result into the text
    <%groovycode%>    Evaluate the groovy code

// Three components to build a dynamic template:
// 1. Engine (SimpleTemplateEngine)
// 2. Template (text)
// 3. Data Bindings (the data to insert into the dynamic portions of our text)
*/

import groovy.text.SimpleTemplateEngine
import groovy.text.Template

// 1. Engine
SimpleTemplateEngine engine = new SimpleTemplateEngine(true) // verbose: true if you want the engine to display the template source file for debugging purposes
//2. Template
Template template = engine.createTemplate(new File('C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/files/dynamic-email-template.txt'))
// 3. Data Bindings (show error if properties are missing)
Map bindings = [
        firstName: "Dan",
        lastName: "Vega",
        commits: 27,
        repositories: [
                [name:'Apache Groovy Course',url:'https://github.com/cfaddict/apache-groovy-course'],
                [name:'Spring Boot REST',url:'https://github.com/cfaddict/spring-boot-rest'],
                [name:'Learn Spring Boot',url:'https://github.com/cfaddict/learnspringboot']
        ]
]

println template.make(bindings)