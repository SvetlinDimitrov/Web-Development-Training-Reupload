let solve = (num) => {
    let arr = [];
    for(let i = 1 ; i <= num/2 ; i++){
        arr.push(i);
    }
    let answer = arr
    .filter(e=> num % e === 0)
    .reduce((f,s) => f+s,0);
    return num === answer ? "We have a perfect number!" : "It's not so perfect.";
}
console.log(solve(6));