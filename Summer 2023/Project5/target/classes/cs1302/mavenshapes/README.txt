This README file is for the mavenshapes example.  It includes the
steps of creating the project directory and executing a few of the
common Maven commands. 

IMPORTANT: you must add the JAVA_HOME variable in your .bash_profile on odin.

The JAVA_HOME environment variable is necessary for the proper
operation of Maven.  So, edit (using emacs or vi) your .bash_profile,
which is in your home directory on odin, and add the following two
lines to it:

JAVA_HOME=/usr/local/java/jdk-17.0.3.1
export JAVA_HOME

then run  

source .bash_profile  

to verify that your environment is properly set up.  Of course, correct any errors before you log out.


1. Create the maven project for shapes

mvn archetype:generate -DgroupId=edu.uga.cs1302.shape -DartifactId=mavenshapes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

2. Display the project directory hierarchy:

Go to the created mavenshapes directory and execute:

   $ find .

You should see:

./pom.xml
./src
./src/main
./src/main/java
./src/main/java/edu
./src/main/java/edu/uga
./src/main/java/edu/uga/cs1302
./src/main/java/edu/uga/cs1302/shape
./src/main/java/edu/uga/cs1302/shape/App.java
./src/test
./src/test/java
./src/test/java/edu
./src/test/java/edu/uga
./src/test/java/edu/uga/cs1302
./src/test/java/edu/uga/cs1302/shape
./src/test/java/edu/uga/cs1302/shape/AppTest.java


3. While still in the mavenshapes directory, modify the pom.xml file,
   as described below (pom.xml is a text file, so you should use
   either emacs or vi to modify it):

a. switch the project to Java 17:
 
   change the lines
       <maven.compiler.source>1.7</maven.compiler.source>
       <maven.compiler.target>1.7</maven.compiler.target>
   to
       <maven.compiler.source>17</maven.compiler.source>
       <maven.compiler.target>17</maven.compiler.target>

b. switch the JUnit version to 4.13.2:
  
   Look for a fragment defining the JUnit dependency:

     <dependencies>
       <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.11</version>
         <scope>test</scope>
       </dependency>
     </dependencies>

   and change the line
         <version>4.11</version>
   to
         <version>4.13.2</version>

c. add javadoc plugin

   Locate the <build> tag for the beginning of the build section in
   pom.xml and then locate the start of the <plugins> section (it
   should be just two lines below): 

    <build>
     <plugins>
      <pluginManagement>

   And add the javadoc plugin section:

        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-javadoc-plugin</artifactId>
          <version>3.3.0</version>
          <configuration>
            <show>private</show>
            <nohelp>true</nohelp>
          </configuration>
        </plugin>

d. add the reporting section

   Locate the </project> tag at the very end of the pom.xml file and
   add the following reporting section (right before the </project> tag): 

   <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.3.0</version>
        <configuration>
          <stylesheetfile>${basedir}/src/main/javadoc/stylesheet.css</stylesheetfile>
          <show>public</show>
        </configuration>
      </plugin>
    </plugins>
   </reporting>

Remember to save the modified pom.xml file.

4. Place the project source code in the ./src/main/java/edu/uga/cs1302/shape directory
   In this example, we use the code from the polymorphism example in ~kkochut/cs1302/polymorphism,
   modified to be placed in a package edu.uga.cs1302.shape.

   You should remove the App.java file from ./src/main/java/edu/uga/cs1302/shape.  
   It is only a sample Java class included as an illustration.

   Similarly, you should remove the AppTest.java file from ./src/test/java/edu/uga/cs1302/shape.

5. Place the project test code in the ./src/test/java/edu/uga/cs1302/shape directory
   In this example, we use the RectangleTester class from the junit example in ~kkochut/cs1302/junit,
   modified to be placed in a package edu.uga.cs1302.shape.

Note that all test classes must have a specific name.  Typically,
Maven uses the Surefire Plugin to run the tests.
By default, the Surefire Plugin will automatically include all test
classes with the following wildcard patterns: 

   "**/Test*.java" - includes all of its subdirectories and all Java filenames that start with "Test".
   "**/*Test.java" - includes all of its subdirectories and all Java filenames that end with "Test".
   "**/*TestCase.java" - includes all of its subdirectories and all Java filenames that end with "TestCase".

So, the easiest thing is to name all test classes with the suffix
Test.  For example, for SomeClass the test class should be SomeClassTest.

6. Compile the project:

While in mavenshapes, execute:

   $ mvn compile

The resulting files will be in the target subdirectories:

   ./target/classes         -- your source code class files
   ./target/test-classes    -- your test classes class files

You can also package your code into a jar file:

   $ mvn package

Your jar files will be in:

   ./target/mavenshapes-1.0-SNAPSHOT.jar

7. You may run the Test program (it is not a JUnit test -- just a simple program using shapes):

   $ java -cp target/classes edu.uga.cs1302.shape.Test
   
If you created a jar file (package), you can execute the program this way:

   $ java -cp target/mavenshapes-1.0-SNAPSHOT.jar edu.uga.cs1302.shape.Test

8. Test the project:

While in mavenshapes, execute:

   $ mvn test

All Test classes will be executed within JUnit and the report will be listed.

9. Generate the JavaDoc documentation:

While in mavenshapes, execute:

   $ mvn site

NOTE: in this example, there are no JavaDoc comments in the
      RectangleTest class, so this step generates several warnings.

The generated files will be in:

   ./target/site/apidocs/
