function solve(num){
    let arr = [];
    for (let index = 0; index < num; index+=10) {
        arr.push("%");
    }
    for(let index = arr.length ; index < 10 ; index++ ){
        arr.push(".");
    }
    return num === 100 ? "100% Complete!" :
    `${num}% [${arr.join("")}]` + `\nStill loading...`;
}
console.log(solve(50));