package JavaUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SeleniumJavautil {


    public String getDateNowFormat() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public String getTimeNowFormat() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public Double convertStrigToDouble(String value) {
        return Double.parseDouble(value.replace("R$", "").
                replace(",", ".").trim());
    }


}
