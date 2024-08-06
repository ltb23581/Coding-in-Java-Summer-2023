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

  javac -d classes src/edu/uga/cs/students/*.java test/edu/uga/cs/students/*.java

and to run it, you need to provide the fully-qualified name
of the class with the main method:

  java edu.uga.cs.students.InheritanceDemo

Your CLASSPATH must include the ./classes directory.
Alternatively, you may provide the -cp option:

  java -cp classes edu.uga.cs.students.InheritanceDemo


In order to generate javadoc documents, enter (you need to create a
directory called html, ahead of time):

  javadoc -d html -sourcepath src -subpackages edu

The automatically created documentation will be placed in the
directory html.


IMPORTANT:  
Note that you will no be able to view the online documentation
directly on odin.  This is because you will not have access to the
graphical console (monitor) connected to odin, as only the systems
administrator can use it in the server room. 

In order to view the online documentation generated on odin, you can
either: 

A.  Transfer the entire html directory to your own system and the view
    the documentation in your browser. Using a file browser on your
    system navigate to the transferred html directory and open the
    file called index.html.

OR

B.  Install the X Windows server on your local system (your own laptop
    or desktop).  This step will be useful when we work on Java GUI
    development, as well.

    Here are brief instructions on how to do this on a Mac and on Windows.

    On a Mac OS X system:
      1. Install the XQuartz application, which is the official X
         server software for the Mac. 
      2. Start the XQuartz program (it is in the Utilities folder under
         Applications).  Chances are it will start automatically once
      	 you start an ssh session with X11 forwarding (as explained
      	 below) and start an X windows program, fo example, emacs.
      3. In a terminal window, connect to odin using the ssh command
         with the -Y option:
   
         $ ssh -Y user@odin.cs.uga.edu

      4. On odin, start the Firefox browser (just run firefox, on
         odin);  its window will be redirected to your local laptop/desktop.
      5. In the Fireforx window, type control-o (^o) and navigate to
         your html directory on odin (with the generated JavaDoc
         documentation), then open the file index.html.  You will be
         able to see the generated documentation on your local laptop,
         even though the HTML pages are on odin.

    On a Windows systems:
      1. Install an X-Windows server.  There are many different
         X-Servers for Windows, so pick one.  I heard good things about
         the Xming X Server, even though I haven't used it
         personally (some of you have already installed MobaXterm).
         A good intro to Xming is available at this URL: 

           http://www.straightrunning.com/XmingNotes

      2. Run Xming on your laptop to start the X server.  You should see
         the Xming icon in the taskbar if it is running.
      3. Run PuTTY, but before you connect to odin, you need to
         configure putty as follows:

            - Enter the server name in Host Name (odin.cs.uga.edu)
            - Make sure the Connection type is set to SSH
            - Enable X11 forwarding (Connection > SSH > X11)

         then connect to odin using your normal user name and
         password.
	 On MobaXterm you can use their tabbed terminal with SSH
         capabilities, instead.
      4. On odin, start the Firefox browser (just type firefox at the
         command prompt);  its window will be redirected to your local
         laptop/desktop.
      5. In the Fireforx window, type control-o (^o) and navigate to
         your html directory on odin, then open the file index.html.
         You will be able to see the generated documentation on your
         local laptop, even though the HTML pages are on odin.
