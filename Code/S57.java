/* This application is about students. Originally we had a
 * simple Student class:
 * class Student { String studentId; String name; Date dateOfBirth; }
 *
 * Later, in order to record what courses the student has
 * enrolled in, on which dates he enrolled and how he paid for them,
 * we modified the code as shown below.
 * Your task is to implement this requirement without modifying
 * the Student class.
 */

class StudentManagementSystem {
    Student students[];
    String[] allCourseCodes;
    Enrollments en;
}
class Student {
    String studentId;
    String name;
    Date dateOfBirth;
}
class Enrollment {
    String courseCode;
    Date enrollDate;
    Payment p;
}
class Enrollments {
    Map<Student, Enrollment[]> enrolls;
    void enroll(Enrollment en) {
        //add courseCode to courseCodes
        //add enrollDate to enrollDates
        //add payment to Payments
    }
    void unenroll(Student s, String courseCode) {
        ...
    }
}
