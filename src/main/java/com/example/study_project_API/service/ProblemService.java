package com.example.study_project_API.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_project_API.dto.problem.ProblemRequestDto;
import com.example.study_project_API.dto.problem.ProblemResponseDto;
import com.example.study_project_API.model.Part;
import com.example.study_project_API.model.Problem;
import com.example.study_project_API.model.User;
import com.example.study_project_API.repository.PartRepository;
import com.example.study_project_API.repository.ProblemRepository;
import com.example.study_project_API.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성, 스프링의 의존성 주입을 위해 사용
@Transactional(readOnly = true) // 모든 메서드를 읽기 전용 트랜잭션으로 설정
public class ProblemService {
	// 필요한 Repository들을 의존성 주입
	private final ProblemRepository problemRepository;// 문제
	private final UserRepository userRepository;// 유저
	private final PartRepository partRepository;// 분야

	@Transactional // 쓰기 작업이 필요하므로 읽기 전용 해제
	public void createProblem(ProblemRequestDto requestDto) {
		// 1. 요청된 userId로 User 엔티티 조회
		User user = userRepository.findById(requestDto.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		// 2. 요청된 partId로 Part 엔티티 조회
		Part part = partRepository.findById(requestDto.getPartId())
				.orElseThrow(() -> new RuntimeException("Part not found"));

		// 3. Problem 엔티티 생성
		Problem problem = Problem.builder().user(user) // 조회한 User 설정
				.part(part) // 조회한 Part 설정
				.title(requestDto.getTitle()) // 요청에서 받은 제목 설정
				.build();

		// 4. Problem 엔티티 저장
		Problem savedProblem = problemRepository.save(problem);

	}

	// 랜덤으로 문제를 조회하는 메서드
	public List<ProblemResponseDto> getRandomProblems(int count) {
		// 1. Repository에서 랜덤하게 문제들을 조회
		return problemRepository.findRandomProblems(count).stream()
				// 2. 각 Problem 엔티티를 DTO로 변환
				.map(problem -> ProblemResponseDto.builder().id(problem.getId()).title(problem.getTitle())
						.partName(problem.getPart().getPartName()).userName(problem.getUser().getUserId()).build())
				// 3. 리스트로 변환하여 반환
				.collect(Collectors.toList());
	}
}