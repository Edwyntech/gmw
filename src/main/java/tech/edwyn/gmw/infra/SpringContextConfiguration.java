package tech.edwyn.gmw.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.edwyn.gmw.domain.QuizHandlerApi;
import tech.edwyn.gmw.domain.QuizService;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

@Configuration
@ComponentScan
public class SpringContextConfiguration {
    @Bean
    public QuizHandlerApi customerOrderHandler(final QuizStoreSpi quizStoreSpi, final AnswerStoreSpi answerStoreSpi) {
        return new QuizService(quizStoreSpi, answerStoreSpi);
    }
}
