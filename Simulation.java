//Mnemoi Lina et Mubiligi Bettina groupe4

import java.util.ArrayList;

public class Simulation{
    private Agent4 agent ;
    private Grille grille;
    private ArrayList<Contenu> tabContenu;

    public Simulation(Agent4 a, Grille g, ArrayList<Contenu> tab, int m){
        agent = a;
        grille = g;
        tabContenu=tab;
        int k = ((int) (Math.random()*grille.nbLignes));
        int l =((int) (Math.random()*grille.nbColonnes));
        int contenuMax = grille.nbLignes*grille.nbColonnes;

        if(m>=contenuMax) m = contenuMax;
        if(m>=tab.size()) m = tab.size();
        System.out.println("ajout de  "+m+" contenus à la grille");

        try{
            for(int i = 0; i<m; i++){
                while (grille.caseEstVide(k,l) == false){
                    k = ((int) (Math.random()*grille.nbLignes));
                    l = ((int) (Math.random()*grille.nbColonnes));
                }
                grille.setCase(k,l,tab.get(i));
            }

       }catch (CoordonneesIncorrectesException e) {
            System.out.println("Erreur: "+e.getMessage());
        }
    }

    public String toString(){
        return grille.lesContenus() +"  "+ agent.toString();
    }

    public void lance(int nbEtapes){
            double force = Math.random()*(90)+10;
            int x = 0;
            int y = 0;
            int deplacementX;
            int deplacementY;

            for(int i=0; i<nbEtapes; i++){
                deplacementX = (int) (Math.random()*2)-1; // -1, 0, ou 1
                deplacementY = (int) (Math.random()*2)-1; // -1, 0, ou 1
                x += deplacementX;
                y += deplacementY;

                if (x>=grille.nbLignes) x = 0;
                if (x<0) x = grille.nbLignes -1;
                if (y>=grille.nbLignes) y = 0;
                if (y<0) y = grille.nbColonnes -1;

                if (Math.random() < 0.3){
                    System.out.print("Etape "+(i+1)+ " : " );
                    agent.seDeplacer(x, y, force);
                        

                } else {
                    System.out.print("Etape "+(i+1)+ " : " );
                    agent.seDeplacer(x, y);
                }

            }
        

    }
}
