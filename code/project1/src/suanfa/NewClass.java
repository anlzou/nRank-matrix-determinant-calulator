/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suanfa;

import java.util.Scanner;

/**
 *
 * @author anlzou
 */
public class NewClass {

    //算法1     调试OK_值为正——不正确
    public static double GetLineTran(double[][] p, int n) {
        if (n == 1) {
            return p[0][0];
        }
        double exChange = 1.0; // 记录行列式中交换的次数
        boolean isZero = false; // 标记行列式某一行的最右边一个元素是否为零
        for (int i = 0; i < n; i++) {// i 表示行号
            if (p[i][n - 1] != 0) { // 若第 i 行最右边的元素不为零
                isZero = true;
                if (i != (n - 1)) { // 若第 i 行不是行列式的最后一行
                    for (int j = 0; j < n; j++) { // 以此交换第 i 行与第 n-1 行各元素
                        double temp = p[i][j];
                        p[i][j] = p[n - 1][j];
                        p[n - 1][j] = temp;
                        exChange *= -1.0;
                    }
                }
                break;
            }
        }
        if (!isZero) {
            return 0; // 行列式最右边一列元素都为零，则行列式为零。				
        }
        for (int i = 0; i < (n - 1); i++) {
            // 用第 n-1 行的各元素，将第 i 行最右边元素 p[i][n-1] 变换为 0，
            // 注意：i 从 0 到 n-2，第 n-1 行的最右边元素不用变换
            if (p[i][n - 1] != 0) {
                // 计算第  n-1 行将第 i 行最右边元素 p[i][n-1] 变换为 0的比例
                double proportion = p[i][n - 1] / p[n - 1][n - 1];
                for (int j = 0; j < n; j++) {
                    p[i][j] += p[n - 1][j] * (-proportion);
                }
            }
        }
        return exChange * p[n - 1][n - 1] * GetLineTran(p, (n - 1));
    }

    //算法2     调试Ok
    public static double GetValue(double[][] p, int n) {
        if (n == 1) // 如果是一阶行列式,直接返回该元素
        {
            return p[0][0];
        }
        double sum = 0; // 累加求和变量
        for (int j = 0; j < n; j++) {// 遍历最后一行各元素,p[n - 1][j]
            int pt = (n - 1) + j;  // 符号判断指数
            double[][] p1 = new double[n][n];
            // 此过程是为了把行列式存放到临时数组中，不改变但前行列式
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    p1[row][col] = p[row][col];
                }
            }
            // 此过程，是为了将元素 p[n-1][j] 所在列之后的每一列向前移动一列，为后面获取该元素对应的余子式做准备
            for (int index = 0; index < n - 1; index++) {
                for (int index1 = j; index1 < n - 1; index1++) {
                    p1[index][index1] = p1[index][index1 + 1];
                }
            }
            // 此过程，截取临时数组 p1 左上角 n-1  阶行列式，提取元素 p[n-1][j] 的余子式
            double[][] temp = new double[n - 1][n - 1];
            for (int row = 0; row < n - 1; row++) {
                for (int col = 0; col < n - 1; col++) {
                    temp[row][col] = p1[row][col];
                }
            }
            // 求和：sum += 元素 * 符号 * 余子式
            // 因为，余子式是去除某一元素所在的行和列之后剩下的元素构成的 n-1 阶行列式
            // 即，余子式本质还是行列式，所以需要递归求行列式的值
            sum += p[n - 1][j] * Math.pow(-1, pt) * GetValue(temp, n - 1);
            // System.out.println(p[n - 1][j] + " * " + Math.pow(-1, pt) + " * " + GetValue(p1, n - 1));
        }
        return sum;
    }

}
