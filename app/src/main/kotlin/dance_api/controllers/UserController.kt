package dance_api.controllers

import dance_api.repositories.UserRepository
import dance_api.models.UserModel

import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getUsers(): List<UserModel> {
        return userRepository.findAll()
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user: UserModel): UserModel {
        return userRepository.save(user)
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userRepository.deleteById(id)
    }

    @PutMapping("/user/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: UserModel): UserModel {
        val existingUser = userRepository.findById(id)
            .orElseThrow { NoSuchElementException("User with id $id not found") }

        val updatedUserEntity = existingUser.copy(
            username = updatedUser.username,
            email = updatedUser.email,
            password = updatedUser.password
        )

        return userRepository.save(updatedUserEntity)
    }
}
