package seylim.seynet.entities.dtos;

import io.swagger.v3.oas.annotations.links.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import seylim.seynet.entities.concretes.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWithAllRelatedEntitiesDto {

    private int id;

    private LocalDateTime creationDate;

    private Candidate candidate;

    private Image image;

    private List<Education> educations;

    private List<Experience> experiences;

    private List<Language> languages;

    private List<SocialMedia> socialMedias;

    private List<Technology> technologies;

}
