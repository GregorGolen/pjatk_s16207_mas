package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

/*    @Query(value = "SELECT activities.activity_id, activities.max_participants, activities.min_participants, activities.specialization, activities.types FROM locations INNER JOIN location_activity  ON locations.location_id = location_activity.location_id INNER JOIN activities ON location_activity.activity_id = activities.activity_id WHERE locations.location_id=?1", nativeQuery = true)
    public List<Activity> findAllActivitesInLocation(Long id);*/
}
