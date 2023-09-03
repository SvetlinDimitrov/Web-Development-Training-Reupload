import { Link } from "react-router-dom";
import { useEffect, useState } from "react";

export function DashBoard() {

  const [albums, setAlbums] = useState([]);

  useEffect(() => {
    fetch('http://localhost:3030/data/albums')
      .then((data) => data.json())
      .then((data) => {
        
        const result = data.map((album) => (album));
        setAlbums(result);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);


  return (
    <section id="dashboard">
      <h2>Albums</h2>
      <ul className="card-wrapper">
        
      {albums.map((album) => (
         
          <li key={album._id} className="card">
            <img src={album.imageUrl} alt="travis" />
            <p>
              <strong>Singer/Band: </strong>
              <span className="singer">{album.singer}</span>
            </p>
            <p>
              <strong>Album name: </strong>
              <span className="album">{album.album}</span>
            </p>
            <p>
              <strong>Sales:</strong>
              <span className="sales">{album.sales}</span>
            </p>
            <Link
              className="details-btn"
              to={`/dashboard/details/${album._id}`}
            >
              Details
            </Link>
            
          </li>
        ))}
      </ul>

      {albums.length === 0 && <h2>There are no albums added yet.</h2>}
    </section>
  );
}
