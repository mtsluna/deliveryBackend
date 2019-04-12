package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PlatoCategoriaDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	private double porcentajeGanancia;
	
	
	//Constructor
	public PlatoCategoriaDTO() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setPorcentajeGanancia(double porcentajeGanancia){
		this.porcentajeGanancia = porcentajeGanancia;
	}
	
	public double getPorcentajeGanancia(){
		return porcentajeGanancia;
	}
	
	
	
	
	

}

