function solve(num){
    let prevNum = num %10;
    let answer = 0;
    let boolean = true;
    while(num !=0){
        if(prevNum != num %10){
            boolean = false;
        }
        prevNum = num % 10;
        
        answer+=prevNum;
        num = Math.floor(num/=10);

    }
    console.log(boolean);
    console.log(answer);
}