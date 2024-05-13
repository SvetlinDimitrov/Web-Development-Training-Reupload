function Button2() {
    // function handleClick() {
    //     console.log("Button Clicked");
    // }

    // const handleClick2 = (name) => {
    //     console.log("Button Clicked", name);
    // }

    const handleClick3 = (e) => {
        e.target.style.backgroundColor = 'red';
        e.target.textContent = 'Clicked';
    }
    return (
        <button onClick={(е)  => handleClick3(е)}>Click Me</button>
    )
}

export default Button2;