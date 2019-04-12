package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_estado")
public class Estado{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "estado_id")
	private int id;
	
	@Column(name = "estado_nombre")
	private String nombre;
	
	
	//Constructor
	public Estado() {
		
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

