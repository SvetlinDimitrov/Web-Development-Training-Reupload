function colorize() {
    let allTr = [...document.getElementsByTagName('tr')].filter((e,i)=>i%2 !==0);
    for (let index = 0 ; index < allTr.length ; index++){
        allTr[index].style.background = 'Teal';
    }
}