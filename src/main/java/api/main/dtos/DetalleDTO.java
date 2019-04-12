package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class DetalleDTO implements Serializable{
	
	private int id;
	
	private int cantidad;
	
	private PlatoDTO plato;
	private ArticuloDTO articulo;
	
	//Constructor
	public DetalleDTO() {
		
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
	
	
	public PlatoDTO getPlato(){
		return plato;
	}
	
	public ArticuloDTO getArticulo(){
		return articulo;
	}
	
	
	public void setPlato(PlatoDTO plato){
		this.plato = plato;
	}
	
	public void setArticulo(ArticuloDTO articulo){
		this.articulo = articulo;
	}
	
	
	

}

