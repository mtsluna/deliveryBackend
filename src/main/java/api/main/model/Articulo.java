package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_articulo")
public class Articulo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "articulo_id")
	private int id;
	
	@Column(name = "articulo_nombre")
	private String nombre;
	@Column(name = "articulo_descripcion")
	private String descripcion;
	@Column(name = "articulo_preciocompra")
	private double precioCompra;
	@Column(name = "articulo_stock")
	private int stock;
	@Column(name = "articulo_stockminimo")
	private int stockMinimo;
	@Column(name = "articulo_stockmaximo")
	private int stockMaximo;
	@Column(name = "articulo_esinsumo")
	private boolean esInsumo;
	@Column(name = "articulo_precioventa")
	private double precioVenta;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_categoria")
	private ArticuloCategoria categoria;
	@OneToOne
	@JoinColumn(name = "fk_posee_medida")
	private UnidadMedida unidadMedida;
	@OneToOne
	@JoinColumn(name = "fk_posee_imagen_articulo")
	private Imagen imagen;
	
	//Constructor
	public Articulo() {
		
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
	
	
	public ArticuloCategoria getCategoria(){
		return categoria;
	}
	
	public UnidadMedida getUnidadMedida(){
		return unidadMedida;
	}
	
	public Imagen getImagen(){
		return imagen;
	}
	
	
	public void setCategoria(ArticuloCategoria categoria){
		this.categoria = categoria;
	}
	
	public void setUnidadMedida(UnidadMedida unidadMedida){
		this.unidadMedida = unidadMedida;
	}
	
	public void setImagen(Imagen imagen){
		this.imagen = imagen;
	}
	
	
	
	
	

}

