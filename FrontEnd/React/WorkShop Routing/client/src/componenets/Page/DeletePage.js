import { useParams , useNavigate } from "react-router-dom"

export function DeletePage(){
    let {albumId} = useParams();
    let navigator = useNavigate();

    fetch(`http://localhost:3030/data/albums/${albumId}`,{method: 'DELETE'});

    navigator('/dashboard');
}