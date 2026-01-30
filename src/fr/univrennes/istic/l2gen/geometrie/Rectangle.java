package fr.univrennes.istic.l2gen.geometrie;

public class Rectangle implements IForme {
    
    private double x;
    private double y;
    private double hauteur;
    private double largeur;

    public Rectangle(double dx, double dy, double largeur, double hauteur){
        x = dx;
        y = dy;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Rectangle(Point point, double largeur, double hauteur){
        x = point.x();
        y = point.y();
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    @Override
    public Point centre(){
        return new Point(x, y);
    }

    @Override
    public String description(int indentation){
        String str = "";
        for (int i = 0; i < indentation; i++){
            str += "  ";
        }
        return str + "Rectangle Centre=" + x + "," + y + " L=" + largeur + " H=" + hauteur + "\n";
    }

    @Override
    public double hauteur(){
        return hauteur;
    }

    @Override
    public double largeur(){
        return largeur;
    }

    @Override
    public void deplacer(double dx, double dy){
        x += dx;
        y += dy;
    }

    @Override
    public IForme dupliquer(){
        return new Rectangle(x, y, largeur, hauteur);
    }

    @Override
    public void redimensionner(double coeflargeur, double coefhauteur){
        this.largeur *= coeflargeur;
        this.hauteur *= coefhauteur;
    }

    @Override
    public String enSVG(){
        double x_coin = x - (largeur / 2);
        double y_coin = y - (hauteur / 2);
        return "<rect x=\""+ x_coin + "\" y=\"" + y_coin + "\" width=\"" + largeur + "\" height=\"" + hauteur + "\" fill=\"white\" stroke=\"black\"/> \n";
    }
}
