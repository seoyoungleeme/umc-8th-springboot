package umc.spring.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, String title, float score) {
        Review review = reviewRepository.saveReview(memberId, storeId, title, score);
        System.out.println("Review created: " + review);
        return review;
    }
}
