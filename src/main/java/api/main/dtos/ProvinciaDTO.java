package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class ProvinciaDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	
	private PaisDTO pais;
	
	//Constructor
	public ProvinciaDTO() {
		
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
	
	
	public PaisDTO getPais(){
		return pais;
	}
	
	
	public void setPais(PaisDTO pais){
		this.pais = pais;
	}
	
	
	

}

