import fr.univrennes.istic.l2gen.geometrie.Cercle;
import fr.univrennes.istic.l2gen.geometrie.IForme;

public class App {
    public static void main(String[] args) throws Exception {
        IForme f = new Cercle(256,256,128);
        System.out.println( f.description(1));
    }
}
