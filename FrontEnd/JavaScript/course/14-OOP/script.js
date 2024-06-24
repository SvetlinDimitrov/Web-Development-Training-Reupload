'use strict';

/*
    Constructor function
const Person = function (firstName, birthYear) {
  // Instance properties
  this.firstName = firstName;
  this.birthYear = birthYear;

  // Never create a method inside a constructor function ,
  // because it will be copied to every object created using this constructor function witch
  // is not efficient
  this.calcAge = function () {
    console.log(2037 - this.birthYear);
  }
}

const jonas = new Person('Jonas', 1991);
// steps when new keyword is used
// 1. New {} is created
// 2. function is called, this = {}
// 3. {} linked to prototype
// 4. function automatically return {}

const matilda = new Person('Matilda', 2017);
const jack = new Person('Jack', 1975);
console.log(matilda, jack, jonas);
 */
/*
Prototypes
const Person = function (firstName, birthYear) {
  // Instance properties
  this.firstName = firstName;
  this.birthYear = birthYear;

}
// All the objects that are created using Person constructor function will have access to the methods
// that are defined in the prototype property of the constructor function
Person.prototype.calcAge = function () {
  console.log(2037 - this.birthYear);
}
Person.prototype.species = 'Homo Sapiens';
// console.log(Person.prototype);

const jonas = new Person('Jonas', 1991);
// console.log(jonas);
//When we look at the jonas object, we can't see the calcAge method, but we can access it
//It has an access because we used a prototype inheritance
// jonas.calcAge();
// This is the prototype of the jonas object
// console.log(jonas.__proto__);

// console.log(jonas.__proto__ === Person.prototype); // true
// console.log(Person.prototype.isPrototypeOf(jonas)); // true
// console.log(Person.prototype.isPrototypeOf(Person)); // false
// console.log(jonas.species)
//
// console.log(jonas.hasOwnProperty('firstName'))
// console.log(jonas.hasOwnProperty('species'))

// console.log(jonas.__proto__);
// // Object.prototype (top of the prototype chain)
// console.log(jonas.__proto__.__proto__);
// console.log(jonas.__proto__.__proto__.__proto__);

// console.log(Person.prototype.constructor)

const arr = [1, 2, 2, 2, 34, 5]; // new Array === []
// console.log(arr.__proto__);
// console.log(arr.__proto__ === Array.prototype);

// This is how we can add a method to the prototype of an array
Array.prototype.unique = function () {
  return [...new Set(this)];
}
console.log(arr.unique());

let str = new String('Jonas');
let num = 2037;
const num2 = 2037;
console.log(str.toUpperCase());

*/
/*
Coding Challenge #21 | JavaScript 🔥
Your tasks:
1. Use a constructor function to implement a 'Car'. A car has a 'make' and a
'speed' property. The 'speed' property is the current speed of the car in
km/h

2. Implement an 'accelerate' method that will increase the car's speed by 10,
and log the new speed to the console.

3. Implement a 'brake' method that will decrease the car's speed by 5,
and log the new speed to the console.

4. Create 2 'Car' objects and experiment with calling 'accelerate' and
'brake' multiple times on each of them.

Test data:
✅ Data car 1: 'BMW' going at 120 km/h
✅ Data car 2: 'Mercedes' going at 95 km/h


function Car(make, speed) {
  this.make = make;
  this.speed = speed;
}
Car.prototype.accelerate = function () {
  this.speed += 10;
  console.log(`${this.make} is going at ${this.speed} km/h`);
}
Car.prototype.brake = function () {
  this.speed -= 5;
  console.log(`${this.make} is going at ${this.speed} km/h`);
}

const bmw = new Car('BMW', 120);
const mercedes = new Car('Mercedes', 95);
bmw.accelerate();
bmw.accelerate();
bmw.brake();
bmw.accelerate();
mercedes.accelerate();
mercedes.accelerate();
mercedes.brake();
 */
/*
ES6 Classes


// class declaration
class Person {

  constructor(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;
  }

  // Methods will be added to .prototype property
  calcAge() {
    console.log(2037 - this.birthYear);
  }

  greet() {
    console.log(`Hey ${this.firstName}`);
  }
}

// This is the same as the constructor function
// Person.prototype.greet = function () {
//   console.log(`Hey ${this.firstName}`);
// }

// const jessica = new Person('Jessica', 1996);
// jessica.calcAge();
// jessica.greet();
// console.log(jessica);

// 1. Classes are NOT hoisted
// 2. Classes are first-class citizens (that we can pass them into functions and return them from functions)
// 3. Classes are executed in strict mode

// Getters and Setters
// const account = {
//   owner: 'jonas',
//   movements: [200, 530, 120, 300],
//
//   get latest() {
//     return this.movements.slice(-1).pop();
//   },
//
//   set latest(mov) {
//     this.movements.push(mov);
//   }
// }
//
// console.log(account.latest);
// account.latest = 50;
// console.log(account.movements);
 */
/*
 Getters and Setters in Classes

// class expression
const Person2 = class {
  constructor(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;
  }

  calcAge() {
    console.log(2037 - this.birthYear);
  }

  get firstName() {
    return this._firstName;
  }

  set firstName(name){
    this._firstName = name;
  }

}

const jessica = new Person2('Jessica', 1996);
jessica.calcAge();
jessica.firstName = 'asdasdasd';
console.log(jessica.firstName);
 */
/*
Static Methods in Classes

const Person = class {
  constructor(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;
  }

  // Static method is a method that is not available
  // in the instances of the class
  // It's a method that is attached to the constructor function
  static hey() {
    console.log('Hello there');
  }
}

//Another way to define a static method
Person.hey2 = function () {
  console.log('Hello there');
}
Person.hey();
Person.hey2();
 */
/*
Object.create() method

const PersonProto = {
  calcAge() {
    console.log(2037 - this.birthYear);
  },

  init(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;
  }
}
// Object.create() is a method in JavaScript that creates a new object,
// using an existing object as the prototype of the newly created object.
const steven = Object.create(PersonProto);
steven.init('Steven', 1991);
steven.calcAge();
 */
/*
 LECTURE: 204 Coding Challenge #22 | JavaScript 🔥


 Coding Challenge #22 | JavaScript 🔥
 Your tasks:
 1. Re-create Challenge #1, but this time using an ES6 class (call it 'CarCl')

 2. Add a getter called 'speedUS' which returns the current speed in mi/h (divide by 1.6)

 3. Add a setter called 'speedUS' which sets the current speed in mi/h (but
 converts it to km/h before storing the value, by multiplying the input by 1.6)

 4. Create a new car and experiment with the 'accelerate' and 'brake'
 methods, and with the getter and setter.

 Test data:
 Data car 1: 'Ford' going at 120 km/h



const CarCl = class {

  constructor(make, speed) {
    this.make = make;
    this.speed = speed;
  }

  accelerate() {
    this.speed += 10;
    console.log(`${this.make} is going at ${this.speed} km/h`);
  }

  brake() {
    this.speed -= 5;
    console.log(`${this.make} is going at ${this.speed} km/h`);
  }

  get speedUS() {
    return this.speed / 1.6;
  }

  set speedUS(speed) {
    this.speed = speed * 1.6;
  }
}

const ford = new CarCl('Ford', 120);
console.log(ford.speedUS);
ford.accelerate();
ford.accelerate();
ford.brake();
ford.speedUS = 50;
console.log(ford);
console.log(ford.speedUS);
 */
/*
Inheritance Between "Classes": Constructor Functions

const Person = function (firstName, birthYear) {
  this.firstName = firstName;
  this.birthYear = birthYear;
}

Person.prototype.calcAge = function () {
  console.log(2037 - this.birthYear);
}

const Student = function (firstName, birthYear, course) {
  // this.firstName = firstName;
  // this.birthYear = birthYear;
  Person.call(this, firstName, birthYear);
  this.course = course;
}

// Linking prototypes. This will go into the Student.property
// object and will override the prototype property with is Object.prototype to the Person.prototype
Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;

Student.prototype.introduce = function () {
  console.log(`My name is ${this.firstName} and I study ${this.course}`);
}

const mike = new Student('Mike', 2020, 'Computer Science');
mike.introduce();
mike.calcAge();
 */
/*
Coding Challenge #23 | JavaScript 🔥
  Your tasks:

  1. Use a constructor function to implement an Electric Car (called 'EV')
  as a child "class" of 'Car'. Besides a make and current speed, the 'EV'
  also has the current battery charge in % ('charge' property)

  2. Implement a 'chargeBattery' method which takes an argument 'chargeTo'
  and sets the battery charge to 'chargeTo'

  3. Implement an 'accelerate' method that will increase the car's speed by 20,
  and decrease the charge by 1%. Then log a message like this: 'Tesla going at 140 km/h,
  with a charge of 22%'

  4. Create an electric car object and experiment with calling 'accelerate', 'brake'
  and 'chargeBattery' (charge to 90%). Notice what happens when you 'accelerate'!
  Hint: Review the definiton of polymorphism 😉

  Test data:
  Data car 1: 'Tesla' going at 120 km/h, with a charge of 23%


const Car = function (make, speed) {
  this.make = make;
  this.speed = speed;
}

Car.prototype.accelerate = function () {
  this.speed += 10;
  console.log(`${this.make} is going at ${this.speed} km/h`);
}

Car.prototype.brake = function () {
  this.speed -= 5;
  console.log(`${this.make} is going at ${this.speed} km/h`);
}

const EV = function (make, speed, charge) {
  Car.call(this, make, speed);
  this.charge = charge;
}

EV.prototype = Object.create(Car.prototype);

EV.prototype.chargeBattery = function (chargeTo) {
  this.charge = chargeTo;
}

EV.prototype.accelerate = function () {
  this.speed += 20;
  this.charge--;
  console.log(`${this.make} is going at ${this.speed} km/h, with a charge of ${this.charge}%`);
}

const tesla = new EV('Tesla', 120, 23);
tesla.accelerate();
tesla.brake();
*/
/*
Inheritance Between "Classes": ES6 Classes

const Person = class {
  constructor(fullName, birthYear) {
    this.fullName = fullName;
    this.birthYear = birthYear;
  }

  calcAge() {
    console.log(2037 - this.birthYear);
  }

  greet() {
    console.log(`Hey ${this.fullName}`);
  }

  get age() {
    return 2037 - this.birthYear;
  }

  set fullName(name) {
    if (name.includes(' ')) this._fullName = name;
    else alert(`${name} is not a full name!`);
  }

  get fullName() {
    return this._fullName;
  }
}
const Student2 = class extends Person{
  // We don't need to call the constructor function of the parent class
  // because it will be called automatically
};
const Student = class extends Person {
  constructor(fullName, birthYear, course) {
    // Always needs to happen first!
    super(fullName, birthYear);
    this.course = course;
  }

  introduce() {
    console.log(`My name is ${this.fullName} and I study ${this.course}`);
  }

  calcAge() {
    console.log(`I'm ${2037 - this.birthYear} years old, but as a student I feel like ${2037 - this.birthYear + 10}`);
  }
}

const mike = new Student('Mike Smith', 2020, 'Computer Science');
mike.introduce();
mike.calcAge();

const mike2 = new Student2('Mike Smith', 2020);
mike2.greet();

 */
/*
Inheritance Between "Classes": Object.create()

const PersonProto = {
  calcAge() {
    console.log(2037 - this.birthYear);
  },

  init(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;
  }
}

const steven = Object.create(PersonProto);

const StudentProto = Object.create(PersonProto);
StudentProto.init = function (firstName, birthYear, course) {
  PersonProto.init.call(this, firstName, birthYear);
  this.course = course;
}

StudentProto.introduce = function () {
  console.log(`My name is ${this.firstName} and I study ${this.course}`);
}

const jay = Object.create(StudentProto);
jay.init('Jay', 2010 , 'Computer Science');
jay.calcAge();
jay.introduce();
console.log(jay);
 */
/*
Encapsulation: Protected Properties and Methods

// the _ is a convention to show that this property is protected
// It's not a real protection, but it's a convention
const Account = class {
  constructor(owner, currency, pin) {
    this.owner = owner;
    this.currency = currency;
    // Protected property
    this._pin = pin;
    // Protected property
    this._movements = [];

    console.log(`Thanks for opening an account, ${owner}`);
  }

  get movements() {
    return this._movements;
  }

  get pin() {
    return this._pin;
  }

  deposit(val) {
    this._movements.push(val);
  }

  withdraw(val) {
    this.deposit(-val);
  }

  _approveLoan(val) {
    return true;
  }

  requestLoan(val) {
    if (this._approveLoan(val)) {
      this.deposit(val);
      console.log('Loan approved');
    }
  }
}

const acc1 = new Account('Jonas', 'EUR', 1111);
acc1.deposit(250);
acc1.withdraw(140);
acc1.requestLoan(1000);
console.log(acc1.movements);
console.log(acc1.pin);
 */
/*
Encapsulation: Private Class Fields and Methods

// Not yet supported ( stage 3 )
// It's a proposal for a new feature in JavaScript , and its not yet implemented in all the browsers
const Account = class {

  // Private fields (instances)
  #movements = [];
  #pin;

  constructor(owner, currency, pin) {
    this.owner = owner;
    this.currency = currency;
    this.#pin = pin;
    console.log(`Thanks for opening an account, ${owner}`);
  }

  // Public methods
  getMovements() {
    return this.#movements;
  }

  deposit(val) {
    this.#movements.push(val);
    return this;
  }

  withdraw(val) {
    this.deposit(-val);
    return this;
  }

  // Private methods
  #approveLoan(val) {
    return true;
  }

  requestLoan(val) {
    if (this.#approveLoan(val)) {
      this.deposit(val);
      console.log('Loan approved');
      return this;
    }
  }
}

const acc1 = new Account('Jonas', 'EUR', 1111);
// acc1.#movements.push(250); // This will not work because #movements is private
acc1.deposit(250);

 */
/*
Chaining Methods

const Account = class {

  // Private fields (instances)
  #movements = [];
  #pin;

  constructor(owner, currency, pin) {
    this.owner = owner;
    this.currency = currency;
    this.#pin = pin;
    console.log(`Thanks for opening an account, ${owner}`);
  }

  // Public methods
  getMovements() {
    return this.#movements;
  }

  deposit(val) {
    this.#movements.push(val);
    return this;
  }

  withdraw(val) {
    this.deposit(-val);
    return this;
  }

  // Private methods
  #approveLoan(val) {
    return true;
  }

  requestLoan(val) {
    if (this.#approveLoan(val)) {
      this.deposit(val);
      console.log('Loan approved');
      return this;
    }
  }
}

const acc1 = new Account('Jonas', 'EUR', 1111);
acc1.deposit(250)
  .deposit(140)
  .withdraw(75)
  .requestLoan(1000)
  .withdraw(10);

 */

