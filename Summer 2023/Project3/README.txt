Be in the the parent directory "Project3"
(cs1302-->Project3)

How to compile java files:
javac -d classes /src/edu/uga/cs1302/txtbuff/*.java

How to compile tester:
input "javac -cp lib/junit-4.13.2.jar:classes -d classes test/edu/uga/cs1302/txtbuff/EditableTextLineTester.java"

How to run tester:
input "java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:classes org.junit.runner.JUnitCore EditableTextLineTester"

