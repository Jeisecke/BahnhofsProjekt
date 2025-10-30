package bahnhofverwaltung;
import java.util.Random;

public class Verwaltung {

    private Stack<Wagon> gleis1;
    private Stack<Wagon> gleis2;
    private Stack<Wagon> gleis3;

    private int anzahlZüge;

    private int[] idList;

    public void Verwaltung(int anzahlZüge)
    {
        this.anzahlZüge = anzahlZüge;

        gleis1 = new Stack<Wagon>();
        gleis2 = new Stack<Wagon>();
        gleis3 = new Stack<Wagon>();

        idList = new int[anzahlZüge]; //temporärer Wert! Bitte noch ändern!
        

    }

    public void schieneWechseln(int von, int zu)
    {

    }



    private void zugHinzufügen(int zugGröße, int target)
    {
        final int zugId = idGenerieren();
        target.push(new Wagon(zugGröße, zugId));
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
