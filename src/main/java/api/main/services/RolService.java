package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.RolRepository;


@Service
public class RolService {
	
	private RolRepository rolRepository;

	public RolService(RolRepository rolRepository){
		this.rolRepository = rolRepository;
	}

	/**
	 * This method transform all entities 'Rol' in 'RolDTO' in the database
	 * @return entities 'Rol' transformed in 'Rol'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<RolDTO> getAll() {
	
		List<RolDTO> result = new ArrayList<>();
	
		for(Rol object2 : rolRepository.findAll()){
			RolDTO object = new RolDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Rol' in 'RolDTO' in the database
	 * @return entity 'Rol' transformed in 'RolDTO' (Data transference Object)
	 * @since 1.0
	 */
	public RolDTO getOne(int id) {
	
		Optional<Rol> aOptional = rolRepository.findById(id);
		RolDTO object = new RolDTO();
	
		try {	
	
			Rol object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'RolDTO' in the entity 'Rol' for save it in the database
	 * @param rolDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'RolDTO'.
	 * @since 1.0
	 */
	public RolDTO save(RolDTO rolDTO) {
		
		Rol rol = new Rol();
		
		rol.setNombre(rolDTO.getNombre());
		
		
		
		
		rolRepository.save(rol);
		
		rolDTO.setId(rol.getId());
		return rolDTO;
		
	}
	/**
	 * This method transform an entity 'RolDTO' in the entity 'Rol' for update it in the database
	 * @param rolDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'RolDTO'.
	 * @since 1.0
	 */
	public RolDTO update(RolDTO rolDTO, int id) {
		
		Optional<Rol> optional = rolRepository.findById(id);
		Rol rol = new Rol();
		
		try {
		
		rol = optional.get();
	
		rol.setNombre(rolDTO.getNombre());
		
		
		
		
		rolRepository.save(rol);
		
		rolDTO.setId(rol.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			rolDTO.setId(0);
	
		}
	
		return rolDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Rol' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			rolRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

