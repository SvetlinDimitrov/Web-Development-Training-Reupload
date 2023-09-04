import { Link } from "react-router-dom";
import React, { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";

export function Header() {
  const { user } = useContext(AuthContext);

  return (
    <header>
      {/* <!-- Navigation --> */}
      <Link id="logo" to="/">
        <img id="logo-img" src="./images/logo.png" alt="" />
      </Link>

      <nav>
        <div>
          <Link to="/dashBoard">Dashboard</Link>
        </div>

        {user._id ? (
          <div className="user">
            <Link to="/addAlbum">Add Album</Link>
            <Link to="/">Logout</Link>
          </div>
        ) : (
          <div className="guest">
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
          </div>
        )}
      </nav>
    </header>
  );
}
