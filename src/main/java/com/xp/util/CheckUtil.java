package com.xp.util;

import com.xp.model.vo.RegisterVO;

/**
 * 校验工具类
 * <p>
 * create by    2020-07-16  19:!2
 *
 * @author xp
 */
public class CheckUtil {

    /**
     * 校验字符串是否为空
     * @param str   待校验的字符串
     * @return 为空则返回true，否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 校验对象是否为空
     * @param object    待校验的对象
     * @return  为空咋返回 true ，否则返回 false
     */
    public static boolean isEmpty(Object object) {
        return object == null;
    }

    /**
     * 校验 Integer 是否为空
     * @param integer   待校验的 Integer 对象
     * @return  为空或则是小于0，则返回true 否则返回false
     */
    public static boolean isEmpty(Integer integer) {
        return integer == null || integer <= 0;
    }

    /**
     * 校验 注册VO 实体类是否符合规范
     * @param registerVO    注册 VO 对象
     * @return 返回校验的字符串信息,若校验成功则返回空字符串，否则返回对应的信息
     */
    public static String checkRegisterVO(RegisterVO registerVO){
        if (registerVO.getAccount() == null || registerVO.getAccount().isEmpty()){
            return "用户名不能为空";
        }
        if (CheckUtil.isEmpty(registerVO.getPassword())){
            return "密码不能为空";
        }
        if (isEmpty(registerVO.getSurePassword())){
            return "确认密码不能为空";
        }
        if (isEmpty(registerVO.getEmail())){
            return "邮箱号不能为空";
        }
        if (checkEmail(registerVO.getEmail())){
            return "邮箱不符合格式";
        }
        if (isEmpty(registerVO.getTel())){
            return "手机号不能为空";
        }
        if (checkPhone(registerVO.getTel())){
            return "手机号格式不正确";
        }
        if (isEmpty(registerVO.getUserName())){
            return "用户名不能为空";
        }
        return "";
    }

    public static boolean strLength(String str) {
        return str.matches("^\\w{6,20}$");
    }

    public static Integer checkPageIndex(String pageIndexStr) {
        int pageIndex = 1;
        if (!isEmpty(pageIndexStr)) {
            try {
                pageIndex = Integer.parseInt(pageIndexStr);
                if (pageIndex <= 0) {
                    pageIndex = 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pageIndex;
    }

    public static boolean checkCardId(String cardId) {
        return cardId.matches("^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$");
    }

    public static boolean checkEmail(String email) {
        return email.matches("^\\w+@\\w{2,3}\\.\\w{2,6}$");
    }

    public static boolean checkPhone(String phone) {
        return phone.matches("^1[3|5|8]\\d{9}$");
    }

    public static boolean checkQQNum(String qqNum) {
        return qqNum.matches("^\\d{6,}$");
    }

    public static boolean checkPostCode(String postCode) {
        return postCode.matches("^[1-9]\\d{5}$");
    }


}
