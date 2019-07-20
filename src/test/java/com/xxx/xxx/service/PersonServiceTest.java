package com.xxx.xxx.service;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.SalaryCalculator;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeUnit.class, SalaryCalculator.class})
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;


    @Before
    public void setUp() throws Exception {
        Method sleep = Thread.class.getMethod("sleep", long.class);
        PowerMockito.replace(sleep)
                .with((proxy, method, args) -> null);
    }

    @Test
    public void should_get_none_when_is_not_james() {
        // given
        PersonRequest request = new PersonRequest("ginsan");
        // when
        Person person = personService.find(request);
        // then
        Person result = new Person("None", "None", BigDecimal.ZERO);
        assertThat(person).isEqualToComparingFieldByField(result);
    }

    @Test
    public void should_get_person_when_is_james() throws Exception {
        // given
        PersonRequest request = new PersonRequest("James");
        // when
        Person person = personService.find(request);
        // then
        Person result = new Person("Merson", "James", BigDecimal.valueOf(20));
        assertThat(person).isEqualToComparingFieldByField(result);

    }
}
