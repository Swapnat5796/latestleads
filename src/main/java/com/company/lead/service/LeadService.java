package com.company.lead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.lead.exception.CustomException;
import com.company.lead.model.Lead;
import com.company.lead.repository.LeadRepository;

import jakarta.validation.Valid;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;

	/*
	 * This method is used to get leads details present in db.
	 * 
	 */
	public List<Lead> getAllLeads() {
		if (!leadRepository.findAll().isEmpty())
			return leadRepository.findAll();
		throw new CustomException("E10011");
	}

	/*
	 * This method is used to save lead details if it is not available based on lead id.
	 * 
	 */
	public String save(@Valid @RequestBody Lead lead) {
		if (!leadRepository.findById(lead.getLeadId()).isPresent()) {
			leadRepository.save(lead);
			return "Created Leads Successfully";
		}
		throw new CustomException("E10010");
	}

	/*
	 * This method is used to find lead details based on id. 
	 *  
	 */
	public String findById(String leadId) {
		if (!leadRepository.findById(leadId).isPresent())
			return null;
		else
			return "Lead Already Exists in the database with the lead id";
	}
	
	/*
	 * This method is used to find lead details based on mobileNumber. 
	 *  
	 */
	public List<Lead> getAllLeadsByMobile(String mobileNumber) {
		if (!leadRepository.findByMobileNumber(mobileNumber).isEmpty())
			return leadRepository.findByMobileNumber(mobileNumber);
		else
			throw new CustomException("E10011");
	}
}
