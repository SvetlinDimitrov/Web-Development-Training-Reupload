function loadRepos() {
   let output = document.getElementById(`res`);
   let URL_CONST = `https://api.github.com/users/testnakov/repos`;
   fetch(URL_CONST)
      .then((res) => output.textContent = res.type)
      .catch((err) => console.error(err))
      
}