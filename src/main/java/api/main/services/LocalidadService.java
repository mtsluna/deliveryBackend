package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.LocalidadRepository;


@Service
public class LocalidadService {
	
	private LocalidadRepository localidadRepository;

	public LocalidadService(LocalidadRepository localidadRepository){
		this.localidadRepository = localidadRepository;
	}

	/**
	 * This method transform all entities 'Localidad' in 'LocalidadDTO' in the database
	 * @return entities 'Localidad' transformed in 'Localidad'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<LocalidadDTO> getAll() {
	
		List<LocalidadDTO> result = new ArrayList<>();
	
		for(Localidad object2 : localidadRepository.findAll()){
			LocalidadDTO object = new LocalidadDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				ProvinciaDTO provincia = new ProvinciaDTO();
				provincia.setId(object2.getProvincia().getId());
				provincia.setNombre(object2.getProvincia().getNombre());
				object.setProvincia(provincia);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Localidad' in 'LocalidadDTO' in the database
	 * @return entity 'Localidad' transformed in 'LocalidadDTO' (Data transference Object)
	 * @since 1.0
	 */
	public LocalidadDTO getOne(int id) {
	
		Optional<Localidad> aOptional = localidadRepository.findById(id);
		LocalidadDTO object = new LocalidadDTO();
	
		try {	
	
			Localidad object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				ProvinciaDTO provincia = new ProvinciaDTO();
				provincia.setId(object2.getProvincia().getId());
				provincia.setNombre(object2.getProvincia().getNombre());
				object.setProvincia(provincia);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'LocalidadDTO' in the entity 'Localidad' for save it in the database
	 * @param localidadDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'LocalidadDTO'.
	 * @since 1.0
	 */
	public LocalidadDTO save(LocalidadDTO localidadDTO) {
		
		Localidad localidad = new Localidad();
		
		localidad.setNombre(localidadDTO.getNombre());
		
		try {
			Provincia provincia = new Provincia();
			provincia.setId(localidadDTO.getProvincia().getId());
			localidad.setProvincia(provincia);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		localidadRepository.save(localidad);
		
		localidadDTO.setId(localidad.getId());
		return localidadDTO;
		
	}
	/**
	 * This method transform an entity 'LocalidadDTO' in the entity 'Localidad' for update it in the database
	 * @param localidadDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'LocalidadDTO'.
	 * @since 1.0
	 */
	public LocalidadDTO update(LocalidadDTO localidadDTO, int id) {
		
		Optional<Localidad> optional = localidadRepository.findById(id);
		Localidad localidad = new Localidad();
		
		try {
		
		localidad = optional.get();
	
		localidad.setNombre(localidadDTO.getNombre());
		
		try {
			Provincia provincia = new Provincia();
			provincia.setId(localidadDTO.getProvincia().getId());
			localidad.setProvincia(provincia);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		localidadRepository.save(localidad);
		
		localidadDTO.setId(localidad.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			localidadDTO.setId(0);
	
		}
	
		return localidadDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Localidad' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			localidadRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

