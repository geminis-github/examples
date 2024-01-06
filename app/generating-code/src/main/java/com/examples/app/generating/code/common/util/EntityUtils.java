package com.examples.app.generating.code.common.util;

import com.examples.app.generating.code.common.base.BasePlusEntity;
import com.examples.app.generating.code.common.exception.ServiceException;
import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.domain.GenTableDO;
import com.examples.app.generating.code.entity.GenColumn;
import com.examples.app.generating.code.entity.GenTable;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体类操作工具
 *
 * @author liangjinlong-CT00345
 * @date 2023-10-13 9:01
 */
@SuppressWarnings("ALL")
public class EntityUtils {

    private static final int DEFAULT_CLASS_SIZE = 200;
    private static final Map<Class<?>, Class<?>> PLUS_TO_RAW_MAP = new HashMap<>(DEFAULT_CLASS_SIZE);
    private static final Map<Class<?>, Class<?>> RAW_TO_PLUS_MAP = new HashMap<>(DEFAULT_CLASS_SIZE);
    private static final Map<Class<?>, Field[]> CLASS_TO_FIELD_MAP = new HashMap<>(DEFAULT_CLASS_SIZE);
    private static final Map<Class<?>, Map<String, String>> CLASS_FIELD_REAL_NAME_MAP = new HashMap<>(DEFAULT_CLASS_SIZE);

    static {
        // 字段信息
        PLUS_TO_RAW_MAP.put(GenColumnDO.class, GenColumn.class);
        // 表格信息
        PLUS_TO_RAW_MAP.put(GenTableDO.class, GenTable.class);
        // 缓存信息
        PLUS_TO_RAW_MAP.forEach((k, v) -> {
            RAW_TO_PLUS_MAP.put(v, k);
            CLASS_TO_FIELD_MAP.put(k, getAllDeclaredFieldsIncludingSuperclasses(k));
            CLASS_TO_FIELD_MAP.put(v, getAllDeclaredFieldsIncludingSuperclasses(v));
        });
    }

    /**
     * 把plus对象转换为raw对象
     *
     * @param plus plus对象
     * @return raw对象实例
     * @param <R> 原始对象类型
     * @param <P> plus对象类型
     */
    public static <R, P extends BasePlusEntity> R convertToRaw(P plus) {
        Class<R> rClass = (Class<R>) PLUS_TO_RAW_MAP.get(plus.getClass());
        if (rClass == null) {
            throw new ServiceException("plus类型不在映射表里");
        }
        try {
            // 实例化Raw实体信息
            R rawEntity = rClass.newInstance();
            // 根据名称copy属性值
            BeanUtils.copyProperties(plus, rawEntity);
            Map<String, String> realFieldMap = CLASS_FIELD_REAL_NAME_MAP.get(plus.getClass());
            if (realFieldMap != null && !realFieldMap.isEmpty()) {
                // 处理特殊情况
                for (Field rField : CLASS_TO_FIELD_MAP.get(rClass)) {
                    String realFieldName = realFieldMap.get(rField.getName());
                    for (Field pField : CLASS_TO_FIELD_MAP.get(plus.getClass())) {
                        if (pField.getName().equals(realFieldName)) {
                            rField.setAccessible(true);
                            pField.setAccessible(true);
                            Object pValue = pField.get(plus);
                            rField.set(rawEntity, pValue);
                        }
                    }
                }
            }
            return rawEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把原始对象转换为plus对象
     *
     * @param raw 原始对象
     * @return plus对象实例
     * @param <R> 原始对象类型
     * @param <P> plus对象类型
     */
    public static <R, P extends BasePlusEntity> P convertToPlus(R raw) {
        // 获取Plus实体字节码
        Class<P> pClass = (Class<P>) RAW_TO_PLUS_MAP.get(raw.getClass());
        if (pClass == null) {
            throw new ServiceException("raw类型不在映射表里");
        }
        try {
            // 实例化Plus实体信息
            P plusEntity = pClass.newInstance();
            // 根据名称copy属性值
            BeanUtils.copyProperties(raw, plusEntity);
            // 处理特殊情况
            Map<String, String> realFieldMap = CLASS_FIELD_REAL_NAME_MAP.get(pClass);
            if (realFieldMap != null && !realFieldMap.isEmpty()) {
                for (Field rField : CLASS_TO_FIELD_MAP.get(raw.getClass())) {
                    String realFieldName = realFieldMap.get(rField.getName());
                    for (Field pField : CLASS_TO_FIELD_MAP.get(pClass)) {
                        if (pField.getName().equals(realFieldName)) {
                            rField.setAccessible(true);
                            pField.setAccessible(true);
                            Object rValue = rField.get(raw);
                            pField.set(plusEntity, rValue);
                        }
                    }
                }
            }
            return plusEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <R, P extends BasePlusEntity> List<P> convertToPlusList(List<R> rawList) {
        List<P> pList = new ArrayList<>(rawList.size());
        for (R raw : rawList) {
            pList.add(convertToPlus(raw));
        }
        return pList;
    }

    public static <R, P extends BasePlusEntity> List<R> convertToRawList(List<P> plusList) {
        List<R> rList = new ArrayList<>();
        for (P plus : plusList) {
            rList.add(convertToRaw(plus));
        }
        return rList;
    }

    /**
     * 根据字节码获取当前类，以及其所有父类的declared字段
     *
     * @param clazz 字节码
     * @return 所有父类的字段
     */
    public static Field[] getAllDeclaredFieldsIncludingSuperclasses(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        // 遍历该类及其所有父类
        for (Class<?> currentClass = clazz; currentClass != null; currentClass = currentClass.getSuperclass()) {
            fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
        }
        return fields.toArray(new Field[0]);
    }

}
