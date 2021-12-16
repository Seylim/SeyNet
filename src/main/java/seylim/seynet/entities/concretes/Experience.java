package seylim.seynet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "termination_date")
    private LocalDate terminationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
