/*Der Bot wurde konzepiert, um auf der Internetseite: "impfterminservice.de" freie Termine zu erkennen.
 * Es besteht die Möglichkeit Vermittlungsnummern einzuholen oder Termine abzufragen.
 * Bei gefunden Termin/Nummer wird man per email benachrichtigt. */

package com.company;

class Main {

    public static void main(String[] args) {
        //Start-Dialog / Disclaimer
        System.out.println("Impftermin-Bot \t\t Version: v0.2.1\t2021");
        System.out.println("Wilkommen zu meinem Impftermin-Bot. \n Der Bot wurde konzepiert, um auf der Internetseite: impfterminservice.de freie Termine zu erkennen.");
        System.out.println("Das Programm ist leider nicht voll ausgereift. Ich hoffe es kann gewissermaßen die Erwartungen erfüllen und helfen. Viel Erfolg!!!\n\n\n");

        //Objekte und Variablen in der Main
        int modus;
        Mail m;
        WebCrawler s;
        m = new Mail();
        s = new WebCrawler(m);

        //Programm
        modus = s.Setup();

        if(modus == 1) while(true) {
            //Anspruch Nein
            for(s.Impfzentrum = 0; s.Impfzentrum < s.ImpfstandortNamen.length; s.Impfzentrum++)
                s.ImpfstandortWahlen(s.Impfzentrum);
        }
        else if(modus == 0) {
            //Nummer Ja
            while(true) s.ImpfstandortWahlen(s.getImpfzentrumURL(), s.getNummer());
        }
    }
}
