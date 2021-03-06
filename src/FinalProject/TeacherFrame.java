/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Handy
 */
public class TeacherFrame extends javax.swing.JFrame {
    public int id = 0;    /**
     * Creates new form TeacherFrame
     */
    
    public TeacherFrame(){
        new TeacherFrame(id);
    }
    
    public TeacherFrame(int id) {
        try {
            MainFrame.writeLog("Teacher frame has been opend");
            initComponents();
            this.setLocationRelativeTo(null);
            this.id = id;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");            
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT `Course name` FROM"
                    + " `exams_info`,teatcher WHERE"
                    + " teatcher.id = "+this.id+" AND teatcher.name = exams_info.`Teatcher name`");
            ResultSet set = ps.executeQuery();
            set.last();
            int rows = set.getRow();
            set.beforeFirst();
            String[] courses = new String[rows];
            for (int i = 0; i < courses.length; i++) {
                set.next();
                courses[i] = set.getString("Course name");                               
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(courses);
            coursesList.setModel(model);
            
            ps = con.prepareStatement("SELECT exam.id, course.name FROM course, exam, offer WHERE"
                    + " exam.offer_id = offer.id AND offer.Teacher_id = "+this.id+" AND course.id = offer.cid ");
            set = ps.executeQuery();
            set.last();
            rows = set.getRow();
            set.beforeFirst();
            courses = new String[rows];
            
            for (int i = 0; i < courses.length; i++) {
                set.next();
                courses[i] = String.valueOf(set.getInt("id")) + " : " + set.getString("name");                               
            }
            model = new DefaultComboBoxModel(courses);
            examsList.setModel(model);
            examsListDelete.setModel(model);
            con.close();
            ActionEvent event = new ActionEvent(viewTable, 0, "");
            buttonViewActionPerformed(event);
            MainFrame.writeLog("All courses and exams for teacher id = "+id+" has been retrived.");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        coursesList = new javax.swing.JComboBox<>();
        addRoom = new javax.swing.JTextField();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        addTime = new javax.swing.JSpinner(sm);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        addDate = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        addId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        updRoom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        examsList = new javax.swing.JComboBox<>();
        buttonUpd = new javax.swing.JButton();
        updTime = new javax.swing.JSpinner(sm);
        pattern = "yyyy-MM-dd";
        simpleDateFormat = new SimpleDateFormat(pattern);
        updDate = new datechooser.beans.DateChooserCombo();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        examsListDelete = new javax.swing.JComboBox<>();
        buttonDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Course :");

        jLabel2.setText("Room :");

        jLabel3.setText("Date :");

        jLabel4.setText("Time :");

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(addTime, "HH:mm");
        addTime.setEditor(de);

        addDate.setDateFormat(simpleDateFormat);

        jLabel5.setText("Id :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coursesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(addRoom, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addTime, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(addId, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(buttonAdd)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(coursesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAdd)
                .addGap(33, 33, 33))
        );

        Dimension size = addDate.getCalendarPreferredSize();
        size.width += 90;
        addDate.setCalendarPreferredSize(size);

        jTabbedPane1.addTab("Add exam", jPanel1);

        jLabel52.setText("Time :");

        jLabel6.setText("Date :");

        jLabel7.setText("Room :");

        jLabel8.setText("Exam :");

        examsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonUpd.setText("Update");
        buttonUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdActionPerformed(evt);
            }
        });

        updTime.setModel(addTime.getModel());

        updDate.setDateFormat(simpleDateFormat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel52))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(examsList, 0, 286, Short.MAX_VALUE)
                            .addComponent(updTime, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(updDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(buttonUpd)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(examsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(updDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(updTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(buttonUpd)
                .addGap(48, 48, 48))
        );

        de = new JSpinner.DateEditor(updTime, "HH:mm");
        updTime.setEditor(de);
        size = updDate.getCalendarPreferredSize();
        size.width += 90;
        updDate.setCalendarPreferredSize(size);

        jTabbedPane1.addTab("Update exam", jPanel2);

        jLabel9.setText("Exam :");

        examsListDelete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(buttonDelete)
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel9)
                    .addGap(18, 18, 18)
                    .addComponent(examsListDelete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(19, 19, 19)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(buttonDelete)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(examsListDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(183, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Delete exam", jPanel3);

        buttonView.setText("View");
        buttonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActionPerformed(evt);
            }
        });

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(viewTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttonView)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonView)
                .addContainerGap())
        );

        jTabbedPane1.addTab("View exam", jPanel4);

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBack)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(buttonBack)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
         TeacherLogin t = new TeacherLogin();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            if(addRoom.getText().isEmpty() || addId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the fields", "Error!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(!addRoom.getText().matches("[A-Z a-z][0-9]{3}")){
                JOptionPane.showMessageDialog(null, "Enter right room nubmer!!", "Error!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String exam = (String) coursesList.getSelectedItem();
            int eid = Integer.parseInt(addId.getText());
            String room = addRoom.getText();
            
            String date = addDate.getText();
            String time =  addTime.getValue().toString();
            int index = time.indexOf(':');
            time = time.substring(index -2, index +3);            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
             PreparedStatement ps = con.prepareStatement("SELECT offer_id FROM exam,offer WHERE offer.Teacher_id = "+id+" AND " +
                "offer.id = exam.offer_id LIMIT 1");            
             ResultSet set = ps.executeQuery();
            set.next();
            int ofId = set.getInt("offer_id");            
            ps = con.prepareStatement("INSERT INTO `exam`(`id`, `offer_id`, `room`, `date`, `time`) VALUES(?,?,?,?,?)");
            ps.setInt(1, eid);
            ps.setInt(2, ofId);
            ps.setString(3, room);
            ps.setString(4, date);
            ps.setString(5, time);            
            ps.executeUpdate();            
            addId.setText("");
            addRoom.setText("");                        
             ps = con.prepareStatement("SELECT exam.id, course.name FROM course, exam, offer WHERE"
                    + " exam.offer_id = offer.id AND offer.Teacher_id = "+this.id+" AND course.id = offer.cid ");
            set = ps.executeQuery();
            set.last();
            int rows = set.getRow();
            set.beforeFirst();
            Object[] courses = new String[rows];            
            for (int i = 0; i < courses.length; i++) {
                set.next();
                courses[i] = String.valueOf(set.getInt("id")) + " : " + set.getString("name");                               
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(courses);
            examsList.setModel(model);
            examsListDelete.setModel(model);            
            con.close();
            ActionEvent event = new ActionEvent(viewTable, 0, "");
            buttonViewActionPerformed(event);            
            JOptionPane.showMessageDialog(null,"Added succesfully","Done",JOptionPane.INFORMATION_MESSAGE);
            MainFrame.writeLog("Exam has been added with id = "+eid+" offer_id = "+ ofId + " room = "+room+" date = "+date+" time = " + time);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Don't duplicate the id", "Error!!",JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Enter the right datatype!!", "Error!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            String exam = examsListDelete.getSelectedItem().toString();
            int examId = Integer.parseInt(exam.substring(0,exam.indexOf(':')-1).trim());
            int answer = JOptionPane.showConfirmDialog(null,"Are you sure?","Done",JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION){
            PreparedStatement ps = con.prepareStatement("DELETE FROM `exam` WHERE id = "+ examId);
            ps.executeUpdate();
            
             ps = con.prepareStatement("SELECT exam.id, course.name FROM course, exam, offer WHERE"
                    + " exam.offer_id = offer.id AND offer.Teacher_id = "+this.id+" AND course.id = offer.cid ");
            ResultSet set = ps.executeQuery();
            set.last();
            int rows = set.getRow();
            set.beforeFirst();
            Object[] courses = new String[rows];
            
            for (int i = 0; i < courses.length; i++) {
                set.next();
                courses[i] = String.valueOf(set.getInt("id")) + " : " + set.getString("name");                               
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(courses);
            examsList.setModel(model);
            examsListDelete.setModel(model);
            JOptionPane.showMessageDialog(null,"Deleted succesfully","Done",JOptionPane.INFORMATION_MESSAGE);
            con.close();
            ActionEvent event = new ActionEvent(viewTable, 0, "");
            buttonViewActionPerformed(event);
            MainFrame.writeLog("Exam with id = "+examId+"has been deleted.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdActionPerformed

        try {
            
            if(updRoom.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the fields", "Error!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(!updRoom.getText().matches("[A-Z a-z][0-9]{3}")){
                JOptionPane.showMessageDialog(null, "Enter right room nubmer!!", "Error!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE `exam` SET room = ?,date =?,time = ? WHERE id = ?");            
            String exam = examsList.getSelectedItem().toString();
            int examId = Integer.parseInt(exam.substring(0,exam.indexOf(':')-1).trim());
            String room = updRoom.getText();            
            String date = updDate.getText();
            String time =  updTime.getValue().toString();
            int index = time.indexOf(':');
            time = time.substring(index -2, index +3);
            ps.setString(1, room);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setInt(4, examId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Updated succesfully","Done",JOptionPane.INFORMATION_MESSAGE);
            con.close();
            ActionEvent event = new ActionEvent(viewTable, 0, "");
            buttonViewActionPerformed(event);
            MainFrame.writeLog("Exam with id = "+examId+" update to "+ " room = "+room+" date = "+date+" time = " + time);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonUpdActionPerformed

    private void buttonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewActionPerformed
        try {
           Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exams_info WHERE `Teatcher name` IN (SELECT name FROM teatcher WHERE id = ?)");            
            
            ps.setInt(1, id);
            
            ResultSet set = ps.executeQuery();
            
            set.last();            
            int rows = set.getRow();
            set.beforeFirst();
            Object[][] data = new String[rows][5];
            Object[] cols = new Object[5];           
            cols[0] = "Teatcher name";
            cols[1] = "Course name";
            cols[2] = "Room";
            cols[3] = "Date";
            cols[4] = "Time";   
            for (int i = 0; i < data.length; i++) {
                set.next();
                data[i][0] = set.getString("Teatcher name");
                data[i][1] = set.getString("Course name");
                data[i][2] = set.getString("room");
                data[i][3] = set.getString("date");
                data[i][4] = set.getString("time");
            }
            DefaultTableModel model = new DefaultTableModel(data, cols);
            viewTable.setModel(model);
            MainFrame.writeLog("All exams for teacher with id = "+ id + "has been retrived");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonViewActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo addDate;
    private javax.swing.JTextField addId;
    private javax.swing.JTextField addRoom;
    private javax.swing.JSpinner addTime;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpd;
    private javax.swing.JButton buttonView;
    private javax.swing.JComboBox<String> coursesList;
    private javax.swing.JComboBox<String> examsList;
    private javax.swing.JComboBox<String> examsListDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private datechooser.beans.DateChooserCombo updDate;
    private javax.swing.JTextField updRoom;
    private javax.swing.JSpinner updTime;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}