package com.aurionpro.mathutil.test;

import java.lang.reflect.Method;

import com.aurionpro.mathutil.model.MathUtil;

public class MathUtilTest {
	public static void main(String[] args) throws Exception {
        // Create instance of MathUtil
        MathUtil util = new MathUtil();

        // Get Class object
        Class<?> clazz = MathUtil.class;

        // Get Method object for square(int)
        Method method = clazz.getDeclaredMethod("square", int.class);

        // Invoke method with argument 5
        Object result = method.invoke(util, 5);

        // Print result
        System.out.println("Square of 5 is: " + result);
    }
}
