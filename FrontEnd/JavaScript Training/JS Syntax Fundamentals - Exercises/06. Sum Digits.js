function solve(num){
    let answer = 0;
    while(num != 0){
        let lastNum = num % 10;
        num/=10;
        answer+=lastNum
        answer = Math.floor(answer);
    }
    console.log(answer);
}
solve(245678);