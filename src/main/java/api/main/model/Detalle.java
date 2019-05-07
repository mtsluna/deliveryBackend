package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_detalle")
public class Detalle{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "detalle_id")
	private int id;
	
	@Column(name = "detalle_cantidad")
	private int cantidad;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_posee_plato")
	private Plato plato;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_posee_articulo")
	private Articulo articulo;
	
	//Constructor
	public Detalle() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	
	public Plato getPlato(){
		return plato;
	}
	
	public Articulo getArticulo(){
		return articulo;
	}
	
	
	public void setPlato(Plato plato){
		this.plato = plato;
	}
	
	public void setArticulo(Articulo articulo){
		this.articulo = articulo;
	}
	
	
	
	
	

}

