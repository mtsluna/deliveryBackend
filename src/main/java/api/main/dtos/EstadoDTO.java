package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class EstadoDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	
	
	//Constructor
	public EstadoDTO() {
		
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

