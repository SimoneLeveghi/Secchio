public class Main {
    public static void main(String[] args) {
        try {
            Secchio s1 = Secchio.generaSecchioRandom();
            Secchio s2 = new Secchio(s1);
            Secchio s3 = Secchio.generaSecchioRandom();

            s1.travasa(s2, 0.2);
            System.out.println("s1 volume: " + s1.getVolume());
            System.out.println("s1 capacità: " + s1.getCapacita());
            System.out.println("s2 volume: " + s2.getVolume());
            System.out.println("s2 capacità: " + s2.getCapacita());
            System.out.println("s3 volume: " + s3.getVolume());
            System.out.println("s3 capacità: " + s3.getCapacita());

            System.out.println("Compare s1 to s2: " + s1.compareTo(s2));
            System.out.println("Compare s1 to s3: " + s1.compareTo(s3));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}