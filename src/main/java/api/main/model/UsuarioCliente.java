package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "usuariocliente")
public class UsuarioCliente extends Usuario{
	
	
	@Column(name = "usuariocliente_fechanacimiento")
	private String fechaNacimiento;
	@Column(name = "usuariocliente_sexo")
	public String sexo;
	
	@OneToMany
	private List <Comprobante> comprobantes = new ArrayList<>();
	
	//Constructor
	public UsuarioCliente() {
		super();
	}
	
	
	public void setFechaNacimiento(String fechaNacimiento){
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getFechaNacimiento(){
		return fechaNacimiento;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	
	public List<Comprobante> getComprobantes(){
		return comprobantes;
	}
	
	
	public void setComprobantes(List<Comprobante> comprobantes){
		this.comprobantes = comprobantes;
	}
	
	
	
	
	

}

