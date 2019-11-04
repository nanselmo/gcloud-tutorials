# Web Development

This walkthrough uses HTML to create a website, and uses App Engine to deploy that website to a public URL.

## Getting Started

If you aren't an HTML expert, that's okay! You don't need anything to start this walkthrough.

You can return to this walkthrough anytime by running this command:

```bash
teachme walkthrough.md
```

Click the **Start** button to begin!

## Directory Structure

Look through the directory structure using the file explorer. The project contains three files:

- <walkthrough-editor-open-file filePath="gcloud-tutorials/web-development/pom.xml">pom.xml</walkthrough-editor-open-file> is a Maven configuration file.
- <walkthrough-editor-open-file filePath="gcloud-tutorials/web-development/src/main/webapp/index.html">src/main/webapp/index.html</walkthrough-editor-open-file> is an HTML file that will be rendered by the browser.
- <walkthrough-editor-open-file filePath="gcloud-tutorials/web-development/src/main/webapp/WEB-INF/appengine-web.xml">src/main/webapp/WEB-INF/appengine-web.xml</walkthrough-editor-open-file> is App Engine's configuration file.

Try navigating to the various files in this project and viewing their contents in the editor.

You'll learn more about each of these files in the following steps.

## Running a Development Server

This project is a web application that contains a single HTML file. To make this HTML available to your web browser, you need to run a **server** to host the file.

To run a server, execute this command:

```bash
mvn appengine:devserver
```

This command tells Maven to run an App Engine development server, which is useful for testing changes before deploying your site publicly. You'll run this command a lot over the next few weeks!

The first time you run this command, Maven will automatically download all of the libraries and files required to run a server, so it might take a few minutes. When the command completes, you'll see this in the console:

```
INFO: Dev App Server is now running
```

Now that you have a server running, your browser can send requests to it. Click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select `Preview on port 8080` to send a request for the `index.html` file.

Your new tab should show a barebones website. You'll start customizing this in the next step!

## index.html

Open the <walkthrough-editor-open-file filePath="gcloud-tutorials/web-development/src/main/webapp/index.html">index.html</walkthrough-editor-open-file> file.

This file contains **HTML tags** that tell a browser how to render text. For example, the `<h1>` tag renders as a heading, and the `<p>` tag renders as a paragraph.

Modify the text in this file and save your changes. (Try changing the heading to include your name.)

### Restarting Your Development Server

Whenever you change your code, you need to restart your server to see your changes. Press `ctrl + c` in the console to shut down your server, and then run the devserver command again:

```bash
mvn appengine:devserver
```

Click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select `Preview on port 8080` to see your changes!

## HTML tags

If you're new to HTML, that's okay! Here are a few place to learn more:

- [W3Schools](https://www.w3schools.com/html/default.asp)
- [Mozilla Developer Network](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/HTML_basics)
- [Google's HTML Style Guide](https://google.github.io/styleguide/htmlcssguide.html)

Don't forget that Google is your friend! For example, try searching "html image tag" for a ton of useful results about adding images to HTML.

Try changing the `index.html` file to create an "about me" webpage for yourself.

### CSS

## JavaScript

### DOM Manipulation


