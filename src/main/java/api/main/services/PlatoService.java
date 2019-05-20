package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PlatoRepository;


@Service
public class PlatoService {
	
	private PlatoRepository platoRepository;

	public PlatoService(PlatoRepository platoRepository){
		this.platoRepository = platoRepository;
	}

	/**
	 * This method transform all entities 'Plato' in 'PlatoDTO' in the database
	 * @return entities 'Plato' transformed in 'Plato'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PlatoDTO> getAll() {
	
		List<PlatoDTO> result = new ArrayList<>();
	
		for(Plato object2 : platoRepository.findAll()){
			PlatoDTO object = new PlatoDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setTiempoPreparacion(object2.getTiempoPreparacion());
			try {
				object.setPrecio(object2.getPrecio());
			} catch(Exception e) {
				System.out.println("vacio");
			}
			
			
			try {
				List<PlatoDetalleDTO> platoDetalle = new ArrayList<>();
				for(PlatoDetalle platoDetalleInternal : object2.getDetalles()){
					PlatoDetalleDTO platoDetalleDTO = new PlatoDetalleDTO();
					platoDetalleDTO.setId(platoDetalleInternal.getId());	
					platoDetalleDTO.setCantidad(platoDetalleInternal.getCantidad());
					
					ArticuloDTO articulo = new ArticuloDTO();
					articulo.setDescripcion(platoDetalleInternal.getArticulo().getDescripcion());
					articulo.setEsInsumo(platoDetalleInternal.getArticulo().getEsInsumo());
					articulo.setId(platoDetalleInternal.getArticulo().getId());
					articulo.setStock(platoDetalleInternal.getArticulo().getStock());
					articulo.setStockMaximo(platoDetalleInternal.getArticulo().getStockMaximo());
					articulo.setStockMinimo(platoDetalleInternal.getArticulo().getStockMinimo());
					articulo.setNombre(platoDetalleInternal.getArticulo().getNombre());
					articulo.setPrecioCompra(platoDetalleInternal.getArticulo().getPrecioCompra());
					articulo.setPrecioVenta(platoDetalleInternal.getArticulo().getPrecioVenta());	
					
					ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO(); 
					articuloCategoria.setId(platoDetalleInternal.getArticulo().getCategoria().getId());
					articuloCategoria.setNombre(platoDetalleInternal.getArticulo().getCategoria().getNombre());
					articuloCategoria.setDescripcion(platoDetalleInternal.getArticulo().getCategoria().getDescripcion());
					articulo.setCategoria(articuloCategoria);
					
					UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
					unidadMedida.setId(platoDetalleInternal.getArticulo().getUnidadMedida().getId());
					unidadMedida.setNombre(platoDetalleInternal.getArticulo().getUnidadMedida().getNombre());
					unidadMedida.setAbreviatura(platoDetalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
					articulo.setUnidadMedida(unidadMedida);
					
					platoDetalleDTO.setArticulo(articulo);
					
					platoDetalle.add(platoDetalleDTO);
			}
			object.setDetalles(platoDetalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				PlatoCategoriaDTO platoCategoria = new PlatoCategoriaDTO();
				platoCategoria.setId(object2.getCategoria().getId());
				platoCategoria.setNombre(object2.getCategoria().getNombre());
				platoCategoria.setPorcentajeGanancia(object2.getCategoria().getPorcentajeGanancia());
				object.setCategoria(platoCategoria);
			
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
	 * This method transform an entity 'Plato' in 'PlatoDTO' in the database
	 * @return entity 'Plato' transformed in 'PlatoDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PlatoDTO getOne(int id) {
	
		Optional<Plato> aOptional = platoRepository.findById(id);
		PlatoDTO object = new PlatoDTO();
	
		try {	
	
			Plato object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			object.setTiempoPreparacion(object2.getTiempoPreparacion());
			try {
				object.setPrecio(object2.getPrecio());
			} catch(Exception e) {
				System.out.println("vacio");
			}
			
			try {
				List<PlatoDetalleDTO> platoDetalle = new ArrayList<>();
				for(PlatoDetalle platoDetalleInternal : object2.getDetalles()){
					PlatoDetalleDTO platoDetalleDTO = new PlatoDetalleDTO();
					platoDetalleDTO.setId(platoDetalleInternal.getId());	
					platoDetalleDTO.setCantidad(platoDetalleInternal.getCantidad());
					
					ArticuloDTO articulo = new ArticuloDTO();
					articulo.setDescripcion(platoDetalleInternal.getArticulo().getDescripcion());
					articulo.setEsInsumo(platoDetalleInternal.getArticulo().getEsInsumo());
					articulo.setId(platoDetalleInternal.getArticulo().getId());
					articulo.setStock(platoDetalleInternal.getArticulo().getStock());
					articulo.setStockMaximo(platoDetalleInternal.getArticulo().getStockMaximo());
					articulo.setStockMinimo(platoDetalleInternal.getArticulo().getStockMinimo());
					articulo.setNombre(platoDetalleInternal.getArticulo().getNombre());
					articulo.setPrecioCompra(platoDetalleInternal.getArticulo().getPrecioCompra());
					articulo.setPrecioVenta(platoDetalleInternal.getArticulo().getPrecioVenta());	
					
					ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO(); 
					articuloCategoria.setId(platoDetalleInternal.getArticulo().getCategoria().getId());
					articuloCategoria.setNombre(platoDetalleInternal.getArticulo().getCategoria().getNombre());
					articuloCategoria.setDescripcion(platoDetalleInternal.getArticulo().getCategoria().getDescripcion());
					articulo.setCategoria(articuloCategoria);
					
					UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
					unidadMedida.setId(platoDetalleInternal.getArticulo().getUnidadMedida().getId());
					unidadMedida.setNombre(platoDetalleInternal.getArticulo().getUnidadMedida().getNombre());
					unidadMedida.setAbreviatura(platoDetalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
					articulo.setUnidadMedida(unidadMedida);
					
					platoDetalleDTO.setArticulo(articulo);
					
					platoDetalle.add(platoDetalleDTO);
			}
			object.setDetalles(platoDetalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				PlatoCategoriaDTO platoCategoria = new PlatoCategoriaDTO();
				platoCategoria.setId(object2.getCategoria().getId());
				platoCategoria.setNombre(object2.getCategoria().getNombre());
				platoCategoria.setPorcentajeGanancia(object2.getCategoria().getPorcentajeGanancia());
				object.setCategoria(platoCategoria);
			
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
	 * This method transform an entity 'PlatoDTO' in the entity 'Plato' for save it in the database
	 * @param platoDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PlatoDTO'.
	 * @since 1.0
	 */
	public PlatoDTO save(PlatoDTO platoDTO) {
		
		Plato plato = new Plato();
		
		plato.setNombre(platoDTO.getNombre());
		plato.setTiempoPreparacion(platoDTO.getTiempoPreparacion());
		plato.setPrecio(platoDTO.getPrecio());
		
		try {
			List<PlatoDetalle> platoDetalle = new ArrayList<>();
			for(PlatoDetalleDTO platoDetalleDTO : platoDTO.getDetalles()){
				PlatoDetalle platoDetalleTemp = new PlatoDetalle();
				platoDetalleTemp.setCantidad(platoDetalleDTO.getCantidad());
				
				Articulo articulo = new Articulo();
				articulo.setId(platoDetalleDTO.getArticulo().getId());
				platoDetalleTemp.setArticulo(articulo);
				
				platoDetalle.add(platoDetalleTemp);
		}
		plato.setDetalles(platoDetalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			PlatoCategoria platoCategoria = new PlatoCategoria();
			platoCategoria.setId(platoDTO.getCategoria().getId());
			plato.setCategoria(platoCategoria);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setUrl(platoDTO.getImagen().getUrl());
			plato.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		platoRepository.save(plato);
		
		platoDTO.setId(plato.getId());
		return platoDTO;
		
	}
	/**
	 * This method transform an entity 'PlatoDTO' in the entity 'Plato' for update it in the database
	 * @param platoDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PlatoDTO'.
	 * @since 1.0
	 */
	public PlatoDTO update(PlatoDTO platoDTO, int id) {
		
		Optional<Plato> optional = platoRepository.findById(id);
		Plato plato = new Plato();
		
		try {
		
		plato = optional.get();
	
		plato.setNombre(platoDTO.getNombre());
		plato.setTiempoPreparacion(platoDTO.getTiempoPreparacion());
		plato.setPrecio(platoDTO.getPrecio());
		
		try {
			List<PlatoDetalle> platoDetalle = new ArrayList<>();
			for(PlatoDetalleDTO platoDetalleDTO : platoDTO.getDetalles()){
				PlatoDetalle platoDetalleTemp = new PlatoDetalle();
				platoDetalleTemp.setId(platoDetalleDTO.getId());
				platoDetalleTemp.setCantidad(platoDetalleDTO.getCantidad());
				
				Articulo articulo = new Articulo();
				articulo.setId(platoDetalleDTO.getArticulo().getId());
				platoDetalleTemp.setArticulo(articulo);
				
				platoDetalle.add(platoDetalleTemp);
		}
		plato.setDetalles(platoDetalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			PlatoCategoria platoCategoria = new PlatoCategoria();
			platoCategoria.setId(platoDTO.getCategoria().getId());
			plato.setCategoria(platoCategoria);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setUrl(platoDTO.getImagen().getUrl());
			plato.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		platoRepository.save(plato);
		
		platoDTO.setId(plato.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			platoDTO.setId(0);
	
		}
	
		return platoDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Plato' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			platoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

