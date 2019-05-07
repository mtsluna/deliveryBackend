package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UsuarioClienteDTO extends UsuarioDTO implements Serializable{
	
	
	private String fechaNacimiento;
	public String sexo;
	
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
	
	
	

}

