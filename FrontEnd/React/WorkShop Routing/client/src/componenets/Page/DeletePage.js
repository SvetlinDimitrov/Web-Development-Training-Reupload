import { useParams , useNavigate } from "react-router-dom"
import { useContext , useEffect } from "react";
import {AuthContext} from '../../context/AuthContext';
import {deleteAlbum} from '../../services/AlbumService';

export function DeletePage(){
    let {user} = useContext(AuthContext);
    let {albumId} = useParams();
    let navigator = useNavigate();

    useEffect(() => {

        deleteAlbum(albumId , user.accessToken);
        navigator('/dashboard');

    },[albumId , user.accessToken , navigator])
    
}