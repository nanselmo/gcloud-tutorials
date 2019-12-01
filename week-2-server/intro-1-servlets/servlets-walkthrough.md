# Intro to Servlets

## Getting Started

This walkthrough introduces **servlets**, which let you write Java code that runs on a server.

You can return to this walkthrough anytime by running this command:

```bash
teachme servlets-walkthrough.md
```

Click the **Start** button to begin!

## Clients and Servers

You'll hear these words a lot, so let's start by defining them.

A [client](https://en.wikipedia.org/wiki/Client_(computing)) is whatever you're using to interact with the internet. It's the web browser you're using to read this page. The web browser on your computer is one client, the web browser on your phone is another client. There are other types of clients (like watching Netflix or listening to Spotify), but we'll focus on web browsers for now.

One important property of a client is that they run **locally**, on your computer (or phone, or whatever device you're using). When we talk about "client-side", or something that happens "in the client", we mean it happens on your device.

A [server](https://en.wikipedia.org/wiki/Server_(computing)) is a computer that **serves** content based on a request. It's the computer that your computer is talking to when it asks for a particular URL.

This project uses Google Cloud, so the server computer happens to be in a Google [data center](https://www.google.com/about/datacenters/).

Servers can return a static file like you created last week, but they can also execute code to decide what content to send back to the client. The rest of this walkthrough introduces that type of server-side code.

## Servlets

A servlet is a Java class with functions that run when a client requests a particular URL. These functions run automatically, similar to how the `main()` function runs when you execute a core Java program.

To see an example, open up the `ExampleServlet.java` file. This file contains a few interesting lines:

- `@WebServlet("/my-example-url")` is an [annotation](https://en.wikipedia.org/wiki/Java_annotation) that tells our server which URL this servlet maps to. When a client requests the `/my-example-url` URL, this servlet is triggered.
- The `doGet()` function runs whenever a client sends a `GET` request to the servlet's URL. (Your browser sends a `GET` request whenever you visit a URL.)
- `response.setContentType("text/html;");` specifies what type of content the client should expect.
- `response.getOutputStream().println("<h1>Hello world!</h1>");` prints an `<h1>` tag as the response.

To see this in action, run a development server:

```bash
mvn appengine:devserver
```

Run this command and then click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to open a tab that displays the `index.html` file. Then navigate to `/my-example-url` to see the content that's coming from the `ExampleServlet.java` file.

Change the content returned by the servlet and restart your development server to see your changes.

### URLs

This servlet maps to the `/my-example-url` URL. You can change the annotation so it maps to a different URL, like `/content` or `/mypage.html`.

## Dynamic Content

So far, the servlet returns some static HTML content. This works, but the real power of server-side code is the ability to return **dynamic** content.

The code in your servlet's `doGet()` function runs every time a client requests the `/my-example-url` URL. That means you can write Java code that generates different content for each request! You can use `if` statements, `for` loops, objects, functions, etc. Any code that works in Java will work in a servlet. Servlets are "just" Java!

To test this out, add this line to the end of the `doGet()` function:

```java
response.getWriter().println("<p>The current date is " + new Date() + "</p>");
```

This line of code adds the current date to the response. The date is calculated on the server, whenever a user sends a request. That means the content will be different every time you refresh the page.

You'll also need an import statement:

```java
import java.util.Date;
```

Restart your dev server and refresh the page to see the content change.

## Why Servlets?

Most large projects use a framework like Spring, Grails, or Flask. So why are we using servlets?

First, learning the fundamentals is important for understanding the higher-level concepts used by a framework. It's hard to learn a framework before understanding how requests work.

Second, using a framework involves a lot of setup and configuration. Code is hard enough to debug, even without fighting with framework config files!

Third, most of the Google Cloud tutorials use servlets. So anything you find in a Google Cloud tutorial should "just work" with the code you write here.

All of that said, if using a framework is interesting to you, consider exploring that during the open project!

## Live Server

TODO

## Next Steps

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

Congratulations, you now have the power to write Java code that runs on a server to create dynamic web content.

You'll build on this knowledge to create a complete web application this week. Next, learn about the `fetch()` function by running the walkthrough in the `intro-2-fetch` directory!