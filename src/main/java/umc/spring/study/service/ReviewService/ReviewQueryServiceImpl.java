package umc.spring.study.service.ReviewService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.QReview;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final JPAQueryFactory queryFactory;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewsByStore(Long storeId, Pageable pageable) {
        QReview review = QReview.review;

        // 리뷰 목록 조회
        List<Review> reviews = queryFactory
                .selectFrom(review)
                .where(review.store.id.eq(storeId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 총 리뷰 개수
        long total = queryFactory
                .select(review.count())
                .from(review)
                .where(review.store.id.eq(storeId))
                .fetchOne();

        return new PageImpl<>(reviews, pageable, total);
    }
}
