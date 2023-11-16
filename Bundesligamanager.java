import java.util.Arrays;
import java.util.Random;

public class Bundesligamanager {
    public static void main(String[] args) {
        Bundesligamanager bLM = new Bundesligamanager();
        bLM.init();
        bLM.simulation();
        bLM.ausgabeTabelle();
    }

    public Verein[] liga;
    private void init() {
        liga = new Verein[18];
        liga[0] = new Verein("KOE");
        liga[1] = new Verein("LEV");
        liga[2] = new Verein("FCB");
        liga[3] = new Verein("VFB");
        liga[4] = new Verein("BVB");
        liga[5] = new Verein("RBL");
        liga[6] = new Verein("TSG");
        liga[7] = new Verein("SGE");
        liga[8] = new Verein("SCF");
        liga[9] = new Verein("WOB");
        liga[10] = new Verein("FCA");
        liga[11] = new Verein("BMG");
        liga[12] = new Verein("SVW");
        liga[13] = new Verein("FCH");
        liga[14] = new Verein("BOC");
        liga[15] = new Verein("D98");
        liga[16] = new Verein("FCU");
        liga[17] = new Verein("M05");
    }

    public void spielen(Verein heim, Verein guest) {
        Random randomTor = new Random();
        int max = 4;

        int heimTore = randomTor.nextInt(max);
        int guestTore = randomTor.nextInt(max);

        heim.setTore(heim.getTore() + heimTore);
        guest.setTore(guest.getTore() + guestTore);
        heim.setGegentore(heim.getGegentore() + guestTore);
        guest.setGegentore(guest.getGegentore() + heimTore);
        heim.setSpiele(heim.getSpiele() + 1);
        guest.setSpiele(guest.getSpiele() + 1);
        
        if (heimTore > guestTore) {
            heim.setGewonnen(heim.getGewonnen() + 1);
            guest.setVerloren(guest.getVerloren() + 1);
            heim.setPunkte(heim.getPunkte() + 3);
        } else if (heimTore < guestTore) {
            guest.setGewonnen(guest.getGewonnen() + 1);
            heim.setVerloren(heim.getVerloren() + 1);
            guest.setPunkte(guest.getPunkte() + 3);
        } else {
            heim.setUnentschieden(heim.getUnentschieden() + 1);
            guest.setUnentschieden(guest.getUnentschieden() + 1);
            heim.setPunkte(heim.getPunkte() + 1);
            guest.setPunkte(guest.getPunkte() + 1);
        }
    }

    public void simulation() {
        for (int i = 0; i < liga.length; i++) { //zählvaribable, ,inkrement/dekrement 
            for (int j = 0; j < liga.length; j++) {
                if (i != j) {   //nicht i gegen i 
                    spielen(liga[i], liga[j]);
                }
            }
        }
        sortiereTabelle();
    }

    public void sortiereTabelle() {
        Arrays.sort(liga, (team1, team2) -> {
            int punkteVergleich = Integer.compare(team2.getPunkte(), team1.getPunkte());
            if (punkteVergleich == 0) {                
                int differenzVergleich = Integer.compare(team2.getDifferenz(), team1.getDifferenz());
                if (differenzVergleich == 0) {
                    return Integer.compare(team2.getTore(), team1.getTore());
                }
                return differenzVergleich;
            }
            return punkteVergleich;
        });
    }

    public void ausgabeTabelle() {
        System.out.println("Club" + "\t" + "S" + "\t" + "U"  + "\t" + "V" + "\t" + "T" + "    " +  "G" + "  " + " D" + "\t" + "P");
    
        int anzahlTeams = liga.length;

        for (int i = 0; i<anzahlTeams -15; i++)
            System.out.println(
                "\u001B[32m" +
                liga[i].getName() + "\t" +
                liga[i].getGewonnen() + "\t"+
                liga[i].getUnentschieden()+ "\t" + 
                liga[i].getVerloren()+ "\t" + 
                liga[i].getTore() + " : " + liga[i].getGegentore() + " " + 
                liga[i].getDifferenz() +"\t" + 
                liga[i].getPunkte() 
                + "\u001B[0m");
    
        for (int i = 3; i < anzahlTeams - 2; i++) {
            System.out.println(
                liga[i].getName() + "\t" +
                liga[i].getGewonnen() + "\t"+
                liga[i].getUnentschieden()+ "\t" + 
                liga[i].getVerloren()+ "\t" + 
                liga[i].getTore() + " : " + liga[i].getGegentore() + " " + 
                liga[i].getDifferenz() +"\t" + 
                liga[i].getPunkte()); 
        }    
        for (int i = anzahlTeams - 3; i < anzahlTeams; i++) {
            System.out.println(
                "\u001B[31m" +
                liga[i].getName() + "\t" +
                liga[i].getGewonnen() + "\t"+
                liga[i].getUnentschieden()+ "\t" + 
                liga[i].getVerloren()+ "\t" + 
                liga[i].getTore() + " : " + liga[i].getGegentore() + "\t" + 
                (liga[i].getTore() - liga[i].getGegentore()) +"\t" + 
                liga[i].getPunkte());
        }
    }
}

//TODO: wenn die Datei aufgerufen wird, soll die maximale anzahl an tore auf ein bestimmten wert gesetzt werden. 
//Dies soll geschen, indem man nach dem Datei namen einr Zahl schreibt 