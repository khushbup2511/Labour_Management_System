package Labour_employemt_Backend.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sample_table")
public class sample {
    
    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;
}
