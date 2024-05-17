package sejong.hackerton.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejong.hackerton.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
