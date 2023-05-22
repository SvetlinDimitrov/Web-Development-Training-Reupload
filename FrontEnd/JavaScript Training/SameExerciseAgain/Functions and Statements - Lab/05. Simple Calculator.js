function solve(num1 , num2 , operation){
    let storage  = {
        multiply : (a,b)=> a*b,
        divide :(a,b) => a/b,
        add : (a,b) => a+b,
        subtract : (a,b) =>a-b
    }
    return storage[operation](num1 , num2);
}
console.log(solve(2,3,"add"));