package umc.spring.study.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> findMissionsByStatusAndMemberId(Long memberId, String status, int limit, int offset) {
        return queryFactory
                .selectFrom(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.stringValue().eq(status)))
                .orderBy(memberMission.updatedAt.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}
