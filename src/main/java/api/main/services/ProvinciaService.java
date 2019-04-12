package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.ProvinciaRepository;


@Service
public class ProvinciaService {
	
	private ProvinciaRepository provinciaRepository;

	public ProvinciaService(ProvinciaRepository provinciaRepository){
		this.provinciaRepository = provinciaRepository;
	}

	/**
	 * This method transform all entities 'Provincia' in 'ProvinciaDTO' in the database
	 * @return entities 'Provincia' transformed in 'Provincia'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<ProvinciaDTO> getAll() {
	
		List<ProvinciaDTO> result = new ArrayList<>();
	
		for(Provincia object2 : provinciaRepository.findAll()){
			ProvinciaDTO object = new ProvinciaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				PaisDTO pais = new PaisDTO();
				pais.setId(object2.getPais().getId());
				pais.setNombre(object2.getPais().getNombre());
				object.setPais(pais);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Provincia' in 'ProvinciaDTO' in the database
	 * @return entity 'Provincia' transformed in 'ProvinciaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public ProvinciaDTO getOne(int id) {
	
		Optional<Provincia> aOptional = provinciaRepository.findById(id);
		ProvinciaDTO object = new ProvinciaDTO();
	
		try {	
	
			Provincia object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				PaisDTO pais = new PaisDTO();
				pais.setId(object2.getPais().getId());
				pais.setNombre(object2.getPais().getNombre());
				object.setPais(pais);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'ProvinciaDTO' in the entity 'Provincia' for save it in the database
	 * @param provinciaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'ProvinciaDTO'.
	 * @since 1.0
	 */
	public ProvinciaDTO save(ProvinciaDTO provinciaDTO) {
		
		Provincia provincia = new Provincia();
		
		provincia.setNombre(provinciaDTO.getNombre());
		
		try {
			Pais pais = new Pais();
			pais.setId(provinciaDTO.getPais().getId());
			provincia.setPais(pais);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		provinciaRepository.save(provincia);
		
		provinciaDTO.setId(provincia.getId());
		return provinciaDTO;
		
	}
	/**
	 * This method transform an entity 'ProvinciaDTO' in the entity 'Provincia' for update it in the database
	 * @param provinciaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ProvinciaDTO'.
	 * @since 1.0
	 */
	public ProvinciaDTO update(ProvinciaDTO provinciaDTO, int id) {
		
		Optional<Provincia> optional = provinciaRepository.findById(id);
		Provincia provincia = new Provincia();
		
		try {
		
		provincia = optional.get();
	
		provincia.setNombre(provinciaDTO.getNombre());
		
		try {
			Pais pais = new Pais();
			pais.setId(provinciaDTO.getPais().getId());
			provincia.setPais(pais);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		provinciaRepository.save(provincia);
		
		provinciaDTO.setId(provincia.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			provinciaDTO.setId(0);
	
		}
	
		return provinciaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Provincia' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			provinciaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

