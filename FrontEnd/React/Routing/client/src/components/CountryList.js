import { useEffect, useState } from "react";
import { Link, Route, Routes ,useParams  } from "react-router-dom";

export function CountryList() {
  const [country, setCountry] = useState([]);

  useEffect(() => {
    fetch("https://restcountries.com/v3.1/all")
      .then((data) => data.json())
      .then((data) => {
        data.forEach((data) => setCountry((state) => [...state, data.name]));
      });
  }, []);

  return (
    <>
      <ul>
        {country.map((data) => (
          <li key={data.common}>
            <Link to={`${data.common}`}>{data.common}</Link>
          </li>
        ))}
      </ul>

      <Routes>
        <Route path="/:name" element={<Country />} />
      </Routes>
    </>
  );
}

export function Country() {

  let { name } = useParams();
  const [country, setCountry] = useState({});
  
  useEffect(() => {
    fetch(`https://restcountries.com/v3.1/name/${name}`)
      .then((data) => data.json())
      .then((data) => setCountry(data[0]))
  }, [name]);

  console.log(country)

  return (
    <h1>{country.cca2}</h1>
  );

}
