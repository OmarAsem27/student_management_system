# Objects responsibilities

Application
- interact with user
- collect input
- request operations
- present results
- delegate operations

StudentManager
- create/register students
- manage student collection
- find students
- remove students
- list students
- ensure IDs are unique
- coordinate student-management operations

Student
- own its state
- maintain its own valid state
- change its name
- change its age
- change its grade
---

# First use case:

## Add Student

1. Application shows menu

2. User chooses "Add Student"

3. Application collects the student's information

4. Application asks StudentManager to add a student
   using that information

5. StudentManager creates a Student

6. Student establishes/validates its own state

7. StudentManager checks whether the Student
   can be added to the collection
   (e.g. ID uniqueness)

8. StudentManager adds the Student to its collection

9. StudentManager communicates the result

10. Application presents the result to the user

---

# second use case:

## Find Student flow

1. Application displays the menu.

2. User chooses "Find Student".

3. Application asks the user for the Student ID.

4. Application sends the ID to StudentManager.

5. StudentManager searches the collection it manages.

6. If the Student exists, StudentManager provides that Student
   as the result.

7. If the Student does not exist, StudentManager communicates
   that no Student was found.

8. Application presents the result to the user.

---

# third use case:

## List students

1. Application displays the menu.
2. User chooses "List Students".
3. Application asks StudentManager for the managed students.
4. StudentManager provides the students it manages.
5. Application displays them to the user.

---

# fourth use case:

## Update Student

1. Application displays menu.

2. User chooses Update Student.

3. Application asks for Student ID.

4. Application sends the ID to StudentManager.

5. StudentManager locates the Student.

6. If no Student exists:
   StudentManager communicates that no Student was found.

7. Application presents that result.

8. If Student exists:
   Application asks which field should be updated.

9. Application collects the new value.

10. StudentManager requests the Student to update itself.

11. Student performs the update.

12. StudentManager communicates success.

13. Application presents the result.

---

# fifth use case:

## Delete Student

1. Application displays the menu.

2. User chooses "Delete Student".

3. Application asks the user for the Student ID.

4. Application sends the ID to StudentManager.

5. StudentManager searches the managed student collection.

6. If the Student does not exist:
   StudentManager communicates that no Student was found.

7. Application presents that result to the user.

8. If the Student exists:
   StudentManager removes the Student from its collection.

9. StudentManager communicates success.

10. Application presents the result to the user.
