package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.CourseSelectionController;
import model.Course;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chizhang
 */
public class CourseSelectionPage extends javax.swing.JFrame {
	/**
	 * Controller fields
	 */
	private CourseSelectionController courseSelectionController;
	// track selected course position pass it to the main page 
	private int selectedCoursePosition;

    /**
     * Creates new form courseSelection
     */
    public CourseSelectionPage() {
        this.courseSelectionController = new CourseSelectionController();
        initComponents();
        // TODO: check whether this position index update dynamically
        this.selectedCoursePosition = this.selectCourseComboBox.getSelectedIndex();
    }
    
    
    /**
     * get all course name with its semester
     * @return
     */
    private ArrayList<String> getAllCoursesName() {
    	ArrayList<Course> allCourses = this.courseSelectionController.getAllCourses();
        ArrayList<String> allCoursesName = new ArrayList<String>();
        for(Course course: allCourses) {
        	allCoursesName.add(course.getCourseName() + " "+ course.getCourseSemester());
        }
        return allCoursesName;
    }
    
    /**
     * get all course IDs as an array of integers
     * @return
     */
    private ArrayList<Integer> getAllCoursesId() {
    	ArrayList<Course> allCourses = this.courseSelectionController.getAllCourses();
    	ArrayList<Integer> allCoursesId = new ArrayList<Integer>();
    	for(Course course: allCourses) {
    		allCoursesId.add(course.getCourseId());
    	}
    	return allCoursesId;
    }
    
    private class selectCourseComboBox implements ActionListener{
    	private CourseSelectionPage courseSelectionPage;
    	public selectCourseComboBox(CourseSelectionPage courseSelectionPage) {
    		this.courseSelectionPage = courseSelectionPage;
    		
    	}
    	public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectCourseComboBoxActionPerformed(evt);
	        // update selectedCoursePosition
	        this.courseSelectionPage.selectedCoursePosition = selectCourseComboBox.getSelectedIndex();
	        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        courseSelectionLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        selectCurrentCourseLabel = new javax.swing.JLabel();
        openDashboardBt = new javax.swing.JButton();
        createCourseBt = new javax.swing.JButton();
        selectCourseComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(25, 118, 210));
        headerPanel.setPreferredSize(new java.awt.Dimension(254, 72));

        courseSelectionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        courseSelectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        courseSelectionLabel.setText("Course Selection");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(courseSelectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(courseSelectionLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 252, 252));
        mainPanel.setAlignmentX(0.0F);

        selectCurrentCourseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        selectCurrentCourseLabel.setText("Select Current Course");

        openDashboardBt.setBackground(new java.awt.Color(255, 255, 255));
        openDashboardBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        openDashboardBt.setForeground(new java.awt.Color(25, 118, 210));
        openDashboardBt.setText("Open Dashboard");
        openDashboardBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDashboardBtActionPerformed(evt);
            }
        });

        createCourseBt.setBackground(new java.awt.Color(255, 255, 255));
        createCourseBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        createCourseBt.setForeground(new java.awt.Color(25, 118, 210));
        createCourseBt.setText("Create Course");
        createCourseBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCourseBtActionPerformed(evt);
            }
        });

        /*
         * present all courses from controller
         */
        ArrayList<String> allCoursesName = this.getAllCoursesName();
        String[] allCoursesNameArray = allCoursesName.toArray(new String[0]);
        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(allCoursesNameArray));
        selectCourseComboBox.addActionListener(new selectCourseComboBox(this));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addComponent(createCourseBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(openDashboardBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectCurrentCourseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCourseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(selectCurrentCourseLabel)
                .addGap(18, 18, 18)
                .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openDashboardBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createCourseBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 770, 542);
    }// </editor-fold>//GEN-END:initComponents

    private void openDashboardBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDashboardBtActionPerformed
        // TODO: jump into the main page, for the "selected course"
        // TODO: set HomePage takes in a course
    	ArrayList<Integer> allCoursesID = this.getAllCoursesId();
    	int selectedCourseID = allCoursesID.get(this.selectedCoursePosition);
        HomePage homePage = new HomePage(selectedCourseID);
        homePage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        homePage.setLocationRelativeTo( null ); // set the previous window location
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_openDashboardBtActionPerformed

    private void createCourseBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCourseBtActionPerformed
        // jump into createCourse page
        CreateCoursePage createCoursePage = new CreateCoursePage();
        createCoursePage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        createCoursePage.setLocationRelativeTo( null ); // set the previous window location
        createCoursePage.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_createCourseBtActionPerformed

    private void selectCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCourseComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseSelectionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseSelectionLabel;
    private javax.swing.JButton createCourseBt;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton openDashboardBt;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JLabel selectCurrentCourseLabel;
    // End of variables declaration//GEN-END:variables
}
