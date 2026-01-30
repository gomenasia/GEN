package fr.univrennes.istic.l2gen.geometrie;

public class Groupe implements IForme {
    private Point centre;
    private IForme[] contenu;

    public Groupe(IForme[] formes){
        if(formes[0] instanceof IForme){
            centre = new Point(formes[0].centre().x(), formes[0].centre().y());
        }
        contenu = formes;
    }

    public Groupe ajouter(IForme forme){
        IForme[] temp = new IForme[contenu.length + 1];
        for(int i = 0; i< contenu.length; i += 1){
            temp[i] = contenu[i];
        }
        temp[temp.length-1] = forme;
        return new Groupe(temp);
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
        rep+="Groupe";
        for (int i = 0; i < contenu.length; i += 1){
            rep += contenu[i].description(identation+1) + "/n";
        }
        return rep;
    }

    @Override
    public double hauteur() {
        double hauteur_max;
        double hauteur_min;
        if(contenu[0] instanceof IForme){
            hauteur_max = contenu[0].centre().y() + hauteur()/2;
            hauteur_min = contenu[0].centre().y() - hauteur()/2;
        } else{
            return 0;
        }
        for(IForme forme : contenu){
            if(forme.centre().y() + (forme.hauteur()/2) > hauteur_max){
                hauteur_max = forme.centre().y() + (forme.hauteur()/2);
            }
            if(forme.centre().y() - (forme.hauteur()/2) < hauteur_min){
                hauteur_min = forme.centre().y() - (forme.hauteur()/2);
            }
        }
        return hauteur_max - hauteur_min;
    }

    @Override
    public double largeur() {
        double largeur_max;
        double largeur_min;
        if(contenu[0] instanceof IForme){
            largeur_max = contenu[0].centre().x() + largeur()/2;
            largeur_min = contenu[0].centre().x() - largeur()/2;
        } else{
            return 0;
        }
        for(IForme forme : contenu){
            if(forme.centre().x() + (forme.largeur()/2) > largeur_max){
                largeur_max = forme.centre().x() + (forme.largeur()/2);
            }
            if(forme.centre().x() - (forme.largeur()/2) < largeur_min){
                largeur_min = forme.centre().x() - (forme.largeur()/2);
            }
        }
        return largeur_max - largeur_min;
    }

    @Override
    public void deplacer(double x, double y) {
        centre.plus(x, y);
        for(IForme forme : contenu){
            forme.deplacer(x, y);
        }
    }

    @Override
    public IForme dupliquer() {
        IForme[] temp = new IForme[contenu.length];

        for(int i = 0; i < contenu.length ; i += 1){
            if(contenu[i] instanceof IForme){
                temp[i] = contenu[i].dupliquer();
            }
        }

        return new Groupe(temp);
    }

    @Override
    public void redimensionner(double x, double y) {
        for(IForme forme : contenu){
            forme.redimensionner(x, y);
        }
    }
    

    public String enSVG(){
        String rep = "";
        rep += "<g> \n";
        for(IForme forme : contenu){
            rep += forme.enSVG();
        }
        rep += "</g> \n";
        return rep;
    }
}
