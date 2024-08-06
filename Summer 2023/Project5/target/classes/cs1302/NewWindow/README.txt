This is a simple JavaFX example.

Dawgs.java illustrates how to:

 1. open a new modal window in JavaFX.  The new window blocks the
    controls in the main window (parent) window until the new window is closed
 2. display a longer text in a scrollable control (ScrollPane)
 3. close a window from a button handler
 4. quit a JavaFX application from a button handler

DawgsDelay.java illustrates how to:

 1. open a new modal window in JavaFX.  The new window blocks the
    controls in the main window (parent) window until the new window is closed
 2. display a longer text in a scrollable control (ScrollPane)
 3. close a window from a button handler; however, in this example,
    the closing of the child window using JavaFX's Task class
 4. quit a JavaFX application from a button handler


To compile this project, execute:

  javac -d classes -p /usr/local/java/javafx-sdk-18.0.1/lib --add-modules javafx.controls src/*.java

IMPORTANT:
You need to run JavaFX programs by running java with the option -Dprism.order=sw
to avoid using the DirectX 2D pipeline.  So, for example, execute:

  java -Dprism.order=sw -p /usr/local/java/javafx-sdk-18.0.1/lib --add-modules javafx.controls Dawgs

or

  java -Dprism.order=sw -p /usr/local/java/javafx-sdk-18.0.1/lib --add-modules javafx.controls DawgsDelay

Of course, you need to use Oracle's Java JDK 17, as for your previous projects.
