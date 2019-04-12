package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PlatoDetalleDTO implements Serializable{
	
	private int id;
	
	private int cantidad;
	
	private ArticuloDTO articulo;
	
	//Constructor
	public PlatoDetalleDTO() {
		
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
	
	
	public ArticuloDTO getArticulo(){
		return articulo;
	}
	
	
	public void setArticulo(ArticuloDTO articulo){
		this.articulo = articulo;
	}
	
	
	

}

