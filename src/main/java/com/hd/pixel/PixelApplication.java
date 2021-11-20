package com.hd.pixel;

import com.hd.pixel.domain.Board;
import com.hd.pixel.domain.User;
import com.hd.pixel.domain.enums.BoardType;
import com.hd.pixel.repository.BoardRepository;
import com.hd.pixel.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class PixelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("havi")
					.password("test")
					.email("havi@gmail.com")
					.createdDate(LocalDateTime.now())
					.build());

			IntStream.rangeClosed(1, 200).forEach(index ->
					boardRepository.save(Board.builder()
							.title("게시글"+index)
							.subTitle("순서"+index)
							.content("컨텐츠")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.user(user).build())
			);
		};
	}
}
