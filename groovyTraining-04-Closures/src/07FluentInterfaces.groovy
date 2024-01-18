// Venkat Subramaniam
// https://www.youtube.com/watch?v=URkFOLywex4

// Java 8
public class Mailer {

    public void to(String address) {
        System.out.println('to')
    }

    public void from(String address) {
        System.out.println('from')
    }

    public void subject(String subject) {
        System.out.println('subject')
    }

    public void body(String msg) {
        System.out.println('body')
    }

    public void send(){
        System.out.println('sending...')
    }
}

// noisy
// should we reuse the object?
Mailer mailer = new Mailer();
mailer.to("danvega@gmail.com");
mailer.from("danvega@gmail.com");
mailer.subject("Hello Dan");
mailer.body("Message Body");
mailer.send();
println "---------------------------"


// Groovy
public class FluentMailer {

    def to(String address) {
        println('to')
    }

    def from(String address) {
        println('from')
    }

    def subject(String subject) {
        println('subject')
    }

    def body(String msg) {
        println('body')
    }

    def static send(closure) {
        FluentMailer fluentMailer = new FluentMailer()
        fluentMailer.with closure
        println('sending...')
    }
}

FluentMailer.send {
    to("danvega@gmail.com");
    from("danvega@gmail.com");
    subject("Hello Dan");
    body("Message Body");
}
println "---------------------------"



