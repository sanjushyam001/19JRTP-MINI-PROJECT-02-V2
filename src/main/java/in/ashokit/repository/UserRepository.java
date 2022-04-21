package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);
}
