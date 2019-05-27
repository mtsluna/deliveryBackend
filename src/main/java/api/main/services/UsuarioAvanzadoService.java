package api.main.services;

import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.UsuarioAvanzadoRepository;

@Service
public class UsuarioAvanzadoService {

	private UsuarioAvanzadoRepository usuarioAvanzadoRepository;

	public UsuarioAvanzadoService(UsuarioAvanzadoRepository usuarioAvanzadoRepository) {
		this.usuarioAvanzadoRepository = usuarioAvanzadoRepository;
	}

	/**
	 * This method transform all entities 'UsuarioAvanzado' in 'UsuarioAvanzadoDTO'
	 * in the database
	 * 
	 * @return entities 'UsuarioAvanzado' transformed in 'UsuarioAvanzado'DTO (Data
	 *         transference Object)
	 * @since 1.0
	 */
	public List<UsuarioAvanzadoDTO> getAll() {

		List<UsuarioAvanzadoDTO> result = new ArrayList<>();

		for (UsuarioAvanzado object2 : usuarioAvanzadoRepository.findAll()) {
			UsuarioAvanzadoDTO object = new UsuarioAvanzadoDTO();
			object.setId(object2.getId());
			object.setEmail(object2.getEmail());
			object.setDni(object2.getDni());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setTelefono(object2.getTelefono());
			object.setPassword(object2.getPassword());
			object.setAlta(object2.getAlta());

			try {
				RolDTO rol = new RolDTO();
				rol.setId(object2.getRol().getId());
				rol.setNombre(object2.getRol().getNombre());
				object.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				RolDTO rol = new RolDTO();
				rol.setId(object2.getRol().getId());
				object.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				DomicilioDTO domicilio = new DomicilioDTO();
				domicilio.setId(object2.getDomicilio().getId());
				object.setDomicilio(domicilio);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
				object.setImagen(imagen);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			result.add(object);
		}

		return result;

	}

	/**
	 * This method transform an entity 'UsuarioAvanzado' in 'UsuarioAvanzadoDTO' in
	 * the database
	 * 
	 * @return entity 'UsuarioAvanzado' transformed in 'UsuarioAvanzadoDTO' (Data
	 *         transference Object)
	 * @since 1.0
	 */
	public UsuarioAvanzadoDTO getOne(int id) {

		Optional<UsuarioAvanzado> aOptional = usuarioAvanzadoRepository.findById(id);
		UsuarioAvanzadoDTO object = new UsuarioAvanzadoDTO();

		try {

			UsuarioAvanzado object2 = aOptional.get();
			object.setId(object2.getId());
			object.setEmail(object2.getEmail());
			object.setDni(object2.getDni());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setTelefono(object2.getTelefono());
			object.setPassword(object2.getPassword());
			object.setAlta(object2.getAlta());

			try {
				RolDTO rol = new RolDTO();
				rol.setId(object2.getRol().getId());
				rol.setNombre(object2.getRol().getNombre());
				object.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				RolDTO rol = new RolDTO();
				rol.setId(object2.getRol().getId());
				object.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				DomicilioDTO domicilio = new DomicilioDTO();
				domicilio.setId(object2.getDomicilio().getId());
				object.setDomicilio(domicilio);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				ImagenDTO imagen = new ImagenDTO();
				imagen.setId(object2.getImagen().getId());
				object.setImagen(imagen);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {

			System.out.println("No existe el id");

		}

		return object;

	}

	/**
	 * This method transform an entity 'UsuarioAvanzadoDTO' in the entity
	 * 'UsuarioAvanzado' for save it in the database
	 * 
	 * @param usuarioAvanzadoDTO it is an object DTO that comes from controller that
	 *                           will transformed in an entity
	 * @return entities 'UsuarioAvanzadoDTO'.
	 * @since 1.0
	 */
	public UsuarioAvanzadoDTO save(UsuarioAvanzadoDTO usuarioAvanzadoDTO) {

		UsuarioAvanzado usuarioAvanzado = new UsuarioAvanzado();

		usuarioAvanzado.setEmail(usuarioAvanzadoDTO.getEmail());
		usuarioAvanzado.setDni(usuarioAvanzadoDTO.getDni());
		usuarioAvanzado.setNombre(usuarioAvanzadoDTO.getNombre());
		usuarioAvanzado.setApellido(usuarioAvanzadoDTO.getApellido());
		usuarioAvanzado.setTelefono(usuarioAvanzadoDTO.getTelefono());
		usuarioAvanzado.setPassword(usuarioAvanzadoDTO.getPassword());
		
		//FECHA DE ALTA				
		Locale locale = new Locale("es", "AR");
		SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy", locale);
		sdf.format(new Date());
		usuarioAvanzado.setAlta(sdf.format(new Date()));		

		try {
			Rol rol = new Rol();
			rol.setId(usuarioAvanzadoDTO.getRol().getId());
			usuarioAvanzado.setRol(rol);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Rol rol = new Rol();
			rol.setId(usuarioAvanzadoDTO.getId());
			usuarioAvanzado.setRol(rol);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Domicilio domicilio = new Domicilio();
			domicilio.setId(usuarioAvanzadoDTO.getId());
			usuarioAvanzado.setDomicilio(domicilio);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Imagen imagen = new Imagen();
			imagen.setId(usuarioAvanzadoDTO.getId());
			usuarioAvanzado.setImagen(imagen);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		usuarioAvanzadoRepository.save(usuarioAvanzado);

		usuarioAvanzadoDTO.setId(usuarioAvanzado.getId());
		return usuarioAvanzadoDTO;

	}

	/**
	 * This method transform an entity 'UsuarioAvanzadoDTO' in the entity
	 * 'UsuarioAvanzado' for update it in the database
	 * 
	 * @param usuarioAvanzadoDTO it is an object DTO that will transformed.
	 * @param id                 it is an id that corresponds with the index of the
	 *                           entity in the DB.
	 * @return entities 'UsuarioAvanzadoDTO'.
	 * @since 1.0
	 */
	public UsuarioAvanzadoDTO update(UsuarioAvanzadoDTO usuarioAvanzadoDTO, int id) {

		Optional<UsuarioAvanzado> optional = usuarioAvanzadoRepository.findById(id);
		UsuarioAvanzado usuarioAvanzado = new UsuarioAvanzado();

		try {

			usuarioAvanzado = optional.get();

			usuarioAvanzado.setEmail(usuarioAvanzadoDTO.getEmail());
			usuarioAvanzado.setDni(usuarioAvanzadoDTO.getDni());
			usuarioAvanzado.setNombre(usuarioAvanzadoDTO.getNombre());
			usuarioAvanzado.setApellido(usuarioAvanzadoDTO.getApellido());
			usuarioAvanzado.setTelefono(usuarioAvanzadoDTO.getTelefono());
			usuarioAvanzado.setPassword(usuarioAvanzadoDTO.getPassword());
			try {
				Rol rol = new Rol();
				rol.setId(usuarioAvanzadoDTO.getRol().getId());
				usuarioAvanzado.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Rol rol = new Rol();
				rol.setId(usuarioAvanzadoDTO.getId());
				usuarioAvanzado.setRol(rol);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Domicilio domicilio = new Domicilio();
				domicilio.setId(usuarioAvanzadoDTO.getId());
				usuarioAvanzado.setDomicilio(domicilio);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Imagen imagen = new Imagen();
				imagen.setId(usuarioAvanzadoDTO.getId());
				usuarioAvanzado.setImagen(imagen);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			usuarioAvanzadoRepository.save(usuarioAvanzado);

			usuarioAvanzadoDTO.setId(usuarioAvanzado.getId());

		} catch (Exception e) {

			System.out.println("Bad Request");
			usuarioAvanzadoDTO.setId(0);

		}

		return usuarioAvanzadoDTO;

	}

	/**
	 * This method call the repository for delete an entity 'UsuarioAvanzado' in the
	 * database for the id.
	 * 
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {

		try {

			usuarioAvanzadoRepository.deleteById(id);

		} catch (Exception e) {

			return false;

		}

		return true;

	}

}
