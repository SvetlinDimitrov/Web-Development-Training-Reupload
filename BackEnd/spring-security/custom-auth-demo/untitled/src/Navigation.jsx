// Navigation.jsx
import React from 'react';
import { Link } from 'react-router-dom';

function Navigation() {
  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/view1">View 1</Link></li>
        <li><Link to="/view2">View 2</Link></li>
      </ul>
    </nav>
  );
}

export default Navigation;