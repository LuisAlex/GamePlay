package com.actor;

import org.springframework.stereotype.Component;

@Component("human")
public class Human 
{
	
	private int Health = 16;
	private String nombre = "Human";

	
	public Human() {}
	
	public int getHealth() 
	{
		return Health;
	}
	
	public void setHealth(int health) 
	{
		Health = health;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}