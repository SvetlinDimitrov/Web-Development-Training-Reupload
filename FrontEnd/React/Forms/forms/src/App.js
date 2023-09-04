import Header from "./components/Header";
import Form from "./components/Form";
import { useState } from "react";
import { useForm } from "./components/useForm";
import { AppContext } from "./AppContext";



function App() {
  const [close, setClose] = useState(false);
  let constFormData = {
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    imageUrl: "",
    country: "",
    city: "",
    street: "",
    streetNumber: "",
  };
  const { formProp, errorMessage, formOnChange, checkForError } = useForm(
    constFormData,
    constFormData
  );

  const closeHandler = () => {
    setClose(true);
  };

  return (
    <>
      <AppContext.Provider value={{closeHandler , formProp, errorMessage, formOnChange, checkForError}}>
        {close ? (
          <button onClick={() => setClose(false)}>Show me the menu</button>
        ) : (
          <div className="modal">
            <div className="user-container">
              <Header />

              <Form />
            </div>
          </div>
        )}
      </AppContext.Provider>
    </>
  );
}

export default App;
