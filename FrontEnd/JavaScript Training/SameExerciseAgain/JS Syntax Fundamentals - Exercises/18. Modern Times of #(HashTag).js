function solve(word){
    let valid = false;
    let wordToCopy = "";
    let array = [];


    for (let index = 0; index < word.length; index++) {
        if(valid){
            if(word.charAt(index) === " "){
                valid = false;
                if(!onlyLetters(wordToCopy)){
                    array.push(wordToCopy);
                }
                wordToCopy="";
            }else{
                wordToCopy+=word.charAt(index);
            }
        }
        if(word.charAt(index) === "#"){
            valid = true;
        }
    }
    if(wordToCopy.length !=0 && !onlyLetters(wordToCopy)){
        array.push(wordToCopy);
    }
    array.map(word=> console.log(word));




    function onlyLetters(word){
        for (let index = 0; index < word.length; index++) {
            if(!isCharDigit(word.charAt(index))){
                return false;
            }  
        }
        return true;
        function isCharDigit(n){
            return !!n.trim() && n*0==0;
          }
    }
}
solve('The symbol # is known #variously in English-speaking #regions as the #number sign')