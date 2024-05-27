package ru.makarov.pipelinesAZ.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	
	@OneToMany(mappedBy = "owner")
	private List <Pipe> pipes;
	
	public Pipeline() {
	}


	public Pipeline(int id,String pipelinename, String pipelinecode) {
		this.id = id;
		this.pipelinename = pipelinename;
		this.pipelinecode = pipelinecode;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public List<Pipe> getPipes() {
		return pipes;
	}

	public void setPipes(List<Pipe> pipes) {
		this.pipes = pipes;
	}


	@Override
	public String toString() {
		return "Pipeline [id=" + id + ", pipelinename=" + pipelinename + ", pipelinecode=" + pipelinecode + "]";
	}
	
	
	
}
