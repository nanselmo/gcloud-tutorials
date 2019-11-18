# Server Programming - Comments

## Getting Started

Last week, you wrote HTML and JavaScript, and you deployed a dev server and a live server that hosted your files so web browsers could access them.

This week, you'll write code that runs on a server.

You can return to this walkthrough anytime by running this command:

```bash
teachme comments-walkthrough.md
```

Click the **Start** button to begin!

## Client and Server

You'll hear these words a lot, so let's start by defining them.

A [client](https://en.wikipedia.org/wiki/Client_(computing)) is whatever you're using to interact with the internet. It's the web browser you're using to read this page. The web browser on your computer is one client, the web browser on your phone is another client. There are other types of clients (like watching Netflix or listening to Spotify), but we'll focus on web browsers for now.

One important property of a client is that they run locally, on your computer (or phone, or game console, or whatever device you're using). When we talk about "client-side", or something that happens "in the client", we mean it happens on your device.

A [server](https://en.wikipedia.org/wiki/Server_(computing)) is the computer that the client requests data from. This project uses Google Cloud, so the computer is in a Google [data center](https://www.google.com/about/datacenters/). That computer can return a static file like you created last week, but it can also execute code to decide what content to send back to the client.

## Servlets

A servlet is a Java class with functions that run when a client requests a particular URL. You'll see two functions most often:

- `doGet()` runs when a client requests data from a URL.
- `doPost()` runs when a client sends data to a URL, for example when the user submits a form.

These functions run automatically, similar to how the `main()` function runs when you execute a Java program.

To see an example, open up the `src/main/java/io/happycoding/servlets/CommentsServlet.java` file. This file contains a few interesting lines:

- `@WebServlet("/comments")` is an [annotation](https://en.wikipedia.org/wiki/Java_annotation) that tells our server which URL this servlet maps to. When a client requests the `/comments` URL, this servlet is triggered.
- The `doGet()` function runs whenever a client sends a `GET` request to the servlet's URL. (Your browser sends a `GET` request whenever you visit a URL.)
- The `response.setContentType("text/html;");` line specifies what type of content the client should expect.
- The `response.getOutputStream().println("<h1>Hello world!</h1>");` prints an `<h1>` tag as the response.

To see this in action, let's run a development server.

```bash
mvn appengine:devserver
```

Run this command and then click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to open a tab that displays the `index.html` file. Then navigate to `/comments` to see the content that's coming from the `HelloWorldSevlet.java` file.

Change the content returned by the servlet and restart your development server to see your changes.

### URLs

This servlet maps to the `/comments` URL. You can change the annotation so it maps to a different URL, like `content` or `mypage.html`.

## Dynamic Content

So far, the servlet returns some static HTML content. This works, but the real power of server-side code is the ability to return **dynamic** content.

To see this in action, add variable to the `CommentsServlet` class:

```java
private List<String> comments = new ArrayList<>();
```

This `ArrayList` will eventually store our comments. For now, add some hard-coded data:

```java
@Override
public void init(){
  comments.add("Hello!");
  comments.add("Hey.");
  comments.add("Hi");
}
```

The `init()` function runs automatically when the servlet is created.

And then change the `doGet()` function to this:

```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  response.setContentType("text/html;");

  response.getWriter().println(comments);
}
```

Whenever the `doGet()` function runs, this code outputs the `ArrayList`.

Restart your development server and refresh the page. The page should show the comments.

**Tip:** Consider creating a pull request from what you've done so far.

## Fetch

A page that shows a list isn't very useful by itself. The page needs more HTML to display content to the user.

You could output HTML directly from the servlet, but that's hard to maintain. Imagine writing a whole HTML page using print statements!

Instead, you can write client-side JavaScript code that **fetches** the content from the server and adds it to an existing HTML file.

First, add an empty `<div>` element to the `<body>` of the `index.html` file:

```html
<div id="comments"></div>
```

Then add this to the JavaScript loaded from your `index.html` file:

```javascript
fetch('/comments')
.then((response) => { 
  return response.text(); 
})
.then((comments) => {
  const commentsElement = document.getElementById('comments');
  commentsElement.innerText = 'Comments: ' + requestCount;
}); 
```

You can either create a new `script.js` file or include this code in a `<script>` tag. See week 1's projects for examples.

This code fetches the content from the `/comments` URL, which executes the servlet's `doGet()` function, which returns the comments. This code then adds those comments to the page content, so the user can see them.

### Fetch and Promises

Since this request is asynchronous (it happens in the background), the `fetch()` function returns a **promise**. This can be confusing, so you might want to read more about it. Here are a few resources:

- [JavaScript Promises - an Introduction](https://developers.google.com/web/fundamentals/primers/promises)
- [Introduction to fetch()](https://developers.google.com/web/updates/2015/03/introduction-to-fetch)
- [Using Promises - MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises)
- [Using Fetch - MDN](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)

You're going to use `fetch()` and promises a lot in the next few weeks, so make sure you understand how they work!

## JSON

The above example prints out the `ArrayList` directly, but you'll normally want to return more complex data in the response from a server. To accomplish this, you can use any format you want: XML and key-value pairs are popular choices.

Another common format is [JavaScript Object Notation](http://www.json.org/). JSON is handy because JavaScript can parse JSON without requiring any custom code.

Modify your `doGet()` function to output the comments as JSON:

```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  response.setContentType("application/json;");

  response.getWriter().println("[");
  for(int i = 0; i < comments.size(); i++) {
    String comment = comments.get(i);
    response.getWriter().println("\"" + comment + "\"");

    // don't print a comma after the last comment
    if(i < comments.size() - 1){
      response.getWriter().println(",");
    }
  }
  response.getWriter().println("]");
}
```

This code outputs JSON in this format:

```json
["Hello!", "Hey.","Hi"]
```

Now change your JavaScript code to parse this JSON to add content to the page:

```javascript
fetch('/comments')
.then((response) => { 
  return response.json(); 
})
.then((comments) => {
  const commentsElement = document.getElementById('comments');

  commentsElement.innerHTML = '<ul>';
  for(let i = 0; i < comments.length; i++) {
    commentsElement.innerHTML += '<li>' + comments[i] + '</li>';
  }
  commentsElement.innerHTML += '</ul>';
}); 
```

This code fetches the data from the server, parses it as JSON, and then uses it to build the UI.

Restart your development server to make sure everything works how you expect.

## Gson

Formatting data as JSON can be tedious and error-prone. Instead of doing it yourself, you can use a library that does it for you!

[Gson](https://github.com/google/gson) is an open-source Java library that formats Java objects as JSON strings.

To use Gson, first add this dependency to the `pom.xml` file:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.6</version>
</dependency>
```

This tells Maven to add the Gson library to your project. Now you can use it in your Java code.

Add this import statement to your servlet class:

```java
import com.google.gson.Gson;
```

Then change you `doGet()` function to use Gson to format the `ArrayList` as JSON:

```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  response.setContentType("application/json;");

  String json = new Gson().toJson(comments);
  response.getWriter().println(json);
}
```

Restart your development server to make sure everything works how you expect.

## POST Requests

Now you've seen two different ways to send requests to a server: by typing a URL into your browser, and by using the `fetch()` function.

So far, these requests have all been `GET` requests, because you're requesting to **get** some data from the server: some HTML, or some JSON content.

But there's another kind of request: `POST` requests allow users to **send** data to the server. One common way to do this is using an HTML form. To create a form, use the `<form>` element.

Open up the `index.html` file and add this content to the `<body>` section:

```html
<form action="/comments" method="POST">
  <textarea name="message"></textarea>
  <br/>
  <input type="submit" value="Submit">
</form>
```

This form contains a text area, and it sends that data as a `POST` request to the `/comments` URL when the user clicks the submit button.

Next, open your `CommentsServlet.java` file and add a `doPost()` function:

```java
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
  String message = request.getParameter("message");
  System.out.println("POST request message parameter: " + message);
  response.getWriter().println("POST request message parameter: " + message);
}
```

Similar to how the `doGet()` function runs when a client sends a `GET` request to the servlet's URL, the `doPost()` function runs when a client sends a `POST` request.

To test this out, run your development server and then load the `index.html` page in your browser. Type a message into the text area and then click the submit button.

The `doPost()` function shows the message in the page, and it also prints it to the console. You should be able to see the print statement in the cloudshell editor. This will be handy for debugging!

To store the comment entered by the user, add it to the `ArrayList`, and then redirect them back to the `index.html` page:

```java
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
  String message = request.getParameter("message");
  comments.add(message);
  response.sendRedirect("/index.html");
}
```

Run your development server again. You should now be able to add comments to your page!


## Why Servlets?

Most large projects use a framework like Spring, Grails, or Flask. So why are we using servlets?

First, learning the fundamentals is important for understanding the higher-level concepts used by a framework. It's hard to learn a framework before you understand how requests work, for example.

Second, using a framework involves a lot of setup and configuration. Code is hard enough to debug, even without fighting with framework config files!

Third, most of the Google Cloud tutorials use servlets. So anything you find in a Google Cloud tutorial should "just work" with the code you write here.

All of that said, if using a framework is interesting to you, consider exploring that during the open project!

## Your Turn

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

You now have a working comment feature! Here are a few ideas for what to do next:

- Add comments to the page you created during week 1.
- Improve the formatting of the comments by adding a timestamp.
- Add a text field that allows users to specify their name as well as a comment.
- Improve error handling and security. What if a user enters HTML content?
- Add a dropdown box that allows users to add a mood (like happy or sad) to their comments.

**Advanced Features:** This code uses an in-memory `ArrayList`, which means that comments will go away when you restart your server. If you want to learn about **persistent storage**, then check out the Datastore project during week 4. If you want to learn about image uploads, check out the Blobstore project!

## Live Server

TODO

## Pull Requests

TODO