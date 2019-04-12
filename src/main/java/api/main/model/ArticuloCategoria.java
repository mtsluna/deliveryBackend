package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_articulocategoria")
public class ArticuloCategoria{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "articulocategoria_id")
	private int id;
	
	@Column(name = "articulocategoria_nombre")
	private String nombre;
	@Column(name = "articulocategoria_descripcion")
	private String descripcion;
	
	
	//Constructor
	public ArticuloCategoria() {
		
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

