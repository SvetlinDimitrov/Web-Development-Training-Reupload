function Form({
  closeHandler,
  formOnChange,
  formProp,
  checkForError,
  errorMessage,
}) {
  return (
    <form>
      <div className="form-row">
        <div className="form-group">
          <label htmlFor="firstName">First name</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-user"></i>
            </span>
            <input
              id="firstName"
              name="firstName"
              type="text"
              value={formProp.firstName}
              onChange={formOnChange}
              onBlur={checkForError}
            />
          </div>
          {errorMessage.firstName !=="" && (
            <p className="form-error">{errorMessage.firstName}</p>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="lastName">Last name</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-user"></i>
            </span>
            <input
              id="lastName"
              name="lastName"
              type="text"
              value={formProp.lastName}
              onChange={formOnChange}
              onBlur={checkForError}
            />
          </div>
          {errorMessage.lastName !== "" && (
            <p className="form-error">{errorMessage.lastName}</p>
          )}
        </div>
      </div>

      <div className="form-row">
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-envelope"></i>
            </span>
            <input
              id="email"
              name="email"
              type="text"
              value={formProp.email}
              onChange={formOnChange}
              onBlur={checkForError}
            />
          </div>
          {errorMessage.email !== "" && (
            <p className="form-error">{errorMessage.email}</p>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="phoneNumber">Phone number</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-phone"></i>
            </span>
            <input
              id="phoneNumber"
              name="phoneNumber"
              type="text"
              value={formProp.phoneNumber}
              onChange={formOnChange}
              onBlur={checkForError}
              
            />
          </div>
          <p className="form-error">Phone number is not valid!</p>
        </div>
      </div>

      <div className="form-group long-line">
        <label htmlFor="imageUrl">Image Url</label>
        <div className="input-wrapper">
          <span>
            <i className="fa-solid fa-image"></i>
          </span>
          <input
            id="imageUrl"
            name="imageUrl"
            type="text"
            value={formProp.imageUrl}
            onChange={formOnChange}
            onBlur={checkForError}
          />
        </div>
        {errorMessage.imageUrl !== "" && (
            <p className="form-error">{errorMessage.imageUrl}</p>
          )}
      </div>

      <div className="form-row">
        <div className="form-group">
          <label htmlFor="country">Country</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-map"></i>
            </span>
            <input
              id="country"
              name="country"
              type="text"
              value={formProp.country}
              onChange={formOnChange}
            />
          </div>
          <p className="form-error">
            Country should be at least 2 characters long!
          </p>
        </div>
        <div className="form-group">
          <label htmlFor="city">City</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-city"></i>
            </span>
            <input
              id="city"
              name="city"
              type="text"
              value={formProp.city}
              onChange={formOnChange}
            />
          </div>
          <p className="form-error">
            City should be at least 3 characters long!
          </p>
        </div>
      </div>

      <div className="form-row">
        <div className="form-group">
          <label htmlFor="street">Street</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-map"></i>
            </span>
            <input
              id="street"
              name="street"
              type="text"
              value={formProp.street}
              onChange={formOnChange}
            />
          </div>
          <p className="form-error">
            Street should be at least 3 characters long!
          </p>
        </div>
        <div className="form-group">
          <label htmlFor="streetNumber">Street number</label>
          <div className="input-wrapper">
            <span>
              <i className="fa-solid fa-house-chimney"></i>
            </span>
            <input
              id="streetNumber"
              name="streetNumber"
              type="text"
              value={formProp.streetNumber}
              onChange={formOnChange}
            />
          </div>
          <p className="form-error">
            Street number should be a positive number!
          </p>
        </div>
      </div>
      <div id="form-actions">
        <button id="action-save" className="btn" type="submit">
          Save
        </button>
        <button
          id="action-cancel"
          className="btn"
          type="button"
          onClick={closeHandler}
        >
          Cancel
        </button>
      </div>
    </form>
  );
}
export default Form;
