package controller;

public class CourseworkSummaryControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		CourseworkSummaryController c1 = new CourseworkSummaryController(1);
//		System.out.println(c1.getCourse(1).getCourseName());
//		System.out.println(c1.getCourse(1).getCourseSemester());
//		String[][] matrix = c1.getStudentDataIn2dArray(1);
//		System.out.println(matrix[0]);
//		String BU_Id = "U123";
//		String intermediate = BU_Id.substring(1);
//		int bu_id = Integer.parseInt(intermediate);
//		System.out.println(bu_id);
		
		CategorySummaryController s1 = new CategorySummaryController(4);
		String [][] mat = s1.getStudentDataIn2dArray(20);
		for(String[] v: mat) {
			for (String s: v) {
				System.out.println(s);
			}
		}
		
//		CourseworkController c1 = new CourseworkController();
//		ArrayList<GradableCategory> allCates = c1.getAllCourseworkCategories(1);
//		for(GradableCategory cate:allCates) {
//			System.out.println(cate.getName());
//		}
		

	}

}
