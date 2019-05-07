package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.UsuarioClienteRepository;


@Service
public class UsuarioClienteService {
	
	private UsuarioClienteRepository usuarioClienteRepository;

	public UsuarioClienteService(UsuarioClienteRepository usuarioClienteRepository){
		this.usuarioClienteRepository = usuarioClienteRepository;
	}

	/**
	 * This method transform all entities 'UsuarioCliente' in 'UsuarioClienteDTO' in the database
	 * @return entities 'UsuarioCliente' transformed in 'UsuarioCliente'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<UsuarioClienteDTO> getAll() {
	
		List<UsuarioClienteDTO> result = new ArrayList<>();
	
		for(UsuarioCliente object2 : usuarioClienteRepository.findAll()){
			UsuarioClienteDTO object = new UsuarioClienteDTO();
			object.setId(object2.getId());
			object.setFechaNacimiento(object2.getFechaNacimiento());
			object.setSexo(object2.getSexo());
			object.setEmail(object2.getEmail());
			object.setDni(object2.getDni());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setTelefono(object2.getTelefono());
			object.setPassword(object2.getPassword());
			
			/*
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());	comprobanteDTO.setFecha(comprobanteInternal.getFecha());
						comprobanteDTO.setMontoDescuento(comprobanteInternal.getMontoDescuento());
						comprobanteDTO.setTotal(comprobanteInternal.getTotal());
						comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			*/
			/*
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());
				comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			*/
			
			try {
				DomicilioDTO domicilio = new DomicilioDTO();		
				domicilio.setId(object2.getDomicilio().getId());
				domicilio.setCalle(object2.getDomicilio().getCalle());
				domicilio.setNumero(object2.getDomicilio().getNumero());
				domicilio.setPiso(object2.getDomicilio().getPiso());
				domicilio.setDepartamento(object2.getDomicilio().getDepartamento());
				domicilio.setLatitud(object2.getDomicilio().getLatitud());
				domicilio.setLongitud(object2.getDomicilio().getLongitud());
				domicilio.setCP(object2.getDomicilio().getCP());
				LocalidadDTO loc = new LocalidadDTO();
				loc.setId(object2.getDomicilio().getLocalidad().getId());
				domicilio.setLocalidad(loc);
				object.setDomicilio(domicilio);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
				object.setImagen(imagen);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'UsuarioCliente' in 'UsuarioClienteDTO' in the database
	 * @return entity 'UsuarioCliente' transformed in 'UsuarioClienteDTO' (Data transference Object)
	 * @since 1.0
	 */
	public UsuarioClienteDTO getOne(int id) {
	
		Optional<UsuarioCliente> aOptional = usuarioClienteRepository.findById(id);
		UsuarioClienteDTO object = new UsuarioClienteDTO();
	
		try {	
	
			UsuarioCliente object2 = aOptional.get();
			object.setId(object2.getId());
			object.setFechaNacimiento(object2.getFechaNacimiento());
			object.setSexo(object2.getSexo());
			object.setEmail(object2.getEmail());
			object.setDni(object2.getDni());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setTelefono(object2.getTelefono());
			object.setPassword(object2.getPassword());
			
			/*
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());	comprobanteDTO.setFecha(comprobanteInternal.getFecha());
						comprobanteDTO.setMontoDescuento(comprobanteInternal.getMontoDescuento());
						comprobanteDTO.setTotal(comprobanteInternal.getTotal());
						comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());
				comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			*/
			
			try {
				DomicilioDTO domicilio = new DomicilioDTO();		
				domicilio.setId(object2.getDomicilio().getId());
				domicilio.setCalle(object2.getDomicilio().getCalle());
				domicilio.setNumero(object2.getDomicilio().getNumero());
				domicilio.setPiso(object2.getDomicilio().getPiso());
				domicilio.setDepartamento(object2.getDomicilio().getDepartamento());
				domicilio.setLatitud(object2.getDomicilio().getLatitud());
				domicilio.setLongitud(object2.getDomicilio().getLongitud());
				domicilio.setCP(object2.getDomicilio().getCP());
				LocalidadDTO loc = new LocalidadDTO();
				loc.setId(object2.getDomicilio().getLocalidad().getId());
				ProvinciaDTO pro = new ProvinciaDTO();
				pro.setId(object2.getDomicilio().getLocalidad().getProvincia().getId());
				loc.setProvincia(pro);
				domicilio.setLocalidad(loc);
				object.setDomicilio(domicilio);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
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
	 * This method transform an entity 'UsuarioCliente' in 'UsuarioClienteDTO' in the database
	 * @return entity 'UsuarioCliente' transformed in 'UsuarioClienteDTO' (Data transference Object)
	 * @since 1.0
	 */
	public UsuarioClienteDTO searchByEmail(String email) {
	
		Optional<UsuarioCliente> aOptional = usuarioClienteRepository.searchByEmail(email);
		UsuarioClienteDTO object = new UsuarioClienteDTO();
	
		try {	
	
			UsuarioCliente object2 = aOptional.get();
			object.setId(object2.getId());
			object.setFechaNacimiento(object2.getFechaNacimiento());
			object.setSexo(object2.getSexo());
			object.setEmail(object2.getEmail());
			object.setDni(object2.getDni());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setTelefono(object2.getTelefono());
			object.setPassword(object2.getPassword());
			/*
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());	comprobanteDTO.setFecha(comprobanteInternal.getFecha());
						comprobanteDTO.setMontoDescuento(comprobanteInternal.getMontoDescuento());
						comprobanteDTO.setTotal(comprobanteInternal.getTotal());
						comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				List<ComprobanteDTO> comprobante = new ArrayList<>();
				for(Comprobante comprobanteInternal : object2.getComprobantes()){
					ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
					comprobanteDTO.setId(comprobanteInternal.getId());
				comprobante.add(comprobanteDTO);
			}
			object.setComprobantes(comprobante);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			*/
			try {
				DomicilioDTO domicilio = new DomicilioDTO();		
				domicilio.setId(object2.getDomicilio().getId());
				domicilio.setCalle(object2.getDomicilio().getCalle());
				domicilio.setNumero(object2.getDomicilio().getNumero());
				domicilio.setPiso(object2.getDomicilio().getPiso());
				domicilio.setDepartamento(object2.getDomicilio().getDepartamento());
				domicilio.setLatitud(object2.getDomicilio().getLatitud());
				domicilio.setLongitud(object2.getDomicilio().getLongitud());
				domicilio.setCP(object2.getDomicilio().getCP());
				LocalidadDTO loc = new LocalidadDTO();
				loc.setId(object2.getDomicilio().getLocalidad().getId());
				ProvinciaDTO pro = new ProvinciaDTO();
				pro.setId(object2.getDomicilio().getLocalidad().getProvincia().getId());
				loc.setProvincia(pro);
				domicilio.setLocalidad(loc);
				object.setDomicilio(domicilio);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
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
	 * This method transform an entity 'UsuarioClienteDTO' in the entity 'UsuarioCliente' for save it in the database
	 * @param usuarioClienteDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'UsuarioClienteDTO'.
	 * @since 1.0
	 */
	public UsuarioClienteDTO save(UsuarioClienteDTO usuarioClienteDTO) {
		
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		
		usuarioCliente.setFechaNacimiento(usuarioClienteDTO.getFechaNacimiento());
		usuarioCliente.setSexo(usuarioClienteDTO.getSexo());
		usuarioCliente.setEmail(usuarioClienteDTO.getEmail());
		usuarioCliente.setDni(usuarioClienteDTO.getDni());
		usuarioCliente.setNombre(usuarioClienteDTO.getNombre());
		usuarioCliente.setApellido(usuarioClienteDTO.getApellido());
		usuarioCliente.setTelefono(usuarioClienteDTO.getTelefono());
		usuarioCliente.setPassword(usuarioClienteDTO.getPassword());
		/*
		try {
			List<Comprobante> comprobante = new ArrayList<>();
			for(ComprobanteDTO comprobanteDTO : usuarioClienteDTO.getComprobantes()){
				Comprobante comprobanteTemp = new Comprobante();
				comprobanteTemp.setId(comprobanteDTO.getId());	comprobante.add(comprobanteTemp);
		}
		usuarioCliente.setComprobantes(comprobante);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Comprobante> comprobante = new ArrayList<>();
			for(ComprobanteDTO comprobanteDTO : usuarioClienteDTO.getComprobantes()){
				Comprobante comprobanteTemp = new Comprobante();
				comprobanteTemp.setId(comprobanteDTO.getId());
			comprobante.add(comprobanteTemp);
		}
		usuarioCliente.setComprobantes(comprobante);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
		try {
			Domicilio domicilio = new Domicilio();
			domicilio.setId(usuarioClienteDTO.getDomicilio().getId());
			domicilio.setCalle(usuarioClienteDTO.getDomicilio().getCalle());
			domicilio.setNumero(usuarioClienteDTO.getDomicilio().getNumero());
			domicilio.setPiso(usuarioClienteDTO.getDomicilio().getPiso());
			domicilio.setCP(usuarioClienteDTO.getDomicilio().getCP());
			domicilio.setDepartamento(usuarioClienteDTO.getDomicilio().getDepartamento());
			domicilio.setLatitud(usuarioClienteDTO.getDomicilio().getLatitud());
			domicilio.setLongitud(usuarioClienteDTO.getDomicilio().getLongitud());
			Localidad localidad = new Localidad();
			localidad.setId(usuarioClienteDTO.getDomicilio().getLocalidad().getId());
			domicilio.setLocalidad(localidad);
			usuarioCliente.setDomicilio(domicilio);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setId(usuarioClienteDTO.getImagen().getId());
			usuarioCliente.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		usuarioClienteRepository.save(usuarioCliente);
		
		usuarioClienteDTO.setId(usuarioCliente.getId());
		usuarioClienteDTO.getDomicilio().setId(usuarioCliente.getDomicilio().getId());	
		
		return usuarioClienteDTO;
		
	}
	/**
	 * This method transform an entity 'UsuarioClienteDTO' in the entity 'UsuarioCliente' for update it in the database
	 * @param usuarioClienteDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'UsuarioClienteDTO'.
	 * @since 1.0
	 */
	public UsuarioClienteDTO update(UsuarioClienteDTO usuarioClienteDTO, int id) {
		
		Optional<UsuarioCliente> optional = usuarioClienteRepository.findById(id);
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		
		try {
		
		usuarioCliente = optional.get();
	
		usuarioCliente.setFechaNacimiento(usuarioClienteDTO.getFechaNacimiento());
		usuarioCliente.setSexo(usuarioClienteDTO.getSexo());
		usuarioCliente.setEmail(usuarioClienteDTO.getEmail());
		usuarioCliente.setDni(usuarioClienteDTO.getDni());
		usuarioCliente.setNombre(usuarioClienteDTO.getNombre());
		usuarioCliente.setApellido(usuarioClienteDTO.getApellido());
		usuarioCliente.setTelefono(usuarioClienteDTO.getTelefono());
		usuarioCliente.setPassword(usuarioClienteDTO.getPassword());
		/*
		try {
			List<Comprobante> comprobante = new ArrayList<>();
			for(ComprobanteDTO comprobanteDTO : usuarioClienteDTO.getComprobantes()){
				Comprobante comprobanteTemp = new Comprobante();
				comprobanteTemp.setId(comprobanteDTO.getId());	comprobante.add(comprobanteTemp);
		}
		usuarioCliente.setComprobantes(comprobante);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			List<Comprobante> comprobante = new ArrayList<>();
			for(ComprobanteDTO comprobanteDTO : usuarioClienteDTO.getComprobantes()){
				Comprobante comprobanteTemp = new Comprobante();
				comprobanteTemp.setId(comprobanteDTO.getId());
			comprobante.add(comprobanteTemp);
		}
		usuarioCliente.setComprobantes(comprobante);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
		try {
			Domicilio domicilio = new Domicilio();
			domicilio.setId(usuarioClienteDTO.getDomicilio().getId());
			domicilio.setCalle(usuarioClienteDTO.getDomicilio().getCalle());
			domicilio.setNumero(usuarioClienteDTO.getDomicilio().getNumero());
			domicilio.setPiso(usuarioClienteDTO.getDomicilio().getPiso());
			domicilio.setCP(usuarioClienteDTO.getDomicilio().getCP());
			domicilio.setDepartamento(usuarioClienteDTO.getDomicilio().getDepartamento());
			domicilio.setLatitud(usuarioClienteDTO.getDomicilio().getLatitud());
			domicilio.setLongitud(usuarioClienteDTO.getDomicilio().getLongitud());
			Localidad localidad = new Localidad();
			localidad.setId(usuarioClienteDTO.getDomicilio().getLocalidad().getId());
			domicilio.setLocalidad(localidad);
			usuarioCliente.setDomicilio(domicilio);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen imagen = new Imagen();
			imagen.setId(usuarioClienteDTO.getImagen().getId());
			usuarioCliente.setImagen(imagen);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		usuarioClienteRepository.save(usuarioCliente);
		
		usuarioClienteDTO.getDomicilio().setId(usuarioCliente.getDomicilio().getId());		
		usuarioClienteDTO.setId(usuarioCliente.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			usuarioClienteDTO.setId(0);
	
		}
	
		return usuarioClienteDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'UsuarioCliente' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			usuarioClienteRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

