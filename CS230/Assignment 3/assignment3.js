// From JK notes
function getRandomStudentNumber(l) {
    return [...Array(l)].map(() => Math.floor(Math.random() * 10)).join('');
}


function initialise() { //make the start button clickable at the start
    for (var row=1;row< table.rows.length;row++) {
        table.rows[row].cells[0].innerHTML = getRandomName();// Random names
        table.rows[row].cells[1].innerHTML = getRandomStudentNumber(9) // Random student numbers
    }

    var gradeCells = document.getElementsByClassName("grade"); // Get all cells that hold a grade
    getAverageGrade(); //

    // Add event listeners to all cells with grades
    for (var i = 0; i < gradeCells.length; i++) {
        gradeCells[i].addEventListener("keyup", validateCell);
        gradeCells[i].addEventListener("keydown", removeDash);
    }
}

function removeDash(){ // If cell clicked remove dash from it
    this.classList.add('right'); // Align right
    if(this.innerHTML.includes('-')){
        this.innerHTML= this.innerHTML.replace('-',''); // Remove -
    }
}

function validateCell(){
    for (var row=1;row<table.rows.length;row++) {
        for(var col = 2; col<7;col++){
            var currentCell = table.rows[row].cells[col];

            // If grade entered is over 100 replace cell with -
            if(parseFloat(currentCell.innerHTML) > 100){
               currentCell.innerHTML = '-';
               currentCell.style.background = "yellow";
               currentCell.classList.remove('right'); // Align to center
            }

            // cell isn't empty, change background to gray or white
            if(!currentCell.innerHTML.includes('-')){
                if(row%2===0){ // Every 2nd row
                   currentCell.style.background = "#d4d4d4";
                }else{
                    currentCell.style.background = "white";
                }
            }

            // if cell is empty add a -
            if(currentCell.innerHTML == '' ||currentCell.innerHTML == ' '){
                currentCell.innerHTML = '-'; // Add -
                currentCell.style.background = "yellow"; // Change background to yellow
                currentCell.classList.remove('right'); // Remove class 'right' which aligned text right
            }
        }
    }


    if(!this.innerHTML.includes('-')){ // Cell isn't an empty cell
        if(isNaN(parseFloat(this.innerHTML))){ // Will be NaN if it's not a number
            this.style.background = "yellow"; // Change background to yellow
            this.classList.remove('right'); // Align center
            this.innerHTML = '-'; // Replace any text in cell with a -
        }
    }
    getAverageGrade();
}
function getAverageGrade(){
    var table = document.getElementById('table');
    for (var row=1;row<table.rows.length;row++) {
        var averageGrade = 0;
        for(var col = 2; col<7;col++){
            // Add up cells that aren't empty
            if(table.rows[row].cells[col].innerHTML != '-'){
                averageGrade += parseFloat(table.rows[row].cells[col].innerHTML);
            }
        }

        averageGrade = Math.round(averageGrade / 5); // Get average grade

        var displayAverageGrade = averageGrade.toString(); // Change to string
        displayAverageGrade = averageGrade+'%'; // Add on % sign at end

        table.rows[row].cells[7].innerText = displayAverageGrade; // Set average grade

        // Change colors depending on grade
        if(averageGrade<60){
            table.rows[row].cells[7].style.background = "red"; // Change background to red
            table.rows[row].cells[7].style.color = "white"; // Change font to white
        }else{ // Grade is 60 or more, change colors back to normal
            if(row%2===0){ // Even rows are gray
                table.rows[row].cells[7].style.background = "#d4d4d4";
            }else{ // Odd rows are white
                table.rows[row].cells[7].style.background = "white";
            }
            table.rows[row].cells[7].style.color = "black"; // Change font color to black
        }
    }
    getUnfinishedAssignments();
}

function getUnfinishedAssignments(){
    var unfinished = 0;
    for (var row=1;row<table.rows.length;row++) {
        for(var col = 2; col<7;col++){
            if(table.rows[row].cells[col].innerText=='-'){ // If cell is a -
                unfinished++; // Assignment is unfinished
            }
        }
    }
    document.getElementById("displayUnfin").innerText = unfinished; // Show current number of unfinished assignments
}

// Changes grading between %, letters, and 4.0
function changeGrading(){
    for (var row=1;row<table.rows.length;row++) {

        var avgCell = table.rows[row].cells[7].innerText;
        var changeCell = table.rows[row].cells[7];
//        // Changing from % to Letters
        if( table.rows[row].cells[7].innerText.includes('%')){
            table.rows[0].cells[7].innerText = "Average(ltr)"; // Change header text to show what grading method is shown

            if(parseFloat(avgCell) >= 93){
                changeCell.innerText = 'A';
            }else if(parseFloat(avgCell) >= 90){
                changeCell.innerText = 'A-';
            }else if(parseFloat(avgCell) >= 87){
                changeCell.innerText = 'B+';
            }else if(parseFloat(avgCell) >= 83){
                changeCell.innerText = 'B';
            }else if(parseFloat(avgCell) >= 80){
                changeCell.innerText = 'B-';
            }else if(parseFloat(avgCell) >= 77){
                changeCell.innerText = 'C+';
            }else if(parseFloat(avgCell) >= 73){
                changeCell.innerText = 'C';
            }else if(parseFloat(avgCell) >= 70){
                changeCell.innerText = 'C-';
            }else if(parseFloat(avgCell) >= 67){
                changeCell.innerText = 'D+';
            }else if(parseFloat(avgCell) >= 63){
                changeCell.innerText = 'D';
            }else if(parseFloat(avgCell) >= 60){
                changeCell.innerText = 'D-';
            }else{
                changeCell.innerText = 'F';
            }
        }

        // Letter Grade to 4.0 scale
        else if(avgCell.includes('A')||avgCell.includes('B')||avgCell.includes('C')||avgCell.includes('D')||avgCell.includes('F')){
            table.rows[0].cells[7].innerText = "Average(4.0)"; // Change header text to show what grading method is shown
            console.log("  From Letter to 4.0 ");

            if(avgCell == "A"){
                changeCell.innerText = '4.0';
            }else if(avgCell == 'A-'){
                changeCell.innerText = '3.7';
            }else if(avgCell == 'B+'){
                changeCell.innerText = '3.3';
            }else if(avgCell == 'B'){
                changeCell.innerText = '3.0';
            }else if(avgCell == 'B-'){
                changeCell.innerText = '2.7';
            }else if(avgCell == 'C+'){
                changeCell.innerText = '2.3';
            }else if(avgCell == 'C'){
                changeCell.innerText = '2.0';
            }else if(avgCell == 'C-'){
                changeCell.innerText = '1.7';
            }else if(avgCell == 'D+'){
                changeCell.innerText = '1.3';
            }else if(avgCell == 'D'){
                changeCell.innerText = '1.0';
            }else if(avgCell == 'D-'){
                changeCell.innerText = '0.7';
            }else{
                changeCell.innerText = '0.0';
            }
        }

        // From 4.0 to %
        else{
            table.rows[0].cells[7].innerText = "Average(%)";
            getAverageGrade();
            break;
        }
    }
}