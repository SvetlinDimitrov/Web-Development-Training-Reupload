function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);
   let input = document.getElementsByTagName(`textarea`)[0];
   
   function onClick () {
      console.log(input.value.split(/["]?[a-zA-z1-9]["]?/)[0]);
      
   }
}