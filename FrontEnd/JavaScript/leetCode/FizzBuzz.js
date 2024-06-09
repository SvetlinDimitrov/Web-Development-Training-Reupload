/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
    const answer = [];
    let i = 1;
    while (++i < n){
        if(i % 3 === 0 && i % 5 === 0) answer.push("FizzBuzz")
        else if (i % 3 === 0) answer.push("Fizz")
        else if (i % 5 === 0) answer.push("Buzz")
        else answer.push(i.toString())
    }
    return answer;
};