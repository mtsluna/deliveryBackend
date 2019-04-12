package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.UnidadMedidaRepository;


@Service
public class UnidadMedidaService {
	
	private UnidadMedidaRepository unidadMedidaRepository;

	public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository){
		this.unidadMedidaRepository = unidadMedidaRepository;
	}

	/**
	 * This method transform all entities 'UnidadMedida' in 'UnidadMedidaDTO' in the database
	 * @return entities 'UnidadMedida' transformed in 'UnidadMedida'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<UnidadMedidaDTO> getAll() {
	
		List<UnidadMedidaDTO> result = new ArrayList<>();
	
		for(UnidadMedida object2 : unidadMedidaRepository.findAll()){
			UnidadMedidaDTO object = new UnidadMedidaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setAbreviatura(object2.getAbreviatura());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'UnidadMedida' in 'UnidadMedidaDTO' in the database
	 * @return entity 'UnidadMedida' transformed in 'UnidadMedidaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public UnidadMedidaDTO getOne(int id) {
	
		Optional<UnidadMedida> aOptional = unidadMedidaRepository.findById(id);
		UnidadMedidaDTO object = new UnidadMedidaDTO();
	
		try {	
	
			UnidadMedida object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setAbreviatura(object2.getAbreviatura());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'UnidadMedidaDTO' in the entity 'UnidadMedida' for save it in the database
	 * @param unidadMedidaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'UnidadMedidaDTO'.
	 * @since 1.0
	 */
	public UnidadMedidaDTO save(UnidadMedidaDTO unidadMedidaDTO) {
		
		UnidadMedida unidadMedida = new UnidadMedida();
		
		unidadMedida.setNombre(unidadMedidaDTO.getNombre());
		unidadMedida.setAbreviatura(unidadMedidaDTO.getAbreviatura());
		
		
		
		
		unidadMedidaRepository.save(unidadMedida);
		
		unidadMedidaDTO.setId(unidadMedida.getId());
		return unidadMedidaDTO;
		
	}
	/**
	 * This method transform an entity 'UnidadMedidaDTO' in the entity 'UnidadMedida' for update it in the database
	 * @param unidadMedidaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'UnidadMedidaDTO'.
	 * @since 1.0
	 */
	public UnidadMedidaDTO update(UnidadMedidaDTO unidadMedidaDTO, int id) {
		
		Optional<UnidadMedida> optional = unidadMedidaRepository.findById(id);
		UnidadMedida unidadMedida = new UnidadMedida();
		
		try {
		
		unidadMedida = optional.get();
	
		unidadMedida.setNombre(unidadMedidaDTO.getNombre());
		unidadMedida.setAbreviatura(unidadMedidaDTO.getAbreviatura());
		
		
		
		
		unidadMedidaRepository.save(unidadMedida);
		
		unidadMedidaDTO.setId(unidadMedida.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			unidadMedidaDTO.setId(0);
	
		}
	
		return unidadMedidaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'UnidadMedida' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			unidadMedidaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

