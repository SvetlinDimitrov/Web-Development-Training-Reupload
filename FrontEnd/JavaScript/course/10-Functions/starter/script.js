'use strict';

/*
 Default Parameters
const booking = [];
const createBook = function(
  flightNum = 'Default name' ,
  numPassengers = 1 ,
  price = numPassengers * 199){
  // Old way E5
  // numPassengers = numPassengers ?? '0';
  // flightNum = flightNum ?? 123;
  // price = price ?? 90000;
  const book = {flightNum , numPassengers , price}
  booking.push(book);
}

createBook('LH123')
createBook('LH1234' , 19)
//if we want to skip a parameter
createBook('name' , undefined , 20)
console.log(booking);
*/
/*
Functions Accepting Callback

const oneWord = function(str) {
  return str.replace(/ /g, '').toLowerCase();
};

const upperWord = function(str) {
  const [first, ...others] = str.split(' ');
  return [first.toUpperCase(), ...others].join(' ');
};

//Higher-order function
const transformer = function(str , fn){
  console.log(`original string: ${str}`);
  console.log(`transformed string: ${fn(str)}`);
  console.log(`transformed by: ${fn.name}`)
}

transformer('Java is the best!' , upperWord);
transformer('Java is the best!' , oneWord);
 */
/*
Returning functions
const greet = function(greeting){
  return function(name) {
    console.log(`${greeting} ${name}`)
  }
}

// const greeterHey = greet('Hey');
// greeterHey('Jhonas');
greet('Hey')('John')

const greetArrow = greeting => name => console.log(`${greeting} ${name}`)
greetArrow('Hello there')('General Kenobi');
 */
/*
apply , bind , call


const hotel = {
  name: 'Street2',
  year: 1999,
  peoples: [],
  registerPeople(name) {
    console.log(`${this.name} is registering ${name}`);
    this.peoples.push(name);
  }
};
const hotel2 = {
  name: 'Street3',
  year: 2000,
  peoples: []
};

const register = hotel.registerPeople;

// not working because the this keyword is not pointing to the hotel object
// register('Jonny');

// apply method (first argument is the this keyword and the second is the array of arguments)
// register.apply(hotel , ['Jonny']);

// call method (first argument is the this keyword and the rest are the arguments)
// register.call(hotel , 'Jonny');

// bind method (first argument is the this keyword and the rest are the arguments)
// now this is a new function that is binded to the hotel object
const registerHotel = register.bind(hotel);
registerHotel('Jonny');
registerHotel('Jonny2');
// now this is a new function that is binded to the hotel2 object
const registerHotel2 = register.bind(hotel2);
registerHotel2('Jonny3');
registerHotel2('Jonny4');
// we can also use bind to set the default parameters
const registerHotel3 = register.bind(hotel, 'Jonny5');
// now the name is already set to Jonny5
registerHotel3();
// we can create a new function using the this and then bind it to the object
const registerPeoples = function(name) {
  this.peoples.push(name);
  console.log(this.peoples);
};
const registerHotel4 = registerPeoples.bind(hotel);
registerHotel4('Jonny6');
 */
