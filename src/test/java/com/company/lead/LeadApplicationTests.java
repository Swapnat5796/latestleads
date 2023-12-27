package com.company.lead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.lead.model.Lead;
import com.company.lead.repository.LeadRepository;
import com.company.lead.service.LeadService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LeadApplicationTests {

	@Autowired
	private LeadService service;

	@MockBean
	private LeadRepository repository;

	@Test
	public void getHelloTest() throws ParseException {
		when(repository.findAll()).thenReturn(Stream.of(
				new Lead("1234", "Vinseet", "", "KV", "8877887788", "Others", Date.valueOf("2000-01-01"),
						"v@gmail.com"),
				new Lead("5678", "Vinseet", "", "KV", "8877887788", "Others", Date.valueOf("2000-01-01"),
						"v@gmail.com"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllLeads().size());
	}

	@Test
	public void saveTest() {
		Lead lead = new Lead("1234", "Vinseet", "", "KV", "8877887788", "Others", Date.valueOf("2000-01-01"),
				"v@gmail.com");
		when(repository.save(lead)).thenReturn(lead);
		assertEquals("Created Leads Successfully", service.save(lead));
	}
}
