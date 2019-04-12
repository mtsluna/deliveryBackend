package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.FacturaRepository;


@Service
public class FacturaService {
	
	private FacturaRepository facturaRepository;

	public FacturaService(FacturaRepository facturaRepository){
		this.facturaRepository = facturaRepository;
	}

	/**
	 * This method transform all entities 'Factura' in 'FacturaDTO' in the database
	 * @return entities 'Factura' transformed in 'Factura'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<FacturaDTO> getAll() {
	
		List<FacturaDTO> result = new ArrayList<>();
	
		for(Factura object2 : facturaRepository.findAll()){
			FacturaDTO object = new FacturaDTO();
			object.setId(object2.getId());
			object.setTipoFactura(object2.getTipoFactura());
			object.setFecha(object2.getFecha());
			object.setMontoDescuento(object2.getMontoDescuento());
			object.setTotal(object2.getTotal());
			
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
	 * This method transform an entity 'Factura' in 'FacturaDTO' in the database
	 * @return entity 'Factura' transformed in 'FacturaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public FacturaDTO getOne(int id) {
	
		Optional<Factura> aOptional = facturaRepository.findById(id);
		FacturaDTO object = new FacturaDTO();
	
		try {	
	
			Factura object2 = aOptional.get();
			object.setId(object2.getId());
			object.setTipoFactura(object2.getTipoFactura());
			object.setFecha(object2.getFecha());
			object.setMontoDescuento(object2.getMontoDescuento());
			object.setTotal(object2.getTotal());
			
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
	 * This method transform an entity 'FacturaDTO' in the entity 'Factura' for save it in the database
	 * @param facturaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'FacturaDTO'.
	 * @since 1.0
	 */
	public FacturaDTO save(FacturaDTO facturaDTO) {
		
		Factura factura = new Factura();
		
		factura.setTipoFactura(facturaDTO.getTipoFactura());
		factura.setFecha(facturaDTO.getFecha());
		factura.setMontoDescuento(facturaDTO.getMontoDescuento());
		factura.setTotal(facturaDTO.getTotal());
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : facturaDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());	detalle.add(detalleTemp);
		}
		factura.setDetalle(detalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : facturaDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());
			detalle.add(detalleTemp);
		}
		factura.setDetalle(detalle);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		facturaRepository.save(factura);
		
		facturaDTO.setId(factura.getId());
		return facturaDTO;
		
	}
	/**
	 * This method transform an entity 'FacturaDTO' in the entity 'Factura' for update it in the database
	 * @param facturaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'FacturaDTO'.
	 * @since 1.0
	 */
	public FacturaDTO update(FacturaDTO facturaDTO, int id) {
		
		Optional<Factura> optional = facturaRepository.findById(id);
		Factura factura = new Factura();
		
		try {
		
		factura = optional.get();
	
		factura.setTipoFactura(facturaDTO.getTipoFactura());
		factura.setFecha(facturaDTO.getFecha());
		factura.setMontoDescuento(facturaDTO.getMontoDescuento());
		factura.setTotal(facturaDTO.getTotal());
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : facturaDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());	detalle.add(detalleTemp);
		}
		factura.setDetalle(detalle);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Detalle> detalle = new ArrayList<>();
			for(DetalleDTO detalleDTO : facturaDTO.getDetalle()){
				Detalle detalleTemp = new Detalle();
				detalleTemp.setId(detalleDTO.getId());
			detalle.add(detalleTemp);
		}
		factura.setDetalle(detalle);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		facturaRepository.save(factura);
		
		facturaDTO.setId(factura.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			facturaDTO.setId(0);
	
		}
	
		return facturaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Factura' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			facturaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

