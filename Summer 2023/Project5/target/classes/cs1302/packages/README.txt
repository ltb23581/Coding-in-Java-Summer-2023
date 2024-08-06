This is a simple example illustrating how to create Java packages.
The example also illustrates some of the fundamental aspects of class
inheritance and polymorphism.

You should copy this directory into your own home space to be
able to compile it yourself (as described below).  You will not be
able to compile the sources in my directory, since you don't have the
write access. 

The package in this example is called edu.uga.cs.students.
All Java classes have this package declaration (at the top of the
source file).  Also, note the directory structure of the source files
in this example.  The directory structure must mirror the name of the 
package and so all of the source file are placed in the directory
edu/uga/cs/students (in the src directory).

To compile this example, type:

$ javac -d classes src/edu/uga/cs/students/*.java

and to run it, you need to provide the fully-qualified name
of the class with the main method:

$ java edu.uga.cs.students.InheritanceDemo

or 

$ java edu.uga.cs.students.InheritanceDemo2

Your CLASSPATH must include the ./classes directory.
Alternatively, you may provide the -cp option:

$ java -cp classes edu.uga.cs.students.InheritanceDemo
$ java -cp classes edu.uga.cs.students.InheritanceDemo2
