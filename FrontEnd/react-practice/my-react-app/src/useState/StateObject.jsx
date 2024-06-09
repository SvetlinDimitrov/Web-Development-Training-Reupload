import {useState} from "react";

function StateObject() {
    const [state, setState] = useState({name: 'John', age: 30});

    const handleNameChange = (e) => {
        setState(old => ({...old, name: e.target.value}));
    }

    const handleAgeChange = (e) => {
        setState(old => ({...old, age: e.target.value}));
    }

    return (
        <div>
            <h1>{state.name}</h1>
            <h2>{state.age}</h2>
            <input type="text" value={state.name} onChange={handleNameChange}/>
            <input type="number" value={state.age} onChange={handleAgeChange}/>
        </div>
    );
}

export default StateObject;