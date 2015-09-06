package softuni.methods.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.util.Map;

public class P14_ExamScore {

	private static Student student = new Student();
	private static List<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		String line = "";
		while (true) {
			
			line = scanner.nextLine();
			
			
			if (count <= 2) {
				count++;
				continue;
				
			} else if (count > 2) {
				
				if (line.charAt(0) == '-') {
					break;
				}
				
				List<String> input = getStudentInfo(line);
				
				String name = String.format("%s %s", input.get(0), input.get(1));
				int examScore = Integer.parseInt(input.get(2));
				double grade = Double.parseDouble(input.get(3));
				
				student = new Student(name, examScore, grade);
				
				students.add(student);
				count++;			
			}
		}
		
		Map<Integer, List<String>> namesByScore = groupStudentsByExamScore();

		Map<Integer, Double> averageGradeByExamScoreGroup = getAverageGradeByStudentGroup();
		
		Map<Integer, List<String>> sortedMap = new TreeMap<Integer, List<String>>(namesByScore);
		
		print(averageGradeByExamScoreGroup, sortedMap);
	}

	private static void print(Map<Integer, Double> averageGradeByExamScoreGroup, Map<Integer, List<String>> sortedMap) {
		for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
	    	
	    	int scoreValue = entry.getKey();
	    	List<String> studentGroup = entry.getValue();
	    	Collections.sort(studentGroup);
	    	Double averageGrade = averageGradeByExamScoreGroup.get(scoreValue);
	    	
	    	String studentsString = String.join(", ", studentGroup);
	    	String format = "%d -> [%s]; avg=%.2f";
	    	String output = String.format(format, scoreValue, studentsString, averageGrade);
	    	  
			System.out.println(output);
		}
	}

	private static Map<Integer, Double> getAverageGradeByStudentGroup() {
		Map<Integer, Double> averageGradeByExamScoreGroup = 
				students
				    .stream()
				    .collect(
				        Collectors.groupingBy(
				            Student::getExamScore,                      
				            Collectors.averagingDouble(Student::getGrade)));
		return averageGradeByExamScoreGroup;
	}

	private static Map<Integer, List<String>> groupStudentsByExamScore() {
		Map<Integer, List<String>> namesByScore =
			    students
				   .stream()
				   .collect(
						Collectors.groupingBy(
						    Student::getExamScore,
						    Collectors.mapping(
						        Student::getName,
						        Collectors.toList())));
		return namesByScore;
	}
	
	private static List<String> getStudentInfo(String line) {
		String pattern = "([A-Za-z0-9\\.]+)";
	      Pattern regex = Pattern.compile(pattern);
	      Matcher matcher = regex.matcher(line);
	      
	      List<String> input = new ArrayList<String>();
	      while(matcher.find()) {
	    	  input.add(matcher.group(1));
    	  }
	      
	      return input;
	}
	
	private static class Student {
		
		private String name;
		private int examScore;
		private double grade;
		
		private Student(String name, int examScore, double grade) {
			this.name = name;
			this.examScore = examScore;
			this.grade = grade;
		}
		
		private Student() {
			this("", 0, 0);
		}
		
		private String getName() {
			return name;
		}
		
		private void setName(String name) {
			this.name = name;
		}
		
		private int getExamScore() {
			return examScore;
		}
		
		private void setExamScore(int examScore) {
			this.examScore = examScore;
		}
		
		private double getGrade() {
			return grade;
		}
		
		private void setGrade(double grade) {
			this.grade = grade;
		}
	}	
}