import { initializeApp } from "firebase/app";
import { getAuth , GoogleAuthProvider} from "firebase/auth";
import { getFirestore } from "firebase/firestore";

const firebaseConfig = {
    apiKey: "AIzaSyAizdh91sXsHqmSxuh2h-lPfeMp6fgSSkY",
    authDomain: "copper-affinity-407417.firebaseapp.com",
    projectId: "copper-affinity-407417",
    storageBucket: "copper-affinity-407417.appspot.com",
    messagingSenderId: "223220421458",
    appId: "1:223220421458:web:377c948d46a4a98a41a08b",
    measurementId: "G-76KFM00PT1"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const googleProvider = new GoogleAuthProvider();
export const db = getFirestore(app);