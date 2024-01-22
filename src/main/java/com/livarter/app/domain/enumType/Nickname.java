package com.livarter.app.domain.enumType;

import lombok.Getter;

import java.util.Random;

/**
 * @author : 황수영
 * @fileName : Nickname
 * @since : 2024-01-20
 */
@Getter
public enum Nickname {

    DESCRIPTORS("자유로운 ", "안목있는 ", "힙한 ", "신중한 ", "귀여운 ", "센스있는 "),
    NAME("가구 수집가", "조명 수집가", "아티스트");

    private final String[] words;
    private static final Random random = new Random();

    Nickname(String... words) {
        this.words = words;
    }

    public static String getRandomNickname() {
        StringBuilder randomNickname = new StringBuilder();
        return randomNickname.append(getRandomWord(DESCRIPTORS.words))
                .append(getRandomWord(NAME.words))
                .toString();
    }

    private static String getRandomWord(String[] words)  {
        int index = random.nextInt(words.length);
        return words[index];
    }
}