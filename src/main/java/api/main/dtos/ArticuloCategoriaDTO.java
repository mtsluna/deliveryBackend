package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class ArticuloCategoriaDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	private String descripcion;
	
	
	//Constructor
	public ArticuloCategoriaDTO() {
		
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
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	
	
	
	

}

