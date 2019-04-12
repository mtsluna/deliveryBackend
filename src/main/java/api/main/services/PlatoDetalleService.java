package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PlatoDetalleRepository;


@Service
public class PlatoDetalleService {
	
	private PlatoDetalleRepository platoDetalleRepository;

	public PlatoDetalleService(PlatoDetalleRepository platoDetalleRepository){
		this.platoDetalleRepository = platoDetalleRepository;
	}

	/**
	 * This method transform all entities 'PlatoDetalle' in 'PlatoDetalleDTO' in the database
	 * @return entities 'PlatoDetalle' transformed in 'PlatoDetalle'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PlatoDetalleDTO> getAll() {
	
		List<PlatoDetalleDTO> result = new ArrayList<>();
	
		for(PlatoDetalle object2 : platoDetalleRepository.findAll()){
			PlatoDetalleDTO object = new PlatoDetalleDTO();
			object.setId(object2.getId());
			object.setCantidad(object2.getCantidad());
			
			try {
				ArticuloDTO articulo = new ArticuloDTO();
				articulo.setId(object2.getArticulo().getId());
				articulo.setNombre(object2.getArticulo().getNombre());
				articulo.setDescripcion(object2.getArticulo().getDescripcion());
				articulo.setPrecioCompra(object2.getArticulo().getPrecioCompra());
				articulo.setStock(object2.getArticulo().getStock());
				articulo.setStockMinimo(object2.getArticulo().getStockMinimo());
				articulo.setStockMaximo(object2.getArticulo().getStockMaximo());
				articulo.setEsInsumo(object2.getArticulo().getEsInsumo());
				articulo.setPrecioVenta(object2.getArticulo().getPrecioVenta());
				object.setArticulo(articulo);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'PlatoDetalle' in 'PlatoDetalleDTO' in the database
	 * @return entity 'PlatoDetalle' transformed in 'PlatoDetalleDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PlatoDetalleDTO getOne(int id) {
	
		Optional<PlatoDetalle> aOptional = platoDetalleRepository.findById(id);
		PlatoDetalleDTO object = new PlatoDetalleDTO();
	
		try {	
	
			PlatoDetalle object2 = aOptional.get();
			object.setId(object2.getId());
			object.setCantidad(object2.getCantidad());
			
			try {
				ArticuloDTO articulo = new ArticuloDTO();
				articulo.setId(object2.getArticulo().getId());
				articulo.setNombre(object2.getArticulo().getNombre());
				articulo.setDescripcion(object2.getArticulo().getDescripcion());
				articulo.setPrecioCompra(object2.getArticulo().getPrecioCompra());
				articulo.setStock(object2.getArticulo().getStock());
				articulo.setStockMinimo(object2.getArticulo().getStockMinimo());
				articulo.setStockMaximo(object2.getArticulo().getStockMaximo());
				articulo.setEsInsumo(object2.getArticulo().getEsInsumo());
				articulo.setPrecioVenta(object2.getArticulo().getPrecioVenta());
				object.setArticulo(articulo);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'PlatoDetalleDTO' in the entity 'PlatoDetalle' for save it in the database
	 * @param platoDetalleDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PlatoDetalleDTO'.
	 * @since 1.0
	 */
	public PlatoDetalleDTO save(PlatoDetalleDTO platoDetalleDTO) {
		
		PlatoDetalle platoDetalle = new PlatoDetalle();
		
		platoDetalle.setCantidad(platoDetalleDTO.getCantidad());
		
		try {
			Articulo articulo = new Articulo();
			articulo.setId(platoDetalleDTO.getArticulo().getId());
			platoDetalle.setArticulo(articulo);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		platoDetalleRepository.save(platoDetalle);
		
		platoDetalleDTO.setId(platoDetalle.getId());
		return platoDetalleDTO;
		
	}
	/**
	 * This method transform an entity 'PlatoDetalleDTO' in the entity 'PlatoDetalle' for update it in the database
	 * @param platoDetalleDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PlatoDetalleDTO'.
	 * @since 1.0
	 */
	public PlatoDetalleDTO update(PlatoDetalleDTO platoDetalleDTO, int id) {
		
		Optional<PlatoDetalle> optional = platoDetalleRepository.findById(id);
		PlatoDetalle platoDetalle = new PlatoDetalle();
		
		try {
		
		platoDetalle = optional.get();
	
		platoDetalle.setCantidad(platoDetalleDTO.getCantidad());
		
		try {
			Articulo articulo = new Articulo();
			articulo.setId(platoDetalleDTO.getArticulo().getId());
			platoDetalle.setArticulo(articulo);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		platoDetalleRepository.save(platoDetalle);
		
		platoDetalleDTO.setId(platoDetalle.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			platoDetalleDTO.setId(0);
	
		}
	
		return platoDetalleDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'PlatoDetalle' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			platoDetalleRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

