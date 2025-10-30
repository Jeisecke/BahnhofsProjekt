package bahnhofverwaltung;
import java.util.Random;

public class Verwaltung {

    private Stack<Wagon> gleis1;
    private Stack<Wagon> gleis2;
    private Stack<Wagon> gleis3;

    private int anzahlZüge;

    private int[] idList;

    public Verwaltung(int anzahlZüge)
    {
        this.anzahlZüge = anzahlZüge;

        gleis1 = new Stack<Wagon>();
        gleis2 = new Stack<Wagon>();
        gleis3 = new Stack<Wagon>();

        idList = new int[anzahlZüge]; //temporärer Wert! Bitte noch ändern!

        for (int i = 0; i < anzahlZüge; i++)
        {
            zugHinzufügen(anzahlZüge+" Kartoffeln", gleis2);
        }
    }

    public void schieneWechseln(Stack<Wagon> von, Stack<Wagon> zu)
    {
        final Wagon zuWechselnderZug = von.top();
        von.pop();
        zu.push(zuWechselnderZug);
    }

    public Wagon getTopWagon(Stack<Wagon> target)
    {
        return(target.top());
    }

    private void zugHinzufügen(String ladung, Stack<Wagon> target)
    {
        final int zugId = idGenerieren();
        target.push(new Wagon(ladung, zugId));
        idList[zugId] = zugId;
    }

    private int idGenerieren()
    {
        final int id;
        Random random = new Random();
        id = random.nextInt(1000000);
        return id;
    }
}
