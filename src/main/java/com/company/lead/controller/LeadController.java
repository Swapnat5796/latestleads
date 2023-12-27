package com.company.lead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lead.exception.CustomException;
import com.company.lead.model.Lead;
import com.company.lead.service.LeadService;
import com.company.lead.service.ResponseHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class LeadController {

	@Autowired
	private LeadService service;

	/*
	 * http://localhost:8090/api/v1/leads
	 * 
	 */
	@GetMapping("/leads")
	public ResponseEntity<Object> getAllLeads() {
		return ResponseHandler.responseBuilder("success", HttpStatus.OK, service.getAllLeads());
	}

	/*
	 * http://localhost:8090/api/v1/leads
	 */
	@PostMapping("/leads")
	public ResponseEntity<Object> createLead(@Valid @RequestBody Lead lead) throws CustomException {
		return ResponseHandler.responseBuilder("success", HttpStatus.OK, service.save(lead));
	}
	
	/*
	 * http://localhost:8090/api/v1/leadsById/{mobileNumber}
	 */
	@GetMapping("/leadsById/{mobileNumber}")
	public ResponseEntity<Object> getAllLeadsById(@PathVariable String mobileNumber) {
		return ResponseHandler.responseBuilder("success", HttpStatus.OK, service.getAllLeadsByMobile(mobileNumber));
	}
	
}
