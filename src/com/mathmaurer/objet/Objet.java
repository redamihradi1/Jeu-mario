package com.mathmaurer.objet;

import com.mathmaurer.jeu.Main;

public class Objet {
	 
	private int largeur , hauteur; // dimension 
	private int x,y ; // position
	
	public Objet(int x,int y ,int largeur , int hauteur) {
		
		this.x =x;
		this.y =y ;
		this.largeur = largeur;
		this.hauteur=hauteur;
	}

	// getters and setters
	public int getLargeur() {return largeur;}
	public void setLargeur(int largeur) {this.largeur = largeur;}

	public int getHauteur() {	return hauteur;}
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	public int getX() {return x;}
	public void setX(int x) {this.x = x;}

	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
 
	// Methodes
	
	public void deplacement() {
		if(Main.scene.getxPos() >= 0 ) {
			this.x=this.x-Main.scene.getDx();
		}
	}
}
