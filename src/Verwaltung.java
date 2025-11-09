import java.util.Random;

public class Verwaltung {

    //TODO: private implementieren
    public Stack<Wagon> gleis1;
    public Stack<Wagon> gleis2;
    public Stack<Wagon> gleis3;
    Random random = new Random();

    //TODO: Möglicherweise Anzahl der Züge im GUI anzeigen?
    //private int anzahlZuege = 0;


    //konstruktor
    public Verwaltung(int anzahlZuegeErstellen)
    {
        gleis1 = new Stack<>();
        gleis2 = new Stack<>();
        gleis3 = new Stack<>();


        //listeNamen, damit nicht alle Wagen dasselbe heißen
        String[] listeNamen = {"Kartoffeln", "Eisenerz", "Werkzeuge", "Mehl", "Öl", "Kohle", "Elektrotechnik", "Müll", "Holz", "Waren", "Gefahrgut"};

        for (int i = 0; i < anzahlZuegeErstellen; i++)
        {   int ii = random.nextInt(listeNamen.length);
            zugHinzufuegen(listeNamen[ii]+"-"+i, gleis2);
        }
    }

    public void schieneWechseln(Stack<Wagon> von, Stack<Wagon> zu)
    {
        final Wagon zuWechselnderZug = getTopWagon(von);
        von.pop();
        zu.push(zuWechselnderZug);
    }

    public void printStacks() {

    Stack<Wagon> tempStack = gleis1.copy();
    System.out.println("Gleis 1:");

    int size = tempStack.getStackSize();
    for (int ii = 0; ii < size; ii++) {
        Wagon top = tempStack.top();
        System.out.println("Stelle: " + ii + " | Ladung an der Stelle: " + top.ladung() + " Id: " + top.id);
        tempStack.pop();
    }

    tempStack = gleis2.copy();
    System.out.println("\nGleis 2:");

    size = tempStack.getStackSize();
    for (int ii = 0; ii < size; ii++) {
        Wagon top = tempStack.top();
        System.out.println("Stelle: " + ii + " | Ladung an der Stelle: " + top.ladung() + " Id: " + top.id);
        tempStack.pop();
    }

    tempStack = gleis3.copy();
    System.out.println("\nGleis 3:");

    size = tempStack.getStackSize();
    for (int ii = 0; ii < size; ii++) {
        Wagon top = tempStack.top();
        System.out.println("Stelle: " + ii + " | Ladung an der Stelle: " + top.ladung() + " Id: " + top.id);
        tempStack.pop();
    }
}


    public Wagon getTopWagon(Stack<Wagon> target)
    {
        return(target.top());
    }

//    public int getAnzahlZuege()
//    {
//        return(anzahlZuege);
//    }

    public void zugHinzufuegen(String ladung, Stack<Wagon> target)
    {
        final int zugId = idGenerieren();
        target.push(new Wagon(ladung, zugId));
        //anzahlZuege ++;
    }

    private int idGenerieren()
    {
        final int id;
        id = random.nextInt(1000000);
        return id;
    }

    public void sortierenZuege(){
        if (!gleis1.isEmpty() || !gleis2.isEmpty()){
            int kleinsterZug = getTopWagon(gleis2).id;
            while (!gleis2.isEmpty()){
                if (getTopWagon(gleis2).id < kleinsterZug){
                    kleinsterZug = getTopWagon(gleis2).id;
                }
                schieneWechseln(gleis2, gleis1);
            }
            while (!gleis1.isEmpty()) {
                if (getTopWagon(gleis1).id == kleinsterZug) {
                    schieneWechseln(gleis1, gleis3);
                } else {
                    schieneWechseln(gleis1, gleis2);
                }
            }
        }
    }
}
