package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-11-14 15:44
 */
public class 面试题_16_10_生存人数 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] death = {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901};
        int[] birth = {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};
        System.out.println(solution.maxAliveYear(birth, death));

    }

    static class Solution {

        private static class Person implements Comparable<Person> {
            int birth;
            int death;
            public Person(int birth, int death) {
                this.birth = birth;
                this.death = death;
            }

            @Override
            public int compareTo(Person person) {
                int birthDiff = this.birth - person.birth;
                if (birthDiff == 0) {
                    return Integer.compare(this.death, person.death);
                }
                return birthDiff;
            }
        }

        public int maxAliveYear(int[] birth, int[] death) {
            if (birth == null || birth.length == 0 || death == null || death.length == 0) {
                return 0;
            }

            List<Person> people = new ArrayList<>(birth.length);
            for (int i = 0; i < birth.length; ++i) {
                people.add(new Person(birth[i], death[i]));
            }
            Collections.sort(people);

            int result = people.get(0).birth;
            int livingPeople = 1;
            for (int i = 1; i < people.size(); ++i) {
                int curLivingPeople = 1;
                for (int j = 0; j < i; ++j) {
                    if (people.get(j).death >= people.get(i).birth) {
                        ++curLivingPeople;
                    }
                }
                if (curLivingPeople > livingPeople) {
                    livingPeople = curLivingPeople;
                    result = people.get(i).birth;
                }
            }
            return result;
        }
    }
}
