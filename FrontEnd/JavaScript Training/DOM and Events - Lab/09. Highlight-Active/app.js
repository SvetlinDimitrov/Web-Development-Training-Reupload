function focused() {
    let inputs = document.getElementsByTagName('input');
    for (const input of inputs) {
        input.addEventListener('focus' , shazam);
        input.addEventListener('blur' , shazam2);
    }
    function shazam(){
        this.parentNode.classList.add('focused');
    }
    function shazam2(){
        this.parentNode.classList.remove(`focused`)
    }
}