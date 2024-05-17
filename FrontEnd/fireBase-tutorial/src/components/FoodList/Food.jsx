/* src/components/FoodList/Food.jsx */
import styles from './Food.module.css';

function Food({food}) {
    return (
        food && (
            <div className={styles.foodItem}>
                <h2>{food.name}</h2>
                <p>Protein: {food.protein}</p>
                <p>Fat: {food.fat}</p>
                <p>Carbs: {food.carbs}</p>
            </div>
        )
    );
}

export default Food;