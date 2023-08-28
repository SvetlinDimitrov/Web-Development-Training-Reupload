import HeroSection from "./components/Header";
import AboutSection from "./components/About";
import PortfolioSection from "./components/Portfolio";
import Service from "./components/Service";
import Client from "./components/Client";
import Info from "./components/Info";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="App">
      
        <HeroSection/>
        <AboutSection/>
        <PortfolioSection/>
        <Service/>
        <Client/>
        <Info/>
        <Footer/>
    </div>
  );
}

export default App;
