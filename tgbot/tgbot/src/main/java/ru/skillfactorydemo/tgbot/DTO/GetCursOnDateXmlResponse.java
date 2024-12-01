package ru.skillfactorydemo.tgbot.DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "GetCursOnDateXmlResponse", namespace = "http://web.cbr.ru/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class GetCursOnDateXmlResponse {
    @XmlElement(name = "GetCursOnDateXmlResult", namespace =  "http://web.cbr.ru/")
    private GetCursOnDateXmlResult getCursOnDateXmlResult;

}

