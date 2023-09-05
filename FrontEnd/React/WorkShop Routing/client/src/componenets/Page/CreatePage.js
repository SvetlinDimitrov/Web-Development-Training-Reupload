import useForm from "../../hooks/useForm";
import { createAlbum } from "../../services/AlbumService";
import { useContext, useState } from "react";
import { AuthContext } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";
import styles from './Page.module.css';

const formKeys = {
  singer: "singer",
  album: "album",
  imageUrl: "imageUrl",
  release: "release",
  label: "label",
  sales: "sales",
};

const initValues = {
  [formKeys.singer]: "",
  [formKeys.album]: "",
  [formKeys.imageUrl]: "",
  [formKeys.release]: "",
  [formKeys.label]: "",
  [formKeys.sales]: "",
};

const CreatePage = () => {
  const [createFail , setCreateFail] = useState('');
  const { user } = useContext(AuthContext);
  const navigate = useNavigate();

  const onSubmitHandler = async (values) => {
   
    try{
      await createAlbum(values, user);
      navigate("/dashboard");
    }catch(e){
      setCreateFail(e.message);
    }
      
      
   
  };
  const onCreateFailClick = () =>{
    setCreateFail('');
  }

  const { values, onChange, onSubmit } = useForm(initValues, onSubmitHandler);

  return (
    <section id="create">
      <div className="form">
        <h2>Add Album</h2>
        <form className="create-form" method="POST" onSubmit={onSubmit}>
          <input
            type="text"
            name={formKeys.singer}
            id="album-singer"
            placeholder="Singer/Band"
            value={values.singer}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.album}
            id="album-album"
            placeholder="Album"
            value={values.album}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.imageUrl}
            id="album-img"
            placeholder="Image url"
            value={values.imageUrl}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.release}
            id="album-release"
            placeholder="Release date"
            value={values.release}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.label}
            id="album-label"
            placeholder="Label"
            value={values.label}
            onChange={onChange}
          />
          <input
            type="text"
            name={formKeys.sales}
            id="album-sales"
            placeholder="Sales"
            value={values.sales}
            onChange={onChange}
          />

          <button type="submit">post</button>
          {createFail !== '' && (
            <div>
              <div className={styles.overlay} id="overlay"></div>
              <div className={styles.popup} id="popup">
                <p>{createFail}</p>
                <button onClick={onCreateFailClick}>OK</button>
              </div>
            </div>
          )}
        </form>
      </div>
    </section>
  );
};

export default CreatePage;
