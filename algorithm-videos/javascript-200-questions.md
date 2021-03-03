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
