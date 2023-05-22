function solve(fruit , grams , money){
    console.log(`I need $${((grams/1000)*money).toFixed(2)} to buy ${(grams/1000).toFixed(2)} kilograms ${fruit}.`);
}
solve('orange', 2500, 1.80);