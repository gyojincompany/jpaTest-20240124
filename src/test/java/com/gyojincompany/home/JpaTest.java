package com.gyojincompany.home;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.gyojincompany.home.entity.Member;
import com.gyojincompany.home.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
//테스트용 db 서버 주소가 설정되어 있는 설정파일로 변경하여 테스트
public class JpaTest {
	
	@Autowired//DI 자동주입
	MemberRepository memberRepository;
	
//	@Test
//	@DisplayName("회원 가입 기능 테스트")
//	public void joinMember() {//회원가입
//		Member member = new Member();
//		member.setMemberid("lion");
//		member.setMemberpw("12345");
//		member.setMembername("김유신");
//		member.setMemberage(23);
//		
//		//insert into jpa_member(memberid,memberpw,membername,memberage)
//		//values('tiger','12345','홍길동',21);
//		
//		memberRepository.save(member);//save->insert sql문을 실행시켜주는 메서드
//	}
	
	@Test
	@DisplayName("모든 회원 리스트 가져오기")
	public void memberSearch( ) {//모든 회원 리스트 가져오기
		List<Member> memberlist = memberRepository.findAll();
		//SELECT * FROM jpa_member;
		
		for(Member member:memberlist) {
			System.out.print(member.getMembernum()+" / ");
			System.out.print(member.getMemberid()+" / ");
			System.out.print(member.getMemberpw()+" / ");
			System.out.print(member.getMembername()+" / ");
			System.out.println(member.getMemberage()+" / ");
			
		}
	}
	
	@Test
	@DisplayName("특정 회원 번호로 검색하기")
	public void numberSearch() {//회원의 번호로 검색
		Optional<Member> memberOptional = memberRepository.findById(10L);//회원번호(기본키)로 검색(검색결과->1개 or 0개)
		//Optional 타입으로 반환받으면 null 값으로 반환되었을때도 에러가 안나고 null값이 그대로 저장됨
		assertTrue(memberOptional.isPresent());//null 값 여부 확인(테스트용)
		
		Member member = memberOptional.get();
		System.out.println(member.getMembername());//회원번호로 검색한 회원의 이름 출력
		
	}

}
