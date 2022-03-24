package com.mathmaurer.personnages;
import java.awt.Image;
import javax.swing.ImageIcon;


import com.mathmaurer.jeu.Main;
import com.mathmaurer.objet.Objet;


public class Mario extends Personnage{
		
	private Image imgMario;
	private ImageIcon icoMario;
	private boolean saut;// vrai si mario saute
	private int compteurSaut;// duree et hauteur du saut 
	
	
	
	public Mario(int x, int y) {
		
		super(x, y, 28, 50);
		
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imgMario = this.icoMario.getImage();
		this.saut=false;
		this.compteurSaut = 0;
	}
	
	
	// getters 
	public Image getImgMario() {return imgMario;}
	public boolean isSaut() {return saut;}

	// setters
	public void setSaut(boolean saut) {this.saut = saut;}
	
	// methodes
	 public Image saute(){
			
		    ImageIcon ico;
		    Image img;
		    String str;
		
			this.compteurSaut++;
			// Montee du saut		
			if(this.compteurSaut <= 35){
				if(this.getY() > Main.scene.getHauteurPlafond()){this.setY(this.getY() - 4);}
				else{this.compteurSaut = 36;}			
				if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
				else{str = "/images/marioSautGauche.png";}	
				
			// Retombee du saut
			}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){this.setY(this.getY() + 1);
				if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
				else{str = "/images/marioSautGauche.png";}
				
			// Saut termine
			}else{				
				if(this.isVersDroite() == true){str = "/images/marioArretDroite.png";}
				else{str = "/images/marioArretGauche.png";}	
				this.saut = false;
				this.compteurSaut = 0;
			}
			// Affichage de l'image de mario
			ico = new ImageIcon(getClass().getResource(str));
			img = ico.getImage();
			return img;
		}
	 public void contact(Objet objet) {
			// contact horizontal
			if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
				Main.scene.setDx(0);
			    this.setMarche(false);
			}
			// contact avec un objet en dessous
	        if(super.contactDessous(objet) == true && this.saut == true){ // Mario saute sur un objet
				Main.scene.setySol(objet.getY());			
			}else if(super.contactDessous(objet) == false){ // Mario tombe sur le sol initial
				Main.scene.setySol(293); // altitude du sol initial
				if(this.saut == false){this.setY(243);} // altitude initiale de Mario
			}
	        // contact avec un objet au-dessus
	        if(super.contactDessus(objet) == true){
				Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
			}else if(super.contactDessus(objet) == false && this.saut == false){
				Main.scene.setHauteurPlafond(0);// altitude du plafond initial (ciel)
			}     
		}
}
