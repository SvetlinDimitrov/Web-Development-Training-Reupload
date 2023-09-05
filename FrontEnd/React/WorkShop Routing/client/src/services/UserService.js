export async function login(user) {
  const response = await fetch("http://localhost:3030/users/login", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(user),
  });

  const result = await response.json();

  if (response.ok) {
    // Registration was successful (status code 200-299)
    return result;
  } else {
    // Registration failed, handle the error here
    throw new Error(result.message);
  }
}

export async function register(user){
  const {confirmPassword , ...values} = user;
  if(user.password !== user.confirmPassword){
    throw new Error('Passwords Did Not Match');
  }
  const response = await fetch("http://localhost:3030/users/register", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(values),
  });
  const data = await response.json();

  if (response.ok) {
    // Registration was successful (status code 200-299)
    return data;
  } else {
    // Registration failed, handle the error here
    throw new Error(data.message);
  }

}

export function logout(user){
  const {accessToken} = user;

  fetch("http://localhost:3030/users/logout", {
    method: "GET",
    headers: {
      "content-type": "application/json",
      'X-Authorization': `${accessToken}`
    }
  });
  
  return true;
}
