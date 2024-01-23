/*
Metaprogramming is a programming technique in which computer programs have the ability to treat other programs as their data.
It means that a program can be designed to read, generate, analyze or transform other programs, and even modify itself while running.

https://docs.groovy-lang.org/latest/html/documentation/core-metaprogramming.html
The Groovy language supports two flavors of metaprogramming: runtime and compile-time.
The first allows altering the class model and the behavior of a program at runtime while the second only occurs at compile-time.

Meta Object Protocol (MOP): a collection of rules on how a request for a method call is handled by the Groovy runtime system
                            and how to control the intermediate layer.

With runtime metaprogramming we can postpone to runtime the decision to intercept, inject and even synthesize methods of classes and interfaces.
For a deep understanding of Groovy’s MOP we need to understand Groovy objects and Groovy’s method handling.
In Groovy we work with three kinds of objects: POJO, POGO and Groovy Interceptors. Groovy allows metaprogramming for all types of objects but in a different manner.

- POJO (Plain Old Java Object): A regular Java object whose class can be written in Java or any other language for the JVM.
- POGO (Plain Old Groovy Object): A Groovy object whose class is written in Groovy. It extends java.lang.Object and implements the groovy.lang.GroovyObject interface by default.
- Groovy Interceptor: A Groovy object that implements the groovy.lang.GroovyInterceptable interface and has method-interception capabilities.
*/


