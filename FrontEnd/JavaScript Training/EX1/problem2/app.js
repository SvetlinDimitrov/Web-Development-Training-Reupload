window.addEventListener("load", solve);

function solve() {
  let authorInfoTable = document.getElementsByClassName(`inner-wrap`)[0].children;
  let firstName = authorInfoTable[0].children[0];
  let lastName = authorInfoTable[1].children[0];
  let age = authorInfoTable[2].children[0];
  let storyTitle = authorInfoTable[3].children[0];
  let gene = authorInfoTable[4].children[0];
  let authorInfoStory = document.getElementsByClassName(`inner-wrap`)[1].children[1];
  let obj = {};
  let publishBtn = document.getElementById(`form-btn`);
  publishBtn.addEventListener(`click` , publishFunction);
  let output = document.getElementById(`preview-list`);

  function publishFunction(){
    if(firstName.value.trim().length !== 0 && lastName.value.trim().length !== 0 &&
      age.value.trim().length !== 0 && storyTitle.value.trim().length !== 0 &&
      gene.value.trim().length !== 0 && authorInfoStory.value.trim().length !==0
    ){

      obj = {firstName: firstName.value ,lastName: lastName.value,
         age: age.value,storyTitle: storyTitle.value,
         gene : gene.value,authorInfoStory : authorInfoStory.value
        };
      
      publishBtn.disabled = true;
      let li = createEl('li' , null , output , ["story-info"] , {});
      let article = createEl('article' , null , li , [] , {});
      createEl('h1' , `Name: ${firstName.value} ${lastName.value}`, article , [] , {});
      createEl('p' , `Age: ${age.value}`, article , [] , {});
      createEl('p' , `Title: ${storyTitle.value}`, article , [] , {});
      createEl('p' , `Genre: ${gene.value}`, article , [] , {});
      createEl('p' , authorInfoStory.value, article , [] , {});
      let saveBtn = createEl('button' , "Save Stroy" , li , ["save-btn"] , {});
      saveBtn.addEventListener('click' , saveFunction);
      let editBtn = createEl('button' , "Edit Stroy" , li , ["edit-btn"] , {});
      editBtn.addEventListener('click' , editFunction);
      let deleteBtn = createEl('button' , "Delete Stroy" , li , ["delete-btn"] , {});
      deleteBtn.addEventListener('click' , deleteFunction);
      firstName.value ="";
      lastName.value = "";
      age.value ="";
      storyTitle.value ="";
      authorInfoStory.value = "";
    }
    
  }
  function editFunction(){
    publishBtn.disabled = false;
    firstName.value = obj.firstName;
    lastName.value = obj.lastName;
    age.value = obj.age;
    storyTitle.value = obj.storyTitle;
    authorInfoStory.value = obj.authorInfoStory;
    output.removeChild(output.children[1]);
  }
  function saveFunction(){
    let div = document.getElementsByTagName('body')[0].children[0];
    div.innerHTML ="";
    createEl('h1' , `Your scary story is saved!`, div , [] , {});
  }
  function deleteFunction(){
    publishBtn.disabled = false;
    output.removeChild(output.children[1]);
  }
  function createEl(type , value ,parent , classes , atributes){
    let element = document.createElement(type);
    
    if(value && (type === "input" || type === "textArea")){
      element.value = value;
    }else if (value){
      element.textContent = value;
    }

    if(parent){
      parent.appendChild(element);
    }

    for (let index = 0; index < classes.length; index++) {
      element.classList.add(classes[index]);
    }

    for (const key in atributes) {
      element.key = atributes[key];
    }
    return element;
  }
}
