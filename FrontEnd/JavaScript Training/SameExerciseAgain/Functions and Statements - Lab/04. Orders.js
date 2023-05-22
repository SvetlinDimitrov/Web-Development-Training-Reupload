function solve(word , times){
    let storage  = {
        water : 1.00,
        coffee :1.50,
        coke : 1.40,
        snacks : 2.00
    }
    return (storage[word] * times).toFixed(2);
}
console.log(solve("water" , 2));