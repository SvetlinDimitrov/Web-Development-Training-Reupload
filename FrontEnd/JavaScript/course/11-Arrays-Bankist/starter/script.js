'use strict';

/*
SLICE , SPLICE , REVERSE , CONCAT , JOIN
let arr = ['a', 'b', 'c', 'd', 'e'];
console.log(`original array :${arr}`);
// slice method
// slice does not change the original array
// the default value of the second argument is the length of the array
// console.log(arr.slice(2));
// the second index is not included
// console.log(arr.slice(2 ,4));
// we can start with a negative index
// console.log(arr.slice(-2));
// we can use the negative as a start and end . It willl exclude exlude the last element
// console.log(arr.slice(-2, -1));
// we can use the positive start and negative end . It will exclude the last two elements
// console.log(arr.slice(0 , -2));
// we can use the slice to create a shallow copy of the array
// console.log(arr.slice());
// another way to create a shadow copy is to use the spread operator
// console.log([...arr]);


// splice method
// splice changes the original array
// console.log(arr.splice(2));
// removing the last element
// console.log(arr.splice(-1));
// the second argument is the number of elements to remove
// console.log(arr.splice(1, 2 ));
// we can add elements to the array using the splice method after the second argument
// the second argument is the number of elements to remove adn after that we will add the elements
// console.log(arr.splice(1, 2, 'x', 'y'));
// changing an element at a specific index
// console.log(arr.splice(0, 1, 'x'));


// reverse method
// changes the original array : it reverses the array
// console.log(arr.reverse());


// concat method
// does not change the original array : it concatenates two arrays
// let arr2 = ['f', 'g', 'h'];
// console.log(arr.concat(arr2));
// we can also use the spread operator to concatenate two arrays
// console.log([...arr, ...arr2]);


// join method
// does not change the original array : it joins the elements of the array into a string
// console.log(arr.join(' - '));
console.log(`modified array :${arr}`);
 */
/*
AT
const arr = [17, 21, 23];
// console.log(arr[0]);
// console.log(arr.at(0));
//getting the last element of the array
console.log(arr[arr.length - 1]);
console.log(arr.at(-1))
console.log("Hello There".at(1));
 */
/*
ForEach

const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// for (const movement of movements) {
//     if (movement > 0) {
//         console.log(`You deposited ${movement}`);
//     } else {
//         console.log(`You withdrew ${Math.abs(movement)}`);
//     }
// }

movements.forEach(function (element , i , arr) {
    if (element > 0) {
        console.log(`Movements ${i} :You deposited ${element}`);
    } else {
        console.log(`Movements ${i} :You withdrew ${Math.abs(element)}`);
    }
  console.log(arr);
});
 */

/*
Coding Challenge #20 | JavaScript 🔥 | Lecture 157
Julia and Kate are still studying dogs, and this time they are studying if dogs are eating too much or too little. Eating too much means the dog's current food portion is larger than the recommended portion, and eating too little is the opposite. Eating an okay amount means the dog's current food portion is within a range 10% above and 10% below the recommended portion (see hint).

Your tasks:
1. Loop over the 'dogs' array containing dog objects, and for each dog, calculate the recommended food portion and add it to the object as a new property.
Do not create a new array, simply loop over the array. Forumla:
recommendedFood = weight ** 0.75 * 28. (The result is in grams of food, and the weight needs to be in kg)

2. Find Sarah's dog and log to the console whether it's eating too much or too little.
Hint: Some dogs have multiple owners, so you first need to find Sarah in the owners array, and so this one is a bit tricky (on purpose) 🤓

3. Create an array containing all owners of dogs who eat too much
('ownersEatTooMuch') and an array with all owners of dogs who eat too little ('ownersEatTooLittle').

4. Log a string to the console for each array created in 3., like this: "Matilda and Alice and Bob's dogs eat too much!" and "Sarah and John and Michael's dogs eat too little!"

5. Log to the console whether there is any dog eating exactly the amount of food that is recommended (just true or false)

6. Log to the console whether there is any dog eating an okay amount of food (just true or false)

7. Create an array containing the dogs that are eating an okay amount of food (try to reuse the condition used in 6.)

8. Create a shallow copy of the 'dogs' array and sort it by recommended food portion in an ascending order (keep in mind that the portions are inside the array's objects 😉)

Hints:
1) Use many different tools to solve these challenges, you can use the summary lecture to choose between them 😉
2) Being within a range 10% above and below the recommended portion means: current ▶(recommended * 0.90) && current  ◀(recommended *
1.10). Basically, the current portion should be between 90% and 110% of the recommended portion.

Test data:
const dogs = [
{ weight: 22, curFood: 250, owners: ['Alice', 'Bob'] },
{ weight: 8, curFood: 200, owners: ['Matilda'] },
{ weight: 13, curFood: 275, owners: ['Sarah', 'John'] },
{ weight: 32, curFood: 340, owners: ['Michael'] },
];

const dogs = [
  { weight: 22, curFood: 250, owners: ['Alice', 'Bob'] },
  { weight: 8, curFood: 200, owners: ['Matilda'] },
  { weight: 13, curFood: 275, owners: ['Sarah', 'John'] },
  { weight: 32, curFood: 340, owners: ['Michael'] }
];

// 1
dogs.forEach(dog => dog.recommendedFood = dog.weight ** 0.75 * 28);

//2
let dog = dogs.find(dog => dog.owners.includes('Sarah'));
console.log(dog.curFood > dog.recommendedFood ? 'Sarah dog is eating to much' : 'Sarah dog is eating little');

//3
const ownersEatTooMuch = dogs
  .filter(dog => dog.curFood > dog.recommendedFood)
  .flatMap(dog => dog.owners);

const ownersEatTooLittle = dogs
  .filter(dog => dog.curFood < dog.recommendedFood)
  .flatMap(dog => dog.owners);


//4
console.log(`${ownersEatTooMuch.join(' and ')} dogs eat too much! and ${ownersEatTooLittle.join(' and ')} dogs eat too little!`);

//5
console.log(dogs.some(dog => dog.curFood === dog.recommendedFood.toFixed(0)));

//6
console.log(dogs.some(dog => dog.curFood > (dog.recommendedFood * 0.90) && dog.curFood < (dog.recommendedFood * 1.10)));

//7
const dogsEatingOKey = dogs.filter(dog => dog.curFood > (dog.recommendedFood * 0.90) && dog.curFood < (dog.recommendedFood * 1.10));
console.log(dogsEatingOKey)

//8
console.log(
  [...dogs].sort((a ,b) => a.recommendedFood - b.recommendedFood)
)
*/