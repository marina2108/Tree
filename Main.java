package com.company;

import java.util.*;

class School {
    private String name;
    private int number;
    School(String n,int k) {
        this.name = n;
        this.number = k;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<School> hashSet = new HashSet<>();
        Set<School> treeSet = new TreeSet<>(new Comparator<School>() {
            @Override
            public int compare(School t1, School t2) {
                 return t2.getNumber() - t1.getNumber();
            }
        });
        while (true) {
            String full_string = scanner.nextLine();
            if (!full_string.isEmpty()) {
                String[] schools = full_string.split(" ");
                String school_name = schools[0];
                int school_number = Integer.parseInt(schools[1]);
                if (school_number % 2 == 0) {
                    hashSet.add(new School(school_name,school_number));
                } else {
                    treeSet.add(new School(school_name,school_number));
                }
            } else {
                break;
            }
        }

        Iterator<School> rule = treeSet.iterator();
        while(rule.hasNext()) {
            if(rule.next().getName().length() > 5) {
                rule.remove();
            }
        }
        Iterator<School> rulee = hashSet.iterator();
        while(rulee.hasNext()) {
            if(rulee.next().getName().length() > 5) {
                rulee.remove();
            }
        }
        for(School s: hashSet) {
            treeSet.add(new School(s.getName(), s.getNumber()));
        }
        for(School s: treeSet) {
            System.out.println("Number is " + s.getNumber() + " and name is " + s.getName());
        }
    }
}
