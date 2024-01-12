function solve(word1 , word2){
    word1 = word1.toLowerCase();
    word2 = word2.toLowerCase();
    if(word2.includes(word1)){
        console.log(word1);
    }else{
        console.log(word1 + " not found!");
    }
}
solve('javascript',
'JavaScript is the best programming language')
solve('python',
'JavaScript is the best programming language')