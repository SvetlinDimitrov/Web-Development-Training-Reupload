import {useContext} from "react";
import {UserContext} from "../context/UserContext.jsx";
import {Navigate, Outlet} from 'react-router-dom';

function UserAuthRequire() {
    const user = useContext(UserContext);
    if (user) {
        return <Navigate to="/"/>;
    }
    return <Outlet/>;
}

export default UserAuthRequire;