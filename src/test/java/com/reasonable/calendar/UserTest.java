package com.reasonable.calendar;

import com.reasonable.calendar.domain.auth.User;
import com.reasonable.calendar.domain.auth.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Tuple;
import java.awt.desktop.PrintFilesEvent;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void test() {
        User user = userRepository.findByUserAccountId("daa05a07-8fac-4641-be8c-de98600d9935");
    }
}
