import {useState} from "react";

function ArrayState() {
    const [items, setItems] = useState([]);
    const [input, setInput] = useState('');

    const addItem = () => {
        setItems([...items, input]);
        setInput('');
    };

    const removeItem = (index) => {
        const newItems = items.filter((item, i) => i !== index);
        setItems(newItems);
    }

    return (
        <div>
            <input
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
            />
            <button onClick={addItem}>Add</button>
            <ul>
                {items.map((item, index) => (
                    <li key={index}
                        onClick={() => removeItem(index)}>{item}</li>
                ))}
            </ul>
        </div>
    );
}

export default ArrayState;