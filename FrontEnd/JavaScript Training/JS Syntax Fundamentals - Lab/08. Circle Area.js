function solve(num){
    if(typeof(num) === 'number'){
        console.log(`${(num*num*3.14159).toFixed(2)}`);
    }else{
        console.log(`We can not calculate the circle area, because we receive a ${typeof(num)}.`);
    }
    
}
solve(5);
solve([1,23]);
