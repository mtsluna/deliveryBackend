package api.main.exceptions;

import org.springframework.http.ResponseEntity;

public class StatusException extends Exception{

	private String message;
	private int status;
	
	public StatusException(String message, int status) {
		super(message);
		this.message = message;
		this.status = status;
	}
	
	public ResponseEntity getResponseStatus() {
		
		return ResponseEntity.status(this.status).body("{ \"Error\": \""+this.message+".\" }");
		
	}
	
}
