import { Link } from "react-router-dom";
import useForm from "../../hooks/useForm";
import { useContext, useState } from "react";
import { AuthContext } from "../../context/AuthContext";
import { login } from "../../services/UserService";
import { useNavigate } from "react-router-dom";
import styles from "./loginPage.module.css";



const loginParamKeys = {
  email : 'email',
  password : 'password'
}

const initValues = {
  [loginParamKeys.email]: "",
  [loginParamKeys.password]: "",
};

export function LoginPage() {
  const { setUser } = useContext(AuthContext);
  const [failLogin, setFailLogin] = useState('');
  const navigate = useNavigate();

  const onFailLoginClick = () => {
    setFailLogin('');
  }
  
  const onLoginSubmit = async (newUser) => {
    
    try{
      const userToSet = await login(newUser);
      setUser(userToSet);
      navigate("/");
    }catch(e){
      setFailLogin(e.message);
    }

  };

  const { values, onChange, onSubmit } = useForm(initValues, onLoginSubmit);

  return (
    <section id="login">
      <div className="form">
        <h2>Login</h2>
        <form className="login-form" method="POST" onSubmit={onSubmit}>
          <input
            type="text"
            name={loginParamKeys.email}
            id={loginParamKeys.email}
            placeholder={loginParamKeys.email}
            autoComplete={loginParamKeys.email}
            value={values[loginParamKeys.email]}
            onChange={onChange}
          />
          <input
            type={loginParamKeys.password}
            name={loginParamKeys.password}
            id={loginParamKeys.password}
            placeholder={loginParamKeys.password}
            autoComplete="current-password"
            value={values[loginParamKeys.password]}
            onChange={onChange}
          />
          <button type="submit">login</button>
          <p className="message">
            Not registered? <Link to="/register">Create an account</Link>
          </p>
          {failLogin !== '' && (
            <div>
              <div className={styles.overlay} id="overlay"></div>
              <div className={styles.popup} id="popup">
                <p>{failLogin}</p>
                <button onClick={onFailLoginClick}>OK</button>
              </div>
            </div>
          )}
        </form>
      </div>
    </section>
  );
}
