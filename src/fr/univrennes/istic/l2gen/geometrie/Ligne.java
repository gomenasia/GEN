package fr.univrennes.istic.l2gen.geometrie;

import java.util.ArrayList;
import java.util.List;

public class Ligne implements IForme{
    List<Point> points;
    public Ligne(double... coordonnees){
        assert coordonnees.length == 8 : "Le constructeur doit prendre 8 arguments.";
        points = new ArrayList<Point>();
        for (int i = 0; i<coordonnees.length; i+=2){
            points.add(new Point(coordonnees[i], coordonnees[i+1]));
        }
    }
    public Ligne(List<Point> coordonnees){
        points = new ArrayList<Point>();
        for (Point p : coordonnees){
            points.add(new Point(p.x(), p.y()));
        }
    }
    public void ajouterSommet(Point point){
        points.add(point);

    }
    public void ajouterSommet(double x, double y){
        points.add(new Point(x, y));

    }
    @Override
    public Point centre(){
        double sommeX = 0;
        double sommeY = 0;
        for (Point p : points){
            sommeX += p.x();
            sommeY += p.y();
        }
        return new Point(sommeX/points.size(), sommeY/points.size());
    }
    @Override
    public String description(int indentation) {
        String s = "  ".repeat(indentation);
        s += "Ligne";
        for (Point point : points){
            s += " ";
            s += point.toString();
        }
        return s;

    }
    @Override
    public double hauteur() {
        double yMax = 0;
        double yMin = Double.POSITIVE_INFINITY;
        for (Point p : points){
            if (p.y()>yMax){
                yMax = p.y();
            }
            if (p.y()<yMin){
                yMin = p.y();
            }
        }
        return yMax-yMin;
    }
    @Override
    public double largeur() {
        double xMax = 0;
        double xMin = Double.POSITIVE_INFINITY;
        for (Point p : points){
            if (p.x()>xMax){
                xMax = p.x();
            }
            if (p.x()<xMin){
                xMin = p.x();
            }
        }
        return xMax-xMin;
    }

    public List<Point> getSommets(){
        return points;
    }

    @Override
    public void deplacer(double x, double y) {
        List<Point> points2 = new ArrayList<Point>();
        for (Point p : points){
            points2.add(p.plus(x, y));
        }
        points = points2;
    }
    @Override
    public IForme dupliquer() {
        return new Ligne(getSommets());
    }

    @Override
    public void redimensionner(double px, double py){
        Point centre = centre();
        List<Point> newPoints = new ArrayList<Point>();
        for (Point point : points){
            double dx = point.x()-centre.x();
            double dy = point.y()-centre.y();
            newPoints.add(new Point(centre.x()+px*dx, centre.y()+py*dy));
        }
        points = newPoints;
    }

    @Override
    public String enSVG() {
        String s = "<polyline points=\"";
        for (Point point : points){
            s += point.x();
            s += " ";
            s += point.y();
            s+= " ";
        }
        s += "\" fill=\"white\" stroke=\"blue\"/>";
        return s;
    }
}


