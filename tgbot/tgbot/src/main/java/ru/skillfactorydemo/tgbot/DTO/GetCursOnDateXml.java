package ru.skillfactorydemo.tgbot.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name="GetCourseonDateXML", namespace = "http://www.cbr.ru/dataservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class GetCursOnDateXml {
@XmlElement(name = "On_Date", required = true, namespace =  "http://www.cbr.ru/dataservice/")
    protected XMLGregorianCalendar onDate;
}
