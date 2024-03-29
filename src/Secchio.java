import com.google.gson.Gson;
import java.util.Random;
import java.io.Serializable;

public class Secchio implements Cloneable, Comparable<Secchio>, Serializable {
    private double volume;
    private double capacita;

    public Secchio(double capacita) throws Exception{
        this(0, capacita);
    }

    public Secchio(double volume, double capacita) throws Exception{
        if((volume <= 0 || capacita <= 0) || volume > capacita) throw new Exception("Valori non validi");
        this.volume = volume;
        this.capacita = capacita;
    }

    public Secchio(Secchio s) {
        this.volume = s.volume;
        this.capacita = s.capacita;
    }

    public Secchio(String json) {
        this(new Gson().fromJson(json, Secchio.class));
    }

    public double getVolume() {
        return volume;
    }

    public double getCapacita() {
        return capacita;
    }

    public void setVolume(double volume) throws Exception{
        if(this.volume < 0 || this.volume > this.capacita) throw new Exception("Volume non valido");
        this.volume = volume;
    }

    public boolean isVuoto() {
        return this.volume == 0;
    }

    public boolean isPieno() {
        return this.volume == this.capacita;
    }

    public double riempi() {
        double ret = volume;
        this.volume = this.capacita;
        return this.capacita - ret;
    }

    public double riempi(double qty) {
        return (volume += (Math.min(qty, capacita - volume)));
    }

    public void svuota() {
        this.volume = 0;
    }

    public void svuota(double qty) {
        this.volume -= Math.min(qty, volume);
    }

    public void travasa(Secchio s) {
        this.volume = s.riempi(volume);
    }

    public void travasa(Secchio s, double qty) {
        double quantitaTravaso = Math.min(qty, volume);
        this.volume -= quantitaTravaso;
        s.riempi(quantitaTravaso);
    }

    public static Secchio generaSecchioRandom() {
        Random r = new Random();
        double capacita = r.nextDouble() * 100D;
        double volume = r.nextDouble() * capacita;
        Secchio ret;
        try {
            ret = new Secchio(volume, capacita);
        }
        catch(Exception e) {
            ret = null;
        }

        return ret;

    }

    @Override
    public Secchio clone() {
        return new Secchio(this);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public int compareTo(Secchio s) {
        double value = this.capacita - s.capacita;
        return (int) (value >= 0 ? Math.ceil(value) : Math.floor(value));
    }
}
