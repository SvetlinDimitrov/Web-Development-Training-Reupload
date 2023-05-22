function solve() {
  let input = document.getElementById(`input`);
  let outPut = document.getElementById(`output`);
  let arr = input.value.split('.');
  let newP = document.createElement(`p`);
 
  for(let i = 0 ; i < arr.length -1 ; i++){
    if(i % 3 === 0){
      newP = document.createElement(`p`);
      outPut.appendChild(newP);
    }
    newP.textContent +=arr[i]+".";
  }
  input.value = '';
;}