package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// ComponentScan이 붙은 클래스를 찾아서 자동으로 스프링 빈에 등록해준다.
@ComponentScan(
        // default는 @ComponentScan이라는 어노테이션이 붙은 클래스의 패키지부터 탐색한다.
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        //  @Configuration이 붙은 AppConfig도 컴포넌트스캔의 대상이다
        //  @Configuration을 들어가보면 @Component가 붙어있다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
