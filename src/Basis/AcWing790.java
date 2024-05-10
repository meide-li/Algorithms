package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 数的三次方根
public class AcWing790 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            double EPS = 1e-8;
            double left = -100, right = 100;
            double k = Double.parseDouble(in.readLine());
            while (right - left > EPS) {
                double mid = (left + right) / 2;
                if (mid * mid * mid >= k) right = mid;
                else left = mid;
            }
            System.out.println(String.format("%.6f", left));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
