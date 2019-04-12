package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.ImagenRepository;


@Service
public class ImagenService {
	
	private ImagenRepository imagenRepository;

	public ImagenService(ImagenRepository imagenRepository){
		this.imagenRepository = imagenRepository;
	}

	/**
	 * This method transform all entities 'Imagen' in 'ImagenDTO' in the database
	 * @return entities 'Imagen' transformed in 'Imagen'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<ImagenDTO> getAll() {
	
		List<ImagenDTO> result = new ArrayList<>();
	
		for(Imagen object2 : imagenRepository.findAll()){
			ImagenDTO object = new ImagenDTO();
			object.setId(object2.getId());
			object.setUrl(object2.getUrl());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Imagen' in 'ImagenDTO' in the database
	 * @return entity 'Imagen' transformed in 'ImagenDTO' (Data transference Object)
	 * @since 1.0
	 */
	public ImagenDTO getOne(int id) {
	
		Optional<Imagen> aOptional = imagenRepository.findById(id);
		ImagenDTO object = new ImagenDTO();
	
		try {	
	
			Imagen object2 = aOptional.get();
			object.setId(object2.getId());
			object.setUrl(object2.getUrl());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'ImagenDTO' in the entity 'Imagen' for save it in the database
	 * @param imagenDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'ImagenDTO'.
	 * @since 1.0
	 */
	public ImagenDTO save(ImagenDTO imagenDTO) {
		
		Imagen imagen = new Imagen();
		
		imagen.setUrl(imagenDTO.getUrl());
		
		
		
		
		imagenRepository.save(imagen);
		
		imagenDTO.setId(imagen.getId());
		return imagenDTO;
		
	}
	/**
	 * This method transform an entity 'ImagenDTO' in the entity 'Imagen' for update it in the database
	 * @param imagenDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ImagenDTO'.
	 * @since 1.0
	 */
	public ImagenDTO update(ImagenDTO imagenDTO, int id) {
		
		Optional<Imagen> optional = imagenRepository.findById(id);
		Imagen imagen = new Imagen();
		
		try {
		
		imagen = optional.get();
	
		imagen.setUrl(imagenDTO.getUrl());
		
		
		
		
		imagenRepository.save(imagen);
		
		imagenDTO.setId(imagen.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			imagenDTO.setId(0);
	
		}
	
		return imagenDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Imagen' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			imagenRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

