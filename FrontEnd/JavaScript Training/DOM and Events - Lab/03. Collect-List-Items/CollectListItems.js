function extractText() {
    let answer = document.getElementById(`result`);
    [...document.querySelectorAll('#items > li')]
    .forEach(e=> answer.textContent+= `${e.textContent}\n`);
}
const testa = document.getElementsByTagName(`li`);
console.log([...testa][0].style.display = 'none');

