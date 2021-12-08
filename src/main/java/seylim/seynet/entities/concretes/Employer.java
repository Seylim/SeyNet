package seylim.seynet.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_adrress")
    private String webAdrress;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Employer(int id, String email, String password, String companyName, String webAdrress, String phoneNumber) {
        super.setId(id);
        super.setEmail(email);
        super.setPassword(password);
        this.setCompanyName(companyName);
        this.setWebAdrress(webAdrress);
        this.setPhoneNumber(phoneNumber);
    }
}
