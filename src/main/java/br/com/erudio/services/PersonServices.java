package br.com.erudio.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	private final AtomicLong counter = new AtomicLong();

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO person) {
		PersonVO entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void delete(Long id) {
		PersonVO entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID"));
		repository.delete(entity);
	}

	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID"));
		// estudar Callbacks no Java --->>> () -> new ResourceNotFoundException("No
		// records found with this ID")
		
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	private PersonVO mockPerson(int i) {
		PersonVO person = new PersonVO();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAddress("Some Address" + i);
		person.setGender("M");
		return person;
	}

}
