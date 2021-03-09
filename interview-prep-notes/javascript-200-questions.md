# undefined vs null.

## Question 1: What is "undefined" in javascript?

undefined means variable is decalared but its value is unassigned.
```javascript
 let x; // undefined
 console.log(x) // output: undefined
```

if a variable is not declared and is accessed, you get the error saying "uncaught ReferenceError: x is not defined."
```javascript
console.log(y);
```
null is a primitve data type.
undefined is a data type.

## Question 2:
null==undefined (true because both null and undefined represents nothingness)
```javascript
let x;
let y = null;
console.log(x==y) // true with Equality opeartor
```
null===undefined (false because undefined is a different data type)

```javascript
let y = null;
console.log(x===y) // false with Strict Equality opeartor
```

## Question 3:
you can explicitly assign undefined to a variable since undefined is a JS keyword.
```javascript
let x = undefined;
```

# Function Scope vs Block Scope

## Question 1: What is function scope in javascript?
Javascript has function scope. A variable declared with var/let keyword insid a javascript function can only be accessed inside the function, not outisde the function.
if a variable name declared insde a function is also delcared outside the function, both outside block and function block have their own copies of the variable with the same name.

```javascript
funciton a() { let/var x= 10; }
function b() { console.log(x); } 
a(); 
b(); //  "uncaught ReferenceError: x is not defined."
```

```javascript
let/var x= 10; // x is now a global variable within current block.
funciton a() { let/var x += 5; }
function b() { console.log(x); } 
a(); 
b(); // output: 15 
```

## Question 2: What is hoistinng ?
- Hoisiting is a process which is happening behind the scene, internally JS Compiler is bringing all VAR decalartions on top.
- ES5 has function scope because of hoisting.
- ES6 has block scope because it does not have hoisiting.
- if you delcare a variable using "var" keyword, hoisiting will be there.

```javascript
// Hositing Example 1:
console.log(y); // y is not delcared and not hoisitied. output: "uncaught ReferenceError: y is not defined."
console.log(x); // x is declared and undefined. output: "undefined"
var x;
```

```javascript
// Hositing Example 1:
/* you won't even see "undefined" value since x is not even hoisited when "let" keyword is used.
"uncaught ReferenceError: cannot access x before initilization." */
console.log(x);
let x;
```

## Question 3 : What is block scope in javascript?
Block scope is nothing but curly brackets.
for example, if condition, for loop, do-while loop or anything that uses curly brackets. 

Block Scope creates a seperate scope or a seperate world for the declarations existing in that block. 
the variable life time usually begins with declarations within that block and ends with closing curly bracket in that block.

```javascript
// Block scope example
let x = 10;
 {
  let x= 20;
  console.log(x); // output: 20. javascript doesn't hoisit variable declared by "let" keyword.
 }
 console.log(x); //output: 10  
```

```javascript
// Hositing Example 2:
console.log(x); // x is declared and defined. output: "undefined"
var x = 10; // only declration is hoisited by JS Compiler. the value assignment is not hoisited.
```

# Automatic Semicolon Insertion  (ASI)

## Question 1: Should you terminate all lines by a semicolon? 
it's good practice to add semicolon at the end of each line, but semicolon in javascript is optional. 
JS compiler automatically adds a semicolon before the new line character when necessary.

```javascript
console.log(10)   // ASI
console.log(20);
```

``` javascript
let a= 4*      // ASI
5              // ASI
console.log(a); //output 20.
```
## Question 2: Why will you get "undefined" with return keyword without opening curly bracket on the same line?

Automatic semicolon insertion does not alway work well. sometimes you will get unexpected result if you use opening curly bracket with return keyword incorrectly.
``` javascript
function getTest() {
 return      // ASI is performed here. you need to bring opening curly bracket next to return keyword to fix this issue.
 {
   x: 5
 }
}

function getTest2() {
 return {
  y: 15
 }
}

const obj = getTet(); const obj2 =getTest2();
console.log(obj); // output: undefined
console.log(obj2); // output: { y:15 }  
```
## Question 3: Can strict mode; 'use strict', affect the ASI behavior? 
No

# ES6 Rest Operator vs ES5 the arguments object.

## Rest opeartor (ES6)
The rest opertor ... must be at the last position.
The rest parameter syntax allows a function to accept unlimited arguments as an array.
```javascript
// in ES6, you use "..." rest operator and followed by variable name you want.
function sum(a,b,...theArgs)  {  console.log(theArgs); } 
sum(10,20, [1,2,3]); // output:  Array [1, 2, 3]
```

## Question: How can you handle 'n' number of, multiple, or any number of parameters passed to a function in javascript?
Rest opeator (...) can handle any number of parameters by declaring a rest variable name at the last position of your function's parameter list.   

<b> parameters vs argumetns </b>
```
 Function parameters are the names listed in the function's definition. Function arguments are the real values passed to the function. Parameters are initialized to the values of the arguments supplied.
```

## Question: Can rest paramter be placed anywhere in the function parameter list in javascript?
No, it can only be placed at the end of the fucntion parameter list. Not in the beginning unless there's only rest parameter list as the only function parameter.


## Spread operator (ES6)
Spread operator can decompse an array into mulitple variables representation, and we can use this representation inside a new array decalartion to operatio array clone opeartion or join operation, a function call, a new-operator construtor call, or create key-value pairs inside an object decalartion.

```javascript
let arr1 = [1,2,3];
let arr2 = [...arr1, 4, 5, 6]; // join the arr1
let arr3 = [...arr2]; // clone the arr2
let arr4 = arr3; // 

let arr5 = [[1],[2]];
let arr6 = [...arr5, 3]; // output: [ [1], [2], 3]
```
## Question: what is the best way to create new Javascript arrays with assignment (operator) ?
you can use spread operator (...), which is placed before a variable name to decompose the variable content into individual elements.


## The arguments object (ES5)
The arguments object is a local variable available within all non-arrow functions. It won't work in arrow function.

```javascript
var bar = x => console.log(arguments) // Uncaught ReferenceError: arguments is not defined
var bar = (...arguments) => console.log(arguments); // use rest operator instead and create your own agruments variable.
```

 The arguments object holds every parameters passed to current function call.
```javascript
function myConcat(separator) { // arguments[0] holds this seperator value.
  let args = Array.prototype.slice.call(arguments, 1); // Array.prototype.slice(start,end) returns a subarray from start index to end-1 index. (exclusive end index) 
  return args.join(separator);
}

myConcat(', ', 'red', 'orange', 'blue');  // returns "red, orange, blue" 
```
## Question: can we use arguments object inside arrow function in Javascript?
No, it can't.  arguments only works in a regular function, not arrow function. 
An arrow function doesn’t have its own this value and the arguments object. Therefore, you should not use it as an event handler, a method of an object, a method of a class, or a prototype method, or when you have a function that uses the arguments object.

# Number.NEGATIVE_INFINITY vs Number.POSITIVE_INFINITY
any Javascript value which cannot fit in 64-bit format will return infinity. 
It cannot hold the value. The value is larger than 64-bit.
```javascript
console.log(1e3); // output: 1000
console.log(9e3); // output: 9000
console.log(9e400); // Infinity
console.log(-9e400); // -Infinity
console.log(Number.MAX_VALUE*2); // Infinity 
console.log(-Number.MAX_VALUE*2); // -Infinity 
```
## How will you validate positive or negative infinity ?
```javascript
 if(value==Number.POSITIVE_INFINITY) return "positive infinity number";'
 return number; // correct and valid number.
```
## What is the output of 1/0 ?
Infinity

# When do you get NaN as outoupt?
Nan represents not-a-number or non-numeric value.

## isNan() vs NaN
```javascript
let a = 10;
let b = "value";
console.log(a*b); // output: NaN

if(!isNaN(a*b)) // when it's a number. (!isNaN(exp) can also be expressed as isNaN(exp)==false)
{ console.log("Valid"); } // this is a number
else 
{ console.log("Invalid"); } // it's not a number result.

console.log(NaN==NaN); //output: false. you should use isNaN() instead
```
## isNaN() vs isFinit()
we prefer to use isFinit() method, which not only checks for NaN but also check for positive & negative infinity as well.
we use isFinit() method to check if a variable is a regular number or not.
```javascript
let a = 10;
let b = "value";

console.log(isFinit(a*b)); // false since it is NaN
console.log(isFinit(4*5)); // true
console.log(isFinit(Number.MAX_VALUE*2)); // false since it is postive infinity
console.log(isFinit(-Infinity)); // false sicne it is negative infinity

```

