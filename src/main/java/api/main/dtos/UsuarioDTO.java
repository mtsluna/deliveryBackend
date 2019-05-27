package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UsuarioDTO implements Serializable{
	
	private int id;
	
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	private double telefono;
	private String password;
	private String alta;	
	private DomicilioDTO domicilio;
	private ImagenDTO imagen;
	
	//Constructor
	public UsuarioDTO() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setDni(String dni){
		this.dni = dni;
	}
	
	public String getDni(){
		return dni;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public void setTelefono(double telefono){
		this.telefono = telefono;
	}
	
	public double getTelefono(){
		return telefono;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getAlta() {
		return alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}

	public DomicilioDTO getDomicilio(){
		return domicilio;
	}
	
	public ImagenDTO getImagen(){
		return imagen;
	}
	
	
	public void setDomicilio(DomicilioDTO domicilio){
		this.domicilio = domicilio;
	}
	
	public void setImagen(ImagenDTO imagen){
		this.imagen = imagen;
	}
	
	
	

}

