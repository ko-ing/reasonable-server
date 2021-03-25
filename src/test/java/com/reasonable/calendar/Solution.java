package com.reasonable.calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Tuple;
import java.awt.desktop.PrintFilesEvent;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class Solution {

    @Test
    public void test() {
        reverse(1124);
    }

    public int reverse(int x) {
        boolean isNegative = (x < 0) ? true : false;
        String[] abX = Integer.toString(Math.abs(x)).split("");

        for (int i= 0; i < abX.length / 2; i ++) {
            String temp = abX[abX.length - i -1];
            abX[abX.length - i -1] = Integer.toString(Integer.parseInt(abX[i]));
            abX[i] = temp;
        }

        int answer = Integer.parseInt(String.join("", abX));

        if (isNegative) return -answer;
        else return answer;
    }
}
