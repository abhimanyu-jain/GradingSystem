package model;

import java.util.ArrayList;

public class DatabaseTest {

	public static void main(String[] args) {
		
		Database.removeStudentFromCourse(1001, 4);
		Student s = new Student(1001, new Name("Jojo", "JJ", "Jojoson"), "JJJ@bu.edu", false);
		Database.addStudentToCourse(s, 4);
		
		Course c = new Course("Learning to write a letter", "Spring 1901");
		Database.addCourse(c);
		
		ArrayList<Course> courses = Database.getAllCourses();
		for (Course course : courses) {
		}
		
		ArrayList<GradableCategory> cats = Database.getCategoriesInCourse(2);
		for (GradableCategory cat : cats) {
		}
		
		ArrayList<GradableItem> gis = Database.getGradedItemsInCategory(15);
		for (GradableItem gi : gis) {
			Database.setDeleteGradedItem(gi.getId());
		}
		
		GradableItem newGi = new GradableItem("Talking to others", 20, 1, 1);
		newGi.setId(1000);
		
		//Database.addGradedItem(newGi, cats.get(1).getId());
		
		//Database.setDeleteGradedItem(1000);
		
	}

}
