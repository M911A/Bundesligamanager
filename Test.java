public class Test {
    public static void main(String[] args) {
        Test bl = new Test();
        bl.init();
        bl.print();
        bl.swap();
    }

    public Verein[] liga; 

    public void init() {
        liga = new Verein[2]; 
        liga[0] = new Verein("Test1");
        liga[1] = new Verein("Test2");
    }

    public void print() { 
        String str = ""; 
        str +=  liga[0].getName() + "  " + liga[1].getName() + "  ";
        System.out.print(str);
    }

    public void swap() {
        String temp1 = liga[0].getName();
        liga[0] = liga[1];
        liga[1].setName(temp1);
        System.out.println(liga[0].getName() + "  " +  liga[1].getName()); 
    }
    //Ausgabe geht nicht richtig weil sie mit dem adneren Code aus der Ursprungsdatei durcheiander kommt. 
    //Grundsätzlich sind die Funktionen vom Code korekt!
    

}
