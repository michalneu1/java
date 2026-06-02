package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Double inputA;
        Double inputB;
        char sign= ' ';
        double result;
        while (true){

            System.out.println("podaj liczbe a");
            inputA= Double.parseDouble(reader.readLine());
            if(!inputA.getClass().equals("class java.lang.Double")){
                System.out.println("zła wartość");
                continue;
            }
            System.out.println(inputA.getClass());
            System.out.println("podaj liczbe b");
            inputB= Double.parseDouble(reader.readLine());
            if(!inputB.getClass().equals("class java.lang.Double")){
                System.out.println("zła wartość");
                continue;
            }
            System.out.println("podaj operacje");
            sign = (char) reader.read();

            switch (sign){
                case '+'->result=inputA+inputB;
                case '-'->result=inputA-inputB;
                case '*'->result=inputA*inputB;
                case '/'->{
                    if(inputB==0){
                        continue;
                    }
                    result=inputA/inputB;
                }
                case '%'->result=inputA%inputB;
                case '^'->result=Math.pow(inputA,inputB);
                default -> result=0;
            }

            System.out.println("wynik: " + result);
            String description=result%2==0?"Ostatni wynik jest parzysty":"Ostatni wynik jest nieparzysty";
            String isPositive=result>0?"Ostatni wynik jest dodatni":"Ostatni wynik jest ujemny";
            System.out.println(isPositive);
            System.out.println(description);
            System.out.println("Czy wykonać kolejne działanie? y/n");
            String answer =  reader.readLine();
            answer =  reader.readLine();
            System.out.println(answer);

            if(answer.equals("n")) {
                System.out.println("koniec");
                break;
            }
        }



    }
}