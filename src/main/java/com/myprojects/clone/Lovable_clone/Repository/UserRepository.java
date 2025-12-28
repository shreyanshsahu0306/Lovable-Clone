package com.myprojects.clone.Lovable_clone.Repository;

import com.myprojects.clone.Lovable_clone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
