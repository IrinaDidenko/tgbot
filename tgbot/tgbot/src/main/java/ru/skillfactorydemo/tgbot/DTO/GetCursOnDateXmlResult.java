package ru.skillfactorydemo.tgbot.DTO;

import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="GetCursOnDateXmlResult ")
@Getter
@Setter
public class GetCursOnDateXmlResult {

    @XmlElementWrapper(name = "ValuteData", namespace = "")
    @XmlElement(name ="ValuteCursOnDate", namespace = "")
    private List<ValuteCursOnDate> valuteData  = new ArrayList<>();
}
