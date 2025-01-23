package com.paul.security.user_security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserTable {

	@Id
	private String userId;
	private String password;

//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "user_data_id", referencedColumnName = "userId")
//	private UserData userData;
	
}
