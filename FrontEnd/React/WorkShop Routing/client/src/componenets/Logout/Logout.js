import { useContext, useEffect } from "react";
import { AuthContext } from "../../context/AuthContext";
import { logout } from "../../services/UserService";
import { useNavigate } from "react-router-dom";

const Logout = () => {
  const navigate = useNavigate();
  const { user,setUser} = useContext(AuthContext);

  useEffect(() => {

    logout(user);
    setUser({});
    navigate("/");
    
  }, [user,setUser,navigate]);

  return null;
};

export default Logout;
