package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_platodetalle")
public class PlatoDetalle{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "platodetalle_id")
	private int id;
	
	@Column(name = "platodetalle_cantidad")
	private int cantidad;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_articulo")
	private Articulo articulo;
	
	//Constructor
	public PlatoDetalle() {
		
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
	
	
	public Articulo getArticulo(){
		return articulo;
	}
	
	
	public void setArticulo(Articulo articulo){
		this.articulo = articulo;
	}
	
	
	
	
	

}

