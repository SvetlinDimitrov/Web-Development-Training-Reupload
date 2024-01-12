function lockedProfile() {

    let main = document.getElementById(`main`);
    main.innerHTML = '';
    let URL = `http://localhost:3030/jsonstore/advanced/profiles`;
    
    fetch(URL).then(e=> e.json())
        .then(res=>{
            for (const key in res) {
                let username = res[key].username;
                let email = res[key].email;
                let age = res[key].age;
                
                let div = document.createElement(`div`);
                div.className = "profile";

                let img = document.createElement(`img`);
                img.src = `./iconProfile2.png`;
                img.className = "userIcon";
                div.appendChild(img);

                let label1 = document.createElement(`label`);
                label1.textContent = "Lock";
                div.appendChild(label1);

                let input1 = document.createElement(`input`);
                input1.type = "radio";
                input1.name = "user1Locked";
                input1.value = "lock";
                input1.checked = true;
                div.appendChild(input1);
                
                let label2 = document.createElement(`label`);
                label2.textContent = "Unlock";
                div.appendChild(label2);

                let input2 = document.createElement(`input`);
                input2.type = "radio";
                input2.name = "user1Locked";
                input2.value = "unlock";
                div.appendChild(input2);

                let hr = document.createElement(`hr`);
                div.appendChild(hr);

                let label3 = document.createElement(`label`);
                label3.textContent = "Username";
                div.appendChild(label3);

                let input3 = document.createElement(`input`);
                input3.type = "text";
                input3.name = "user1Username";
                input3.value = username;
                input3.disabled = true;
                input3.readOnly = true;
                div.appendChild(input3);

                let div2 = document.createElement(`div`);
                div2.id = "user1HiddenFields";
                div2.style.display = "none";
                div.appendChild(div2);

                let hr1 = document.createElement(`hr`);
                div2.appendChild(hr1);

                let label4 = document.createElement(`label`);
                label4.textContent = "Email:";
                div2.appendChild(label4);
                
                let input4 = document.createElement(`input`);
                input4.type = "email";
                input4.name = "user1Email";
                input4.value = email;
                input4.disabled = true;
                input4.readOnly = true;
                div2.appendChild(input4);

                let label5 = document.createElement(`label`);
                label5.textContent = "Age:";
                div2.appendChild(label5);

                let input5 = document.createElement(`input`);
                input5.type = "email";
                input5.name = "user1Age";
                input5.value = age;
                input5.disabled = true;
                input5.readOnly = true;
                div2.appendChild(input5);

                let button = document.createElement(`button`);
                button.textContent = "Show more";
                button.addEventListener(`click` , showMore);
                div.appendChild(button);

                main.appendChild(div);
               
            }
        })
    function showMore(){
        let lock = this.parentNode.children[2];
        if(!lock.checked){
            if(this.textContent === 'Show more'){
                this.textContent = 'Hide it';
                let div2 = this.parentNode.children[8];
            
                div2.style.display = "block";
            }else{
                this.textContent = 'Show more';
                let div2 = this.parentNode.children[8];
                div2.style.display = "none";
            }
            
        }
    }
}


{/* <div class="profile">
<img src="./iconProfile2.png" class="userIcon" />
<label>Lock</label>
<input type="radio" name="user1Locked" value="lock" checked>
<label>Unlock</label>
<input type="radio" name="user1Locked" value="unlock"><br>
<hr>
<label>Username</label>
<input type="text" name="user1Username" value="" disabled readonly />
<div class="user1Username">
<hr>
<label>Email:</label>
<input type="email" name="user1Email" value="" disabled readonly />
<label>Age:</label>
<input type="text" name="user1Age" value="" disabled readonly />
</div> */}