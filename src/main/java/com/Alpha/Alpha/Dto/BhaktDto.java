package com.Alpha.Alpha.Dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BhaktDto {
	private int id;
	private String name;
	private String hashPassoword;
	private String role;
	@Column(name = "Status", columnDefinition = "int default 0")
	private int status;
	private String mobileNo;
}
