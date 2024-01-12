function extract(content) {
    let text = document.getElementById(content).textContent;
    let start =0;
    let arr = [];
    for(let i =0 ; i < text.length; i++){
        if(text.charAt(i) == '('){
            start = i;
        }
        if(text.charAt(i) == ')'){
          arr.push(text.substring(start , i+1));  
        }
    }
   return `${arr.join("; ")}`;
}