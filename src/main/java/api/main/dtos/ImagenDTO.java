package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class ImagenDTO implements Serializable{
	
	private int id;
	
	private String url;
	
	
	//Constructor
	public ImagenDTO() {
		
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

