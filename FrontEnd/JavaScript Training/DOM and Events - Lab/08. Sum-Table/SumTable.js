function sumTable() {
    let answer = document.getElementById("sum");
    let allTr = [...document.getElementsByTagName('tr')];
    let sum  = 0;
    for(let i = 1; i < allTr.length-1 ; i++){
        sum += Number(allTr[i].children[1].textContent);
    }
    answer.textContent = sum;
}