package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_unidadmedida")
public class UnidadMedida{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "unidadmedida_id")
	private int id;
	
	@Column(name = "unidadmedida_nombre")
	private String nombre;
	@Column(name = "unidadmedida_abreviatura")
	private String abreviatura;
	
	
	//Constructor
	public UnidadMedida() {
		
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

