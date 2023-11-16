public class Verein {

  private String name; 
  private int spiele; 
  private int gewonnen; 
  private int unentschieden; 
  private int verloren; 
  private int tore; 
  private int gegentore; 
  private int punkte;

  public Verein(String name) {
    this.name = name;
  }

  public int getDifferenz() {
    return getTore() - getGegentore(); 
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSpiele() {
    return spiele;
  }

  public void setSpiele(int x) {
    this.spiele = x;
  }

  public int getGewonnen() {
    return gewonnen;
  }

  public void setGewonnen(int x) {
    this.gewonnen = x;
  }

  public int getUnentschieden() {
    return unentschieden;
  }

  public void setUnentschieden(int x) {
    this.unentschieden = x;
  }

  public int getVerloren() {
    return verloren;
  }

  public void setVerloren(int x) {
    this.verloren = x;
  }

  public int getTore() {
    return tore;
  }

  public void setTore(int x) {
    this.tore = x;
  }

  public int getGegentore() {
    return gegentore;
  }

  public void setGegentore(int x) {
    this.gegentore = x;
  }

  public int getPunkte() {
    return punkte;
  }

  public void setPunkte(int x) {
    this.punkte = x;
  }
}
