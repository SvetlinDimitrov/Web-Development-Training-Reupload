import {Link} from 'react-router-dom';
import { useParams } from 'react-router-dom';
import { useEffect , useState } from 'react';

export function DetailsPage(){

  let  {albumId} = useParams();
  const [album , setAlbum] = useState({});
  //TODO liked button
  // const [liked , setLiked] = useState(false);

  useEffect(() =>{
    fetch(`http://localhost:3030/data/albums/${albumId}`)
    .then(res=> res.json())
    .then(res => setAlbum(res))
  },[albumId])

   return (
        <section id="details">
            <div id="details-wrapper">
              <p id="details-title">Album Details</p>
              <div id="img-wrapper">
                <img src={album.imageUrl} alt="example1" />
              </div>
              <div id="info-wrapper">
                <p>
                  <strong>Band:</strong>
                  <span id="details-singer">{album.singer}</span>
                </p>
                <p>
                  <strong>Album name:</strong>
                  <span id="details-album">{album.album}</span>
                </p>
                <p>
                  <strong>Release date:</strong>
                  <span id="details-release">{album.release}</span>
                </p>
                <p>
                  <strong>Label:</strong>
                  <span id="details-label">{album.label}</span>
                </p>
                <p>
                  <strong>Sales:</strong>
                  <span id="details-sales">
                    {album.sales}
                  </span>
                </p>
              </div>
              <div id="likes">
                Likes: <span id="likes-count">0</span>
              </div>

              {/* <!--Edit and Delete are only for creator--> */}
              <div id="action-buttons">
                <Link to="" id="like-btn">
                  Like
                </Link>
                <Link to={`/dashboard/details/${album._id}/edit`} id="edit-btn">
                  Edit
                </Link>
                <Link to={`/dashboard/details/${album._id}/delete`} id="delete-btn">
                  Delete
                </Link>
              </div>
            </div>
          </section>
          
    );
}