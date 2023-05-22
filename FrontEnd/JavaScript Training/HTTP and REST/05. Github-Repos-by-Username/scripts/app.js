async function loadRepos() {
	let output = document.getElementById("repos");
	for (const li of output.children) {
		output.removeChild(li);
	}
	let URL =  `https://api.github.com/users/`;
	let name = document.getElementById(`username`).value;
	let end = `/repos`;
try{
	let repos = await fetch(`${URL}${name}${end}`);
	let jason = await repos.json();
	jason.forEach(object => {
		let li = document.createElement(`li`);
		output.appendChild(li);
		let a = document.createElement(`a`);
		a.href = object.full_name;
		a.textContent = object.full_name;
		li.appendChild(a);
	});
}catch(err){
	console.error(err);
}
	
		
}