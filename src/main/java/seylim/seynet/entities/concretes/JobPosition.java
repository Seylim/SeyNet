package seylim.seynet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "jop_positions")
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "salary_min")
    private String salaryMin;

    @Column(name = "salary_max")
    private String salaryMax;

    @Column(name = "posting_date")
    private LocalDateTime postingDate;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;
}
