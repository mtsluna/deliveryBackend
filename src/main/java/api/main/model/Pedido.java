package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "pedido")
public class Pedido extends Comprobante{
	
	
	@Column(name = "pedido_horaestimadafin")
	private String horaEstimadaFin;
	@Column(name = "pedido_tipoenvio")
	private String tipoEnvio;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_posee_estado")
	private Estado estado;
	@OneToMany
	private List <Detalle> detalle = new ArrayList<>();
	
	//Constructor
	public Pedido() {
		super();
	}
	
	
	public void setHoraEstimadaFin(String horaEstimadaFin){
		this.horaEstimadaFin = horaEstimadaFin;
	}
	
	public String getHoraEstimadaFin(){
		return horaEstimadaFin;
	}
	
	public void setTipoEnvio(String tipoEnvio){
		this.tipoEnvio = tipoEnvio;
	}
	
	public String getTipoEnvio(){
		return tipoEnvio;
	}
	
	
	public Estado getEstado(){
		return estado;
	}
	
	public List<Detalle> getDetalle(){
		return detalle;
	}
	
	
	public void setEstado(Estado estado){
		this.estado = estado;
	}
	
	public void setDetalle(List<Detalle> detalle){
		this.detalle = detalle;
	}
	
	
	
	
	

}

