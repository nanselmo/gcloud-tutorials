# Google Maps

## Getting Started

Over the past 3 weeks, you've learned about client-side HTML and JavaScript, server-side Java, test-driven development, and data structures and algorithms.

This week, you're going to learn about libraries that provide access to various features of Google Cloud.

This walkthrough introduces the Google Maps library, which lets you add an interactive Google Map to your page.

You can return to this walkthrough anytime by running this command:

```bash
teachme maps-walkthrough.md
```

Click the **Start** button to begin!

## The Goal

The goal of this project is to create a page that shows a Google Map. What you do with that map is up to you! You could show a map of your favorite restaurants, or of bigfoot sightings, or of local homeless shelters.

This walkthrough introduces a lot of concepts, but you don't have to use all of them. Decide what makes sense for your goal.

Focus on creating a [minimum viable product](https://en.wikipedia.org/wiki/Minimum_viable_product) that proves you have all of the pieces connected, and then come back later and add extra features if you have time left over.

## Directory Structure

Before you start coding, take some time to understand the files in the project.

- `pom.xml` is Maven's configuration file.
- `appengine-web.xml` is App Engine's configuration file.
- `index.html` contains the skeleton for an HTML file.
- `script.js` contains a single function that's called when the `index.html` page loads.

You'll be modifying these files to create your map!

## API Keys

The Google Maps library requires an API key, which is a special string that tells the library which project is making the request. So before you can start writing code, you need to obtain an API key.

Follow [these steps](https://developers.google.com/maps/documentation/javascript/get-api-key) to get an API key.

When you have your API key, modify the `index.html` file to pass the key into the URL that loads the Google Maps library.

## Hello World

Read through [this page](https://developers.google.com/maps/documentation/javascript/tutorial) to learn how to add a Google Map to your page. [Here](https://developers-dot-devsite-v2-prod.appspot.com/maps/documentation/javascript/examples/map-sync) is another example.

Modify `index.html` and `script.js` to add a Google Map to your page. Don't worry about adding features like markers or interactivity yet! Focus on getting the map to show.

When you have a map that displays on your page, click the `Next` button.

## Customizing Your Map

You can change what your map looks like by specifying its center and zoom level. You can also modify its styling, or change how it interacts with the user.

To learn about these options, read through this documentation:

- [MapOptions](https://developers.google.com/maps/documentation/javascript/reference/map#MapOptions)
- [Map Types](https://developers.google.com/maps/documentation/javascript/maptypes)
- [Styling Your Map](https://developers.google.com/maps/documentation/javascript/styling)

Customize your map so it looks and behaves the way you want!

## Markers

The Google Maps library supports adding **markers** which are pins that show specific locations. To learn about markers, read through this documentation:

- [Adding a Google Map with a Marker to Your Website](https://developers.google.com/maps/documentation/javascript/adding-a-google-map)
- [Markers](https://developers.google.com/maps/documentation/javascript/markers)
- [Custom Markers](https://developers.google.com/maps/documentation/javascript/custom-markers)

If you want to show specific locations, then consider adding markers to your map. For example, you could add markers that show your favorite places in your hometown.

## Info Windows

If you want to show more information about a location on a Google Map, you can use an **info window**. You can show an info window directly on the map, or you can show an info window when a user clicks a marker.

Read [this documentation](https://developers.google.com/maps/documentation/javascript/infowindows) to learn about info windows.

If you want to show more information on your map, then consider using info windows. For example, if your map shows markers on local dog parks, clicking a marker could show an info window that contains an image of your dog at that park.

You could also use a [marker click listener](https://developers.google.com/maps/documentation/javascript/events#MarkerEvents) to detect user interaction, and then use DOM manipulation (like you learned about in week 1) to show more information in the page next to the map. It's up to you!

## Data Visualization

In addition to markers and info windows, Google Maps supports different kinds of visualizations. Read through this documentation to learn more:

- [Visualizing Data](https://developers.google.com/maps/documentation/javascript/earthquakes)
- [Importing Data into Google Maps](https://developers.google.com/maps/documentation/javascript/importing_data)
- [Combining Data](https://developers.google.com/maps/documentation/javascript/combining-data)
- [Shapes](https://developers.google.com/maps/documentation/javascript/shapes)
- [Displaying data](https://developers.google.com/maps/documentation/javascript/layers)

You could also use [Google Dataset Search](https://toolbox.google.com/datasetsearch) to find interesting data sets to visualize. For example, you could create a visualization from [bigfoot sightings data](https://toolbox.google.com/datasetsearch/search?query=Bigfoot%20Sightings).

## Live Server

TODO

## Pull Requests

TODO

## Next Steps

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

Congratulations! You should now have a working map feature! Make sure your [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) works and is submitted to your GitHub repo by the end of the week.

So far, all of the code in this walkthrough has been client-side.

But you can use the concepts you learned in weeks 2 and 3 alongside the concepts you learned about Google Maps.

If you have some time left over and you want to explore a bit more, then here are a few example projects you could create:

- Load a CSV file on the server, and return its contents as JSON. Use that JSON to visualize the data in a map.
- Show a map of user hometowns. Let users add their hometowns by detect clicks on the map and sending a `POST` request to the server.
- Show a form that allows users to write blog entries about specific locations, and include a map in the post.