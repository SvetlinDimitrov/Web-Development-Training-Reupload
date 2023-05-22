function addItem() {
    let input1 = document.getElementById(`newItemText`);
    let input2 = document.getElementById(`newItemValue`);
    let select = document.getElementById(`menu`);
    let option = document.createElement(`option`);
    option.value = input1.value +input2.value;
    option.textContent = input1.value +" "+input2.value;
    select.appendChild(option);
    input1.value =' ';
    input2.value = ' ';
}