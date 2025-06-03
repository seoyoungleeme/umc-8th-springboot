package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.service.MissionService.MissionCommandService;
import umc.spring.study.web.dto.MissionRequestDTO;
import umc.spring.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}") // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
    public ApiResponse<MissionResponseDTO.createMemberMissionResultDTO> createMemberMission(@RequestBody @Valid MissionRequestDTO.createMemberMissionDTO request,
                                                                                            @RequestParam(name = "memberId") Long memberId,
                                                                                            @PathVariable(name = "missionId") Long missionId) {
        MemberMission memberMission = missionCommandService.createMemberMission(memberId, missionId, request);

        return ApiResponse.onSuccess(MissionConverter.createMemberMissionResultDTO(memberMission));

    }
}
