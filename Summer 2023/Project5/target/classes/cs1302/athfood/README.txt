This is a simple example illustrating a JavaFX app, reading from a CSV
file, creating a simple main window (it includes a new JavaFX control
of ComboBox), and creating a new window from a Button included in the
main window.  The new window is a modal window, just as you need in
Project 5.

The CSV file is placed in the src/main/resources directory, inside
your Maven directory structure.  This will include the data file (the
CSV file) as a resource in your JavaFX application.  In this way, we
are not accessing an "external" CSV file using an absolute file name,
which could lead to potential crashes if the app were to be moved to a
different computer, or the external file were removed or even renamed.

Furthermore, this example shows how you can update the data in a
window by iterating over elements on a list, just as you will need to
iterate over the 6 questions in a quiz.

This example is a Maven project, which was initialized by mvn, as
described in the Developing JavaFX programs on odin guide.
Consequently, it is very easy to work with this example. 

To compile the example, execute:

  mvn compile

To run it, first start your X11 server, if on a Windows computer (on a
Mac, XQuartz should start automatically) and connect to odin with X11
forwarding enabled, as described in the Developing JavaFX programs on
odin guide.

Then, execute:

  mvn javafx:run

You can also clean the project by executing:

  mvn clean

