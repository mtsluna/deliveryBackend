package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.DomicilioRepository;


@Service
public class DomicilioService {
	
	private DomicilioRepository domicilioRepository;

	public DomicilioService(DomicilioRepository domicilioRepository){
		this.domicilioRepository = domicilioRepository;
	}

	/**
	 * This method transform all entities 'Domicilio' in 'DomicilioDTO' in the database
	 * @return entities 'Domicilio' transformed in 'Domicilio'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<DomicilioDTO> getAll() {
	
		List<DomicilioDTO> result = new ArrayList<>();
	
		for(Domicilio object2 : domicilioRepository.findAll()){
			DomicilioDTO object = new DomicilioDTO();
			object.setId(object2.getId());
			object.setCalle(object2.getCalle());
			object.setNumero(object2.getNumero());
			object.setPiso(object2.getPiso());
			object.setDepartamento(object2.getDepartamento());
			object.setCP(object2.getCP());
			object.setLatitud(object2.getLatitud());
			object.setLongitud(object2.getLongitud());
			
			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(object2.getLocalidad().getId());
				localidad.setNombre(object2.getLocalidad().getNombre());
				object.setLocalidad(localidad);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Domicilio' in 'DomicilioDTO' in the database
	 * @return entity 'Domicilio' transformed in 'DomicilioDTO' (Data transference Object)
	 * @since 1.0
	 */
	public DomicilioDTO getOne(int id) {
	
		Optional<Domicilio> aOptional = domicilioRepository.findById(id);
		DomicilioDTO object = new DomicilioDTO();
	
		try {	
	
			Domicilio object2 = aOptional.get();
			object.setId(object2.getId());
			object.setCalle(object2.getCalle());
			object.setNumero(object2.getNumero());
			object.setPiso(object2.getPiso());
			object.setDepartamento(object2.getDepartamento());
			object.setCP(object2.getCP());
			object.setLatitud(object2.getLatitud());
			object.setLongitud(object2.getLongitud());
			
			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(object2.getLocalidad().getId());
				localidad.setNombre(object2.getLocalidad().getNombre());
				object.setLocalidad(localidad);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'DomicilioDTO' in the entity 'Domicilio' for save it in the database
	 * @param domicilioDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'DomicilioDTO'.
	 * @since 1.0
	 */
	public DomicilioDTO save(DomicilioDTO domicilioDTO) {
		
		Domicilio domicilio = new Domicilio();
		
		domicilio.setCalle(domicilioDTO.getCalle());
		domicilio.setNumero(domicilioDTO.getNumero());
		domicilio.setPiso(domicilioDTO.getPiso());
		domicilio.setDepartamento(domicilioDTO.getDepartamento());
		domicilio.setCP(domicilioDTO.getCP());
		domicilio.setLatitud(domicilioDTO.getLatitud());
		domicilio.setLongitud(domicilioDTO.getLongitud());
		
		try {
			Localidad localidad = new Localidad();
			localidad.setId(domicilioDTO.getLocalidad().getId());
			domicilio.setLocalidad(localidad);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		domicilioRepository.save(domicilio);
		
		domicilioDTO.setId(domicilio.getId());
		return domicilioDTO;
		
	}
	/**
	 * This method transform an entity 'DomicilioDTO' in the entity 'Domicilio' for update it in the database
	 * @param domicilioDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'DomicilioDTO'.
	 * @since 1.0
	 */
	public DomicilioDTO update(DomicilioDTO domicilioDTO, int id) {
		
		Optional<Domicilio> optional = domicilioRepository.findById(id);
		Domicilio domicilio = new Domicilio();
		
		try {
		
		domicilio = optional.get();
	
		domicilio.setCalle(domicilioDTO.getCalle());
		domicilio.setNumero(domicilioDTO.getNumero());
		domicilio.setPiso(domicilioDTO.getPiso());
		domicilio.setDepartamento(domicilioDTO.getDepartamento());
		domicilio.setCP(domicilioDTO.getCP());
		domicilio.setLatitud(domicilioDTO.getLatitud());
		domicilio.setLongitud(domicilioDTO.getLongitud());
		
		try {
			Localidad localidad = new Localidad();
			localidad.setId(domicilioDTO.getLocalidad().getId());
			domicilio.setLocalidad(localidad);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		domicilioRepository.save(domicilio);
		
		domicilioDTO.setId(domicilio.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			domicilioDTO.setId(0);
	
		}
	
		return domicilioDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Domicilio' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			domicilioRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

