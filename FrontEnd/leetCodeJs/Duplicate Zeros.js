/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify arr in-place instead.
 */
var duplicateZeros = function(arr) {
    let answer = [];
    for (let i = 0; i < arr.length; i++) {
        if(arr[i] === 0){
            answer.push(0);
            answer.push(0);
            i++;
        }else{
            answer.push(arr[i]);
        }
    }
};