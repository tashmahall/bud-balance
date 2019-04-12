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

import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.repositories.IRepresentativeRepository;
@RunWith(MockitoJUnitRunner.class)
public class RepresentativeServiceTest {
	@InjectMocks
	private RepresentativeService service;
	@Mock
	private IRepresentativeRepository repository;
	
	private Representative representativeTest;
	@Before
	public void load() {
		representativeTest = new Representative();
		representativeTest.setCompanyIdNumber("1234567890");
		representativeTest.setName("Representations");
	}
	@Test
	public void testFindByCompanyIdNumber() {
		when(repository.findByCompanyIdNumber(representativeTest.getCompanyIdNumber())).thenReturn(representativeTest);
		Representative rTemp = service.findByCompanyIdNumber(representativeTest.getCompanyIdNumber());
		assertEquals(representativeTest,rTemp);
	}

	@Test
	public void testFindByName() {
		List<Representative> lRepreTest = new ArrayList<Representative>();
		lRepreTest.add(representativeTest);
		when(repository.findByName(representativeTest.getName())).thenReturn(lRepreTest);
		List<Representative> lTemp = service.findByName(representativeTest.getName());
		assertEquals(lRepreTest,lTemp);
	}

}
