package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "factura")
public class Factura extends Comprobante{
	
	
	@Column(name = "factura_tipofactura")
	private String tipoFactura;
	
	@OneToMany
	private List <Detalle> detalle = new ArrayList<>();
	
	//Constructor
	public Factura() {
		super();
	}
	
	
	public void setTipoFactura(String tipoFactura){
		this.tipoFactura = tipoFactura;
	}
	
	public String getTipoFactura(){
		return tipoFactura;
	}
	
	
	public List<Detalle> getDetalle(){
		return detalle;
	}
	
	
	public void setDetalle(List<Detalle> detalle){
		this.detalle = detalle;
	}
	
	
	
	
	

}

