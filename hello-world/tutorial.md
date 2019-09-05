# Hello World Tutorial

This tutorial introduces Google's Cloud Shell and editor. We'll use Maven to compile and run a hello world program.

## Directory Structure

Look through the directory using the <walkthrough-spotlight-pointer spotlightId="devshell-web-editor-button">explorer</walkthrough-spotlight-pointer>.

Try navigating to the various files in this project.

## Understanding Maven

The project in this folder uses Maven to build and run the code.

Open <walkthrough-editor-open-file filePath="pom.xml" text="pom.xml">
</walkthrough-editor-open-file> to view the configuration file for this project.

Notice the `exec.mainClass` property, which specifies the class to run.

## Running

We'll use the Cloud Shell console to run our code. Click the `walkthrough cloud-shell-icon` button to open the console, and then type this command:

```bash
mvn clean compile exec:java
```

### Errors

Encountering errors is a normal part of coding! If your code contains any compiler errors, they'll show up in the console during this step. Get into the habit of scrolling up and looking for errors.

## Your Turn

`conclusion-trophy`

Try changing the text in the `HelloWorld` class to print out a different message!
