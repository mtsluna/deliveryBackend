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
import api.main.services.ArticuloService;
import api.main.exceptions.StatusException;


@Controller
@RestController
@RequestMapping(path = "api/v1/articulo")
public class ArticuloController {
	
	private ArticuloService articuloService;

	public ArticuloController(ArticuloService articuloService){
		this.articuloService = articuloService;
	}

	/**
	 * This method return all entities 'Articulo' in the database
	 * @return entities 'Articulo' transformed in DTO's (Data transference Object)
	 * @since 1.0
	 */
	@GetMapping("/")
	public List<ArticuloDTO> getAll() {
		
		return ResponseEntity.status(200).body(articuloService.getAll()).getBody();
		
	}

	/**
	 * This method return only entity 'Articulo' that match with the id in the database
	 * @param id this is a index to find in the DB.
	 * @return entity 'Articulo' that match with the id transformed in DTO's (Data transference Object).
	 * @since 1.0
	 */
	@GetMapping("/{id}")
	public ArticuloDTO getOne(@PathVariable int id) {
				
		return ResponseEntity.status(200).body(articuloService.getOne(id)).getBody();
		
	}

	/**
	 * This method save an entity 'ArticuloDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @return entities 'ArticuloDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PostMapping("/")
	public ResponseEntity save(@RequestBody ArticuloDTO t) {
		
		ArticuloDTO temp = articuloService.save(t);		
		
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
	 * This method update an entity 'ArticuloDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ArticuloDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody ArticuloDTO t, @PathVariable int id) {
		
		ArticuloDTO temp = articuloService.update(t, id);
		
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
	 * This method delete an entity 'Articulo' in the database
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return nothing. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
	
		boolean det = articuloService.delete(id);
		
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

