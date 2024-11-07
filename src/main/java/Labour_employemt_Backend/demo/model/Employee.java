package Labour_employemt_Backend.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_login")
public class Employee {
    
    @Id
    @Column(name = "Eid", nullable = false)
    private String eid;  // Employee ID

    @Column(name = "Name", nullable = true)
    private String name;  // Employee Name

    @Column(name = "Mobile", nullable = true)
    private long mobile;  // Mobile number

    @Column(name = "Address", nullable = true)
    private String address;  // Address

    @Column(name = "Skill", nullable = true)
    private String skill;  // Skill

    @Column(name = "Aadhaar", nullable = true)
    private String aadhaar;  // Aadhaar number

    @Column(name = "Password", nullable = true)
    private String password;  // Password

    @Column(name = "Rating", nullable = true)
    private Integer rating;  // Rating

}
