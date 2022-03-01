package testnr4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacjent {
    public static List<Pacjent> ekstensja = new ArrayList<>();

    int idPacjenta;
    String nazwisko;
    String imie;
    String pesel;
    LocalDate dataUrodzenia;
    List<Wizyta> listaWizyt;

    public Pacjent(int idPacjenta, String nazwisko, String imie, String pesel, LocalDate dataUrodzenia) {
        this.idPacjenta = idPacjenta;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.listaWizyt = new ArrayList<>();


        ekstensja.add(this);

    }

    public static List<Pacjent> getEkstensja() {
        return ekstensja;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        pesel = pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        dataUrodzenia = dataUrodzenia;
    }

    public void addWizyta(Wizyta wizyta) {
        this.listaWizyt.add(wizyta);
    }


    @Override
    public String toString() {
        return "Pacjent{" + "idPacjenta=" + idPacjenta + ", nazwisko='" + nazwisko + '\'' + ", imie='" + imie + '\'' + ", pesel='" + pesel + '\'' + ", dataUrodzenia='" + dataUrodzenia + '\'' + ", wizyta=" + listaWizyt + '}';
    }
}

