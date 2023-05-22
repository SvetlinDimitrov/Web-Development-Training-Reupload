function attachEvents() {
    let inputName = document.getElementsByTagName(`input`)[0];
    let inputMessage = document.getElementsByTagName(`input`)[1];
    let sendButton = document.getElementsByTagName(`input`)[2];
    let refreshButton = document.getElementsByTagName(`input`)[3];
    let messages = document.getElementById(`messages`);
    let URL = `http://localhost:3030/jsonstore/messenger`;
    refreshAll();
    
    sendButton.addEventListener(`click` , sendMessage);
    async function sendMessage(){
        let header = {method:`post`,body:JSON.stringify({author:inputName.value , content:inputMessage.value})}
        fetch(URL , header);
    }
    refreshButton.addEventListener(`click` , refreshAll);

    async function refreshAll(){
        messages.value = '';
        let data = await (await fetch(URL)).json();
        for (const key in data) {
            messages.value += `${data[key].author}: ${data[key].content}\n`
            
        }
    }
}

attachEvents();