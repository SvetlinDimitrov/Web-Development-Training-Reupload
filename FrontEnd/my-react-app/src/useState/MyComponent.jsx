import {useState} from "react";

function MyComponent() {
    const [count, setCount] = useState(0);
    return (
        < div>
            < h1>{count} </ h1>
            < button onClick={() => setCount(count + 1)}>Increment</ button>
            < button onClick={() => setCount(0)}>Reset</ button>
            < button onClick={() => setCount(count - 1)}>Decrement</ button>
        </ div>
    );
}

export default MyComponent;