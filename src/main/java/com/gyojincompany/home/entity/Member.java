package com.gyojincompany.home.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//JPA설정
@Entity
@Table(name = "jpa_member")//엔티티 클래스와 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "JPAMEMBER_SEQ_GENERATOR",//시퀀스 제너레이터 이름
		sequenceName = "jpamember_seq",//시퀀스 이름
		initialValue = 1,//시작값
		allocationSize = 1//증가치
)

public class Member {
	
	@Id //매핑될 테이블의 기본키로 설정
	@Column(name = "membernum") //실제로 db 테이블의 필드이름을 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPAMEMBER_SEQ_GENERATOR")
	private Long membernum;//회원번호(1부터 1씩 증가하면서 시퀀스로 들어가는 회원번호)->기본키
	
	@Column(name = "memberid", length = 20, nullable = false) //실제로 db 테이블의 필드이름을 설정
	private String memberid;//회원아이디
	
	@Column(name = "memberpw", length = 20, nullable = false) //실제로 db 테이블의 필드이름을 설정
	private String memberpw;//회원비밀번호
	
	@Column(name = "membername", length = 30, nullable = false) //실제로 db 테이블의 필드이름을 설정
	private String membername;//회원이름
	
	@Column(name = "memberage") //실제로 db 테이블의 필드이름을 설정
	private int memberage;//회원나이

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(Long membernum, String memberid, String memberpw, String membername, int memberage) {
		super();
		this.membernum = membernum;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.memberage = memberage;
	}

	public Long getMembernum() {
		return membernum;
	}

	public void setMembernum(Long membernum) {
		this.membernum = membernum;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberpw() {
		return memberpw;
	}

	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public int getMemberage() {
		return memberage;
	}

	public void setMemberage(int memberage) {
		this.memberage = memberage;
	}
	
	

}
