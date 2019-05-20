package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PlatoDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	private String tiempoPreparacion;
	private double precio;
	
	private List <PlatoDetalleDTO> detalles = new ArrayList<>();
	private PlatoCategoriaDTO categoria;
	private ImagenDTO imagen;
	
	//Constructor
	public PlatoDTO() {
		
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
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<PlatoDetalleDTO> getDetalles(){
		return detalles;
	}
	
	public PlatoCategoriaDTO getCategoria(){
		return categoria;
	}
	
	public ImagenDTO getImagen(){
		return imagen;
	}
	
	
	public void setDetalles(List<PlatoDetalleDTO> detalles){
		this.detalles = detalles;
	}
	
	public void setCategoria(PlatoCategoriaDTO categoria){
		this.categoria = categoria;
	}
	
	public void setImagen(ImagenDTO imagen){
		this.imagen = imagen;
	}
	
	
	

}

