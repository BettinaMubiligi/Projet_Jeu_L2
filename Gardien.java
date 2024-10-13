//Mnemoi Lina et Mubiligi Bettina groupe4

public class Gardien extends Contenu{
	private double ptsVie;
	
	public Gardien(String nom, int qte){
		super(nom,qte);
		ptsVie = Math.random()*200;
	}
	
	public String toString(){
		return "Gardien";
	}
	public double getPtsVie(){
		return ptsVie;
	}
	public void setPtsVie(double t){
		ptsVie=t;
	}
}
