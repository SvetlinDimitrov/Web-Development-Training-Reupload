function generateReport() {
    let arrTR = document.querySelectorAll('tbody > tr');
    let arrInputValue = document.getElementsByTagName(`th`);
    let arrChecked = [];
    
    for (const th of arrInputValue) {
        if(th.children[0].checked){
            arrChecked.push(true);
        }else{
            arrChecked.push(false);
        }
    }

    let answer = [];
    let obj = {};

    for(let i = 0 ; i < arrTR.length ; i++){
        
        if(arrChecked[0]){
            obj[arrInputValue[0].textContent] = arrTR[i].children[0].textContent;
        }
        if(arrChecked[1]){
            obj[arrInputValue[1].textContent] = arrTR[i].children[1].textContent;
        }
        if(arrChecked[2]){
            obj[arrInputValue[2].textContent] = arrTR[i].children[2].textContent;
        }
        if(arrChecked[3]){
            obj[arrInputValue[3].textContent] = arrTR[i].children[3].textContent;
        }
        if(arrChecked[4]){
            obj[arrInputValue[4].textContent] = arrTR[i].children[4].textContent;
        }
        if(arrChecked[5]){
            obj[arrInputValue[5].textContent] = arrTR[i].children[5].textContent;
        }
        if(arrChecked[6]){
            obj[arrInputValue[6].textContent] = arrTR[i].children[6].textContent;
        }
        
       answer.push(obj);
    }
    document.getElementById(`output`).value = JSON.stringify(answer);
}