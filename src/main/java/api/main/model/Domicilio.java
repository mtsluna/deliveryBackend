package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_domicilio")
public class Domicilio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "domicilio_id")
	private int id;
	
	@Column(name = "domicilio_calle")
	private String calle;
	@Column(name = "domicilio_numero")
	private String numero;
	@Column(name = "domicilio_piso")
	private int piso;
	@Column(name = "domicilio_departamento")
	private int departamento;
	@Column(name = "domicilio_cp")
	private String CP;
	@Column(name = "domicilio_latitud")
	private double latitud;
	@Column(name = "domicilio_longitud")
	private double longitud;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_localidad")
	private Localidad localidad;
	
	//Constructor
	public Domicilio() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setCalle(String calle){
		this.calle = calle;
	}
	
	public String getCalle(){
		return calle;
	}
	
	public void setNumero(String numero){
		this.numero = numero;
	}
	
	public String getNumero(){
		return numero;
	}
	
	public void setPiso(int piso){
		this.piso = piso;
	}
	
	public int getPiso(){
		return piso;
	}
	
	public void setDepartamento(int departamento){
		this.departamento = departamento;
	}
	
	public int getDepartamento(){
		return departamento;
	}
	
	public void setCP(String CP){
		this.CP = CP;
	}
	
	public String getCP(){
		return CP;
	}
	
	public void setLatitud(double latitud){
		this.latitud = latitud;
	}
	
	public double getLatitud(){
		return latitud;
	}
	
	public void setLongitud(double longitud){
		this.longitud = longitud;
	}
	
	public double getLongitud(){
		return longitud;
	}
	
	
	public Localidad getLocalidad(){
		return localidad;
	}
	
	
	public void setLocalidad(Localidad localidad){
		this.localidad = localidad;
	}
	
	
	
	
	

}

