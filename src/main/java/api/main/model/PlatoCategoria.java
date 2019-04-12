package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_platocategoria")
public class PlatoCategoria{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "platocategoria_id")
	private int id;
	
	@Column(name = "platocategoria_nombre")
	private String nombre;
	@Column(name = "platocategoria_porcentajeganancia")
	private double porcentajeGanancia;
	
	
	//Constructor
	public PlatoCategoria() {
		
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
	
	public void setPorcentajeGanancia(double porcentajeGanancia){
		this.porcentajeGanancia = porcentajeGanancia;
	}
	
	public double getPorcentajeGanancia(){
		return porcentajeGanancia;
	}
	
	
	
	
	
	
	

}

