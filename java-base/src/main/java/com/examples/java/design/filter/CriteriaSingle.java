package com.examples.java.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *  CriteriaSingle - 过滤单身者
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-25 15:27
 */
public class CriteriaSingle implements Criteria {

    /**
     * 过滤单身用户
     *
     * @param persons 过滤目标列表
     * @return 过滤后的数据
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
