package tw.taipei.scteam.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.taipei.scteam.member.domain.bean.MemberDetailBean;

public interface MemberDetailRepository extends JpaRepository<MemberDetailBean, Long> {
}
