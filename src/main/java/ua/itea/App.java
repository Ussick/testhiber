package ua.itea;

import ua.itea.component.ProductEntityManager;
import ua.itea.component.ProductMapper;
import ua.itea.component.UserEntityManager;
import ua.itea.component.UserMapper;
import ua.itea.model.UserEntity;
import ua.itea.service.ProductService;
import ua.itea.service.UserService;


public class App {
    public static void main( String[] args ) {
//        UserService userService = new UserService(new UserEntityManager(), new UserMapper());
//        System.out.println(userService.getProductById(1));
//        ProductService productService = new ProductService(new ProductEntityManager(), new ProductMapper());
//        System.out.println(productService.getProductsByCategory(2));
//        System.out.println(productService.getProductById(9));
        UserService userService = new UserService(new UserEntityManager(), new UserMapper());
//        System.out.println(userService.getUserById(1));
//        UserEntity user=new UserEntity();
//                user.setLogin("qwer@wert.com").setName("Bill").setPassword("1234567").setGender("M")
//                .setRegion("How knows")
//                .setComment("Bugaga");
//        System.out.println(userService.addUser(user));
        System.out.println(userService.checkLogin("qwer@wert.com", "1234567"));
    }
}
