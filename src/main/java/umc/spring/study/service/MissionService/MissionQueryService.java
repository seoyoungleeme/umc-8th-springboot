package umc.spring.study.service.MissionService;

public interface MissionQueryService {
    void getAvailableMissions(Long memberId, Long regionId, int limit, int offset);
}