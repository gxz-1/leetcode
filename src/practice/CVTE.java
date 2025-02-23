package practice;

import java.util.Scanner;

public class CVTE {
    //压缩重复字符
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
//        //双指针
//        int pre=0,tep=0;
//        StringBuilder sb=new StringBuilder();
//        while (pre<s.length()){
//            int count=0;
//            while (pre<s.length() && s.charAt(pre)==s.charAt(tep)){
//                pre++;
//                count++;
//            }
//            sb.append(s.charAt(tep));
//            sb.append(count);
//            tep=pre;
//        }
//        if(sb.length()>=s.length()){
//        //如果压缩后的字符串长度没有变短，则返回原始字符串。
//            System.out.println(s);
//        }else {
//            System.out.println(sb);
//        }
//    }

    static class Animal{
        public void printAnimalFavoriteFood(){}
    }
    static class Dog extends Animal{
        @Override
        public void printAnimalFavoriteFood() {
            System.out.println("狗喜欢吃骨头");
        }
    }
    static class Cat extends Animal{
        @Override
        public void printAnimalFavoriteFood() {
            System.out.println("猫喜欢吃鱼");
        }
    }
    static class Cow extends Animal{
        @Override
        public void printAnimalFavoriteFood() {
            System.out.println("牛喜欢吃草");
        }
    }
    public static void printAnimalFavoriteFood(Animal animal){
        animal.printAnimalFavoriteFood();
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        Cat cat=new Cat();
        Cow cow=new Cow();
        System.out.println("不同动物喜欢的食物类型：");
        printAnimalFavoriteFood(dog);
        printAnimalFavoriteFood(cat);
        printAnimalFavoriteFood(cow);
    }
}
