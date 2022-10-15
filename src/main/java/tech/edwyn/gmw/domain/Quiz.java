package tech.edwyn.gmw.domain;

import java.util.List;

public record Quiz(Question<String> question, List<Answer<String>> answers) {
}
