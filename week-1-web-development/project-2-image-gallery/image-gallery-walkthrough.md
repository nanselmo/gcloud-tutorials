# Image Gallery

## Getting Started

This project uses HTML to create an image gallery, and uses App Engine to deploy that website to a public URL.

You can return to this walkthrough anytime by running this command:

```bash
teachme image-gallery-walkthrough.md
```

Click the **Start** button to begin!

## Directory Structure

Look through the directory structure using the file explorer. The project contains three files:

- `pom.xml` is a Maven configuration file. This file sets up the libraries we're using.
- `src/main/webapp/index.html` is an HTML file that will be rendered by the browser.
- `src/main/webapp/WEB-INF/appengine-web.xml` is App Engine's configuration file. This file tells Google Cloud how to deploy our code.

Try navigating to the various files in this project and viewing their contents in the Google Cloud Shell editor.

You'll learn more about each of these files in the following steps.

## Run a Development Server

This project is a web application that contains a single HTML file. To make this HTML available to your web browser, you need to run a **server** to host the file.

To run a development server, execute this command:

```bash
mvn appengine:devserver
```

This command tells Maven to run an App Engine development server, which is useful for testing changes before deploying your site publicly. You'll run this command a lot over the next few weeks!

The first time you run this command, Maven will automatically download all of the libraries and files required to run a server, so it might take a few minutes. When the command completes, you'll see this in the console:

**INFO: Dev App Server is now running**

Now that you have a server running, your browser can send requests to it. Click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to open a tab that displays the `index.html` file.

Your new tab should show a barebones website with a single image. You'll start customizing this in the next step!

## index.html

Open the `src/main/webapp/index.html` file in the Google Cloud Shell editor.

This file contains **HTML tags** that tell a browser how to render text. For example, the `<h1>` tag renders as a heading, and the `<img>` tag renders an image.

Modify the text in this file and save your changes. Change the heading to include your name.

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

Add some content to your image gallery:

- Add more images!
- Add a couple paragraphs explaining what you enjoy photographing.
- Add a link to your LinkedIn and GitHub profiles.

This is **your** image gallery, so make it your own. Create a gallery of your favorite places, or selfies, or pictures of your pets.

### Uploading Images

To add images to your project, right-click the `src/main/webapp/images` directory and then select `Upload Files...` to select an image from your computer.

To reference an image in your `images` directory, use a path that starts with a `/` forward slash, like `/images/cat.jpg`. This path will work on a development server and when you deploy to a live URL.

### CSS

You can use Cascading Style Sheets, or CSS, to style your HTML with formatting and colors. For example, you can use CSS to tell the browser what size to display your images.

Learning CSS is **optional** for CodeU. You can skip this step if you want. But if you're curious, here are a few places to learn more:

- [W3Schools](https://www.w3schools.com/css/)
- [MDN](https://developer.mozilla.org/en-US/docs/Web/CSS)

If you're interested in CSS, feel free to explore it further. But make sure you aren't spending most of your time on styling. You can always make your projects pretty after you get their core functionality working!

## JavaScript

You can use JavaScript to make your page interactive.

To write JavaScript, start by creating a file named `script.js` next to your `index.html` file.

Add this function to your `script.js` file:

```javascript
function showHello() {
  console.log('Hello!')
  alert('Hello!');
}
```

This function calls the `console.log()` function, which shows a message in the JavaScript console, and the [`alert()`](https://www.w3schools.com/jsref/met_win_alert.asp) function, which shows a dialog.

Then add this line to the `<head>` section of your `index.html` file:

```html
<script src="script.js"></script>
```

This line tells the browser to load the `script.js` file when it loads the page, which means we can use the `showHello()` function in our HTML.

Add this HTML tag to the `<body>` section of your `index.html` file:

```html
<button onclick="showHello()">Click me!</button>
```

This `<button>` element has an `onclick` attribute that tells the browser which JavaScript function to run when the user clicks the button.

Now run your development server and click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to view your changes.

Your page should now contain a button that shows a dialog when you click it!

### JavaScript Console

Your browser's JavaScript console will show anything you print out using the `console.log()` function, as well as any errors. **This should be the first place you look when you have a problem.** It's a good idea to always have your JavaScript console open, so you see errors right away.

You can learn more about JavaScript at [W3Schools](https://www.w3schools.com/js/default.asp) and [MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript), or by googling "JavaScript tutorials".

Change the button so it shows your contact info when the user clicks it.

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

Change the content that's added to the page. You can make it show your contact information, or tell a joke, or add any other content that makes sense to you.

## Live Server

TODO

## Pull Request

TODO