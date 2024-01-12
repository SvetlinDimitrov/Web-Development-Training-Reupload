function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let input = document.getElementById("searchField");
      let allTr = document.querySelectorAll(`tbody > tr`);
      for (const tr of allTr) {
         
         if(tr.classList.contains(`select`)){
            tr.classList.remove(`select`);
         }
      
         for (const child of tr.children) {
            if(child.textContent.includes(input.value)){
               tr.classList.add(`select`);
               break;
            }
         }
         
      }
      input.value = '';
   }
}