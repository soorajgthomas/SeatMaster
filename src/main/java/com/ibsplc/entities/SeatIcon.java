package com.ibsplc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seaticon")
public class SeatIcon {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn(name= "icon_id", nullable = true, referencedColumnName="id")
	@ManyToOne(fetch = FetchType.EAGER)
	Icon icon;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SeatIcon(){
		
	}
	public SeatIcon(Long id, Icon icon_id, int sequenceno, byte[] seatimage) {
		super();
		this.id = id;
		this.icon = icon_id;
		this.sequenceno = sequenceno;
		this.seatimage = seatimage;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon_id) {
		this.icon = icon_id;
	}

	public int getSequenceno() {
		return sequenceno;
	}

	public void setSequenceno(int sequenceno) {
		this.sequenceno = sequenceno;
	}

	public byte[] getSeatimage() {
		return seatimage;
	}

	public void setSeatimage(byte[] seatimage) {
		this.seatimage = seatimage;
	}

	@Column(length = 1000)
    private int sequenceno;
    
    @Lob
    private byte[] seatimage;    

	
    
}
