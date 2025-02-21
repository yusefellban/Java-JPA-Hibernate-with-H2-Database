package com.h2Database;

import jakarta.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) {
        ArrayList<Ausschreibung> ausschreibungen = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader("meerbusch-aktuelle-ausschreibungen.csv"))) {
            csvReader.readLine(); // تخطي العنوان
            String csvLine;
            while ((csvLine = csvReader.readLine()) != null) {
                String[] csvValues = csvLine.split(";");
                ausschreibungen.add(new Ausschreibung(
                        csvValues[0], csvValues[1], csvValues[2], csvValues[3], csvValues[4],
                        LocalDate.parse(csvValues[5].substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ausschreibung_pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        for (Ausschreibung ausschreibung : ausschreibungen) {
            em.persist(ausschreibung);
        }
        em.getTransaction().commit();

        List<Ausschreibung> results = em.createQuery("SELECT a FROM Ausschreibung a", Ausschreibung.class).getResultList();
        for (Ausschreibung a : results) {
            System.out.println("Titel: " + a.getTitel());
            System.out.println("Link: " + a.getUrl());
            System.out.println("Auftraggeber: " + a.getAuftragGeber());
            System.out.println("Vergabenummer: " + a.getVergabeNummer());
            System.out.println("Ausschreibungsart: " + a.getAusschreibungsArt());
            System.out.println("Angebotsabgabefrist: " + a.getAngebotsAbgabeFrist());
            System.out.println();
        }

        em.close();
        emf.close();
    }
}
