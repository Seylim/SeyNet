package seylim.seynet.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employerId")
    private int employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_adrress")
    private String webAdrress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_activited")
    private boolean isActivited;

    //@OneToMany(mappedBy = "employer")
    //private List<JobAdvertisement> jobAdvertisements;
}
