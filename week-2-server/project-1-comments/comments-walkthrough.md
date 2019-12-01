# Server Programming - Comments

**Prerequisites:** Read through the intro walkthroughs first!

## Getting Started

Last week, you wrote HTML and JavaScript, and you deployed a dev server and a live server that hosted your files so web browsers could access them.

So far this week, you've gone through the intro walkthroughs to learn about servlets, the `fetch()` function, and `POST` requests. (If you haven't done that yet, go do it now and then come back!)

Now, you'll combine everything you've learned so far to create a web app that allows users to comment on an HTML page.

You can return to this walkthrough anytime by running this command:

```bash
teachme comments-walkthrough.md
```

Click the **Start** button to begin!

## The Goal

The goal of this project is to create a page that allows users to leave comments. The page should contain a comment form, and it should show all of the user comments that have already been left.

Think about how you want your comments to work. What features do you find most useful?

Focus on creating a [minimum viable product](https://en.wikipedia.org/wiki/Minimum_viable_product) that proves you have all of the pieces connected, and then come back later and add extra features if you have time left over.

## Directory Structure

Before you start coding, take some time to understand the files in the project.

- `pom.xml` is Maven's configuration file.
- `appengine-web.xml` is App Engine's configuration file.
- `index.html` contains the skeleton for an HTML file.
- `CommentsServlet.java` is a barebones servlet with a `doGet()` function.

You'll be modifying these files to create your comments feature!

## HTML Form

First, add a comment form to the `index.html` page.

What you include in the form is up to you. At a minimum you probably want a text input.

You might also include another text input that lets users specify their username, or a dropdown that lets them specify their reaction (e.g. happy, sad, or mad). You can always go back and add those extra features after you get your [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) working!

Test your changes by running a development server:

```bash
mvn appengine:devserver
```

You should see your form in the page. It's okay if it doesn't do anything yet. You'll fix that in the next step!

## Servlet doPost()

Now that you have a comment form in your HTML page, you need server-side code that handles the `POST` request.

Add a `doPost()` function to your servlet. You can use print statements in your `doPost()` function to confirm that your `doPost()` function is receiving the data correctly.

Restart your dev server and submit the form to make sure everything is working how you expected.

After you've confirmed that your form is connected to your servlet, modify your `doPost()` function so it stores the user's comment and redirects back to `index.html`.

**Hint:** You might want to create a `Comment` class and then use an `ArrayList` of `Comment` instances in your servlet to store all of the comments.

## Servlet doGet()

Now that your servlet stores the comments entered by the user, create a `doGet()` function that responds with the comments.

You can use any format you want. JSON should work fine. You can also use GSON to format the data for you.

Test your code by restarting your dev server, submitting a few comments, and then navigating to your servlet's URL in your browser. You should see the data in your browser.

## JavaScript Fetch

Finally, write some JavaScript code that fetches the comment data from your server, and then use that data to show your comments in the page. You can show your comments in any format you want. It doesn't have to be pretty! Get something working first, and then think about styling it if you have extra time left over.

Restart your development server and try to use your new comments feature. Does everything work how you expected?

## Live Server

TODO

## Pull Requests

TODO

## Next Steps

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

Congratulations! You now have a working comment feature! Make sure your [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) works and is submitted to your GitHub repo by the end of the week.

If you have some time left over and you want to learn more, here are a few ideas for what to do next:

- Add comments to the page you created during week 1.
- Improve the formatting of the comments by adding a timestamp.
- Add a text field that allows users to specify their name as well as a comment.
- Add a dropdown box that allows users to add a mood (like happy or sad) to their comments.
- Allow users to change the order that comments display: newest first, oldest first, longest first, etc.
- What happens when you have 1000 comments? Should they all show?
- Improve error handling and security. What if a user enters HTML content?

**Advanced Features:** This code uses an in-memory `ArrayList`, which means that comments will go away when you restart your server. If you want to learn about **persistent storage**, then check out the Datastore project during week 4. If you want to learn about image uploads, check out the Blobstore project!