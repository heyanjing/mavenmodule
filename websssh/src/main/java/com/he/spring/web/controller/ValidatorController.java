package com.he.spring.web.controller;

import com.he.maven.module.utils.Dates;
import com.he.maven.module.utils.Jsons;
import com.he.maven.module.utils.Randoms;
import com.he.spring.entity.Person;
import com.he.spring.web.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 * 在JSR303中已经定义的Constraint如下：
 * 空检查
 *
 * @Null 验证对象是否为null
 * @NotNull 验证对象是否不为null, 无法查检长度为0的字符串
 * @NotBlank 检查约束字符串是不是Null还有被Trim的长度是否大于0, 只对字符串, 且会去掉前后空格.
 * @NotEmpty 检查约束元素是否为NULL或者是EMPTY.
 * <p>
 * Booelan检查
 * @AssertTrue 验证 Boolean 对象是否为 true
 * @AssertFalse 验证 Boolean 对象是否为 false
 * <p>
 * 长度检查
 * @Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
 * @Length(min=, max=)
 * 验证字符串的长度是否在给定的范围之内，包含两端
 * <p>
 * 日期检查
 * @Past 验证 Date 和 Calendar 对象是否在当前时间之前
 * @Future 验证 Date 和 Calendar 对象是否在当前时间之后
 * @Pattern 验证 String 对象是否符合正则表达式的规则
 * <p>
 * 数值检查：建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为"",Integer为null
 * @Min 验证 Number 和 String 对象是否大等于指定的值
 * @Max 验证 Number 和 String 对象是否小等于指定的值
 * @DecimalMax 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
 * @DecimalMin 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
 * @Digits 验证 Number 和 String 的构成是否合法
 * @Digits(integer=,fraction=) 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。
 * @Range(min=, max=) Checks whether the annotated value lies between (inclusive) the specified minimum and maximum.
 * @Range(min=10000,max=50000,message="range.bean.wage") private BigDecimal wage;
 * @Valid递归的对关联对象进行校验, 如果关联对象是个集合或者数组, 那么对其中的元素进行递归校验, 如果是一个map, 则对其中的值部分进行校验.(是否进行递归验证)
 * @CreditCardNumber信用卡验证
 * @Email 验证是否是邮件地址，如果为null,不进行验证，算通过验证。
 * @ScriptAssert(lang= , script=, alias=)
 * @URL(protocol=,host=, port=,regexp=, flags=)
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ValidatorController.class);

    @Autowired
    private PersonService personService;


    private Integer count = 1;

    /**
     * BindingResult 与Errors一样
     */
    @RequestMapping("/save")
    @ResponseBody
    public Person save(@Valid Person p, BindingResult result, Errors errors) {

        if (result.hasErrors()) {
            log.error(Jsons.toJson(result.getAllErrors()));
            log.error(Jsons.toJson(result.getFieldErrors()));
            return null;
        }
        if(errors.hasErrors()){
            log.error(Jsons.toJson(errors.getAllErrors()));
            log.error(Jsons.toJson(errors.getFieldErrors()));
        }


        if (p == null) {
            p = new Person("name" + Dates.newDateString("yyyy-MM-dd_HH:mm:ss.SSS"), count++, Dates.newDate(), Randoms.getInt(5));
        }
        return this.personService.save(p);
    }
}
