
package com.he.maven.module.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>person complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "age",
    "birthday",
    "name"
})
public class Person {

    protected Integer age;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthday;
    protected String name;

    /**
     * ��ȡage���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getAge() {
        return age;
    }

    /**
     * ����age���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setAge(Integer value) {
        this.age = value;
    }

    /**
     * ��ȡbirthday���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * ����birthday���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setBirthday(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    /**
     * ��ȡname���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

}
