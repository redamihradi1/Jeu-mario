package com.mathmaurer.objet;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bloc extends Objet{
	private Image imgBloc;
	private ImageIcon icoBloc;
		
	
	public Bloc(int x ,int y ) {
		super(x,y, 43,65);
		this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
		this.imgBloc = this.icoBloc.getImage();
	
	}
	// getters and setters 

	public Image getImgBloc() {return imgBloc;}
	
}
