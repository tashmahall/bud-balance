	package br.com.comsom.budbalance.msbrand.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.repositories.IBrandRepository;
@RunWith(MockitoJUnitRunner.class)
public class BrandServiceTest {
	@InjectMocks
	private BrandService service;
	@Mock
	private IBrandRepository repository;
	private Brand brandTest;
	@Before
	public void Load() {
		brandTest = new Brand();
		brandTest.setCode("1234567890");
		brandTest.setCountry("Brasil");
		brandTest.setName("New Brand");
	}

	@Test
	public void testFindByName() {
		when(repository.findByName(brandTest.getName())).thenReturn(brandTest);
		Brand response = service.findByName(brandTest.getName());
		assertEquals(brandTest, response);
	}

	@Test
	public void testFindByCode() {
		when(repository.findByCode(brandTest.getCode())).thenReturn(brandTest);
		Brand response = service.findByCode(brandTest.getCode());
		assertEquals(brandTest, response);
	}

}
