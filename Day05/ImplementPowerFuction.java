package Day05;
/*
https://leetcode.com/problems/powx-n/description/

mplement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

*/

class Solution {

    private double power(double base, long exponent) {

        // Base case:
        // x^0 = 1
        if (exponent == 0) {
            return 1;
        }

        // Base case:
        // x^1 = x
        if (exponent == 1) {
            return base;
        }

        // Compute power for half exponent
        double halfPower = power(base, exponent / 2);

        // If exponent is even:
        // x^n = (x^(n/2)) * (x^(n/2))
        if (exponent % 2 == 0) {
            return halfPower * halfPower;
        }

        // If exponent is odd:
        // x^n = x * (x^(n/2)) * (x^(n/2))
        return base * halfPower * halfPower;
    }

    public double myPow(double x, int n) {

        // Convert to long to handle:
        // n = Integer.MIN_VALUE
        long exponent = n;

        // For negative powers:
        // x^(-n) = (1/x)^n
        if (exponent < 0) {

            exponent = -exponent;
            x = 1 / x;
        }

        return power(x, exponent);
    }
}