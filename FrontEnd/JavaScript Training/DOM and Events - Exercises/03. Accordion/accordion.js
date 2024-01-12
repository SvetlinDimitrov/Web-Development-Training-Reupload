function toggle() {
    let buttom = document.querySelector(`.button`);
    let extraText = document.getElementById(`extra`);
    if(buttom.textContent == "More"){
        buttom.textContent = "Less";
        extraText.style.display = `block`;
    }else{
        buttom.textContent = "More";
        extraText.style.display = `none`;
    }
}