package umc.spring.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Review createReview (Long storeId, StoreRequestDTO.createReviewDTO request) { // 2. 가게에 리뷰 추가하기 API
        Review review = StoreConverter.toReview(request);
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
    @Override
    public Mission createMission (Long storeId, StoreRequestDTO.createMissionDTO request) { // 3. 가게에 미션 추가하기 API
        Mission mission = StoreConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
}
