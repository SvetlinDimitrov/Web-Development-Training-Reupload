import {Link} from 'react-router-dom';
import useForm from '../../hooks/useForm';
import { useContext } from 'react';
import { AuthContext } from '../../context/AuthContext';

export function LoginPage(){
    const {onLoginSubmit} = useContext(AuthContext);

    const initValues = {
      email: '',
      password : '',
    };

    const {values ,onChange , onSubmit} = useForm(initValues,onLoginSubmit);

    return (
        <section id="login">
            <div className="form">
              <h2>Login</h2>
              <form className="login-form" method='POST' onSubmit={onSubmit}>
                <input
                  type="text"
                  name="email"
                  id="email"
                  placeholder="email"
                  autoComplete="email"
                  value={values.email}
                  onChange={onChange}
                />
                <input
                  type="password"
                  name="password"
                  id="password"
                  placeholder="password"
                  autoComplete="current-password"
                  value={values.password}
                  onChange={onChange}
                />
                <button type="submit">login</button>
                <p className="message">
                  Not registered? <Link href="/register">Create an account</Link>
                </p>
              </form>
            </div>
          </section>
    );
}