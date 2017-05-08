package com.ibsplc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "metaData")
public class MetaData {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String cabin;
    
    @Column
    private String description;
    
    @Column
    private String customClass;
    
    @JoinColumn(nullable = true, referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Icon icon;
    
    @Column
    private String seatAmenites;

	public MetaData() {
	}

	public MetaData(Long id) {
		this.id = id;
	}

	public MetaData(String cabin, String description, String customClass, Icon icon, String seatAmenites) {
		this.cabin = cabin;
		this.description = description;
		this.customClass = customClass;
		this.icon = icon;
		this.seatAmenites = seatAmenites;
	}

	public MetaData(Long id, String cabin, String description, String customClass, Icon icon, String seatAmenites) {
		this.id = id;
		this.cabin = cabin;
		this.description = description;
		this.customClass = customClass;
		this.icon = icon;
		this.seatAmenites = seatAmenites;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomClass() {
		return customClass;
	}

	public void setCustomClass(String customClass) {
		this.customClass = customClass;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getSeatAmenites() {
		return seatAmenites;
	}

	public void setSeatAmenites(String seatAmenites) {
		this.seatAmenites = seatAmenites;
	}
    
    
}
