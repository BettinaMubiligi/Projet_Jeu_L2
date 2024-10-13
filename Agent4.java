//Mnemoi Lina et Mubiligi Bettina groupe4

import java.util.ArrayList;

public class Agent4 {
	private int x; 
	private int y;
	private ArrayList<Joyaux> sacJoyaux; 
	private Grille grille;

	public Agent4(Grille grille){
		sacJoyaux = new ArrayList<Joyaux>();
		x = -1;
		y = -1;
		this.grille = grille;
	}
	
	public void seDeplacer(int xnew, int ynew){
		try {
			if (grille.sontValides(xnew, ynew) == false) throw new DeplacementIncorrectException("Déplacement impossible");
			x = xnew;
			y = ynew;
			Contenu contenuCase = grille.getCase(x,y);
			if (contenuCase instanceof Joyaux){
				sacJoyaux.add((Joyaux)contenuCase);
				grille.videCase(x,y);
				System.out.println("l'agent se déplace et ramasse un " + contenuCase +" en position "+ x + ", " + y);
			}
			else if (contenuCase instanceof Gardien){
				System.out.println("l'agent se déplace et perd le contenu de son sac sans se battre");
				sacJoyaux.clear();
			}
			else System.out.println("la case où est l'agent est vide");
			
		}catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}
	}
	
	public  void seDeplacer(int xnew, int ynew, double f){
		try {
				if (grille.sontValides(xnew, ynew) == false) throw new DeplacementIncorrectException("Déplacement impossible");
				x = xnew;
				y = ynew;
				Contenu contenuCase = grille.getCase(x,y);
				if (contenuCase instanceof Joyaux){
					sacJoyaux.add((Joyaux)contenuCase);
					grille.videCase(x,y);
					System.out.println("l'agent se déplace et ramasse un " + contenuCase+" en position "+ x + ", " + y);
				}
				else if (contenuCase instanceof Gardien){
					if (((Gardien)contenuCase).getPtsVie() <= f){
						if(contenuCase instanceof GardienTeleportable){
							((GardienTeleportable)contenuCase).seTeleporter();
						}

						else{
							grille.videCase(x,y);
							System.out.println("l'agent se déplace et bat le gardien grâce à sa force");
						}

					}
					else {
						sacJoyaux.clear();
						((Gardien)contenuCase).setPtsVie(((Gardien)contenuCase).getPtsVie()-f);
						System.out.println("l'agent perd le contenu de son sac malgré sa force");
					}
				}
				else System.out.println("la case où est l'agent est vide");
			}catch (Exception e) {
				System.out.println("Erreur: "+e.getMessage());
			}
	}

	public double fortune(){
		double fortun = 0;
		for(Joyaux j : sacJoyaux){
			fortun += j.getPrix();
		}
		return fortun;
	}
	
	public String contenuSac(){
		String s = "";
		for(Joyaux j : sacJoyaux){
			s += j.toString()+", ";
		}
		return s;
	
	}
	public String toString(){
		return " Agent en position " +x+" , "+y+" avec fortune = "+fortune() /* + " et "+contenuSac()+" joyaux."*/;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return x;
	}
			
}
