package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_rol")
public class Rol{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "rol_id")
	private int id;
	
	@Column(name = "rol_nombre")
	private String nombre;
	
	
	//Constructor
	public Rol() {
		
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

