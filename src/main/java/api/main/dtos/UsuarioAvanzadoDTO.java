package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UsuarioAvanzadoDTO extends UsuarioDTO implements Serializable{
	
	
	private String fechaAlta;
	
	private RolDTO rol;
	
	//Constructor
	public UsuarioAvanzadoDTO() {
		super();
	}
	
	
	public void setFechaAlta(String fechaAlta){
		this.fechaAlta = fechaAlta;
	}
	
	public String getFechaAlta(){
		return fechaAlta;
	}
	
	
	public RolDTO getRol(){
		return rol;
	}
	
	
	public void setRol(RolDTO rol){
		this.rol = rol;
	}
	
	
	

}

