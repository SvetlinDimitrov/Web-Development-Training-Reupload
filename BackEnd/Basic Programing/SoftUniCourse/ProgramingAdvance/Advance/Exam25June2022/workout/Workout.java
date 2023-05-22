package JavaAdvance.Exams.Java_Advanced_Exam25June2022.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise){
        if(exercises.size()<exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (int i = 0; i < exercises.size(); i++) {
            if(exercises.get(i).getMuscle().equals(muscle) && exercises.get(i).getName().equals(name)){
                exercises.remove(i);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if (exercise.getMuscle().equals(muscle) && exercise.getName().equals(name)) {
                return exercise;
            }
        }
        return null;
    }


    public String getType() {
        return type;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max((f,s)->Integer.compare(f.getBurnedCalories() , s.getBurnedCalories())).orElse(null);
    }

    public int getExerciseCount(){
        return exercises.size();
    }

    public String getStatistics(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("Workout type: %s%n",getType()));
        for (Exercise exercise : exercises) {
            print.append(String.format("Exercise: %s%n",exercise));
        }
        return print.toString();
    }
}
