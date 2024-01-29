/* https://docs.groovy-lang.org/latest/html/api/groovy/sql/Sql.html

A facade over Java's normal JDBC APIs providing greatly simplified resource management and result set handling.
Under the covers the facade hides away details associated with getting connections, constructing and configuring statements,
interacting with the connection, closing resources and logging errors.
Special features of the facade include using closures to iterate through result sets,
a special GString syntax for representing prepared statements and treating result sets like collections of maps
with the normal Groovy collection methods available.
*/
import groovy.sql.Sql
import groovy.sql.GroovyRowResult


String username = "root"
String password = "root"
String url = "jdbc:mysql://localhost:3306/world"
String driver = "com.mysql.cj.jdbc.Driver"

// connect to db with newInstance
// manual resource handling (eg: close connection)
def sql = Sql.newInstance(url, username, password, driver)
println "Connected to $sql.connection"

// create table
sql.execute('DROP TABLE IF EXISTS dishes')
sql.execute '''
CREATE TABLE dishes (
      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(50) NOT NULL,
      ingredients VARCHAR(100) NULL,
      recipe VARCHAR(1000) NULL
);
'''

// INSERT
sql.execute '''
    INSERT INTO dishes (name, ingredients, recipe) VALUES ('basic pasta', 'pasta, water, salt', 'boil water, put salt, throw pasta in')
'''

def dish = [id:2, name:'tomato sauce', ingredients:'olive oil, garlic, tomato sauce, salt, sugar', recipe:'cook in pan']
sql.execute """
  INSERT INTO dishes (id, name, ingredients, recipe)
  VALUES
  (${dish.id}, ${dish.name}, ${dish.ingredients}, ${dish.recipe})
"""

// print records with .rows and GroovyRowResult
List<GroovyRowResult> rows = sql.rows("select * from dishes")
println rows

// print records with .eachRow and GroovyRowResult (closure)
sql.eachRow('select * from dishes') { row ->
    println "Recipe ${row.id}: ${row.name}"
}

// closing connection manually
sql.close()
println "Disconnected from $sql.connection"
println "---------------------------------"


// connect to db and execute operations with withInstance (closure)
// resource handling performed by Groovy (eg: no need to close connection manually)
def myDish = [name:'basil pesto', ingredients:'olive oil, garlic, basil, pine nuts, parmigiano', recipe:'combine with mixer']

Sql.withInstance(url, username, password, driver) {mySql ->
    mySql.execute """
      INSERT INTO dishes (name, ingredients, recipe)
      VALUES
      (${myDish.name}, ${myDish.ingredients}, ${myDish.recipe})
    """

    // the connection is closed automatically at the end of the closure, so query should be performed within the closure
    mySql.eachRow('select * from dishes') { row ->
        println "Recipe ${row.id}: ${row.name}"
    }
}
println "---------------------------------"


// Exercise: write db records to CSV
def dbDump = new File('C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/files/db/dbDump.csv')
dbDump.delete() // clear file content

dbDump.write("id,name,ingredients,recipe\n") // write header

Sql.withInstance(url, username, password, driver) { mySql ->
    mySql.eachRow('select * from dishes') { row ->
        dbDump.append("${row.id},${row.name},${row.ingredients},${row.recipe}\n")
    }
}

def fr = new FileReader(dbDump)
fr.eachLine {row ->
    println row
}
println "---------------------------------"
