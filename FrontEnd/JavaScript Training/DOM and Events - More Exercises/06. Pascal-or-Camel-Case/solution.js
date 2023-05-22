function solve() {
  let firstInput = document.getElementById(`text`);
  let convention = document.getElementById(`naming-convention`);
  let result = document.getElementById(`result`);

  let arr = firstInput.value.split(" ");
  
  if(convention.value === "Pascal Case" || convention.value === "Camel Case"){
    for(let i = 0 ; i < arr.length ; i++){
      let word = arr[i].toLowerCase();
      if(convention.value === "Camel Case" && i === 0){
        result.textContent += word;
      }else{
        word = word.replace(word.charAt(0),word.charAt(0).toUpperCase());
        result.textContent += word;
      }
    }
  }else{
    result.textContent = "Error!";
  }
}