function addItem() {
    let input = document.getElementById("newItemText");
    let newLi = document.createElement("li")
    newLi.textContent = input.value;
  

    let hrefToAdd = document.createElement("a")
    hrefToAdd.textContent = '[Delete]';
    hrefToAdd.href = "#";
    hrefToAdd.addEventListener('click' , handler);
    function handler(){
        newLi.remove();
    }

    newLi.appendChild(hrefToAdd);
    document.getElementById("items").appendChild(newLi);
    
    input.value = '';

}