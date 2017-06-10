package com.koou.enums;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by yunqiangdi on 3/7/2017.
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em =
                new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("KITCHEN fire!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("BATHROOM fire!");
            }
        });

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + " : ");
            e.getValue().action();
        }
    }
}
