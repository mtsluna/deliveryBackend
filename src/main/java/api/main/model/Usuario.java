package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType=DiscriminatorType.STRING)
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "usuario_id")
	private int id;
	
	@Column(name = "usuario_email")
	private String email;
	@Column(name = "usuario_dni")
	private String dni;
	@Column(name = "usuario_nombre")
	private String nombre;
	@Column(name = "usuario_apellido")
	private String apellido;
	@Column(name = "usuario_telefono")
	private double telefono;
	@Column(name = "usuario_password")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "fk_posee_domicilio")
	private Domicilio domicilio;
	@OneToOne
	@JoinColumn(name = "fk_posee_imagen")
	private Imagen imagen;
	
	//Constructor
	public Usuario() {
		
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
	
	
	public Domicilio getDomicilio(){
		return domicilio;
	}
	
	public Imagen getImagen(){
		return imagen;
	}
	
	
	public void setDomicilio(Domicilio domicilio){
		this.domicilio = domicilio;
	}
	
	public void setImagen(Imagen imagen){
		this.imagen = imagen;
	}
	
	
	
	
	

}

