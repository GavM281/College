// Based on Johns code

// Tested using firefox version 88.0.1 on Windows 10


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
  console.log("\nDatabase (exam): Disconnected!\n");
  process.exit();
});


// Set up MongoDB connection
const MongoClient = require("mongodb").MongoClient;
const uri =
  "mongodb+srv://admin:adminpw@cluster0.tt6zh.mongodb.net/exam?retryWrites=true&w=majority";


MongoClient.connect(uri, { useUnifiedTopology: true })
  .then((client) => {

    // three different collections to keep Clients,Therapists and Sessions seperate
    const db = client.db("exam");
    const clientCollection = db.collection('Clients');
    const therapCollection = db.collection('Therapist');
    const sessionCollection = db.collection('Sessions');

    console.log("Database (exam): Connected!\n");
    //
    // If no API call made then the default route is / so
    // just return the default index.html file to the user.
    // This contains the forms, etc. for making the CRUD requests
    //
    app.get("/", function (req, res) {
      res.sendFile(__dirname + "/index.html");
    });


//====================================================================================================================

    // CREATE
    // Create Client
    app.post("/api/createClient", function (req, res) { // works
      var clientData = req.body;
      console.log("Client DATA RECEIVED: \n\n" + JSON.stringify(clientData, null, 2) + "\n");
      // Insert data into clientCollection
      clientCollection
        .insertOne(clientData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(
        `Client RECORD INSERTED: ['${clientData.firstname}','${clientData.surname}','${clientData.email}']\n`
      );
      // respond to the user with confirmation message
      res.send("Client (" + clientData.firstname + " " + clientData.surname + ") data added to the Database!");
    });

    // Create Therapist
    app.post("/api/createTherapist", function (req, res) { // works
      var therapData = req.body;
      console.log("Therapist DATA RECEIVED: \n\n" + JSON.stringify(therapData, null, 2) + "\n");

      // Insert data into therapCollection
      therapCollection
        .insertOne(therapData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(
        `Therapist RECORD INSERTED: ['${therapData.firstname}','${therapData.surname}','${therapData.email}']\n`
      );
      // respond to the user with confirmation message
      res.send("Therapist (" + therapData.firstname +" " + therapData.surname +") added to the Database!");
    });


    // Create Session
    app.post("/api/createSession", function (req, res) {
      var sessionData = req.body;
      console.log("Session DATA RECEIVED: \n\n" + JSON.stringify(sessionData, null, 2) + "\n");
      // Insert data into sessionCollection
      sessionCollection
        .insertOne(sessionData)
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.error(error));
      console.log(`Session entered\n`);
      // respond to the user with confirmation message
      res.send("Session with therapist (" + sessionData.therapist +  ") data added to the Database!");
    });


//====================================================================================================================


    // RETRIEVE
    // Get clients
    app.get("/api/clients", function (req, res) {
      // make the database query using the connection created earlier
      clientCollection
        .find()
        .toArray()
        .then((results) => {
          console.log(
            "Clients DATABASE REQUESTED: \n\n" +
              JSON.stringify(results, null, 2) +
              "\n"
          );
          res.json(results); // return unprocessed result from MongoDB "find" Query
        })
        .catch((error) => console.error(error));
    });


    // GET therapists
    app.get("/api/therapists", function (req, res) {
      // make the database query using the connection created earlier
      therapCollection
        .find()
        .toArray()
        .then((results) => {
          console.log(
            "Therapist DATABASE REQUESTED: \n\n" +
              JSON.stringify(results, null, 2) +
              "\n"
          );
          res.json(results); // return unprocessed result from MongoDB "find" Query
        })
        .catch((error) => console.error(error));
    });


    // GET sessions
    app.get("/api/sessions", function (req, res) {
      // make the database query using the connection created earlier
      sessionCollection
        .find()
        .toArray()
        .then((results) => {
          console.log(
            "Sessions DATABASE REQUESTED: \n\n" +
              JSON.stringify(results, null, 2) +
              "\n"
          );
          res.json(results); // return unprocessed result from MongoDB "find" Query
        })
        .catch((error) => console.error(error));
    });


//====================================================================================================================

    // UPDATES
    // Update Client
    app.put("/api/updateClients", function(req, res) {
        var clientData = req.body;
        var ObjectID = require('mongodb').ObjectID;

//        var myId = JSON.parse(req.body.id);
          var myQuery = { '_id':ObjectID(clientData.clientId)}; // enter id
//        var myQuery = {'_id': clientData.clientId}; // enter id
//        var myQuery = { _id:clientData.clientId}; // enter id
//        var myQuery = { mobile: clientData.currentMobile};

        var newValues = {$set: {
          title: clientData.title, firstname: clientData.firstname, surname: clientData.surname, email: clientData.email,
          mobile: clientData.mobile, phone: clientData.phone, address1: clientData.address1, address2: clientData.address2,
          town: clientData.town, county:clientData.county, eircode: clientData.eircode, dob: clientData.dob, parent:clientData.parent,
          permission: clientData.permission, doctor: clientData.doctor, referred: clientData.referred
        } };
        clientCollection
          .updateOne(myQuery, newValues, function(err, res) {
          if (err) throw err;
          console.log("Client " + clientData.firstname +" " + clientData.surname + " was updated.  Id was " +clientData.clientId);
        });
    });

    // Update Therapist
    app.put("/api/updateTherapist", function(req, res) {
        var therapData = req.body;
        var ObjectID = require('mongodb').ObjectID;

      var myQuery = { '_id':ObjectID(therapData.therapistId)}; // enter id

        var newvalues = {$set: {
          title: therapData.title, firstname: therapData.firstname, surname: therapData.surname, email: therapData.email,
          mobile: therapData.mobile, phone: therapData.phone, address1: therapData.address1, address2: therapData.address2,
          town: therapData.town, county:therapData.county, eircode: therapData.eircode
        } };

        therapCollection
          .updateOne(myQuery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("Therapist: " + therapData.firstname + " " + therapData.surname + "  was updated");
          });
    });

    // Update Sessions
    app.put("/api/updateSessions", function(req, res) {
        var sessionData = req.body;
        var ObjectID = require('mongodb').ObjectID;

//        var myQuery = { client: sessionData.client};
        var myQuery = { '_id':ObjectID(sessionData.sessionId)}; // enter id

        var newvalues = { $set:
        {date: sessionData.date, time: sessionData.time, client: sessionData.client,
        therapist: sessionData.therapist, fee: sessionData.fee, sesNo: sessionData.sesNo,
        sesDur: sessionData.sesDur, type: sessionData.type, notes: sessionData.notes}
        };
        sessionCollection.updateOne(myQuery, newvalues, function(err, res) {
          if (err) throw err;
          console.log("Session: "+sessionData.client + " with " + sessionData.therapist);
          });
    });


//=====================================================================================================================

    // DELETES

    // Delete Client
    app.delete("/api/deleteClients", function(req, res) {
        var clientData = req.body;
        var ObjectID = require('mongodb').ObjectID;

        var myQuery = { '_id':ObjectID(clientData.clientId)}; // enter id

        clientCollection.deleteOne(myQuery, function(err, obj) {
          if (err) throw err;

        });
    });

    // Delete Therapist
    app.delete("/api/deleteTherapist", function(req, res) {
        var therapData = req.body;
        var ObjectID = require('mongodb').ObjectID;


        var myQuery = { '_id':ObjectID(therapData.therapistId)}; // enter id

        therapCollection
          .deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
        });
    });


    // Delete Session
    app.delete("/api/deleteSession", function(req, res) {
        var sessionData = req.body;
        var ObjectID = require('mongodb').ObjectID;

        var myQuery = { '_id':ObjectID(sessionData.sessionId)}; // enter id

        sessionCollection
          .deleteOne(myQuery, function(err, obj) {
          if (err) throw err;
          console.log("Session with id  " +sessionData.sessionId + " has been deleted ");
        });
    });



    // Set up the HTTP server and listen on port 8000
    app.listen(port, function () {
      console.log("AJAX (HTTP) API server running on port: " + port + "\n");
    });
  })
  .catch(console.error);

