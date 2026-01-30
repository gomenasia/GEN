package fr.univrennes.istic.l2gen.geometrie;


public interface IForme {
    
    public Point centre();
    
    public void deplacer(double x, double y);

    public String description(int identation);

    public IForme dupliquer();

    public double hauteur();
    
    public double largeur();

    public void redimensionner(double x, double y);

    public String enSVG();
}
