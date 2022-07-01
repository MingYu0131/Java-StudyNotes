package com.JavaStudy.HspMiddleJavaTest.Enum;

/**
 * @author mingyu
 * @version 1.0
 */
public class EnumExercise {
    public static void main(String[] args) {
        for (Week week: Week.values()){
            System.out.println(week.getDayName());
        }
    }
}


enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期天");

    private String dayName;

    Week(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return "Week{" +
                "dayName='" + dayName + '\'' +
                '}';
    }

    public String getDayName() {
        return dayName;
    }
}
