package DataStructure;

import java.io.*;
// 字符串哈希方法
public class AcWing831_2 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            char[] p = (" " + in.readLine()).toCharArray();
            int m = Integer.parseInt(in.readLine());
            char[] s = (" " + in.readLine()).toCharArray();


            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}