package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

//    @Autowired MemberRepository memberRepository;
//    @Autowired DiscountPolicy discountPolicy;
//    @Bean
//    OrderService orderService() {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
