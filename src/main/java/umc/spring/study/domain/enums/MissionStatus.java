package umc.spring.study.domain.enums;

public enum MissionStatus {
    ONGOING("진행중"),
    COMPLETED("완료"),
    PENDING("대기중");

    private final String value;

    MissionStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MissionStatus fromString(String text) {
        for (MissionStatus status : MissionStatus.values()) {
            if (status.value.equals(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + text);
    }
}
