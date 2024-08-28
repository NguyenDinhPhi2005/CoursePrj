package edu.iuh.fit;

import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: This class represents a bank with many bank accounts
 * @author: Phi, Nguyen Dinh
 * @version: 1.0
 * @created: 8/24/2024 23:09 PM
 */
public class CourseList {
    private static Course[] courses; // Array to store the courses
    public static int count = 0; // Number of courses currently in the list

    /**
     * Constructor to initialize the CourseList with a given size.
     * @param n the initial size of the course array. Must be greater than 0.
     * @throws IllegalArgumentException if the size is less than or equal to 0.
     */
    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0.");
        }
        courses = new Course[n];
    }

    /**
     * Adds a course to the list.
     * @param course the course to be added.
     * @return true if the course is added successfully, false otherwise.
     */
    public static boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }
        if (isExists(course)) {
            return false;
        }
        if (count < courses.length) {
            courses[count++] = course;
            return true;
        }
        return false;
    }

    /**
     * Returns the array of courses.
     * @return an array of courses.
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * Checks if a course already exists in the list by its ID.
     * @param course the course to check.
     * @return true if the course exists, false otherwise.
     */
    public static boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            Course temp = courses[i];
            if (temp != null && temp.getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a course by its ID.
     * @param id the ID of the course to find.
     * @return the course with the specified ID, or null if not found.
     */
    public Course findCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Finds courses by their title, performing a case-insensitive search.
     * @param title the title to search for.
     * @return an array of courses that match the title, or null if none are found.
     */
    public Course[] findCourseByTitle(String title) {
        Course[] tempResults = new Course[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                tempResults[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) {
            return null;
        }
        Course[] results = new Course[resultCount];
        System.arraycopy(tempResults, 0, results, 0, resultCount);
        return results;
    }

    /**
     * Finds courses by their department.
     * @param department the department to search for.
     * @return an array of courses that belong to the specified department, or null if none are found.
     */
    public Course[] findCoursesByDepartment(String department) {
        Course[] tempResults = new Course[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                tempResults[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) {
            return null;
        }
        Course[] results = new Course[resultCount];
        System.arraycopy(tempResults, 0, results, 0, resultCount);
        return results;
    }

    /**
     * Finds the index of a course by its ID.
     * @param id the ID of the course.
     * @return the index of the course in the list, or -1 if not found.
     */
    public int findCourseIndexById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a course from the list by its ID.
     * @param id the ID of the course to remove.
     * @return true if the course was removed successfully, false otherwise.
     */
    public boolean removeCourse(String id) {
        int index = findCourseIndexById(id);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[--count] = null;
        return true;
    }

    /**
     * Sorts the courses by their title in ascending order.
     * @return an array of courses sorted by title.
     */
    public Course[] sortCoursesByTitle() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getTitle().compareToIgnoreCase(c2.getTitle());
            }
        });
        return sortedCourses;
    }

    /**
     * Finds the courses with the maximum number of credits.
     * @return an array of courses that have the maximum number of credits.
     */
    public Course[] findCourseWithMaxCredits() {
        if (count == 0) {
            return new Course[0];
        }
        int maxCredit = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }
        Course[] tempResult = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                tempResult[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(tempResult, resultCount);
    }

    /**
     * Finds the department with the most courses.
     * @return the name of the department with the highest number of courses.
     */
    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return null;
        }
        HashMap<String, Integer> departmentCountMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCountMap.put(department, departmentCountMap.getOrDefault(department, 0) + 1);
        }
        String maxDepartment = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : departmentCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }
        return maxDepartment;
    }
}