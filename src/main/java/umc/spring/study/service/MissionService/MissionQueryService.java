package umc.spring.study.service.MissionService;

import umc.spring.study.domain.Mission;
import java.util.List;

public interface MissionQueryService {
    List<Mission> getMissions(Long memberId, Long regionId, int limit, int offset);
}
