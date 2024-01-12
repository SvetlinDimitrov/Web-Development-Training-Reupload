function solve(char1 , char2){
    let a =char1.charCodeAt(0);
    let b =char2.charCodeAt(0);
    let answer =  [];
    for(let i = Math.min(a,b)+1 ; i < Math.max(a,b); i++){
        answer.push(String.fromCharCode(i));
    }
    console.log(answer.join(" "));
}
solve('a',
'd')
