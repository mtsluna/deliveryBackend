package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class ArticuloDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	private String descripcion;
	private double precioCompra;
	private int stock;
	private int stockMinimo;
	private int stockMaximo;
	private boolean esInsumo;
	private double precioVenta;
	
	private ArticuloCategoriaDTO categoria;
	private UnidadMedidaDTO unidadMedida;
	private ImagenDTO imagen;
	
	//Constructor
	public ArticuloDTO() {
		
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
	
	public void setPrecioCompra(double precioCompra){
		this.precioCompra = precioCompra;
	}
	
	public double getPrecioCompra(){
		return precioCompra;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}
	
	public int getStock(){
		return stock;
	}
	
	public void setStockMinimo(int stockMinimo){
		this.stockMinimo = stockMinimo;
	}
	
	public int getStockMinimo(){
		return stockMinimo;
	}
	
	public void setStockMaximo(int stockMaximo){
		this.stockMaximo = stockMaximo;
	}
	
	public int getStockMaximo(){
		return stockMaximo;
	}
	
	public void setEsInsumo(boolean esInsumo){
		this.esInsumo = esInsumo;
	}
	
	public boolean getEsInsumo(){
		return esInsumo;
	}
	
	public void setPrecioVenta(double precioVenta){
		this.precioVenta = precioVenta;
	}
	
	public double getPrecioVenta(){
		return precioVenta;
	}
	
	
	public ArticuloCategoriaDTO getCategoria(){
		return categoria;
	}
	
	public UnidadMedidaDTO getUnidadMedida(){
		return unidadMedida;
	}
	
	public ImagenDTO getImagen(){
		return imagen;
	}
	
	
	public void setCategoria(ArticuloCategoriaDTO categoria){
		this.categoria = categoria;
	}
	
	public void setUnidadMedida(UnidadMedidaDTO unidadMedida){
		this.unidadMedida = unidadMedida;
	}
	
	public void setImagen(ImagenDTO imagen){
		this.imagen = imagen;
	}
	
	
	

}

