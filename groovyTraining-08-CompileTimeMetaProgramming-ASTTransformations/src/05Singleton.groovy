//https://docs.groovy-lang.org/next/html/gapi/groovy/lang/Singleton.html

@Singleton
class DatabaseConnection {
    // ...
}

// java.lang.RuntimeException: Can't instantiate singleton DatabaseConnection. Use DatabaseConnection.instance
//DatabaseConnection dbConnection = new DatabaseConnection()
//println dbConnection

DatabaseConnection dbConnection = DatabaseConnection.instance
println dbConnection
println"--------------------------"
