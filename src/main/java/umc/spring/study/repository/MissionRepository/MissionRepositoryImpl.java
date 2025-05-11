package umc.spring.study.repository.MissionRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.QMission;
import umc.spring.study.domain.QRegion;
import umc.spring.study.domain.QStore;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.QMemberMission;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Tuple> findMissionsByRegionAndStatus(Long memberId, Long regionId, int limit, int offset) {
        QRegion region = QRegion.region;
        QStore store = QStore.store;
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;

        return jpaQueryFactory
                .select(mission.id, store.name, mission.deadline, mission.reward, mission.missionSpec, region.name)
                .from(mission)
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .join(store).on(mission.store.id.eq(store.id))
                .join(region).on(store.region.id.eq(region.id))
                .where(memberMission.status.eq(MissionStatus.ONGOING)
                        .and(memberMission.member.id.eq(memberId))
                        .and(region.id.eq(regionId)))
                .orderBy(memberMission.createdAt.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
