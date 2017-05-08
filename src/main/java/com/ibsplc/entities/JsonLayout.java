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
@Table(name = "jsonLayout")
public class JsonLayout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 1000)
	private String jsonString;
	
	@JoinColumn(nullable = true, referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private MetaData metaData;

	public JsonLayout() {
	}

	public JsonLayout(Long id) {
		this.id = id;
	}

	public JsonLayout(String jsonString, MetaData metaData) {
		this.jsonString = jsonString;
		this.metaData = metaData;
	}

	public JsonLayout(Long id, String jsonString, MetaData metaData) {
		this.id = id;
		this.jsonString = jsonString;
		this.metaData = metaData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	
}
