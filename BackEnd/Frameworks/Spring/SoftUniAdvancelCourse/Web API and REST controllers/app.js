
let tbody = document.getElementsByTagName("tbody")[0];
let loadAllBooksButton =  document.getElementById("loadBooks");
let submitButton =  document.getElementById("submit");
loadAllBooksButton.addEventListener('click' , loadAll);
submitButton.addEventListener('click' , submit);


function loadAll(){
    tbody.innerHTML = ""
    fetch('http://localhost:8080/book')
    .then((r) => r.json())
    .then(j=> {
        j.forEach(element => {
            let tr = document.createElement("tr");
            let tdTitle = document.createElement("td");
            tdTitle.textContent = element["title"];

            let tdAuthor = document.createElement("td");
            tdAuthor.textContent = element["author"];

            let tdIsbn = document.createElement("td");
            tdIsbn.textContent = element["isbn"];

            let tdId = document.createElement("td");
            tdId.textContent = element["id"];
            tdId.style.display = "none";

            let tdButtons = document.createElement("td");

            let editButton = document.createElement("button");
            editButton.addEventListener('click' , editHandler);
            editButton.textContent= "Edit";

            let deleteButton = document.createElement("button");
            deleteButton.addEventListener('click' , deleteHandler);
            deleteButton.textContent= "Delete";

            tdButtons.appendChild(editButton);
            tdButtons.appendChild(deleteButton);
            
            tr.appendChild(tdTitle);
            tr.appendChild(tdAuthor);
            tr.appendChild(tdIsbn);
            tr.appendChild(tdButtons);
            tr.appendChild(tdId);
            tbody.appendChild(tr);

        });
    })
}

function deleteHandler(){
    let id = this.parentNode.parentNode.children[4];
    let body = {method:'delete'};
    fetch('http://localhost:8080/book/'+id.textContent , body).
    then(r => loadAll())
}

function editHandler(){
    let id = this.parentNode.parentNode.children[4];
    //TODO:
}

function submit(){
    let title =  document.getElementById("title");
    let author =  document.getElementById("author");
    let isbn =  document.getElementById("isbn");

    let bookToCreate = {
        "title": title.value,
        "isbn": isbn.value,
        "author": author.value
    }   

    let body2 = {
        method: 'POST',
        body: JSON.stringify(bookToCreate)
    }
    console.log(JSON.stringify(bookToCreate))

    fetch('http://localhost:8080/book' , body2) 
    .then(response => {
        loadAll()
    })
    .catch(error => {
        console.error('Error making POST request:', error);
        // Handle any errors that occurred during the request
    });
}