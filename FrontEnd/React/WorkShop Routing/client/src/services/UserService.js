export async function login(user) {
  const response = await fetch("http://localhost:3030/users/login", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(user),
  });

  const result = await response.json();

  //Handle exception

  return result;
}
