package com.mathmaurer.objet;

import javax.swing.ImageIcon;
import java.awt.*;

public class TuyauRouge extends Objet{
	private Image imgTuyauRouge;
	private ImageIcon icoTuyauRouge;
		
	
	public TuyauRouge(int x ,int y ) {
		super(x,y, 43,65);
		this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgTuyauRouge = this.icoTuyauRouge.getImage();
	
	}
	// getters and setters 

	public Image getImgTuyauRouge() {return imgTuyauRouge;}// principale
	public void setImgTuyauRouge(Image imgTuyauRouge) {this.imgTuyauRouge = imgTuyauRouge;}

	public ImageIcon getIcoTuyauRouge() {return icoTuyauRouge;}
	public void setIcoTuyauRouge(ImageIcon icoTuyauRouge) {this.icoTuyauRouge = icoTuyauRouge;}
	
}
