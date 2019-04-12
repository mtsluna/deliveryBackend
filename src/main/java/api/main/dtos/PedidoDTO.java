package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PedidoDTO extends ComprobanteDTO implements Serializable{
	
	
	private String horaEstimadaFin;
	private String tipoEnvio;
	
	private EstadoDTO estado;
	private List <DetalleDTO> detalle = new ArrayList<>();
	
	//Constructor
	public PedidoDTO() {
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
	
	
	public EstadoDTO getEstado(){
		return estado;
	}
	
	public List<DetalleDTO> getDetalle(){
		return detalle;
	}
	
	
	public void setEstado(EstadoDTO estado){
		this.estado = estado;
	}
	
	public void setDetalle(List<DetalleDTO> detalle){
		this.detalle = detalle;
	}
	
	
	

}

