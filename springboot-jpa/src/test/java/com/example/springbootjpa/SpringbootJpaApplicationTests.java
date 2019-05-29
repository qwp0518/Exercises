package com.example.springbootjpa;

import com.example.springbootjpa.dao.*;
import com.example.springbootjpa.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    @Autowired
    private UsersPagingAndSortingRepository usersPagingAndSortingRepository;
    @Autowired
    private UsersRepositorySpecExecutor usersRepositorySpecExecutor;

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

    @Test
    public void testPagingAndSortingRepository(){
        Order order = new Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        List<Users> usersList5 = (List<Users>)this.usersPagingAndSortingRepository.findAll(sort);
        for (Users users: usersList5){
            System.out.println(users);
        }
    }

    @Test
    public void testPagingAndSortingRepositoryPage(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");

        Pageable pageable = new PageRequest(0,2,sort);
        Page<Users> usersPage = this.usersPagingAndSortingRepository.findAll(pageable);
        System.out.println("总条数：" + usersPage.getTotalElements());
        System.out.println("总页数:" + usersPage.getTotalPages());
        List<Users> usersList6 = usersPage.getContent();
        for (Users users:usersList6) {
            System.out.println(users);
        }
    }

    @Test
    public void testSpecificationExecutor1(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("name"),"william");
                return predicate;

            }
        };
        List<Users> usersList7 = this.usersRepositorySpecExecutor.findAll(specification);
        for (Users users:usersList7) {
            System.out.println(users);
        }
    }

    @Test
    public void testSpecificationExecutor2(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"),"william"));
                list.add(criteriaBuilder.equal(root.get("age"),25));
                Predicate[] arr = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(arr));

            }
        };
        List<Users> usersList8 = this.usersRepositorySpecExecutor.findAll(specification);
        for (Users users:usersList8) {
            System.out.println(users);
        }
    }
}
