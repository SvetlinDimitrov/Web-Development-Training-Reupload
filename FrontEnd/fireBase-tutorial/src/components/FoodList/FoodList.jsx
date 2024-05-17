/* src/components/FoodList/FoodList.jsx */
import Food from './Food';
import styles from './FoodList.module.css';
import {db} from "../../firebase";
import {useEffect, useState} from "react";
import {doc, getDoc} from "firebase/firestore";

function FoodList() {

    const [food, setFood] = useState();
    useEffect(() => {
        // //Reading embeded document
        // getDoc(doc(db, "foods_embeded", "a1eo3rt1sdD26rhB8nRA"))
        //     .then((doc) => {
        //     if (doc.exists) {
        //         setFood(doc.data());
        //     } else {
        //         console.log("No such document!");
        //     }
        // }).catch((error) => {
        //     console.log("Error getting document:", error);
        // });

        //Reading collection document
        // getDoc(doc(db, "foods_subcollection", "KpFXpFzjMZ908et7beiw"))
        //     .then((docSnapshot) => {
        //         if (docSnapshot.exists) {
        //             let food = {
        //                 name: docSnapshot.data().name,
        //             };
        //             // Get all documents in the subcollection
        //             getDocs(collection(docSnapshot.ref, "macro"))
        //                 .then((querySnapshot) => {
        //                     querySnapshot.docs.forEach(
        //                         (doc) => {
        //                             food.protein = doc.data().protein;
        //                             food.fat = doc.data().fat;
        //                             food.carbs = doc.data().carbs;
        //                         });
        //                     setFood(food);
        //                 });
        //         } else {
        //             console.log("No such document!");
        //         }
        //     }).catch((error) => {
        //     console.log("Error getting document:", error);
        // });

        // Reading using Bucket strategy
        // Promise.all([
        //     getDoc(doc(db, "foods_buget", "BGkrwhZodvVMbAEDGEI5")),
        //     getDoc(doc(db, "marco_buget", "BGkrwhZodvVMbAEDGEI5"))
        // ]).then(([foodsBucketDoc, marcoBugetDoc]) => {
        //     if (foodsBucketDoc.exists) {
        //         setFood({"name": foodsBucketDoc.data()?.name});
        //     } else {
        //         console.log("No such document in Foods Bucket!");
        //     }
        //
        //     if (marcoBugetDoc.exists) {
        //         setFood(food => ({
        //             ...food,
        //             protein: marcoBugetDoc.data()?.protein,
        //             fat: marcoBugetDoc.data()?.fat,
        //             carbs: marcoBugetDoc.data()?.carbs
        //         }));
        //     } else {
        //         console.log("No such document in Marco Buget!");
        //     }
        // }).catch((error) => {
        //     console.log("Error getting documents:", error);
        // });
    }, []);
    return (
        <div className={styles.foodList}>
            <Food key={0} food={food}/>
        </div>
    );
}

export default FoodList;