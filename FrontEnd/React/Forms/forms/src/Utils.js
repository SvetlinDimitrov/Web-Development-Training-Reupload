export function checkFirstName(firstName, type, oldValue) {
  if (type !== "firstName") {
    return oldValue;
  }

  if (firstName.length < 3) {
    return "First name should be at least 3 characters long!";
  }

  return "";
}

export function checkLastName(lastName, type, oldValue) {
  if (type !== "lastName") {
    return oldValue;
  }

  if (lastName.length < 3) {
    return "Last name should be at least 3 characters long!";
  }

  return "";
}

export function checkEmail(email, type, oldValue) {
  let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  if (type !== "email") {
    return oldValue;
  }

  if (!email.match(regex)) {
    return "Email is not valid";
  }

  return "";
}

export function checkImageUrl(imageUrl, type, oldValue) {

  if (type !== "imageUrl") {
    return oldValue;
  }

  let regex = /^https?:\/\/.*\/.*\.(png|gif|webp|jpeg|jpg)\??.*$/gmi
  
  if (!imageUrl.match(regex)) {
    return "imageUrl is not valid";
  }

  return "";
}

