import {Routes , Route} from 'react-router-dom';
import { CountryList } from './components/CountryList';
import Header from './components/Header';

function App() {

  return (
	<>
		<Header /> 

    	<Routes>
			<Route path="/country/*" element={<CountryList />}> </Route>
			<Route path="/" element={<h1>Welcome To HomePage</h1>}> </Route>
			<Route path="*" element={<h1>404 Error</h1>}> </Route>
		</Routes>

	</>
  );
}

export default App;
