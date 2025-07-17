package com.aurionpro.abstraction.model;

public class ScienceStudent extends Student {
    private int physics, chemistry, maths;

    public ScienceStudent(int rollNumber, String name, int physics, int chemistry, int maths) {
        super(rollNumber, name);
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
    }

    @Override
    public double calculatePerformance() {
        return (physics + chemistry + maths) / 3.0;
    }

    @Override
    public String calculateGrade() {
        double avg = calculatePerformance();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }
}
