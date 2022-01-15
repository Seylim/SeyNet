package seylim.seynet.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import seylim.seynet.business.abstracts.JobPositionService;
import seylim.seynet.core.utilities.*;
import seylim.seynet.dataAccess.abstracts.JobPositionDao;
import seylim.seynet.entities.concretes.JobPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobPositionManager implements JobPositionService{

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.jobPositionDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<List<JobPosition>> getAllByIsActive(boolean isActive) {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(isActive));
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(true, pageable));
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDate() {
        Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");

        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(true, sort));
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by("postingDate").descending());

        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(true, pageable));
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesSortedByPostingDateTop6() {
        List<JobPosition> result = getAllActiveOnesByPageSortedByPostingDate(1, 6).getData();

        return new SuccessDataResult<List<JobPosition>>(result);
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesByEmployerIdSortedByPostingDate(int employerId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");

        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActiveAndEmployer_Id(true, employerId, sort));
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesFilteredByCityAndJobTitle(int cityId, int jobTitleId) {
        List<JobPosition> result = new ArrayList<JobPosition>();

        Stream<JobPosition> stream = getAllActiveOnesSortedByPostingDate().getData().stream();

        Predicate<JobPosition> cityCondition = cityId != 0
                ? (jobPosting -> jobPosting.getCity().getId() == cityId)
                : (jobPosting -> jobPosting.getCity().getId() > 0);
        Predicate<JobPosition> jobTitleCondition = jobTitleId != 0
                ? (jobPosting -> jobPosting.getJobTitle().getId() == jobTitleId)
                : (jobPosting -> jobPosting.getJobTitle().getId() > 0);

        stream.filter(cityCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));

        return new SuccessDataResult<List<JobPosition>>(result);
    }

    @Override
    public DataResult<List<JobPosition>> getAllActiveOnesByPageFilteredByCityAndJobTitle(int cityId, int jobTitleId, int pageNo, int pageSize) {
        int skipCount = (pageNo -1) * pageSize;

        List<JobPosition> result = getAllActiveOnesFilteredByCityAndJobTitle(cityId, jobTitleId).getData();

        return new SuccessDataResult<List<JobPosition>>(result.stream().skip(skipCount).limit(pageSize).collect(Collectors.toList()));
    }
}
