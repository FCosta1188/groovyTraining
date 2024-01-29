//FILES ----------------------------------------------------------
// create a new file/directory (they are equivalent in Java/Groovy)
def fileDummy = new File('dummy.txt') // creates a File object but does not write to disk
fileDummy.write("This is some dumb text \n") // writes to disk

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

// list all the files in a directory
    // eachFile: every file in dir
    String dir = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK'
    new File(dir).eachFile { fileDir ->
        // show all first
        if(fileDir.isFile()){
            println fileDir.name
        }
    }

    // eachFileRecurse: every file in dir and corresponding sub-dirs
    String groovyCourse = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK'
    new File(groovyCourse).eachFileRecurse { file ->
        // show all first
        if( file.isFile() && file.name != '.git' ){
            println file.name
        }
    }

// list only certain files from current directory ('.')
new File('.').eachFile { file ->
    if( file.name.endsWith('.groovy') ) {
        println file.name
    }
}
println '-------------------------------------'


//DIRS ----------------------------------------------------------
// list all the directories in a given path
dir = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/files'
List hidden = []
new File(dir).eachFile { file ->
    if(file.isDirectory()){ // true if the file is actually a folder, false if it is a final file
        println file.name
    }

    if(file.isHidden()) { // true if the file/dir is hidden
        hidden << file.name
    }
}
println hidden

// list all directories and subdirectories in a given path
dir = 'C:/Users/TI-LT2101/IdeaProjects/groovyTraining/groovyTraining-11-WorkingWithTheGDK/files'
new File(dir).eachDir { subfolder ->
    println "$subfolder.name: $subfolder"
}

// get the size of a directory
println dir.size()

// create a new directory
new File("$dir/dummyDir").mkdir()

// create multiple nested directories
new File("$dir/dummyDir/one/two/three").mkdirs()

// delete a directory
new File("$dir/dummyDir").deleteDir()
println '-------------------------------------'


//I/O ----------------------------------------------------------
println "Please Enter Your Favorite Sports Team..."

String team
System.in.withReader { reader ->
    team = reader.readLine()
}

println "Your favorite team is: $team"
println '-------------------------------------'

