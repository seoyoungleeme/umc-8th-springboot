package umc.spring.study.repository.MissionRepository;

import umc.spring.study.domain.Mission;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByRegionAndStatus(Long memberId, Long regionId, int limit, int offset);
}
