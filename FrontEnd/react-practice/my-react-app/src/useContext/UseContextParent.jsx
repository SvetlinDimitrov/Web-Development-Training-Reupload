import UseContextChildA from "./UseContextChildA.jsx";
import {createContext} from "react";

export const UserContext = createContext();

function UseContextParent() {

    const user = {
        name: 'John Doe',
        age: 25,
    }

    return (
        <div>
            <UserContext.Provider value={user}>
                <UseContextChildA/>
            </UserContext.Provider>
        </div>
    )
}

export default UseContextParent;