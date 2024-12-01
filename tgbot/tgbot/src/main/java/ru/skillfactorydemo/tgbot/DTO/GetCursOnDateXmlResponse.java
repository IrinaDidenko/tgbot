package ru.skillfactorydemo.tgbot.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "GetCursOnDateXMLResponse", namespace = "http://www.cbr.ru/dataservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class GetCursOnDateXmlResponse {
    @XmlElement(name = "GetCursOnDateXmlResult", namespace = "http://www.cbr.ru/dataservice/")
    private GetCursOnDateXmlResult getCursOnDateXmlResult;

}

