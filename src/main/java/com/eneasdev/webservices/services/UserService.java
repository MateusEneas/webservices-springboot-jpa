package com.eneasdev.webservices.services;

import com.eneasdev.webservices.entities.User;
import com.eneasdev.webservices.repositories.UserRepository;
import com.eneasdev.webservices.services.exceptions.DatabaseException;
import com.eneasdev.webservices.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
       if (!userRepository.existsById(id)) {
           throw new ResourceNotFoundException(id);
       }
       try {
           userRepository.deleteById(id);
       }catch (DataIntegrityViolationException e) {
           throw new DatabaseException(e.getMessage());
       }

    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
