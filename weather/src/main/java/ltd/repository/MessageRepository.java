package ltd.repository;

import ltd.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 短信
 *
 * songshu 2017/11/23 15:17
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
