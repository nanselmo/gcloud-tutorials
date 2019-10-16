# Hello World Walkthrough

## Getting Started

This walkthrough introduces Google Cloud Shell and Cloud Shell editor.

Click the buttons at the bottom of this side panel to step through the walkthrough.

You can return to this walkthrough anytime by executing this command:

```
teachme tutorial.md
```

Let's get started!

## Google Cloud Shell

[Google Cloud](https://cloud.google.com/) is a set of tools that lets us run code on the same computers that run Google. There are many ways to use Google Cloud: as a Java library, as a standalone tool, or as a service.

[Cloud Shell](https://cloud.google.com/shell/) is one way to interact with Google Cloud. Cloud Shell gives you a [code editor](https://cloud.google.com/shell/docs/viewing-and-editing-files) that lets you edit files, and a command line window to run commands. You can think of Cloud Shell as a window into a computer running inside of Google Cloud. We're going to use Cloud Shell over the next few weeks to write, build, and run our code.

If you see `Cloud Shell` in the upper-left corner and you're reading this text in a panel on the right, then you're already using Cloud Shell!

## Cloud Shell Editor

Cloud Shell comes with a built-in code editor that allows you to browse file directories and view and edit files. Let's familiarize ourselves with how the Cloud shell editor works.

To start, open the editor by clicking on the <walkthrough-cloud-shell-editor-icon></walkthrough-cloud-shell-editor-icon> icon to toggle the editor panel.

The editor displays the directory structure in its left-hand panel. We'll learn more about these files in the following steps, but for now try clicking around to explore. Try opening the <walkthrough-editor-open-file filePath="gcloud-tutorials/hello-world/tutorial.md" text="tutorial.md"></walkthrough-editor-open-file> file to view the source for this walkthrough!

We'll be using the Cloud Shell editor quite a bit in the coming weeks, so take some time to familiarize yourself now. You can read more about Cloud Shell Editor [here](https://cloud.google.com/shell/docs/viewing-and-editing-files).

## Command Line

Cloud Shell also comes with a command line that lets us run commands in Google Cloud.

Click the <walkthrough-cloud-shell-icon></walkthrough-cloud-shell-icon> icon to toggle the Cloud Shell command line.

We can type commands into the command line to run programs, compile our code, and deploy to Google Cloud.

For now, try a few of these commands:

To get the path of your current directory:

```bash
pwd
```

To view the contents of your current directory:

```bash
ls
```

To move to a different directory:

```bash
cd src
```

To go back up a directory:

```bash
cd ..
```

If you're new to the command line, that's okay! We'll learn about some other commands soon, and you can also Google "command line commands" for some other resources.

## Directory Structure

Look through the directory structure using the file explorer. The project has a few key files and folders:

- `pom.xml` is a Maven configuration file.
- `src/` contains our code.
- `src/main` contains our core logic.
- `src/test` contains code that tests our core logic.

Try navigating to the various files in this project and viewing their contents in the editor.

## Maven

The project in this folder uses [Maven](https://maven.apache.org/) to build and run the code. Maven handles stuff like classpath management for us. This will come in handy, because it means we don't have to worry about downloading a bunch of `.jar` files ourselves. Maven automatically downloads dependencies, adds them to the classpath, and runs the code, all based on the content of the `pom.xml` file.

Open <walkthrough-editor-open-file filePath="gcloud-tutorials/hello-world/pom.xml" text="pom.xml">
</walkthrough-editor-open-file> to view the configuration file for this project.

Notice the `exec.mainClass` property, which specifies the class to run.

### Running Code

We'll use the Cloud Shell console to run our code. Click the <walkthrough-cloud-shell-icon></walkthrough-cloud-shell-icon> icon to toggle the console, and then type this command:

```bash
mvn clean compile exec:java
```

Press enter to run the command, which tells Maven to execute the main class.

NOTE: You might notice that the output contains a typo. We'll fix that in a minute.

### Errors

Encountering errors is a normal part of coding! If your code contains any compiler errors, they'll show up in the command line during this step. Get into the habit of scrolling up and looking for errors.

## Unit Tests

When writing code for a large project, it's not always possible to run our part of the code as a standalone program. The engineer working on Google's autocorrect feature doesn't want to run all of Google just to test their code! It can also be hard to remember all of the different things we need to test every time we make a change. That's where **unit tests** come in handy.

Unit tests are small programs or functions that test the core logic. A unit test usually consists of three parts:

- Setup, where some input is **arranged**.
- Execution, where the code **acts**, usually by calling a function.
- Confirmation, where the code **asserts** that the output is what we expect.

Open <walkthrough-editor-open-file filePath="gcloud-tutorials/hello-world/src/test/java/io/happycoding/gcloud/GreeterTest.java" text="GreeterTest.java"></walkthrough-editor-open-file> to view the unit tests for this project. The test class contains two functions that each test a different expected behavior of our core logic.

To run the tests, run this command:

```bash
mvn test
```

Read through the output of that command, and notice this line:

```
Failed tests:
testGetGreetingMessage(io.happycoding.gcloud.GreeterTest):
expected:<Hello[ ]world!>
but was:<Hello[]world!>
```

That's telling us that the `testGetGreetingMessage` test failed because it was expecting the output to be `Hello world!` but the output was `Helloworld!` instead.

### Your Turn

To make sure everything is working properly, your challenge is to modify `Greeter.java` to fix the bug and make sure all the tests pass. When all the tests pass, you're done!

## Congratulations!

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

If you're looking for more to do, try thinking about how the code should handle corner cases. What should happen with `null` or empty input, or input that contains punctuation? Try modifying the code and adding tests for the new behavior.
