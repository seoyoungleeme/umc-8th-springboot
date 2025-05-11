package umc.spring.study.service.MissionService;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.repository.MissionRepository.MissionRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public void getAvailableMissions(Long memberId, Long regionId, int limit, int offset) {
        List<Tuple> missions = missionRepository.findMissionsByRegionAndStatus(memberId, regionId, limit, offset);
        if (missions.isEmpty()) {
            System.out.println("No available missions found for region ID: " + regionId);
        } else {
            missions.forEach(System.out::println);
        }
    }
}

