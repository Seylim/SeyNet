package seylim.seynet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidateId")
    private int candidateId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity_number")
    private String nationalIdNumber;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    //JsonIgnore
    //@OneToMany(mappedBy="candidate")
    //private List<Resume> resumes;
}
