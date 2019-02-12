package be.ehb.opdrachtandroi_input;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class Reminder implements Serializable {

    private String titel;
    private String omschrijving;
    private Calendar datum;
    private String homepage;

    public Reminder() {
    }

    public Reminder(String titel, String omschrijving, Calendar datum, String homepage) {
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.datum = datum;
        this.homepage = homepage;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Calendar getDatum() {
        return datum;
    }

    public void setDatum(Calendar datum) {
        this.datum = datum;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "titel='" + titel + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                ", datum=" + datum +
                '}';
    }
}
