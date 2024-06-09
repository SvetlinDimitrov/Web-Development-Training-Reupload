/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    nums1.splice(m , nums1.length);
    nums2.splice(0 , n)
        .forEach(num => {
            nums1.push(num);
        })
    nums1.sort((a, b) => a - b);
};

//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]

console.log(merge([1,2,3,0,0,0], 3, [2,5,6], 3));