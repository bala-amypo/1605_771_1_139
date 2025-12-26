public interface CourseRepository {
    Optional<Course> findById(Long id);
    Optional<Course> findByUniversityIdAndCourseCode(Long uid, String code);
    List<Course> findByUniversityIdAndActiveTrue(Long uid);
    Course save(Course c);
}
