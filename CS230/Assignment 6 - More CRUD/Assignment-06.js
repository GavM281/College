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
  console.log("\nDatabase (assign6): Disconnected!\n");
  process.exit();
});


// Set up MongoDB connection
const MongoClient = require("mongodb").MongoClient;
const uri =  ""; // Removed from Github upload


MongoClient.connect(uri, { useUnifiedTopology: true })
  .then((client) => {

    // three different collections to keep users,phones and orders seperate
    const db = client.db("assign6");
    const usersCollection = db.collection('User');
    const phoneCollection = db.collection('Phone');
    const orderCollection = db.collection('Orders');

    console.log("Database (assign6): Connected!\n");
    
  
    // If no API call made then the default route is / so
    // just return the default Assignment-06.html file to the user.
    app.get("/", function (req, res) {
     res.sendFile(__dirname + "/Assignment-06.html");
    });


//====================================================================================================================

    // CREATE
    // Create User
    app.post("/api/createUser", function (req, res) { // works
      var userData = req.body;
      console.log("USER DATA RECEIVED: \n\n" + JSON.stringify(userData, null, 2) + "\n");
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
      res.send("User (" + userData.firstname + " " + userData.surname + ") data added to the Database!");
    });

    // Create Phone
    app.post("/api/createPhone", function (req, res) { // works
      var phoneData = req.body;
      console.log("USER DATA RECEIVED: \n\n" + JSON.stringify(phoneData, null, 2) + "\n");

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
      res.send("Phone (" + phoneData.manu +" " + phoneData.model +") data added to the Database!");
    });


    // Create Order
    app.post("/api/createOrder", function (req, res) {
      var orderData = req.body;
      console.log("USER DATA RECEIVED: \n\n" + JSON.stringify(orderData, null, 2) + "\n");
      // Insert data into orderCollection
      orderCollection
        .insertOne(orderData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(`Order entered\n`);
      // respond to the user with confirmation message
      res.send("Order (" + orderData.user + " " + orderData.model + ") data added to the Database!");
    });


//====================================================================================================================


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


    // GET orders
    app.get("/api/orders", function (req, res) {
      // make the database query using the connection created earlier
      orderCollection
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


//====================================================================================================================

    // UPDATES
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
        var ObjectID = require('mongodb').ObjectID;
        var phoneData = req.body;
        var myquery = { '_id':ObjectID(phoneData.phoneId)};
        var newvalues = { $set: {manu: phoneData.updateManu, model: phoneData.updateModel, price: phoneData.updatePrice} };
        phoneCollection
          .updateOne(myquery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("new manufacturer: " + phoneData.updateManu +
                      " new model: " + phoneData.updateModel + " new price: " + phoneData.updatePrice);
          });
    });

    // Update Orders
    app.put("/api/updateOrders", function(req, res) {
        var orderData = req.body;
        var myquery = { user: orderData.user, model: orderData.phone};
        var newvalues = { $set: {user: orderData.newUser, model: orderData.newModel} };
        orderCollection.updateOne(myquery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("new user: "+orderData.newUser + " new model: " + orderData.newModel);
          });
    });


//=====================================================================================================================

    // DELETES

    // Delete User
    app.delete("/api/deleteUsers", function(req, res) {
        console.log("Going to delete user");
        var userData = req.body;
        var myQuery = {firstname: userData.fName, surname: userData.lName,email: userData.delEmail, mobile: userData.phone};
        usersCollection.deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
          console.log("user " + userData.fName + " " + userData.lName + "   "+ userData.delEmail + "   " + userData.phone +" deleted");
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


    // Delete Order
    app.delete("/api/deleteOrder", function(req, res) {
        var orderData = req.body;
        var myQuery = {user: orderData.user, model: orderData.model};
        orderCollection
          .deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
          console.log("User  " +orderData.user + " and model " + orderData.model + " deleted");
        });
    });



    // Set up the HTTP server and listen on port 8000
    app.listen(port, function () {
      console.log("AJAX (HTTP) API server running on port: " + port + "\n");
    });
  })
  .catch(console.error);
