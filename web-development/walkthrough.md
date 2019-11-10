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

**INFO: Dev App Server is now running**

Now that you have a server running, your browser can send requests to it. Click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to open a tab that displays the `index.html` file.

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
- [MDN](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/HTML_basics)
- [Google's HTML Style Guide](https://google.github.io/styleguide/htmlcssguide.html)

Don't forget that Google is your friend! For example, try searching "html image tag" for a ton of useful results about adding images to HTML.

### CSS

You can use Cascading Style Sheets, or CSS, to style your HTML with formatting and colors.

Learning CSS is **optional** for the rest of the content. But if you're curious, here are a few places to learn more:

- [W3Schools](https://www.w3schools.com/css/)
- [MDN](https://developer.mozilla.org/en-US/docs/Web/CSS)

If you're interested in CSS, feel free to explore it further. But make sure you're spending most of your time on the core topics each week!

### Practice

Modify the `index.html` file to create a webpage containing five facts about yourself. Then deploy it to a dev server to see your changes.

## JavaScript

You can use JavaScript to make your page interactive.

To write JavaScript, start by creating a file named `script.js` next to your `index.html` file.

Add this function to your `script.js` file:

```javascript
function showHello() {
  alert('Hello!');
}
```

This function calls the [`alert()`](https://www.w3schools.com/jsref/met_win_alert.asp) function, which shows a dialog.

Then add this line to the `<head>` section of your `index.html` file:

```html
<script src="script.js"></script>
```

This line tells the browser to load the `script.js` file when it loads the page, which means we can use the `showHello()` function in our HTML.

Add this line to the `<body>` section of your `index.html` file:

```html
<button onclick="showHello()">Click me!</button>
```

Now run your development server and click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to view your changes.

Your page should now contain a button that shows a dialog when you click it!

You can learn more about JavaScript at [W3Schools](https://www.w3schools.com/js/default.asp) and [MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript), or by googling "JavaScript tutorials".

## DOM Manipulation

You can also use JavaScript to change the HTML in the page, also called the document object model, or the DOM.

Add this to the `<body>` section of your `index.html` page:

```html
<div id="output"></div>
```

This line creates an empty `<div>` element with an `id` of `output`. This tag does not have any content, at least not yet!

Now change your `showHello()` function to this:

```javascript
function showHello() {
  const outputElement = document.getElementById('output');
  outputElement.innerText = 'Hello!';
}
```

This code finds the element with an `id` of `output` and then sets the `innerText` of that element.

Run your development server again and refresh your web preview. Now when you click the button, the message should show in the page instead of in a dialog.

You can learn more about DOM manipulation on [W3Schools](https://www.w3schools.com/js/js_htmldom.asp) and [MDN](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction), or by googling "JavaScript DOM manipulation".

## Live Server

TODO

## Your Turn

Congratulations, you've completed this walkthrough! You should now have some familiarity with HTML and JavaScript.

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

To practice what you just learned, pick a project from the `week_1` directory. Talk with your group to decide who will do what!

- Project 1: About Me
- Project 2: Organization Homepage
- Project 3: Portfolio
- Project 4: Current time?