function deleteByEmail() {
    let input = document.getElementsByName("email")[0];
    let result = document.getElementById('result');
    let arr = document.querySelectorAll('tbody > tr');
    let boolean = false;
    
    for (const e of arr) {
        let toCheck = e.children[1];
        if(toCheck.textContent === input.value){
            toCheck.parentNode.parentNode.removeChild(toCheck.parentNode);
            boolean = true;
        }
    }
   
    if(boolean){
        result.textContent = 'Deleted';
    }else{
        result.textContent = 'Not found.';
    }
    input.value = '';
}
