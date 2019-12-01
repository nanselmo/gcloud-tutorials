# Intro to Post Requests

**Prerequisite:** Read the `fetch()` intro walkthrough first!

## Getting Started

This walkthrough introduces `POST` requests, which let you send data to your server.

You can return to this walkthrough anytime by running this command:

```bash
teachme post-walkthrough.md
```

Click the **Start** button to begin!

## Requests

At this point, you've seen two ways to send requests: by typing a URL into your browser, or by using the `fetch()` function.

The requests you've seen so far are called `GET` requests, because they're requesting to **get** some data from the server.

There's another kind of request called a `POST` request, which lets you **send** data to the server.

## HTML Forms

One common way to send `POST` requests is by using the HTML `<form>` tag.

A `<form>` element has attributes that tell the page where to send the data, and contains input elements that let the user specify the data to send.

To see an example, open the `index.html` file. This file contains a `<form>` element and a few example input elements. The user can enter data into these inputs, and when they click the `Submit` button, the form sends a `POST` request to the `/my-data-url` URL.

### Learn More

For more information, check out [MDN](https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms) or [W3Schools](https://www.w3schools.com/html/html_forms.asp), or try googling "HTML form tutorial" for more resources.

## The `doPost()` Function

When the user clicks the `Submit` button, the form sends a `POST` request to the `/my-data-url` URL. The server looks for a servlet that maps to that URL, and then runs its `doPost()` function. Open the `DataServlet.java` file to see that code.

To get the values from a submitted form, you can use the `request.getParameter()` function. The request contains parameters with names that match the names of the input elements in the HTML form. For example, the HTML form contains an `input` with a name of `name-input`, so on the server, you can call `request.getParameter("name-input")` to get the value entered by the user into that input.

Run a development server:

```bash
mvn appengine:devserver
```

Try submitting different values in the form and seeing how they're handled on the server.

## Redirects

The example code takes the input from the `POST` request and outputs it directly in the page as the response to that request.

Most of the time, you'll probably do something else after receiving a `POST` request. Normally you'll process or store the data, and then **redirect** the user to another page.

A redirect tells the client/browser to go to a different URL. Add this line of code to the end of the `doPost()` function:

```java
response.sendRedirect("/index.html");
```

This line of code redirects the client back to the `index.html` page after they submit the form.

Restart your dev server and try submitting the form. You should now go back to the form after you submit it.

This isn't very useful yet, but we'll tie it all together in the next step.

## Mixing GET and POST

Now you have a servlet that contains a `doPost()` function that receives parameters from the request, but redirects the user instead of doing anything with those values.

You can use the concepts you learned in the `fetch()` introduction to store the submitted input and use it to populate the HTML page.

Start by modifying the `DataServlet` class:

```java
@WebServlet("/my-data-url")
public class DataServlet extends HttpServlet {

  private String name;
  private String color;
  private String description;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Return the previously entered data as JSON.
    response.setContentType("application/json;");
    response.getWriter().println("{");
    response.getWriter().println("\"name\": \"" + name + "\",");
    response.getWriter().println("\"color\": \"" + color + "\",");
    response.getWriter().println("\"description\": \"" + description + "\"");
    response.getWriter().println("}");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Store the values so we can reference them later.
    name = request.getParameter("name-input");
    color = request.getParameter("color-input");
    description = request.getParameter("description-input");

    // Redirect the user back to the index.html page.
    response.sendRedirect("/index.html");
  }
}
```

This servlet contains a `doPost()` function that takes input from the user, and a `doGet()` function that returns the input as JSON.

Next, write some JavaScript code that fetches the data from the server:

```javaScript
fetch('my-data-url')
.then(response => response.json())
.then(previousSubmission => {
  const name = previousSubmission.name;
  const color = previousSubmission.color;
  const description = previousSubmission.description;

  const resultsContainer = document.getElementById('results');
  resultsContainer.innerHTML += 'Name: ' + name + '<br/>';
  resultsContainer.innerHTML += 'Color: ' + color + '<br/>';
  resultsContainer.innerHTML += 'Description: ' + description + '<br/>';
});
```

Load this JavaScript from your `index.html` page.

Restart your development server and refresh the `index.html` page. Now when you submit the form, you should see it the next time you load the `index.html` page.

This isn't very interesting yet, but it demonstrates a common pattern:

- Data is posted to a server.
- The server processes or stores the data.
- The page gets the processed data from the server and builds a UI.

You'll use this pattern in this week's projects.

## Live Server

TODO

## Next Steps

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

You now have the power to write server-side code, fetch data from your server, and send data to your server.

This week, you'll use this knowledge to create a complete web application!

Decide with your team who will do which project, and then run the corresponding walkthrough. Good luck!