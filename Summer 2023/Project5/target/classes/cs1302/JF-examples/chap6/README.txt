Examples in this chapter involve using GUI programs developed using
JavaFX.  You must have an X11 server installed on your laptop/desktop
in order to be able to see the GUI window(s) created by these
programs.

Also, you must include JavaFX modules available in a JavaFX lib
directory on odin.  Here is how you an run the PushCounter example:

To compile:
javac -d classes -p /usr/local/java/javafx-sdk-18.0.1/lib --add-modules javafx.controls src/PushCounter.java

To run:
java -Dprism.order=sw -p /usr/local/java/javafx-sdk-18.0.1/lib --add-modules javafx.controls PushCounter

The -Dprism.order=sw option is needed to overcome a small problem of
the GL library available on odin.
