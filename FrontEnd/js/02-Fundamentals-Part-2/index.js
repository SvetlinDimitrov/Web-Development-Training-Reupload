/*
Coding Challenge #1
Mark and John are trying to compare their BMI (Body Mass Index), which is calculated using the formula: BMI = mass / height ** 2 = mass / (height * height). (mass in kg and height in meter).

1. Store Mark's and John's mass and height in variables
2. Calculate both their BMIs using the formula (you can even implement both versions)
3. Create a boolean variable 'markHigherBMI' containing information about whether Mark has a higher BMI than John.

TEST DATA 1: Marks weights 78 kg and is 1.69 m tall. John weights 92 kg and is 1.95 m tall.
TEST DATA 2: Marks weights 95 kg and is 1.88 m tall. John weights 85 kg and is 1.76 m tall.

GOOD LUCK 😀

const markWeight = 78;
const johnWeight = 92;

const markHeight = 1.69;
const johnHeight = 1.95;

const markBMI = markWeight / markHeight ** 2;
const johnBMI = johnWeight / johnHeight ** 2;

const markHigherBMI = markBMI > johnBMI;
console.log(markHigherBMI)
*/

/*
Coding Challenge #2
Use the BMI example from Challenge #1, and the code you already wrote, and improve it:

1. Print a nice output to the console, saying who has the higher BMI. The message can be either "Mark's BMI is higher than John's!" or "John's BMI is higher than Mark's!"
2. Use a template literal to include the BMI values in the outputs. Example: "Mark's BMI (28.3) is higher than John's (23.9)!"

HINT: Use an if/else statement 😉

GOOD LUCK 😀


const markWeight = 78;
const johnWeight = 92;

const markHeight = 1.69;
const johnHeight = 1.95;

const markBMI = markWeight / markHeight ** 2;
const johnBMI = johnWeight / johnHeight ** 2;

if( markBMI > johnBMI){
    console.log(`Mark's BMI ${markBMI.toFixed(2)} is higher than John's!`)
}else{
    console.log(`John's BMI ${johnBMI.toFixed(2)} is higher than Mark's!`)
}
*/

/*
Coding Challenge #3 |  JavaScript 🔥
There are two gymnastics teams, Dolphins and Koalas. They compete against each other 3 times.
 The winner with the highest average score wins a trophy!

Your tasks:
1. Calculate the average score for each team, using the test data below

2. Compare the team's average scores to determine the winner of the competition,
 and print it to the console. Don't forget that there can be a draw,
  so test for that as well (draw means they have the same average score)

3. Bonus 1: Include a requirement for a minimum score of 100. With this rule,
 a team only wins if it has a higher score than the other team,
  and the same time a score of at least 100 points.
Hint: Use a logical operator to test for a minimum score, as well as multiple else-if blocks 😉

4. Bonus 2: Minimum score also applies to a draw!
 So a draw only happens when both teams have the same score and both have a score greater
  or equal 100 points. Otherwise, no team wins the trophy

Test data:
Data 1: Dolphins score 96, 108 and 89. Koalas score 88, 91 and 110
Data Bonus 1: Dolphins score 97, 112 and 101. Koalas score 109, 95 and 123
Data Bonus 2: Dolphins score 97, 112 and 101. Koalas score 109, 95 and 106


const dolphinsAvgScore = (97 + 112 + 101) / 3;
const koalasAvgScore = (109 + 109 + 106) / 3;
const minScore = 100;

if(dolphinsAvgScore > koalasAvgScore && dolphinsAvgScore >= minScore){
    console.log(`Dolphins win with an average score of ${dolphinsAvgScore}`)
}else if(dolphinsAvgScore === koalasAvgScore && dolphinsAvgScore >= minScore){
    console.log(`It's a draw! Both teams have an average score of ${dolphinsAvgScore}`)
}else if(koalasAvgScore > dolphinsAvgScore && koalasAvgScore >= minScore){
    console.log(`Koalas win with an average score of ${koalasAvgScore}`)
}else{
    console.log(`No team wins the trophy!`)
}
 */

/*
Coding Challenge #6 | JavaScript 🔥 | Lecture 038
Steven is still building his tip calculator, using the same rules as before:
Tip 15% of the bill if the bill value is between 50 and 300, and if the value is different, the tip is 20%.

Your tasks:
1. Write a function 'calcTip' that takes any bill value as an input and returns the corresponding tip,
 calculated based on the rules above (you can check out the code from first tip calculator challenge if you need to).
  Use the function type you like the most. Test the function using a bill value of 100
2. And now let's use arrays! So create an array 'bills' containing the test data below
3. Create an array 'tips' containing the tip value for each bill, calculated from the function you created before
4. Bonus: Create an array 'total' containing the total values, so the bill + tip

Test data: 125, 555 and 44


const calcTip = (bill) => {
    return bill >= 50 && bill <= 300 ? bill * 0.15 : bill * 0.20;
}

const bills = [125, 555, 44];
const tips = [calcTip(bills[0]), calcTip(bills[1]), calcTip(bills[2])];
const total = [bills[0] + tips[0], bills[1] + tips[1], bills[2] + tips[2]];

console.log(tips, total)
 */

/*
Coding Challenge #7 | JavaScript 🔥 | Lecture 042
Let's go back to Mark and John comparing their BMIs! This time, let's use objects to implement the calculations!
 Remember: BMI = mass / height ** 2 = mass / (height * height) (mass in kg and height in meter)

Your tasks:
1. For each of them, create an object with properties for their full name, mass, and height (Mark Miller and John Smith)
2. Create a 'calcBMI' method on each object to calculate the BMI (the same
method on both objects). Store the BMI value to a property, and also return it
from the method
3. Log to the console who has the higher BMI, together with the full name and the respective BMI. Example: "John's BMI (28.3) is higher than Mark's (23.9)!"

Test data: Marks weights 78 kg and is 1.69 m tall. John weights 92 kg and is 1.95 m tall.

GOOD LUCK 😀


const mark = {
   fullName: 'Mark Miller',
   mass: 78,
   height: 1.69,
   calcBMI: function () {
       if(this.bmi) return this.bmi;
       this.bmi = this.mass / this.height ** 2;
       return this.bmi;
   }
}
const john = {
    fullName: 'John Smith',
    mass: 92,
    height: 1.95,
    calcBMI: function () {
        if(this.bmi) return this.bmi;
        this.bmi = this.mass / this.height ** 2;
        return this.bmi;
    }
}

if(mark.calcBMI() > john.calcBMI()){
    console.log(`${mark.fullName} (${mark.calcBMI()}) is higher than ${john.fullName} (${john.calcBMI()})`)
}else{
    console.log(`${john.fullName} (${john.calcBMI()}) is higher than ${mark.fullName} (${mark.calcBMI()})`)
}
 */
