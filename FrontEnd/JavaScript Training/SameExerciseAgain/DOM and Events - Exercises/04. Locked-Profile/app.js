function lockedProfile() {
    let buttons = document.getElementsByTagName(`button`);
    for (const button of buttons) {
        button.addEventListener(`click` , handler)
    }
    function handler(){
        if(!this.parentNode.children[2].checked){
            if(this.textContent === "Show more"){
                this.textContent = "Hide it";
                this.parentNode.children[9].style.display = `block`
            }else{
                this.textContent = "Show more";
                this.parentNode.children[9].style.display = `none`
            }
        }
    }
}