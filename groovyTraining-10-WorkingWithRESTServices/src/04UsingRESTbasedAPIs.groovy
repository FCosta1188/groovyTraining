import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

//import groovyx.net.http.ContentType
//import groovyx.net.http.RESTClient

// Simple GET: gets the content of the page found at the target URL as text
println 'http://groovy-lang.org'.toURL().text

// REST Client - Native Groovy GET and POST: https://stackoverflow.com/questions/25692515/groovy-built-in-rest-http-client
//def get = new URL("https://api.chucknorris.io/jokes/random").openConnection()
def get = new URL("https://api.chucknorris.io/jokes/search?query=rockets").openConnection()
get.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.0.11)")
get.setRequestProperty("Content-Type", "application/json; charset=utf-8")
def getText = get.getInputStream().getText()
println getText

//if (getRC.equals(200)) {
//    println(get.getInputStream().getText());
//}

//java.lang.NoClassDefFoundError: groovy/util/slurpersupport/GPathResult: https://stackoverflow.com/questions/71918967/in-groovy-how-do-i-fix-this-error-groovy-util-slurpersupport-gpathresult
/*
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1') // grabs a dependency

//String base = 'http://api.icndb.com'
String baseURL = 'https://api.chucknorris.io/'

def cnClient = new RESTClient(baseURL)
def params = [query: "Chuck"]

cnClient.contentType = ContentType.JSON
cnClient.get(path: '/jokes/search', query: params) { response, json ->
    println response.status
    println json
}
*/
println "------------------------------------------------------------------"
