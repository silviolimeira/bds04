package com.devsuperior.bds04.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.bds04.dto.EventInsertDTO;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.resources.exceptions.FieldMessage;

public class EventInsertValidator implements ConstraintValidator<EventInsertValid, EventInsertDTO> {

	@Autowired
	private EventRepository repository;

	@Override
	public void initialize(EventInsertValid eventInsertValid) {
	}

	@Override
	public boolean isValid(EventInsertDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
