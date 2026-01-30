package fr.univrennes.istic.l2gen.geometrie;

public class Cercle implements IForme {
    private Point centre;
    private double rayon;
    
    public Cercle(double x, double y, double rayon){
        centre = new Point(x, y);
        this.rayon = rayon;
    }

    public Cercle(Point centre, double rayon){
        this.centre = centre;
        this.rayon = rayon;
    }
    
    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int identation) {
        String rep = "";
        for (int i = 0; i < identation; i += 1){
            rep += "  ";
        }
        rep += "Cercle centre=" + (int)centre.x() + "," + (int)centre.y() + " r=" + rayon;
        return rep;
    }

    @Override
    public double hauteur() {
        return rayon * 2;
    }

    @Override
    public double largeur() {
        return rayon * 2;
    }

    @Override
    public void deplacer(double x, double y) {
        centre = centre.plus(x, y);
    }

    @Override
    public IForme dupliquer() {
        return new Cercle(centre.plus(0,0), rayon);
    }

    @Override
    public void redimensionner(double x, double y) {
        rayon = rayon*x;
    }

    public String enSVG(){
        String rep = """<circle cx=
                
                """;

    }
}