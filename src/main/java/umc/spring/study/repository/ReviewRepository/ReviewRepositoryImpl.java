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
    private final QReview review = QReview.review;

    @Override
    public Review saveReview(Long memberId, Long storeId, String title, float score) {
        Review newReview = Review.builder()
                .title(title)
                .score(score)
                .build();

        entityManager.persist(newReview);
        System.out.println("Review saved: " + newReview);
        return newReview;
    }
}
