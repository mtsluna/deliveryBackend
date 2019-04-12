package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "usuarioavanzado")
public class UsuarioAvanzado extends Usuario{
	
	
	@Column(name = "usuarioavanzado_fechaalta")
	private String fechaAlta;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_rol")
	private Rol rol;
	
	//Constructor
	public UsuarioAvanzado() {
		super();
	}
	
	
	public void setFechaAlta(String fechaAlta){
		this.fechaAlta = fechaAlta;
	}
	
	public String getFechaAlta(){
		return fechaAlta;
	}
	
	
	public Rol getRol(){
		return rol;
	}
	
	
	public void setRol(Rol rol){
		this.rol = rol;
	}
	
	
	
	
	

}

