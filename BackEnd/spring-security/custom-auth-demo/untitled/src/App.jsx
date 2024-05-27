// App.jsx
import {Route, Routes} from 'react-router-dom';
import Navigation from './Navigation';
import View1 from './View1';
import View2 from './View2.jsx';
import Home from "./Home.jsx";

function App() {
    return (
        <>
            <Navigation/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/view1" element={<View1/>}/>
                <Route path="/view2" element={<View2/>}/>
            </Routes>
        </>
    );
}

export default App;