//Mnemoi Lina et Mubiligi Bettina groupe4

public class GardienTeleportable extends Gardien implements Teleportable{
	private Grille grille;

    public GardienTeleportable(String nom, int qte, Grille grille){
        super(nom,qte);
		this.grille = grille;

    }
    public String toString(){
        return super.toString()+" Teleportable";
    }
    public void seTeleporter(){

        if(Math.random()<0.5){
            int fin = 0;
            for(int i = 0; i < grille.nbLignes; i++){
                for(int j = 0; j < grille.nbColonnes; j++){
                    try{
                    if(grille.caseEstVide(i, j)){
                        grille.setCase(i, j, this);
                        grille.videCase(i, j);
                        fin = 1;
                        System.out.println("le gardien présent dans la case s'est téléporté, trop faible pour se battre");
                        break;
                    }}catch (Exception e){System.out.println("Erreur: "+e.getMessage()+"in se téléporter");}
                }
                if (fin == 1) break;
            }
        }
        else{
            System.out.println("le gardien n'est pas parvenu à se téléporté, l'agent l'a battu");
        }
    }
}