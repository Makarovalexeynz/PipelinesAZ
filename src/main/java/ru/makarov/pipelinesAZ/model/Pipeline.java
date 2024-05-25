package ru.makarov.pipelinesAZ.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pipeline")
public class Pipeline {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pipelinename")
	private String pipelinename;
	
	@Column(name = "pipelinecode")
	private String pipelinecode;
	
	public Pipeline() {
	}

	public Pipeline(String pipelinename, String pipelinecode) {
		this.pipelinename = pipelinename;
		this.pipelinecode = pipelinecode;
	}

	public String getPipelinename() {
		return pipelinename;
	}

	public void setPipelinename(String pipelinename) {
		this.pipelinename = pipelinename;
	}

	public String getPipelinecode() {
		return pipelinecode;
	}

	public void setPipelinecode(String pipelinecode) {
		this.pipelinecode = pipelinecode;
	}
	
	
}
