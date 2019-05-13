package com.example.springbootjpa;

import com.example.springbootjpa.dao.UsersCrudRepository;
import com.example.springbootjpa.dao.UsersRepository;
import com.example.springbootjpa.dao.UsersRepositoryByName;
import com.example.springbootjpa.dao.UsersRepositoryQueryAnnotation;
import com.example.springbootjpa.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Size;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersRepositoryByName usersRepositoryByName;
    @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
    @Autowired
    private UsersCrudRepository usersCrudRepository;

    @Test
    public void addTest() {
        Users users = new Users();
        users.setId(3);
        users.setName("tracy");
        users.setAge(23);
        users.setAddress("Shanghai");
        this.usersRepository.save(users);
    }

    @Test
    public void find(){
//        List<Users> usersList = this.usersRepositoryByName.findByName("tracy");
//        for (Users user:usersList) {
//            System.out.println(user);
//        }
//        List<Users> usersList1 = this.usersRepositoryByName.findByNameAndAge("william",25);
//        for (Users user:usersList1) {
//            System.out.println(user);
//        }

        List<Users> usersList2 = this.usersRepositoryByName.findByNameLike("wil%");
        for (Users user:usersList2) {
           System.out.println(user);
    }

}
        @Test
        public void findByHQL(){
        List<Users> userList3 = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("william");
        System.out.println(userList3);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateNameById(){
        this.usersRepositoryQueryAnnotation.updateNameById("william",1);
    }

    @Test
    public void testCrudRepositorySave(){
        Users user1 = new Users();
        user1.setAddress("beijing");
        user1.setAge(35);
        user1.setName("newton");
        this.usersCrudRepository.save(user1);
    }

    @Test
    public void testCrudRepositoryFindAll(){
        List<Users> usersList4 =(List<Users>) this.usersCrudRepository.findAll();
        for (Users users:usersList4){
            System.out.println(users);
        }
    }
}
