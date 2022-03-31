package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("LADA",12)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Nissan",111)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Mitsubishi",1010)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Audi",7)));
      userService.add(new User("Radel", "Nigmatullin", "radelnigma@mail.ru", new Car("Nissan",1)));
      userService.add(new User("Ivan", "Glinka", "ivanglinkamail.ru", new Car("Mitsubishi",1010)));
      userService.add(new User("Aleksandr", "Suvorov", "suvorov.ru", new Car("Mitsubishi",101)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Auto = "+user.getCar());
         System.out.println();
      }


      List<User> usersCar = userService.getUserByCarModelAndSeries("Mitsubishi", 1010);

      System.out.println(usersCar);

      context.close();
   }
}
