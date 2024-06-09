/**
 * @param {number[]} nums
 * @return {number[]}
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
var sortedSquares = function(nums) {
    const answer = [];
    for (let i = 0; i < nums.length; i++) {
        answer.push(nums[i] * nums[i])
    }
    return answer.sort((a , b) => a- b)
};

console.log(sortedSquares([-4,-1,0,3,10]))