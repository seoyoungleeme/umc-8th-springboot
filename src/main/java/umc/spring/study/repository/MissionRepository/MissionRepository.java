package umc.spring.study.repository.MissionRepository;

import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    List<Tuple> findMissionsByRegionAndStatus(Long memberId, Long regionId, int limit, int offset);
}
