package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_plato")
public class Plato{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "plato_id")
	private int id;
	
	@Column(name = "plato_nombre")
	private String nombre;
	@Column(name = "plato_tiempopreparacion")
	private String tiempoPreparacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <PlatoDetalle> detalles = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "fk_posee_categoria")
	private PlatoCategoria categoria;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_posee_imagen_plato")
	private Imagen imagen;
	
	//Constructor
	public Plato() {
		
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
	
	public void setTiempoPreparacion(String tiempoPreparacion){
		this.tiempoPreparacion = tiempoPreparacion;
	}
	
	public String getTiempoPreparacion(){
		return tiempoPreparacion;
	}
	
	
	public List<PlatoDetalle> getDetalles(){
		return detalles;
	}
	
	public PlatoCategoria getCategoria(){
		return categoria;
	}
	
	public Imagen getImagen(){
		return imagen;
	}
	
	
	public void setDetalles(List<PlatoDetalle> detalles){
		this.detalles = detalles;
	}
	
	public void setCategoria(PlatoCategoria categoria){
		this.categoria = categoria;
	}
	
	public void setImagen(Imagen imagen){
		this.imagen = imagen;
	}
	
	
	
	
	

}

