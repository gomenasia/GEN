package fr.univrennes.istic.l2gen.geometrie;

public class Cercle implements IForme {
    private Point centre;
    private double rayon;

    public Cercle(double x, double y, double r){
        this.centre = new Point(x, y);
        this.rayon = r;
    }
    public Cercle(Point centre, double r){
        this.centre = centre;
        this.rayon = r;
    }

    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int indentation) {
        String texte = "";
        for(int i = 0; i < indentation; i++){
            texte += "  ";
        }
        texte += "Cercle centre=" + centre.x() + "," + centre.y() + " r=" + rayon;
        return texte;
    }

    @Override
    public double hauteur() {
        return 2*rayon;
    }

    @Override
    public double largeur() {
        return 2*rayon;
    }

    @Override
    public IForme dupliquer() {
        return new Cercle(centre, rayon);
    }

    @Override
    public void redimensionner(double px, double py) {
        rayon *= (px+py)/2;
    }

    @Override
    public void deplacer(double dx, double dy) {
        centre = centre.plus(dx, dy);
    }

    @Override
    public String enSVG() {
        String texte = "<circle cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" r=\"" + rayon + "\" \n"; 
        texte+= "        fill=\"white\" stroke=\"black\" /> \n";
        return texte;
    }
}