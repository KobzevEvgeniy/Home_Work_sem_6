package org.example;
//
//Урок 6. Хранение и обработка данных ч3: множество коллекций Set
//        Разработать программу, имитирующую поведение коллекции HashSet.
//        В программе создать метод add добавляющий элемент, метод toString возвращающий
//        строку с элементами множества и метод позволяющий читать элементы по индексу.
//        *Реализовать все методы из семинара.
//        Формат данных Integer.

import jdk.jfr.DataAmount;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySet mySet= new MySet();                             //Инициализация метода
        System.out.print("Проверяем множество на наличие элементов, пуcтое-true: ");
        System.out.println(mySet.isEmpty());
        System.out.println("Добавляем 4 элемента в множество: ");
        System.out.print("1-й "+ mySet.add(1)+" | ");         // добавляем 1-й элемент
        System.out.print("2-й"+mySet.add(12)+" | ");          // добавляем 2-й элемент
        System.out.print("3-й"+mySet.add(123)+" | ");         // добавляем 3-й элемент
        System.out.println("4-й"+mySet.add(1234)+" | ");      // добавляем 4-й элемент
        System.out.print("Проверяем множество на наличие элементов, после добавления,пуcтое-true: ");
        System.out.println(mySet.isEmpty());
        System.out.print("Удаляем элемент, если есть и удалили-true: ");
        System.out.println(mySet.del(1234));          // удаляем 3-й элемент
        System.out.print("Проверяем есть ли в множестве такой элемент, есть-true: ");
        System.out.println(mySet.contains(1));
        System.out.print("Вытягиваем по индексу элемент (2-й): ");
        System.out.println(mySet.get(2));
        System.out.println("Достаем все элементы множества: ");
        Iterator <Integer> iterator=  mySet.iterator();    //итератор, замена for, но без указания длины массива
        while (iterator.hasNext()){
            int i= iterator.next();
            System.out.print(i+"  ");                      //печатаем элементы, на которые указывают ссылки итератора
        }


    }
}

class MySet{
    HashMap <Integer, Object> myHashMap= new HashMap<>(); //Обьявили хранилище данных
    private static final Object OBJECT= new Object(); //так мы создали пустое место в мапе,
    // чтоб не выделять каждый раз память на новый value
    public boolean add (int element){// Метод, который добавляет елемент в мноество, если его еще нет (уникальные значения)
        return myHashMap.put(element, OBJECT )==null;
    }
    public boolean del (int element){// Метод, который удаляет елемент в мноестве
        return myHashMap.remove(element)==OBJECT;
    }
    public boolean isEmpty (){// Метод, который вернет true если он пустой, false если есть что-то
        return myHashMap.isEmpty();
    }
    public boolean contains (int element){// Метод, который вернет true если есть такой, false если нет
        return myHashMap.containsKey(element);
    }
    public int get (int index){// Метод, который вернет значение по индексу
        Object[] a=myHashMap.keySet().toArray();
        return (int) a[index];
    }
    public Iterator <Integer> iterator(){// Метод, который вернет true если есть такой, false если нет
        return myHashMap.keySet().iterator();
    }

}