/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import controller.CourseCreationController;
import model.Course;

/**
 *
 * @author chizhang
 */
public class CreateCoursePage extends javax.swing.JFrame {

	/**
	 * controller field
	 */
	private CourseCreationController courseCreationController = new CourseCreationController();
	
	//init upload student as false
	private boolean hasUploadStudent = false;
	//init select a grading template as false
	private boolean hasSelectGradingTemplate = false;
	// track selected course position for grading template
	private int selectedCoursePosition;
    /**
     * Creates new form createCourse
     */
    public CreateCoursePage() {
        initComponents();
    }
    
    
    /**
     * get the course name text field 
     * @return
     */
    public String getCourseNameText() {
    	return this.courseNameTextField1.getText();
    }
    
    public String getCourseSemesterText() {
    	return this.semesterTextField.getText();
    }
    /**
     * get all course name with its semester
     * @return
     */
    private ArrayList<String> getAllCoursesName() {
    	ArrayList<Course> allCourses = this.courseCreationController.getAllCourses();
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
    	ArrayList<Course> allCourses = this.courseCreationController.getAllCourses();
    	ArrayList<Integer> allCoursesId = new ArrayList<Integer>();
    	for(Course course: allCourses) {
    		allCoursesId.add(course.getCourseId());
    	}
    	return allCoursesId;
    }
    
    /**
     * Action Listener classes
     */
    private class ReadCourseNameListenser implements ActionListener {
    	protected CreateCoursePage createCoursePage;
    	/**
    	 * constructor
    	 * @param createCoursePage
    	 */
    	public ReadCourseNameListenser(CreateCoursePage createCoursePage) {
    		this.createCoursePage = createCoursePage;
    		
    		
    	}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
    	
    }
    
    private class ReadCourseSemesterListenser implements ActionListener {
    	protected CreateCoursePage createCoursePage;
    	/**
    	 * constructor
    	 * @param createCoursePage
    	 */
    	public ReadCourseSemesterListenser(CreateCoursePage createCoursePage) {
    		this.createCoursePage = createCoursePage;
    		
    		
    	}
		@Override
		public void actionPerformed(ActionEvent e) {	
		}
    	
    }
    private class ReadSelectTemplateComboBox implements ActionListener {
    	protected CreateCoursePage createCoursePage;
    	/**
    	 * constructor
    	 * @param createCoursePage
    	 */
    	public ReadSelectTemplateComboBox(CreateCoursePage createCoursePage) {
    		this.createCoursePage = createCoursePage;
    		
    		
    	}
		@Override
		public void actionPerformed(ActionEvent e) {
			//if user select a item in the combobox, set hasSelectGradingTemplate = true
			this.createCoursePage.hasSelectGradingTemplate = true;
			
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

        popupMenu1 = new java.awt.PopupMenu();
        headerPanel = new javax.swing.JPanel();
        createCourseLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        courseNameLabel = new javax.swing.JLabel();
        saveBt = new javax.swing.JButton();
        cancelBt = new javax.swing.JButton();
        selectTemplateComboBox = new javax.swing.JComboBox<>();
        semesterTextField = new javax.swing.JTextField();
        semesterLabel = new javax.swing.JLabel();
        courseNameTextField1 = new javax.swing.JTextField();
        initTemplateLabel = new javax.swing.JLabel();
        attachStudentBt = new javax.swing.JButton();
        attachStudentTextField = new javax.swing.JTextField();
        initTemplateLabel1 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");
        popupMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenu1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(25, 118, 210));
        headerPanel.setPreferredSize(new java.awt.Dimension(254, 72));

        createCourseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        createCourseLabel.setForeground(new java.awt.Color(255, 255, 255));
        createCourseLabel.setText("Create Course");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(createCourseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(523, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(createCourseLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 252, 252));
        mainPanel.setAlignmentX(0.0F);

        courseNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        courseNameLabel.setText("Course Name");

        saveBt.setBackground(new java.awt.Color(255, 255, 255));
        saveBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        saveBt.setForeground(new java.awt.Color(25, 118, 210));
        saveBt.setText("Save");
        saveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtActionPerformed(evt);
            }
        });

        cancelBt.setBackground(new java.awt.Color(255, 255, 255));
        cancelBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cancelBt.setForeground(new java.awt.Color(25, 118, 210));
        cancelBt.setText("Cancel");
        cancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtActionPerformed(evt);
            }
        });

        ArrayList<String> allCourseNames = this.getAllCoursesName();
        allCourseNames.add(0, "");
        String [] coursesArray = allCourseNames.toArray(new String[0]);
        selectTemplateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(coursesArray));
        selectTemplateComboBox.addActionListener(new ReadSelectTemplateComboBox(this));
        

        //Read semester info
        semesterTextField.setText("Spring 2019");
        semesterTextField.addActionListener(new ReadCourseSemesterListenser(this));

        semesterLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        semesterLabel.setText("Semester");

        // Read course name info
        courseNameTextField1.setText("");
        courseNameTextField1.addActionListener(new ReadCourseNameListenser(this));

        initTemplateLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        initTemplateLabel.setText("Initialize From Template (Optional)");

        attachStudentBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        attachStudentBt.setForeground(new java.awt.Color(25, 118, 210));
        attachStudentBt.setText("Attach");
        attachStudentBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachStudentBtActionPerformed(evt);
            }
        });

        attachStudentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachStudentTextFieldActionPerformed(evt);
            }
        });

        initTemplateLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        initTemplateLabel1.setText("Attach Student CSV file (Optional)");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(attachStudentTextField)
                        .addGap(18, 18, 18)
                        .addComponent(attachStudentBt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(courseNameTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(semesterTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semesterLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addComponent(cancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(saveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(courseNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initTemplateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectTemplateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(initTemplateLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(190, 190, 190))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(courseNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(semesterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(semesterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(initTemplateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectTemplateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(initTemplateLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachStudentBt)
                    .addComponent(attachStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtActionPerformed
        // save this new course, read all the new information
    	String csvFile = this.attachStudentTextField.getText();
		int selectedCourseIndex = this.selectTemplateComboBox.getSelectedIndex();
		int selectedCourseId = this.getAllCoursesId().get(selectedCourseIndex);
		boolean isValidCsvFile = false;
		// check for valid csv
		if(csvFile.length()>4) {
			isValidCsvFile = csvFile.substring(csvFile.length()-4).equals(".csv");
		}

		// check for valid course name and course semester
		if (this.getCourseNameText().equals("") || this.getCourseSemesterText().equals("")) {
			JOptionPane.showMessageDialog(this, "Course name and semester must be none empty!");
		} else if(this.hasUploadStudent && ! isValidCsvFile) {
			JOptionPane.showMessageDialog(this, "Please upload a valid CSV file!");
		}
		else {
			
    	if(this.hasSelectGradingTemplate && this.hasUploadStudent && selectedCourseIndex!= 0) {
    		if(! isValidCsvFile) {
    			JOptionPane.showMessageDialog(this, "Please upload a valid CSV file!");
    		}  else { 		
    			this.courseCreationController.createNewCourseFromTemplateWithListOfStudents(this.getCourseNameText(), this.getCourseSemesterText(), selectedCourseId, csvFile);	
    		}	
    	}
    	else if(this.hasSelectGradingTemplate && selectedCourseIndex!= 0) {
    		this.courseCreationController.createNewCourseFromTemplate(this.getCourseNameText(), this.getCourseSemesterText(), selectedCourseId);
    	} 
    	else if(this.hasUploadStudent) {
    		if(! isValidCsvFile) {
    			JOptionPane.showMessageDialog(this, "Please upload a valid CSV file!");
    		} else {
    		
    		this.courseCreationController.createNewCourseWithListOfStudents(this.getCourseNameText(), this.getCourseSemesterText(), csvFile);
    		
    		}
    	} 
    	else {
    		this.courseCreationController.createNewCourse(this.getCourseNameText(), this.getCourseSemesterText());
    	}
    	// jump back to the course selection page
    	CourseSelectionPage courseSelectionPage = new CourseSelectionPage();
        courseSelectionPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        courseSelectionPage.setLocationRelativeTo( null ); // set the previous window location
        courseSelectionPage.setVisible(true);
        dispose();

		}
    	
    	
        
    }//GEN-LAST:event_saveBtActionPerformed

    private void cancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtActionPerformed
        // jump back to the course selection page, without saving anything
    	// Wait for the DB connect
        CourseSelectionPage courseSelectionPage = new CourseSelectionPage();
        courseSelectionPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        courseSelectionPage.setLocationRelativeTo( null ); // set the previous window location
        courseSelectionPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelBtActionPerformed

    private void selectTemplateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTemplateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectTemplateComboBoxActionPerformed

    private void semesterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterTextFieldActionPerformed

    private void courseNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTextField1ActionPerformed

    private void attachStudentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachStudentTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attachStudentTextFieldActionPerformed

    private void attachStudentBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachStudentBtActionPerformed
        // add file choose when click the attach bt
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName  = file.getAbsolutePath();
        //TODO: handle cancel when upload
        this.attachStudentTextField.setText(fileName); 
        // set the upload student to true if click upload button
        this.hasUploadStudent = true;
        
        
    }//GEN-LAST:event_attachStudentBtActionPerformed

    private void popupMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateCoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateCoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateCoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateCoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCoursePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachStudentBt;
    private javax.swing.JTextField attachStudentTextField;
    private javax.swing.JButton cancelBt;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JTextField courseNameTextField1;
    private javax.swing.JLabel createCourseLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel initTemplateLabel;
    private javax.swing.JLabel initTemplateLabel1;
    private javax.swing.JPanel mainPanel;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JButton saveBt;
    private javax.swing.JComboBox<String> selectTemplateComboBox;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JTextField semesterTextField;
    // End of variables declaration//GEN-END:variables
}
