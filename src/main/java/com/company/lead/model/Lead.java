package com.company.lead.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "lead")
public class Lead {

	@Id()
	@Column(unique = true)
	@NotBlank(message = "LeadId is mandatory ")
	@NotNull(message = "LeadId: ID is NULL")
	@Pattern(regexp = "^[0-9]{4}", message = "LeadId should be integer")
	private String leadId;

	@Pattern(regexp = "^[A-Z][a-z]{1,}$", message = "FirstName is mandatory")
	private String firstName;

	private String middleName;

	@Pattern(regexp = "^[A-Z]{2}$", message = "LastName is mandatory")
	private String lastName;

	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Mobile Number is mandatory")
	private String mobileNumber;

	@Pattern(regexp = "Male\\b|Female\\b|Others\\b", message = "Gender Male/Female/Others.Gender is mandatory")
	private String gender;

	@NotNull(message = "DOB is mandatory")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dob;

	@Email(message = "Email is not valid")
	@Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
			+ "(?:[A-Za-z0-9-]*[A-Za-z0-9])?", message = "{invalid.email}")
	private String email;

	public Lead() {
		super();
	}

	public Lead(String leadId, String firstName, String middleName, String lastName, String mobileNumber, String gender,
			Date dob, String email) {
		super();
		this.leadId = leadId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "mobile_number", nullable = false)
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "dob", nullable = false)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", dob=" + dob + ", email="
				+ email + "]";
	}

}
