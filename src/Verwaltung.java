import java.util.Random;

public class Verwaltung {

    //TODO: private implementieren
    public Stack<Wagon> gleis1;
    public Stack<Wagon> gleis2;
    public Stack<Wagon> gleis3;

    //TODO: Möglicherweise Anzahl der Züge im GUI anzeigen?
    private int anzahlZuege = 0;


    //konstruktor
    public Verwaltung(int anzahlZügeErstellen)
    {
        gleis1 = new Stack<Wagon>();
        gleis2 = new Stack<Wagon>();
        gleis3 = new Stack<Wagon>();

        //namenliste damit nicht alle Wgen dasselbe heißen
        String[] namenliste = {"Kartoffeln", "Eisenerz", "Werkzeuge", "Mehl", "Öl", "Personenverkehr", "Kohle", "Elektrotechnik"};

        for (int i = 0; i < anzahlZügeErstellen; i++)
        {   int ii = i;
            while (ii >= namenliste.length) ii -= namenliste.length;
            zugHinzufuegen(namenliste[ii]+"-"+i, gleis2);
        }
    }

    public void schieneWechseln(Stack<Wagon> von, Stack<Wagon> zu)
    {
        final Wagon zuWechselnderZug = getTopWagon(von);
        von.pop();
        zu.push(zuWechselnderZug);
    }

    public Wagon getTopWagon(Stack<Wagon> target)
    {
        return(target.top());
    }

    public int getAnzahlZuege()
    {
        return(anzahlZuege);
    }

    public void zugHinzufuegen(String ladung, Stack<Wagon> target)
    {
        final int zugId = idGenerieren();
        target.push(new Wagon(ladung, zugId));
        anzahlZuege ++;
    }

    private int idGenerieren()
    {
        final int id;
        Random random = new Random();
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
                System.out.println("Lauf1");
            }
            while (!gleis1.isEmpty()) {
                if (getTopWagon(gleis1).id == kleinsterZug) {
                    schieneWechseln(gleis1, gleis3);
                } else {
                    schieneWechseln(gleis1, gleis2);
                }
                System.out.println("Lauf2");
            }
        }
    }
}
