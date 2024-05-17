package sejong.hackerton.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejong.hackerton.demo.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByKey(String key);
}
