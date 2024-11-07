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
@Table(name = "User_Login")
public class User {
    
@Column(name = "uid" ,columnDefinition = "varchar")
@Id
private String uid;

@Column(name = "Name", columnDefinition = "varchar")
private String name;

@Column(name = "Mobile_no")
private long mobile;

@Column(name ="Address", columnDefinition = "text" )
private String address;

@Column(name = "Password", columnDefinition = "varchar")
private String password;
 




}
