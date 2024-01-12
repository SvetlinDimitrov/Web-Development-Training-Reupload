function solve(array){
    let answer = 0;
    for (let i = 0; i < array.length; i++) {
        if(array[i] % 2 != 0){answer-=array[i];}
        else{answer+=array[i];}
    }
    console.log(answer);
}
solve([1,3,5]);