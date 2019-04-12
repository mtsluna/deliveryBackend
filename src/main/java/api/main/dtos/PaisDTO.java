package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PaisDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	
	
	//Constructor
	public PaisDTO() {
		
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
	
	
	
	
	

}

