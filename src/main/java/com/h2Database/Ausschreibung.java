package com.h2Database;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ausschreibungen")
public class Ausschreibung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;
    private String url;
    private String auftragGeber;
    private String vergabeNummer;
    private String ausschreibungsArt;
    private LocalDate angebotsAbgabeFrist;

    public Ausschreibung() {}

    public Ausschreibung(String titel, String url, String auftragGeber, String vergabeNummer, String ausschreibungsArt, LocalDate angebotsAbgabeFrist) {
        this.titel = titel;
        this.url = url;
        this.auftragGeber = auftragGeber;
        this.vergabeNummer = vergabeNummer;
        this.ausschreibungsArt = ausschreibungsArt;
        this.angebotsAbgabeFrist = angebotsAbgabeFrist;
    }

    public String getTitel() {
        return titel;
    }

    public String getUrl() {
        return url;
    }

    public String getAuftragGeber() {
        return auftragGeber;
    }

    public String getVergabeNummer() {
        return vergabeNummer;
    }

    public String getAusschreibungsArt() {
        return ausschreibungsArt;
    }

    public LocalDate getAngebotsAbgabeFrist() {
        return angebotsAbgabeFrist;
    }
}
