function List() {
    const fruits = [
        {name: 'apple', calories: 95},
        {name: 'banana', calories: 105},
        {name: 'cherry', calories: 77},
        {name: 'date', calories: 282},
        {name: 'elderberry', calories: 73},
    ];
    fruits.sort((a, b) => a.calories - b.calories);

    const lowerCaloriesFruits = fruits.filter(fruit => fruit.calories < 100);

    const fruitList =
        lowerCaloriesFruits.map((fruit, index) =>
            <li key={index}> Name: {fruit.name} , Calories: {fruit.calories}</li>
        );

    return (<ol>{fruitList}</ol>);
}

export default List;