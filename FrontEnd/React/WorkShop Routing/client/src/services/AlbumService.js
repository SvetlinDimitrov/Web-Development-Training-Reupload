export function getAllAlbums(){
    let result = [];

    fetch('http://localhost:3030/data/albums')
    .then(data => data.json())
    .then(data => data.forEach(album => result.push(album)))

    return result;
}

export async function createAlbum(values , {accessToken}){

    if(!checkValues(values)){
        throw new Error("Some fields are not filed");
      }

   const result = await fetch("http://localhost:3030/data/albums", {
    method: "POST",
    headers: {
      "content-type": "application/json",
      'X-Authorization': `${accessToken}`
    },
    body: JSON.stringify(values),
  });

  if(!result.ok){
    throw new Error("Create album failed");
  }

  return true;
}

export async function getAlbumById(albumId){
  const response = await fetch(`http://localhost:3030/data/albums/${albumId}`);

  const result = await response.json();
  
  return result;
}

export function deleteAlbum(albumId , accessToken){
  fetch(`http://localhost:3030/data/albums/${albumId}`,{
    headers: {
    'X-Authorization': `${accessToken}`
  },method: 'DELETE'});
}
function checkValues(data){
    return Object.values(data).every((value) => value.length !== 0);
}

export async function changeAlbum(values , {accessToken}){

  if(!checkValues(values)){
      throw new Error("Some fields are not filed");
    }

 const result = await fetch(`http://localhost:3030/data/albums/${values._id}`, {
  method: "PUT",
  headers: {
    "content-type": "application/json",
    'X-Authorization': `${accessToken}`
  },
  body: JSON.stringify(values),
});

if(!result.ok){
  throw new Error("Change album failed");
}

return true;
}