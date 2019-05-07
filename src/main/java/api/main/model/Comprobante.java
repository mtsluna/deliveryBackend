package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_comprobante")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType=DiscriminatorType.STRING)
public class Comprobante{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "comprobante_id")
	private int id;
	
	@Column(name = "comprobante_fecha")
	private String fecha;
	@Column(name = "comprobante_montodescuento")
	private double montoDescuento;
	@Column(name = "comprobante_total")
	private double total;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_posee_usuario")
	private UsuarioCliente usuariocliente;
	
	
	//Constructor
	public Comprobante() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public void setMontoDescuento(double montoDescuento){
		this.montoDescuento = montoDescuento;
	}
	
	public double getMontoDescuento(){
		return montoDescuento;
	}
	
	public void setTotal(double total){
		this.total = total;
	}
	
	public double getTotal(){
		return total;
	}

	public UsuarioCliente getUsuariocliente() {
		return usuariocliente;
	}

	public void setUsuariocliente(UsuarioCliente usuariocliente) {
		this.usuariocliente = usuariocliente;
	}

}

