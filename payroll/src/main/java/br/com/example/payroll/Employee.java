package br.com.example.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;
	
	public Employee() {
	}
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	/* TODO: Transient solution. Need to repair lombok dependency */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + "]";
	}
	
	/* TODO: <END> Transient solution. Need to repair lombok dependency */
	
}
