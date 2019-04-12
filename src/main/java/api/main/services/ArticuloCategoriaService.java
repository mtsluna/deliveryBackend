package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.ArticuloCategoriaRepository;


@Service
public class ArticuloCategoriaService {
	
	private ArticuloCategoriaRepository articuloCategoriaRepository;

	public ArticuloCategoriaService(ArticuloCategoriaRepository articuloCategoriaRepository){
		this.articuloCategoriaRepository = articuloCategoriaRepository;
	}

	/**
	 * This method transform all entities 'ArticuloCategoria' in 'ArticuloCategoriaDTO' in the database
	 * @return entities 'ArticuloCategoria' transformed in 'ArticuloCategoria'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<ArticuloCategoriaDTO> getAll() {
	
		List<ArticuloCategoriaDTO> result = new ArrayList<>();
	
		for(ArticuloCategoria object2 : articuloCategoriaRepository.findAll()){
			ArticuloCategoriaDTO object = new ArticuloCategoriaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setDescripcion(object2.getDescripcion());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'ArticuloCategoria' in 'ArticuloCategoriaDTO' in the database
	 * @return entity 'ArticuloCategoria' transformed in 'ArticuloCategoriaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public ArticuloCategoriaDTO getOne(int id) {
	
		Optional<ArticuloCategoria> aOptional = articuloCategoriaRepository.findById(id);
		ArticuloCategoriaDTO object = new ArticuloCategoriaDTO();
	
		try {	
	
			ArticuloCategoria object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setDescripcion(object2.getDescripcion());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'ArticuloCategoriaDTO' in the entity 'ArticuloCategoria' for save it in the database
	 * @param articuloCategoriaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'ArticuloCategoriaDTO'.
	 * @since 1.0
	 */
	public ArticuloCategoriaDTO save(ArticuloCategoriaDTO articuloCategoriaDTO) {
		
		ArticuloCategoria articuloCategoria = new ArticuloCategoria();
		
		articuloCategoria.setNombre(articuloCategoriaDTO.getNombre());
		articuloCategoria.setDescripcion(articuloCategoriaDTO.getDescripcion());
		
		
		
		
		articuloCategoriaRepository.save(articuloCategoria);
		
		articuloCategoriaDTO.setId(articuloCategoria.getId());
		return articuloCategoriaDTO;
		
	}
	/**
	 * This method transform an entity 'ArticuloCategoriaDTO' in the entity 'ArticuloCategoria' for update it in the database
	 * @param articuloCategoriaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ArticuloCategoriaDTO'.
	 * @since 1.0
	 */
	public ArticuloCategoriaDTO update(ArticuloCategoriaDTO articuloCategoriaDTO, int id) {
		
		Optional<ArticuloCategoria> optional = articuloCategoriaRepository.findById(id);
		ArticuloCategoria articuloCategoria = new ArticuloCategoria();
		
		try {
		
		articuloCategoria = optional.get();
	
		articuloCategoria.setNombre(articuloCategoriaDTO.getNombre());
		articuloCategoria.setDescripcion(articuloCategoriaDTO.getDescripcion());
		
		
		
		
		articuloCategoriaRepository.save(articuloCategoria);
		
		articuloCategoriaDTO.setId(articuloCategoria.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			articuloCategoriaDTO.setId(0);
	
		}
	
		return articuloCategoriaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'ArticuloCategoria' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			articuloCategoriaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

