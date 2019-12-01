# Intro to Fetch

**Prerequisite:** Read the servlets intro walkthrough first!

## Getting Started

This walkthrough introduces the `fetch()` function, which lets you write JavaScript code that sends requests to a server.

You can return to this walkthrough anytime by running this command:

```bash
teachme fetch-walkthrough.md
```

Click the **Start** button to begin!

## Requests

You've now seen `.html` files that contain HTML, and you've seen servlets that generate HTML. So far, you've **requested** that HTML by pointing your web browser at a URL. The server responds to that request by looking at the URL, finding the file or servlet it maps to, and returning the corresponding content.

Pointing your web browser at a URL is one way to request content from a server. This walkthrough introduces another way to request content: the `fetch()` function!

The `fetch()` function lets you write JavaScript code that requests content from a particular URL. This is useful for separating your static and dynamic content, because it means you can put static content in an HTML file, and you can use the `fetch()` function to request dynamic content from the server.

Let's look at an example of this in action.

## Server Content

Open the `DataServlet` class and read through its code. The `doGet()` function increments a `requestCount` variable, and then outputs the value of that variable as the response to the request.

To see the output of this servlet, run a development server:

```bash
mvn appengine:devserver
```

Run this command and then click the <walkthrough-web-preview-icon></walkthrough-web-preview-icon> icon. Then select **Preview on port 8080** to open a tab that displays the `index.html` file. Navigate to `/data` to see the content that's coming from the `DataServlet.java` file.

You should see a number that increments whenever you refresh the page.

## Fetch

A page that shows a number isn't very useful by itself. The page needs more HTML to display content to the user.

You could output HTML directly from the servlet, but that's hard to maintain. Imagine writing a whole HTML page using Java print statements!

Instead, you can write client-side JavaScript code that **fetches** the content from the server and adds it to an existing HTML file.

Create a `script.js` file and put this JavaScript code inside it:

```javascript
fetch('/data')
.then(response => response.text())
.then((requestCount) => {
  document.getElementById('count-container').innerText = 'Request count: ' + requestCount;
});
```

Read through the code line-by-line:

- `fetch('/data')`: Just like you pointed your browser to `/data` to request data from the server, this line tells JavaScript to send a request to the `/data` URL.
- `.then(response => response.text())`: This line creates an [arrow function](https://www.w3schools.com/js/js_arrow_function.asp) that takes the response from the server and converts it to text.
- `.then((requestCount) => {`: This is another arrow function that takes the text of the response as a parameter.
- `document.getElementById('count-container').innerText = 'Request count: ' + requestCount;`: This line finds the element with an ID of `count-container` and sets its content so you can see it in the page.

Next, load your `script.js` file from the `<head>` section of `index.html`. (Hint: If you forget how to do that, look back at the week 1 projects!)

Run your dev server and visit `index.html`. You should now see the counter in the `index.html` page!

**Having trouble?** Make sure to check your JavaScript console for errors!

## JSON

So far, your server returns a single value, but you'll normally want to return more than one value in the response from a server. To do that, you can use any format you want: XML and key-value pairs are popular choices.

Another common format is [JavaScript Object Notation](http://www.json.org/). JSON is handy because JavaScript can parse JSON without requiring any custom code.

To try this out, modify your `doGet()` function:

```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  requestCount++;
  response.setContentType("application/json;");
  response.getWriter().println("{");
  response.getWriter().println("\"requestCount\": \"" + requestCount + "\"");
  response.getWriter().println(", ");
  response.getWriter().println("\"date\": \"" + startDate + "\"");
  response.getWriter().println("}");
}
```

This code outputs JSON in this format:

```json
{
  "requestCount": "2", 
  "date": "Sun Nov 10 16:39:32 PST 2019"
}
```

Restart your dev server and navigate to `/data` to see this in your browser.

Now change your JavaScript code to parse this JSON to add content to the page:

```javascript
fetch('/data')
.then(content => content.json())
.then((serverStats) => {
  document.getElementById('count-container').innerText = 'Request count : ' + serverStats.requestCount;
  document.getElementById('date-container').innerText = 'Date : ' + serverStats.date;
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

Next, create a new Java class to encapsulate the data you want to send from the server to the client:

```java
package io.happycoding.servlets;

import java.util.Date;

public class ServerStats {
  private Date date;
  private int requestCount;

  public ServerStats(Date date, int requestCount){
    this.date = startDate;
    this.requestCount = requestCount;
  }
}
```

Then add this import statement to your servlet:

```java
import com.google.gson.Gson;
```

Finally, change your `doGet()` function to create an instance of the `ServerStats` class and then use Gson to format the instance as JSON:

```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  requestCount++;
  response.setContentType("application/json;");
  ServerStats serverStats = new ServerStats(new Date(), requestCount);
  String json = new Gson().toJson(serverStats);
  response.getWriter().println(json);
}
```

Restart your development server to make sure everything works how you expect.

## Live Server

TODO

## Next Steps

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

You now have the power to write JavaScript code that fetches data from your server.

You'll build on this knowledge to create a complete web application this week. Next, learn about `POST` requests by running the walkthrough in the `intro-3-post` directory!