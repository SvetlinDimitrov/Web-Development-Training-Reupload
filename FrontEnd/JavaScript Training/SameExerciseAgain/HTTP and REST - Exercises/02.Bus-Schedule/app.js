function solve() {
    let URL = 'http://localhost:3030/jsonstore/bus/schedule/';
    let next = 'depot';
    let departButton = document.getElementById(`depart`);
    let arriveButton = document.getElementById(`arrive`);
    let output = document.getElementsByClassName(`info`)[0];

    function depart() {
        fetch(`${URL}${next}`)
            .then(res => res.json())
            .then(res => {
                departButton.disabled = true;
                arriveButton.disabled = false;
                output.textContent = `Next stop ${res.name}`
                
            })
            .catch(err => {
                output.textContent = `Error`;
                departButton.disabled = true;
                arriveButton.disabled = true;
            })
    }

    async function arrive() {
        fetch(`${URL}${next}`)
            .then(res => res.json())
            .then(res => {
                departButton.disabled = false;
                arriveButton.disabled = true;
                next = res.next;
                output.textContent = `Arriving at ${res.name}`
                
            })
            .catch(err => {
                output.textContent = `Error`;
                departButton.disabled = true;
                arriveButton.disabled = true;
            })
        
        
    }

    return {
        depart,
        arrive
    };
}

let result = solve();