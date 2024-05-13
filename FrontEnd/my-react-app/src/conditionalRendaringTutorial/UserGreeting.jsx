// function UserGreeting(props) {
//     if (props.isLoggedIn) {
//         return (<h5>Welcome {props.username}</h5>);
//     }
//     return <h5>Welcome Guest</h5>;
// }

// function UserGreeting(props) {
//     const loggedInStyle = {
//         fontSize: "2.5em",
//         backgroundColor: "green",
//         color: "white",
//         padding: "10px",
//         borderRadius: "10px",
//         margin: "0"
//     }
//     const notLoggedInStyle = {
//         fontSize: "2.5em",
//         backgroundColor: "red",
//         color: "white",
//         padding: "10px",
//         borderRadius: "10px",
//         margin: "0"
//     }
//     return (
//         props.isLoggedIn ?
//             <h5 style={loggedInStyle}>Welcome {props.username}</h5> :
//             <h5 style={notLoggedInStyle}>Welcome Guest</h5>
//     )
// }

import PropTypes from "prop-types";

function UserGreeting(props) {
    const loggedInStyle = {
        fontSize: "2.5em",
        backgroundColor: "green",
        color: "white",
        padding: "10px",
        borderRadius: "10px",
        margin: "0"
    }
    const notLoggedInStyle = {
        fontSize: "2.5em",
        backgroundColor: "red",
        color: "white",
        padding: "10px",
        borderRadius: "10px",
        margin: "0"
    }

    const loggedIn = <h5 style={loggedInStyle}>Welcome {props.username}</h5>;
    const notLoggedIn = <h5 style={notLoggedInStyle}>Welcome Guest</h5>;
    return (
        props.isLoggedIn ? loggedIn : notLoggedIn
    )
}

UserGreeting.propTypes = {
    isLoggedIn: PropTypes.bool,
    username: PropTypes.string
}

UserGreeting.defaultProps = {
    isLoggedIn: false,
    username: "Guest"
}

export default UserGreeting;