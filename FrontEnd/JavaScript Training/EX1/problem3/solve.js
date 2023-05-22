
function attachEvents() {
    let URL = 'http://localhost:3030/jsonstore/tasks/';
    let input = document.getElementById(`title`);
    let addBtn = document.getElementById(`add-button`);
    let loadBtn = document.getElementById(`load-button`);
    loadBtn.addEventListener('click' , loadFunction);
    addBtn.addEventListener('click' , addFunction);

  function addFunction(event){
    event.preventDefault();
    let body = {method : "post", body : JSON.stringify({ name : input.value})};
    fetch(URL , body);
    input.value ="";
    loadFunction();
  }

  function loadFunction(event){
        if(event){
          event.preventDefault()
        }
        document.getElementById(`todo-list`).innerHTML ="";
        
        fetch(URL)
        .then(e=> e.json())
        .then(res => {
          let jsonInput = Object.values(res);
          for (const {_id , name} of jsonInput) {
            let li = document.createElement('li');
            li.id = _id;

            let span = document.createElement('span');
            span.textContent = name;
            li.appendChild(span);

            let removeBtn = document.createElement('button');
            removeBtn.textContent = 'Remove';
            removeBtn.addEventListener('click' , removeFunctionHandler);
            li.appendChild(removeBtn);

            let EditBtn = document.createElement('button');
            EditBtn.addEventListener('click' , editFunctionHandler)
            EditBtn.textContent = 'Edit';
            li.appendChild(EditBtn);

            document.getElementById(`todo-list`).appendChild(li);
          }
        })
  }

  function removeFunctionHandler(){
    let name = this.parentNode.id;
   
    fetch(`${URL}${name}`, {method :'delete'})
    .then(e=>{loadFunction()});    
  }
  function editFunctionHandler(){
    let ID = this.parentNode.id;
    if(this.textContent === "Edit"){
        let oldSpan = this.parentNode.children[0];
        let input = document.createElement('input');
        input.value=oldSpan.textContent;
        this.parentNode.replaceChild(input,oldSpan);
        this.textContent = "Submit";
    }else{
        let body = {method : "PATCH" ,  body : JSON.stringify({name : this.parentNode.children[0].value})};
        fetch(`${URL}${ID}`, body)
        .then(e=> {loadFunction()});
        
    }
    
  }
}

attachEvents();
