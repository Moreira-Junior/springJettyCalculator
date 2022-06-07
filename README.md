###Hello! If you want to use my calculator, here's what you have to do to succeed.

###First, I have to inform you about the requirements for running this application localy.
Basically, you'll need a java environment, a Jetty server, Gradle, the source code of the app and a browser.

###Since you probably already have a browser, let's skip that part and focus on the rest of it.
First things first, I'm leaving a reference where you can be guided how to install the java environment and Jetty:
https://www.linuxcloudvps.com/blog/how-to-install-jetty-9-on-ubuntu-16-04/

Then, you have to download gradle, another guide for you:
https://gradle.org/install/

Finally, download this repository!

###Putting all of it together
Initially you have to build the application with gradle, so you can generate a .WAR file. That's the file you'll deploy on Jetty.
Inside the folder you downloaded with the source code, you can open a terminal and go like this: gradle build (pretty straight).
Then you have to find the file .WAR generated by the build, just follow the path: folderYouSavedTheRepo/build/libs.
Once you get there, you'll find the file: tema4.war, that's what you're looking for.

###Now you have to deploy it on Jetty
First of all, you have to copy the .WAR file to the path: jetty'sFolder/webapps.
After that, you have to open a terminal in Jetty's folder and execute the jar as follows:
java -jar start.jar - the server is already running.

You can access http://localhost:8080/tema4/Calculator and make as many calculations as you want now. Enjoy!

##Stopping the server
To stop the Jetty server, you just have to press CTRL + C in the terminal that is running Jetty:
