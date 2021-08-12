// Load the NodeJS modules required

var http = require("http"); // creating an API using http
var url = require("url"); // using url to extract the route (e.g. /, /api/user)
var querystring = require("querystring"); // this will contain the body of the POST request
var fs = require("fs"); // file handling to read the index.html served for / route
var port = 8000; // port the server with listen on

var server = http.createServer(); // create the server


var mysql = require("mysql");
var con = mysql.createConnection({
  
  // Removed from Github upload
  host: "",
  user: "",
  password: "",
  database: "",
  
});

// Connect
con.connect(function (err) {
  if (err) throw err;
  console.log("Database (USERS): Connected!");
});

// watch for Ctrl-C and then close database connection!
process.on("SIGINT", function () {
  con.end(function (err) {
    if (err) {
      return console.log("error:" + err.message);
    }
    console.log("\nDatabase (USERS): Disconnected!");
    process.exit();
  });
});

// listen for requests from clients
server.on("request", function (request, response) {
  var currentRoute = url.format(request.url); // get the route (/ or /api/user)
  var currentMethod = request.method; // get the HTTP request type (POST - Create; GET - Retrieve)
  var requestBody = ""; // will contain the extracted POST data later

  // determine the route (/ or /api/user)
  switch (currentRoute) {
    // If no API call made then the default route is / so
    // just return the default index.html file to the user.
    case "/":
      fs.readFile(__dirname + "/index.html", function (err, data) {
        // get the file and add to data
        var headers = {
          // set the appropriate headers
          "Content-Type": "text/html",
        };
        response.writeHead(200, headers);
        response.end(data); // return the data (index.html)
      }); // as part of the response

      break;

    //
    // Handle the requests from client made using the route /api/user
    // These come via AJAX embedded in the earlier served index.html
    // There will be a single route (/api/user) but two HTTP request methods
    // POST (for Create) and GET (for Retrieve)
    //
    case "/api/user":
      // Handle a POST request;  the user is sending user data via AJAX!
      // This is the CRUD (C)reate request. These data need to be
      // extracted from the POST request and saved to the database!


        // CREATE
      if (currentMethod === "POST") {
        // read the body of the POST request
        request.on("data", function (chunk) {
          requestBody += chunk.toString();
        });

        // determine the POST request Content-type (and log to console)
        // Either: (i)  application/x-www-form-urlencoded or (ii) application/json
        const { headers } = request;
        let ctype = headers["content-type"];
        console.log("RECEIVED Content-Type: " + ctype + "\n");

        // finished reading the body of the request
        request.on("end", function () {
          var userData = "";
          // saving the user from the body to the database
          if (ctype.match(new RegExp("^application/x-www-form-urlencoded"))) {
            userData = querystring.parse(requestBody);
          } else {
            userData = JSON.parse(requestBody);
          }
          // log the user data to console
          console.log(
            "USER DATA RECEIVED: \n\n" +
              JSON.stringify(userData, null, 2) +
              "\n"
          );
          // we have the data supplied so make the database connection and
          // the (unvalidated) data. Without validation we just hope everything
          // works out okay - for production we would need to perform validation
          var sql = `INSERT INTO USERS (title, firstname, surname, email, mobile, address1, address2, town, county, eircode,shipAddress1,shipAddress2,shipTown,shipCounty,shipEircode)
                VALUES ('${userData.title}','${userData.firstname}','${userData.surname}','${userData.email}','${userData.mobile}',
                '${userData.address1}','${userData.address2}','${userData.town}','${userData.county}','${userData.eircode}',
                '${userData.address1Ship}','${userData.address2Ship}','${userData.townShip}','${userData.countyShip}','${userData.eircodeShip}')`;
          con.query(sql, function (err, result) {
            if (err) throw err;
            console.log(
              `USER RECORD INSERTED: ['${userData.title}','${userData.firstname}','${userData.surname}','${userData.email}','${userData.mobile}',
                              '${userData.address1}','${userData.address2}','${userData.town}','${userData.county}','${userData.eircode}'
                              '${userData.address1Ship}','${userData.address2Ship}','${userData.townShip}','${userData.countyShip}','${userData.eircodeShip}']\n`
            );
            // respond to the user with confirmation message
            var headers = {
              "Content-Type": "text/plain",
            };
            // handle the responses here after the database query completes!
            response.writeHead(200, headers);
            response.end(
              "User (" +
                userData.firstname +
                " " +
                userData.surname +
                ") data added to the Database!"
            );
          });
        });
      }


      // RETRIEVE
      else if (currentMethod === "GET") {
        var headers = {
          "Content-Type": "application/json",
        };
        // make the database query using the connection created earlier
        con.query(
          "SELECT title, firstname, surname, email, mobile, address1, address2, town, county, eircode,ShipAddress1,ShipAddress2,ShipTown,ShipCounty,ShipEircode FROM USERS",
          function (err, result, fields) {
            if (err) throw err;
            //output details to the console
            console.log(
              "USER DATABASE REQUESTED: \n\n" +
                JSON.stringify(result, null, 2) +
                "\n"
            );
            // notice we include the processing in here so that is processed as part
            // of the callback - if it is outside this function then it could progress
            // before the data are returned from the database.
            response.writeHead(200, headers); // return headers for everything okay!
            response.end(JSON.stringify(result)); // return unprocessed result from SQL Query
          }
        );
      }


      // Update User
      else if (currentMethod === "PATCH"){
          console.log("UPDATING USER");
         // read the body of the POST request
         request.on("data", function (chunk) {
           requestBody += chunk.toString();
         });

         // determine the POST request Content-type (and log to console)
         // Either: (i)  application/x-www-form-urlencoded or (ii) application/json
         const { headers } = request;
         let ctype = headers["content-type"];
         console.log("RECEIVED Content-Type: " + ctype + "\n");

         // finished reading the body of the request
         request.on("end", function () {
            var userInfo = "";
            // saving the user from the body to the database
            if (ctype.match(new RegExp("^application/x-www-form-urlencoded"))) {
                userInfo = querystring.parse(requestBody);
            } else {
                userInfo = JSON.parse(requestBody);
            }
            // log the user data to console
            console.log(
            "USER INFO RECEIVED: \n\n" +
             JSON.stringify(userInfo, null, 2) +
             "\n"
            );


            // Get info
            var currentPhone = userInfo.currentPhone;
            var phone = userInfo.updatePhone;
            var email = userInfo.updateEmail;
            var title = userInfo.updateTitle;

            console.log("Current phone: " + currentPhone + "  new phone: " + phone + "  new email: "  + email + " new title :  " + title);
            var sql = "UPDATE USERS SET Email = ?, Mobile = ?, Title = ? WHERE Mobile = ?";
            con.query(sql,[email,phone,title,currentPhone], function (err, result) {
                if (err) throw err;
                console.log("Number of rows updated \n" + result.affectedRows);
            });
         });
      }


        // DELETE
       else if (currentMethod === "DELETE"){
        console.log("DELETING USER");
           // read the body of the POST request
           request.on("data", function (chunk) {
             requestBody += chunk.toString();
           });

           // determine the POST request Content-type (and log to console)
           // Either: (i)  application/x-www-form-urlencoded or (ii) application/json
           const { headers } = request;
           let ctype = headers["content-type"];
           console.log("RECEIVED Content-Type: " + ctype + "\n");

           // finished reading the body of the request
           request.on("end", function () {
                var userInfo = "";
                // saving the user from the body to the database
                if (ctype.match(new RegExp("^application/x-www-form-urlencoded"))) {
                    userInfo = querystring.parse(requestBody);
                } else {
                    userInfo = JSON.parse(requestBody);
                }
                // log the user data to console
                console.log(
                "USER info RECEIVED: \n\n" +
                 JSON.stringify(userInfo, null, 2) +
                 "\n"
                );

                // Get info
                var FName = userInfo.fName;
                var LName = userInfo.lName;
                var email = userInfo.delEmail;
                var phone = userInfo.phone;

                 console.log("First name: " + FName + "  Last name: " + LName + "  email: "  + email + " phone number:  " + phone);
                var sql = "DELETE FROM USERS WHERE ((FirstName = ?) AND (SurName = ?) AND (Email = ?) AND (Mobile = ?))";
                con.query(sql,[FName,LName,email,phone], function (err, result) {
                    if (err) throw err;
                    console.log("Number of rows deleted \n" + result.affectedRows);
                });
            });

      }
      break;
  }
});

// Set up the HTTP server and listen on port 8000
server.listen(port, function () {
  console.log("\nAJAX - API - Assignment-04");
  console.log("AJAX (HTTP) API server running on port: " + port + "\n");
});
