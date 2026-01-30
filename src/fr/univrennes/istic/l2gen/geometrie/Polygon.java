package fr.univrennes.istic.l2gen.geometrie;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements IForme{
    private List<Point> pos;
    private Point centre;

    private String color;

    public Polygon(double... co){
        List<Point> lst = new ArrayList<>();
        for(int i = 0; i < co.length; i += 2){
            lst.add(new Point(co[i], co[i + 1]));
        }
        create(lst);
    }

    public Polygon(List<Point> pos){
        this.pos = pos;
        System.out.println(this.pos.get(0).x());
        centre = new Point(largeur()/2, hauteur()/2);
    }

    public void create(List<Point> pos){
        this.pos = pos;
        centre = new Point(largeur()/2, hauteur()/2);
    }

    public void ajouterSommet(Point p){
        pos.add(p);
    }
    public void ajouterSommet(double x, double y){
        pos.add(new Point(x, y));
    }
    public List<Point> getSommets(){
        return new ArrayList<Point>();
    }



    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int indentation) {
        String res = "";
        for(int i = 0; i < indentation; i++){
            res += "  ";
        }
        res += "Polygone ";
        for(int i = 0; i < pos.size(); i++){
            Point p = pos.get(i);
            res += String.valueOf(p.x()) + "," + String.valueOf(p.y()) + " ";
        }
        res += " " + color;
        return res;
    }

    @Override
    public void deplacer(double x, double y) {
        for(int i = 0; i < pos.size(); i++){
            pos.get(i).plus(x, y);
        }
    }

    @Override
    public IForme dupliquer() {
        List<Point> lst = new ArrayList<>();
        for(int i = 0; i < pos.size(); i++){
            lst.add(new Point(pos.get(i).x(), pos.get(i).y()));
        }
        Polygon poly = new Polygon(lst);
        poly.color = color;
        return poly;
    }

    private double[] minMax(boolean hauteur){
        if(pos.size() <= 1){
            double[] res = {0.0,0.0};
            return res;
        }
        double[] res = new double[2];
        if(hauteur){res[0] = pos.get(0).y(); res[1] = pos.get(0).y();}
        else{res[0] = pos.get(0).x(); res[1] = pos.get(0).x();}
        for(int i = 0; i < pos.size(); i++){
            Point p = pos.get(i);
            if(hauteur){
                if(res[0] < p.y()){
                    res[0] = p.y();
                }
                if(res[1] > p.y()){
                    res[1] = p.y();
                }
            }else{
                if(res[0] < p.x()){
                    res[0] = p.x();
                }
                if(res[1] > p.x()){
                    res[1] = p.x();
                }
            }
        }
        return res;
    }

    @Override
    public double hauteur() {
        double[] mm = minMax(true);
        return mm[0] - mm[1];
    }

    @Override
    public double largeur() {
        double[] mm = minMax(false);
        return mm[0] - mm[1];
    }

    @Override
    public void redimensionner(double l, double h) {
        double coeffL = l/largeur();
        double coeffH = h/hauteur();
        List<Point> newPos = new ArrayList<>();
        for(int i = 0; i < pos.size(); i++){
            newPos.add(new Point((pos.get(i).x() - centre.x()) * coeffL, (pos.get(i).y() - centre.y()) * coeffH));
        }
        pos = newPos;
    }

    @Override
    public String enSVG() {
        String s = "<polygon points=\"";
        for (Point point : pos){
            s += point.x();
            s += " ";
            s += point.y();
            s += " ";
        }
        s += "\" fill=\"white" + color + "\" stroke=\"black\"/> \n";
        
        return s;
    }

    // @Override
    // public void colorier(String... couleurs){
    //     color = couleurs[0];
    // }
}