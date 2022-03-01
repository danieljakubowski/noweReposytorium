package testnr4;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Lekarz implements Comparable<Lekarz> {
    public static List<Lekarz> ekstensja = new ArrayList<>();

    int idLekarza;
    String nazwisko;
    String imie;
    String specjalnosc;
    LocalDate dataUrodzenia;
    String NIP;
    String pesel;
    List<Wizyta> listaWizyt;

    public Lekarz(int idLekarza, String nazwisko, String imie, String specjalnosc, LocalDate dataUrodzenia, String NIP, String pesel) throws FileNotFoundException {
        this.idLekarza = idLekarza;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.specjalnosc = specjalnosc;
        this.dataUrodzenia = dataUrodzenia;
        this.NIP = NIP;
        this.pesel = pesel;
        this.listaWizyt = new ArrayList<>();

        ekstensja.add(this);
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public static List<Lekarz> getEkstensja() {
        return ekstensja;
    }


    public void addWizyta(Wizyta wizyta) {
        this.listaWizyt.add(wizyta);
    }


    @Override
    public String toString() {
        return "Lekarz{" +
                "idLekarza=" + idLekarza +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", specjalnosc='" + specjalnosc + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", NIP='" + NIP + '\'' +
                ", pesel='" + pesel + '\'' +
                ", listaWizyt=" + listaWizyt +
                '}';
    }

    @Override
    public int compareTo(Lekarz o) {
        return Integer.compare(Period.between(this.getDataUrodzenia(), LocalDate.now()).getYears(),
                Period.between(o.getDataUrodzenia(), LocalDate.now()).getYears());

    }

}

