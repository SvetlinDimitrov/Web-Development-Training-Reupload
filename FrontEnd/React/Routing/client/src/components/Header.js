import { Link } from "react-router-dom";
import styles from '../cssModule/Header.module.css';

export default function Header() {
  return (
    <ul>
      <li className={styles.header}> <Link to="/">HomePage</Link></li>
      <li className={styles.header}> <Link to="/country">Countries</Link></li>
    </ul>
  );
}
