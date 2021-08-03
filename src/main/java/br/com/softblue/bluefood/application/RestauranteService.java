package br.com.softblue.bluefood.application;

//public class RestauranteService {

	//package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.restaurante.Restaurante;
import br.com.softblue.bluefood.domain.restaurante.RestauranteRepository;


	@Service
	public class RestauranteService {

		@Autowired
		public RestauranteRepository restauranteRepository;
		
		public void saveRestaurante(Restaurante restaurante) throws ValidationException {
			
			if(!validateEmail(restaurante.getEmail(), restaurante.getId()))
			{
				throw new ValidationException("Já existe um e-mail igual a este cadastrado!");
			}
			
			restauranteRepository.save(restaurante);
			
		}
		
		private boolean validateEmail(String email, Integer id)
		{
			
			Restaurante restaurante = restauranteRepository.findByEmail(email);
			if (restaurante != null)
			{
				if(id == null)
				{
					return false;
				} 
				
				if(!restaurante.getId().equals(id))
				{
					return false;
				}
			}
			return true;
		}
		
}
