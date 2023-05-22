let URL  = `http://localhost:3030/jsonstore/tasks/`;
let loadBtn = document.getElementById(`load-board-btn`);
let createBtn = document.getElementById(`create-task-btn`);

let titleInput = document.getElementById(`title`);
let descriptionInput = document.getElementById(`description`);

let ToDo = document.getElementById(`todo-section`);
let InProgress = document.getElementById(`in-progress-section`);
let CodeReview = document.getElementById(`code-review-section`);
let Done = document.getElementById(`done-section`);

function attachEvents() {
    loadBtn.addEventListener('click' , loadHandler)
    createBtn.addEventListener('click' , addHandler);

}
function loadHandler(event){
    if(event){event.preventDefault();}
    ToDo.innerHTML ="";
    InProgress.innerHTML = "";
    CodeReview.innerHTML ="";
    Done.innerHTML ="";

    fetch(URL)
    .then(res => res.json())
    .then(obj => {
        for (const {title , description , status ,_id} of Object.values(obj)) {
            let li = document.createElement(`li`);
            let h3 = document.createElement(`h3`);
            let p = document.createElement(`p`);
            let button = document.createElement(`button`);
            
            li.classList.add("task");
            li.id = _id;

            h3.textContent = title;
            li.appendChild(h3);

            p.textContent = description;
            li.appendChild(p);

            button.addEventListener('click' , moveHandler);

            if(status === "ToDo"){
                button.textContent = "Move to In Progress";
                li.appendChild(button);
                ToDo.appendChild(li);
            }else if(status === "In Progress"){
                button.textContent = "Move to Code Review";
                li.appendChild(button);
                InProgress.appendChild(li);
            }else if (status === "Code Review"){
                button.textContent = "Move to Done";
                li.appendChild(button);
                CodeReview.appendChild(li);
            }else if (status === "Done"){
                button.textContent = "Close";
                li.appendChild(button);
                Done.appendChild(li);
            }

        }
    })

}
function addHandler (event){
    if(event){event.preventDefault();}
    // if(titleInput.value.trim().length !== 0 && descriptionInput.value.trim().length !== 0){
        let body = {
            method : 'post' ,
            body : JSON.stringify({
                "title": titleInput.value,
                "description": descriptionInput.value,
                "status": "ToDo"
            })
        }
        fetch(URL , body)
        .then(res => {
            loadHandler();
            titleInput.value = "";
            descriptionInput.value ="";
        })
    // }
}
function moveHandler(){
    let li = this.parentNode;
    let id = li.id;
    let body = {};
    if(this.textContent === "Move to In Progress"){
        body = {
            method : "PATCH" ,
            body : JSON.stringify({
                title: li.children[0].textContent,
                description: li.children[1].textContent,
                status: 'In Progress'
            })
        }
        fetch(`${URL}${id}` , body)
        .then(res => {
            loadHandler();
        })
    }else if (this.textContent === "Move to Code Review") {
        body = {
            method : "PATCH" ,
            body : JSON.stringify({
                title: li.children[0].textContent,
                description: li.children[1].textContent,
                status: 'Code Review'
            })
        }
        fetch(`${URL}${id}` , body)
        .then(res => {
            loadHandler();
        })
    }else if (this.textContent === "Move to Done"){
        body = {
            method : "PATCH" ,
            body : JSON.stringify({
                title: li.children[0].textContent,
                description: li.children[1].textContent,
                status: 'Done'
            })
        }
        fetch(`${URL}${id}` , body)
        .then(res => {
            loadHandler();
        })
    }else{
        deleteFunction(this);
    }
}
function deleteFunction(button){
    
    let li = button.parentNode;
    fetch(`${URL}${li.id}` , {method: 'DELETE'})
    .then(loadHandler());

}
attachEvents();