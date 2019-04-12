package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.DetalleRepository;


@Service
public class DetalleService {
	
	private DetalleRepository detalleRepository;

	public DetalleService(DetalleRepository detalleRepository){
		this.detalleRepository = detalleRepository;
	}

	/**
	 * This method transform all entities 'Detalle' in 'DetalleDTO' in the database
	 * @return entities 'Detalle' transformed in 'Detalle'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<DetalleDTO> getAll() {
	
		List<DetalleDTO> result = new ArrayList<>();
	
		for(Detalle object2 : detalleRepository.findAll()){
			DetalleDTO object = new DetalleDTO();
			object.setId(object2.getId());
			object.setCantidad(object2.getCantidad());
			
			try {
				PlatoDTO plato = new PlatoDTO();
				plato.setId(object2.getPlato().getId());
				plato.setNombre(object2.getPlato().getNombre());
				plato.setTiempoPreparacion(object2.getPlato().getTiempoPreparacion());
				object.setPlato(plato);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
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
	 * This method transform an entity 'Detalle' in 'DetalleDTO' in the database
	 * @return entity 'Detalle' transformed in 'DetalleDTO' (Data transference Object)
	 * @since 1.0
	 */
	public DetalleDTO getOne(int id) {
	
		Optional<Detalle> aOptional = detalleRepository.findById(id);
		DetalleDTO object = new DetalleDTO();
	
		try {	
	
			Detalle object2 = aOptional.get();
			object.setId(object2.getId());
			object.setCantidad(object2.getCantidad());
			
			try {
				PlatoDTO plato = new PlatoDTO();
				plato.setId(object2.getPlato().getId());
				plato.setNombre(object2.getPlato().getNombre());
				plato.setTiempoPreparacion(object2.getPlato().getTiempoPreparacion());
				object.setPlato(plato);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
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
	 * This method transform an entity 'DetalleDTO' in the entity 'Detalle' for save it in the database
	 * @param detalleDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'DetalleDTO'.
	 * @since 1.0
	 */
	public DetalleDTO save(DetalleDTO detalleDTO) {
		
		Detalle detalle = new Detalle();
		
		detalle.setCantidad(detalleDTO.getCantidad());
		
		try {
			Plato plato = new Plato();
			plato.setId(detalleDTO.getPlato().getId());
			detalle.setPlato(plato);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Articulo articulo = new Articulo();
			articulo.setId(detalleDTO.getArticulo().getId());
			detalle.setArticulo(articulo);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		detalleRepository.save(detalle);
		
		detalleDTO.setId(detalle.getId());
		return detalleDTO;
		
	}
	/**
	 * This method transform an entity 'DetalleDTO' in the entity 'Detalle' for update it in the database
	 * @param detalleDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'DetalleDTO'.
	 * @since 1.0
	 */
	public DetalleDTO update(DetalleDTO detalleDTO, int id) {
		
		Optional<Detalle> optional = detalleRepository.findById(id);
		Detalle detalle = new Detalle();
		
		try {
		
		detalle = optional.get();
	
		detalle.setCantidad(detalleDTO.getCantidad());
		
		try {
			Plato plato = new Plato();
			plato.setId(detalleDTO.getPlato().getId());
			detalle.setPlato(plato);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Articulo articulo = new Articulo();
			articulo.setId(detalleDTO.getArticulo().getId());
			detalle.setArticulo(articulo);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		detalleRepository.save(detalle);
		
		detalleDTO.setId(detalle.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			detalleDTO.setId(0);
	
		}
	
		return detalleDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Detalle' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			detalleRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

