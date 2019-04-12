package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PlatoCategoriaRepository;


@Service
public class PlatoCategoriaService {
	
	private PlatoCategoriaRepository platoCategoriaRepository;

	public PlatoCategoriaService(PlatoCategoriaRepository platoCategoriaRepository){
		this.platoCategoriaRepository = platoCategoriaRepository;
	}

	/**
	 * This method transform all entities 'PlatoCategoria' in 'PlatoCategoriaDTO' in the database
	 * @return entities 'PlatoCategoria' transformed in 'PlatoCategoria'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PlatoCategoriaDTO> getAll() {
	
		List<PlatoCategoriaDTO> result = new ArrayList<>();
	
		for(PlatoCategoria object2 : platoCategoriaRepository.findAll()){
			PlatoCategoriaDTO object = new PlatoCategoriaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setPorcentajeGanancia(object2.getPorcentajeGanancia());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'PlatoCategoria' in 'PlatoCategoriaDTO' in the database
	 * @return entity 'PlatoCategoria' transformed in 'PlatoCategoriaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PlatoCategoriaDTO getOne(int id) {
	
		Optional<PlatoCategoria> aOptional = platoCategoriaRepository.findById(id);
		PlatoCategoriaDTO object = new PlatoCategoriaDTO();
	
		try {	
	
			PlatoCategoria object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setPorcentajeGanancia(object2.getPorcentajeGanancia());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'PlatoCategoriaDTO' in the entity 'PlatoCategoria' for save it in the database
	 * @param platoCategoriaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PlatoCategoriaDTO'.
	 * @since 1.0
	 */
	public PlatoCategoriaDTO save(PlatoCategoriaDTO platoCategoriaDTO) {
		
		PlatoCategoria platoCategoria = new PlatoCategoria();
		
		platoCategoria.setNombre(platoCategoriaDTO.getNombre());
		platoCategoria.setPorcentajeGanancia(platoCategoriaDTO.getPorcentajeGanancia());
		
		
		
		
		platoCategoriaRepository.save(platoCategoria);
		
		platoCategoriaDTO.setId(platoCategoria.getId());
		return platoCategoriaDTO;
		
	}
	/**
	 * This method transform an entity 'PlatoCategoriaDTO' in the entity 'PlatoCategoria' for update it in the database
	 * @param platoCategoriaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PlatoCategoriaDTO'.
	 * @since 1.0
	 */
	public PlatoCategoriaDTO update(PlatoCategoriaDTO platoCategoriaDTO, int id) {
		
		Optional<PlatoCategoria> optional = platoCategoriaRepository.findById(id);
		PlatoCategoria platoCategoria = new PlatoCategoria();
		
		try {
		
		platoCategoria = optional.get();
	
		platoCategoria.setNombre(platoCategoriaDTO.getNombre());
		platoCategoria.setPorcentajeGanancia(platoCategoriaDTO.getPorcentajeGanancia());
		
		
		
		
		platoCategoriaRepository.save(platoCategoria);
		
		platoCategoriaDTO.setId(platoCategoria.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			platoCategoriaDTO.setId(0);
	
		}
	
		return platoCategoriaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'PlatoCategoria' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			platoCategoriaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

