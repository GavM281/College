
// Based on Johns code

// Tested using firefox version 87.0 on Windows 10


// Load the NodeJS modules required (ExpressJS)
var express = require("express"); // using ExpressJS package
var bodyParser = require("body-parser"); // using body-parser for parsing!

var app = express(); // create the ExpressJS server app

// parse JSON and URL Encoded bodies
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = 8000; // port the server app with listen on

// watch for Ctrl-C and then close database connection!
process.on("SIGINT", function () {
  console.log("\nDatabase (assign5): Disconnected!\n");
  process.exit();
});

//
// Setup up the MongoDB connection - note that this sets up a variable
// client which is used to make connections, etc. The connection code
// was generated and copied from the MongoDB Atlas Cluster ("Connect"
// botton). You need to have already set this up and have created a
// user and database callec "test". My user is called Admin user.
// I have created a collection called "AjaxAPIDemo" that will hold the data.
//

const MongoClient = require("mongodb").MongoClient;
const uri =
  "mongodb+srv://admin:adminpw@cluster0.tt6zh.mongodb.net/assign5?retryWrites=true&w=majority";

//
// This section manages a collection-based (mogodb) database connection
// This Demo services the routes using ExpressJS. Notice that with MongoDB
// we organise the app by setting up the connection and issue the ExpressJS
// commands "inside" the callback function. When we worked with MySQL the
// database setup code was outside and before ExpressJS services.
//

MongoClient.connect(uri, { useUnifiedTopology: true })
  .then((client) => {

    // two different collections to keep users and phones seperate
    const db = client.db("assign5");
    const usersCollection = db.collection('User');
    const phoneCollection = db.collection('Phone');

    console.log("Database (assign5): Connected!\n");
    //
    // If no API call made then the default route is / so
    // just return the default index.html file to the user.
    // This contains the forms, etc. for making the CRUD
    // requests (only Create and Retrieve implemented)
    //
    app.get("/", function (req, res) {
      res.sendFile(__dirname + "/index.html");
    });


    // CREATE

    // Create User
    app.post("/api/createUser", function (req, res) {
      var userData = req.body;
      console.log(
        "USER DATA RECEIVED: \n\n" + JSON.stringify(userData, null, 2) + "\n"
      );
      // Insert data into usersCollection
      usersCollection
        .insertOne(userData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(
        `USER RECORD INSERTED: ['${userData.firstname}','${userData.surname}','${userData.email}']\n`
      );
      // respond to the user with confirmation message
      res.send(
        "User (" +
          userData.firstname +
          " " +
          userData.surname +
          ") data added to the Database!"
      );
    });

    // Create Phone
    app.post("/api/createPhone", function (req, res) {
      var phoneData = req.body;
      console.log(
        "USER DATA RECEIVED: \n\n" + JSON.stringify(phoneData, null, 2) + "\n"
      );
      // Insert data into phoneCollection
      phoneCollection
        .insertOne(phoneData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(
        `USER RECORD INSERTED: ['${phoneData.manu}','${phoneData.model}','${phoneData.phone}']\n`
      );
      // respond to the user with confirmation message
      res.send(
        "Phone (" +
          phoneData.manu +
          " " +
          phoneData.model +
          ") data added to the Database!"
      );
    });


    // RETRIEVE

    // Get users
    app.get("/api/users", function (req, res) {
      // make the database query using the connection created earlier
      usersCollection
        .find()
        .toArray()
        .then((results) => {
          console.log(
            "USER DATABASE REQUESTED: \n\n" +
              JSON.stringify(results, null, 2) +
              "\n"
          );
          res.json(results); // return unprocessed result from MongoDB "find" Query
        })
        .catch((error) => console.error(error));
    });


    // GET phone models
    app.get("/api/phones", function (req, res) {
      // make the database query using the connection created earlier
      phoneCollection
        .find()
        .toArray()
        .then((results) => {
          console.log(
            "USER DATABASE REQUESTED: \n\n" +
              JSON.stringify(results, null, 2) +
              "\n"
          );
          res.json(results); // return unprocessed result from MongoDB "find" Query
        })
        .catch((error) => console.error(error));
    });

    //UPDATES

    // Update user
    app.put("/api/updateUsers", function(req, res) {
        var userData = req.body;
        var myquery = { mobile: userData.currentPhone};
        var newvalues = { $set: {mobile: userData.updatePhone, email: userData.updateEmail, title: userData.updateTitle} };
        usersCollection
          .updateOne(myquery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("new phone number: " + userData.updatePhone +
            " new email: " + userData.updateEmail + " new title: " + userData.updateTitle);
        });
    });

    // Update Phones
    app.put("/api/updatePhones", function(req, res) {
        console.log("Going to update");
        var phoneData = req.body;
        var myquery = { manu: phoneData.currentManu, model: phoneData.currentModel};
        var newvalues = { $set: {manu: phoneData.updateManu, model: phoneData.updateModel, price: phoneData.updatePrice} };
        phoneCollection
          .updateOne(myquery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("new manufacturer: " + phoneData.updateManu +
                      " new model: " + phoneData.updateModel + " new price: " + phoneData.updatePrice);
          });
    });

    // DELETES

    // Delete User
    app.delete("/api/deleteUsers", function(req, res) {
        console.log("Going to delete user");
        var userData = req.body;
        var myQuery = {firstname: userData.fName, surname: userData.lName,email: userData.delEmail, mobile: userData.phone};
        usersCollection
          .deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
          console.log("user " + userData.fName + " " + userData.lName +" deleted");
        });
    });

    // Delete Phone
    app.delete("/api/deletePhone", function(req, res) {
        var phoneData = req.body;
        var myQuery = {manu: phoneData.delManu, model: phoneData.delModel};
        phoneCollection
          .deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
          console.log("Manufacturer  " +phoneData.delManu + " and model " + phoneData.delModel + " deleted");
        });
    });


    // Set up the HTTP server and listen on port 8000
    app.listen(port, function () {
      console.log("AJAX (HTTP) API server running on port: " + port + "\n");
    });
  })
  .catch(console.error);
