package ru.skillfactorydemo.tgbot.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ValuteCursOnDate")
@Getter
@Setter
public class ValuteCursOnDate {
    @XmlElement(name = "vMame")
    private String name;
    @XmlElement(name="vNom")
    private int nominal;
    @XmlElement(name = "vCourse")
    private double course;
    @XmlElement(name = "vCode")
    private String  code;
    @XmlElement(name ="vChCode")
    private String chCode;
}
