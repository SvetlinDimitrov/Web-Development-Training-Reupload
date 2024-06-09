/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let a = 0;
    let sum = 0;
    for (let j = 0; j < nums.length; j++) {
        if(nums[j] === 0) sum = 0;
        else sum ++;
        a = Math.max(a , sum);
    }

    return a;
};

console.log(findMaxConsecutiveOnes([1,1,0,1])) // 2
console.log(findMaxConsecutiveOnes([1,1,0,1,1,1])) // 3