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

## Question 1: What is function scope?
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

## Question 3 : What is block scope?
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

# ES6 Rest Operator vs ES5 the arguments object.

## Rest opeartor (ES6)
The rest opertor ... must be at the last position.
The rest parameter syntax allows a function to accept unlimited arguments as an array.
```javascript
// in ES6, you use "..." rest operator and followed by variable name you want.
function sum(a,b,...theArgs)  {  console.log(theArgs); } 
sum(10,20, [1,2,3]); // output:  Array [1, 2, 3]
```

## Spread operator (ES6)
Spread operator can decompse an array into mulitple variables representation, and we can use this representation inside a new array decalartion to operatio array clone opeartion or join operation, a function call, a new-operator construtor call, or create key-value pairs inside an object decalartion.


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

