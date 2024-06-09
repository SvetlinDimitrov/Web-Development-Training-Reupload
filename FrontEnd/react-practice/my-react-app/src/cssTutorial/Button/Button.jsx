function Button() {

    const styles2 = {
        backgroundColor: "#77c5d3",
        color: "white",
        borderRadius: "5px",
        padding: "10px 20px",
        cursor: "pointer",
    }
    // return (<button className={styles.button}>Click me</button>);
    // return (<button className="button">Click me</button>);
    return (<button style={styles2}>Click me</button>);
}


export default Button

//First way (EXTERNAL) of doing it is to store the css in the index.html file (.button)
//Second way (MODULE) is module.css (Button.module.css)
//Third way (INLINE) is to use the style attribute (styles2) in the Button component