/* package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Mission;
import umc.spring.study.repository.MissionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> getMissions(Long memberId, Long regionId, int limit, int offset) {
        return missionRepository.findMissionsByRegionAndStatus(memberId, regionId, limit, offset);
    }
}
*/