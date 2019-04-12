package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_localidad")
public class Localidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "localidad_id")
	private int id;
	
	@Column(name = "localidad_nombre")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_provincia")
	private Provincia provincia;
	
	//Constructor
	public Localidad() {
		
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
	
	
	public Provincia getProvincia(){
		return provincia;
	}
	
	
	public void setProvincia(Provincia provincia){
		this.provincia = provincia;
	}
	
	
	
	
	

}

