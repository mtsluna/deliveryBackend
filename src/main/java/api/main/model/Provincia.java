package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_provincia")
public class Provincia{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "provincia_id")
	private int id;
	
	@Column(name = "provincia_nombre")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_pais")
	private Pais pais;
	
	//Constructor
	public Provincia() {
		
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
	
	
	public Pais getPais(){
		return pais;
	}
	
	
	public void setPais(Pais pais){
		this.pais = pais;
	}
	
	
	
	
	

}

