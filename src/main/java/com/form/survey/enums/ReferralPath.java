package com.form.survey.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReferralPath {
    FRIEND_RECOMMENDATION("지인 추천"),
    ONLINE_SEARCH("온라인 검색"),
    MAP_APP("지도 앱"),
    SNS_SOCIAL_MEDIA("SNS/소셜 미디어"),
    WALK_BY_CHANCE("길 가다 우연히"),
    SIGN_EXTERNAL_PROMOTION("간판 / 외부 홍보물"),
    PREVIOUS_VISIT_EXPERIENCE("이전 방문 경험");

    private final String displayName;

    ReferralPath(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static com.form.survey.enums.ReferralPath fromDisplayName(String displayName) {
        return Arrays.stream(com.form.survey.enums.ReferralPath.values())
                .filter(path -> path.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 찾아온 경로 입력"));
    }
}