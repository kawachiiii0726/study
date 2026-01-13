package com.example.spring_subject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.SubjectEntity;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectService;
import com.example.demo.SpringSubjectApplication;


@SpringBootTest(classes = SpringSubjectApplication.class)
public class SubjectServiceTest {

	@Autowired
	private SubjectService subjectService;
	
	@MockBean
	private SubjectRepository subjectRepository;
	
	@Test
	void findById_test(){
		SubjectEntity subject = new SubjectEntity();
		subject.setId(1);
		subject.setSubject("国語");
		
		when(subjectRepository.getOne(1)).thenReturn(subject);
		
		SubjectEntity result = subjectService.findById(1);
		
		assertEquals("国語", result.getSubject());
	}
}
