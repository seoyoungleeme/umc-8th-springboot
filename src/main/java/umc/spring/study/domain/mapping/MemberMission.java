package umc.spring.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus status;

    @Override
    public String toString() {
        return "MemberMission{" +
                "id=" + id +
                ", member=" + (member != null ? member.getName() : "N/A") +
                ", mission=" + (mission != null ? mission.getMissionSpec() : "N/A") +
                ", status='" + status + '\'' +
                '}';
    }
}