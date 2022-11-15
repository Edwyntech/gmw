package tech.edwyn.gmw.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.edwyn.gmw.domain.QuizHandlerApi;
import tech.edwyn.gmw.domain.QuizService;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

@Configuration
@ComponentScan
public class SpringContextConfiguration {

    @Bean
    public QuizHandlerApi customerOrderHandler(final QuizStoreSpi quizStoreSpi) {
        return new QuizService(quizStoreSpi);
    }
}
