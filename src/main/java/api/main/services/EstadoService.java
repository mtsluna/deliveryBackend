package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.EstadoRepository;


@Service
public class EstadoService {
	
	private EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository){
		this.estadoRepository = estadoRepository;
	}

	/**
	 * This method transform all entities 'Estado' in 'EstadoDTO' in the database
	 * @return entities 'Estado' transformed in 'Estado'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<EstadoDTO> getAll() {
	
		List<EstadoDTO> result = new ArrayList<>();
	
		for(Estado object2 : estadoRepository.findAll()){
			EstadoDTO object = new EstadoDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Estado' in 'EstadoDTO' in the database
	 * @return entity 'Estado' transformed in 'EstadoDTO' (Data transference Object)
	 * @since 1.0
	 */
	public EstadoDTO getOne(int id) {
	
		Optional<Estado> aOptional = estadoRepository.findById(id);
		EstadoDTO object = new EstadoDTO();
	
		try {	
	
			Estado object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'EstadoDTO' in the entity 'Estado' for save it in the database
	 * @param estadoDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'EstadoDTO'.
	 * @since 1.0
	 */
	public EstadoDTO save(EstadoDTO estadoDTO) {
		
		Estado estado = new Estado();
		
		estado.setNombre(estadoDTO.getNombre());
		
		
		
		
		estadoRepository.save(estado);
		
		estadoDTO.setId(estado.getId());
		return estadoDTO;
		
	}
	/**
	 * This method transform an entity 'EstadoDTO' in the entity 'Estado' for update it in the database
	 * @param estadoDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'EstadoDTO'.
	 * @since 1.0
	 */
	public EstadoDTO update(EstadoDTO estadoDTO, int id) {
		
		Optional<Estado> optional = estadoRepository.findById(id);
		Estado estado = new Estado();
		
		try {
		
		estado = optional.get();
	
		estado.setNombre(estadoDTO.getNombre());
		
		
		
		
		estadoRepository.save(estado);
		
		estadoDTO.setId(estado.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			estadoDTO.setId(0);
	
		}
	
		return estadoDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Estado' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			estadoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

