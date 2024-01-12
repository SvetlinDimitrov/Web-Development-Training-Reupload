function solve(arr){
    let answer =[];
    arr.sort((f,s)=> f-s);
    let index =0;
    while(arr.length !=0){
        if(index % 2 == 0){
            answer.push(arr.shift());
        }else{
            answer.push(arr.pop());
        }
        index++;
    }
    return answer;
}
solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);