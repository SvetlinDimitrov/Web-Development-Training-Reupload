/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let i = 0;
    for (let j = 0; j < nums.length; j++) {
        if (nums[j] === val) {
            nums.splice(j , 1);
            i++;
            j--;
        }
    }
    console.log(nums , i);
    return i;
};

removeElement([0,1,2,2,3,0,4,2] ,2); // [0,1,4,0,3]