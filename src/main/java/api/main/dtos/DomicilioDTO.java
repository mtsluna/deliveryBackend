package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class DomicilioDTO implements Serializable{
	
	private int id;
	
	private String calle;
	private String numero;
	private int piso;
	private int departamento;
	private String CP;
	private double latitud;
	private double longitud;
	
	private LocalidadDTO localidad;
	
	//Constructor
	public DomicilioDTO() {
		
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
	
	
	public LocalidadDTO getLocalidad(){
		return localidad;
	}
	
	
	public void setLocalidad(LocalidadDTO localidad){
		this.localidad = localidad;
	}
	
	
	

}

