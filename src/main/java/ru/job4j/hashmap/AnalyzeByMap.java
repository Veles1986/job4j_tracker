package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double scoreOverall = 0D;
        double score;
        for (Pupil pupil : pupils) {
            score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            score /= pupil.subjects().size();
            scoreOverall += score;
        }
        scoreOverall /= pupils.size();
        return scoreOverall;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double score;
        List<Label> list = new LinkedList<>();
        for (Pupil pupil : pupils) {
            score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            score /= pupil.subjects().size();
            list.add(new Label(pupil.name(), score));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> map = new LinkedHashMap<>();
        BiFunction<Double, Double, Double> function = Double::sum;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), (double) subject.score(), function);
            }
        }
        List<Label> list = new LinkedList<>();
        for (String name : map.keySet()) {
            list.add(new Label(name, map.getOrDefault(name, 0D) / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestPupil = new Label(null, 0D);
        double score;
        for (Pupil pupil : pupils) {
            score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            if (score > bestPupil.score()) {
                bestPupil = new Label(pupil.name(), score);
            }
        }
        return bestPupil;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> map = new LinkedHashMap<>();
        BiFunction<Double, Double, Double> function = Double::sum;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), (double) subject.score(), function);
            }
        }
        Label bestSubject = new Label(null, 0D);
        for (String name : map.keySet()) {
            if (map.get(name) > bestSubject.score()) {
                bestSubject = new Label(name, map.get(name));
            }
        }
        return bestSubject;
    }
}
