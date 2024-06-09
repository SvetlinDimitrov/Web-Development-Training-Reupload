'use strict';

// Data needed for a later exercise
const flights =
  '_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30';

// Data needed for first part of the section
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  openingHours: {
    thu: {
      open: 12,
      close: 22
    },
    fri: {
      open: 11,
      close: 23
    },
    sat: {
      open: 0, // Open 24 hours
      close: 24
    }
  }
};
/*
  Array Destructuring

const arr = [1, 2, 3, 4, 5];
const a = arr[0];
const b = arr[1];
const c = arr[2];
const d = arr[3];
const e = arr[4];
const [a1, b1, c1, d1, e1] = arr;

//SKIPPING AN ELEMENT
let [a2, , c2] = arr;
// console.log(a2 === a1, c2 === c1);

//SWAPPING TRICK
[a2, c2] = [c2, a2];
// console.log(a2 === c1, a1 === c2);

//NESTED ARRAYS DESTRUCTURING
const nested = [1, 2, [3, 4]];
const [a3, b3, [c3, d3]] = nested;
// console.log(a3, b3, c3, d3);
 */
/*
  Object Destructuring

const { name, categories } = restaurant;

//DIFFERENT NAMES
const { name: resName, location: test, categories: cat } = restaurant;
// console.log(name === resName, categories === cat);

//GIVING A DEFAULT VALUE
const { name: name2 = 'yes', menu = [] } = restaurant;
// console.log(name2 === restaurant.name, menu);

//MUTATING OBJECTS
let a = 111;
let b = 100;
const obj = { a: 23, b: 7 };
({ a, b } = obj);
// console.log(a, b);

//NESTED OBJECTS
const { openingHours } = restaurant;
console.log(openingHours);
const { openingHours: { fri } } = restaurant;
console.log(fri);
const { openingHours: { fri: { open, close } } } = restaurant;
console.log(open, close);

 */
/*
The Spread Operator (...)

const arr = [7, 8, 9];
const badNewArr = [1, 2, arr[0], arr[1], arr[2]];
const newArray = [1, 2, ...arr];
const newMenu = [...restaurant.mainMenu, 'Pizza'];
// Shallow Copy Array - UseCases1
const newMenuCopy = [...newMenu];
// Merge arrays - UseCase2
const mergedArrays = [...newMenu, ...newArray];
// Iterables: arrays , strings, maps , sets, NOT OBJECTS
const str = 'Suck it';
const letters = [...str];

//Objects
const newRestraint = { somethingsElse: 'yes', ...restaurant, founder: 'Gay' };
//Shallow Copy
const restraintCopy = {...restaurant, name: 'asdasd'};
*/
/*
  Rest Pattern

//dest is on the right
const arr = [1, 2, ...[3, 4]];
// console.log(arr);

//spread is on the left side
const [a, b, ...others] = [1, 2, 3, 4, 5];
// console.log(a, b, others);

const [pizza, , risotto, ...otherFood] = [...restaurant.mainMenu, ...restaurant.starterMenu];
// console.log(pizza, risotto, otherFood);

//Rest in objects
const { sat, ...weekdays } = restaurant.openingHours;
// console.log(sat , weekdays)

//Rest in functions
const add = (...args) => {
  return args.reduce((a, b) => a + b, 0);
};
// console.log(add(2, 3));
// console.log(add(3, 1, 2, 5, 9));
const x = [123, 123, 54, 123, 687, 12];
// console.log(add(...x));
const add2 = (mainNumber, ...othersNumbers) => `Main number is ${mainNumber} , and others doesnt matter`;
// console.log(add2(1, 2, 321, 12, 2));
 */