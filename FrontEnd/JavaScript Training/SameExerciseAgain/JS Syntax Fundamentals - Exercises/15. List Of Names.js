function solve (arr){
    arr.sort((a,b) => a.localeCompare(b))
    .map((word , index) => console.log(`${index+1}.${word}`));
}
solve(["John", "Bob", "Christina", "Ema"])