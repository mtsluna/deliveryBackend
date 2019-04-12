package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.ArticuloRepository;


@Service
public class ArticuloService {
	
	private ArticuloRepository articuloRepository;

	public ArticuloService(ArticuloRepository articuloRepository){
		this.articuloRepository = articuloRepository;
	}

	/**
	 * This method transform all entities 'Articulo' in 'ArticuloDTO' in the database
	 * @return entities 'Articulo' transformed in 'Articulo'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<ArticuloDTO> getAll() {
	
		List<ArticuloDTO> result = new ArrayList<>();
	
		for(Articulo object2 : articuloRepository.findAll()){
			ArticuloDTO object = new ArticuloDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setDescripcion(object2.getDescripcion());
			object.setPrecioCompra(object2.getPrecioCompra());
			object.setStock(object2.getStock());
			object.setStockMinimo(object2.getStockMinimo());
			object.setStockMaximo(object2.getStockMaximo());
			object.setEsInsumo(object2.getEsInsumo());
			object.setPrecioVenta(object2.getPrecioVenta());
			
			try {
				ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO();
				articuloCategoria.setId(object2.getCategoria().getId());
				articuloCategoria.setNombre(object2.getCategoria().getNombre());
				articuloCategoria.setDescripcion(object2.getCategoria().getDescripcion());
				object.setCategoria(articuloCategoria);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
				unidadMedida.setId(object2.getUnidadMedida().getId());
				unidadMedida.setNombre(object2.getUnidadMedida().getNombre());
				unidadMedida.setAbreviatura(object2.getUnidadMedida().getAbreviatura());
				object.setUnidadMedida(unidadMedida);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
				imagen.setUrl(object2.getImagen().getUrl());
				object.setImagen(imagen);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Articulo' in 'ArticuloDTO' in the database
	 * @return entity 'Articulo' transformed in 'ArticuloDTO' (Data transference Object)
	 * @since 1.0
	 */
	public ArticuloDTO getOne(int id) {
	
		Optional<Articulo> aOptional = articuloRepository.findById(id);
		ArticuloDTO object = new ArticuloDTO();
	
		try {	
	
			Articulo object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setDescripcion(object2.getDescripcion());
			object.setPrecioCompra(object2.getPrecioCompra());
			object.setStock(object2.getStock());
			object.setStockMinimo(object2.getStockMinimo());
			object.setStockMaximo(object2.getStockMaximo());
			object.setEsInsumo(object2.getEsInsumo());
			object.setPrecioVenta(object2.getPrecioVenta());
			
			try {
				ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO();
				articuloCategoria.setId(object2.getCategoria().getId());
				articuloCategoria.setNombre(object2.getCategoria().getNombre());
				articuloCategoria.setDescripcion(object2.getCategoria().getDescripcion());
				object.setCategoria(articuloCategoria);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
				unidadMedida.setId(object2.getUnidadMedida().getId());
				unidadMedida.setNombre(object2.getUnidadMedida().getNombre());
				unidadMedida.setAbreviatura(object2.getUnidadMedida().getAbreviatura());
				object.setUnidadMedida(unidadMedida);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
				imagen.setUrl(object2.getImagen().getUrl());
				object.setImagen(imagen);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'ArticuloDTO' in the entity 'Articulo' for save it in the database
	 * @param articuloDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'ArticuloDTO'.
	 * @since 1.0
	 */
	public ArticuloDTO save(ArticuloDTO articuloDTO) {
		
		Articulo articulo = new Articulo();
		
		articulo.setNombre(articuloDTO.getNombre());
		articulo.setDescripcion(articuloDTO.getDescripcion());
		articulo.setPrecioCompra(articuloDTO.getPrecioCompra());
		articulo.setStock(articuloDTO.getStock());
		articulo.setStockMinimo(articuloDTO.getStockMinimo());
		articulo.setStockMaximo(articuloDTO.getStockMaximo());
		articulo.setEsInsumo(articuloDTO.getEsInsumo());
		articulo.setPrecioVenta(articuloDTO.getPrecioVenta());
		
		try {
			ArticuloCategoria articuloCategoria = new ArticuloCategoria();
			articuloCategoria.setId(articuloDTO.getCategoria().getId());
			articulo.setCategoria(articuloCategoria);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			UnidadMedida unidadMedida = new UnidadMedida();
			unidadMedida.setId(articuloDTO.getUnidadMedida().getId());
			articulo.setUnidadMedida(unidadMedida);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setId(articuloDTO.getImagen().getId());
			articulo.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		articuloRepository.save(articulo);
		
		articuloDTO.setId(articulo.getId());
		return articuloDTO;
		
	}
	/**
	 * This method transform an entity 'ArticuloDTO' in the entity 'Articulo' for update it in the database
	 * @param articuloDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ArticuloDTO'.
	 * @since 1.0
	 */
	public ArticuloDTO update(ArticuloDTO articuloDTO, int id) {
		
		Optional<Articulo> optional = articuloRepository.findById(id);
		Articulo articulo = new Articulo();
		
		try {
		
		articulo = optional.get();
	
		articulo.setNombre(articuloDTO.getNombre());
		articulo.setDescripcion(articuloDTO.getDescripcion());
		articulo.setPrecioCompra(articuloDTO.getPrecioCompra());
		articulo.setStock(articuloDTO.getStock());
		articulo.setStockMinimo(articuloDTO.getStockMinimo());
		articulo.setStockMaximo(articuloDTO.getStockMaximo());
		articulo.setEsInsumo(articuloDTO.getEsInsumo());
		articulo.setPrecioVenta(articuloDTO.getPrecioVenta());
		
		try {
			ArticuloCategoria articuloCategoria = new ArticuloCategoria();
			articuloCategoria.setId(articuloDTO.getCategoria().getId());
			articulo.setCategoria(articuloCategoria);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			UnidadMedida unidadMedida = new UnidadMedida();
			unidadMedida.setId(articuloDTO.getUnidadMedida().getId());
			articulo.setUnidadMedida(unidadMedida);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setId(articuloDTO.getImagen().getId());
			articulo.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		articuloRepository.save(articulo);
		
		articuloDTO.setId(articulo.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			articuloDTO.setId(0);
	
		}
	
		return articuloDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Articulo' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			articuloRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

