package tw.taipei.scteam.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.taipei.scteam.member.domain.bean.MemberBean;

public interface MemberRepository extends JpaRepository<MemberBean, Long> {

  boolean existsByAccount(String account);

  Optional<MemberBean> findByAccount(String account);

}
