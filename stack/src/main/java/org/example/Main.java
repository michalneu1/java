package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Person> stackP = new Stack<>();
        stackP.push(new Person("44444444444"));
        stackP.push(new Person("44444444443"));
        stackP.push(new Person("44444444442"));
        System.out.println(stackP.getSize());
        stackP.remove(new Person("44444444443"));
        System.out.println(stackP.getSize());
        System.out.println(stackP.pop());
        System.out.println(stackP.pop());
        System.out.println(stackP.pop());


        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.remove(2);

        System.out.println("Size: " + stack.getSize());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}