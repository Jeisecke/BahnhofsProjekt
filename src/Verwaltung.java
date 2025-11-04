package bahnhofverwaltung;
import java.util.Random;

public class Verwaltung {

    private Stack<Wagon> gleis1;
    private Stack<Wagon> gleis2;
    private Stack<Wagon> gleis3;

    private int anzahlZüge;

    public Verwaltung()
    {
        gleis1 = new Stack<Wagon>();
        gleis2 = new Stack<Wagon>();
        gleis3 = new Stack<Wagon>();

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
        anzahlZüge ++;
    }

    private int idGenerieren()
    {
        final int id;
        Random random = new Random();
        id = random.nextInt(1000000);
        return id;
    }

    public void sortierenZüge(){
        if (!gleis1.isEmpty() && !gleis2.isEmpty() && !gleis3.isEmpty()){
            int kleinsterZug = 0;
            boolean toogle = true;
            if (toogle){
                while (!gleis2.isEmpty()){
                    if (gleis2.top().id < kleinsterZug){
                        kleinsterZug = gleis2.top().id;
                        schieneWechseln(gleis2, gleis1);

                    }
                }
                while (!gleis1.isEmpty()){
                    if (gleis1.top().id == kleinsterZug){
                        schieneWechseln(gleis1, gleis3);
                    }

                }
            }
            else
            {
                while (!gleis1.isEmpty()){
                    if (gleis1.top().id < kleinsterZug){
                        kleinsterZug = gleis1.top().id;
                        schieneWechseln(gleis1, gleis2);
                    }
                }
                while (!gleis2.isEmpty()){
                    if (gleis2.top().id == kleinsterZug){
                        schieneWechseln(gleis2, gleis3);
                    }
                }
            }
            toogle = !toogle;
        }
    }

}
