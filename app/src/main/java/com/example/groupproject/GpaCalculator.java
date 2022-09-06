package com.example.groupproject;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GpaCalculator {
    List<String> pointList = new ArrayList<>();;

    public GpaCalculator() {
    }

    public double calculateGPA(double grade1, double grade2, double grade3, double grade4, double grade5) {
        double gpa = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;
        return gpa;
    }

    public Double[] calculate(List<Double[]> gradeAndWeights) {
        double total = 0;
        double totalWeight = 0;
        for (Double[] array: gradeAndWeights) {
            total += array[0] * (array[1]*0.01);
            totalWeight += array[1];
        }
        Double[] totalArray = {total, totalWeight};
        return totalArray;

    }

    public double getGPARating(double grade){
        double rating = 0.0;

        if (grade < 50) {
            rating = 0.0;
        } else if (grade >= 50 && grade <= 52) {
            rating = 0.7;
        } else if (grade >= 53 && grade <= 56) {
            rating = 1.0;
        } else if (grade >= 57 && grade <= 59) {
            rating =1.3;
        } else if (grade >= 60 && grade <= 62) {
            rating = 1.7;
        } else if (grade >= 63 && grade <= 66) {
            rating = 2.0;
        } else if (grade >= 67 && grade <= 69) {
            rating = 2.3;
        } else if (grade >= 70 && grade <= 72) {
            rating = 2.7;
        } else if (grade >= 73 && grade <= 76) {
            rating = 3.0;
        } else if (grade >= 77 && grade <= 79) {
            rating = 3.3;
        } else if (grade >= 80 && grade <= 84) {
            rating = 3.7;
        } else if (grade >= 85) {
            rating = 4.0;
        }

        return rating;
    }

    public double getPointList(List<String> grades) {
        Double gpa = 0.0;
        for (String grade: grades) {
            double point = getPoints(grade);
            Log.e("point",point+"");
            pointList.add(point + "");
        }

        Log.e("Point List", pointList.toString());
        getGPA(pointList);
        gpa = getGPA(pointList);
        pointList.clear();


        return gpa;

    }

    public double getGPA(List<String> points) {
        double total = 0;
        for(String element:points){
            try {
                int num = (int) Double.parseDouble(element);
                total += num;
            }
            catch (NumberFormatException nfe){
                System.out.println ("Element " + element + " in the array is not an integer");
            }
        }
        Log.e("total",total+"");
        Log.e("GPA",total/5+"");
        return total/5;
    }

    public int getPoints(String grade){
        int points = 0;
        if (grade.equals("A")) {
            points = 4;
        } else if (grade.equals("A-")) {
            points = 3;
        } else if (grade.equals("B+")) {
            points = 2;
        } else if (grade.equals("B")) {
            points = 2;
        } else if (grade.equals("B-")) {
            points = 1;
        } else if (grade.equals("C+")) {
            points = 1;
        } else if (grade.equals("C")) {
            points = 1;
        } else if (grade.equals("C-")) {
            points = 0;
        } else if (grade.equals("D+")) {
            points = 0;
        } else if (grade.equals("D")) {
            points = 0;
        } else if (grade.equals("D-")) {
            points = 0;
        } else if (grade.equals("F")) {
            points = 0;
        }
        return points;
    }


}


