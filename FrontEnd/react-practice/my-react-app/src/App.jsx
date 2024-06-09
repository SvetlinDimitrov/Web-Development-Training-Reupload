import Header from "./components/Header.jsx";
import Footer from "./components/Footer.jsx";
import Card from "./components/Card.jsx";
import Button from "./cssTutorial/Button/Button.jsx";
import Student from "./propsTutorial/Student.jsx";
import UserGreeting from "./conditionalRendaringTutorial/UserGreeting.jsx";
import List from "./rendaringListsTutorial/List.jsx";
import Button2 from "./clickEventsTutorial/Button.jsx";
import MyComponent from "./useState/MyComponent.jsx";
import OnChangeExample from "./onChange/OnChangeExample.jsx";
import StateObject from "./useState/StateObject.jsx";
import ArrayState from "./useState/ArrayState.jsx";
import UseContextParent from "./useContext/UseContextParent.jsx";

function App() {

    return (
        <>
            <Header/>
            <Card/>
            <Button/>
            <Student name="John" age={30} isStudent={true}/>
            <UserGreeting isLoggedIn={true} username="BroCode"/>
            <UserGreeting isLoggedIn={false} username="BroCode"/>
            <List/>
            <Button2/>
            <MyComponent/>
            <OnChangeExample/>
            <StateObject/>
            <ArrayState/>
            <UseContextParent/>
            <Footer/>
        </>
    )
}

export default App
