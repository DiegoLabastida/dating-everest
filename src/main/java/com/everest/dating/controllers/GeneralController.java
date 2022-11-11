package com.everest.dating.controllers;

import com.everest.dating.models.entity.Contract;
import com.everest.dating.models.entity.Job;
import com.everest.dating.models.entity.Profile;
import com.everest.dating.models.entity.User;
import com.everest.dating.services.general.ContractServiceImpl;
import com.everest.dating.services.general.JobServiceImpl;
import com.everest.dating.services.general.ProfileServiceImpl;
import com.everest.dating.services.general.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/basic")
public class GeneralController {

    private final UserServiceImpl userService;
    private final ProfileServiceImpl profileService;
    private final JobServiceImpl jobService;
    private final ContractServiceImpl contractService;

    public GeneralController(UserServiceImpl userService, ProfileServiceImpl profileService, JobServiceImpl jobService, ContractServiceImpl contractService) {
        this.userService = userService;
        this.profileService = profileService;
        this.jobService = jobService;
        this.contractService = contractService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        Iterable<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User userDB = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDB);
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUsers(@RequestBody Iterable<User> users){
        List<User> usersDB = new ArrayList<>();
        for (User user : users){
            usersDB.add(userService.save(user));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDB);
    }

    @GetMapping("/profiles")
    public ResponseEntity<?> getProfiles(){
        Iterable<Profile> profiles = profileService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(profiles);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable Long id){
        Optional<Profile> profile = profileService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(profile.get());
    }

    @PostMapping("/profile")
    @Transactional
    public ResponseEntity<?> saveProfile(@RequestBody Profile profile) {
        Profile profileDB = profileService.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(profileDB);
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs(){
        Iterable<Job> jobs = jobService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<?> getJob(@PathVariable Long id){
        Optional<Job> job = jobService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(job.get());
    }

    @PostMapping("/job")
    public ResponseEntity<?> saveJob(@RequestBody Job job){
        Job jobDB = jobService.save(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobDB);
    }

    @GetMapping("/contracts")
    public ResponseEntity<?> getContracts(){
        Iterable<Contract> contracts = contractService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(contracts);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<?> getContract(@PathVariable Long id){
        Optional<Contract> contract = contractService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(contract.get());
    }

    @PostMapping("/contract")
    public ResponseEntity<?> saveContract(@RequestBody Contract contract){
        Contract contractDB = contractService.save(contract);
        return ResponseEntity.status(HttpStatus.CREATED).body(contractDB);
    }
}
