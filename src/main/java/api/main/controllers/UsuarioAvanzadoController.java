package api.main.controllers;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.main.dtos.*;
import api.main.services.UsuarioAvanzadoService;
import api.main.exceptions.StatusException;


@Controller
@RestController
@RequestMapping(path = "api/v1/usuarioavanzado")
public class UsuarioAvanzadoController {
	
	private UsuarioAvanzadoService usuarioAvanzadoService;

	public UsuarioAvanzadoController(UsuarioAvanzadoService usuarioAvanzadoService){
		this.usuarioAvanzadoService = usuarioAvanzadoService;
	}

	/**
	 * This method return all entities 'UsuarioAvanzado' in the database
	 * @return entities 'UsuarioAvanzado' transformed in DTO's (Data transference Object)
	 * @since 1.0
	 */
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<UsuarioAvanzadoDTO> getAll() {
		
		return ResponseEntity.status(200).body(usuarioAvanzadoService.getAll()).getBody();
		
	}

	/**
	 * This method return only entity 'UsuarioAvanzado' that match with the id in the database
	 * @param id this is a index to find in the DB.
	 * @return entity 'UsuarioAvanzado' that match with the id transformed in DTO's (Data transference Object).
	 * @since 1.0
	 */
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public UsuarioAvanzadoDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(usuarioAvanzadoService.getOne(id)).getBody();
		
	}

	/**
	 * This method save an entity 'UsuarioAvanzadoDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @return entities 'UsuarioAvanzadoDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody UsuarioAvanzadoDTO t) {
		
		UsuarioAvanzadoDTO temp = usuarioAvanzadoService.save(t);		
		
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
	 * This method update an entity 'UsuarioAvanzadoDTO' in the database
	 * @param t it is an object DTO that comes from the JSON that you introduce in the body of request
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'UsuarioAvanzadoDTO' that you introduce in the body request. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody UsuarioAvanzadoDTO t, @PathVariable int id) {
		
		UsuarioAvanzadoDTO temp = usuarioAvanzadoService.update(t, id);
		
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
	 * This method delete an entity 'UsuarioAvanzado' in the database
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return nothing. And status 200 OK or 400 Bad Request.
	 * @since 1.0
	 */
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
	
		boolean det = usuarioAvanzadoService.delete(id);
		
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

