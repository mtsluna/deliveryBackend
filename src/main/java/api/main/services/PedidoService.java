package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PedidoRepository;


@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository){
		this.pedidoRepository = pedidoRepository;
	}

	/**
	 * This method transform all entities 'Pedido' in 'PedidoDTO' in the database
	 * @return entities 'Pedido' transformed in 'Pedido'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PedidoDTO> getAll() {
	
		List<PedidoDTO> result = new ArrayList<>();
	
		for(Pedido object2 : pedidoRepository.findAll()){
			PedidoDTO object = new PedidoDTO();
			object.setId(object2.getId());
			object.setHoraEstimadaFin(object2.getHoraEstimadaFin());
			object.setTipoEnvio(object2.getTipoEnvio());
			object.setFecha(object2.getFecha());
			object.setMontoDescuento(object2.getMontoDescuento());
			object.setTotal(object2.getTotal());
			
			try {
				
				UsuarioClienteDTO user = new UsuarioClienteDTO();
				user.setId(object2.getUsuariocliente().getId());
				object.setUsuarioCliente(user);
				
			} catch (Exception e) {

				System.out.println(e.getMessage());
				
			}
			
			try {
				EstadoDTO estado = new EstadoDTO();
				estado.setId(object2.getEstado().getId());
				estado.setNombre(object2.getEstado().getNombre());
				object.setEstado(estado);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<DetalleDTO> detalle = new ArrayList<>();
				for(Detalle detalleInternal : object2.getDetalle()){
					DetalleDTO detalleDTO = new DetalleDTO();
					detalleDTO.setId(detalleInternal.getId());	
					detalleDTO.setCantidad(detalleInternal.getCantidad());			
					
					if(detalleInternal.getArticulo() != null) {
					
						ArticuloDTO articulo = new ArticuloDTO();
						articulo.setDescripcion(detalleInternal.getArticulo().getDescripcion());
						articulo.setEsInsumo(detalleInternal.getArticulo().getEsInsumo());
						articulo.setId(detalleInternal.getArticulo().getId());
						articulo.setStock(detalleInternal.getArticulo().getStock());
						articulo.setStockMaximo(detalleInternal.getArticulo().getStockMaximo());
						articulo.setStockMinimo(detalleInternal.getArticulo().getStockMinimo());
						articulo.setNombre(detalleInternal.getArticulo().getNombre());
						articulo.setPrecioCompra(detalleInternal.getArticulo().getPrecioCompra());
						articulo.setPrecioVenta(detalleInternal.getArticulo().getPrecioVenta());					
						UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
						unidadMedida.setId(detalleInternal.getArticulo().getUnidadMedida().getId());
						unidadMedida.setNombre(detalleInternal.getArticulo().getUnidadMedida().getNombre());
						unidadMedida.setAbreviatura(detalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
						articulo.setUnidadMedida(unidadMedida);					
						detalleDTO.setArticulo(articulo);
					
					}					
					
					if(detalleInternal.getPlato() != null) {
					
						PlatoDTO plato = new PlatoDTO();
						plato.setId(detalleInternal.getPlato().getId());
						plato.setNombre(detalleInternal.getPlato().getNombre());
						plato.setTiempoPreparacion(detalleInternal.getPlato().getTiempoPreparacion());
						
						List<PlatoDetalleDTO> detallesPlato = new ArrayList<>();
						for(PlatoDetalle platoDetalleInternal : detalleInternal.getPlato().getDetalles()) {							
							PlatoDetalleDTO temp = new PlatoDetalleDTO();
							temp.setId(platoDetalleInternal.getId());
							temp.setCantidad(platoDetalleInternal.getCantidad());							
							ArticuloDTO articuloDetalle = new ArticuloDTO();
							articuloDetalle.setDescripcion(platoDetalleInternal.getArticulo().getDescripcion());
							articuloDetalle.setEsInsumo(platoDetalleInternal.getArticulo().getEsInsumo());
							articuloDetalle.setId(platoDetalleInternal.getArticulo().getId());
							articuloDetalle.setStock(platoDetalleInternal.getArticulo().getStock());
							articuloDetalle.setStockMaximo(platoDetalleInternal.getArticulo().getStockMaximo());
							articuloDetalle.setStockMinimo(platoDetalleInternal.getArticulo().getStockMinimo());
							articuloDetalle.setNombre(platoDetalleInternal.getArticulo().getNombre());
							articuloDetalle.setPrecioCompra(platoDetalleInternal.getArticulo().getPrecioCompra());
							articuloDetalle.setPrecioVenta(platoDetalleInternal.getArticulo().getPrecioVenta());							
							ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO(); 
							articuloCategoria.setId(platoDetalleInternal.getArticulo().getCategoria().getId());
							articuloCategoria.setNombre(platoDetalleInternal.getArticulo().getCategoria().getNombre());
							articuloCategoria.setDescripcion(platoDetalleInternal.getArticulo().getCategoria().getDescripcion());
							articuloDetalle.setCategoria(articuloCategoria);							
							UnidadMedidaDTO unidadMedidaDetalle = new UnidadMedidaDTO();
							unidadMedidaDetalle.setId(platoDetalleInternal.getArticulo().getUnidadMedida().getId());
							unidadMedidaDetalle.setNombre(platoDetalleInternal.getArticulo().getUnidadMedida().getNombre());
							unidadMedidaDetalle.setAbreviatura(platoDetalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
							articuloDetalle.setUnidadMedida(unidadMedidaDetalle);
							
							temp.setArticulo(articuloDetalle);
							
							detallesPlato.add(temp);
						}
						
						plato.setDetalles(detallesPlato);	
						
						detalleDTO.setPlato(plato);
					
					}
					
					detalle.add(detalleDTO);
			}
			object.setDetalle(detalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}	
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Pedido' in 'PedidoDTO' in the database
	 * @return entity 'Pedido' transformed in 'PedidoDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PedidoDTO getOne(int id) {
	
		Optional<Pedido> aOptional = pedidoRepository.findById(id);
		PedidoDTO object = new PedidoDTO();
	
		try {	
	
			Pedido object2 = aOptional.get();
			object.setId(object2.getId());
			object.setHoraEstimadaFin(object2.getHoraEstimadaFin());
			object.setTipoEnvio(object2.getTipoEnvio());
			object.setFecha(object2.getFecha());
			object.setMontoDescuento(object2.getMontoDescuento());
			object.setTotal(object2.getTotal());
			
			try {
				
				UsuarioClienteDTO user = new UsuarioClienteDTO();
				user.setId(object2.getUsuariocliente().getId());
				object.setUsuarioCliente(user);
				
			} catch (Exception e) {

				System.out.println(e.getMessage());
				
			}
			
			try {
				EstadoDTO estado = new EstadoDTO();
				estado.setId(object2.getEstado().getId());
				estado.setNombre(object2.getEstado().getNombre());
				object.setEstado(estado);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<DetalleDTO> detalle = new ArrayList<>();
				for(Detalle detalleInternal : object2.getDetalle()){
					DetalleDTO detalleDTO = new DetalleDTO();
					detalleDTO.setId(detalleInternal.getId());	
					detalleDTO.setCantidad(detalleInternal.getCantidad());			
					
					if(detalleInternal.getArticulo() != null) {
					
						ArticuloDTO articulo = new ArticuloDTO();
						articulo.setDescripcion(detalleInternal.getArticulo().getDescripcion());
						articulo.setEsInsumo(detalleInternal.getArticulo().getEsInsumo());
						articulo.setId(detalleInternal.getArticulo().getId());
						articulo.setStock(detalleInternal.getArticulo().getStock());
						articulo.setStockMaximo(detalleInternal.getArticulo().getStockMaximo());
						articulo.setStockMinimo(detalleInternal.getArticulo().getStockMinimo());
						articulo.setNombre(detalleInternal.getArticulo().getNombre());
						articulo.setPrecioCompra(detalleInternal.getArticulo().getPrecioCompra());
						articulo.setPrecioVenta(detalleInternal.getArticulo().getPrecioVenta());					
						UnidadMedidaDTO unidadMedida = new UnidadMedidaDTO();
						unidadMedida.setId(detalleInternal.getArticulo().getUnidadMedida().getId());
						unidadMedida.setNombre(detalleInternal.getArticulo().getUnidadMedida().getNombre());
						unidadMedida.setAbreviatura(detalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
						articulo.setUnidadMedida(unidadMedida);					
						detalleDTO.setArticulo(articulo);
					
					}					
					
					if(detalleInternal.getPlato() != null) {
					
						PlatoDTO plato = new PlatoDTO();
						plato.setId(detalleInternal.getPlato().getId());
						plato.setNombre(detalleInternal.getPlato().getNombre());
						plato.setTiempoPreparacion(detalleInternal.getPlato().getTiempoPreparacion());
						
						List<PlatoDetalleDTO> detallesPlato = new ArrayList<>();
						for(PlatoDetalle platoDetalleInternal : detalleInternal.getPlato().getDetalles()) {							
							PlatoDetalleDTO temp = new PlatoDetalleDTO();
							temp.setId(platoDetalleInternal.getId());
							temp.setCantidad(platoDetalleInternal.getCantidad());							
							ArticuloDTO articuloDetalle = new ArticuloDTO();
							articuloDetalle.setDescripcion(platoDetalleInternal.getArticulo().getDescripcion());
							articuloDetalle.setEsInsumo(platoDetalleInternal.getArticulo().getEsInsumo());
							articuloDetalle.setId(platoDetalleInternal.getArticulo().getId());
							articuloDetalle.setStock(platoDetalleInternal.getArticulo().getStock());
							articuloDetalle.setStockMaximo(platoDetalleInternal.getArticulo().getStockMaximo());
							articuloDetalle.setStockMinimo(platoDetalleInternal.getArticulo().getStockMinimo());
							articuloDetalle.setNombre(platoDetalleInternal.getArticulo().getNombre());
							articuloDetalle.setPrecioCompra(platoDetalleInternal.getArticulo().getPrecioCompra());
							articuloDetalle.setPrecioVenta(platoDetalleInternal.getArticulo().getPrecioVenta());							
							ArticuloCategoriaDTO articuloCategoria = new ArticuloCategoriaDTO(); 
							articuloCategoria.setId(platoDetalleInternal.getArticulo().getCategoria().getId());
							articuloCategoria.setNombre(platoDetalleInternal.getArticulo().getCategoria().getNombre());
							articuloCategoria.setDescripcion(platoDetalleInternal.getArticulo().getCategoria().getDescripcion());
							articuloDetalle.setCategoria(articuloCategoria);							
							UnidadMedidaDTO unidadMedidaDetalle = new UnidadMedidaDTO();
							unidadMedidaDetalle.setId(platoDetalleInternal.getArticulo().getUnidadMedida().getId());
							unidadMedidaDetalle.setNombre(platoDetalleInternal.getArticulo().getUnidadMedida().getNombre());
							unidadMedidaDetalle.setAbreviatura(platoDetalleInternal.getArticulo().getUnidadMedida().getAbreviatura());
							articuloDetalle.setUnidadMedida(unidadMedidaDetalle);
							
							temp.setArticulo(articuloDetalle);
							
							detallesPlato.add(temp);
						}
						
						plato.setDetalles(detallesPlato);	
						
						detalleDTO.setPlato(plato);
					
					}
					
					detalle.add(detalleDTO);
			}
			object.setDetalle(detalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'PedidoDTO' in the entity 'Pedido' for save it in the database
	 * @param pedidoDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PedidoDTO'.
	 * @since 1.0
	 */
	public PedidoDTO save(PedidoDTO pedidoDTO) {
		
		Pedido pedido = new Pedido();
		
		pedido.setHoraEstimadaFin(pedidoDTO.getHoraEstimadaFin());
		pedido.setTipoEnvio(pedidoDTO.getTipoEnvio());
		pedido.setFecha(pedidoDTO.getFecha());
		pedido.setMontoDescuento(pedidoDTO.getMontoDescuento());
		pedido.setTotal(pedidoDTO.getTotal());
		
		try {
			
			UsuarioCliente usuario = new UsuarioCliente();
			usuario.setId(pedidoDTO.getUsuarioCliente().getId());
			pedido.setUsuariocliente(usuario);
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			
		}
		
		try {
			Estado estado = new Estado();
			estado.setId(pedidoDTO.getEstado().getId());
			pedido.setEstado(estado);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		List<Detalle> detalle = new ArrayList<>();
		
		try {			
			for(DetalleDTO detalleDTO : pedidoDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setCantidad(detalleDTO.getCantidad());
				
				try{
					if(detalleDTO.getArticulo() != null) {
						Articulo articulo = new Articulo();
						articulo.setId(detalleDTO.getArticulo().getId());
						detalleTemp.setArticulo(articulo);
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				try {
					if(detalleDTO.getPlato() != null) {
						Plato plato = new Plato();
						plato.setId(detalleDTO.getPlato().getId());
						detalleTemp.setPlato(plato);
					}	
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				detalle.add(detalleTemp);
			}
			
		pedido.setDetalle(detalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		pedidoRepository.save(pedido);
		
		pedidoDTO.setId(pedido.getId());
		return pedidoDTO;
		
	}
	/**
	 * This method transform an entity 'PedidoDTO' in the entity 'Pedido' for update it in the database
	 * @param pedidoDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PedidoDTO'.
	 * @since 1.0
	 */
	public PedidoDTO update(PedidoDTO pedidoDTO, int id) {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		Pedido pedido = new Pedido();
		
		try {
		
		pedido = optional.get();
	
		pedido.setHoraEstimadaFin(pedidoDTO.getHoraEstimadaFin());
		pedido.setTipoEnvio(pedidoDTO.getTipoEnvio());
		pedido.setFecha(pedidoDTO.getFecha());
		pedido.setMontoDescuento(pedidoDTO.getMontoDescuento());
		pedido.setTotal(pedidoDTO.getTotal());
		
		try {
			
			UsuarioCliente usuario = new UsuarioCliente();
			usuario.setId(pedidoDTO.getUsuarioCliente().getId());
			pedido.setUsuariocliente(usuario);
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			
		}
		
		try {
			Estado estado = new Estado();
			estado.setId(pedidoDTO.getEstado().getId());
			pedido.setEstado(estado);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : pedidoDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());	detalle.add(detalleTemp);
		}
		pedido.setDetalle(detalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : pedidoDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());
			detalle.add(detalleTemp);
		}
		pedido.setDetalle(detalle);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		pedidoRepository.save(pedido);
		
		pedidoDTO.setId(pedido.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			pedidoDTO.setId(0);
	
		}
	
		return pedidoDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Pedido' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			pedidoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

