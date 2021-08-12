var row1Number = 0;
var row2Number = 0;
var row3Number = 0;
var row4Number = 0;
var row5Number = 0;
var row6Number = 0;

var r1Display = document.getElementById("row1Display");
var r2Display = document.getElementById("row2Display");
var r3Display = document.getElementById("row3Display");
var r4Display = document.getElementById("row4Display");
var r5Display = document.getElementById("row5Display");
var r6Display = document.getElementById("row6Display");

var over4 = document.getElementById('over4');
var under4 = document.getElementById('under4');

var r1Rec = 0;
var r2Rec = 1;
var r3Rec = 3; // 2 for under 4s
var r4Rec = 4; // 3 for under 4s

var r5MinRec = 3; // 2 for under 4s
var r6MinRec = 5; //3 for under 4s

var r5MaxRec = 5; // 3 for under 4s
var r6MaxRec = 7; // 4 for under 4s

function rad(){
    addRow1();
    subRow1();
    addRow2();
    subRow2();
    addRow3();
    subRow3();
    addRow4();
    subRow4();
    addRow5();
    subRow5();
    addRow6();
    subRow6();
}

// Subtract 1 from row 1
function subRow1() {
    if(row1Number!=0){
        row1Number--;
        r1Display.innerText = row1Number;
    }
    if(row1Number == 0){
        r1Display.style.backgroundColor = "white";
    }else{
        r1Display.style.backgroundColor = "red";
    }
}
function addRow1() { // Add 1 to row 1
    row1Number++;
    r1Display.innerText = row1Number;
    if(row1Number > 0){
        r1Display.style.backgroundColor = "red";
    }
}


function subRow2() {
    if(row2Number!=0){
        row2Number--;
        r2Display.innerText = row2Number;
    }

    if(row2Number<=r2Rec){
        r2Display.style.backgroundColor = "white";
    }
}
function addRow2() {
    row2Number++;
    r2Display.innerText = row2Number;

    if(row2Number>r2Rec){
        r2Display.style.backgroundColor = "red";
    }
}


function subRow3() {
    if(row3Number!=0){
        row3Number--;
        r3Display.innerText = row3Number;
    }

    if(over4.checked){
        r3Rec = 3;
    }else{
        r3Rec = 2;
    }

    if(row3Number<=r3Rec){
        r3Display.style.backgroundColor = "white";
    }
}
function addRow3() {
    row3Number++;
    r3Display.innerText = row3Number;

    if(over4.checked){
        r3Rec = 3;
    }else{
        r3Rec = 2;
    }

    if(row3Number>r3Rec){
        r3Display.style.backgroundColor = "red";
    }
}


function subRow4() {
    if(row4Number!=0){
        row4Number--;
        r4Display.innerText = row4Number;
    }

    if(over4.checked){
        r4Rec = 4;
    }else{
        r4Rec = 3;
    }

    if(row4Number<=r4Rec){
        r4Display.style.backgroundColor = "white";
    }
}
function addRow4() {
    row4Number++;
    r4Display.innerText = row4Number;
    if(over4.checked){
        r4Rec = 4;
    }else{
        r4Rec = 3;
    }
    if(row4Number>r4Rec){
        r4Display.style.backgroundColor = "red";
    }
}


function subRow5() {
    if(row5Number!=0){
        row5Number--;
        r5Display.innerText = row5Number;
    }

    if(over4.checked){
        r5MinRec = 3;
        r5MaxRec = 5;
    }else{
        r5MinRec = 2;
        r5MaxRec = 3;
    }

    if(row5Number < r5MinRec){
        r5Display.style.backgroundColor = "white";
    } else if(row5Number > r5MaxRec){
        r5Display.style.backgroundColor = "red";
    }else{
        r5Display.style.backgroundColor = "#00A4FE";
    }
}
function addRow5() {
    row5Number++;
    r5Display.innerText = row5Number;

    if(over4.checked){
        r5MinRec = 3;
        r5MaxRec = 5;
    }else{
        r5MinRec = 2;
        r5MaxRec = 3;
    }

    if(row5Number < r5MinRec){ // Less than recommended
        r5Display.style.backgroundColor = "white";
    } else if(row5Number > r5MaxRec){ // More than recommended
        r5Display.style.backgroundColor = "red";
    }else{ // recommended amount
        r5Display.style.backgroundColor = "#00A4FE";
    }
}


function subRow6() {
    if(row6Number!=0){
        row6Number--;
        r6Display.innerText = row6Number;
    }

    if(over4.checked){
        r6MinRec = 5;
        r6MaxRec = 7;
    }else{
        r6MinRec = 3;
        r6MaxRec = 4;
    }

    if(row6Number < r6MinRec){ // Less than recommended
        r6Display.style.backgroundColor = "white";
    } else if(row6Number > r6MaxRec){ // More than recommended
        r6Display.style.backgroundColor = "red";
    }else{ // recommended amount
        r6Display.style.backgroundColor = "#00A4FE";
    }
}
function addRow6() {
    row6Number++;
    r6Display.innerText = row6Number;

    if(over4.checked){
        r6MinRec = 5;
        r6MaxRec = 7;
    }else{
        r6MinRec = 3;
        r6MaxRec = 4;
    }

    if(row6Number < r6MinRec){ // Less than recommended
        r6Display.style.backgroundColor = "white";
    } else if(row6Number > r6MaxRec){ // More than recommended
        r6Display.style.backgroundColor = "red";
    }else{ // recommended amount
        r6Display.style.backgroundColor = "#00A4FE";
    }
}