'use strict'

/* Math and rounding
// console.log(Math.sqrt(25)); //square root
// console.log(25 ** (1/2)); //square root
// console.log(Math.pow(5, 2)); //5^2

// console.log(Math.max(5, 18, 23, 11, 2)); //max
// console.log(Math.min(5, 18, 23, 11, 2)); //min

// console.log(Math.PI); //pi
// console.log(Math.random()) // num between 0 and 1
// console.log(Math.trunc(Math.random() * 6) + 1);
//
// const randomInt = (min, max) => Math.floor(Math.random() * (max - min) + 1) + min;
// randomInt(1, 9)
//
// let a = randomInt(1 ,9);
// let trys =0;
// while(a < 9){
//     trys++;
//     a = randomInt(1 ,9);
// }
// console.log(trys)

//Rounding integers
// console.log("trunk: 23.3 = " + Math.trunc(23.3))
// console.log("trunk: 23.9 = " + Math.trunc(23.9))
//
// console.log("round: 23.3 = " + Math.round(23.3))
// console.log("round: 23.9 = " + Math.round(23.9))
//
// console.log("ceil: 23.3 = " + Math.ceil(23.3))
// console.log("ceil: 23.9 = " + Math.ceil(23.9))
//
// console.log("floor: 23.3 = " + Math.floor(23.3))
// console.log("floor: 23.9 = " + Math.floor(23.9))

// Rounding decimals
// console.log((2.7).toFixed(0)) // toFixed return string
// console.log((2.7).toFixed(3)) // toFixed return string
// console.log(+(2.345).toFixed(2)) // toFixed return string

 */
/*
Numeric Separators
//287,460,000,000
const diameter = 287_460_000_000;
console.log(diameter);
 */
/*
BigInt

// normal int is storing in 64 bit in witch 53 bit is for number and 11 bit is for decimal
// so the max number is 2^53 - 1
// console.log(2 ** 53 - 1);
// console.log(Number.MAX_SAFE_INTEGER);
// if we want to add more to this number then the operations are not accurate
// console.log(2 ** 53 + 1);
// console.log(2 ** 53 + 2);
// console.log(2 ** 53 + 3);
// console.log(9007199254740991900719925474099190071992547409919007199254740991)

// to solve this problem we can use BigInt
// if we want to see the number we need to put (n) at the end witch will convert this into BigInt
// console.log(9007199254740991900719925474099190071992547409919007199254740991n)
// console.log(BigInt(9007199254740991900719925474099190071992547409919007199254740991n))

// Operations
// console.log(10000n + 10000n);
// console.log(1012312312312312312312000n * 10012312312312312312300n);
// console.log(Math.sqrt(16n)); // not possible
// console.log(16n ** 0.5); // possible
// console.log(16n ** BigInt(0.5)); // possible
// console.log(16n ** BigInt(1/2)); // not possible
// const huge = 2312234234234234234234234234234n;
// const num = 23;
// console.log(huge * num); // not possible
// console.log(huge * BigInt(num)); // possible

// Exceptions
// console.log(20n > 15); // true
// console.log(20n === 20); // false , because the type is different
// console.log(20n == 20); // true , because the value is same , because js does the conversion

// divisions
// console.log(10n / 3n); // 3n
// console.log(10 / 3); // 3.3333333333333335
// console.log(10n % 3n); // 1n

 */
/*
Dates and Times


// Create a date (4 ways)

// const now = new Date();
// console.log(now);
// console.log(new Date('Aug 02 2020 18:05:41'));
// console.log(new Date('December 24, 2015'));
// console.log(new Date(2037, 10, 19, 15, 23, 5));
// console.log(new Date(2037, 10, 43)); // this will auto correct the date
// console.log(new Date(0)); // 1970-01-01T00:00:00.000Z , creating date from timestamp
// console.log(new Date(3 * 24 * 60 * 60 * 1000)); // 3days * 24 hours * 60 min * 60 sec * 1000 ms will give us 3 days from 1970-01-01

// Working with dates
const future = new Date(2037, 10, 19, 15, 23);
// console.log(future);
// console.log(future.getFullYear());
// console.log(future.getMonth());
// console.log(future.getDate()); // the day of the month
// console.log(future.getDay()); // the day of the week
// console.log(future.getHours());
// console.log(future.getMinutes());
// console.log(future.getSeconds());
// console.log(future.toISOString());
// console.log(future.getTime()); // timestamp

console.log(Date.now()) // current timestamp

future.setFullYear(2040);
 */
/*
Date Operations

const future = new Date(2037, 10, 19, 15, 23);
console.log(Number(future)); // timestamp

const calcDaysPassed = (date1, date2) => Math.abs(date2 - date1) / (1000 * 60 * 60 * 24); // getting the days between two dates
console.log(calcDaysPassed(
    new Date(2037, 3, 14),
    new Date(2037, 3, 24))
);
 */
/*
Internationalizing Date (Intl)

const now = new Date();
const options = {
    hour: 'numeric',
    minute: 'numeric',
    day: 'numeric',
    month: 'long',
    year: 'numeric',
    weekday: 'long'
};
const date = new Intl.DateTimeFormat('en-US', options).format(now);
console.log(date);
const date2 = new Intl.DateTimeFormat('en-GB', options).format(now);
console.log(date2);
const date3 = new Intl.DateTimeFormat('ar-SY', options).format(now);
console.log(date3);
const date4 = new Intl.DateTimeFormat('bg-BG', options).format(now);
console.log(date4);
 */
/*
Internationalizing Numbers (Intl)

const num = 3884764.23;
const options = {
    style: 'unit',
    unit: 'mile-per-hour'
};
console.log('US: ', new Intl.NumberFormat('en-US', options).format(num));
console.log('Germany: ', new Intl.NumberFormat('de-DE', options).format(num));
console.log('Syria: ', new Intl.NumberFormat('ar-SY', options).format(num));
console.log('Bulgaria: ', new Intl.NumberFormat('bg-BG', options).format(num));
 */
/*
setTimeout and setInterval

// setTimeout
// first param is the function and the second is the time in ms and the rest of the params are the arguments for the function
const ingredients = ['Pizza', 'Tomato', 'Cheese'];
const picaTimer = setTimeout(
    (ing1, ing2) => console.log(`Here is your pizza with ${ing1} and ${ing2}!`),
    3000,
    ...ingredients
);
console.log('Waiting...');
// if there is a Pizza in the ingredients array then we will clear the timer
if (ingredients.includes('Pizza')) {
    clearInterval(picaTimer);
}

// setInterval will run the function every x ms
// first param is the function and the second is the time in ms
setInterval(() => {
    console.log(new Date());
}, 1000);
 */