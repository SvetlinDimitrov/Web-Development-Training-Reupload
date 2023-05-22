function attachEvents() {
    let lead = document.getElementById(`btnLoad`);
    let phonebook = document.getElementById(`phonebook`);
    let createButton = document.getElementById(`btnCreate`);
    createButton.addEventListener(`click` , createContact);
    lead.addEventListener(`click`, loadAll);
    let URL = `http://localhost:3030/jsonstore/phonebook`;
    let toDelete = {};

    async function loadAll(){
        phonebook.innerHTML = ' ';
        let data = await (await fetch(URL)).json();
        for (const key in data) {
            let object = data[key];
            let deleteButton = document.createElement(`button`);
            deleteButton.textContent = `Delete`;
            deleteButton.classList.add(`button`);
            deleteButton.addEventListener(`click`,deleteContact);
            let li = document.createElement(`li`);
            li.textContent = `${object.person}: ${object.phone}`
            li.appendChild(deleteButton);
            phonebook.appendChild(li);
            toDelete[object.person] = object._id;
        }
        
    }
    async function deleteContact(){
        let li = this.parentNode;
        let nameToDelete = li.textContent.split(':')[0];
        let bonusUrl = toDelete[nameToDelete];
        await fetch(`${URL}/${bonusUrl}`, {method : 'delete'});
        await loadAll();
    }
    async function createContact(){
        let name = document.getElementById(`person`);
        let phoneNumber = document.getElementById(`phone`);
        let body = {method: 'post' , body:JSON.stringify({person : name.value, phone :phoneNumber.value})}
        await fetch(URL , body);
        name.value ='';
        phoneNumber.value ='';
        await loadAll();
    }
}

attachEvents();