/**
 * @param {number[]} nums
 * @return {number}
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
var findNumbers = function(nums) {
    let i = 0;
    let a = 0;
    while (i < nums.length){
        if(nums[i++].toString().length % 2 === 0 ) a++;
    }
    return a;
};
console.log(findNumbers([12,345,2,6,7896]))