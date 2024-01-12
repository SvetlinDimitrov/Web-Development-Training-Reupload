function search() {
   let wordToSearch = document.getElementById(`searchText`).value;
   let arrNames = Array.from(document.getElementById(`towns`).children);
   let count = 0;
   
   for (let i = 0 ; i < arrNames.length ; i++) {
      arrNames[i].style.fontWeight = "normal";
      arrNames[i].style.textDecoration = "none"

      if(arrNames[i].textContent.includes(wordToSearch)){
         count++;
         arrNames[i].style.fontWeight = "bold";
         arrNames[i].style.textDecoration = "underline";
      }
   }
   document.getElementById(`result`).textContent = `${count} matches found`;
}
