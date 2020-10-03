package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private final MemberRepositroy memberRepositroy;

    @Autowired
    public SpringConfig(MemberRepositroy memberRepositroy) {
        this.memberRepositroy = memberRepositroy;
    }

    @Autowired


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepositroy);
    }

//    @Bean
//    public MemberRepositroy memberRepositroy(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }


}
