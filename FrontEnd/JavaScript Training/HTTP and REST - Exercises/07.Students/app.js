function attachEvents() {
  let buttonSubmit = document.getElementById(`submit`);
  let URL = `http://localhost:3030/jsonstore/collections/students`;
  getAllContacts();
  buttonSubmit.addEventListener(`click` , createInfo);

  async function createInfo(){
    try{
      let firstName = document.getElementsByTagName(`input`)[0];
      let lastName = document.getElementsByTagName(`input`)[1];
      let facNumber = document.getElementsByTagName(`input`)[2];
      let grade = document.getElementsByTagName(`input`)[3];
      if(firstName.value.length === 0 || 
        lastName.value.length === 0 ||
        facNumber.value.length === 0 ||
        grade.value.length ===0){
          throw new Error();
        }
      let body = {method : `post` , body: JSON.stringify({
        firstName: `${firstName.value}`,
        lastName: `${lastName.value}`,
        facultyNumber: `${facNumber.value}`,
        grade: `${grade.value}`
      })}
    await fetch(URL , body);
    firstName.value = '';
    lastName.value ='';
    facNumber.value ='';
    grade.value = '';
    getAllContacts();
    }catch(err){
      console.log(err);
    }
    
  }
  async function getAllContacts(){
    let data = await (await fetch(URL)).json();
    for (const key in data) {
      let object = data[key];
      
      let tr = document.createElement(`tr`);
      let tdFirstName = document.createElement(`td`);
      let tdSecondName = document.createElement(`td`);
      let tdFacNumber = document.createElement(`td`);
      let tdGrade = document.createElement(`td`);
      
      tdFirstName.textContent = object.firstName;
      tdSecondName.textContent = object.lastName;
      tdFacNumber.textContent = object.facultyNumber;
      tdGrade.textContent = object.grade;
      
      tr.appendChild(tdFirstName);
      tr.appendChild(tdSecondName);
      tr.appendChild(tdFacNumber);
      tr.appendChild(tdGrade);
      document.getElementsByTagName(`tbody`)[0].appendChild(tr);
    }
  }
}

attachEvents();