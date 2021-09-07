package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class Transform {

    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\21\\Desktop\\input.txt"));
            String s = "";
            while( (s = reader.readLine())!=null ){
                System.out.println(underscoreName(s));
            }
        }catch (Exception e){
            System.out.println("error!");
        }

    }

    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成小写
            result.append(name.substring(0, 1).toLowerCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                if(s.equals("_")){
                    result.append(s);
                    continue;
                }
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0)) && !name.substring(i-1,i).equals("_")) {
                    result.append("_");
                }
                // 其他字符直接转成小写
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }
}
