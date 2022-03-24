package com.mathmaurer.personnages;
import java.awt.*;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.objet.Objet;
public class Personnage {
	 
	private int largeur,hauteur;// dimension du perso
	private int x,y ; // position
	private boolean marche;// vrai si le persomarche
	private boolean versDroite;
	public int compteur;// compter les pas du personnage
	
	public Personnage(int x,int y ,int largeur , int hauteur) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.compteur = 0;
		this.marche=false;
		this.versDroite =true;
	}
	// getters et setters
	
	public int getLargeur() {return largeur;}
	public void setLargeur(int largeur) {this.largeur = largeur;}

	public int getHauteur() {return hauteur;}
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	public int getX() {return x;}
	public void setX(int x) {this.x = x;}

	public int getY() {return y;}
	public void setY(int y) {this.y = y;}

	public boolean isMarche() {return marche;}
	public void setMarche(boolean marche) {this.marche = marche;}

	public boolean isVersDroite() {return versDroite;}
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

	public int getCompteur() {return compteur;}
	public void setCompteur(int compteur) {this.compteur = compteur;}
	
	
	// methodes
	
	public Image marche(String nom, int frequence){
		
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.marche == false || Main.scene.getxPos() <= 0){
			if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
			else{str = "/images/" + nom + "ArretGauche.png";}
		}else{
			this.compteur++;
			if(this.compteur / frequence == 0){
				if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
				else{str = "/images/" + nom + "ArretGauche.png";}
			}else{
				if(this.versDroite == true){str = "/images/" + nom + "MarcheDroite.png";}
				else{str = "/images/" + nom + "MarcheGauche.png";}
			}
			if(this.compteur == 2 * frequence){this.compteur = 0;}
		}
		//Affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public boolean contactAvant(Objet objet) {
		if(this.isVersDroite() == true) {
			if(this.x+this.largeur < objet.getX() || this.x +this.largeur > objet.getX()+5 || this.y +this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur())
			{
				return false;
			}
			else {
				return true;
			}
			
		}else {
				return false;
			}
		
		
	}
	public boolean proche(Objet objet){  	
    	if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) 
    	|| (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)){return true;}
    	else{return false;}
    }
    
    // Dtection contact  gauche de Mario
    protected boolean contactArriere(Objet objet){		
		if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 || 
		   this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	}

    // Dtection contact en dessous de Mario
    protected boolean contactDessous(Objet objet){		
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
		   this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5){return false;}
		else{return true;}		
	}

    // Dtection contact au-dessus de Mario
    protected boolean contactDessus(Objet objet){
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
		   this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){return false;}
		else{return true;}
	} 
}
