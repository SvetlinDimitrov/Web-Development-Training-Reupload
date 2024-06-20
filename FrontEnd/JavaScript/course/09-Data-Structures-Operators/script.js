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
  order(a, b) {
    return [this.starterMenu[a], this.starterMenu[b]];
  },
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
/*
  Short Circuiting (&& and ||)

//||
//if the first value is truly it will be return
// console.log(3 || 'Json');
// console.log('' || 'Json');
// console.log(true || 0);

//if we have only falsy values i will get the last one
// console.log(undefined || null);
// console.log(undefined || 0 || '' || 'Hello' || 23);

//setting a default value
const guest1 = restaurant.numGuests ? restaurant.numGuests : 10;
const guest2 = restaurant.numGuests || 10;
restaurant.numGuests = 15;
const guest3 = restaurant.numGuests || 1;
// console.log(guest1, guest2 , guest3);

//&&
//when is truty the operation continues and returns the last result
// console.log(7 && 'Jonas') //returns Jonas
//when is falsy i will return the first falsy thing
// console.log(0 && 'Jonas') // returns Jonas
//its working like that because if the first is false there is not need to look for the next result
// console.log('Hello' && 23 && null && 'Jonas') // null
if(restaurant.orderPizza){
  restaurant.orderPizza('a' , 'b');
}
console.log(restaurant.orderPizza && restaurant.orderPizza('a' , 'b'));
restaurant.orderPizza = (a ,b) => `${a} ${b}`
console.log(restaurant.orderPizza && restaurant.orderPizza('a' , 'b'));
//OR (||) will return the first truthy value of all the operands or simply the last value if all of them are falsy
//AND (&&) will return the first falsy value or the last value if all of them are truthy
 */
/*
  Nullish Coalescing Operator (??)
restaurant.numGuests = 0;
const guest = restaurant.numGuests || 10;
// console.log(guest);

//nullish: null and undefined (NOT 0 or '')
const guestCorrect = restaurant.numGuests ?? 10;
// console.log(guestCorrect);
 */
/*
  Logical Assignment Operators
const rest1 = {
  name: 'adsa',
  numGuests: 10
};
const rest2 = {
  name: 'adsa',
  owner: 'asdasddasd'
};

//LOGICAL ASSIGNMENT OPERATOR (||=)
rest1.numGuests ||= 30;// същото като rest2.numGuests = rest2.numGuests || 30
rest1.owner ||= 'Misho';
// console.log(rest1);

//LOGICAL NULLISH ASSIGNMENT OPERATOR
rest1.cats = 0;
rest1.cats ??= 10; // същото като rest1.cats = rest1.cats ?? 10
// console.log(rest1)

//LOGICAL AND ASSIGMENT OPERATOR
//Ако съществува тогава го промени
rest1.owner &&= 'Gosho'; //същото като rest1.owner = rest1.owner && 'Gosho';
rest1.leader &&= 'Gosho'; // нищо не се случва защото няма поле leader
*/

/*
Coding Challenge #11 | JavaScript 🔥  | Lecture 102
We're building a football betting app (soccer for my American friends 😅)! Suppose we get data from a web service about a certain game ('game' variable on next page). In this challenge we're gonna work with that data.

Your tasks:
1. Create one player array for each team (variables 'players1' and 'players2')
2. The first player in any player array is the goalkeeper and the others are field players.
 For Bayern Munich (team 1) create one variable ('gk') with the
goalkeeper's name, and one array ('fieldPlayers') with all the remaining 10 field players.
3. Create an array 'allPlayers' containing all players of both teams (22 players)
4. During the game, Bayern Munich (team 1) used 3 substitute players.
So create a new array ('players1Final') containing all the original team1 players
plus 'Thiago', 'Coutinho' and 'Perisic'.
5. Based on the game.odds object, create one variable for each odd
(called'team1', 'draw' and 'team2').
6. Write a function ('printGoals') that receives an arbitrary number of player
names (not an array) and prints each of them to the console, along with the
number of goals that were scored in total (number of player names passed in).
7. The team with the lower odd is more likely to win.
Print to the console which team is more likely to win,
without using an if/else statement or the ternary operator.

Test data for 6.: First, use players 'Davies', 'Muller', 'Lewandowski' and 'Kimmich'.
Then, call the function again with players from game.scored.

const game = {
  team1: 'Bayern Munich',
  team2: 'Borrussia Dortmund',
  players: [
    [
      'Neuer',
      'Pavard',
      'Martinez',
      'Alaba',
      'Davies',
      'Kimmich',
      'Goretzka',
      'Coman',
      'Muller',
      'Gnarby',
      'Lewandowski'
    ],
    [
      'Burki',
      'Schulz',
      'Hummels',
      'Akanji',
      'Hakimi',
      'Weigl',
      'Witsel',
      'Hazard',
      'Brandt',
      'Sancho',
      'Gotze'
    ]
  ],
  score: '4:0',
  scored: ['Lewandowski', 'Gnarby', 'Lewandowski', 'Hummels'],
  date: 'Nov 9th, 2037',
  odds: {
    team1: 1.33,
    x: 3.25,
    team2: 6.5
  }
};
const [team1, team2] = game.players;
const [
  [gk1, ...fieldPlayers1],
  [gk2, ...fieldPlayers2]
] = game.players;
const allPlayers = [...team1, ...team2];
const players1Final = [...team1, 'Thiago', 'Coutinho', 'Perisic'];
const { odds: { team1: team11, x: draw, team2: team22 } } = game;
const printGoals = (...players) => {
  players.forEach(player => console.log(`${player} total: ${players.length}`));
};
const message =
  team11 < team22 && 'Team1 is going to win' || team11 > team22 && 'Team2 is going to win'
 */

/*
For-of Loop
const menu = [...restaurant.starterMenu, ...restaurant.mainMenu];
// for (const item of menu) console.log(item);
for (const item of menu.entries()) {
  const [index , menu] = [...item]
  // console.log(index , menu);
}
for (const [index , menuItem] of menu.entries()) {
  // console.log(`${index + 1}: ${menuItem}`);
}
 */
/*
  Optional Chaining (?.)

// console.log(restaurant.openingHours.mon.open) //this will throw
//if openingHours exists and mon exists then the open filed will be taken.
//if they dont exists then undefined will be returned immediately
// console.log(restaurant.openingHourss?.mon?.open)

//Example
const days = ['mon' , 'tue' , 'wed' , 'thu' , 'fri' , 'sat' , 'sun']
for(const day of days){
  const open = restaurant.openingHours[day]?.open.toString()
  // open && console.log(`On ${day} we open in ${open}`);
}

//ON METHODS
console.log(restaurant.order?.(0,1) ?? 'Method does not exits');
console.log(restaurant.orders?.(0,1) ?? 'Method does not exits');
 */
/*
  Looping Objects: Object Keys, Values, and Entries

for(const day of Object.keys(restaurant.openingHours)){
  // console.log(day);
}
for(const val of Object.values(restaurant.openingHours)){
  // console.log(`Open in ${val.open} , Closes in ${val.close}`)
}
for(const [key , {open , close}] of Object.entries(restaurant.openingHours)){
  // console.log(`In ${key} we open in ${open} , Closes in ${close}`)
}
 */

/*
Coding Challenge #12 | JavaScript 🔥 | Lecture 107
Let's continue with our football betting app! Keep using the 'game' variable from before.

Your tasks:
1. Loop over the game.scored array and print each player name to the console,
 along with the goal number (Example: "Goal 1: Lewandowski").
2. Use a loop to calculate the average odd and log it to the console
(We already studied how to calculate averages, you can go check if you don't remember).
3. Print the 3 odds to the console, but in a nice formatted way, exactly like this:
Odd of victory Bayern Munich: 1.33
Odd of draw: 3.25
Odd of victory Borrussia Dortmund: 6.5
Get the team names directly from the game object, don't hardcode them
(except for "draw").

Hint: Note how the odds and the game objects have the same property names 😉

4. Bonus: Create an object called 'scorers' which contains the names of the
players who scored as properties, and the number of goals as the value.
In this game, it will look like this:
{
Gnarby: 1,
Hummels: 1,
Lewandowski: 2
}

GOOD LUCK 😀

const game = {
  team1: 'Bayern Munich',
  team2: 'Borrussia Dortmund',
  players: [
    [
      'Neuer',
      'Pavard',
      'Martinez',
      'Alaba',
      'Davies',
      'Kimmich',
      'Goretzka',
      'Coman',
      'Muller',
      'Gnarby',
      'Lewandowski'
    ],
    [
      'Burki',
      'Schulz',
      'Hummels',
      'Akanji',
      'Hakimi',
      'Weigl',
      'Witsel',
      'Hazard',
      'Brandt',
      'Sancho',
      'Gotze'
    ]
  ],
  score: '4:0',
  scored: ['Lewandowski', 'Gnarby', 'Lewandowski', 'Hummels'],
  date: 'Nov 9th, 2037',
  odds: {
    team1: 1.33,
    x: 3.25,
    team2: 6.5
  }
};
// 1.
for (const [i, player] of game.scored.entries()) {
  // console.log(`Goal ${i + 1}: ${player}`);
}

// 2. with loop
let avg = 0;
const values = Object.values(game.odds);
for (const odds of values) {
  avg += odds;
}
// console.log(avg * values.length / 100);
// easy way
// console.log(values.reduce((a, b) => a + b, 0) * values.length / 100);

// 3.
for (const [k, odd] of Object.entries(game.odds)) {
  // console.log(((k !== 'x') && `Odd of victory ${game[k]}: ${odd}`) || `Odd of draw: ${odd}`);
}

// 4.
const scorers = {};
for (const scorer of game.scored) {
  scorers[scorer] ??= 0;
  scorers[scorer] = scorers[scorer] + 1;
}
// console.log(scorers);
 */

/*
  Working with Strings
 */
// const airLine = 'Tap Air Portugal';
// const plane = 'A320';
// console.log(plane[0] === 'A');
// console.log('B737'[0]);
// console.log('B737'.length);
// console.log(airLine.length);
// console.log(plane.indexOf('A'));
// console.log(airLine.lastIndexOf('a'));
// console.log(airLine.indexOf('Air'));

//SUB STRING
// console.log(airLine.slice(4));
// console.log(airLine.slice(4, 7));
// console.log(airLine.slice(0, airLine.indexOf(' ')));
// console.log(airLine.slice(0, airLine.lastIndexOf(' ')));
// console.log(airLine.slice(-2)) //will start from the back
// console.log(airLine.slice(0 , -1)) //will start from the start till the last word
// const checkMiddleSeat = (seat) => {
//   //B and E are middle seats
//   const s = seat.slice(-1);
//   (s === 'B' || s === 'E') && console.log(`You got the middle seat`);
//   (s !== 'B' && s !== 'E') && console.log(`You got lucky`);
// }
//
// checkMiddleSeat('11B')
// checkMiddleSeat('23C')
// checkMiddleSeat('3E')

// console.log(airLine.toLowerCase());
// console.log(airLine.toUpperCase());
// const wrongName = 'aLeX';
// console.log(
//   wrongName.charAt(0).toUpperCase()
//     .concat(wrongName.toLowerCase().slice(1))
// );

//replacing
// const priceGB = '288,97#';
// const priceUs = priceGB
//   .replace('#', '$')
//   .replace(',', '.');
// console.log(priceUs);
// const announcement = 'All passengers come to boarding door 23. Boarding door 23!';
// console.log(announcement.replaceAll('door', 'gate'));
// console.log(announcement.replaceAll(/door/g, 'gate')); //using regex

//BOOLEANS
const plane = 'A320eno'
console.log(plane.includes('A320'))
console.log(plane.includes('Boeing'))
console.log(plane.startsWith('A32'))
console.log(plane.endsWith('A32'))

