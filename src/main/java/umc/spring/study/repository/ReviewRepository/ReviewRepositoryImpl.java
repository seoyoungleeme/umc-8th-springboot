package umc.spring.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.QReview;
import umc.spring.study.domain.Review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    @Override
    public boolean existsByMemberAndStore(Long memberId, Long storeId) {
        Long count = queryFactory
                .select(QReview.review.count())
                .from(QReview.review)
                .where(QReview.review.member.id.eq(memberId)
                        .and(QReview.review.store.id.eq(storeId)))
                .fetchOne();

        return count != null && count > 0;
    }

    @Override
    public Review saveReview(Review review) {
        if (review.getId() == null) {
            entityManager.persist(review);  // 새로 생성된 엔티티
        } else {
            entityManager.merge(review);    // 기존 엔티티 업데이트
        }
        return review;
    }
}
