package us.lwin.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import us.lwin.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
