public class Secchio {
    private double volume;
    private double capacita;

    public Secchio(double volume, double capacita) throws Exception{
        if(volume <= 0 || capacita <= 0) throw new Exception("Valori non validi");
        this.volume = volume;
        this.capacita = capacita;
    }

    public double getVolume() {
        return volume;
    }

    public double getCapacita() {
        return capacita;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
