package com.viniciusalcantaracursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.viniciusalcantaracursomc.domain.Cliente;
import com.viniciusalcantaracursomc.domain.enums.TipoCliente;
import com.viniciusalcantaracursomc.dto.ClienteDTO;
import com.viniciusalcantaracursomc.dto.ClienteNewDTO;
import com.viniciusalcantaracursomc.repositories.ClienteRepository;
import com.viniciusalcantaracursomc.resources.exception.FieldMessage;
import com.viniciusalcantaracursomc.services.validation.utils.BR;

public class ClienteUpdateValidation implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
			if(aux != null && !aux.getId().equals(uriId)) {
				list.add(new FieldMessage("email", "Email já existente"));
			}		
		
		// 	inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();			
		}
		return list.isEmpty();
	}
}