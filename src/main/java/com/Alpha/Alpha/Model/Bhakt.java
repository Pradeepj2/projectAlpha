package com.Alpha.Alpha.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Validation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Bhakt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "{this field is required...}")
	@Size(min=1, max =3 ,message = "{validation.error.size.name}")
	
	private String name;
	private String hashPassword;
		
	private String role;
	private String mobileNo;
	@Column(name = "Status", columnDefinition = "int default 0")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	




public Bhakt(int id, @NotBlank(message = "{this field is required...}") @Size(min = 1, max = 3) String name,
			String hashPassword, String role, String mobileNo, int status) {
		super();
		this.id = id;
		this.name = name;
		this.hashPassword = hashPassword;
		this.role = role;
		this.mobileNo = mobileNo;
		this.status = status;
	}

//	public Bhakt(int id, String name, String hashPassword, String role, String mobileNo, int status) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.hashPassword = hashPassword;
//		this.role = role;
//		this.mobileNo = mobileNo;
//		this.status = status;
//	}

	public Bhakt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bhakt [id=" + id + ", name=" + name + ", hashPassword=" + hashPassword + ", role=" + role
				+ ", mobileNo=" + mobileNo + ", status=" + status + "]";
	}

}
