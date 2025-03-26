package sort;

import java.util.*;

class student{
    int id;
    int age;
    student(int id,int age){
        this.id=id;
        this.age=age;
    }
}
//java提供的排序的接口
public class JavaSort {
    public static void main(String[] args) {
        student[] students= {
                new student(5,25),
                new student(8,16),
                new student(3,17)
        };
        List<student> studentList=new ArrayList<>();
        studentList.add(new student(5,25));
        studentList.add(new student(8,16));
        studentList.add(new student(3,17));
        //1.对于数组使用 Arrays.sort 对于集合使用 变量名.sort
        Arrays.sort(students,Comparator.comparingInt(a -> a.age));
        studentList.sort(Comparator.comparingInt((student stu) -> stu.age));
        //2.自定义排序
        //2.1 对数组降序排序（注意Comparator不支持int，要用Integer）
        Integer[] arr={1,7,8,9,22};
        Arrays.sort(arr, Comparator.comparingInt(a -> -a));
        //2.2 按id升序 按age降序
        Arrays.sort(students, Comparator.comparingInt((student s) -> s.id).thenComparingInt((student s) -> -s.age));
        studentList.sort(Comparator.comparingInt((student s)->s.id).thenComparingInt((student s)->-s.age));
    }
}
