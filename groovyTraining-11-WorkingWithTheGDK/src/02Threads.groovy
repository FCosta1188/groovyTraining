import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

// Java approach
public class RunnableDemo implements Runnable {
    public RunnableDemo() {
        // do stuff
    }

    @Override
    public void run() {
        // this is where our task would go
    }
}

public class Application {
    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo();

        Thread t = new Thread(demo);
        t.start(); // calls run

        // Java 8: since Runnable is a functional interface we can also make an instance with a lamda expression.
    }
}
println '-------------------------------------'


// Groovy approach

// Right away Groovy is going to make our lives easier when it comes to creating threads.
// A Closure in groovy implements Runnable. This means that we can create a new thread pretty easily.
def t = new Thread() { /* task */ }
t.start()

// Show Thread static methods (to simplify the above code)
Thread.start { /* task */ }
Thread.start('thread-name') { /* task */ }

// In Java and Groovy you can create a daemon thread.
// A daemon thread is one that runs in the background and isn't tied to a program. This means a program can exit
// with daemon threads still running.
Thread.startDaemon { /* task */ }
Thread.startDaemon('daemon-name') { /* task */ }


// Sync push-pop (single thread)
List numbers = []

10.times {
    println "push\t: ${it}"
    numbers << it
}
println numbers

for( i in 9..0 ) {
    println "pop\t: ${i}"
    numbers.pop()
}
println numbers

// Async push-pop (multithreading)
BlockingQueue sharedQueue = [] as LinkedBlockingQueue
println sharedQueue
Thread.start('push') {
    10.times {
        try {
            println "${Thread.currentThread().name}\t: ${it}"
            sharedQueue << it
            println sharedQueue
            sleep 100
        } catch (InterruptedException ignore) {
            println ignore.message
        }
    }
}

Thread.start('pop'){
    for(i in 0..9) {
        sleep 200
        println "${Thread.currentThread().name}\t: ${sharedQueue.take()}"
        println sharedQueue
    }
}
println '-------------------------------------'