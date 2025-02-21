package com.h2Database;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProgramTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeAll
    void setup() {
        emf = Persistence.createEntityManagerFactory("ausschreibung_pu");
        em = emf.createEntityManager();
    }

    @AfterAll
    void teardown() {
        em.close();
        emf.close();
    }

    @Test
    void testCsvReading() throws Exception {
        ArrayList<Ausschreibung> ausschreibungen = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader("meerbusch-aktuelle-ausschreibungen.csv"))) {
            csvReader.readLine(); // Skip header
            String csvLine;
            while ((csvLine = csvReader.readLine()) != null) {
                String[] csvValues = csvLine.split(";");
                ausschreibungen.add(new Ausschreibung(
                        csvValues[0], csvValues[1], csvValues[2], csvValues[3], csvValues[4],
                        LocalDate.parse(csvValues[5].substring(0, 10))
                ));
            }
        }
        assertFalse(ausschreibungen.isEmpty(), "CSV file should not be empty");
    }

    @Test
    void testDatabaseInsertion() {
        Ausschreibung testAusschreibung = new Ausschreibung(
                "Test Title", "https://test.url", "Test Auftraggeber",
                "12345", "Test Art", LocalDate.now()
        );

        em.getTransaction().begin();
        em.persist(testAusschreibung);
        em.getTransaction().commit();

        Ausschreibung retrieved = em.find(Ausschreibung.class, testAusschreibung.getId());
        assertNotNull(retrieved, "Object should be saved in DB");
        assertEquals("Test Title", retrieved.getTitel());
    }

    @Test
    void testJPQLQuery() {
        List<Ausschreibung> results = em.createQuery("SELECT a FROM Ausschreibung a", Ausschreibung.class).getResultList();
        assertNotNull(results, "Query should return results");
        assertFalse(results.isEmpty(), "Query should return at least one result");
    }
}
