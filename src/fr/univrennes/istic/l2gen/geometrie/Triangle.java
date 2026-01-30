package fr.univrennes.istic.l2gen.geometrie;

public class Triangle implements IForme{
    
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(double x1, double x2, double y1, double y2, double z1, double z2){
        this.p1 = new Point(x1, x2);
        this.p2 = new Point(y1, y2);
        this.p3 = new Point(z1, z2);
    }

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point centre(){
        return new Point(((p1.x()+p2.x()+p3.x())/3), ((p1.y()+p2.y()+p3.y())/3));
    }

    public String description(int indentation){
        String s = ""; 
        for (int i = 0; i < indentation; i++){
            s +=" "; 
        }
        return s + "Triangle " + p1.x() + "," + p1.y() + " " + p2.x() + "," + p2.y() + " " + p3.x() + "," + p3.y();
    }

    public double hauteur(){
        double ymax = Math.max((Math.max(p1.y(), p2.y())), p3.y());
        double ymin = Math.min((Math.min(p1.y(), p2.y())), p3.y());

        return ymax - ymin;
    }

    public double largeur(){
        double xmax = Math.max((Math.max(p1.x(), p2.x())), p3.x());
        double xmin = Math.min((Math.min(p1.x(), p2.x())), p3.x());

        return xmax - xmin;
    }

    public void deplacer(double dx, double dy){
        p1 = p1.plus(dx, dx);
        p2 = p2.plus(dx, dx);
        p3 = p3.plus(dx, dx);
    }

    public void redimensionner(double coeffL, double coeffH){
        Point center = centre();

        p1 = new Point((center.x() + (p1.x() - center.x()) * coeffL), (center.y() + (p1.y() - center.y()) * coeffH));

        p2 = new Point((center.x() + (p2.x() - center.x()) * coeffL), (center.y() + (p2.y() - center.y()) * coeffH));

        p3 = new Point((center.x() + (p3.x() - center.x()) * coeffL), (center.y() + (p3.y() - center.y()) * coeffH));
    }

    public IForme dupliquer(){
        return new Triangle(new Point(p1.x(), p1.y()), new Point(p2.x(), p2.y()), new Point(p3.x(), p3.y()));
    }

    public String enSVG(){
        String s = "<polygon points=\"";
        s += p1.x();
        s += " ";
        s += p1.y();
        s += " ";
        s += p2.x();
        s += " ";
        s += p2.y();
        s += " ";
        s += p3.x();
        s += " ";
        s += p3.y();
        s += "\" fill = \"white\" stroke =\"black\"/> \n";

        return s;
    }
}