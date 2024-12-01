package ru.skillfactorydemo.tgbot.DTO;

import jakarta.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ValuteCursOnDate")
@Getter
@Setter
public class GetCursOnDateXmlResult {

    @XmlElementWrapper(name = "ValuteData", namespace = "")
    @XmlElement(name ="valuteCursOnData", namespace = "")
    private List<ValuteCursOnDate> valuteData = new ArrayList<>();
}
