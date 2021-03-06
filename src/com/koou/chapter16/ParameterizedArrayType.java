package com.koou.chapter16;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-20 4:59 PM
 */
public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles= {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParameter.f(ints);
        doubles = MethodParameter.f(doubles);
    }
}
