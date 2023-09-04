import { DashBoard } from "./componenets/DashBoard/DashBoard";
import { Header } from "./componenets/Header/Header";
import { Home } from "./componenets/Home/Home";
import { RegisterPage } from "./componenets/RegisterPage/RegisterPage";
import { LoginPage } from "./componenets/LoginPage/LoginPage";
import { CreatePage } from "./componenets/Page/CreatePage";
import { DetailsPage } from "./componenets/Page/DetailsPage";
import { EditPage } from "./componenets/Page/EditPage";
import { Footer } from "./componenets/Footer/Footer";
import { Routes, Route } from "react-router-dom";
import { DeletePage } from "./componenets/Page/DeletePage";
import { AuthContext } from "./context/AuthContext";
import { useState } from "react";
import { login } from "./services/UserService";
import { useNavigate } from "react-router-dom";

function App() {
  const [user, setUser] = useState({});
  const navigate = useNavigate();

  const onLoginSubmit = async (newUser) => {
    const userToSet = await login(newUser);

    if(userToSet._id){
      setUser(userToSet);
      navigate('/');
    }
    
  };

  const userSignature = {
    user,
    onLoginSubmit,
  };

  return (
    <>
      <AuthContext.Provider value={userSignature}>
        <div id="wrapper">
          <Header />
          <main>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/dashboard" element={<DashBoard />} />
              <Route
                path="/dashboard/details/:albumId"
                element={<DetailsPage />}
              />
              <Route
                path="/dashboard/details/:albumId/edit"
                element={<EditPage />}
              />
              <Route
                path="/dashboard/details/:albumId/delete"
                element={<DeletePage />}
              />
              <Route path="/register" element={<RegisterPage />} />
              <Route path="/login" element={<LoginPage />} />
              <Route path="/addAlbum" element={<CreatePage />} />
              <Route path="*" element={<h1>Error : 404</h1>} />
            </Routes>
          </main>
        </div>
        <Footer />
      </AuthContext.Provider>
    </>
  );
}

export default App;
