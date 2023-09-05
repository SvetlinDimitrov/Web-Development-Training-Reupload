import { Link } from "react-router-dom";
import useForm from "../../hooks/useForm";
import { register } from "../../services/UserService";
import { useContext, useState } from "react";
import { AuthContext } from "../../context/AuthContext";
import styles from "./register.module.css";
import { useNavigate } from "react-router-dom";

const formKeys = {
  email: "email",
  password: "password",
  confirmPassword: "confirmPassword",
};

const formValues = {
  [formKeys.email]: "",
  [formKeys.password]: "",
  [formKeys.confirmPassword]: "",
};

export function RegisterPage() {
  const navigate = useNavigate();
  const { setUser } = useContext(AuthContext);
  const [failRegister, setFailRegister] = useState("");

  const handleSubmitAction = async (values) => {

    try{
      const result = await register(values);
      setUser(result);
      navigate("/dashboard");
    }catch(e){
      setFailRegister(e.message);
    }
    
  };

  const onFailRegisterClick = () => {
    setFailRegister("");
  };

  const { values, onChange, onSubmit } = useForm(
    formValues,
    handleSubmitAction
  );

  return (
    <section id="register">
      <div className="form">
        <h2>Register</h2>
        <form className="login-form" method="POST" onSubmit={onSubmit}>
          <input
            type="text"
            name={formKeys.email}
            id="register-email"
            placeholder={formKeys.email}
            value={values[formKeys.email]}
            onChange={onChange}
          />
          <input
            type={formKeys.password}
            name={formKeys.password}
            id="register-password"
            placeholder={formKeys.password}
            value={values[formKeys.password]}
            onChange={onChange}
          />
          <input
            type={formKeys.password}
            name={formKeys.confirmPassword}
            id="repeat-password"
            placeholder="repeat password"
            value={values[formKeys.confirmPassword]}
            onChange={onChange}
          />
          <button type="submit">register</button>
          <p className="message">
            Already registered? <Link to="/login">Login</Link>
          </p>
          {failRegister !== "" && (
            <div>
              <div className={styles.overlay} id="overlay"></div>
              <div className={styles.popup} id="popup">
                <p>{failRegister}</p>
                <button onClick={onFailRegisterClick}>OK</button>
              </div>
            </div>
          )}
        </form>
      </div>
    </section>
  );
}
