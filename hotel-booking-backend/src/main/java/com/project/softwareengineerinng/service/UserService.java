package com.project.softwareengineerinng.service;

import com.project.softwareengineerinng.model.User;
import com.project.softwareengineerinng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository  userRepository;

    public User getUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
public List<User> sortAscending(String string){
        return  userRepository.findAll(Sort.by(Sort.Direction.ASC, string));
}
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public void deleteAll(Iterable<? extends User> entities) {
        userRepository.deleteAll(entities);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }


}

