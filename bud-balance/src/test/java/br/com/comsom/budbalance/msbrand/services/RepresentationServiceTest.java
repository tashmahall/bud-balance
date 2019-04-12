package br.com.comsom.budbalance.msbrand.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.repositories.IRepresentationRepository;
@RunWith(MockitoJUnitRunner.class)
public class RepresentationServiceTest {
	@InjectMocks
	private RepresentationService service;
	@Mock
	private BrandService brandService;
	@Mock
	private RepresentativeService representativeService;
	@Mock
	private IRepresentationRepository repository;
	
	private Representation representationTest;
	
	private List<Representation> listRepresentationTest;
	@Before
	public void load() {
		representationTest = new Representation();
		representationTest.setCode("1234567890");
		Brand brandTest = new Brand();
		brandTest.setCode("1234567890");
		brandTest.setCountry("Brasil");
		brandTest.setName("New Brand");
		representationTest.setBrand(brandTest);
		Representative representativeTest = new Representative();
		representativeTest.setCompanyIdNumber("1234567890");
		representativeTest.setName("Representations");
		representationTest.setRepresentative(representativeTest);
		listRepresentationTest = new ArrayList<Representation>();
		listRepresentationTest.add(representationTest);
	}
	
	@Test
	public void testFindByCode() {
		when(repository.findByCode(representationTest.getCode())).thenReturn(representationTest);
		Representation response = service.findByCode(representationTest.getCode());
		assertEquals(representationTest,response);
	}

	@Test
	public void testFindByBrand() {
		when(repository.findByBrand(representationTest.getBrand())).thenReturn(listRepresentationTest);
		when(brandService.findByName(representationTest.getBrand().getName())).thenReturn(representationTest.getBrand());
		List<Representation> response = service.findByBrand(representationTest.getBrand().getName());
		assertEquals(listRepresentationTest, response);
	}

	@Test
	public void testFindByRepresentative() {
		when(repository.findByRepresentative(representationTest.getRepresentative())).thenReturn(listRepresentationTest);
		when(representativeService.findByCompanyIdNumber(representationTest.getRepresentative().getCompanyIdNumber())).thenReturn(representationTest.getRepresentative());
		List<Representation> response = service.findByRepresentative(representationTest.getRepresentative().getCompanyIdNumber());
		assertEquals(listRepresentationTest, response);
	}

}
