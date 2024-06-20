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