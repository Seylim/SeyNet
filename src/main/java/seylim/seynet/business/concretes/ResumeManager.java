package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.EducationService;
import seylim.seynet.business.abstracts.ExperienceService;
import seylim.seynet.business.abstracts.ImageService;
import seylim.seynet.business.abstracts.ResumeService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.ResumeDao;
import seylim.seynet.entities.concretes.Resume;
import seylim.seynet.entities.dtos.ResumeWithAllRelatedEntitiesDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private ImageService imageService;
    private EducationService educationService;
    private ExperienceService experienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, ImageService imageService, EducationService educationService, ExperienceService experienceService){
        this.resumeDao = resumeDao;
        this.imageService = imageService;
        this.educationService = educationService;
        this.experienceService = experienceService;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Resume resume) {
        resume = getById(resume.getId()).getData();
        resume.setCreationDate(LocalDateTime.now());

        resumeDao.save(resume);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.resumeDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(this.resumeDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<Resume> getByCandidate_Id(int candidateId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getByCandidate_Id(candidateId));
    }

    @Override
    public DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByCandidate() {
        List<ResumeWithAllRelatedEntitiesDto> resumes = new ArrayList<ResumeWithAllRelatedEntitiesDto>();

        for (Resume resume : getAll().getData()) {
            if (resume.getCandidate() != null ) {
                resumes.add(getResumeDetailsByCandidateId(resume.getCandidate().getId()).getData());
            }
        };

        return new SuccessDataResult<List<ResumeWithAllRelatedEntitiesDto>>(resumes);
    }

    @Override
    public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId) {
        Resume resume = getByCandidate_Id(candidateId).getData();

        ResumeWithAllRelatedEntitiesDto resumeWithAllRelatedEntitiesDto = new ResumeWithAllRelatedEntitiesDto(
                resume.getId(),
                resume.getCreationDate(),
                resume.getCandidate(),
                imageService.getByUser_Id(candidateId).getData(),
                educationService.getAllByResumeIdSortedByGraduationDate(resume.getId()).getData(),
                experienceService.getAllByResumeIdSortedByTerminationDate(resume.getId()).getData(),
                resume.getLanguages(),
                resume.getSocialMedias(),
                resume.getTechnologies()
        );

        return new SuccessDataResult<ResumeWithAllRelatedEntitiesDto>(resumeWithAllRelatedEntitiesDto);
    }
}
