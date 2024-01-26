// create a new file/directory (they are equivalent in Java/Groovy)
def fileDummy = new File('dummy.txt')
fileDummy.write("This is some dumb text \n")

// append
fileDummy.append("I am appending text...\n")
println fileDummy.getText()

// create a new file with a bunch of text and read it
println new File('dummier.txt').text = 'one liner File instance'

// readLines
List lines = fileDummy.readLines()
println lines
lines.each { line ->
     println line
}
println '---------------------------'

// list all the files in a directory
    // eachFile(closure)
    String dir = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/src'
    new File(dir).eachFile { fileDir ->
        // show all first
        if(fileDir.isFile()){
            println fileDir.name
        }
    }

    // eachFileRecurse
    String groovyCourse = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/src'
    new File(groovyCourse).eachFileRecurse { file ->
        // show all first
        if( file.isFile() && file.name != '.git' ){
            println file.name
        }
    }

// list only certain files from this directory
new File('.').eachFile { file ->
    if( file.name.endsWith('.groovy') ) {
        println file.name
    }
}
println '-------------------------------------'

