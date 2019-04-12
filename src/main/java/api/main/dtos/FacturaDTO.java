package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class FacturaDTO extends ComprobanteDTO implements Serializable{
	
	
	private String tipoFactura;
	
	private List <DetalleDTO> detalle = new ArrayList<>();
	
	//Constructor
	public FacturaDTO() {
		super();
	}
	
	
	public void setTipoFactura(String tipoFactura){
		this.tipoFactura = tipoFactura;
	}
	
	public String getTipoFactura(){
		return tipoFactura;
	}
	
	
	public List<DetalleDTO> getDetalle(){
		return detalle;
	}
	
	
	public void setDetalle(List<DetalleDTO> detalle){
		this.detalle = detalle;
	}
	
	
	

}

