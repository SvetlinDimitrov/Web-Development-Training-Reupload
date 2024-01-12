function solve(arr , num){
    for (let index = 0; index < num; index++) {
        let save = arr.shift();
        arr.push(save);
    }
    console.log(arr.join(" "));
}
solve([51, 47, 32, 61, 21], 2);
