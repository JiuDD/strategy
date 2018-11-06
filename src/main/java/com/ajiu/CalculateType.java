package com.ajiu;

/**
 * description: 策略模式的理念：“分离算法、选择实现”
 *      该接口为计算器的计算方法接口，规定了计算方法。接口的实现类，实现了策略模式的“分离算法”功能
 * @author: JiuDongDong
 */
public interface CalculateType {
    // 对2个数进行计算，实现类有4个：加、减、乘、除
    int calculate(int a, int b);
}

// description: 计算类型的策略实现类：加法
class PlusCalculate implements CalculateType {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

// description: 计算类型的策略实现类：减法
class MinusCalculate implements CalculateType {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

// description: 计算类型的策略实现类：乘法
class MultiplyCalculate implements CalculateType {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

// description: 计算类型的策略实现类：除法
class DivideCalculate implements CalculateType {
    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}

/**
 * description: 计算器上下文，通过此上下文 “选择算法” ，起到策略模式的“选择实现”的功能
 * @author: JiuDongDong
 */
class CalculateContext {
    // 计算器类型，可以为：加法、减法、乘法、除法
    private CalculateType calculateType = null;

    // 根据入参选择计算器
    public CalculateType getCalculateType(int type) {
        // 以下根据入参选择计算器
        if (1 == type) this.calculateType = new PlusCalculate();
        if (2 == type) this.calculateType = new MinusCalculate();
        if (3 == type) this.calculateType = new MultiplyCalculate();
        if (4 == type) this.calculateType = new DivideCalculate();
        return calculateType;
    }

    // 测试方法
    public static void main(String[] args) {
        CalculateContext calculateContext = new CalculateContext();
        // 选择计算器: 加法
        CalculateType plusCalculate = calculateContext.getCalculateType(1);// 加法
        int result1 = plusCalculate.calculate(3, 4);// result1 = 7

        // 选择计算器: 乘法
        CalculateType multiplyCalculate = calculateContext.getCalculateType(3);// 乘法
        int result2 = multiplyCalculate.calculate(5, 7);// result2 = 35
    }
}