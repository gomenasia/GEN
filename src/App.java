import fr.univrennes.istic.l2gen.geometrie.Cercle;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Polygon;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Triangle;

public class App {
    public static void main(String[] args) throws Exception {

        Groupe tableau = new Groupe();

        tableau.ajouter(new Cercle(256,256,128));
        tableau.ajouter(new Ligne(128, 128, 128, 256, 256, 128, 256, 256));
        tableau.ajouter(new Polygon(128, 128, 128, 256, 256, 128, 256, 256));
        tableau.ajouter(new Rectangle(256,256, 256,128));
        tableau.ajouter(new Triangle(192, 128, 256,128, 256, 256));

        System.out.println(tableau.enSVG());
    }
}
