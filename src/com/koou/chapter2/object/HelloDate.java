package com.koou.chapter2.object;

import java.util.Date;

/** The first Thinking in Java example program.
 * Displays a string and today's date.
 * @author yunqiangdi
 * @version 1.0
 */
public class HelloDate {
    /** Entry point to class & application.
     * @param args arrays of string arguments
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
    }
}
