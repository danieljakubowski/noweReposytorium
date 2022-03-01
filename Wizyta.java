package testnr4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wizyta {
    public static List<Wizyta> ekstensja = new ArrayList<>();

    int idLekarza;
    int idPacjenta;
    LocalDate dataWizyty;
    Lekarz lekarz;
    Pacjent pacjent;

    public Wizyta(int idLekarza, int idPacjenta, LocalDate dataWizyty) {
        this.idLekarza = idLekarza;
        this.idPacjenta = idPacjenta;
        this.dataWizyty = dataWizyty;
        this.addLekarz(idLekarza);
        this.addPacjent(idPacjenta);
        this.pacjent.addWizyta(this);
        this.lekarz.addWizyta(this);


        ekstensja.add(this);

    }

    public static List<Wizyta> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Wizyta> ekstensja) {
        Wizyta.ekstensja = ekstensja;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(LocalDate dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public void addLekarz(int idLekarza) {
        for (Lekarz i : Lekarz.getEkstensja()) {
            if (i.getIdLekarza() == idLekarza) {
                this.lekarz = i;
            }
        }
    }

    public void addPacjent(int idPacjenta) {
        for (Pacjent i : Pacjent.getEkstensja()) {
            if (i.getIdPacjenta() == idPacjenta) {
                this.pacjent = i;
            }
        }
    }


    @Override
    public String toString() {
        return "Wizyta{" +
                "idLekarza=" + idLekarza +
                ", idPacjenta=" + idPacjenta +
                ", dataWizyty='" + dataWizyty + '\'' +
                '}';
    }
}

