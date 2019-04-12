package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UsuarioClienteDTO extends UsuarioDTO implements Serializable{
	
	
	private String fechaNacimiento;
	public String sexo;
	
	private List <ComprobanteDTO> comprobantes = new ArrayList<>();
	
	//Constructor
	public UsuarioClienteDTO() {
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
	
	
	public List<ComprobanteDTO> getComprobantes(){
		return comprobantes;
	}
	
	
	public void setComprobantes(List<ComprobanteDTO> comprobantes){
		this.comprobantes = comprobantes;
	}
	
	
	

}

