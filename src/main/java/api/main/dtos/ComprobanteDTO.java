package api.main.dtos;
import java.io.Serializable;
import java.util.*;

import api.main.model.UsuarioCliente;

public class ComprobanteDTO implements Serializable{
	
	private int id;
	
	private String fecha;
	private double montoDescuento;
	private double total;
	private UsuarioClienteDTO usuarioCliente;
	
	
	//Constructor
	public ComprobanteDTO() {
		
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

	public UsuarioClienteDTO getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(UsuarioClienteDTO usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

}

