package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "usuarioavanzado")
public class UsuarioAvanzado extends Usuario{
		
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_posee_rol")
	private Rol rol;
	
	//Constructor
	public UsuarioAvanzado() {
		super();
	}	
	
	public Rol getRol(){
		return rol;
	}
	
	
	public void setRol(Rol rol){
		this.rol = rol;
	}
	
	
	
	
	

}

