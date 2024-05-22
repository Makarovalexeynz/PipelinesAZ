package ru.makarov.pipelinesAZ.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pipe")
public class Pipe {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "diameter")
	private int diameter;
	
	@Column(name = "length")
	private float length;
	
	@Column(name = "temperatureflow")
	private int temperatureflow;
			
	public Pipe() {
	
	}

	public Pipe(int id, int diameter, float length, int temperatureflow) {
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

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
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

	public void setTemperatureFlow(int temperatureflow) {
		this.temperatureflow = temperatureflow;
	}
	
	
	
	
}
