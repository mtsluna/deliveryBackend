package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PaisRepository;


@Service
public class PaisService {
	
	private PaisRepository paisRepository;

	public PaisService(PaisRepository paisRepository){
		this.paisRepository = paisRepository;
	}

	/**
	 * This method transform all entities 'Pais' in 'PaisDTO' in the database
	 * @return entities 'Pais' transformed in 'Pais'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PaisDTO> getAll() {
	
		List<PaisDTO> result = new ArrayList<>();
	
		for(Pais object2 : paisRepository.findAll()){
			PaisDTO object = new PaisDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Pais' in 'PaisDTO' in the database
	 * @return entity 'Pais' transformed in 'PaisDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PaisDTO getOne(int id) {
	
		Optional<Pais> aOptional = paisRepository.findById(id);
		PaisDTO object = new PaisDTO();
	
		try {	
	
			Pais object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'PaisDTO' in the entity 'Pais' for save it in the database
	 * @param paisDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PaisDTO'.
	 * @since 1.0
	 */
	public PaisDTO save(PaisDTO paisDTO) {
		
		Pais pais = new Pais();
		
		pais.setNombre(paisDTO.getNombre());
		
		
		
		
		paisRepository.save(pais);
		
		paisDTO.setId(pais.getId());
		return paisDTO;
		
	}
	/**
	 * This method transform an entity 'PaisDTO' in the entity 'Pais' for update it in the database
	 * @param paisDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PaisDTO'.
	 * @since 1.0
	 */
	public PaisDTO update(PaisDTO paisDTO, int id) {
		
		Optional<Pais> optional = paisRepository.findById(id);
		Pais pais = new Pais();
		
		try {
		
		pais = optional.get();
	
		pais.setNombre(paisDTO.getNombre());
		
		
		
		
		paisRepository.save(pais);
		
		paisDTO.setId(pais.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			paisDTO.setId(0);
	
		}
	
		return paisDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Pais' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			paisRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

