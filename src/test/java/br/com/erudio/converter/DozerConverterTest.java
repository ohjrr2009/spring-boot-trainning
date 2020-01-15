package br.com.erudio.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.mocks.MockPerson;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;

public class DozerConverterTest {
	
	MockPerson inputObject;
	
	@Before
	public void setUp() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
		Assert.assertEquals(0L, output.getId());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Address Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());
	}
	
	@Test
	public void parseEntityListToVOListTest() {
		List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
		PersonVO outputZero = outputList.get(0);
		
		Assert.assertEquals(0L, outputZero.getId());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Address Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());
		
		PersonVO outputTree = outputList.get(3);
		
		Assert.assertEquals(3L, outputTree.getId());
		Assert.assertEquals("First Name Test3", outputTree.getFirstName());
		Assert.assertEquals("Last Name Test3", outputTree.getLastName());
		Assert.assertEquals("Address Test3", outputTree.getAddress());
		Assert.assertEquals("Female", outputTree.getGender());
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		Assert.assertEquals(0L, output.getId());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Address Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
		Person outputZero = outputList.get(0);
		
		Assert.assertEquals(0L, outputZero.getId());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Address Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());
		
		Person outputTree = outputList.get(3);
		
		Assert.assertEquals(3L, outputTree.getId());
		Assert.assertEquals("First Name Test3", outputTree.getFirstName());
		Assert.assertEquals("Last Name Test3", outputTree.getLastName());
		Assert.assertEquals("Address Test3", outputTree.getAddress());
		Assert.assertEquals("Female", outputTree.getGender());
	}
}
