import Header from "./components/Header";
import Form from "./components/Form";
import { useState } from "react";
import { checkEmail, checkFirstName, checkImageUrl, checkLastName } from "./Utils";

function App() {
  const [close, setClose] = useState(false);
  const [formProp, setFormProp] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    imageUrl: "",
    country: "",
    city: "",
    street: "",
    streetNumber: "",
  });
  const [errorMessage, setErrorMessage] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    imageUrl: "",
    country: "",
    city: "",
    street: "",
    streetNumber: "",
  });

  const closeHandler = () => {
    setClose(true);
  };

  const checkForError = (event) => {

    let eventName = event.target.name;
    let eventValue = event.target.value;

    setErrorMessage({
      firstName: checkFirstName(eventValue, eventName , errorMessage.firstName),
      lastName: checkLastName(eventValue, eventName , errorMessage.lastName),
      email: checkEmail(eventValue, eventName , errorMessage.email),
      phoneNumber: "",
      imageUrl: checkImageUrl(eventValue , eventName , errorMessage.imageUrl),
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

  return (
    <>
      {close ? (
        <button onClick={() => setClose(false)}>Show me the menu</button>
      ) : (
        <div className="modal">
          <div className="user-container">
            <Header closeHandler={closeHandler} />

            <Form
              closeHandler={closeHandler}
              formOnChange={formOnChange}
              formProp={formProp}
              checkForError={checkForError}
              errorMessage={errorMessage}
            />
          </div>
        </div>
      )}
    </>
  );
}

export default App;
