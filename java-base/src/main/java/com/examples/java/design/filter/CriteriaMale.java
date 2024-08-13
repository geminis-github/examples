package com.examples.java.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的 Criteria 类，过滤男性
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-25 15:27
 */
public class CriteriaMale implements Criteria {

    /**
     * 过滤男性用户
     *
     * @param persons 过滤目标列表
     * @return 过滤后的数据
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }

}
