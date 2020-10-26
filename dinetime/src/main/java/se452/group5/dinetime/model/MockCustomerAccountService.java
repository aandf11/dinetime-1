// package se452.group5.dinetime.model;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.StringTokenizer;
// import java.util.UUID;
// import java.util.stream.Stream;

// import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
// import org.springframework.stereotype.Service;

// @Service
// @ConditionalOnProperty(name = "datasource", havingValue = "mock")
// public class MockCustomerAccountService implements IAccountServise{

//     private static List<CustomerAccount> STUDENTS = new ArrayList<CustomerAccount>();

//     static {
//         Stream.of("Sheena Wyre", "Dilly Caffery", "Marysa Alyonov", "Julie Venturoli", "SFrieda Liddiatt")
//                 .forEach(name -> {
//                     CustomerAccount student = new CustomerAccount();
//                     student.setName(name);
//                     StringTokenizer tokenizer = new StringTokenizer(name, " ");
//                     student.setId(123);
//                     student.setUserId("userId");
//                     student.setEmail(tokenizer.nextToken().toLowerCase() + "@mockup.com");
//                     STUDENTS.add(student);

//                 });
//     }

//     @Override
//     public List<CustomerAccount> findAll() {
//         return STUDENTS;
//     }

//     @Override
//     public CustomerAccount update(CustomerAccount student) {
      
//         if (student.getId()!= 123) {
//             student.setId(123);
//             student.setUserId("userId");
//             STUDENTS.add(student);
//         } else {
            
//             // CustomerAccount originalStudent = findById();
//             // STUDENTS.remove(originalStudent);
//             // STUDENTS.add(student);
//         }


//         return student;
//     }

//     @Override
//     public CustomerAccount findById(String studentId) {
//         // for (CustomerAccount student : STUDENTS) {
//         //     if (student.getId().toString().equals(studentId)) {
//         //         return student;
//         //     }
//         // }
//         return null;
//     }

//     public CustomerAccount findByStudentId(String studentId) {
//         // for (Student student : STUDENTS) {
//         //     if (student.getStudentId().equalsIgnoreCase(studentId)) {
//         //         return student;
//         //     }
//         // }
//         return null;
//     }

//     @Override
//     public void deleteById(String studentId) {
//         STUDENTS.remove(findById(studentId));
//     }
    
// }
