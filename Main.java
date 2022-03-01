package testnr4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner inputLekarz = new Scanner(new BufferedReader(new FileReader("lekarze.txt")));
        List<Lekarz> listLekarz = new ArrayList<>();
        inputLekarz.nextLine();
        while (inputLekarz.hasNext()) {
            int idLekarza = inputLekarz.nextInt();
            String nazwisko = inputLekarz.next();
            String imie = inputLekarz.next();
            String specjlanosc = inputLekarz.next();
            LocalDate dataUrodzenia = dataUrodzenia(inputLekarz.next());
            String nip = inputLekarz.next();
            String pesel = inputLekarz.next();
            Lekarz newLekarz = new Lekarz(idLekarza, nazwisko, imie, specjlanosc, dataUrodzenia, nip, pesel);
            listLekarz.add(newLekarz);
        }


        Scanner inputPacjent = new Scanner(new BufferedReader(new FileReader("pacjenci.txt")));
        List<Pacjent> listPacjent = new ArrayList<>();
        inputPacjent.nextLine();
        while (inputPacjent.hasNext()) {
            int idPacjenta = inputPacjent.nextInt();
            String nazwisko = inputPacjent.next();
            String imie = inputPacjent.next();
            String pesel = inputPacjent.next();
            LocalDate dataUrodzenia = dataUrodzenia(inputPacjent.next());
            Pacjent newPacjent = new Pacjent(idPacjenta, nazwisko, imie, pesel, dataUrodzenia);
            listPacjent.add(newPacjent);


        }

        Scanner inputWizyta = new Scanner(new BufferedReader(new FileReader("wizyty.txt")));
        List<Wizyta> listWizyta = new ArrayList<>();
        inputWizyta.nextLine();
        while (inputWizyta.hasNext()) {
            int idLekarza = inputWizyta.nextInt();
            int idPacjenta = inputWizyta.nextInt();
            LocalDate dataWizyty = dataUrodzenia(inputWizyta.next());
            Wizyta newWizyta = new Wizyta(idLekarza, idPacjenta, dataWizyty);
            listWizyta.add(newWizyta);
        }

        ktoryLekarzMialNajwiecejWizyt();
        System.out.println("----------------------");
        ktoryPacjentMialNajwiecejWizyt();
        System.out.println("----------------------");
        ktoraSpecjalizacjaNajpopularniejsza();
        System.out.println("----------------------");
        ktoregoRokuNakjwiecejWizyt();
        System.out.println("----------------------");
        top5NajstarszychLekarzy();
        System.out.println("----------------------");
        czyJestPacjentKtoryMialWizytyU5RoznychLekarzy();
        System.out.println("----------------------");
        czyJestLekarzKtoryprzyjmowalJednegoPacjenta();


    }

    public static LocalDate dataUrodzenia(String slowo) {
        var data = slowo.split("-");
        int rok = Integer.parseInt(data[0]);
        int miesiac = Integer.parseInt(data[1]);
        int dzien = Integer.parseInt(data[2]);
        return LocalDate.of(rok, miesiac, dzien);
    }

    public static void ktoryLekarzMialNajwiecejWizyt() {
        int ilsoc = Integer.MIN_VALUE;
        String lekarz = null;
        for (Lekarz i : Lekarz.getEkstensja()) {
            if (i.listaWizyt.size() >= ilsoc) {
                lekarz = i.getImie() + " " + i.getNazwisko();
                ilsoc = i.listaWizyt.size();
            }
        }
        System.out.println("Najwiecej wizyt ma lekarz: " + lekarz + ", ilosc wizyt = " + ilsoc);
    }

    public static void ktoryPacjentMialNajwiecejWizyt() {
        int ilosc = Integer.MIN_VALUE;
        String pacjent = null;
        for (Pacjent i : Pacjent.getEkstensja()) {
            if (i.listaWizyt.size() >= ilosc) {
                pacjent = i.getImie() + " " + i.getNazwisko();
                ilosc = i.listaWizyt.size();
            }

        }
        System.out.println("Najwiecej wizyt ma Pacjent " + pacjent + ", ilosc wizyt = " + ilosc);
    }


    public static void ktoraSpecjalizacjaNajpopularniejsza() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String specjalnosc = null;
        for (Lekarz i : Lekarz.getEkstensja()) {
            specjalnosc = i.getSpecjalnosc();
            if (map.containsKey(specjalnosc)) {
                map.put(specjalnosc, map.get(specjalnosc) + i.listaWizyt.size());
            } else {
                map.put(specjalnosc, i.listaWizyt.size());
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        String key = null;
        int value = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> i : set) {
            if (i.getValue() >= value) {
                value = i.getValue();
                key = i.getKey();
            }
        }
        System.out.println("Najpopularniejsza specjalizacja to " + key + ", ilosc wizyt = " + value);

    }


    public static void ktoregoRokuNakjwiecejWizyt() {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rokWizyty = 0;
        for (Wizyta i : Wizyta.getEkstensja()) {
            rokWizyty = i.getDataWizyty().getYear();
            if (map.containsKey(rokWizyty)) {
                map.put(rokWizyty, map.get(rokWizyty) + 1);
            } else {
                map.put(rokWizyty, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Integer key = null;
        int value = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> i : set) {
            if (i.getValue() >= value) {
                value = i.getValue();
                key = i.getKey();
            }
        }
        System.out.println("Najwiecej wizyt bylo w roku, " + key + ", ilosc wizyt = " + value);
    }


    public static void top5NajstarszychLekarzy() {
        List<Lekarz> zawartoscEktensji = new ArrayList<>(Lekarz.getEkstensja());
        Collections.sort(zawartoscEktensji);
        Collections.reverse(zawartoscEktensji);
        System.out.println("Top 5 najstarszych lekarzy");
        for (int i = 0; i < 5; i++) {
            System.out.println(zawartoscEktensji.get(i));
        }


    }

    public static void czyJestPacjentKtoryMialWizytyU5RoznychLekarzy() {
        HashSet<Integer> newset = new HashSet<>();
        List<Pacjent> pacjentList = new ArrayList<>();
        for (Pacjent i : Pacjent.getEkstensja()) {
            for (Wizyta ii : i.listaWizyt) {
                newset.add(ii.getIdLekarza());
            }
            if (newset.size() > 5) {
                pacjentList.add(i);
            }
            newset.clear();
        }
        if (pacjentList.isEmpty()) {
            System.out.println("Nie ma pacjenta ktory ma wiecej niz piec wizyt u roznych lekarzy");
        } else {
            System.out.println("Pacjenci ktorzy mieli wizyty u wiecej niz pieciu roznych lekarzy:");
            for (Pacjent i : pacjentList) {
                System.out.println(i);
            }
        }
    }


    public static void czyJestLekarzKtoryprzyjmowalJednegoPacjenta() {
        List<Integer> newlist = new ArrayList<>();
        List<Lekarz> lekarzList = new ArrayList<>();
        for (Lekarz i : Lekarz.getEkstensja()) {
            for (Wizyta ii : i.listaWizyt) {
                newlist.add(ii.getIdPacjenta());
            }
            boolean allEqual = newlist.stream().distinct().limit(2).count() <= 1;
            if (allEqual) {
                lekarzList.add(i);
            }
            newlist.clear();
        }
        if (lekarzList.isEmpty()) {
            System.out.println("Nie ma lekarza ktory mial wizyty tylko u jednego pacjenta ");
        } else {
            System.out.println("Lekarze ktorzy mieli wizyty tylko u jednego pacjenta: ");
            for (Lekarz i : lekarzList) {
                System.out.println(i);

            }
        }

    }
}

