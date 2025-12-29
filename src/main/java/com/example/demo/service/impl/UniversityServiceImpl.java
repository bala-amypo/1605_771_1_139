@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repo;

    public UniversityServiceImpl(UniversityRepository repo) {
        this.repo = repo;
    }

    public University createUniversity(University u) {
        u.setActive(true);
        return repo.save(u);
    }

    public University getUniversity(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<University> getAllUniversities() {
        return repo.findAll();
    }

    public University updateUniversity(Long id, University u) {
        University db = getUniversity(id);
        db.setName(u.getName());
        return repo.save(db);
    }

    public void deactivateUniversity(Long id) {
        University u = getUniversity(id);
        u.setActive(false);
        repo.save(u);
    }
}
