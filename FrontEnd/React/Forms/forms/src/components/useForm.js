import { useState } from "react";
import {
  checkEmail,
  checkFirstName,
  checkImageUrl,
  checkLastName,
} from "../Utils";

export function useForm(initValue, errorInitValue) {
  const [formProp, setFormProp] = useState(initValue);
  const [errorMessage, setErrorMessage] = useState(errorInitValue);

  const checkForError = (event) => {
    let eventName = event.target.name;
    let eventValue = event.target.value;

    setErrorMessage({
      firstName: checkFirstName(eventValue, eventName, errorMessage.firstName),
      lastName: checkLastName(eventValue, eventName, errorMessage.lastName),
      email: checkEmail(eventValue, eventName, errorMessage.email),
      phoneNumber: "",
      imageUrl: checkImageUrl(eventValue, eventName, errorMessage.imageUrl),
      country: "",
      city: "",
      street: "",
      streetNumber: "",
    });
  };

  const formOnChange = (e) => {
    let targetName = e.target.name;
    let targetValue = e.target.value;

    setFormProp((state) => ({ ...state, [targetName]: targetValue }));
  };

  return {formProp , errorMessage , formOnChange , checkForError};
}
