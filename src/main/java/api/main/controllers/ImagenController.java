package api.main.controllers;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.main.dtos.*;
import api.main.services.ImagenService;
import api.main.exceptions.StatusException;


@Controller
@RestController
@RequestMapping(path = "api/v1/imagen")
public class ImagenController {
	
	private ImagenService imagenService;

	public ImagenController(ImagenService imagenService){
		this.imagenService = imagenService;
	}

	/**
	 * This method return all entities 'Imagen' in the database
	 * @return entities 'Imagen' transformed in DTO's (Data transference Object)
	 * @since 1.0
	 */
	@GetMapping("/")
	public List<ImagenDTO> getAll() {
		
		return ResponseEntity.status(200).body(imagenService.getAll()).getBody();
		
	}

	/**
	 * This method return only entity 'Imagen' that match with the id in the database
	 * @param id this is a index to find in the DB.
	 * @return entity 'Imagen' that match with the id transformed in DTO's (Data transference Object).
	 * @since 1.0
	 */
	@GetMapping("/{id}")
	public ImagenDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(imagenService.getOne(id)).getBody();
		
	}

	/**
	 * This method save an entity 'ImagenDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @return entities 'ImagenDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PostMapping("/")
	public ResponseEntity save(@RequestBody ImagenDTO t) {
		
		ImagenDTO temp = imagenService.save(t);		
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

	/**
	 * This method update an entity 'ImagenDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ImagenDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody ImagenDTO t, @PathVariable int id) {
		
		ImagenDTO temp = imagenService.update(t, id);
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

	/**
	 * This method delete an entity 'Imagen' in the database
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return nothing. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
	
		boolean det = imagenService.delete(id);
		
		try {
			
			if(det) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			}
			else {
				throw new StatusException("Bad request. Please verify the id or if exist a relation with another table", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

}

