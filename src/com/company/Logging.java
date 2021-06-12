package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

class Logging {
    //Variablen und Objekte
    private Date date = new Date();
    private final Timestamp timestamp = new Timestamp(date.getTime());
    private final File logFile;
    private final File SettingsFile;
    private FileWriter fw;
    private PrintWriter pw;
    private int modus;
    private final Scanner keyboardscanner = new Scanner(System.in);
    private final WebCrawler s;
    private final Mail m;

    void deleteLog(){
        try {
            //Init
            fw = new FileWriter(logFile,false);
            pw = new PrintWriter(fw);
            //überschreiben
            pw.println("");
            pw.close();
        } catch(Exception LogWurdeNichtGeschrieben) {
            System.out.println("\u001b[31m" + "Error: " + "Log konnte nicht gelöscht werden" + "\u001b[0m");
        }
    }

    void readSettings()
    {
        try{
            //Aus Datei Einstellungen laden
            String[] temp = new String[20];
            String[] temp2 = new String[20];
            int i = 0;
            Scanner filescanner = new Scanner(SettingsFile);
            filescanner.nextLine(); //leere Zeilen überspringen
            filescanner.nextLine();
            m.setEmail(""+ filescanner.nextLine()); //email, nummer, name, url(für "Nummerbetrieb") auslesen und in Variable speichern
            s.setNummer(""+ filescanner.nextLine());
            s.setImpfzentrumName(""+ filescanner.nextLine());
            s.setImpfzentrumURL(""+ filescanner.nextLine());
            filescanner.nextLine();
            //die nächsten 20 Impfzentren (Name und URL) auslesen
            while(filescanner.hasNextLine()){
                temp2[i] = ""+ filescanner.nextLine() + "";
                temp[i] = ""+ filescanner.nextLine();
                i++;
            }
            //in die "echten" Variablen übergeben
            s.setImpfstandortURLs(temp);
            s.setImpfstandortNamen(temp2);
            System.out.println("Standards wurden geladen!");
        } catch(Exception e){
            System.out.println("\u001b[31m"+"Error: " + "Einstellungen konnte nicht geladen werden" + "\u001b[0m");
        }
    }


    void AddToLog(String Nachricht){
        try {
            //Init
            fw = new FileWriter(logFile,true);
            pw = new PrintWriter(fw);
            //Zu Log schreiben
            date = new Date();
            pw.println(""+ timestamp +"\t\t"+ Nachricht);
            pw.close();
        } catch(Exception LogWurdeNichtGeschrieben) {
            System.out.println("\u001b[31m" + "Error: " + "Log konnte nicht initialisiert werden" + "\u001b[0m");
        }
    }

    int UserSetup(){
        //Hier kann der Nutzer Einstellungen an dem Programm vornehmen

        //Email prüfen
        int tempinput;
        System.out.println("Überprüfen Sie bitte die Daten! 1 = ändern; 0 = weiter");
        System.out.println("Email-Addresse: " + m.getEmail());
        tempinput = keyboardscanner.nextInt();
        if(tempinput==1){
            //ändern
            System.out.println("Geben Sie bitte die neuen E-Mail Addresse ein und bestätigen Sie mit Enter");
            m.setEmail(keyboardscanner.next());
        }

        //Modus (Nummer/keine Nummer) -> (Ja, Nein)
        System.out.println("Wählen Sie den Modus aus! 1 = Anspruch prüfen; 0 = Terminnummer abfragen");
        tempinput = keyboardscanner.nextInt();
        if(tempinput==0){
            //Modus Nummer
            System.out.println("Modus: Termin suchen (Nummer)");
            //Vermittlungsnummer und Impfzentrum prüfen
            System.out.println("Überprüfen Sie bitte die Daten! 1 = ändern; 0 = weiter");
            System.out.println("Vermittlungsnummer: " + s.getNummer() + "\n Impfzentrum und zugehörige URL: " + s.getImpfzentrumName());
            tempinput = keyboardscanner.nextInt();
            if(tempinput==1) {
                //ändern
                System.out.println("Geben Sie Ihre Nummer ohne Bindestriche/Leerzeichen ein.");
                s.setNummer(keyboardscanner.next());
                System.out.println("Geben Sie die URL ihres Impfzentrums ein. (Öffnen Sie hierzu den Browser und wählen Sie ihr gewünschtes Impfzentrum an. Kopieren sie anschließend die URL und fügen Sie hier ein.)");
                s.setImpfzentrumURL("" + keyboardscanner.next());
            }
            modus = 0;
        }
        else if(tempinput==1){
            //Modus Anspruch überprüfen
            System.out.println("Modus: Anspruch prüfen");
            System.out.println("Um Warteräume zu überspringen, drücken sie 1; um 4 Minuten zu warten 0");
            tempinput=keyboardscanner.nextInt();
            s.setWarteraumWarten(tempinput);
            System.out.print("Ausgewählte Impfzentren: ");
            for(int i = 0; i < s.ImpfstandortNamen.length; i++)
                System.out.print(s.ImpfstandortNamen[i] + "   "); //Ausgewählte Orte ausgeben
            System.out.println("\nUm die Standorte zu ändern, modifizieren Sie die 'ProgrammEinstellungen.txt' nach den Vorgaben!");
            modus = 1;
        }
        else{
            UserSetup(); //Fehler bei Modus-Auswahl -> Neustart
        }
        System.out.println("\u001b[31m" + "Das Programm wird gestartet!" + "\u001b[0m");

        return modus;
    }

    //Konstruktor
    Logging(Mail m, WebCrawler s) {
        logFile = new File("Log.txt");
        SettingsFile = new File("ProgrammEinstellungen.txt");
        this.m = m;
        this.s = s;
    }
}
