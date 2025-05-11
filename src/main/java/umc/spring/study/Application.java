package umc.spring.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.study.service.MissionService.MissionQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);

			Long memberId = 1L;
			Long regionId = 2L;
			int limit = 5;
			int offset = 0;

			System.out.println("Fetching available missions for region ID: " + regionId);
			missionQueryService.getAvailableMissions(memberId, regionId, limit, offset);
		};
	}
}

