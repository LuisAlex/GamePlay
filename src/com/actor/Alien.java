package com.actor;

import org.springframework.stereotype.Component;

@Component("alien")
public class Alien 
{
		
	private int Health = 14;
	private String nombre = "Alien";
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alien() {}
	
	public int getHealth() 
	{
		return Health;
	}
	
	public void setHealth(int health) 
	{
		Health = health;
	}
	
}