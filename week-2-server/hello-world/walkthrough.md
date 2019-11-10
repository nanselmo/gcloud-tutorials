# Server Programming

## Getting Started

Last week, you wrote HTML and JavaScript, and you deployed a dev server and a live server that hosted your files so web browsers could access them.

This week, you'll write code that runs on a server.

## Client and Server

You'll hear these words a lot, so let's start by defining them.

A [client](https://en.wikipedia.org/wiki/Client_(computing)) is whatever you're using to interact with the internet. It's the web browser you're using to read this page. The web browser on your computer is one client, the web browser on your phone is another client. There are other types of clients (like watching Netflix or listening to Spotify), but we'll focus on web browsers for now.

One important property of a client is that they run locally on your computer (or phone, or game console, or whatever device you're using). When we talk about "client-side", or something that happens "in the client", we mean it happens on your device.

A [server](https://en.wikipedia.org/wiki/Server_(computing)) is the computer that the client requests data from. This project uses Google Cloud, so the computer is in a Google [data center](https://www.google.com/about/datacenters/). That computer can return a static file like you created last week, but it can also execute code to decide what content to send back to the client.

## Servlets

A servlet is a Java class with functions that run when a client requests a particular URL. You'll see two functions most often:

- `doGet()` runs when a client requests data from a URL.
- `doPost()` runs when a client sends data to a URL, for example when the user submits a form.

These functions run automatically, similar to how the `main()` function runs when you execute a Java program.

To see an example, open up <walkthrough-editor-open-file filePath="week-2-server/hello-world/src/main/io/happycoding/servlets/HelloWorldServlet.java">HelloWorldServlet.java</walkthrough-editor-open-file>. This file contains a few interesting lines:

- `@WebServlet("/hello")` is an [annotation](https://en.wikipedia.org/wiki/Java_annotation) that tells our server which URL this servlet maps to. When a client requests the `/hello` URL, this servlet is triggered.
- The `doGet()` function runs whenever a client sends a `GET` request to the servlet's URL. (Your browser sends a `GET` request whenever you visit a URL.)
- The `response.setContentType("text/html;");` line specifies what type of content the client should expect.
- The `response.getOutputStream().println("<h1>Hello world!</h1>");` prints an `<h1>` tag as the response.

To see this in action, let's run a development server.

```bash
mvn appengine:devserver
```


Click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon and then select **Preview on port 8080** to open a tab that displays the `index.html` file. Then navigate to `/hello` to see the content that's coming from the `HelloWorldSevlet.java` file.

### Dynamic content
Date





## Why Servlets?


## More Info

https://www.w3schools.com/tags/ref_httpmethods.asp
https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/GET