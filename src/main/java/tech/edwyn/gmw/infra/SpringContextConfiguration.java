package tech.edwyn.gmw.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.edwyn.gmw.domain.QuizHandlerApi;
import tech.edwyn.gmw.domain.QuizService;
import tech.edwyn.gmw.domain.UserHandlerApi;
import tech.edwyn.gmw.domain.UserService;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

@Configuration
@ComponentScan
public class SpringContextConfiguration {
    @Bean
    public QuizHandlerApi quizHandlerApi(final QuizStoreSpi quizStoreSpi, final AnswerStoreSpi answerStoreSpi, final UserStoreSpi userStoreSpi) {
        return new QuizService(quizStoreSpi, answerStoreSpi, userStoreSpi);
    }

    @Bean
    public UserHandlerApi userHandlerApi(final UserStoreSpi userStoreSpi) {
        return new UserService(userStoreSpi);
    }
}
