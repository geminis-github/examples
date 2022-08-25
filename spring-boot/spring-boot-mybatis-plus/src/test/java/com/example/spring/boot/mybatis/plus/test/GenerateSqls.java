package com.example.spring.boot.mybatis.plus.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * 生产test_user表数据
 */
public class GenerateSqls {

    /**
     * 主键ID
     */
    public static long id() {
        return worker.nextId();
    }

    /**
     * 用户类型
     */
    public static int userType() {
        return dom.nextInt(100) + 1;
    }

    /**
     * 昵称
     */
    public static String nickName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 身份证号码
     */
    public static String cardNumber () {
        return cre.getRandomID();
    }

    /**
     * 真实姓名
     */
    public static String realName () {
        return randomName.randomName(dom.nextBoolean(), (dom.nextInt(3) + 2));
    }

    /**
     * 性别
     */
    public static boolean sex () {
        return dom.nextBoolean();
    }

    /**
     * 户籍地
     */
    public static String censusRegister () {
        return CITY[dom.nextInt(CITY.length)];
    }

    /**
     * 生日
     */
    public static LocalDateTime birthday () {
        return createTime();
    }

    /**
     * 邮箱
     */
    public static String email () {
        int prefix = dom.nextInt(999999999) + 100000;
        String email = prefix + "@" + EMAIL_SUFFIX[dom.nextInt(EMAIL_SUFFIX.length)] + ".com";
        return email;
    }

    /**
     * 手机号码
     */
    public static String mobile () {
        String mobile = "1" + MOBILE_PREFIX[dom.nextInt(MOBILE_PREFIX.length)] + String.format("%09d", dom.nextInt(999999999));
        return mobile;
    }

    /**
     * 微信号
     */
    public static String weChartId () {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9);
    }

    /**
     * QQ号码
     */
    public static String qq () {
        return String.valueOf(dom.nextLong(9999999999L) + 100000);
    }

    /**
     * 兴趣爱好
     */
    public static String hobby () {
        int size = dom.nextInt(INTERESTS.length);
        if (size == 0) {
            size = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            String item = ",";
            String one = INTERESTS[dom.nextInt(INTERESTS.length)];
            if (i != size -1) {
                sb.append(one + item);
            } else {
                sb.append(one);
            }
        }
        return sb.toString();
    }

    /**
     * 工作地
     */
    public static String workingLocation () {
        return CITY[dom.nextInt(CITY.length)];
    }

    /**
     * 工资
     */
    public static BigDecimal salary () {
        return new BigDecimal(dom.nextDouble(30000)).setScale(3, BigDecimal.ROUND_DOWN);
    }

    /**
     * 职业
     */
    public static String occupation () {
        return OCCUPATIONS[dom.nextInt(OCCUPATIONS.length)];
    }

    /**
     * 创建时间
     */
    public static LocalDateTime createTime () {
        int year = dom.nextInt(40) + 1980;
        int month = dom.nextInt(12) + 1;
        int day = dom.nextInt(27) + 1;
        int hour = dom.nextInt(24);
        int minute = dom.nextInt(60);
        int second = dom.nextInt(60);
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static String sql = "insert into test_user values ( '${id}', '${sn}', '${nickname}', '${card_number}', '${real_name}', '${sex}', '${census_register}', '${birthday}','${email}', '${mobile}', '${we_chart_id}', '${qq}', '${hobby}', '${working_location}', '${salary}', '${occupation}', 0, 0, '${birthday}', now(), 0 );\n";
    static String[] CITY = new String[]{"渝中区", "万州区", "大渡口区", "江北区", "沙坪坝区", "九龙坡区", "南岸区", "北碚区", "万盛区", "双桥区", "渝北区", "巴南区", "涪陵区", "黔江区", "长寿区", "江津市", "合川市", "南川市", "綦江县", "潼南县", "铜梁县", "大足县", "壁山县", "垫江县", "荣昌县", "武隆县", "丰都县", "城口县", "梁平县", "开县", "巫溪县", "巫山县", "奉节县", "云阳县", "忠县", "酉阳县", "石柱县", "秀山县", "彭水县", "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "丰台区", "石景山区", "海淀区", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "密云县", "延庆县", "黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区", "杨浦区", "闵行区", "嘉定区", "浦东新区", "宝山区", "金山区", "松江区", "青浦区", "南汇区", "奉贤区", "崇明县", "和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区", "东丽区", "西青区", "津南区", "北辰区", "武清区", "宝坻区", "蓟县", "宁河县", "静海县"};
    static String[] OCCUPATIONS = new String[]{"行政主管", "企业主管", "经理人", "土木营造监工", "天文学家", "电脑程式设计人员", "系统分析师", "道景师", "建筑师", "交通规划师", "化学工程技术师", "土木工程师", "造景师", "测量员", "销售工程师", "工业工程师", "品质管制工程师", "陶瓷技师", "药师", "兽医师", "公共卫生医师", "中医师", "护理佐理员", "护理师", "学前教育教师", "特殊教育教师", "程序员"};
    static String[] INTERESTS = new String[] { "玩游戏", "看电影", "看动漫", "看美漫", "看直播", "看新闻", "跑步", "仰卧起坐", "扶老奶奶", "兼职", "跳绳", "开车", "弹钢琴", "弹吉他", "拉小提琴", "玩4399", "英雄联盟", "王者荣耀", "CF", "DNF", "QQ飞车", "绝地求生", "举重", "爬山", "旅游", "逛街", "写字", "看书", "三国杀", "魔兽世界", "CSGO" };
    static String[] MOBILE_PREFIX = new String[] { "3", "5", "7", "9" };
    static String[] EMAIL_SUFFIX = new String[] { "qq", "163", "huawei", "vivo", "oppo", "xiaomi", "microsoft", "stream", "tiktok", "apple", "amazon", "amd", "intel", "ibm", "nvidia" };
    static Random dom = new Random();
    static RandomName randomName = new RandomName();
    static IdWorker worker = new IdWorker(1,1,1);
    static CreateIDCardNo cre = new CreateIDCardNo();

}
