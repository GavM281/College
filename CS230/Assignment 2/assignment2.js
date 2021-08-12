// Browser: Microsoft edge
// Version: 89.0.774.45
// OS: Windows 10


var indicator = document.getElementById("indicator");

var green = document.getElementById("buttonGreen");
var red = document.getElementById("buttonRed");
var yellow = document.getElementById("buttonYellow");
var blue = document.getElementById("buttonBlue");

var score = document.getElementById("currentScore");
var highScoreDisplay = document.getElementById("highScore");
var highScore = 0;
var currentScore = 0;
var round = 1;
var value = 0;
var playing = new Boolean(false);


function start(colors){
    if(playing==false){ // If start button hasn't been pressed, avoids pressing start during game
        playing = true;
        indicator.style.backgroundColor = "lightgreen"; // Change color from red to green
        var colors = fillArray(); // Fill array
        setTimeout(function(){printSequence(colors,0,round,value)}, 3000); // call function after 3 seconds
    }
}

function fillArray(){ // Fill array with random numbers 0-3 representing colors
    var color =[];
    for(var i=0;i<25;i++){
        color[i] = Math.floor(Math.random()*4);
        console.log(color[i]);
    }
    return color;
}


function printSequence(colors,i,round, value){
    // Set time between flashes depending on rounds played
    var time = 0;
    if(round > 13){
        time = 400;
    }else if(round > 9){
        time = 500;
    }else if(round > 5){
        time = 600;
    }else{
        time = 700;
    }

    // Flash sequence
    if(i<round){
        setTimeout(function(){
            if(colors[i] == 0){
                green.click(); // Causes button to flash
                value += 20; // Sets expected value, find if user presses right buttons
                console.log("green");
            }else if(colors[i] == 1){
                red.click(); // Causes button to flash
                value += 21; // Sets expected value, find if user presses right buttons
                console.log("red");
            }else if(colors[i] == 2){
                yellow.click(); // Causes button to flash
                value += 22; // Sets expected value, find if user presses right buttons
                console.log("yellow");
            }else if(colors[i] == 3){
                blue.click(); // Causes button to flash
                value += 23; // Sets expected value, find if user presses right buttons
                console.log("blue");
            }else{
                console.log(i);
            }

            i++; // Increase index to print next
            printSequence(colors,i,round, value); // Recursive
        }, time);
    }else{
        console.log(" ");
        userTurn(colors,i,round,value); // Finished sequence, Get user inputs
    }
}


function userTurn(colors, i, round, expectedValue){
    var trackPresses = 0;

    // Used to check if buttons already have eventListeners
    var gBool = new Boolean(false);
    var rBool = new Boolean(false);
    var yBool = new Boolean(false);
    var bBool = new Boolean(false);

    if(gBool==false){ // Doesn't already have an event Listener
        green.addEventListener("click", function(){trackPresses+=20});
        gBool = true;
    }

    if(rBool == false){  // Doesn't already have an event Listener
        red.addEventListener("click", function(){trackPresses+=21});
        rBool = true;
    }

    if(yBool == false){  // Doesn't already have an event Listener
        yellow.addEventListener("click", function(){trackPresses+=22});
        yBool = true;
    }

    if(bBool == false){  // Doesn't already have an event Listener
        blue.addEventListener("click", function(){trackPresses+= 23});
        bBool = true;
    }

    setTimeout(function(){
        console.log("TRACK IS: " + trackPresses);
        console.log("EXPECTED IS: " + expectedValue);
        console.log("ROUND IS: " + round);

        if(trackPresses == expectedValue){ // If trackPresses is equal to expected
            console.log("RETURNING TO SEQUENCE \n");
            score.innerText = round; // Set score display to current round value
            i = 0;
            round++;
            value = 0;
            printSequence(colors,i,round,value); // Print sequence
        }else{
            endGame(round); // End game
        }
    },5000); //5 seconds to input sequence
}

function endGame(round){
    var x = 0;
    flashButtons(x);
    console.log("\n GAME OVER \n");
    playing = false; // Not playing
    score.innerText = 0; // reset current score
    round--;
    if(round>highScore){ // If new high score
        highScore = round; // Set highscore
        highScoreDisplay.innerText = round; // Change high score display
    }
    indicator.style.backgroundColor = "red"; // Change indicator color
}

function flashButtons(x){ // Flash all buttons five times when game ends
    if(x<5){
        setTimeout(function(){
            flash(green);
            flash(red);
            flash(yellow);
            flash(blue);
            x++;
            flashButtons(x);
        },500);
    }
}



// From JK notes, flash button
function flash(e) {
    var myFlashableElement = e;
    myFlashableElement.classList.remove("flashElement");
    void myFlashableElement.offsetWidth; /* trick to trigger reflow */
    myFlashableElement.classList.add("flashElement");
}


function greenClick(){
    flash(green);
}

function redClick(){
    flash(red);
}
function yellowClick(){
    flash(yellow);
}
function blueClick(){
    flash(blue);
}