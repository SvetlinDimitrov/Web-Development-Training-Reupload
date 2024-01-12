let sum = (a ,b) => a=== 0 ? a+b : sum(a-1,b);
console.log(sum(10,9) + sum (10,10));


