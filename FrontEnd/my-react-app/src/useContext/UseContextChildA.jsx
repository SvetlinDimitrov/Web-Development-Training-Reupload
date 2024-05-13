import {useContext} from "react";
import {UserContext} from "./UseContextParent.jsx";

function UseContextChildA() {
    const {name, age} = useContext(UserContext);
    return (
        <div>
            <p>Name: {name}</p>
            <p>Age: {age}</p>
        </div>
    )
}

export default UseContextChildA;