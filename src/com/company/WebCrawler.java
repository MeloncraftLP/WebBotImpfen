package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Level;

class WebCrawler {
    //Variablen und Objekte
    private String[] ImpfstandortURLs;
    String[] ImpfstandortNamen;
    private String ImpfzentrumURL, ImpfzentrumName;
    private int warteraumWarten;
    int Impfzentrum;
    private final WebDriver chrome;
    private String Nummer;
    private final Logging c;
    private final Mail m;

    int Setup(){
        //wird am Anfang ausgeführt
        c.deleteLog();
        try {
            c.readSettings();
            return c.UserSetup(); //User-Setup Funktion ausführen
        } catch(Exception EingabeFehler){
            System.out.println("\u001b[31m" + "Error: " + "Fehler bei Eingabe" + "\u001b[0m");
            Setup();
        }
        return -1;
    }

    //mit Nummer
    void ImpfstandortWahlen(String ImpfzentrumURL,String Nummer){
        try {
            chrome.get(ImpfzentrumURL); //Seite öffnen; warten
            Thread.sleep(300);
            try{
                //Ja klicken
                chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-login/div/div/div[2]/app-its-login-user/div/div/app-corona-vaccination/div[2]/div/div/label[1]")).click();
                try {
                    //warten; Nummer eingeben; warten; Termin Suchen clicken
                    Thread.sleep(300);
                    chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-login/div/div/div[2]/app-its-login-user/div/div/app-corona-vaccination/div[3]/div/div/div/div[1]/app-corona-vaccination-yes/form/div[1]/label/app-ets-input-code/div/div[1]/label/input")).sendKeys(Nummer);
                    Thread.sleep(300);
                    chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-login/div/div/div[2]/app-its-login-user/div/div/app-corona-vaccination/div[3]/div/div/div/div[1]/app-corona-vaccination-yes/form/div[2]/button")).click();
                    Thread.sleep(6000);
                    SeiteScannen(); //Ergebnis überprüfen
                }catch(Exception NummerNichtGesendet){
                    System.out.println("\u001b[31m" + "Error: " + "Termine konnten nicht überprüft werden" + "\u001b[0m");
                }
            }catch(Exception ButtonNotFound){
                if(chrome.getPageSource().contains("Virtueller Warteraum des Impfterminservice")){
                    //Warteraum vorhanden
                    System.out.println("Warteraum. Es wird 2 Minute gewartet und erneut geprüft");
                    c.AddToLog("Warteraum. Es wird 2 Minute gewartet und erneut geprüft");
                    Thread.sleep(120000);
                    ImpfstandortWahlen(getImpfzentrumURL(), getNummer()); //erneuter Versuch
                }
                else {
                    System.out.println("\u001b[31m" + "Error: " + "Button (Ja) konnte nicht gefunden werden" + "\u001b[0m");
                }
            }
        }catch(Exception NotConnected){
            System.out.println("\u001b[31m" + "Error: " + "Es konnte keine Verbindung hergestellt werden" + "\u001b[0m");
        }
    }

    //ohne Nummer
    void ImpfstandortWahlen(int Impfzentrum) {
        if(ImpfstandortURLs[Impfzentrum] != null && ImpfstandortNamen[Impfzentrum] != null) {
            try {
                chrome.get(ImpfstandortURLs[Impfzentrum]); //Website des jeweiligen Zentrums aufmachen
                System.out.println("Impfzentrum \u001b[33m" + ImpfstandortNamen[Impfzentrum] + "\u001b[0m wird untersucht");
                //Anspruch prüfen (Nein clicken)
                Thread.sleep(500);
                chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-login/div/div/div[2]/app-its-login-user/div/div/app-corona-vaccination/div[2]/div/div/label[2]")).click();
                SeiteScannen(Impfzentrum);
            } catch(Exception ButtonNotFound) {
                //Auf Warteraum prüfen (dann überspringen)
                if(chrome.getPageSource().contains("Virtueller Warteraum des Impfterminservice")) {
                    if(getWarteraumWarten() == 0) { //in 4min Abschnitten warten
                        try {
                            System.out.println("Warteraum. Es werden 4 Minuten gewartet");
                            c.AddToLog("" + ImpfstandortNamen[Impfzentrum] + " Warteraum. Es werden 4 Minuten gewartet");
                            Thread.sleep(240000); //danach: erneut scannen
                            chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-login/div/div/div[2]/app-its-login-user/div/div/app-corona-vaccination/div[2]/div/div/label[2]")).click();
                            SeiteScannen(Impfzentrum);
                        } catch(Exception Timer) {
                            System.out.println("\u001b[31m" + "Error: " + "Es wurde nicht 4 Minuten gewartet oder der Warteraum ist noch nicht beendet" + "\u001b[0m");
                        }
                    } //bzw überspringen
                    System.out.println("Warteraum. Wird übersprungen");
                    c.AddToLog("" + ImpfstandortNamen[Impfzentrum] + " Warteraum. Wird übersprungen");
                } else {
                    System.out.println("\u001b[31m" + "Error: " + "Button (Nein) konnte nicht gefunden werden" + "\u001b[0m");
                }
            }
        }
    }

    //mit Nummer
    private void SeiteScannen(){
        try {
            //Termin suchen clicken
            chrome.findElement(By.xpath("/html/body/app-root/div/app-page-its-search/div/div/div[2]/div/div/div[5]/div/div[1]/div[2]/div[2]/button")).click();
            Thread.sleep(6000);
            try{
                if(chrome.getPageSource().contains("Derzeit stehen leider keine Termine zur Verfügung")){
                    //kein Termin
                    System.out.println("\u001b[33m" + "Es wurde kein Impftermin gefunden" + "\u001b[0m");
                    c.AddToLog("Es wurde kein Termin gefunden");
                    System.out.println("Kein Termin. Es wird 2 Minute gewartet und erneut geprüft");
                    c.AddToLog("Kein Termin. Es wird 2 Minute gewartet und erneut geprüft");
                    Thread.sleep(120000);
                }
                else{
                    //Text(Kein Termin) wurde nicht gefunden --> ggf Termin
                    System.out.println("\n\n" + "\u001b[31m" + "Es liegt ein möglicher Impftermin vorhanden" + "\u001b[0m" + "\n\n");
                    c.AddToLog("\n\n"+"Es wurde ein möglicher Termin gefunden\n\n");
                    m.TerminGefunden(ImpfzentrumURL); //Email verschicken (10min warten)

                    System.out.println("\u001b[33m" + "Suche wird fortgesetzt" + "\u001b[0m");
                    c.AddToLog(ImpfzentrumName+": Suche wird fortgesetzt");
                }
            } catch(Exception FalscheSeite){
                System.out.println("\u001b[31m" + "Error: " + "Termine konnten nicht überprüft werden" + "\u001b[0m");
            }
        }catch(Exception ButtonNotFound){
            if(chrome.getPageSource().contains("Es ist ein unerwarteter Fehler aufgetreten")){
                //Fehler/kein Termin
                System.out.println("\u001b[33m" + "Es wurde kein Impftermin gefunden" + "\u001b[0m");
                c.AddToLog("Es wurde kein Termin gefunden");
            }
            else if(chrome.getPageSource().contains("Ungültiger Vermittlungscode")){
                System.out.println("\u001b[31m" + "Error: " + "Ungültige Vermittlungsnummer" + "\u001b[0m");
                Setup(); //Neustart
            }
            else {
                System.out.println("\u001b[31m" + "Error: " + "Nummer konnte nicht gesendet werden" + "\u001b[0m");
            }
        }
    }

    //ohne Nummer
    private void SeiteScannen(int Impfzentrum){
        //Anspruch prüfen (Nein)
        try {
            Thread.sleep(6000); //auf Antwort(freie Termine) warten und prüfen
            if(chrome.getPageSource().contains("Es wurden keine freien Termine in Ihrer Region gefunden.")) {
                //Kein Termin
                System.out.println("\u001b[33m" + "Es wurde kein Impftermin gefunden" + "\u001b[0m");
                c.AddToLog(ImpfstandortNamen[Impfzentrum]+": Es wurde kein Termin gefunden");
            } else {
                //Text(Kein Termin) wurde nicht gefunden --> ggf Termin
                System.out.println("\n\n" + "\u001b[31m" + ImpfstandortNamen[Impfzentrum] +" Es liegt ein möglicher Impftermin vorhanden" + "\u001b[0m" + "\n\n");
                c.AddToLog("\n\n"+ImpfstandortNamen[Impfzentrum]+": Es wurde ein möglicher Termin gefunden\n\n");
                m.TerminGefunden(ImpfstandortURLs[Impfzentrum]); //Email verschicken
                System.out.println("\u001b[33m" + "Suche wird fortgesetzt" + "\u001b[0m");
                c.AddToLog(ImpfstandortNamen[Impfzentrum]+": Suche wird fortgesetzt");
            }
        } catch (Exception NoResponse){
            System.out.println("\u001b[31m" + "Error: " +"Seite hat nicht geantwortet. Erneuter Versuch wird gestartet" + "\u001b[0m");
        }
    }


    //Konstruktor
    WebCrawler(Mail m) {
        //Objekte
        this.m = m;
        c = new Logging(m, this);

        System.setProperty("webdriver.chrome.silentOutput", "true"); //deaktiviert Start-Dialog
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        chrome = new ChromeDriver(); //initialisieren
        System.out.println("Web-Service wird gestartet");
    }

    //Getters
    String getImpfzentrumName() {
        return ImpfzentrumName;
    }

    String getImpfzentrumURL() {
        return ImpfzentrumURL;
    }

    String getNummer() {
        return Nummer;
    }

    private int getWarteraumWarten() {
        return warteraumWarten;
    }

    //Setters
    void setImpfzentrumName(String impfzentrumName) {
        ImpfzentrumName = impfzentrumName;
    }

    void setImpfzentrumURL(String impfzentrumURL) {
        ImpfzentrumURL = impfzentrumURL;
    }

    void setNummer(String nummer) {
        Nummer = nummer;
    }

    void setWarteraumWarten(int warteraumWarten) {
        this.warteraumWarten = warteraumWarten;
    }

    void setImpfstandortNamen(String[] impfstandortNamen) {
        ImpfstandortNamen = impfstandortNamen;
    }

    void setImpfstandortURLs(String[] impfstandortURLs) {
        ImpfstandortURLs = impfstandortURLs;
    }

}