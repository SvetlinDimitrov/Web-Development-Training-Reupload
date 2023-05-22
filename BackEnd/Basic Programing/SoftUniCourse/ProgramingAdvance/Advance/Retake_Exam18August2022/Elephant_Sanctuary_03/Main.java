package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2022.Elephant_Sanctuary_03;

public class Main {
    public static void main(String[] args) {
        Habitat park = new Habitat(10);
        Elephant firstElephant = new Elephant("Bobby", 10, "Thailand Zoo");
        System.out.println(firstElephant);
        park.add(firstElephant);
        System.out.println(park.remove("Bobby"));
        System.out.println(park.remove("Lola"));
        Elephant secondElephant = new Elephant("Bibi", 5, "Private Zoo");
        Elephant thirdElephant = new Elephant("Lola", 7, "National Circus of Thailand");
        park.add(secondElephant);
        park.add(thirdElephant);
        Elephant oldest = park.getOldestElephant();
        System.out.println(oldest);
        Elephant elephant = park.getElephant("Private Zoo");
        System.out.println(elephant);
        System.out.println(park.getAllElephants());
        System.out.println(park.getReport());
    }
}
