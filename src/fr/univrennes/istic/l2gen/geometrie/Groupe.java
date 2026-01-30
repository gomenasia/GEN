package fr.univrennes.istic.l2gen.geometrie;

import java.util.ArrayList;

public class Groupe implements IForme {

    public ArrayList<IForme> formes;

    public Groupe(IForme ... formes){
        this.formes = new ArrayList<>();
        for(int i = 0; i < formes.length; i++){
            this.formes.add(formes[i]);
        }
    }

    public void ajouter(IForme forme){
        formes.add(forme);
    }

	@Override
	public Point centre() {
		double mx = 0;
        double my = 0;
        for(int i = 0; i < formes.size(); i++){
            Point p = formes.get(i).centre();
            mx += p.x();
            my += p.y();
        }
        return new Point(mx / formes.size(), my / formes.size());
	}

	@Override
	public String description(int indentation) {
		String str = "";
        for (int i = 0; i < indentation; i++){
            str += "  ";
        }
        str += "Groupe\n";
        for(int i = 0; i < formes.size(); i++){
            str += formes.get(i).description(indentation + 1);
        }
        return str;
	}

	@Override
	public double hauteur() {
		if (formes.size() == 0){
            return 0;
        }
        
        double miny = formes.get(0).centre().y();
        double maxy = formes.get(0).centre().y();
        
        for(int i = 1; i < formes.size(); i++){
            double y = formes.get(i).centre().y();
            if(y < miny){
                miny = y;
            }
            if(y > maxy){
                maxy = y;
            }
        }
        
        return maxy - miny;
	}

	@Override
	public double largeur() {
		if (formes.size() == 0){
            return 0;
        }
        
        double minx = formes.get(0).centre().x();
        double maxx = formes.get(0).centre().x();
        
        for(int i = 1; i < formes.size(); i++){
            double x = formes.get(i).centre().x();
            if(x < minx){
                minx = x;
            }
            if(x > maxx){
                maxx = x;
            }
        }
        
        return maxx - minx;
	}

	@Override
	public void deplacer(double dx, double dy) {
		int size = formes.size();
		for (int i = 0; i < size; i++){
			formes.get(i).deplacer(dx, dy);
		}
	}

	@Override
	public IForme dupliquer() {
		int size = formes.size();
		IForme[] lst = new IForme[size]; 
		int indice = 0;
		for (int i = 0; i < size; i++){
			lst[indice] = formes.get(i).dupliquer();
			indice ++;
		}
		return new Groupe(lst);
	}

    @Override
    public void redimensionner(double coeflargeur, double coefhauteur){
		int size = formes.size();
		for (int i = 0; i < size; i++){
			formes.get(i).redimensionner(coeflargeur, coefhauteur);
		}
    }

    @Override
	public String enSVG () {
		String str = "<g>\n";
        for (int i = 0; i < formes.size(); i++){
            str += formes.get(i).enSVG();
        }
        str += "</g> \n";
        return str;
	}

    /*
    public IForme fractale(IForme base, int profondeur){
        if(profondeur == 0){
            return base;
        } else {
            IForme f = base.dupliquer();
            f.redimensionner(0.5, 0.5);
            Groupe grp = new Groupe(fractale(new Rectangle(base.centre().x()-base.largeur(), base.centre().y() - base.hauteur(), base.)))
        }
    }
    */
}