function calc() {
    let input1 = document.getElementsByTagName(`input`)[0].value;
    let input2 = document.getElementsByTagName(`input`)[1].value;
    
    let input3 = document.getElementsByTagName(`input`)[2];
    input3.value = Number(input1) + Number(input2);
}


