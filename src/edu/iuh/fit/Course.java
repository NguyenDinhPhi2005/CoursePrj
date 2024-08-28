package edu.iuh.fit;

/**
 * @description: This class represents a bank with many bank accounts
 * @author: Phi, Nguyen Dinh
 * @version: 1.0
 * @created: 8/24/2024 23:15 PM
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    /**
     * Default constructor for Course. Initializes a course with default values.
     */
    public Course() {
        this.id = "";
        this.title = "";
        this.credit = 0;
        this.department = "";
    }

    /**
     * Parameterized constructor for Course. Initializes a course with specified values.
     * @param id the ID of the course
     * @param title the title of the course
     * @param credit the number of credits for the course
     * @param department the department responsible for the course
     */
    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    /**
     * Gets the title of the course.
     * @return the title of the course
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the number of credits for the course.
     * @return the number of credits
     */
    public int getCredit() {
        return this.credit;
    }

    /**
     * Gets the department responsible for the course.
     * @return the department name
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Gets the ID of the course.
     * @return the ID of the course
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the ID of the course. The ID must have at least 3 characters and contain only letters or digits.
     * @param id the new ID of the course
     */
    public void setId(String id) {
        if (id == null || id.length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    /**
     * Sets the title of the course. The title must not be empty.
     * @param title the new title of the course
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    /**
     * Sets the number of credits for the course. The number of credits must be non-negative.
     * @param credit the new number of credits
     */
    public void setCredit(int credit) {
        if (credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    /**
     * Sets the department responsible for the course.
     * @param department the new department name
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns a string representation of the course with a formatted output.
     * @return a string representation of the course
     */
    @Override
    public String toString() {
        return String.format("%-10s %-30s %5d  %-15s", id, title, credit, department);
    }
}