public class Main {
    public static void main(String[] args) {
        try {
            Secchio s1 = new Secchio(5.5, 6);
            Secchio s2 = new Secchio(s1);
            Secchio s3 = new Secchio(0.5, 7);

            s1.travasa(s2, 0.2);
            System.out.println("s1 volume: " + s1.getVolume());
            System.out.println("s2 volume: " + s2.getVolume());

            System.out.println("Compare: " + s1.compareTo(s2));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}