import {Route, Routes} from "react-router-dom";
import Login from "./components/User/Login/Login.jsx";
import Register from "./components/User/Register/Register.jsx";
import NotFound from "./components/NotFoundPage/NotFoundPage.jsx";
import Home from "./components/Home/Home.jsx";
import Header from "./components/Header/Header.jsx";
import UserProvider from "./context/UserContext.jsx";
import Logout from "./components/User/Logout/Logout.jsx";
import UserAuthRequire from "./layouts/UserAuthRquire.jsx";
import UserNoAuthRequire from "./layouts/UserNoAuthRequre.jsx";
import AppProvider from "./context/AppContext.jsx";
import FoodList from "./components/FoodList/FoodList.jsx";

function App() {

    return (
        <UserProvider>
            <AppProvider>
                <Header/>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route element={<UserNoAuthRequire/>}>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/register" element={<Register/>}/>
                    </Route>
                    <Route element={<UserAuthRequire/>}>
                        <Route path="/foods" element={<FoodList/>}/>
                        <Route path="/logout" element={<Logout/>}/>
                    </Route>
                    <Route path={'*'} element={<NotFound/>}/>
                </Routes>
            </AppProvider>
        </UserProvider>
    )
}

export default App
