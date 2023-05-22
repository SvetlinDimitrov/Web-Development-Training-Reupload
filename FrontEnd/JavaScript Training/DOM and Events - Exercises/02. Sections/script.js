function create(words) {
   for (const word of words) {
      let divElement = document.createElement('div');
      let pElement = document.createElement(`p`);
      pElement.textContent = word;
      pElement.style.display = 'none';
      divElement.appendChild(pElement);
      divElement.addEventListener('click' , handel)
      document.getElementById(`content`).appendChild(divElement);
      function handel(){ 
         this.children[0].style.display =``;
      }
   }
}