package JavaAdvance.Generics_Lab.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("ko");
        jar.add("ne");
        jar.add("6to");
        System.out.println(jar.remove());
        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
