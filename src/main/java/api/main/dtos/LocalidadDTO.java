package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class LocalidadDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	
	private ProvinciaDTO provincia;
	
	//Constructor
	public LocalidadDTO() {
		
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
	
	
	public ProvinciaDTO getProvincia(){
		return provincia;
	}
	
	
	public void setProvincia(ProvinciaDTO provincia){
		this.provincia = provincia;
	}
	
	
	

}

