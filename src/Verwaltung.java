import java.util.Random;

public class Verwaltung {

    //TODO: private implementieren
    public Stack<Wagon> gleis1;
    public Stack<Wagon> gleis2;
    public Stack<Wagon> gleis3;

    //TODO: Möglicherweise Anzahl der Züge im GUI anzeigen?
    private int anzahlZuege = 0;

    //globale variable nötig zum sortieren
    private boolean toggle = true;

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
            zugHinzufügen(namenliste[ii]+"-"+i, gleis2);
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

    public int getAnzahlZüge()
    {
        return(anzahlZuege);
    }

    public void zugHinzufügen(String ladung, Stack<Wagon> target)
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

    public void sortierenZüge(){
        toggle = !toggle;
        if (!gleis1.isEmpty() && !gleis2.isEmpty() && !gleis3.isEmpty()){
            int kleinsterZug = 0;
            if (toggle){
                while (!gleis2.isEmpty()){
                    if (getTopWagon(gleis2).id < kleinsterZug){
                        kleinsterZug = getTopWagon(gleis2).id;
                        schieneWechseln(gleis2, gleis1);

                    }
                }
                while (!gleis1.isEmpty()){
                    if (getTopWagon(gleis1).id == kleinsterZug){
                        schieneWechseln(gleis1, gleis3);
                    }

                }
            }
            else
            {
                while (!gleis1.isEmpty()){
                    if (getTopWagon(gleis1).id < kleinsterZug){
                        kleinsterZug = getTopWagon(gleis1).id;
                        schieneWechseln(gleis1, gleis2);
                    }
                }
                while (!gleis2.isEmpty()){
                    if (getTopWagon(gleis2).id == kleinsterZug){
                        schieneWechseln(gleis2, gleis3);
                    }
                }
            }
            toggle = !toggle;
        }
    }
}
