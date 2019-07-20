package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;

    @Test
    public void should_get_name() {
        // given
        String name = "ginsan";
        given(personService.find(argThat((PersonRequest person) -> person.getName().equals(name))))
                .willReturn(new Person("f", "l", BigDecimal.ZERO));
        // when
        String fullName = personController.getName(name);
        // then
        assertThat(fullName).isEqualTo("f,l");
    }
}