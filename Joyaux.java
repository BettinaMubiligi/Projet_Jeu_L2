//Mnemoi Lina et Mubiligi Bettina groupe4

public abstract class Joyaux extends Contenu{
	private double prix;
	private String nom;
	
	public Joyaux(String nom, int qte){
		super(nom, qte);
		prix= Math.random()*((4000-1)+1);
		this.nom = nom;
	}

	public String toString(){
		return nom;
	}
	
	public double getPrix(){
		return prix;
	}


}
