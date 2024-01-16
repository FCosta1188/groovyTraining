/*
Behind the scenes, Groovy creates a class which extends the Script class and
contains a run() method; this method contains the println statement.
It is possible to inspect this code (see below) via groovyConsole -> Script -> Inspect AST.

public class script1705058197125 extends groovy.lang.Script {
    public script1705058197125() {
    }

    public script1705058197125(final groovy.lang.Binding context) {
        super(context)
    }

    public static void main(final java.lang.String[] args) {
        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1705058197125, args)
    }

    public java.lang.Object run() {
        this.println('Hello Groovy')
    }
}
*/
println "Hello Groovy"
