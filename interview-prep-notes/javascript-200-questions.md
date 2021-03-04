# undefined vs null.

## Question 1: What is "undefined" in javascript?

undefined means variable is decalared but its value is unassigned.
```
 let x; // undefined
 console.log(x) // output: undefined
```

if a variable is not declared and is accessed, you get the error saying "uncaught Error x is undefined."
```
console.log(y);
```
null is a primitve data type.
undefined is a data type.

## Question 2:
null==undefined (true because both null and undefined represents nothingness)
```
let x;
let y = null;
console.log(x==y) // true with Equality opeartor
```
null===undefined (false because undefined is a different data type)

```
let y = null;
console.log(x===y) // false with Strict Equality opeartor
```

## Question 3:
you explicitly assign undefined to a variable since undefined is a JS keyword.
'''
let x = undefined;
'''

# ES6 Rest Operator vs ES5 the arguments object.

## Rest opeartor (ES6)
The rest opertor ... must be at the last position.
The rest parameter syntax allows a function to accept unlimited arguments as an array.
```javascript
// in ES6, you use "..." rest operator and followed by variable name you want.
function sum(a,b,...theArgs)  {  console.log(theArgs); } 
sum(10,20, [1,2,3]); // output:  Array [1, 2, 3]
```

## The arguments object (ES5)
The arguments object is a local variable available within all non-arrow functions. It won't work in arrow function.

```javascript
var bar = x => console.log(arguments) // Uncaught ReferenceError: arguments is not defined
var bar = (...arguments) => console.log(arguments); // use rest operator instead and create your own agruments variable.
```

 The arguments holds every parameters passed to current function call.
```javascript
function myConcat(separator) { // arguments[0] holds this seperator value.
  let args = Array.prototype.slice.call(arguments, 1); // Array.prototype.slice(start,end) returns a subarray from start index to end-1 index. (exclusive end index) 
  return args.join(separator);
}

myConcat(', ', 'red', 'orange', 'blue');  // returns "red, orange, blue" 
```

