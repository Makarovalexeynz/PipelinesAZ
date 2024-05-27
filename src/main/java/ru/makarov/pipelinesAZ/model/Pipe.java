package ru.makarov.pipelinesAZ.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pipe")
public class Pipe {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "diameter")
	private float diameter;
	
	@Column(name = "length")
	private float length;
	
	@Column(name = "temperatureflow")
	private int temperatureflow;
	
	@ManyToOne
	@JoinColumn(name = "pipeline_id", referencedColumnName = "id")
	private Pipeline owner;
	
			

	public Pipe() {
	
	}

	
	public Pipe(int id, float diameter, float length, int temperatureflow) {
		this.id = id;
		this.diameter = diameter;
		this.length = length;
		this.temperatureflow = temperatureflow;
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public int getTemperatureflow() {
		return temperatureflow;
	}

	public void setTemperatureflow(int temperatureflow) {
		this.temperatureflow = temperatureflow;
	}
	
	public float getSurfacearea() {
		return (float)3.14 * getDiameter();
	}
	
	
	
	public void setOwner(Pipeline owner) {  // new
		this.owner = owner;                 // new
	}

	
	public Pipeline getOwner() {
		return owner;
	}


	public String useCoat(){
		if (getTemperatureflow() < 80) {
			return "anticorrosionCoating";
		} else return "termoCoating";
	}


	@Override
	public String toString() {
		return "Pipe [id=" + id + ", diameter=" + diameter + ", length=" + length + ", temperatureflow="
				+ temperatureflow + "]\n";
	}
	 
	
}
