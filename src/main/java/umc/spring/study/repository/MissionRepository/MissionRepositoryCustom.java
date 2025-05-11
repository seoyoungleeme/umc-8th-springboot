package umc.spring.study.repository.MissionRepository;

import com.querydsl.core.Tuple;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Tuple> findMissionsByRegionAndStatus(Long memberId, Long regionId, int limit, int offset);
}
