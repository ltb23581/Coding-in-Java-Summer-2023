This is a small example illustrating how to read from a CSV file.
Also, it is a Maven project, which will allow us to locate and
automatically download the necessary CSV reading library (an
Apache library for reading and writing CSV files).

The dependency for the CSV reading library is already included
in the pom.xml file.  It is

    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-csv</artifactId>
        <version>1.10.0</version>
    </dependency>

placed right after the junit dependency.  This dependency will
automatically download the jar file from the standard Maven
repository (you can look at the repository using your Web browser:

https://mvnrepository.com/artifact/org.apache.commons/commons-csv).

IMPORTANT:  note that the csv file (ranking.csv) used in this example
is placed as part of the program, in the src/main/resources directory.
This directory is not automatically created by Maven when you first
create a Maven project.  You will have to add it manually (using mkdir)
and place there any resource files (with some initial data).
Carefully examine how a file from the resources directory is accessed
in the main method of the CSVReader class.  Accessing it in a
non-static method is a bit different.


In order to run this example:

1. Compile the project:

   While in the csvreading directory, execute:

     mvn compile

   As usual, the resulting class files will be in the target directory:

     ./target/classes         -- your compiled class files

   You can also package your code into a jar file.  Execute:

     mvn package

   The jar file will be in:

     ./target/csvreading-1.0-SNAPSHOT.jar

2. Now, you may run this program using the following maven command:

   mvn exec:java -Dexec.mainClass="edu.uga.cs1302.csvsample.CSVReader"

   This command will execute Java, given the full name of the class
   with the main method.  Note that we don't have to provide the location
   of the CSV reading jar file, as it is already known to Maven (as a
   dependency in pom.xml).
   
3. You may also run this program using a regular java command:

     java -cp target/classes:/home/myid/kkochut/classes/commons-csv-1.10.0.jar edu.uga.cs1302.csvsample.CSVReader
   
   Please note that we using here an command line option -cp
   specifying the classpath for Java.  It includes the compiled class
   files in target/classes and also the needed commons-csv-1.10.0.jar jar file.

   Or, if you created a project's jar file (package), you can execute the program this way:

     java -cp target/csvreading-1.0-SNAPSHOT.jar:/home/myid/kkochut/classes/commons-csv-1.10.0.jar edu.uga.cs1302.csvsample.CSVReader

