export function getAllAlbums(){
    let result = [];

    fetch('http://localhost:3030/data/albums')
    .then(data => data.json())
    .then(data => data.forEach(album => result.push(album)))

    return result;
}