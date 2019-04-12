package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UnidadMedidaDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	private String abreviatura;
	
	
	//Constructor
	public UnidadMedidaDTO() {
		
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
	
	public void setAbreviatura(String abreviatura){
		this.abreviatura = abreviatura;
	}
	
	public String getAbreviatura(){
		return abreviatura;
	}
	
	
	
	
	

}

