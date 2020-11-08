package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-19 20:01
 */
public class 面试题_16_09_运算 {

    public static void main(String[] args) {
/*
["Operations","minus","minus","divide","minus","minus","divide","minus","minus","minus","minus","minus","divide","minus","divide","minus","divide","minus","divide","minus","minus","multiply","divide","divide","minus","multiply","divide","divide","minus","minus","divide"]
[[],[-63658,632122],[-8167350,-259939104],[243880,-4540],[205,-1882195],[32825,-34121287],[62900344,346],[-6,-729401],[-39439,7452154],[5811,-1066359],[-484,-668526],[3594,272357947],[88510724,-3244776],[723553,6],[-9142,2],[-168001,-14003685],[4377,-15525],[2177,-61],[-887085,-8318200],[4205,343],[-7448,1946576635],[934,-7],[980,-534875],[-9,-805],[6,-3040],[6,395],[747138413,-651],[1880730178,-507874261],[559134,-36],[55,2820],[563683068,-49]]

[null,-695780,251771754,-53,1882400,34154112,181792,729395,-7491593,1072170,668042,-272354353,-27,723547,-4570,13835684,0,2238,0,3862,-1946584083,-6538,0,0,3046,2370,-1147678,-3,559170,-2765,-11503736]

["Operations","minus","minus","multiply","minus","minus","divide","multiply","minus","minus","divide","multiply","minus","minus","divide","multiply","divide","divide","multiply","divide","divide","multiply","minus","divide","minus","minus","divide","multiply","minus","divide","divide","multiply","divide","divide","divide","minus","divide","multiply","multiply","minus"]
[[],[73,2192],[-3413,-83],[-653939,-772],[1393853667,-6],[-86897493,-263823],[-612429016,1446792151],[5631,93],[-329992536,-18278561],[-5,-1452597680],[-53699228,2724],[7,-9],[-675912,-7],[108719094,6170],[-33954929,-247],[2558506,-99],[3766,-9685],[72579,5613],[-1,77],[-186378544,938],[-60,5],[492647,-67],[406,448562],[1,-1993014488],[-5,91],[-869,-383085],[-2859304,5164049],[-1936250313,1],[458,1531467072],[-3329512,3121],[3,-68],[-406577,375],[-1870,1],[10336695,-828],[1834157185,1594413306],[3646,463767],[347783578,-933857],[-65,285],[2038,-53028],[109119,63853]]

 */


        Operations operations = new Operations();
        int divide = operations.divide(-1870,1);
        System.out.println(divide);
//
//        System.out.println(operations.minus(7, -744));
//        System.out.println(operations.minus(-7623,-475));
//        System.out.println(operations.divide(-13969484,-5));
//        System.out.println(operations.multiply(272,4));
//        System.out.println(operations.multiply(-534555,-9));
//        System.out.println(operations.minus(1060075809,663));
//        System.out.println(operations.minus(-955876987,2));
//        System.out.println(operations.divide(-11954206,5401));

    }


    static class Operations {

        public Operations() {

        }

        public int minus(int a, int b) {
            b = (~b) + 1;
            return a + b;
        }

        public int multiply(int a, int b) {
            if (a == 0 || b == 0) {
                return 0;
            }

            int sign;
            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                sign = 1;
            } else {
                sign = -1;
            }

            if (a < 0) {
                a = (~a) + 1;
            }
            if (b < 0) {
                b = (~b) + 1;
            }

            if (a == 1 || b == 1) {
                if (sign < 0) {
                    if (a == 1) {
                        return (~b) + 1;
                    } else {
                        return (~a) + 1;
                    }
                } else {
                    if (a == 1) {
                        return b;
                    } else {
                        return a;
                    }
                }
            }

            int result = 0;
            int length = a < b ? a : b;
            int base = a < b ? b : a;
            for (int i = 0; i < length; ++i) {
                result += base;
            }

            if (sign < 0) {
                return (~result) + 1;
            } else {
                return result;
            }
        }

        public int divide(int a, int b) {
            // 0 判断
            if (a == 0 || b == 0) {
                return 0;
            }

            // 获取结果符号
            int sign;
            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                sign = 1;
            } else {
                sign = -1;
            }

            // 除数特殊值: Integer.MIN_VALUE 判断
            if (b == Integer.MIN_VALUE) {
                if (a == Integer.MIN_VALUE) {
                    return 1;
                } else {
                    return 0;
                }
            }

            // 除数特殊值: 1 判断
            if (b == 1) {
                return a;
            }
            // 除数特殊值: -1 判断
            if (b == -1) {
                return (~a) + 1;
            }

            // 除数取绝对值
            if (b < 0) {
                b = (~b) + 1;
            }

            // 对 被除数 进行特殊值处理: Integer.MIN_VALUE
            boolean aIsMin = false;
            if (a == Integer.MIN_VALUE) {
                aIsMin = true;
                a += 1;
            }

            // 被除数取绝对值
            if (a < 0) {
                a = (~a) + 1;
            }

            if (!aIsMin && a == b) {
                if (sign < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (a < b) {
                return 0;
            }

            int result = 0;

            // 快速除法的中间值
            int[] arr = new int[32];
            int[] res = new int[32];
            int validIndex = 0;
            arr[0] = (~b) + 1;
            res[0] = 1;
            for (int i = 0; i < 31; ++i) {
                long value = (long)arr[i] + (long)arr[i];
                if (value <= Integer.MIN_VALUE || value < (~a) + 1) {
                    break;
                }
                arr[i + 1] = arr[i] + arr[i];
                res[i + 1] = res[i] + res[i];
                validIndex = i + 1;
            }

            // 进行除法计算
            for (int i = validIndex; i >= 0 && a >= b; i = i + (-1)) {
                int curNegative = arr[i];
                int curPositive = (~curNegative) + 1;
                while (a >= curPositive) {
                    result += res[i];
                    a += arr[i];
                }
                if (i != validIndex && aIsMin) {
                    a += 1;
                }
            }
            if (sign < 0) {
                return (~result) + 1;
            } else {
                return result;
            }
        }
    }

}
