export default function Person({
    name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,
}) {
  return (
    <div className="character-card">
      <h1>Character Information</h1>
      <div className="character-info">
        <p>
          <span className="label">Name: {name}</span> 
        </p>
        <p>
          <span className="label">Height: {height}</span> 
        </p>
        <p>
          <span className="label">Mass: {mass}</span> 
        </p>
        <p>
          <span className="label">Hair Color: {hair_color}</span> 
        </p>
        <p>
          <span className="label">Skin Color: {skin_color}</span> 
        </p>
        <p>
          <span className="label">Eye Color: {eye_color}</span> 
        </p>
        <p>
          <span className="label">Birth Year: {birth_year}</span>
        </p>
        <p>
          <span className="label">Gender: {gender}</span> 
        </p>
      </div>
    </div>
  );
}
