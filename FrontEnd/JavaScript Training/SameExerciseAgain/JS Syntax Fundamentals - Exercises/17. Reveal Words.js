function solve(word1 , word2){
    let arr = word1.split(", ");
    for(let word of arr){
        let wordToReplace ="";
        for(let i = 0 ; i < word.length ; i++){
            wordToReplace+="*";
        }
        word2 = word2.replace(wordToReplace , word)
    }
    console.log(word2);
}
solve('great, learning',
'softuni is ***** place for ******** new programming languages'
)
