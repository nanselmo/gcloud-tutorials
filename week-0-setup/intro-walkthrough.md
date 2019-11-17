# Intro

This walkthrough introduces the Google Cloud Shell environment, which you'll be using throughout CodeU.

You can return to this walkthrough anytime by executing this command:

```bash
teachme intro-walkthrough.md
```

Let's get started!

## Google Cloud Shell

[Google Cloud](https://cloud.google.com/) is a set of tools that lets you run code on the same computers that run Google. There are many ways to use Google Cloud: as a Java library, as a standalone tool, or as a service.

[Cloud Shell](https://cloud.google.com/shell/) is one way to interact with Google Cloud. Cloud Shell gives you a [code editor](https://cloud.google.com/shell/docs/viewing-and-editing-files) that lets you edit files, and a command line window to run commands. You can think of Cloud Shell as a window into a computer running inside of Google Cloud. You're going to use Cloud Shell over the next few weeks to write, build, and run your code.

If you see `Cloud Shell` in the upper-left corner and you're reading this text in a panel on the right, then you're already using Cloud Shell!

## Cloud Shell Editor

Cloud Shell comes with a built-in code editor that allows you to browse file directories and view and edit files.

To start, open the editor by clicking on the <walkthrough-cloud-shell-editor-icon></walkthrough-cloud-shell-editor-icon> icon to toggle the editor panel.

The editor displays the directory structure in its left-hand panel. You'll learn more about these files throughout CodeU, but for now try clicking around to explore. Try opening the `week-0-setup/intro-walkthrough.md` file to view the source for this walkthrough!

You'll be using the Cloud Shell editor quite a bit in the coming weeks, so take some time to familiarize yourself now. You can read more about Cloud Shell Editor [here](https://cloud.google.com/shell/docs/viewing-and-editing-files).

## Command Line

Cloud Shell also comes with a command line console that lets you run commands in Google Cloud.

Click the <walkthrough-cloud-shell-icon></walkthrough-cloud-shell-icon> icon to toggle the Cloud Shell console.

You can type commands into the console to run programs, compile your code, and deploy to Google Cloud.

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

If you're new to the command line, that's okay! You'll learn about some other commands soon, and you can also Google "command line commands" for some other resources.

## Directory Structure

This repo is split up into directories that contain the projects you'll be working on each week.

Wherever you see a file that ends with `-walkthrough.md`, you can run the `teachme` command on that file to open it in the walkthrough panel. For example, this command runs the walkthrough you're currently reading:

```bash
teachme intro-walkthrough.md
```

## Local Development

We recommend using Google Cloud Shell as your coding environment, because it comes with everything you'll need.

But if you're curious, it's also possible to do everything on your own computer, using whatever operating system and IDE you want. At a high level, you would need to:

1. Install Java 8, and add it to your `PATH`.
2. Install Maven, and add it to your `PATH`.
3. Install Git, and add it to your `PATH`.
4. Check out your team's repo.
5. Setup your editor or IDE.

You can explore this if you're curious, but we recommend sticking with the Google Cloud Shell editor. You can always do this later if you want to.

## Modify README

To test that everything is connected, modify the `README.md` file.

The `README.md` file contains the content that shows in your repo's GitHub page. Change it to include your name, and a brief paragraph that explains one non-programming fact about you!

## Push Your Changes

To save your changes to your team's repo, first create a branch:

```bash
git checkout -b YOUR_BRANCH_NAME
```

(You can use anything you want for `YOUR_BRANCH_NAME`. I normally use something like `KevinDevelopment`.)

Add the `README.md` file to the set of changes you want to upload:

```bash
git add README.md
```

Then create a commit which describes the changes you just made:

```bash
git commit -m "Update README.md file to include a fun fact about me."
```

Finally, push all of your changes to the shared repo:

```bash
git push origin YOUR_BRANCH_NAME
```

Your changes are now stored in a branch on your team's repo. Follow the instructions for creating a pull request on the CodeU website to send your changes to your team for review.

## Congratulations!

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

After you send your pull request, you've finished this introduction!