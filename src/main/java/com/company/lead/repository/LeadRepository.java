package com.company.lead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.lead.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, String> {

	List<Lead> findByMobileNumber(String mobileNumber);
}
