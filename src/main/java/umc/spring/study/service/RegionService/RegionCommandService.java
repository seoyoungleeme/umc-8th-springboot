package umc.spring.study.service.RegionService;

import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.RegionRequestDTO;

public interface RegionCommandService {

    // 1. 특정 지역에 가게 추가하기 API
    Store createStore(Long regionId, RegionRequestDTO.StoreDTO request);
}
