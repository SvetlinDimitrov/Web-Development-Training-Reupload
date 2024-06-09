function Food() {

    const food1 = "Pizza";
    const food2 = "Burger";

    return (
        <div>
            <h3>My favourite food</h3>
            <ul>
                <li>{food1}</li>
                <li>{food2}</li>
            </ul>
        </div>
    );
}

export default Food;