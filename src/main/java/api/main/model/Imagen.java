package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_imagen")
public class Imagen{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "imagen_id")
	private int id;
	
	@Column(name = "imagen_url")
	private String url;
	
	
	//Constructor
	public Imagen() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	
	
	
	
	
	

}

