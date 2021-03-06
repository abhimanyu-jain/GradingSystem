package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import controller.CourseworkSummaryController;
import model.Course;
import model.GradableCategory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chizhang
 */
public class HomePage extends javax.swing.JFrame {

	// fields
	private int courseID;
	private Object[][] mainTableMatrix;
	private ArrayList<String> mainTableCols = new ArrayList<String>();
	private ArrayList<Integer> categoryIdList = new ArrayList<Integer>();
	// selected column (category)
	private int selectedColIndex;
	/**
	 * Controller field 
	 */
	private CourseworkSummaryController courseworkSummaryController;
	
    /**
     * Creates new form home Page
     */
    public HomePage() {
        initComponents();
    }
    
    /**
     * Create new form home page with a specific course id
     * TODO: link to the given course
     * @param courseID
     */
    public HomePage(int courseID) {
    	this.courseID = courseID;
    	this.mainTableCols.add("Student ID");
    	this.mainTableCols.add("Student Name");
    	this.courseworkSummaryController = new CourseworkSummaryController(this.courseID);
    	this.mainTableMatrix = this.courseworkSummaryController.getStudentDataIn2dArray(this.courseID);
    	//TODO: add table columns 
    	ArrayList<GradableCategory> categories = this.courseworkSummaryController.getAllCategories(this.courseID);
    	for(GradableCategory cat: categories) {
    		this.mainTableCols.add(cat.getName());
    		this.categoryIdList.add(cat.getId());
    	}
    	//add an extra column for raw score
    	this.mainTableCols.add("Raw Score");

    	initComponents();
    }
    
    public int getCourseID() {
    	return this.courseID;
    }
    
    
    private class mainTableMouseAdapter extends Object
    implements MouseListener, MouseWheelListener, MouseMotionListener {
    	private HomePage homepage;
    	/**
    	 * takes in a home page
    	 * @param homePage
    	 */
    	public mainTableMouseAdapter(HomePage homePage) {
    		this.homepage = homePage;
    	}
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JTable target = this.homepage.mainSummaryTable;
				int numCols = target.getColumnCount();
                int col_index = target.columnAtPoint(e.getPoint());
                // you can play more here to get that cell value and all
                String name = target.getColumnName(col_index);

                //clicked on the student info columns or on the last raw score column
                if(col_index <2) {
                	//TODO: jump to the student info page
                	StudentInformationPage studentInformationPage = new StudentInformationPage(this.homepage.courseID);
                	studentInformationPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                	studentInformationPage.setLocationRelativeTo( null ); // set the previous window location
                	studentInformationPage.setVisible(true);
                    dispose();
                } else if (col_index !=numCols-1){
                	//Open the coursework summary page
                    //TODO: input course id and category id 
                    int categoryId = this.homepage.categoryIdList.get(col_index-2);
                    CourseWorkSummaryPage courseWorkSummaryPage = new CourseWorkSummaryPage(this.homepage.courseID, categoryId, name);
                    courseWorkSummaryPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    courseWorkSummaryPage.setLocationRelativeTo( null ); // set the previous window location
                    courseWorkSummaryPage.setVisible(true);
                    dispose();
                } 
            }
		} // end mouse clicked 

		@Override
		public void mousePressed(MouseEvent e) {		
		}
		@Override
		public void mouseReleased(MouseEvent e) {			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
        titleLabel = new javax.swing.JLabel();
        couseNameLabel = new javax.swing.JLabel();
        semesterLabel = new javax.swing.JLabel();
        backToCourseSelectBt = new javax.swing.JButton();
        mainPanel2 = new javax.swing.JPanel();
        moreActionLabel = new javax.swing.JLabel();
        moreActionsPanel = new javax.swing.JPanel();
        studentInfoBt = new javax.swing.JButton();
        createCourseworkBt = new javax.swing.JButton();
        courseLogisticBt3 = new javax.swing.JButton();
        courseRubricBt4 = new javax.swing.JButton();
        addNoteBt = new javax.swing.JButton();
        exportCSVBt = new javax.swing.JButton();
        summaryLabel1 = new javax.swing.JLabel();
        mainTableScrollPane = new javax.swing.JScrollPane();
        mainSummaryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(770, 496));

        headerPanel.setBackground(new java.awt.Color(25, 118, 210));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Dashboard");

        /**
         * Done: get course name for this course
         */
        //this.courseworkSummaryController.getDashboardInfo(courseID);
        couseNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        couseNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        Course course = this.courseworkSummaryController.getCourse(this.courseID);
        couseNameLabel.setText(course.getCourseName());

        
        /**
         * Done: get course semester for this course
         */
        semesterLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        semesterLabel.setForeground(new java.awt.Color(255, 255, 255));
        semesterLabel.setText(course.getCourseSemester());

        backToCourseSelectBt.setBackground(new java.awt.Color(255, 255, 255));
        backToCourseSelectBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        backToCourseSelectBt.setForeground(new java.awt.Color(25, 118, 210));
        backToCourseSelectBt.setText("Back");
        backToCourseSelectBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToCourseSelectBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(couseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backToCourseSelectBt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backToCourseSelectBt)
                .addGap(18, 18, 18))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(semesterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(couseNameLabel))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel2.setBackground(new java.awt.Color(255, 252, 252));
        mainPanel2.setPreferredSize(new java.awt.Dimension(770, 496));

        moreActionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        moreActionLabel.setForeground(new java.awt.Color(25, 118, 210));
        moreActionLabel.setText("More Actions");

        studentInfoBt.setBackground(new java.awt.Color(255, 255, 255));
        studentInfoBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        studentInfoBt.setForeground(new java.awt.Color(25, 118, 210));
        studentInfoBt.setText("Student Info");
        studentInfoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoBtActionPerformed(evt);
            }
        });

        createCourseworkBt.setBackground(new java.awt.Color(255, 255, 255));
        createCourseworkBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        createCourseworkBt.setForeground(new java.awt.Color(25, 118, 210));
        createCourseworkBt.setText("Create Coursework");
        createCourseworkBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCourseworkBtActionPerformed(evt);
            }
        });

        courseLogisticBt3.setBackground(new java.awt.Color(255, 255, 255));
        courseLogisticBt3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        courseLogisticBt3.setForeground(new java.awt.Color(25, 118, 210));
        courseLogisticBt3.setText("Course Logistic");
        courseLogisticBt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseLogisticBt3ActionPerformed(evt);
            }
        });

        courseRubricBt4.setBackground(new java.awt.Color(255, 255, 255));
        courseRubricBt4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        courseRubricBt4.setForeground(new java.awt.Color(25, 118, 210));
        courseRubricBt4.setText("Course Rubric");
        courseRubricBt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRubricBt4ActionPerformed(evt);
            }
        });

        addNoteBt.setBackground(new java.awt.Color(255, 255, 255));
        addNoteBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addNoteBt.setForeground(new java.awt.Color(25, 118, 210));
        addNoteBt.setText("Add Note (Optional)");
        addNoteBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoteBtActionPerformed(evt);
            }
        });

        exportCSVBt.setBackground(new java.awt.Color(255, 255, 255));
        exportCSVBt.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        exportCSVBt.setForeground(new java.awt.Color(25, 118, 210));
        exportCSVBt.setText("Export CSV");
        exportCSVBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportCSVBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moreActionsPanelLayout = new javax.swing.GroupLayout(moreActionsPanel);
        moreActionsPanel.setLayout(moreActionsPanelLayout);
        moreActionsPanelLayout.setHorizontalGroup(
            moreActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moreActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(moreActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentInfoBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createCourseworkBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseLogisticBt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseRubricBt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addNoteBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportCSVBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        moreActionsPanelLayout.setVerticalGroup(
            moreActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moreActionsPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(studentInfoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createCourseworkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseLogisticBt3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseRubricBt4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNoteBt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportCSVBt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        summaryLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        summaryLabel1.setForeground(new java.awt.Color(25, 118, 210));
        summaryLabel1.setText("Course summay  ");

        mainTableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mainTableScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // read the table
        mainSummaryTable.setModel(new javax.swing.table.DefaultTableModel(this.mainTableMatrix,this.mainTableCols.toArray()
            
        ) {
        	public boolean isCellEditable(int row, int column) {
        	      return false;
        	   }
        });
        // set rows height
        mainSummaryTable.setRowHeight(35);
        // set column width
        TableColumnModel columnModel = mainSummaryTable.getColumnModel();
        int cols = mainSummaryTable.getColumnCount();
        
        mainSummaryTable.setColumnSelectionAllowed(true);
        mainSummaryTable.getTableHeader().setReorderingAllowed(false);
        mainTableScrollPane.setViewportView(mainSummaryTable);
        mainSummaryTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (mainSummaryTable.getColumnModel().getColumnCount() > 0) {
        	for(int i = 0; i<cols;i++) {
                mainSummaryTable.getColumnModel().getColumn(i).setResizable(true);

        	}
        }
        for(int i = 0;i<cols;i++){
            columnModel.getColumn(i).setPreferredWidth(140);
        }
        mainSummaryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);


        // add mouse listener for table
        mainSummaryTable.getTableHeader().addMouseListener(new mainTableMouseAdapter(this));
        //mainSummaryTable.addMouseListener(new mainTableMouseAdapter(this));
        javax.swing.GroupLayout mainPanel2Layout = new javax.swing.GroupLayout(mainPanel2);
        mainPanel2.setLayout(mainPanel2Layout);
        mainPanel2Layout.setHorizontalGroup(
            mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanel2Layout.createSequentialGroup()
                        .addComponent(summaryLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanel2Layout.createSequentialGroup()
                        .addComponent(mainTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                        .addGap(36, 36, 36)))
                .addGroup(mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moreActionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moreActionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        mainPanel2Layout.setVerticalGroup(
            mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moreActionLabel)
                    .addComponent(summaryLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moreActionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToCourseSelectBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToCourseSelectBtActionPerformed
    	// jump back to the course selection page
    	CourseSelectionPage courseSelectionPage = new CourseSelectionPage();
        courseSelectionPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        courseSelectionPage.setLocationRelativeTo( null ); // set the previous window location
        courseSelectionPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_backToCourseSelectBtActionPerformed

    private void exportCSVBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCSVBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportCSVBtActionPerformed

    private void addNoteBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoteBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNoteBtActionPerformed

    private void courseRubricBt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRubricBt4ActionPerformed
        // TODO jump to grading rubric page, takes in courseID
    	GradingRubricPage gradingRubricPage = new GradingRubricPage(this.courseID,this.semesterLabel.getText(), this.couseNameLabel.getText());
    	gradingRubricPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    	gradingRubricPage.setLocationRelativeTo( null ); // set the previous window location
    	gradingRubricPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_courseRubricBt4ActionPerformed

    private void courseLogisticBt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseLogisticBt3ActionPerformed
        // TODO jump to course logistic page, takes in courseID:
    	CourseLogisticPage courseLogisticPage = new CourseLogisticPage(this.courseID);
    	courseLogisticPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    	courseLogisticPage.setLocationRelativeTo( null ); // set the previous window location
    	courseLogisticPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_courseLogisticBt3ActionPerformed

    private void createCourseworkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCourseworkBtActionPerformed
        // TODO jump to createCoursework page, takes in courseID:
    	CreateCourseWorkPage createCourseWorkPage = new CreateCourseWorkPage(this.courseID, this.semesterLabel.getText(), this.couseNameLabel.getText());
    	createCourseWorkPage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    	createCourseWorkPage.setLocationRelativeTo( null ); // set the previous window location
    	createCourseWorkPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_createCourseworkBtActionPerformed

    private void studentInfoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoBtActionPerformed
    	StudentInformationPage studentInformationPage = new StudentInformationPage(this.courseID);
    	studentInformationPage.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    	studentInformationPage.setLocationRelativeTo( null ); // set the previous window location
    	studentInformationPage.setVisible(true);
        dispose();

    }//GEN-LAST:event_studentInfoBtActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	// VIEW the course ID: 4
                new HomePage(4).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNoteBt;
    private javax.swing.JButton backToCourseSelectBt;
    private javax.swing.JButton courseLogisticBt3;
    private javax.swing.JButton courseRubricBt4;
    private javax.swing.JLabel couseNameLabel;
    private javax.swing.JButton createCourseworkBt;
    private javax.swing.JButton exportCSVBt;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel2;
    private javax.swing.JTable mainSummaryTable;
    private javax.swing.JScrollPane mainTableScrollPane;
    private javax.swing.JLabel moreActionLabel;
    private javax.swing.JPanel moreActionsPanel;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JButton studentInfoBt;
    private javax.swing.JLabel summaryLabel1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
