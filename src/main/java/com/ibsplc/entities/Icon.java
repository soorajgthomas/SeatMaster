package com.ibsplc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "icon")
public class Icon {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    private byte[] icon;
    
    @Lob
    private byte[] imageForm;    

	public Icon() {
	}

	public Icon(Long id) {
		this.id = id;
	}
	
	public Icon(byte[] icon, byte[] imageForm) {
		this.icon = icon;
		this.imageForm = imageForm;
	}
	
	public Icon(Long id, byte[] icon, byte[] imageForm) {
		this.id = id;
		this.icon = icon;
		this.imageForm = imageForm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public byte[] getImageForm() {
		return imageForm;
	}

	public void setImageForm(byte[] imageForm) {
		this.imageForm = imageForm;
	}
    
}
