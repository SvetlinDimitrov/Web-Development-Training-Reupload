function attachEvents() {
  let loadBooks = document.getElementById(`loadBooks`);
  loadBooks.addEventListener(`click` , loadAll);
  let URL = `http://localhost:3030/jsonstore/collections/books`;
  let buttonSubmit = document.querySelector(`#form > button`);
  buttonSubmit.addEventListener(`click` , submit);

  async function submit(){
   
    try{
      if(buttonSubmit.textContent === `Submit`){
        let titleName = document.querySelector(`#form`).children[2].value;
        let authorName = document.querySelector(`#form`).children[4].value;
        if(titleName.length === 0 || authorName.length === 0){throw new Error;}
        else{
          let body = {method : `post` , body : JSON.stringify({
            author: authorName,
            title: titleName
          })}
          await fetch(URL , body);
          document.querySelector(`#form`).children[2].value = '';
          document.querySelector(`#form`).children[4].value = '';
        }
      }else{
        let titleName = document.querySelector(`#form`).children[2].value;
        let authorName = document.querySelector(`#form`).children[4].value;
        let body = {method : `put` , body : JSON.stringify({
          author: authorName,
          title: titleName
        })}
        let id = document.getElementById(`editId`).textContent;
        console.log(id);
        await fetch(`${URL}/${id}`, body);
        buttonSubmit.textContent = `Submit`;
        document.querySelector(`#form`).children[0].textContent = `FORM`;
        document.querySelector(`#form`).children[2].value = '';
        document.querySelector(`#form`).children[4].value = '';
        loadAll();
      }
      
    }catch(err){

    }
    
  }
  async function loadAll(){
    let data = await (await fetch(URL)).json();
    document.getElementsByTagName(`tbody`)[0].innerHTML = '';
    for (const key in data) {
      let object = data[key];
      let tr = document.createElement(`tr`);
      let titleTd = document.createElement(`td`);
      titleTd.textContent = object.title;
      tr.appendChild(titleTd);
      let authorTd = document.createElement(`td`);
      authorTd.textContent = object.author;
      tr.appendChild(authorTd);
      let buttonTd = document.createElement(`td`);
      let buttonEdit = document.createElement(`button`);
      buttonEdit.textContent = `Edit`;
      buttonEdit.addEventListener(`click` , editFunction);
      buttonTd.appendChild(buttonEdit);
      let buttonDelete = document.createElement(`button`);
      buttonDelete.textContent = `Delete`;
      buttonDelete.addEventListener(`click` , deleteArticle);
      buttonTd.appendChild(buttonDelete);
      tr.appendChild(buttonTd);
      let tdID = document.createElement(`td`);
      tdID.textContent = key;
      tdID.style.display = `none`;
      tdID.id = `editId`;
      tr.appendChild(tdID);
      document.getElementsByTagName(`tbody`)[0].appendChild(tr);
    }
  }
  async function deleteArticle(){
    let deleteId = document.getElementById(`editId`).textContent;
    let body = { method:`delete`};
    await fetch (`${URL}/${deleteId}` , body);
    loadAll();
  }
  async function editFunction(){
    let titleName = this.parentNode.parentNode.children[0].textContent;
    let authorName = this.parentNode.parentNode.children[1].textContent;
    document.querySelector(`#form`).children[0].textContent = `Edit FORM`;
    document.querySelector(`#form`).children[2].value = titleName;
    document.querySelector(`#form`).children[4].value = authorName;
    buttonSubmit.textContent = `Save`;
  }
}

attachEvents();