package umc.spring.study.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.QMember;
import umc.spring.study.domain.QMission;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberMissionRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<MemberMission> findMissionsByStatus(Long memberId, String status, Pageable pageable) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QMember member = QMember.member;

        // 상태값 변환
        MissionStatus missionStatus;
        try {
            missionStatus = MissionStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("잘못된 상태 값입니다: " + status);
        }

        List<MemberMission> result = queryFactory
                .selectFrom(memberMission)
                .join(memberMission.member, member).fetchJoin()
                .join(memberMission.mission, mission).fetchJoin()
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq(missionStatus)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.deadline.desc())
                .fetch();

        long total = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq(missionStatus)))
                .fetchOne();

        return new PageImpl<>(result, pageable, total);
    }
}
