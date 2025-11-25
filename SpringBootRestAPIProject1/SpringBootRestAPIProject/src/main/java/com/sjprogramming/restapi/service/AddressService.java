package com.sjprogramming.restapi.service;

//package com.sjprogramming.restapi.service;

import com.sjprogramming.restapi.entity.Address;
import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.repository.AddressRepository;
import com.sjprogramming.restapi.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(int rollNo) {
        return addressRepository.findById(rollNo);
    }

    public Address addAddress(int rollNo, Address address) {

        Optional<Student> student = studentRepository.findById(rollNo);

        if (student.isEmpty()) {
            throw new RuntimeException("Student not found. Cannot add address.");
        }

        address.setStudent(student.get());
        address.setRollNo(rollNo);

        return addressRepository.save(address);
    }

    public Address updateAddress(int rollNo, Address address) {

        if (!addressRepository.existsById(rollNo)) {
            return null;
        }

        address.setRollNo(rollNo);
        address.setStudent(studentRepository.findById(rollNo).orElse(null));

        return addressRepository.save(address);
    }

    public boolean deleteAddress(int rollNo) {
        if (!addressRepository.existsById(rollNo)) {
            return false;
        }
        addressRepository.deleteById(rollNo);
        return true;
    }
}