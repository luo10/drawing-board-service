// package
// com.yinrj.drawingboardserver.modules.user.infrastructure.db.repository;

// import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
// import
// com.yinrj.drawingboardserver.modules.user.domain.repository.UserRepository;
// import jakarta.annotation.Resource;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// class UserRepositoryImplTest {

// @Resource
// private UserRepository userRepository;

// @Test
// @Disabled
// void testInsert() {
// UserEntity user = new UserEntity();
// user.setUsername("1234");
// user.setStudentId("23444488");
// userRepository.insert(user);
// }

// @Test
// @Disabled
// void testSelect() {
// UserEntity user = userRepository.select("1234", "23444488");
// assertNotNull(user);
// }

// }