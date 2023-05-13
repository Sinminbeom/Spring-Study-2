package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("service")
@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //필드 주입은 사용하지 않는 것이 좋다.
//    @Autowired private DiscountPolicy discountPolicy;
//    @Autowired private MemberRepository memberRepository;
     private final MemberRepository memberRepository;
     private final DiscountPolicy discountPolicy;
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 스프링에서 자동으로 주입해줌
    @Autowired
    public OrderServiceImpl(MemberRepository  memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }
//    @Autowired
      // @MainDiscountPolicy
//    public OrderServiceImpl(MemberRepository  memberRepository,@Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//        this.memberRepository = memberRepository;
//    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
