document.getElementById("buttons").onclick = getEntry;
var equals = document.getElementById("calculate");
var entry = document.getElementsByClassName("t1").value;
var entries = [];
var result;


equals.addEventListener('click', getResult);



function  getEntry(e) {

    if (e.target.innerText == '=') {

    } else {
        console.log(e.target.innerText);
        document.getElementById("display").innerHTML = e.target.innerText;
        entries.push(e.target.innerText);
        document.getElementById("display").innerHTML = entries.join('');
        console.log(entries);

    }
}
;

function getResult() {
    try {

        //eval udregner det sammen som står i en string, hvis det er tal.
        result = (entries.join('') + ' = ' + eval(entries.join('')));
        document.getElementById("display").innerHTML = result;

        console.log(result);

    } catch (ex) {
        document.getElementById("display").innerHTML = '<i>Error</i>   ' + ex.message + '   press clear';
    }

}


//Opg 1 - Useing map and filter.

var numbers = [1, 3, 5, 10, 11];

function cbAll(number, index, arr) {
    if (index < arr.length - 1) {
        return number + arr[index + 1];
    } else {
        return number;
    }
}

var result = numbers.map(cbAll, numbers);
console.log(result);

//Filter arrayet
var moreThan15 = result.filter(function (result) {
    //Filtrer i data
    return result >= 15;
});

console.log(moreThan15);

//Reduce method - Count same word in an array.
var votes = ["Clinton", "Trump", "Clinton", "Clinton", "Trump", "Trump", "Trump", "None"];

var votesCount = votes.reduce(function (prev, cur) {
    prev[cur] = (prev[cur] || 0) + 1;
    return prev;
}, {});

console.log(votesCount);

//Anden løsning
var initialValue = {};

var reducer = function (tally, vote) {
    if (!tally[vote]) {
        tally[vote] = 1;
    } else {
        tally[vote] = tally[vote] + 1;
    }
    return tally;
};

var result2 = votes.reduce(reducer, initialValue);

console.log(result2);

//Closure - inner closure, der closer over variablen age.
//http://crockford.com/javascript/#names
var setAge = (function () {
    function setAge(age) {
        this.getAge = function () { //Konstruktør
            return age;
        };
    }

    return setAge;
}());

var setName = (function () {
    function setName(name) {
        this.getName = function () { //Konstruktør
            return name;
        };
    }

    return setName;
}());

function Person(first, name, age) {
    this.getName = function () { //Konstruktør
            return name;
        };
    this.lastName = last;
    this.getAge = function () { //Konstruktør
            return age;
        };
  
}

//var bo = new setName("Bo");
//console.log("Bo's age is " + bo.getName());

var bo = new setAge(43);
delete bo.age;
console.log("Bo's age is " + bo.getAge());

//var person = Person.getName();
//console.log(person);

//Virker ikke
//getInfo();
//
//function getInfo() {
//    var bo = new setName("Bo");
//    var bo = new setAge(43);
//    
////    var result = bo.getName() + ", " + bo.getAge();
//    console.log(result);
//    console.log("Indeholder: " + bo.getName() + ", " + bo.getAge());
//}

function Person(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
      this.details=function() {return this.firstName + " " + this.lastName + ", " + this.age}
}
//    var getDetails=(Person) => {
//        return "First Name:  " + Person.firstName + ". Last Name: " + Person.lastName + ". Age: " + Person.age;
//};

var Benedikte = new Person("Benedikte", "Majbrink", 47);
var Bo = new Person("Bo", "Henriksen", 43);

console.log(Benedikte.details());




