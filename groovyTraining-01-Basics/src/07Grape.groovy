/*
Grape is a JAR dependency manager embedded into Groovy. Grape lets you quickly add maven repository dependencies to your classpath.
*/

@Grapes(
    @Grab(group ='org.apache.commons', module='commons-lang3', version='3.14.0') //module = ArtifactId
)

import org.apache.tools.mail.MailMessage
MailMessage msg = new MailMessage(from:"fc@gmail.com")
println msg.from()
