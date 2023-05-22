function addItem() {
    let input = document.getElementById("newItemText");
    let newLI = document.createElement("li");
    newLI.textContent = input.value;
    document.getElementById("items").appendChild(newLI);
    input.value = '';
}