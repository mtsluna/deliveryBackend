package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_pais")
public class Pais{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "pais_id")
	private int id;
	
	@Column(name = "pais_nombre")
	private String nombre;
	
	
	//Constructor
	public Pais() {
		
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

