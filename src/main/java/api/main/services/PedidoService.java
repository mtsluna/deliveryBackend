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
					detalleDTO.setId(detalleInternal.getId());	detalleDTO.setCantidad(detalleInternal.getCantidad());
						detalle.add(detalleDTO);
			}
			object.setDetalle(detalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				EstadoDTO estado = new EstadoDTO();
				estado.setId(object2.getEstado().getId());
				object.setEstado(estado);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<DetalleDTO> detalle = new ArrayList<>();
				for(Detalle detalleInternal : object2.getDetalle()){
					DetalleDTO detalleDTO = new DetalleDTO();
					detalleDTO.setId(detalleInternal.getId());
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
					detalleDTO.setId(detalleInternal.getId());	detalleDTO.setCantidad(detalleInternal.getCantidad());
						detalle.add(detalleDTO);
			}
			object.setDetalle(detalle);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				EstadoDTO estado = new EstadoDTO();
				estado.setId(object2.getEstado().getId());
				object.setEstado(estado);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<DetalleDTO> detalle = new ArrayList<>();
				for(Detalle detalleInternal : object2.getDetalle()){
					DetalleDTO detalleDTO = new DetalleDTO();
					detalleDTO.setId(detalleInternal.getId());
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
				detalleTemp.setId(detalleDTO.getId());
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

