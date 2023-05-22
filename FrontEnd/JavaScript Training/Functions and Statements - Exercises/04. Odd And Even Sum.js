let solve = (num) =>{
    let arr = num.toString().split("").map(e=>Number(e));
    let sum1 = arr.filter(e=> e %2 === 0).reduce((a,b) => a+b);
    let sum2 = arr.filter(e=> e %2 !== 0).reduce((a,b) => a+b);
    return `Odd sum = ${sum2}, Even sum = ${sum1}`;
}
console.log(solve(1231556));