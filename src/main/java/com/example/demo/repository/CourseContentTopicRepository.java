public interface CourseContentTopicRepository
        extends JpaRepository<CourseContentTopic, Long> {

    List<CourseContentTopic> findByCourse_Id(Long courseId);
}
