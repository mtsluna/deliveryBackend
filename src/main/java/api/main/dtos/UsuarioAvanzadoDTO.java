package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UsuarioAvanzadoDTO extends UsuarioDTO implements Serializable{
		
	private RolDTO rol;
	
	//Constructor
	public UsuarioAvanzadoDTO() {
		super();
	}	
	
	public RolDTO getRol(){
		return rol;
	}
	
	
	public void setRol(RolDTO rol){
		this.rol = rol;
	}
	
	
	

}

