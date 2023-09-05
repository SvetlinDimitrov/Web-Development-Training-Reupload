import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import {getAlbumById , changeAlbum} from '../../services/AlbumService';
import { useContext } from "react";
import {AuthContext} from '../../context/AuthContext';
import { useNavigate } from "react-router-dom";

const formKeys = {
  singer: "singer",
  album: "album",
  imageUrl: "imageUrl",
  release: "release",
  label: "label",
  sales: "sales",
};

export function EditPage() {
  const { albumId } = useParams();
  const [currentAlbum, setCurrentAlbum] = useState({});
  const {user} = useContext(AuthContext);
  const navigate = useNavigate();


  useEffect(() => {

    const fetchData = async () => {
      const album = await getAlbumById(albumId);
      setCurrentAlbum(album);
    }
    
    fetchData();

  }, [albumId]);

  const onChange = (e) => {
    setCurrentAlbum((state) => ({ ...state, [e.target.name]: e.target.value }));
  };

  const onSubmit = (e) => {
    e.preventDefault();
    
   try{
    changeAlbum(currentAlbum , user);
    navigate('/dashboard');
   }catch(e){
    console.log(e.message);
   }
  };

  return (
    <section id="edit">
      <div className="form">
        <h2>Edit Album</h2>
        <form className="edit-form" method="PUT" onSubmit={onSubmit}>
          <input
            type="text"
            name={formKeys.singer}
            id="album-singer"
            placeholder="Singer/Band"
            value={currentAlbum[formKeys.singer]}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.album}
            id="album-album"
            placeholder="Album"
            value={currentAlbum[formKeys.album]}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.imageUrl}
            id="album-img"
            placeholder="Image url"
            value={currentAlbum[formKeys.imageUrl]}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.release}
            id="album-release"
            placeholder="Release date"
            value={currentAlbum[formKeys.release]}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.label}
            id="album-label"
            placeholder="Label"
            value={currentAlbum[formKeys.label]}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.sales}
            id="album-sales"
            placeholder="Sales"
            value={currentAlbum[formKeys.sales]}
            onChange={onChange}
          />

          <button type="submit">post</button>
        </form>
      </div>
    </section>
  );
}

