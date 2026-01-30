package fr.univrennes.istic.l2gen.geometrie;

public class Point {
    private double x;
    private double y;


    public Point(double x, double y){
        this.y=y;
        this.x=x;

    }
    
    public boolean equals(Object obj){
        if (obj instanceof Point){
            Point p=(Point) obj;
            return x== p.x() && y==p.y();
        }
        return false;
    }

    public Point plus(Point autre_pt){
        return new Point( x + autre_pt.x(), y + autre_pt.y());
    }

    public Point plus(double x, double y){
        return new Point( this.x + x, this.y + y);
    }

    public double x(){
        return x;
    }

    public double y(){
        return y;
    }
}
