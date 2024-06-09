import reactLogo from '../assets/react.svg';

function Card() {
    return (
        <div className="card">
            <img className="card-image" alt="react" src={reactLogo}></img>
            <h2 className="card-title">Card Title</h2>
            <p className="card-text">Card Description</p>
        </div>
    )
}

export default Card;